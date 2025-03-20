package tp1.ejercicio1;

public class Numeros {
	
	public static void conFor(int a, int b) {
			for (int i=a; i<=b; i++) {
				System.out.println(i);
			}
	}
	
	public static void conWhile(int a, int b) {
		int i = a;
		while(i<=b) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void conRecursion(int a, int b) {
		if(a <= b) {
			System.out.println(a);
			conRecursion(a + 1, b);
		}
	}
	
	public static void main (String [] args) {
		Numeros.conFor(1, 5);
		Numeros.conWhile(1, 5);
		Numeros.conRecursion(1, 5);
	}
}


