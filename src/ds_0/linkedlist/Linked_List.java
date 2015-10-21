package ds_0.linkedlist;

public class Linked_List {
	// ========================= Static Node ====================================
	static class Node{
		int data;
		Node next;
		Node(){}
		Node(int _data, Node _next){
			data = _data;
			next = _next;
		}
	}
	// ========================= Add ===========================================
	// Methods - add, addAtIndex, addAtData, delete, deleteAtIndex, deleteAtData, print, reverse, 
	// Using prev
	public static Node add(Node _head, int _data) {
		
		Node newN = new Node(_data, null);
		if(_head == null) return newN;
		
		Node prev = null;
		Node n = _head;
		while(n!=null){
			prev = n;
			n = n.next;
		}
		prev.next = newN;
		return _head;
	}
	
	// Without tracking prev
	public static Node add1(Node _head, int _data) {
		
		Node newN = new Node(_data, null);
		if(_head == null) return newN;

		Node n = _head;
		while(n.next != null) {
			n = n.next;
		}
		n.next = newN;
		return _head;
	}

	public static Node addAtIndex(Node _head, int _data, int _index){
		
		Node newN = new Node(_data, null);
		if(_head == null) return newN;
		if(_index == 0){
			newN.next = _head;
			return newN;
		}

		Node prev = null;
		Node n = _head;

		for(int i=0 ; i<_index ; i++){
			if(n == null) return _head;			//LL is shorter than given index
			prev = n;
			n = n.next;
		}
		prev.next = newN;
		newN.next = n;

		return _head;
	}

	public static Node addAtData(Node _head, int _data){

		Node newN = new Node(_data,null);
		if(_head == null) return _head;

		Node n = _head;
		while(n != null){
			if(n.data == _data){
				Node temp = n.next;
				n.next = newN;
				newN.next = temp;
			}
			n=n.next;
		}

		return _head;
	}

	// ========================= Delete ===========================================
	//delete, deleteAtIndex, deleteAtFirstData, deleteGivenOnlyNode
	
	/*
	public static Node delete(Node _head){	//Not yet implemented
		if(_head == null || _head.next == null) return null;

		Node prev_prev = null;
		Node prev = _head;
		Node n = _head.next;
		while(n != null){
			prev_prev = n;
			prev = n;
			n = n.next;
		}
		prev.data = 0;

		return _head;
	}
	*/

	public static Node deleteAtIndex(Node _head, int index){

		if(_head == null) return null;
		if(index == 0) return _head.next;

		Node prev = null;
		Node n = _head;
		for(int i=0 ; i<index ; i++){
			if(n == null) return _head;			//LL is shorter than given index
			prev = n;
			n = n.next;
		}
		if(n != null)							//Check if index is last + 1
			prev.next = n.next;

		return _head;
	}

	public static Node deleteAtFirstData(Node _head, int _data){

		if(_head == null) return null;
		if(_head.data == _data) return _head.next;

		Node prev = null;
		Node n = _head;
		while(n!=null){
			if(n.data == _data) break;
			prev = n;
			n = n.next;
		}
		if(n != null)
			prev.next = n.next;

		return _head;
	}
	
	public static void deleteGivenOnlyNode(Node _head, Node _node) {
		//_node = _node.next; ??
		_node.data = _node.next.data;
		_node.next = _node.next.next;
	}

	// ========================= Reverse ===========================================
	// Creating new copy
	public static Node reverse(Node _head){

		if(_head == null || _head.next == null) return _head;
		
		Node reverse_head = null;

		while(_head!=null){
			Node reverse = new Node(_head.data, reverse_head);
			reverse_head = reverse;
			_head = _head.next;
		}
		return reverse_head;
	}

	//Modify the existing Linked List
	public static Node reverse1(Node _head){
		
		if(_head == null || _head.next == null) return _head;
		
		Node reverse_head = null;

		while(_head!=null){
			Node next = _head.next;
			Node reverse = _head;
			reverse.next = reverse_head;
			reverse_head = reverse;
			_head = next;
		}
		return reverse_head;
	}

	// ========================= Get m'th node from Last =========================
	// Last element corresponds to m = 1
	static int findM(Node head, int m){

		if(head == null || m <= 0)	return -1;
		int count = 1;

		Node prev = head;
		Node n = head;

		while(n != null){
			if(count++ > m)				//don't move prev until there is a gap of m between prev and n.
				prev = prev.next;
			n = n.next;
		}
		return (count > m) ? prev.data : -1; 
	}
	
	// ========================= Print ===========================================
	public static void print(Node _head){
		while(_head != null){
			System.out.print(_head.data+" -> ");
			_head = _head.next;
		}
		System.out.println("NULL");
	}

	// ========================= Main for test ====================================
	public static void main(String args[]){
		Node n1 = new Node(10, new Node(20, new Node(30, null)));
		
		print(n1);
		
		int m = 2;
		System.out.println(m + "'th element from last :" + findM(n1, m) + "\n");

		print(add(n1,43));
		print(addAtIndex(n1, 111, 3));
		print(addAtData(n1, 10));
		print(n1=deleteAtIndex(n1, 3));
		print(n1=deleteAtFirstData(n1, 10));
		print(reverse(n1));
		print(reverse1(n1));
		
		System.out.println();
		
		n1 = new Node(1,new Node(2,new Node(3,null)));
		
		print(n1);
		deleteGivenOnlyNode(n1, n1.next);
		print(n1);
	}
}


