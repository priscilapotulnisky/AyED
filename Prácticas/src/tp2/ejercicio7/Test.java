package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;
public class Test {
	
	
	public static void main (String [] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(2);
		arbol.addLeftChild(new BinaryTree<Integer>(7));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		arbol.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		arbol.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		arbol.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		arbol.addRightChild(new BinaryTree<Integer>(-5));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
		arbol.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arbol.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
		
		ParcialArboles parcial = new ParcialArboles(arbol);
		System.out.println(parcial.isLeftTree(7));
	}

}
