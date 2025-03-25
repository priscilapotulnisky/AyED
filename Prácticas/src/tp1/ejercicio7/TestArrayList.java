package tp1.ejercicio7;

import tp1.ejercicio3.*;
import java.util.*;
public class TestArrayList {

	public static void main (String [] args) {
		
		//------- Inciso a----------
		ArrayList<Integer> lista = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			lista.add(i);
		}
		
		//diferentes formas para imprimir el arraylist
		System.out.println(lista);
		
		
		for (int i = 0; i < lista.size(); i++) {
		    System.out.println(lista.get(i));
		}
		
		for(int l: lista) {
			System.out.println(l);
		}
		
		//-------inciso d----------
		
		List<Estudiante> listaEst = new LinkedList<>();
		listaEst.add(new Estudiante("Nombre est 1", "Apellido est 1", "email 1", "comision 1", "direccion1"));
		listaEst.add(new Estudiante("Nombre est 2", "Apellido est 2", "email 2", "comision 2", "direccion3"));
		listaEst.add(new Estudiante("Nombre est 3", "Apellido est 3", "email 3", "comision 3", "direccion3"));
		
		List<Estudiante> listaEstCopia = new LinkedList<>(listaEst);
		
		System.out.println("-------------Lista original----------");
		for(Estudiante e: listaEst) {
		  System.out.println(e.tusDatos());
		  System.out.println();
		}
		
		System.out.println("-------------Copia----------");
		for(Estudiante e: listaEstCopia) {
			System.out.println(e.tusDatos());
			System.out.println();
		}
		
		listaEst.get(1).setApellido("Nuevo apellido");
		
		System.out.println("-------------Lista original----------");
		for(Estudiante e: listaEst) {
			System.out.println(e.tusDatos());
			System.out.println();
		}
		
		System.out.println("-------------Copia----------");
		for(Estudiante e: listaEstCopia) {
			System.out.println(e.tusDatos());
			System.out.println();
		}
		
		Estudiante estudianteNuevo = new Estudiante("Estudiante nuevo ", "Apellido est nuevo", "email est nuevo","comision 4", "direccion est nuevo");
		if(!listaEst.contains(estudianteNuevo)) 
			listaEst.add(estudianteNuevo);
		
		
	}
	
	
	
}
