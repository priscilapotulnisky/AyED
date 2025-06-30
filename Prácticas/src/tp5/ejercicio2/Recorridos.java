package tp5.ejercicio2;

import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;
public class Recorridos<T> {

	
	
	//O(V+E) --> numero de vertices y numero de aristas
	public List<T> dfs (Graph<T> grafo){
		boolean [] marca = new boolean [grafo.getSize()];
		List<T> lista = new LinkedList<T>();
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!marca[i]) {
				System.out.println("Largo con: "+grafo.getVertex(i).getData());
				dfsRecursivo(i, grafo,lista, marca);
			}
		}
		return lista;
	}
	
	private void dfsRecursivo(int i, Graph<T> grafo, List<T> lista, boolean [] marca ) {
		marca[i] = true; 
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		List<Edge<T>> adyacentes = grafo.getEdges(v);
		for(Edge<T> e: adyacentes){
			int j = e.getTarget().getPosition();
			if(!marca[j]) {
				dfsRecursivo(j, grafo,lista, marca);
			}
		}
		
	}
	
	
	public List<T> bfs (Graph<T> grafo){
		boolean [] marca = new boolean [grafo.getSize()];
		List<T> lista = new LinkedList<>();
		for(int i = 0; i < grafo.getSize(); i++) {
			if(!marca[i]) {
				bfs(i, grafo, lista, marca);
			}
		}
		return lista;	
	}
	
	private void bfs(int i, Graph<T> grafo,List<T> lista, boolean [] marca) {
		Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		q.enqueue(grafo.getVertex(i));
		marca[i] = true;
		while(!q.isEmpty()) {
			Vertex<T> w = q.dequeue();
			lista.add(w.getData());
			List<Edge<T>> adyacentes = grafo.getEdges(w);
			for(Edge<T> e: adyacentes) {
				int j = e.getTarget().getPosition();
				if(!marca[j]) {
					marca[j] = true;
					q.enqueue(e.getTarget());
				}
			}
			
		}
	}
}
