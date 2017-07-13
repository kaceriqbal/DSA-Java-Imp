import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {
	
	//Node Class - creating Queue using linked list
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	// Adds to the back of the queue 
	public void add(T item) {
		
		Node<T> n = new Node<T>(item);
		if (last != null) {
			last.next = n;
		}
		last = n;
		if(first == null) {
			first = last;
		}
		System.out.println("Adding: "+ item);
	}
		
		//Removes the first item from the queue
		public T remove() {
			if (first == null) throw new NoSuchElementException();
			T data = first.data;
			first = first.next;
			if (first == null) {
				last = null;
			}
			System.out.println("Removing: "+ data);
			return data;
		}
		
		//Returns first item in the queue
		public T peek() {
			if (first == null) throw new EmptyStackException();
			System.out.println("Peek: "+ first.data);
			return first.data;
		}
		
		//Checks if Queue is empty, Returns True if empty
		public boolean isEmpty() {
			System.out.println(first == null);
			return first == null;
			
		}
	
//---------------------- Main Method --------------------------
		public static void main(String [] arg) {
			
			Queue<Integer> queue = new Queue<Integer>();
			
			queue.add(4);
			queue.add(6);
			queue.add(12);
			queue.add(40);
			queue.remove();
			queue.peek();
			queue.isEmpty();
			
			
		}
		
}
