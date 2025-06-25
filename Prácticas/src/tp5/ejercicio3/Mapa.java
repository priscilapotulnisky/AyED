package tp5.ejercicio3;
import tp5.ejercicio1.*;
import java.util.*;
public class Mapa {

	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	//tiene que ser recursivo para encontrar el camino. Usar dfs
	public List<String> devolverCaminos(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<>();
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
			if(v1 != null && v2 != null)
				devolverCaminosRecursivo(v1, v2, this.mapaCiudades, lista, new boolean [this.mapaCiudades.getSize()]);
		}
		return lista;
	}
	
	//recibe dos vertices que serían las ciudades
	private boolean devolverCaminosRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, List<String> lista, boolean [] marcas) {
		boolean ok = false;
		marcas[vertice1.getPosition()] = true;
		lista.add(vertice1.getData());
		if(vertice1 == vertice2) 
			return true;
		List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
		Iterator<Edge<String>> it = adyacentes.iterator();
		while(it.hasNext() && !ok) {
			Vertex<String> verticeActual = it.next().getTarget();
			int j = verticeActual.getPosition();
			if(!marcas[j]) {
				ok = devolverCaminosRecursivo(verticeActual, vertice2, grafo, lista, marcas);
			}
		}
		if(!ok)
			lista.remove(lista.size()-1);
		marcas[vertice1.getPosition()] = false;
		return ok;
			
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		List<String> lista = new LinkedList<>();
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
			if(v1 != null && v2 != null) {
				Vertex<String> santiago = this.mapaCiudades.search("Santiago");
				marcas[santiago.getPosition()] = true;
				devolverCaminosRecursivo(v1, v2, this.mapaCiudades, lista, marcas);
			}
		}
		return lista;
	}
	
	private boolean devolverCaminoExceptuandoRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, List<String> lista, boolean [] marcas) {
		boolean ok = false;
		marcas[vertice1.getPosition()] = true;
		lista.add(vertice1.getData());
		if(vertice1 == vertice2) 
			return true;
		List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
		Iterator<Edge<String>> it = adyacentes.iterator();
		while(it.hasNext() && !ok) {
			Vertex<String> verticeActual = it.next().getTarget();
			/*if(ciudades.contains(vertice1.getData())) {
				return true;
			}*/
			int j = verticeActual.getPosition();
			if(!marcas[j]) {
				ok = devolverCaminoExceptuandoRecursivo(verticeActual, vertice2, grafo, lista, marcas);
			}
		}
		if(!ok) {
			lista.remove(lista.size()-1);
		}
		marcas[vertice1.getPosition()] = false;
		return ok;
			
	}
	
}
