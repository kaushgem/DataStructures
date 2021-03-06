package ds_2.queue;

import java.util.NoSuchElementException;


public class MyQueue {

	private static class Node {
		private String data;
		private Node next;
		Node(String _data) {
			data = _data;
		}
	}

	private Node front, back;

	public void enqueue(String _data) {
		Node newN = new Node(_data);
		if(isEmpty()) {
			front = newN;
			back = newN;
		}
		else {
			back.next = newN;
			back = back.next;
		}
	}

	public String dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		String val = front.data;
		front = front.next;
		
		if(isEmpty())
			back = null;
		return val;
	}
	
	public String peek() {
		if(isEmpty())
			throw new NoSuchElementException();
		return front.data;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	}

}
