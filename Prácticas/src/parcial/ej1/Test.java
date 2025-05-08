package parcial.ej1;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class Test {
	public static void main (String[]args) {
		GeneralTree<Integer> a1 = new GeneralTree<>(10); // Raíz
		GeneralTree<Integer> a2 = new GeneralTree<>(8); // Hijo de la raíz
		GeneralTree<Integer> a3 = new GeneralTree<>(-5); // Hijo de la raíz
		GeneralTree<Integer> a4 = new GeneralTree<>(5); // Hijo de a2
		GeneralTree<Integer> a5 = new GeneralTree<>(22); // Hijo de a2
		GeneralTree<Integer> a6 = new GeneralTree<>(19); // Hijo de a3

		// Hijos de a4
		List<GeneralTree<Integer>> hijosA4 = new LinkedList<>();
		hijosA4.add(new GeneralTree<>(-6));
		hijosA4.add(new GeneralTree<>(2));
		hijosA4.add(new GeneralTree<>(8));
		a4.setChildren(hijosA4);

		// Hijos de a5
		List<GeneralTree<Integer>> hijosA5 = new LinkedList<>();
		hijosA5.add(new GeneralTree<>(28));
		hijosA5.add(new GeneralTree<>(55));
		hijosA5.add(new GeneralTree<>(18));
		a5.setChildren(hijosA5);

		// Hijos de a6
		List<GeneralTree<Integer>> hijosA6 = new LinkedList<>();
		hijosA6.add(new GeneralTree<>(4));
		hijosA6.add(new GeneralTree<>(2));
		hijosA6.add(new GeneralTree<>(8));
		a6.setChildren(hijosA6);

		// Agregar hijos a los nodos correspondientes
		List<GeneralTree<Integer>> hijosRaiz = new LinkedList<>();
		hijosRaiz.add(a2);
		hijosRaiz.add(a3);
		a1.setChildren(hijosRaiz);

		List<GeneralTree<Integer>> hijosA2 = new LinkedList<>();
		hijosA2.add(a4);
		hijosA2.add(a5);
		a2.setChildren(hijosA2);

		List<GeneralTree<Integer>> hijosA3 = new LinkedList<>();
		hijosA3.add(a6);
		a3.setChildren(hijosA3);

		ParcialArboles arbol = new ParcialArboles(a1);
		List<Integer> lista = arbol.nivel(3);
		System.out.print(lista);
	}
}