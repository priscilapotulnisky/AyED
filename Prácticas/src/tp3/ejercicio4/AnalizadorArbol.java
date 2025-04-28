package tp3.ejercicio4;
import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;
public class AnalizadorArbol {

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		if(arbol.isEmpty())
			return 0;
		double promedioMax = -1;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		while(!cola.isEmpty()) {
			int cantidadNodos = cola.size();
			double suma = 0;
			for(int i = 0; i < cantidadNodos; i++) {
				GeneralTree<AreaEmpresa> arbolAux = cola.dequeue();
				suma += arbolAux.getData().getTardanza();
				 for(GeneralTree<AreaEmpresa> child: arbolAux.getChildren())
					 cola.enqueue(child);
			}
			double promedioActual = suma / cantidadNodos;
			System.out.println(promedioActual);
			if(promedioActual > promedioMax)
				promedioMax = promedioActual;
		}
		return promedioMax;
	}
}
