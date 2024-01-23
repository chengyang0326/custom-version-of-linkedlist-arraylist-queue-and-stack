public class NaughtyLLQueue<E> implements Queue<E>{
	private Node<E> head = null;
	private int size = 0;

	public boolean isEmpty() {
		;

		return head == null;
	}
	private Node<E> nodeAt(int index) {
		Node<E> temp = head;
		for (int i = 0; i < index; i++)		// Runs for "index" iterations
			temp = temp.getNext();			// Each time this runs, temp advances down the list by one node
		return temp;
	}
	public void enqueue(E newValue){
		Node<E> newNode = new Node<>(newValue, null);
		if (!isEmpty()) {		
			Node<E> perviousHead = head;
			head= newNode;
			head.setNext(perviousHead);
		}
		else {
			head = newNode;
			head.setNext(null);
		}
		
		

	}
	public E dequeue(){
		

		if (!isEmpty()) {
			E valueToReturn = peek();
		
			// nodeAt(size-2).setNext(null);
			// 	// nodeAt(size-2).setNext(null);
				
			
			// // Update tail if the removal empties the list
			// if (isEmpty()||size ==1)
			// 	head=null;


			if(head.getNext()==null){
				head =null;

			}
			else{
				Node<E> temp = new Node<>(null, null);
				temp = head;
				while(temp.getNext().getNext()!=null){
					temp=temp.getNext();
				}
				temp.setNext(null);

			}

			return valueToReturn;
		}
		else
			return null;

	}
	public E peek(){
		if (!isEmpty())
			return nodeAt(size-1).getData();
		else
			return null;

	}
	public String toString() {
		String result = "NaughtyLLQueue object, elements (back to front):\n";
		for (Node<E> temp = head; temp != null; temp = temp.getNext())
			result += temp.getData() + "\n";
		return result;


		
		
	}
	public static void main(String[] args) {
		Queue<String> stuff = new NaughtyLLQueue<>();
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