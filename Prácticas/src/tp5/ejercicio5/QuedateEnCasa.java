package tp5.ejercicio5;

import java.util.*;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.*;

public class QuedateEnCasa {

	public List<Persona> mostrarCamino(Graph<Persona> grafo, Persona empleado, int gradoSeparacion, int limite){
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		Vertex<Persona> persona = grafo.search(empleado);
		List<Persona> lista = new LinkedList<>();
		if(persona != null && persona.getData().isEsEmpleado()) {
			boolean [] marcas = new boolean [grafo.getSize()];
			marcas[persona.getPosition()] = true;
			cola.enqueue(persona);
			cola.enqueue(null);
			int nivel = 0;
			while(!cola.isEmpty() && nivel < gradoSeparacion && lista.size() < limite) {
				Vertex<Persona> vertice = cola.dequeue();
				if(vertice != null) {
					List<Edge<Persona>> adyacentes = grafo.getEdges(vertice);
					Iterator<Edge<Persona>> it = adyacentes.iterator();
					while(it.hasNext() && lista.size() < limite) {
						Vertex<Persona> vertice2 = it.next().getTarget();
						if(!marcas[vertice2.getPosition()]) {
							marcas[vertice2.getPosition()] = true;
							cola.enqueue(vertice2);
							if(!vertice2.getData().isEsEmpleado() && !vertice2.getData().isCobro())
								lista.add(new Persona(vertice2.getData().getNombre(), vertice2.getData().getDomicilio(), false, false));
						}
					}
				}
				else if(!cola.isEmpty()) {
					nivel++;
					cola.enqueue(null);
				}
			}
			System.out.println(nivel);
		}
		return lista;
	}
			
}
	
	
