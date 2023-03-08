package resolucion;

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio_1_B {

	public static void main(String[] args) {
		// Igual al ejercicio 1 A pero solicitando los parámetros por consola
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Por favor, ingresar 3 numeros separados por un espacio: ");
		//Estoy haciendo un salto de fe porque si ingresan algo que no es un número esto
		//va a estallar :)
		
		String numerosComoStr = entrada.nextLine();
		
		//Intento evitar que el usuario escriba algo distinto de A o D
		
		String orden="";
		
		do {
			System.out.println("Por favor,ingresar A para ordenarlos en forma ascendente o D para ordenarlos en forma descendente");
			orden = entrada.nextLine();
		}while(!orden.equalsIgnoreCase("A") && !orden.equalsIgnoreCase("D"));
			
		entrada.close();
		
		//Convierto los numeros a una array de int y siempre la ordeno, si el orden es descendente la doy vuelta
		int [] numeros = new int [3];
		
		String[] arrayDeNumStr = numerosComoStr.split(" ");
		
		for(int i=0; i<arrayDeNumStr.length; i++) {
			int num = Integer.parseInt(arrayDeNumStr[i]);
			numeros[i] = num;
		}
		Arrays.sort(numeros);
		
		if(orden.equalsIgnoreCase("A")) {
			//Orden ascendente
			System.out.println("Se ha elegido ordenar los numeros en orden ascendente");		
		}else if(orden.equalsIgnoreCase("D")) {
			//Orden descendente, hay que dar vuelta la array !
			System.out.println("Se ha elegido ordenar los numeros en orden descendente");
			
			for(int i=0, j=numeros.length - 1; i<j; i++,j--) {
				int temp = numeros[i];
				numeros[i] = numeros[j];
				numeros[j] = temp;
			}
		}
		//Ahora imprimo los numeros segun el orden que se eligió.
		System.out.println("El resultado es: ");
		for(int num:numeros) {
			System.out.println(num);
		}
		
		
	}

}
