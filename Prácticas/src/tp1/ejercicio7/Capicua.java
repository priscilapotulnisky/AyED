package tp1.ejercicio7;

import java.util.*;
public class Capicua {

	public static boolean esCapicua(ArrayList<Integer> lista) {
		int tamaño = lista.size();
		int [] vector = new int [tamaño];
		for(int i = 0; i<tamaño; i++) {
			vector[i] = lista.get(tamaño-i-1);
		}
		
		int i = 0;
		boolean ok = true;
		while(i<tamaño && ok == true) {
			if(vector[i] == lista.get(i))
				ok=true;
			else
				ok=false;
			i++;
		}
		return ok;
		
			
	}
	
	public static void main (String[]args) {
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(2);
		lista.add(1);
		
		System.out.println(Capicua.esCapicua(lista));
	}
}
