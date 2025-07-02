package tp5.ejercicio6;

import tp5.ejercicio1.*;
import java.util.*;

public class BuscadorDeCaminos {
	
	private Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	
	public List<List<String>> recorridosMasSeguros(){
		List<List<String>> caminos = new LinkedList<>();
		Vertex<String> caperucita = this.bosque.search("Casa Caperucita");
		Vertex<String> abuelita = this.bosque.search("Casa Abuelita");
		if(!this.bosque.isEmpty()) {
			boolean [] marcas = new boolean [this.bosque.getSize()];
			if(caperucita != null && abuelita != null) {
				recorridosMasSeguros(caperucita, abuelita, marcas, caminos, new LinkedList<>());
				recorridosMasSeguros2(caperucita, abuelita, marcas, caminos, new LinkedList<>());	
			}
		}
		return caminos;
	}
	
	//implementado con un for 
	private void recorridosMasSeguros(Vertex<String> caperucita, Vertex<String> abuelita, boolean[] marcas, List<List<String>> caminos, List<String> caminoActual) {
		marcas[caperucita.getPosition()] = true;
		caminoActual.add(caperucita.getData());
		if(caperucita.getData().equals(abuelita.getData()))
			caminos.add(new LinkedList<>(caminoActual));
		List<Edge<String>> adyacentes = this.bosque.getEdges(caperucita);
		for(Edge<String> adyacente: adyacentes) {
			Vertex<String> destino = adyacente.getTarget();
			if(!marcas[destino.getPosition()] && adyacente.getWeight() <= 5)
				recorridosMasSeguros(destino, abuelita, marcas, caminos, caminoActual);
			
		}
		marcas[caperucita.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		
	}
	
	//implementado con un while e iterator
	private void recorridosMasSeguros2(Vertex<String> caperucita, Vertex<String> abuelita, boolean[] marcas, List<List<String>> caminos, List<String> caminoActual) {
		marcas[caperucita.getPosition()] = true;
		caminoActual.add(caperucita.getData());
		if(caperucita.getData().equals(abuelita.getData()))
			caminos.add(new LinkedList<>(caminoActual));
		List<Edge<String>> adyacentes = this.bosque.getEdges(caperucita);
		Iterator<Edge<String>> it = adyacentes.iterator();
		while(it.hasNext()) {
			Edge<String> sendero = it.next();
			Vertex<String> verticeActual = sendero.getTarget();
			if(!marcas[verticeActual.getPosition()] && sendero.getWeight() < 5)
				recorridosMasSeguros2(verticeActual, abuelita, marcas, caminos, caminoActual);
		}
		caminoActual.remove(caminoActual.size()-1);
		marcas[caperucita.getPosition()] = false;
	}
	
	
	
}
