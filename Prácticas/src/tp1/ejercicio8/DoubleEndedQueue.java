package tp1.ejercicio8;

public class DoubleEndedQueue<T> extends Queue {

	public DoubleEndedQueue() {
		
	}
	
	public void enqueueFirst(T elemento) {
		getQueue().add(0, elemento);
	}
}
