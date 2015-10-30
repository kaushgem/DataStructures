/*
 * Stack implementation using LinkedList with Generic type
 *  
 */

package ds_1.stack;

import java.util.EmptyStackException;

/**
 *
 * @author kaush
 * @param <T>
 */
public class MyStackLinkedListGenericP<T> {
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
        if (isEmpty())
        	throw new EmptyStackException();
        T val = top.data;
        top = top.next;
        return val;
    }
    
    public T peek() {
        if (isEmpty())
        	throw new EmptyStackException();
        return top.data;
    }
    
    public boolean isEmpty() {
        return (top == null);
    }
    
    public static void main(String[] args) {
    	// Diamond Operator
        MyStackLinkedListGenericP<Integer> stack = new MyStackLinkedListGenericP<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
    

