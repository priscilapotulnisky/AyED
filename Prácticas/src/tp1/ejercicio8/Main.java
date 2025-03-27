package tp1.ejercicio8;

public class Main {

	public static void main(String [] args) {
		
		//Probando clase Queue

		Queue<Integer> cola = new Queue<Integer>();
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		cola.enqueue(4);
		
		System.out.println(cola.size());
		System.out.println(cola.isEmpty());
		System.out.println(cola.toString());
		
		cola.dequeue();
		cola.dequeue();
		
		System.out.println(cola.size());
		System.out.println(cola.isEmpty());
		System.out.println(cola.toString());
		System.out.println(cola.head());
		
		cola.dequeue();
		cola.dequeue();
		
		System.out.println(cola.size());
		System.out.println(cola.isEmpty());
		System.out.println(cola.toString());
		
		
		//Probando circularQueue
		
		CircularQueue<Integer> colaCircular = new CircularQueue<Integer>();
		colaCircular.enqueue(1);
		colaCircular.enqueue(2);
		colaCircular.enqueue(3);
		colaCircular.enqueue(4);
		colaCircular.enqueue(5);
		
		System.out.println(colaCircular.size());
		System.out.println(colaCircular.isEmpty());
		System.out.println(colaCircular.toString());
		
		System.out.println(colaCircular.shift());
		System.out.println(colaCircular.toString());
		
		colaCircular.dequeue();
		colaCircular.dequeue();
		
		System.out.println(colaCircular.size());
		System.out.println(colaCircular.isEmpty());
		System.out.println(colaCircular.toString());
		System.out.println(colaCircular.head());
		

		
		//Probando DoubleEndedQueue
		DoubleEndedQueue<Integer> deq = new DoubleEndedQueue<Integer>();
		
		deq.enqueue(1);
		deq.enqueue(2);
		deq.enqueue(3);
		deq.enqueue(4);
		
		System.out.println(deq.size());
		System.out.println(deq.isEmpty());
		System.out.println(deq.toString());
		
		deq.dequeue();
		deq.dequeue();
		
		deq.enqueueFirst(9);
		System.out.println(deq.toString());
	}
}
