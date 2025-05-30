package tp3.ejercicio2;
import tp3.ejercicio1.GeneralTree;
import java.util.*;
public class Test {
	 public static void main(String[] args) {
		// Crear los nodos
	    GeneralTree<Integer> a1 = new GeneralTree<>(1); // Raíz
	    GeneralTree<Integer> a2 = new GeneralTree<>(2); // Hijo de la raíz
	    GeneralTree<Integer> a3 = new GeneralTree<>(31); // Hijo de la raíz
	    GeneralTree<Integer> a4 = new GeneralTree<>(45); // Hijo de la raíz
	    GeneralTree<Integer> a5 = new GeneralTree<>(29); // Hijo de a2
	    GeneralTree<Integer> a6 = new GeneralTree<>(50); // Hijo de a2
	    GeneralTree<Integer> a7 = new GeneralTree<>(123); // Hijo de a3
	    GeneralTree<Integer> a8 = new GeneralTree<>(53); // Hijo de a3

	    // Agregar hijos a los nodos correspondientes
	    List<GeneralTree<Integer>> hijosRaiz = new LinkedList<>();
	    hijosRaiz.add(a2);
	    hijosRaiz.add(a3);
	    hijosRaiz.add(a4);
	    a1.setChildren(hijosRaiz);

	    List<GeneralTree<Integer>> hijosA2 = new LinkedList<>();
	    hijosA2.add(a5);
	    hijosA2.add(a6);
	    a2.setChildren(hijosA2);

	    List<GeneralTree<Integer>> hijosA3 = new LinkedList<>();
	    hijosA3.add(a7);
	    hijosA3.add(a8);
	    a3.setChildren(hijosA3);
	    
	    System.out.println(a1.preOrden()); //para chequear si el árbol está bien cargado
	    
	    
	    RecorridosAG rAg = new RecorridosAG();
	    
	    System.out.println(rAg.numerosImparesMayoresQueInOrden(a1, 1));
	    System.out.println(rAg.numerosImparesMayoresQuePostOrden(a1, 1));
	    System.out.println(rAg.numerosImparesMayoresQuePreOrden(a1, 1));
	    System.out.println(rAg.numerosImparesMayoresQuePorNiveles(a1, 1));
	    
	 }
	
     
}
