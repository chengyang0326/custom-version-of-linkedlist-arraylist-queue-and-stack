import java.util.*;
public class ArrayStack<E>  implements Stack<E> {

	// make data and size as instance varible 
	public  E[] data = (E[])(new Object[8]);
	private int size = 0;
	
	


	//check if the stack empty
	public boolean isEmpty() {
		return data.length==0;

		
	}
	//make sure capacity is enough
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
	public void push(E newValue) {
		E[] newData = (E[])(new Object[data.length]);

		newData[0]=newValue;
		for(int i = 0; i<data.length;i++){

		}
		


     if (size == data.length){
      	ensureCapacity(size + 1);
      }
     
     		E[] newData = (E[])(new Object[data.length+1]);

     	
     	for(int i =0;i<size;i++){
     		newData[i] = data[i];

     	}
     	for(int i =0;i<size; i++){
     		data[i+1]= newData[i];
     	}
     
   	  data[0] = newValue;
 	  size++;

	}
	public E pop() {
		if (!isEmpty()) {
			E valueToReturn = data[0];
			for (int i = 0; i < size - 1; i++){
				data[i] = data[i + 1];
			}
			size--;

			return valueToReturn;
		}
		else
			return null;
	}
	public E peek() {
		if (!isEmpty())
			return data[0];
		else
			return null;
	}
	public String toString() {
		String result = "ArrayList object (size = " + size + ", capacity = " + data.length + "), elements:\n";
		for (int i = 0; i < size; i++)
			result += " " + data[i] + "\n";
		return result;
	}

	public static void main(String[] args) {
		Stack<String> stuff = new ArrayStack<>();
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