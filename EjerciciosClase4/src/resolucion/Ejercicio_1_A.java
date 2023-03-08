package resolucion;

import java.util.Arrays;

public class Ejercicio_1_A {

	public static void main(String[] args) {
		//haga un main, donde por parámetro ponga 3 números y una letra que
		//represente ascendente o descendente y los muestre ordenados por tal criterio
		
		//args: 3 numeros seguidos por una letra A o D, cuidado en como guardo eso en variables
		
		//Primero creo la array de los nùmeros, cuidado con la condicion !
		int [] numeros = new int[3];
		
		for(int i=0; i<args.length - 1; i++ ) {
			numeros[i] = Integer.parseInt(args[i]);
		}
		
		//Separo la letra que representa el orden
		String orden = args[args.length - 1];
		
		//Siempre ordeno la array, luego si es descendente la doy vuelta
		
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
