package tp2.ejercicio2;
import tp2.ejercicio1.*;
public class Test {

	public static void main (String [] args) {
		// Paso 1: Crear el árbol y agregar hijos izquierdo y derecho
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		arbol.addLeftChild(new BinaryTree<>(2));
		arbol.addRightChild(new BinaryTree<>(3));
		arbol.getRightChild().addLeftChild(new BinaryTree<>(4));
		arbol.getRightChild().addRightChild(new BinaryTree<>(5));
		arbol.getLeftChild().addLeftChild(new BinaryTree<>(6));
		System.out.print("Cantidad de hojas del arbol: ");
		System.out.println("  "+ arbol.contarHojas());
		
		BinaryTree<Integer> arbol2 = arbol.espejo();
		arbol.entreNiveles(0, 1);
		System.out.println();
		arbol2.entreNiveles(0, 2);
	}
	
}
