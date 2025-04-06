package tp2.ejercicio3;
import tp2.ejercicio1.*;
import java.util.*;
public class Test {

	public static void main (String [] args) {
		BinaryTree<Integer> arbol = new BinaryTree<>(1);
		arbol.addLeftChild(new BinaryTree<Integer>(2));
		arbol.addRightChild(new BinaryTree<Integer>(4));
		arbol.getLeftChild().addLeftChild(new BinaryTree<Integer>(6));
		arbol.getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		arbol.getRightChild().addLeftChild(new BinaryTree<Integer>(7));
		arbol.getRightChild().addRightChild(new BinaryTree<Integer>(20));
		
		ContadorArbol ca = new ContadorArbol(arbol);
		//PreOrden
		List<Integer> lista = ca.numerosPares();
		System.out.println("-----PreOrden-----");
		System.out.print(lista);
		System.out.println();
		//InOrden
		lista = ca.numerosParesInOrden();
		System.out.println("-----InOrden-----");
		System.out.println(lista);
		//PostOrden
		lista = ca.numerosParesPostOrden();
		System.out.println("-----PostOrden-----");
		System.out.println(lista);
	}
}
