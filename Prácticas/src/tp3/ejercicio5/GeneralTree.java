package tp3.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public List<T> preOrden(){
		List<T> lista = new LinkedList<T>();
		this.preOrden(lista);
		return lista;
	}
	
	private void preOrden(List<T> l) {
		l.add(this.getData());
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child: children)
			child.preOrden(l);
		
	}
	
	//se podria hacer un recorrido por niveles y contar cuantos tiene, pero si piden el camino debería cambiar toda la implementación
	public int altura() {	 
		if(!this.isEmpty())
			return alturaRecursiva(this);
		return 0;
	}
	
	private int alturaRecursiva(GeneralTree<T> arbol) {
		if(arbol.isLeaf())
			return 0;
		int alturaMax = 0;
		for (GeneralTree<T> child: arbol.getChildren())
				alturaMax = Math.max(alturaMax, alturaRecursiva(child));
		return 1 + alturaMax;
	}
	
	public int nivel(T dato){
		int nivel = 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree<T> arbolAux = cola.dequeue();
			if(arbolAux != null) {
				if(arbolAux.getData().equals(dato)) //creo que va equals
					return nivel;
				for(GeneralTree<T> child: arbolAux.getChildren()) {
					cola.enqueue(child);
			    }
			}
			else if(!cola.isEmpty()) {
				nivel ++;
				cola.enqueue(null);	
			}
		}
		return 0;
	  }

	//No hace falta hacerlo con separadores, con size alcanza 
	public int ancho(){
		if(this.isEmpty())
			return 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		int maxNodos = 0;
		while(!cola.isEmpty()) {
			int cantNivelActual = cola.size();
			if(cantNivelActual > maxNodos)
				maxNodos = cantNivelActual;
			for(int i = 0; i< cantNivelActual; i++) {
				GeneralTree<T> arbolAux = cola.dequeue();
				for(GeneralTree<T> child: arbolAux.getChildren())
					cola.enqueue(child);
			}
		}
		return maxNodos;
	  }
	
	public boolean esAncestro(T a, T b) {
		if(this.isEmpty())
			return false;
		return esAncestroRecursivo(a,b,this);
	}
	
	private GeneralTree<T> retornarArbol(T a, GeneralTree<T> arbol){
		if(arbol.getData().equals(a))
			return arbol;
		for(GeneralTree<T> child: arbol.getChildren()) {
			GeneralTree<T> result = retornarArbol(a, child);
	        if (result != null) 
	            return result;
		}
	    return null;
	}
	
	private boolean esAncestroRecursivo(T a, T b, GeneralTree<T> arbol) {
		if(retornarArbol(a, arbol) == null)
			return false;
		return recorrerSubArbol(b, arbol);
	}
	
	private boolean recorrerSubArbol(T b, GeneralTree<T> arbol) {
		if(arbol.getData().equals(b))
			return true;
		for(GeneralTree<T> child: arbol.getChildren()) {
			if(recorrerSubArbol(b, child))
				return true;
		}
		return false;	
	}
}