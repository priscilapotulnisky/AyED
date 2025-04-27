package tp2.ejercicio7;
import tp2.ejercicio1.*;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	//La idea de este método es encontrar el nodo buscado y retornar su subarbol
	private BinaryTree<Integer> retornarSubArbolBuscado(BinaryTree<Integer> arbol, int num){
		BinaryTree<Integer> resultadoDer;
		BinaryTree<Integer> resultadoIzq;
		
		if(arbol.getData() == num) 
			return arbol;
		if(arbol.hasLeftChild()) {
			resultadoIzq = retornarSubArbolBuscado(arbol.getLeftChild(), num);
			if(resultadoIzq != null)
				return resultadoIzq;
		}
		if(arbol.hasRightChild()) {
			resultadoDer = retornarSubArbolBuscado(arbol.getRightChild(), num);
			if(resultadoDer != null)
				return resultadoDer;
		}
		return null;
	}
	
	private int sumar (BinaryTree<Integer> arbol) {
		if(arbol == null)
			return -1;
		int suma = 0;
		if((arbol.hasLeftChild() && !arbol.hasRightChild() || (arbol.hasRightChild() && !arbol.hasLeftChild())))
			suma += 1;
		if(arbol.hasLeftChild()) 
			suma += sumar(arbol.getLeftChild());
		if(arbol.hasRightChild())
			suma += sumar(arbol.getRightChild());
		return suma;
	}
	
	public boolean isLeftTree(int num) {
		if(this.arbol == null || arbol.isEmpty()) 
			return false;
		BinaryTree<Integer> arbolResult = retornarSubArbolBuscado(this.arbol, num);
		if(arbolResult == null)
			return false;
		int sumaDer = 0;
		int sumaIzq = 0;
		if(arbolResult.hasLeftChild())
			sumaIzq = sumar(arbolResult.getLeftChild());
		if(arbolResult.hasRightChild())
			sumaDer = sumar(arbolResult.getRightChild());
		return sumaIzq > sumaDer;
	}
	
}	

