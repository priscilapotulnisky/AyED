package tp5.ejercicio3;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;
public class MapaTest {

	public static void main(String [] args) {
		Graph<String> grafo = new AdjListGraph<String>();
		Vertex<String> bsas = grafo.createVertex("Buenos Aires");
		Vertex<String> asuncion = grafo.createVertex("Asuncion");
		Vertex<String> santiago = grafo.createVertex("Santiago");
		Vertex<String> roma = grafo.createVertex("Roma");
		Vertex<String> madrid = grafo.createVertex("Madrid");
		Vertex<String> caracas = grafo.createVertex("Caracas");
		Vertex<String> tokio = grafo.createVertex("Tokio");
		Vertex<String> paris = grafo.createVertex("Paris");
		
		grafo.connect(bsas, santiago, 3);
		grafo.connect(bsas, asuncion, 6);
		grafo.connect(santiago, roma, 4);
		grafo.connect(roma, tokio, 80);
		grafo.connect(tokio, bsas, 10);
		grafo.connect(asuncion, madrid, 10);
		grafo.connect(asuncion, caracas, 2);
		grafo.connect(caracas, tokio, 2);
		grafo.connect(caracas, madrid, 2);
		grafo.connect(madrid, tokio, 60);
		grafo.connect(paris, roma, 4);
		grafo.connect(paris, madrid, 65);
		grafo.connect(paris, tokio, 35);
		
		Mapa m = new Mapa(grafo);
		System.out.println(m.devolverCaminos("Buenos Aires", "Tokio"));
		List<String> listaCiudades = new LinkedList<>();
		listaCiudades.add("Santiago");
		System.out.println(m.devolverCaminoExceptuando("Buenos Aires", "Tokio", listaCiudades));
		
	}
}
