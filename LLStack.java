/*
Implements the Stack<E> interface using a linked list as the underlying
data structure.  The stack operations (push, pop, peek) are done at the
head of the list, since doing them at the tail would require traversing
the list.  This allows us to make the stack operations O(1) instead of
O(n).
*/
public class LLStack<E> implements Stack<E> {
	// Maintains the head node of the list
	private Node<E> head = null;

	// Returns whether or not the stack is empty.
	public boolean isEmpty() {
		return head == null;
	}

	// Adds a new element to the top of the stack.
	// (This just adds a new node to the front of the linked list.)
	public void push(E newValue) {
		// Create a new node containing the newValue and whose next points to head
		Node<E> newNode = new Node<>(newValue, head);

		// Change head to point to the new node
		head = newNode;

		// Could combine the previous lines into this:
		// head = new Node<>(newValue, head);
	}

	// Removes and returns the element at the top of the stack.
	// (This just removes the head node from the linked list, and returns
	//  the data that was in that node.)
	public E pop() {
		if (!isEmpty()) {
			E valueToReturn = head.getData();
			head = head.getNext();
			return valueToReturn;
		}
		else
			return null;	// This indicates that the stack is empty
	}

	// Returns (without removing) the element at the top of the stack.
	// (This just returns the data part of the head node of the linked list.)
	public E peek() {
		if (!isEmpty())
			return head.getData();
		else
			return null;	// This indicates that the stack is empty
	}

	public String toString() {
		String result = "LLStack object, elements (top to bottom):\n";
		for (Node<E> temp = head; temp != null; temp = temp.getNext())
			result += temp.getData() + "\n";
		return result;
	}

	public static void main(String[] args) {
		Stack<String> stuff = new LLStack<>();
		System.out.println(stuff);

		stuff.push("Soulja Boy");
		System.out.println(stuff);

		stuff.push("Steven Tyler");
		System.out.println(stuff);

		stuff.push("Chester Bennington");
		System.out.println(stuff);

		stuff.push("Taylor Swift");
		System.out.println(stuff);

		stuff.push("John Lennon");
		System.out.println(stuff);

		stuff.push("Katy Perry");
		System.out.println(stuff);

		System.out.println(stuff.peek());
		System.out.println(stuff);

		System.out.println(stuff.pop());
		System.out.println(stuff);

		System.out.println(stuff.pop());
		System.out.println(stuff);

		System.out.println(stuff.pop());
		System.out.println(stuff);
	}
}
