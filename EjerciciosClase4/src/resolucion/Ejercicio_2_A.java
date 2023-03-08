package resolucion;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

//EJERCICIO 2 A
//Al programa anterior agreguele un parámetro para que la operación pueda ser
//suma o multiplicación.

public class Ejercicio_2_A {

	public static void main(String[] args) {
		//Se obtiene la ruta desde la array de argumentos
		String archivo = args[0];
		Path ruta = Paths.get(archivo);
		
		//Se obtiene la operación a realizar del segundo argumento (SUMA o MULTIPLICACION)
		String operacion = args[1];
		System.out.println("La operaciòn elegida de acuerdo al parametro es " + operacion);
		
		//Cuidado con el valor inicial de resultado, porque si no terminamos multiplicando por cero !!!
		int resultado = (operacion.equals("SUMA")) ? 0 : 1;
		
		try {
			for (String linea :Files.readAllLines(ruta)) {
				int numActual = Integer.parseInt(linea);
				switch (operacion) {
				case "SUMA":
					resultado = resultado + numActual;
					break;
				case "MULTIPLICACION":
					resultado = resultado * numActual;
					break;
				}
				
				System.out.println("El numero actual es " + linea + " el resultado acumulado hasta ahora es " + resultado);
			}
			System.out.println("****************************************");
			System.out.println("El resultado de la operacion " + operacion.toLowerCase() + " de los numeros del archivo es " + resultado );
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
