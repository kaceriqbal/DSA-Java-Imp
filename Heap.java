
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Heap<T extends Comparable<T>>{

	private ArrayList<T> nodes;
	private static Scanner scan;
	
	public Heap() {
		nodes = new ArrayList<T>();
	}
	
	//Used to move the node up the heap.
	private void moveUp() {
		
		int v = nodes.size() -1;
		while (v > 0) {
			int p =(v-1)/2;
			T node = nodes.get(v);
			T Parent = nodes.get(p);
			
			
			//compares the two values, moves smaller value up the heap.
			//< minHeap, > maxHeap
			if (node.compareTo(Parent) > 0) {
				
				//swap
				nodes.set(v, Parent);
				nodes.set(p, node);
				//move up
				v = p;
				
			} else {
				break;
			}
		}
	}
	
	//inserting value into the heap 1 at a time, at the end of the heap
	protected void insert(T node) {
		nodes.add(node);
		moveUp(); //call to moveUp method
	}
	
	
	private void moveDown() {
		
		int v = 0;
		int left = 2*v+1; //left Child
		
		while (left <nodes.size()) {
			int min=left, right=left+1; //right Child
			
			//checks if there is a right child 
			if (right < nodes.size()) {
				//compare the right and left child
				//< minHeap, > maxHeap
				if (nodes.get(right).compareTo(nodes.get(left)) > 0) {
					min++;
				}
			}
			
			//comparing the value to the child with the smaller value. 
			//< maxHeap, > minHeap
			if (nodes.get(v).compareTo(nodes.get(min)) < 0) {
				//swap if value is smaller
				T temp = nodes.get(v);
				nodes.set(v, nodes.get(min));
				nodes.set(min, temp);
				v = min;
				left = 2*v+1;
			} else {
				break;  
			}
		}
	}
	
	
	public T delete() {
		//If the heap is empty throw exception
		if (nodes.size() == 0) {
			throw new NoSuchElementException();
		}
		//If the heap contains 1 value, the value is removed then returned   
		if (nodes.size() == 1) {
			return nodes.remove(0);
		}
		//root value saved in variable hold 
		T hold = nodes.get(0);
		//last value moved to root and node is removed
		nodes.set(0, nodes.remove(nodes.size()-1));
		//calls the method moveDown 
		moveDown();
		//root value is returned
		return hold;	
	}
	
	
	//returns the size of the Heap
	public int size() {
		return nodes.size();
	}
	
	
	//Returns true if Heap is empty, otherwise returns false
	public boolean isEmpty() {
		return nodes.isEmpty();
	}
	
	
	//returns all the values in the Heap.
	public String toString() {
		return nodes.toString();
	}
	
//-------------------------- Main Class --------------------------------
	
		public static void main(String [] args) {
			
			Heap<Integer> heap = new Heap<Integer>();
			scan = new Scanner(System.in);
			System.out.println("Enter Value - 'done' to stop :");
			String line = scan.next();
		
			
		try {
				while (!line.equals("done")) {
					heap.insert(Integer.parseInt(line));  
					System.out.println(heap);
					System.out.println("Enter Value - 'done' to stop :");
					line = scan.next(); 
				}
		} 
		//Catches invalid input
		catch (NumberFormatException e) {
			System.out.println("Please provide correct input");
			line = scan.next();
			
			while (!line.equals("done")) {
				heap.insert(Integer.parseInt(line));  
				System.out.println(heap);
				System.out.println("Enter Value - 'done' to stop :");
				line = scan.next(); 
			}
		}
			
			//deleting from heap;
			while (!heap.isEmpty()) {
				int min = heap.delete();
				System.out.println(min+ " " +heap);
			}
			
		}
	
}