/*
Implements the List<E> interface using an array as the underlying data structure
*/
public class ArrayList<E> implements List<E> {
	// The ArrayList stores its data in this array
	// We set the initial capacity to 8 (this doesn't matter a whole lot, as long as
	//  the array can be reallocated when needed)
	public  E[] data = (E[])(new Object[8]);

	// The size keeps track of how many elements are currently in the array list.
	private int size = 0;

	// Returns the list element at the specified index.
	// O(1)
	public E get(int index) {
		if (index >= 0 && index < size)
			return data[index];
		else
			throw new IndexOutOfBoundsException("get: invalid index " + index);
	}

	// Replaces the element at the specified index with a new value.
	// O(1)
	public void set(int index, E newValue) {
		if (index >= 0 && index < size)
			data[index] = newValue;
		else
			throw new IndexOutOfBoundsException();
	}
	//throw index out bounds exception
	public void checkBoundInclusive(int index){
		if (index > size){
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size);
		}
	}
	//make sure the capacity is enough
	public void ensureCapacity(int minCapacity){
     int current = data.length;
 
       if(minCapacity>current){
       E[] newData = (E[]) new Object[Math.max(current * 2, minCapacity)];
        // System.arraycopy(data, 0, newData, 0, size);
        for(int i =0;i<size;i++){
     		newData[i] = data[i];

     	}
     	for(int i =0;i<size; i++){
     		data[i+1]= newData[i];
     	}
          data = newData;
        }
    }

	// Adds a new element to the end of this list.
	// O(1) if we don't need to reallocate the array
	// O(n) if we do need to reallocate the array
	public void add(E newValue) {
		// Check to see if the array list has been filled up (size = capacity)
		if (size == data.length) {
			// Create a new array of double the old capacity
			E[] newData = (E[])(new Object[data.length * 2]);

			// Copy all the elements of data into newData
			for (int i = 0; i < data.length; i++)
				newData[i] = data[i];

			// Point the data reference to the new array
			data = newData;
		}

		// Add the newValue to the end of the array, and increase the size
		data[size] = newValue;
		size++;
	}
	// add element in specified index
	public void add(int index, E newValue){
	
		
     if (size == data.length){
      	ensureCapacity(size + 1);
      }
     if (index != size){
     		E[] newData = (E[])(new Object[data.length+1]);

     	
     	for(int i =0;i<size;i++){
     		newData[i] = data[i];

     	}
     	for(int i =index;i<size; i++){
     		data[i+1]= newData[i];
     	}
     }
   	  data[index] = newValue;
 	  size++;
	}

	// Removes and returns the list element at the specified index.
	// O(1) if removing from the back (tail) of the list
	// O(n) if removing from the front (head) of the list
	public E remove(int index) {
		if (index >= 0 && index < size) {
			E result = data[index];
			// Shift all array elements starting from index down by 1
			for (int i = index; i < size - 1; i++)
				data[i] = data[i + 1];

			// We don't need to explicitly erase the element that
			//  used to be at the back of the list - the next call to
			//  add would overwrite that element anyway

			size--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException();
	}
	// to string 
	public String toString() {
		String result = "ArrayList object (size = " + size + ", capacity = " + data.length + "), elements:\n";
		for (int i = 0; i < size; i++)
			result += " " + data[i] + "\n";
		return result;
	}

	public static void main(String[] args) {
		List<Integer> test = new ArrayList<>();
		System.out.println(test);

		for (int i = 17; i < 26; i++) {
			test.add(i);
			System.out.println(test);
		}
		System.out.println(test);
		test.add(0,1);
		test.add(3,4);
		test.add(11,9);
		System.out.println(test);

		test.remove(0);
		System.out.println(test);
		test.remove(7);
		System.out.println(test);
		test.remove(3);
		System.out.println(test);

		System.out.println(test.get(6));
	}
}
