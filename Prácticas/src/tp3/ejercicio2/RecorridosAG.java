package tp3.ejercicio2;
import tp3.ejercicio1.*;
import tp1.ejercicio8.Queue;
import java.util.*;
public class RecorridosAG {

	//preOrden = se procesa primero la raiz, luego los hijos
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a != null && !a.isEmpty()) 
			numerosImparesMayoresQuePreOrdenRecursivo(a, n, lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePreOrdenRecursivo(GeneralTree<Integer> arbol, Integer n, List<Integer> lista){
		if ((arbol.getData() > n) && ((arbol.getData() % 2) !=0)) 
	        lista.add(arbol.getData());
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for (GeneralTree<Integer> child: children) 
			numerosImparesMayoresQuePreOrdenRecursivo(child, n, lista);
	}
	
	//InOrden = primero el primer hijo, luego la raiz y por ultimo el resto de los hijos
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a != null && !a.isEmpty())
			numerosImparesMayoresQueInOrdenRecursivo(a, n, lista);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrdenRecursivo(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> children = arbol.getChildren();
		if(!children.isEmpty()) {
			numerosImparesMayoresQueInOrdenRecursivo(children.get(0), n, lista);
		}
		if(arbol.getData() % 2 != 0 && arbol.getData() > n)
			lista.add(arbol.getData());
		
		for(int i = 1; i < children.size(); i++)
			numerosImparesMayoresQueInOrdenRecursivo(children.get(i), n, lista);
	}
	
	//PostOrden = primero los hijos y luego la raíz
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a != null && !a.isEmpty())
			numerosImparesMayoresQuePostOrdenRecursivo(a, n, lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrdenRecursivo(GeneralTree<Integer> arbol, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> children = arbol.getChildren();
		for(GeneralTree<Integer> child: children)
			numerosImparesMayoresQuePostOrdenRecursivo(child, n, lista);
		if(arbol.getData() % 2 != 0 && arbol.getData() > n)
			lista.add(arbol.getData());
	}
	
	//no hace falta implementarlo con separadores (en este caso)
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> result = new LinkedList<>();
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(a);
		//queue.enqueue(null);
		while (!queue.isEmpty()) {
			GeneralTree<Integer> arbolAux = queue.dequeue();
			//if(arbolAux != null) {
			if(arbolAux.getData() % 2 != 0 && arbolAux.getData() > n)
				result.add(arbolAux.getData());
			List<GeneralTree<Integer>> children = arbolAux.getChildren();
			for(GeneralTree<Integer> child: children)
				queue.enqueue(child);
			//else if(!queue.isEmpty()) {
				//queue.enqueue(null);
			//}
		}
		return result;
			
	}
	
}
