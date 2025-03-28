package tp1.ejercicio9;

import java.util.*;

public class Balance {
	
	public static boolean estaBalanceado(String cadena) {
		Stack<Character> pila = new Stack<>();
		for (char c : cadena.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				pila.push(c);
	        } 
		    else if (c == ')' || c == ']' || c == '}') {
		    	if (pila.isEmpty()) {
	                return false; // Hay un cierre sin apertura correspondiente
	            }
		    	char ultimo = pila.pop();
	            	if ((c == ')' && ultimo != '(') || (c == ']' && ultimo != '[') || (c == '}' && ultimo != '{')) {
	            		return false; // Los paréntesis no coinciden
	                }
	        }
	     }

	     return pila.isEmpty(); // Verificar si quedan paréntesis abiertos sin cerrar}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un string: ");
		boolean result = Balance.estaBalanceado(scanner.next());
		scanner.close();
		if (result) {
			System.out.println("El string ingresado está balanceado.");
		} else {
			System.out.println("El string ingresado no está balanceado");
		}
	}
}
