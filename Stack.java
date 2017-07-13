import java.util.EmptyStackException;

public class Stack<T> {

	//Node class -- creating stack using linked list.
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	
	//Remove the top item from the stack
	public T pop() {
		if(first == null) throw new EmptyStackException();
		T item = first.data;
		first = first.next;
		System.out.println("Removing: " + item);
		return item;
	}
	
	//Adds item into stack
	public void push(T item){
		Node<T> t = new Node<T>(item);
		t.next = first;
		first = t;
		System.out.println("Adding: " + item);
	}
	
	//Returns the top item of the stack
	public T peek() {
		if(first == null) throw new EmptyStackException();
		System.out.println("Peek: " + first.data);
		return first.data;
	}
	
	//checks if stack is empty, returns True if empty.
	public boolean isEmpty() {
		System.out.println(first == null);
		return first == null;
	}
	

//---------------------- Main Method --------------------------
	public static void main(String [] arg) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(12);
		stack.pop();
		stack.peek();
		
	}
	
}
