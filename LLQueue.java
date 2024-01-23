/*
Implements the Queue<E> interface using a linked list as the underlying
data structure.  We maintain references to both the head and tail nodes.

We let the head of the list correspond to the front of the queue and the
tail of the list correspond to the back of the queue.  Add (enqueue) is
done from the tail, and remove (dequeue) is done from the head.  This
lets us make all the queue operations O(1).
*/
public class LLQueue<E> implements Queue<E> {
	// Maintain both the head and tail nodes of the list
	// For an empty list, both point to null
	private Node<E> 	head = null,
						tail = null;

	// Returns whether or not the queue is empty.
	public boolean isEmpty() {
		return head == null;
		// The line above behaves the same as this if-else:
		// if (head == null)
		// 	return true;
		// else
		// 	return false;
	}

	// Adds a new element to the back of the queue.
	// (This just adds a new node to the back of the linked list, with a special
	//  case for adding to an empty list since that requires altering the head.)
	public void enqueue(E newValue) {
		// Create a new node containing the newValue and whose next points to null
		Node<E> newNode = new Node<>(newValue, null);

		if (!isEmpty()) {		// Adding to the back of a non-empty list
			tail.setNext(newNode);
			tail = newNode;
		}
		else					// Adding to an empty list
			head = tail = newNode;	// New node becomes both head and tail
	}

	// Removes and returns the element at the front of the queue.
	// (This just removes the head node from the linked list, and returns
	//  the data that was in that node.)
	public E dequeue() {
		if (!isEmpty()) {
			E valueToReturn = head.getData();
			head = head.getNext();

			// Update tail if the removal empties the list
			if (isEmpty())
				tail = null;

			return valueToReturn;
		}
		else
			return null;		// This indicates that the queue is empty
	}

	// Returns (without removing) the element at the front of the queue.
	// (This just returns the data part of the head node of the linked list.)
	public E peek() {
		if (!isEmpty())
			return head.getData();
		else
			return null;		// This indicates that the queue is empty
	}

	public String toString() {
		String result = "LLQueue object, elements (front to back):\n";
		for (Node<E> temp = head; temp != null; temp = temp.getNext())
			result += temp.getData() + "\n";
		return result;
	}

	public static void main(String[] args) {
		Queue<String> stuff = new LLQueue<>();
		System.out.println(stuff);

		stuff.enqueue("Sergei Rachmaninoff");
		System.out.println(stuff);

		stuff.enqueue("Piotr Tchaikovsky");
		System.out.println(stuff);

		stuff.enqueue("Samuel Barber");
		System.out.println(stuff);

		stuff.enqueue("Nikolai Rimsky-Korsakov");
		System.out.println(stuff);

		stuff.enqueue("Yensid");
		System.out.println(stuff);

		System.out.println(stuff.peek());
		System.out.println(stuff);

		while (!stuff.isEmpty()) {
			System.out.println(stuff.dequeue());
			System.out.println(stuff);
		}
	}
}
