/*
Home-brewed Queue<E> interface.

A queue is a linear data structure where elements are added to one
end (the "back" of the queue) and removed from the other end (the
"front" of the queue).  It's a "first-in, first-out" (FIFO)
structure - the first element added is the first element to be removed.

This interface supports the isEmpty, enqueue, dequeue, peek operations.
*/
public interface Queue<E> {

	// Returns whether or not the queue is empty.
	boolean isEmpty();

	// Adds a new element to the back of the queue.
	void enqueue(E newValue);

	// Removes and returns the element at the front of the queue.
	E dequeue();

	// Returns (without removing) the element at the front of the queue.
	E peek();
}
