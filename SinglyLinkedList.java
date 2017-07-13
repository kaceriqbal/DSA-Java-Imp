
public class SinglyLinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	
public void add(T value) {
	
	Node<T> node = new Node<T>();
	node.setData(value);
	System.out.println("Adding: " + value);
	
	// Check if list is empty
	
	if(head == null) {  
		head = node; //if list empty, added value becomes head
		tail = node; //one value means tail points to same value as head
	} 
	else {	
		tail.setNext (node); //set current tails next link to new node
		tail = node; //set tail as new node
	}
}

public void addAfter (T value, T after) {
	
	Node<T> tmp = head;
	Node<T> nextNode = null;
	System.out.println("Traversing through all nodes... ");
	
	//Traverse until given value
	while (true) {
		if(tmp == null) {
			break;
		}
		if(tmp.compareTo(after) == 0) {
			//Target node found, add new node after this node
			nextNode = tmp;
			break;
		}
		tmp = tmp.getNext();
	}
	if(nextNode != null) {
		//add value after target node
		Node<T> node = new Node<T>();
		node.setData(value);
		node.setNext(tmp.getNext());
		if(tmp == tail) {
			tail = node;
		}
		tmp.setNext(node);
	}
	else {
		System.out.println("unable to find given value...");
	}
}

public void deleteFront () {
	
	if(head == null){ //check if list is empty
		System.out.println("list Empty");
	}
	Node<T> tmp = head;
	head = tmp.getNext();
	if(head == null) {
		tail = null;
	}
	System.out.println("Deleted: " + tmp.getData());
}

public void deleteAfter (T after) {
	
	Node<T> tmp = head;
	Node<T> nextNode = null;
	System.out.println("Traversing through nodes...");
	
	//Traverse until given value
		while (true) {
			if(tmp == null) {
				break;
			}
			if(tmp.compareTo(after) == 0) {
				//Target node found, add new node after this node
				nextNode = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		if(nextNode != null) {
			tmp = nextNode.getNext();
			nextNode.setNext(tmp.getNext());
			if(nextNode.getNext() == null) {
				tail = nextNode;
			}
			System.out.println("Deleted: " + tmp.getData());
		} 
		else {
			System.out.println("unable to find given value...");
		}
}

public void traverse() {
	
	Node<T> tmp = head;
	while(true) {
		if(tmp == null) {
			break;
		}
		System.out.println(tmp.getData());
		tmp = tmp.getNext();
	}
}


//---------------Node Class---------------

	@SuppressWarnings("hiding")
	private class Node<T> implements Comparable<T> {

		private Node<T> next;
		private T data; 
		
		public T getData() {
			return this.data;
		}
		
		public void setData(T data) {
			this.data=data;
		}
		
		public Node<T> getNext() {
			return this.next;
		}
		
		public void setNext(Node<T> nextNode) {
			this.next=nextNode;
		}
		
		@Override
		public int compareTo(T arg) {
			if (arg == this.data) {
				return 0;
			} else {
				return 1;
			}
		}	
		
	}
	
//---------------Main Class---------------	
	
public static void main(String [] args) {
	SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
	sll.add(5);
	sll.add(28);
	sll.add(67);
	sll.add(12);
	sll.add(100);
	sll.traverse();
	sll.addAfter(9, 5);
	sll.traverse();
	sll.deleteFront();
	sll.traverse();
	sll.deleteAfter(67);
	sll.traverse();
	}
	
}



