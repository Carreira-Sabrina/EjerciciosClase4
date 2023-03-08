package resolucion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//Ejercicio 2
//Haga una main donde por parámetro envíe la ruta de un archivo. Ese archivo debe
// contener números. El programa debe escribir por consola la suma de esos números

public class Ejercicio_2 {

	public static void main(String[] args) {
		
		//Se obtiene la ruta desde la array de argumentos
		String archivo = args[0];
		
		Path ruta = Paths.get(archivo);
	
		//Intentamos leer las lineas del archivo. Hay error si no se usa el try/catch !
		
		int suma = 0;
		
		try {
			for (String linea :Files.readAllLines(ruta)) {
				int numActual = Integer.parseInt(linea);
				suma+=numActual;
				System.out.println("El numero actual es " + linea + " el resultado acumulado hasta ahora es " + suma);
			}
			System.out.println("****************************************");
			System.out.println("El resultado de la suma de los numeros del archivo es " + suma);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
