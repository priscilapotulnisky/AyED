package parcial.ej1;
import tp3.ejercicio5.GeneralTree;
import java.util.*;
import tp1.ejercicio8.Queue;
public class ParcialArboles {

	private GeneralTree<Integer> arbol;
	
	public ParcialArboles(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> nivel (int num){
		if(this.arbol.isEmpty())
			return new LinkedList<Integer>();
		List<Integer> lista = new ArrayList<Integer>();
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		int cumple = 0;
		int cantidadNodosNivel = 0;
		while(!cola.isEmpty()) {
			GeneralTree<Integer> arbolAux = cola.dequeue();
			if(arbolAux != null) {
				cantidadNodosNivel ++;
				if(arbolAux.getChildren().size() >= num) {
					lista.add(arbolAux.getData());
					cumple ++;
				}
				for(GeneralTree<Integer> child: arbolAux.getChildren()) {
					cola.enqueue(child);
				}
			}else if(!cola.isEmpty()) {
				if(cantidadNodosNivel == cumple) 
					return lista;
				else {
					lista.clear();
					cumple = 0;
					cantidadNodosNivel = 0;
				}
				cola.enqueue(null);
			}
		}
		return lista;
		
		
	}
}
