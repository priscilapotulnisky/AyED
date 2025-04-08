package tp2.ejercicio6;
import tp2.ejercicio1.*;
public class Transformacion { 
	
	//probar también si se puede hacer un método privado que retorne la suma y otro que arme el arbol nuevo
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		if(arbol.isEmpty())
			return null;
		return sumaRecursiva(this.arbol);
	}
	
	private BinaryTree<Integer> sumaRecursiva(BinaryTree<Integer> arbol) {
		if(arbol.isLeaf())
			return new BinaryTree<Integer> (0);
		BinaryTree<Integer> izq = null;
		BinaryTree<Integer> der = null;
		int suma = 0;
		if(arbol.hasLeftChild()) {
			izq = sumaRecursiva(arbol.getLeftChild());
			suma += izq.getData();
			suma += arbol.getLeftChild().getData();
		}
		if(arbol.hasRightChild()) {
			der = sumaRecursiva(arbol.getRightChild());
			suma += der.getData();
			suma += arbol.getRightChild().getData();
		}
		BinaryTree<Integer> arbolFinal = new BinaryTree<Integer>(suma);
		arbolFinal.addLeftChild(izq);
		arbolFinal.addRightChild(der);
		return arbolFinal;
		
	}
}
