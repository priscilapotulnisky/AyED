package tp1.ejercicio8;

public class CircularQueue<T> extends Queue {

	public CircularQueue() {
		
	}
	
	public T shift() {
		T elemento = (T) this.data.get(0);
		dequeue();
		enqueue(elemento);
		return elemento;
		
	}
}
