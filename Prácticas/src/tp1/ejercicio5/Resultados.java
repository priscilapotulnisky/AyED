package tp1.ejercicio5;

public class Resultados {

	private int minimo;
	private int maximo;
	private double promedio;

	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	public String toString() {
		return "Minimo: " + this.getMinimo() + "\nMaximo: "+this.getMaximo() + "\nPromedio: "+this.getPromedio();
	}
}
