package tp2.ejercicio6v3;
import tp2.ejercicio1.*;
public class Transformacion {
	
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma (){
		if(this.arbol.isEmpty())
			return null;
		return armarArbol(this.arbol);
	}
	private int sumaRecursiva(BinaryTree<Integer> arbol) {
		int suma = 0;
		if(arbol.isLeaf())
			return 0;
		if(arbol.hasLeftChild())
			suma+= arbol.getLeftChild().getData() + sumaRecursiva(arbol.getLeftChild()) ;
		if(arbol.hasRightChild())
			suma+= arbol.getRightChild().getData() + sumaRecursiva(arbol.getRightChild());
		return suma;
	}
	
	private BinaryTree<Integer> armarArbol(BinaryTree<Integer> arbol){
		if(arbol.isLeaf())
			new BinaryTree<Integer>(0);
		
		BinaryTree<Integer> arbolResultante = new BinaryTree<>(sumaRecursiva(arbol));
		if (arbol.hasLeftChild()) {
			arbolResultante.addLeftChild(armarArbol(arbol.getLeftChild()));
		}
		if (arbol.hasRightChild()) {
			arbolResultante.addRightChild(armarArbol(arbol.getRightChild()));
		}

		return arbolResultante;
	}
}
