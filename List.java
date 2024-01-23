/*
Home-brewed version of the List<E> interface.  We focus on a subset
of operations from Java's built-in java.util.List<E> interface:

get, set, add, remove
*/

public interface List<E> {

	// Returns the list element at the specified index.
	E get(int index);

	// Replaces the element at the specified index with a new value.
	void set(int index, E newValue);	

	// Adds a new element to the end of this list.
	void add(E newValue);

	void add(int index, E newValue);

	// Removes and returns the list element at the specified index.
	E remove(int index);
}
