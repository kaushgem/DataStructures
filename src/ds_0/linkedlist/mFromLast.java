package ds_0.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mFromLast {

	static class Node{
		int data;
		Node next;
		Node(){}
		Node(int _data, Node _next){
			data=_data;
			next=_next;
		}
	}

	// ---------------
	static int findM(Node head, int m){
		
		if(head == null || m <= 0)	return -1;
		int count = 1;

		Node prev = head;
		Node n = head;

		while(n != null){
			if(count++ > m)
				prev = prev.next;
			n = n.next;
		}
		return (count > m) ? prev.data : -1; 
	}
	// ---------------

	public static int find(Node head, int m) {
		
		if(head == null || m <= 0)	return -1;
		int count = 1;
		
		Node prev = head;
		Node n = head;
		while(n != null) {
			if(count++ > m)
				prev = prev.next;
			n = n.next;
		}
		return (count > m) ? prev.data : -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(buf.readLine());

		String str;
		if( (str = buf.readLine()) != null ){
			String s[] = str.split(" ");

			Node head = new Node(Integer.parseInt(s[0]),null);
			Node tail = head;

			for(int i=1 ; i<s.length ; i++){
				Node n = new Node(Integer.parseInt(s[i]),null);
				tail.next = n;
				tail = n;
			}

			int val = findM(head,m);
			if(val < 0)
				System.out.println("NIL");
			else
				System.out.println(val);
		}
	}
}