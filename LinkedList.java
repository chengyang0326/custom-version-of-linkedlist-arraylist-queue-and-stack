/*
Implements the List<E> interface using a linked list as the underlying data structure.
A linked list consists of "nodes"; each node contains data and a reference to the next
node.  From the head (first) node, any other node can be reached.  The nodes in a list
do *not* have to be contiguous in memory, unlike the elements of an array.
*/
public class LinkedList<E> implements List<E> {
	// Each list keeps track of its head node.  From the head node, we
	//  can get to any other node of the list.
	private Node<E> head = null;

	// The size keeps track of how many elements are currently in the list.
	private int size = 0;

	// Returns the list element at the specified index.
	// O(n) because of the call to nodeAt
	public E get(int index) {
		if (index >= 0 && index < size)
			return nodeAt(index).getData();
		else
			throw new IndexOutOfBoundsException("get: invalid index " + index);
	}

	// Replaces the element at the specified index with a new value.
	// O(n) because of the call to nodeAt
	public void set(int index, E newValue) {
		if (index >= 0 && index < size)
			nodeAt(index).setData(newValue);
		else
			throw new IndexOutOfBoundsException();
	}

	// Adds a new element to the end of this list.
	// O(1) if adding to an empty list
	// O(n) if adding to a non-empty list
	public void add(E newValue) {
		// Create new Node object containing the newValue and whose next points to null
		Node<E> newNode = new Node<>(newValue, null);

		if (size == 0) {		// If the list is empty...
			// Point the head reference to the new node
			head = newNode;
		}
		else {					// If the list is not empty...
			// Get to the last node in the list, and set that node's next to the new node
			nodeAt(size - 1).setNext(newNode);
		}

		size++;
	}

	public void add (int index, E newValue){
		Node<E> newNode = new Node<>(newValue, null);

		if(size == 0){
			head = newNode;
		}
		else{
			if(index == 0){
				Node<E> nodeAfter = head;
				head = newNode;
				head.setNext(nodeAfter);
			}
			else if(index <size){
				Node<E> nodeBefore = nodeAt(index-1);
				Node<E> nodeAfter = nodeAt(index);
				nodeBefore.setNext(newNode);
				nodeBefore.getNext().setNext(nodeAfter);

			}
			else if (index == size) {
				nodeAt(size - 1).setNext(newNode);
			}
			else{
				throw new IndexOutOfBoundsException();
			}

		}
		size++;

	}

	// Removes and returns the list element at the specified index.
	// O(1) if removing from the front (head) of the list
	// O(n) if removing from the back (tail) of the list
	public E remove(int index) {
		if (index >= 0 && index < size) {
			// Store the value to return
			E valueToReturn;
			if (index == 0) {	// Remove the head node from the list
				valueToReturn = head.getData();
				head = head.getNext();
			}
			else {				// Remove a node from any other position
				Node<E> nodeBefore = nodeAt(index - 1);
				Node<E> nodeAfter = nodeBefore.getNext().getNext();
				valueToReturn = nodeBefore.getNext().getData();
				nodeBefore.setNext(nodeAfter);				
			}
			size--;
			return valueToReturn;
		}
		else
			throw new IndexOutOfBoundsException();
	}

	public String toString() {
		String result = "LinkedList object (size = " + size + "), elements: head -> ";
		// The commented out loop below works, but it's inefficient because *every*
		//  call to nodeAt involves a loop
		// for (int i = 0; i < size; i++)
		// 	result += nodeAt(i).getData() + " -> ";

		// Better way: just traverse the list once
		for (Node<E> temp = head; temp != null; temp = temp.getNext())
			result += temp.getData() + " -> ";

		result += "null";
		return result;
	}

	// Returns a reference to the node at the specified index of the list
	// Declared private, since nodeAt is meant to be called only by other
	//  methods within this class
	private Node<E> nodeAt(int index) {
		Node<E> temp = head;
		for (int i = 0; i < index; i++)		// Runs for "index" iterations
			temp = temp.getNext();			// Each time this runs, temp advances down the list by one node
		return temp;
	}

	public static void main(String[] args) {
		List<String> test = new LinkedList<>();
		// System.out.println(test);
		test.add("Impossible Burger");
		// System.out.println(test);
		test.add("Beyond Burger");
		// System.out.println(test);
		test.add("Whopper");
		// System.out.println(test);
		test.add("Heart Attack Burger");
		// System.out.println(test);
		test.add("Big Mac");

		System.out.println(test);
		System.out.println("");
		test.add(0,"a");
		
		System.out.println(test);
		System.out.println("");
		test.add(2,"b");
		
		System.out.println(test);
		System.out.println("");
		test.add(7,"c");
		
		System.out.println(test);
		System.out.println("");
	}
}
