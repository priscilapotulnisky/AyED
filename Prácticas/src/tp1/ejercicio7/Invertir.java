package tp1.ejercicio7;
import java.util.*;
public class Invertir {

	//hay que hacer el privado para respetar la firma del metodo
	public static void invertirArrayList(ArrayList<Integer> lista){
		invertirRecursivo(lista, 0, lista.size() - 1);
	}
	
	private static void invertirRecursivo(ArrayList<Integer> lista, int inicio, int fin) {
		if(inicio<fin){
			int aux = lista.get(fin);
			lista.set(fin, lista.get(inicio));
			lista.set(inicio, aux);
			invertirRecursivo(lista, inicio + 1, fin - 1);
		}
	}
	
	public static void main (String [] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		
		System.out.println(lista);
		
		Invertir.invertirArrayList(lista);
		
		System.out.println(lista);
	}
	
}
