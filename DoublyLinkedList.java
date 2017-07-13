import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

	private Node head;
	private Node tail;
	private int size;
	
	public DoublyLinkedList() {
		size=0;
	}
	
	//This class will keep track of each element
	private class Node {
		E value;
		Node next;
		Node prev;
	
		public Node(E value, Node next, Node prev){
			this.value = value;
			this.next = next;
			this.prev = prev;
			
		}
	}
	
	//Return Size of the Linked List
	public int size() {
		return size;
	}
	
	//Tells us if the list is empty or not
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Add value at the front(Head)
	public void addFirst(E value) {
		Node tmp = new Node(value, head, null);
		if (head != null) {
			head.prev = tmp;
		}
		head = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size ++;
		System.out.println("Adding: " + value);
	}
	
	//Add value at the end of list(Tail)
	public void addLast(E value) {
		Node tmp = new Node(value, null, tail);
		if(tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			head = tmp;
		}
		size ++;
		System.out.println("Adding: " + value);
	}
	
	//This method goes forward through list
	public void iterateFoward() {
		System.out.println("Iterating forwards...");
		Node tmp = head;
		while(tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
	}
	
	//This method goes backwards through list
	public void iterateBackwards() {
		System.out.println("Iterating Backwards");
		Node tmp = tail;
		while(tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.prev;
		}
	}
	
	//This method removes the first element (Head)
	public E removeFirst() {
		if (size == 0) throw new NoSuchElementException();
		Node tmp = head;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("Removed: " + tmp.value);
		return tmp.value;
	}
	
	//This method removes the last element (tail)
		public E removeLast() {
			if (size == 0) throw new NoSuchElementException();
			Node tmp = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			System.out.println("Removed: " + tmp.value);
			return tmp.value;
		}
		
		
//------------------Main Method---------------------
		public static void main(String [] arg) {
			
			DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
			dll.addFirst(10);
			dll.addFirst(9);
			dll.addLast(11);
			dll.addLast(12);
			dll.iterateFoward();
			
			
		}
	
}
