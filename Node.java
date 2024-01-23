/*
This class represents a single node in a linked list.
Each node contains data and a reference to the next node in the list.
*/
public class Node<E> {
	private E data;
	private Node<E> next;

	// Constructor
	public Node(E data, Node<E> next) {
		setData(data);
		setNext(next);
	}

	// Setter methods
	public void setData(E data) {
		this.data = data;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	// Getter methods
	public E getData() {
		return data;
	}

	public Node<E> getNext() {
		return next;
	}
}
