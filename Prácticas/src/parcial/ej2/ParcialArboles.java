package parcial.ej2;
import tp2.ejercicio1.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private BinaryTree<Integer> retornarArbol(BinaryTree<Integer> arbol, int num){
		BinaryTree<Integer> result = new BinaryTree<Integer>();
		if(arbol.getData().equals(num))
			return arbol;
		if(arbol.hasLeftChild()) {
			result = retornarArbol(arbol.getLeftChild(), num);
			if(result != null)
				return result;
		}
		if(arbol.hasRightChild()) {
			result = retornarArbol(arbol.getRightChild(), num);
			if(result != null)
				return result;
		}
		return null;	
	}
	
	
	//falta que retorne -1 si no tiene alguna de las ramas 
	private int sumar(BinaryTree<Integer> arbol) {
		if(arbol == null)
			return -1;
		int ladoDer = 0;
		int ladoIzq = 0;
		if(arbol.hasLeftChild()) {
			if(arbol.getLeftChild().hasLeftChild() && (arbol.getLeftChild().hasRightChild())) 
				ladoIzq ++;
			ladoIzq += sumar(arbol.getLeftChild());
		}
		if(arbol.hasRightChild()) {
			if(arbol.getRightChild().hasLeftChild() && arbol.getRightChild().hasRightChild()) 
				ladoDer ++;
			ladoDer += sumar(arbol.getRightChild());
		}
		if(ladoDer == ladoIzq)
			return 0;
		return -1;
	}
	
	public Boolean isTwoTree(int num) {
		if(this.arbol.isEmpty())
			return false;
		if(sumar(retornarArbol(this.arbol,num)) == 0)
			return true;
		return false;
	}
	
}
