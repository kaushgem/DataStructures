package com.learn.ds.stack.test;

import com.learn.ds.stack.MyStackArray;
import com.learn.ds.stack.MyStackLinkedListGeneric;

public class StackTest {

	public static void main(String[] args) {
		
		MyStackLinkedListGeneric<Integer> stack = new MyStackLinkedListGeneric<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        
        System.out.println();
        
        MyStackArray s = new MyStackArray();
        s.push("a");
        s.push("b");
        s.push("c");
        s.push("d");
        s.push("e");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
	}
	

}
