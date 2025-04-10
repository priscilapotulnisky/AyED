package tp2.ejercicio6v2;
import tp2.ejercicio1.*;
public class Transformacion {
	
	//transformando el mismo arbol
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		if(arbol.isEmpty())
			return null;
		sumaRecursiva(this.arbol);
		return this.arbol;
	}
	
	private int sumaRecursiva(BinaryTree<Integer> arbol){
		int suma = 0;
		if(arbol.isLeaf()) {
			int valor = arbol.getData();
			arbol.setData(0);
			return valor;
		}
		if(arbol.hasLeftChild()) 
			suma+= sumaRecursiva(arbol.getLeftChild());
		if(arbol.hasRightChild()) 
			suma+= sumaRecursiva(arbol.getRightChild());
		int valorOriginal = arbol.getData();
		arbol.setData(suma);
		return suma + valorOriginal;
	}
}
