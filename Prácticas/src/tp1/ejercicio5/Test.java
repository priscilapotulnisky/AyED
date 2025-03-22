package tp1.ejercicio5;

public class Test {

	public static void main (String [] args) {
		Valores v = new Valores();
		Resultados resultados = new Resultados();
		int vector [] = new int [5];
		
		//se carga el vector para probar el metodo 1
		for (int i = 0; i<vector.length; i++) 
			vector[i] = i+5;
		
		resultados = v.metodo1(vector);
		System.out.println(resultados.toString()); //deberia imprimir min = 5, max = 9, prom = 7
		System.out.println();
		
		
		//se carga el vector para probar el metodo 2
		for (int i = 0; i<vector.length; i++) 
			vector[i] = i+10;
		
		v.metodo2(vector, resultados);
		System.out.println(resultados.toString()); //deberia imprimir min = 10, max = 14, prom = 12
		System.out.println();
		
		
		//se carga el vector para probar el metodo 3
		for (int i = 0; i<vector.length; i++) 
			vector[i] = i+20;
		
		v.metodo3(vector);
		System.out.println(Valores.resultados.toString()); //deberia imprimir min = 20, max = 24, prom = 22
	}
}
