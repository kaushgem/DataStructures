package ds_0.linkedlist;

public abstract class Linked_List_Abstract {
	
	static class Node{
		int data;
		Node next;

		Node(){}

		Node(int _data, Node _next){
			data = _data;
			next = _next;
		}

		public void setData(int _data){
			data = _data;
		}

		public int getData(){
			return data;
		}
		
		public void setNext(Node _next){
			next = _next;
		}

		public Node getNext(){
			return next;
		}
	}
	
	public abstract Object get(int _index);
	
	public abstract void add(int _data, int _index);
	public abstract void append(int _data);

	public abstract void remove(int _index);
	public abstract void removeAll(int _index);
	
	public abstract void print(Node _node);
	
	public abstract String toString();
	public abstract int size();
}
