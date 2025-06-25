package tp5.ejercicio2;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

public class RecorridosTest {
	public static void main (String[] args) {
		Graph<Integer> numeros = new AdjListGraph<Integer>();
		Recorridos<Integer> r = new Recorridos <Integer>();
		Vertex<Integer> v1 = numeros.createVertex(1);
		Vertex<Integer> v2 = numeros.createVertex(2);
		Vertex<Integer> v3 = numeros.createVertex(3);
		Vertex<Integer> v4 = numeros.createVertex(4);
		Vertex<Integer> v5 = numeros.createVertex(5);
		Vertex<Integer> v6 = numeros.createVertex(6);
		Vertex<Integer> v7 = numeros.createVertex(7);
		numeros.connect(v1, v2);
		numeros.connect(v1, v3);
		numeros.connect(v1, v4);
		numeros.connect(v2, v5);
		numeros.connect(v3, v5);
		numeros.connect(v4, v2);
		numeros.connect(v4, v3);
		numeros.connect(v4, v5);
		numeros.connect(v4, v6);
		numeros.connect(v5, v7);
		numeros.connect(v6, v3);
		numeros.connect(v6, v7);
		
		System.out.println(r.dfs(numeros));
		System.out.println(r.bfs(numeros));
		
	}
}
