/*
 * Stack implementation using LinkedList
 *  
 */

package ds_1.stack;

import java.util.EmptyStackException;

/**
 *
 * @author kaush
 */
public class MyStackLinkedList {
    private Node top;
    
    private static class Node {
        private int data;
        private Node next;
        public Node(int _data) {
            data = _data;
        }
    }

    public void push(int _data) {
        Node newN = new Node(_data);
        newN.next = top;
        top = newN;
    }
        
    public int pop() {
        if (top == null) throw new EmptyStackException();
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }
    
    public static void main(String[] args) {
        MyStackLinkedList stack = new MyStackLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
    
    
}
