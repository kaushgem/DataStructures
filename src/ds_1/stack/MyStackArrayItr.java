/*
 * Stack implementation using Resizing Array with Iterator
 *  
 */

package ds_1.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @author kaush
 */
public class MyStackArrayItr implements Iterable<String>{

	private int top;
	private String[] stack;

	MyStackArrayItr() {
		top = -1;
		stack = new String[1];
	}
	MyStackArrayItr(int size) {
		top = -1;
		stack = new String[size];
	}

	public void push(String _val) {
		if(top + 1 == stack.length)
			modifyStackSize(2 * stack.length);
		stack[++top] = _val;
	}

	public String pop() {
		if(isEmpty())
			throw new EmptyStackException();

		String val = stack[top];
		stack[top] = null;
		top--;

		if(top > 0 && top == stack.length/4)
			modifyStackSize(stack.length / 2);

		return val;
	}

	public String peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return stack[top];
	}

	public boolean isEmpty() {
		return top < 0;
	}

	private void modifyStackSize(int _capacity) {
		String[] copy = new String[_capacity];
		System.arraycopy(stack, 0, copy, 0, top+1);
		stack = copy;
	}

	@Override
	public Iterator<String> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<String> {
		int current = top;

		@Override
		public boolean hasNext() {
			return current >= 0;
		}

		@Override
		public String next() {
			return stack[current--];
		}
	}

	public static void main(String[] args) {
		MyStackArrayItr s = new MyStackArrayItr();
		System.out.println("initial: len: "+ s.top +"/"+s.stack.length);
		s.push("a");
		System.out.println("push: len: "+ s.top +"/"+s.stack.length);
		s.push("b");
		System.out.println("push: len: "+ s.top +"/"+s.stack.length);
		s.push("c");
		System.out.println("push: len: "+ s.top +"/"+s.stack.length);
		s.push("d");
		System.out.println("push: len: "+ s.top +"/"+s.stack.length);
		s.push("e");
		System.out.println("push: len: "+ s.top +"/"+s.stack.length);

		for(String str:s)
			System.out.println(str);

		System.out.println("peek: "+s.peek()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("peek: "+s.peek()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("peek: "+s.peek()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("peek: "+s.peek()+" len: "+ s.top +"/"+s.stack.length);

		System.out.println("pop:  "+s.pop()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("pop:  "+s.pop()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("pop:  "+s.pop()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("pop:  "+s.pop()+" len: "+ s.top +"/"+s.stack.length);
		System.out.println("pop:  "+s.pop()+" len: "+ s.top +"/"+s.stack.length);
	}
}

