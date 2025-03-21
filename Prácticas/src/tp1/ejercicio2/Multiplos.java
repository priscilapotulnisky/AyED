package tp1.ejercicio2;
import java.util.*;
public class Multiplos {

	public static ArrayList <Integer> arregloMultiplos() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un numero: ");
		int numero = sc.nextInt();
		sc.close();
		ArrayList<Integer> vector = new ArrayList<>();
		for (int i=1; i<=numero; i++)
			vector.add(i * numero);
		return vector;	
	}
	
	public static void main (String [] args) {
		ArrayList<Integer>array = new ArrayList<>(Multiplos.arregloMultiplos());
		System.out.println(array);
	}
}
