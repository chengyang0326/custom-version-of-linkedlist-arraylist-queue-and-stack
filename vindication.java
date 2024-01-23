

public class vindication {
	public static void main(String[] args) {
		long t1 = System.nanoTime();
		Queue<Integer> stuff1 = new NaughtyLLQueue<>();
		for(int i =0; i<250000;i++){
			stuff1.enqueue(i);
		}
		while (!stuff1.isEmpty()){
			
			stuff1.dequeue();
		}
		long t2 = System.nanoTime();
		long t3 = System.nanoTime();

		Queue<Integer> stuff2 = new LLQueue<>();
		for(int i =0; i<250000;i++){
			stuff2.enqueue(i);
		}
		while (!stuff2.isEmpty()){
			stuff2.dequeue();
		}
		long t4 = System.nanoTime();

		double badTime= t2-t1;
		double goodTime = t4-t3;


		System.out.println("time for NaughtyLLQueue: "+ badTime);
		System.out.println("time for LLQueue: "+ goodTime);
	}
}