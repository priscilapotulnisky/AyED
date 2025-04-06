package tp2.ejercicio3;
import tp2.ejercicio1.*;
import java.util.*;
public class ContadorArbol {

	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol){
		this.arbol = arbol;
	}
	
	public List<Integer> numerosPares(){
		List<Integer> lista = new ArrayList<>();
		if (!this.arbol.isEmpty()) 
			numerosParesRecursivo(lista, this.arbol);		 
		return lista;
	}
	
	private void numerosParesRecursivo(List<Integer> lista, BinaryTree<Integer> arbol){ //Preorden
		if(arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
		if(arbol.hasLeftChild())
			numerosParesRecursivo(lista, arbol.getLeftChild());
		if(arbol.hasRightChild())
			numerosParesRecursivo(lista, arbol.getRightChild());
	}
	
	public List<Integer> numerosParesInOrden() {
		List<Integer> lista = new ArrayList<>();
		if(!this.arbol.isEmpty())
			numerosParesRecursivoInOrden(lista, this.arbol);
		return lista;
	}
	
	private void numerosParesRecursivoInOrden(List<Integer> lista, BinaryTree<Integer> arbol){ //InOrden
		if(arbol.hasLeftChild())
			numerosParesRecursivoInOrden(lista, arbol.getLeftChild());
		if(arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
		if(arbol.hasRightChild())
			numerosParesRecursivoInOrden(lista, arbol.getRightChild());
	}
	
	public List<Integer> numerosParesPostOrden(){
		List<Integer> lista = new ArrayList<>();
		if(!this.arbol.isEmpty())
			numerosParesRecursivoPostOrden(lista, this.arbol);
		return lista;
	}
	
	private void numerosParesRecursivoPostOrden(List<Integer> lista, BinaryTree<Integer> arbol){ //PostOrden
		if(arbol.hasLeftChild())
			numerosParesRecursivoPostOrden(lista, arbol.getLeftChild());
		if(arbol.hasRightChild())
			numerosParesRecursivoPostOrden(lista, arbol.getRightChild());
		if(arbol.getData() % 2 == 0)
			lista.add(arbol.getData());
	}
	
	
}
