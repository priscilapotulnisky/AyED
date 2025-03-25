package tp1.ejercicio7;

import java.util.*;
public class Suma {

	private static int sumaRec(LinkedList<Integer> lista, int pos) {
		if(pos < lista.size()) {
			return lista.get(pos) + sumaRec(lista, pos + 1);	
		}
		return 0;
	}
	
	public static int sumarLinkedList(LinkedList<Integer> lista) {
		return sumaRec(lista, 0);
	}
	
	public static void main (String [] args) {
		LinkedList<Integer> lista = new LinkedList<>();
		lista.add(2);
		lista.add(4);
		lista.add(6);
		lista.add(8);
		lista.add(10);
		
		int resultado = Suma.sumarLinkedList(lista);
		System.out.println(resultado);
	}
}
