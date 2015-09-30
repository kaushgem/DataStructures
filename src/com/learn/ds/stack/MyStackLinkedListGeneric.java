/*
 * Stack implementation using LinkedList with Generic type
 *  
 */

package com.learn.ds.stack;

import java.util.EmptyStackException;

/**
 *
 * @author kaush
 * @param <T>
 */
public class MyStackLinkedListGeneric<T> {
    private Node<T> top;
    
    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T _data) {
            data = _data;
        }
    }
    
    public void push(T _data) {
        Node<T> newN = new Node<T>(_data);
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
    
    public static void main(String[] args) {
        MyStackLinkedListGeneric<Integer> stack = new MyStackLinkedListGeneric<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
    

