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
		grafo.connect(caracas, madrid, 2);
		grafo.connect(madrid, tokio, 60);
		grafo.connect(paris, roma, 4);
		grafo.connect(paris, madrid, 65);
		grafo.connect(paris, tokio, 35);
		
		Mapa m = new Mapa(grafo);
		//--------INCISO A-------
		System.out.println(m.devolverCaminos("Buenos Aires", "Tokio"));
		//--------INCISO B-------
		List<String> listaCiudades = new LinkedList<>();
		listaCiudades.add("Roma");
		listaCiudades.add("Madrid");
		listaCiudades.add("Tokio");
		System.out.println(m.devolverCaminoExceptuando("Paris", "Buenos Aires", listaCiudades));
		//--------INCISO C-------
		System.out.println(m.caminoMasCorto("Buenos Aires", "Tokio"));
		System.out.println(m.caminoMasCortoOpcion2("Buenos Aires", "Tokio"));
		//--------INCISO D-------
		System.out.println(m.caminoSinCargarCombustible("Paris", "Buenos Aires", 45));
		//--------INCISO E-------
		System.out.println(m.caminoConMenorCargaDeCombustible("Tokio","Madrid", 20));
		
	}
	
}
