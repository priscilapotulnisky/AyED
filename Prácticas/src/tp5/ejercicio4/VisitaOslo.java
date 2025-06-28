package tp5.ejercicio4;

import tp5.ejercicio1.*;
import java.util.*;
public class VisitaOslo {

	public List<String> paseoEnBici (Graph<String> lugares, String destino,  int maxTiempo, List<String> lugaresRestringidos){
		List<String> lista = new LinkedList<>();
		Vertex<String> vertice1 = lugares.search("Ayuntamiento");
		Vertex<String> vertice2 = lugares.search(destino);
		if(vertice1 != null && vertice2 != null)
			paseoEnBiciRecursivo(vertice1, vertice2, lugares, maxTiempo, 0, lugaresRestringidos,new boolean [lugares.getSize()], lista);
		return lista;
	}
	
	private boolean paseoEnBiciRecursivo (Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, int maxTiempo, int tiempoUsado, List<String> lugaresRestringidos, boolean [] marcas, List<String> camino) {
		boolean ok = false;
		marcas[vertice1.getPosition()] = true;
		camino.add(vertice1.getData());
		if(vertice1 == vertice2)
			return true;
		List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
		Iterator<Edge<String>> it = adyacentes.iterator();
		while(it.hasNext() && !ok) {
			Edge<String> arista = it.next();
			Vertex<String> verticeActual = arista.getTarget();
			int tiempoActual = tiempoUsado + arista.getWeight();
			if(!marcas[verticeActual.getPosition()] && !lugaresRestringidos.contains(verticeActual.getData()) && tiempoActual <= maxTiempo) {
				ok = paseoEnBiciRecursivo(verticeActual, vertice2, grafo, maxTiempo, tiempoActual, lugaresRestringidos, marcas, camino);
			}
		}
		if(!ok)
			camino.remove(camino.size()-1);
		marcas[vertice1.getPosition()] = false;
		return ok;
	}
}

