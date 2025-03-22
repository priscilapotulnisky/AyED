package tp1.ejercicio5;

public class Valores {
	static Resultados resultados;
	public Valores() {
		
	}

	public static Resultados metodo1(int array[]){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		double suma = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i]>max) 
				max = array[i];
			if(array[i]<min) 
				min = array[i];
			suma += array[i];
		}
		Resultados resultados = new Resultados();
		resultados.setMaximo(max);;
		resultados.setMinimo(min);;
		resultados.setPromedio(suma/array.length);
		return resultados;
	}
	
	public static void metodo2 (int [] array, Resultados resultados) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		double suma = 0;
		for(int i = 0; i<array.length; i++) {
			if(array[i] > max)
				max = array[i];
			if(array[i]<min)
				min=array[i];
			suma += array[i];
		}
		resultados.setMaximo(max);
		resultados.setMinimo(min);
		resultados.setPromedio(suma/array.length);
	}
	public static void metodo3(int [] array) {
		resultados = new Resultados();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		double suma = 0;
		for(int i = 0; i<array.length; i++) {
			if(array[i]>max) 
				max = array[i];
			if(array[i]<min)
				min = array[i];
			suma += array[i];
		}
		resultados.setMinimo(min);
		resultados.setMaximo(max);
		resultados.setPromedio(suma/array.length);
	}
	
	
}
