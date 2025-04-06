package tp2.ejercicio4;
import tp2.ejercicio1.*;
public class RedBinariaLlena {

	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	public int retardoReenvio() {
		if(arbol.isEmpty())
			return 0;
		return maximo(0, this.arbol);
	}
	
	private int maximo(int suma, BinaryTree<Integer> arbol) {
		suma += arbol.getData();
		if (arbol.isLeaf()) {
			return suma;
		}
		int maxIzq = 0;
		int maxDer = 0;
		if(arbol.hasLeftChild())
			maxIzq = maximo(suma, arbol.getLeftChild());
		if(arbol.hasRightChild())
			maxDer = maximo(suma, arbol.getRightChild());
		return Math.max(maxIzq, maxDer);
	}
}
