/*
 * Stack implementation using Resizing Array
 *  
 */

package ds_1.stack;

import java.util.EmptyStackException;

/**
 *
 * @author kaush
 */
public class MyStackArray {
    
    private int top;
    private String[] stack;

    public MyStackArray() {
        top = -1;
        stack = new String[1];
    }
        
    public void push(String _data) {
        if(top+1 == stack.length) 
            increaseStack(2 * stack.length);
        stack[++top] = _data;
    }
    
    public String pop() {
        if(top == -1) 
            throw new EmptyStackException();
        
        String val = stack[top];
        stack[top] = null;
       
        if(top > 0 && top == stack.length/4)
            decreaseStack(stack.length / 2);
        
        top--;
        return val;
    }
    
    public String peek() {
        if (top == -1)
            throw new EmptyStackException();
        return stack[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    private void increaseStack(int _capacity) {
        String[] copy = new String[_capacity];
        for(int i=0; i<=top; i++)
            copy[i] = stack[i];
        stack = copy;
    }
    
    private void decreaseStack(int _capacity) {
        String[] copy = new String[_capacity];
        System.arraycopy(stack, 0, copy, 0, top+1); 
        stack = copy;
    }
    
    public static void main(String[] args) {
        MyStackArray s = new MyStackArray();
        s.push("a");
        System.out.println("len: "+s.stack.length);
        s.push("b");
        System.out.println("len: "+s.stack.length);
        s.push("c");
        System.out.println("len: "+s.stack.length);
        s.push("d");
        System.out.println("len: "+s.stack.length);
        s.push("e");
        System.out.println("len: "+s.stack.length);
        System.out.println(s.pop());
        System.out.println("len: "+s.stack.length);
        System.out.println(s.pop());
        System.out.println("len: "+s.stack.length);
        System.out.println(s.peek());
        System.out.println("len: "+s.stack.length);
        System.out.println(s.pop());
        System.out.println("len: "+s.stack.length);
    }
}
