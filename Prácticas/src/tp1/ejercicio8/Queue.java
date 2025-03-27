package tp1.ejercicio8;

import java.util.*;

public class Queue<T> extends Sequence {

	protected List<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		this.data.add(dato);
	}
	
	public List<T> dequeue(){
		this.data.remove(0);
		return this.data;
	}
	
	public T head () {
		return this.data.get(0);
	}
	
	public boolean isEmpty() {
		if(this.data.size() < 1) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return this.data.size();
	}
	
	public List<T> getQueue(){
		return this.data;
	}
	
	public String toString() {
		return this.data.toString();
	}
}
