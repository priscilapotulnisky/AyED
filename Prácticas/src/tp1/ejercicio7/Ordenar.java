package tp1.ejercicio7;

import java.util.*;
public class Ordenar {

	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer>lista1, ArrayList<Integer>lista2){
		ArrayList<Integer> listaCombinada = new ArrayList<>();
		int i = 0;
		int j = 0;
		while((i < lista1.size()) && (j < lista2.size())) {
			if(lista1.get(i) <= lista2.get(j)) {
				listaCombinada.add(lista1.get(i));
				i ++;
			}
			else {
				listaCombinada.add(lista2.get(j));
				j++;
			}
		}
		while(i < lista1.size()) {
			listaCombinada.add(lista1.get(i));
			i++;
		}
		
		while(j < lista2.size()) {
			listaCombinada.add(lista2.get(j));
			j++;
		}
		return listaCombinada;
	}
	
	public static void main (String [] args) {
		ArrayList<Integer> lista1 = new ArrayList<>();
		ArrayList<Integer> lista2 = new ArrayList<>();
		lista1.add(2);
		lista1.add(4);
		lista1.add(6);
		lista1.add(8);
		lista1.add(10);
		lista2.add(3);
		lista2.add(7);
		lista2.add(12);
		
		ArrayList<Integer> combinado = new ArrayList<>();
		combinado = Ordenar.combinarOrdenado(lista1, lista2);
		System.out.println(combinado);
		
	}
}
