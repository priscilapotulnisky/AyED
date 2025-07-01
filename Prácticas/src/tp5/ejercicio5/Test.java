package tp5.ejercicio5;

import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
public class Test {

	public static void main (String [] args) {
		 Graph<Persona> grafo = new AdjListGraph<>();
	        Vertex<Persona> v1 = grafo.createVertex(new Persona("Empleado1", "22222", true, true));
	        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado1", "1231", false, false));
	        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado2", "234234", false, true));
	        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado2", "2423", true, true));
	        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado3", "2352", false, false));
	        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado3", "2342", true, true));
	        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado4", "2342", false, false));
	        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado5", "2666", false, false));
	        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado6", "999", false, false));
	        
	        grafo.connect(v1, v2);
	        grafo.connect(v2, v1);
	        grafo.connect(v2, v3);
	        grafo.connect(v3, v2);
	        
	        grafo.connect(v1, v9);
	        grafo.connect(v9, v1);
	        grafo.connect(v9, v8);
	        grafo.connect(v8, v9);
	        
	        grafo.connect(v1, v4);
	        grafo.connect(v4, v1);
	        grafo.connect(v1, v6);
	        grafo.connect(v6, v1);
	        grafo.connect(v4, v5);
	        grafo.connect(v5, v4);
	        grafo.connect(v5, v7);
	        grafo.connect(v7, v5);
	        
	        
	        QuedateEnCasa q = new QuedateEnCasa();
	        System.out.println(q.mostrarCamino(grafo, new Persona("Empleado1", "22222", true, true) , 2, 3));
	}
}
