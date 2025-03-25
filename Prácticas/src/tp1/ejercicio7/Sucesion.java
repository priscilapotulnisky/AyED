package tp1.ejercicio7;
import java.util.*;
public class Sucesion {

	private static void calcularSucesionRec (List<Integer> lista,int n){
		lista.add(n);
		if(n > 1) {
			if(n % 2 == 0) 
				calcularSucesionRec(lista,n/2);
	
			else
				calcularSucesionRec(lista,3*n + 1);
		}
	}
	
	public static List<Integer> calcularSucesion(int n){
		List<Integer> lista = new LinkedList <Integer>();
		Sucesion.calcularSucesionRec(lista, n);
		return lista;
	}
	
	public static void main (String [] args) {
		List<Integer> lista = Sucesion.calcularSucesion(6);
		System.out.println(lista);
	}
}
