package tp5.ejercicio3;
import tp5.ejercicio1.*;
import java.util.*;
public class Mapa {

	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	//tiene que ser recursivo para encontrar el camino. Usar dfs
	//----------------------- INCISO A -----------------------------
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
		
		
		
		return ok;
			
	}
	
	//---------------------- INCISO B ------------------------------------------
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		List<String> lista = new LinkedList<>();
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
			if(v1 != null && v2 != null) 
				devolverCaminoExceptuandoRecursivo(v1, v2, this.mapaCiudades, lista, marcas, ciudades);
		}
		return lista;
	}
	
	
	private boolean devolverCaminoExceptuandoRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, List<String> lista, boolean [] marcas, List<String> ciudades) {
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
			if(!marcas[j] && !ciudades.contains(vertice1.getData())) {
				ok = devolverCaminoExceptuandoRecursivo(verticeActual, vertice2, grafo, lista, marcas, ciudades);
			}
		}
		if(!ok)
			lista.remove(lista.size()-1);
		return ok;
			
	}
	
	//---------------------- INCISO C ---------------------------------
	
	//Sacar un minimo entre todos los caminos del grafo desde ciudad1 hasta ciudad2
	//usar dfs y guardar una lista con el camino actual y otra con el minimo
	//tambien se podria hacer con una lista de listas y despues sacar el minimo entre los recorridos que quedaron almacenados
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
			if(v1 != null && v2 != null)
				caminoMasCortoRecursivo(v1, v2, this.mapaCiudades, lista, new LinkedList<String>(), marcas, 9999, 0);
			
		}
		return lista;
	}
	
	private int caminoMasCortoRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, List<String> caminoMinimo, List<String> caminoActual, boolean [] marcas, int min, int cont) {
		marcas[vertice1.getPosition()] = true;
		caminoActual.add(vertice1.getData());
		if(vertice1 == vertice2) { //caso base, si ya llegué a la ciudad2. cortar el recorrido
			caminoMinimo.clear();
			caminoMinimo.addAll(caminoActual);
			min = cont;
		} 
		else {
			List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
			Iterator<Edge<String>> it = adyacentes.iterator();
			while(it.hasNext()) {
				Edge<String> verticeActual = it.next();
				int j = verticeActual.getTarget().getPosition();
				int aux = cont + verticeActual.getWeight();
				if(!marcas[j] && aux < min)
					min = caminoMasCortoRecursivo(verticeActual.getTarget(), vertice2, grafo, caminoMinimo, caminoActual, marcas, min, aux);
			}
		}
		marcas[vertice1.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		return min;
	}
	
	
	//Acá la opcion de hacerlo con una lista de listas 
	public List<String> caminoMasCortoOpcion2(String ciudad1, String ciudad2) {
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		List<String> caminoMin = new LinkedList<>();
		Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
		Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
		if(v1 != null && v2 != null) 
			caminoMin = caminoMinimo(buscarCaminosPosibles(v1, v2, this.mapaCiudades, new LinkedList<>(), new LinkedList<>(), marcas));
		return caminoMin;
	}
	
	
	private List<List<String>> buscarCaminosPosibles(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, List<String> caminoActual, List<List<String>> todosLosCaminos, boolean[] marcas) {
			marcas[vertice1.getPosition()] = true;
			caminoActual.add(vertice1.getData());
			if (vertice1 == vertice2) {                  
				todosLosCaminos.add(new LinkedList<>(caminoActual)); 
			} else {                                  
				for (Edge<String> e : grafo.getEdges(vertice1)) {
					Vertex<String> verticeActual = e.getTarget();
					if (!marcas[verticeActual.getPosition()]) 
						todosLosCaminos = buscarCaminosPosibles(verticeActual, vertice2, grafo, caminoActual, todosLosCaminos, marcas);
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			marcas[vertice1.getPosition()] = false;
			return todosLosCaminos;
	}
	
	private List<String> caminoMinimo(List<List<String>> todosLosCaminos){
		List<String> caminoMasCorto = new LinkedList<>();
		if(!todosLosCaminos.isEmpty()) {
			int minimo = Integer.MAX_VALUE;
			for(List<String> caminoActual: todosLosCaminos) {
				int total = 0;
				for(int i = 0; i < caminoActual.size() -1; i++) {
					String origen = caminoActual.get(i);
					String destino = caminoActual.get(i + 1);
					Vertex<String> v = this.mapaCiudades.search(origen);
					Vertex<String> v2 = this.mapaCiudades.search(destino);
					total +=  this.mapaCiudades.weight(v, v2);
				}
				if(total < minimo) {
					minimo = total;
					caminoMasCorto = new LinkedList<>(caminoActual);
				}
					
			}
		}
		return caminoMasCorto;
	}
	
	//---------------------- INCISO D ---------------------------------
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new LinkedList<>();
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
		Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
		if(v1 != null && v2 != null)
			caminoSinCargarCombustibleRecursivo(v1, v2, this.mapaCiudades, tanqueAuto, 0, camino, marcas);
		return camino;
	}
	
	
	private boolean caminoSinCargarCombustibleRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo, int tanque,int totalUsado, List<String> lista, boolean [] marcas) {
		boolean ok = false;
		marcas[vertice1.getPosition()] = true;
		lista.add(vertice1.getData());
		if(vertice1 == vertice2)
			return true;
		List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
		Iterator<Edge<String>> it = adyacentes.iterator();
		while(it.hasNext() && !ok) {
			Edge<String> verticeActual = it.next();
			int aux = totalUsado + verticeActual.getWeight();
			if(!marcas[verticeActual.getTarget().getPosition()] && aux <= tanque) 
				ok = caminoSinCargarCombustibleRecursivo(verticeActual.getTarget(), vertice2, grafo, tanque, aux, lista, marcas);
				
		}
		if(!ok)
			lista.remove(lista.size()-1);
		marcas[vertice1.getPosition()] = false;
		return ok;
	}
	
	//---------------------- INCISO E ---------------------------------
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> lista = new LinkedList<>();
		boolean [] marcas = new boolean [this.mapaCiudades.getSize()];
		Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
		Vertex<String> v2 = this.mapaCiudades.search(ciudad2);
		if(v1 != null && v2 != null)
			caminoConMenorCargaDeCombustibleRecursivo(v1,v2, this.mapaCiudades, tanqueAuto,tanqueAuto, marcas, 0, Integer.MAX_VALUE,new LinkedList<>(), lista);
		return lista;
	}
	
	
	private int caminoConMenorCargaDeCombustibleRecursivo(Vertex<String> vertice1, Vertex<String> vertice2, Graph<String> grafo,int capacidad, int tanque, boolean [] marcas, int cantCargas, int cargaMin, List<String> listaActual, List<String> listaMin) {
		marcas[vertice1.getPosition()] = true;
		listaActual.add(vertice1.getData());
		if(vertice1 == vertice2 && cantCargas < cargaMin) {
			cargaMin = cantCargas;
			listaMin.clear();
			listaMin.addAll(new LinkedList<String>(listaActual));
		}else {
			List<Edge<String>> adyacentes = grafo.getEdges(vertice1);
			Iterator<Edge<String>> it = adyacentes.iterator();
			while(it.hasNext()) {
				Edge<String> verticeActual = it.next();
				if(!marcas[verticeActual.getTarget().getPosition()] && cantCargas <= cargaMin)
					if(tanque - verticeActual.getWeight() < 0) 
						cargaMin = caminoConMenorCargaDeCombustibleRecursivo(verticeActual.getTarget(), vertice2, grafo,capacidad, capacidad - verticeActual.getWeight(), marcas, cantCargas+1, cargaMin, listaActual, listaMin);
					else if (capacidad - verticeActual.getWeight() >= 0)
						cargaMin = caminoConMenorCargaDeCombustibleRecursivo(verticeActual.getTarget(), vertice2, grafo, capacidad, tanque - verticeActual.getWeight(), marcas, cantCargas, cargaMin, listaActual, listaMin);
			}
		}
		listaActual.remove(listaActual.size()-1);
		marcas[vertice1.getPosition()] = false;
		return cargaMin;
	}

}
