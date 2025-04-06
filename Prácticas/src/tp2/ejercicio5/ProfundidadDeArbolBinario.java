package tp2.ejercicio5;
import tp2.ejercicio1.*;
import tp1.ejercicio8.*;
public class ProfundidadDeArbolBinario {

	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public int sumaElementosProfundidad(int p) {
		int nivel = 0;
		if(arbol.isEmpty())
			return 0;
		int suma = 0;
		Queue<BinaryTree<Integer>> cola = new Queue<>();
		BinaryTree<Integer> arbol;
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			arbol = cola.dequeue();
			if(arbol != null) {
				if(nivel == p)
					suma += arbol.getData();
				if (arbol.hasLeftChild()) 
					cola.enqueue(arbol.getLeftChild());
				if (arbol.hasRightChild()) 
					cola.enqueue(arbol.getRightChild());
			}
			else if (!cola.isEmpty()) {
	   	    	cola.enqueue(null); 
	   	    	nivel ++;
			}
		}
		return suma;
	}

	
}
