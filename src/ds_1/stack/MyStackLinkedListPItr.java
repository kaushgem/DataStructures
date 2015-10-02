/*
 * Stack implementation using LinkedList with Generic type and Iterator
 *  
 */

package ds_1.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @author kaush
 * @param <T>
 */
public class MyStackLinkedListPItr<T> implements Iterable<T>{
    private Node top;
    
    private class Node {
        private T data;
        private Node next;
        public Node(T _data) {
            data = _data;
        }
    }
    
    public void push(T _data) {
        Node newN = new Node(_data);
        newN.next = top;
        top = newN;
    }
    
    public T pop() {
        if (top == null) throw new EmptyStackException();
        T val = top.data;
        top = top.next;
        return val;
    }
    
    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }
    
    public boolean isEmpty() {
        return (top == null);
    }
    
    @Override
    public Iterator<T> iterator() {
    	return new StackIterator();
    }
    
    private class StackIterator implements Iterator<T> {
    	Node current = top;
    	
    	@Override
    	public boolean hasNext() {
    		return current != null;
    	}
    	
    	@Override
    	public T next() {
    		T val = current.data;
    		current = current.next;
    		return val;
    	}
    }
    
    public static void main(String[] args) {
    	// Diamond Operator
    	MyStackLinkedListPItr<Integer> stack = new MyStackLinkedListPItr<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        for(int itr:stack)
        	System.out.println(itr);
        
        Iterator<Integer> itr = stack.iterator();
        while(itr.hasNext())
        	System.out.println(itr.next());
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
    

