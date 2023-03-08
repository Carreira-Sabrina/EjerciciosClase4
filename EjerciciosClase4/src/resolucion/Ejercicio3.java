package resolucion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


/*Tome el ejercicio B de la clase 3 y que por parámetro se pueda elegir si es una
codificación o decodificación, el valor del desplazo, y 2 archivos, uno para la entrada y
otro para la salida. Que por pantalla solo indique si terminó o no correctamente, los
resultados deben estar en el archivo de salida*/


public class Ejercicio3 {

	public static void main(String[] args) {
		//"Desenpacando" los argumentos
		String operacion = args[0].toUpperCase(); // codificar o decodificar (C o D)
		int clave = Integer.parseInt(args[1]); //valor del desplazamiento
		Path rutaEntrada = Paths.get(args[2]); //ruta del archivo de entrada
		Path rutaSalida = Paths.get(args[3]); //ruta del archivo de salida
		
		String abecedario = "abcdefghijklmnñopqrstuvwxyz ";
		int cantLetrasAbc = abecedario.length();
		
		String msjEntrada ="";
		String msjSalida = "";
		
		//Leer del archivo 
		try {
			for (String linea :Files.readAllLines(rutaEntrada)) {
				msjEntrada = linea;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nuevoIndiceEnAbc=0; //para usar con indexOf contra abecedario
		
		char [] msjEnArray = msjEntrada.toCharArray(); //convierto el mensaje en array de char
		int cantLetrasMsj = msjEntrada.length();
		
		for(int i=0; i<cantLetrasMsj; i++) {
		
			char letraOriginal = msjEnArray[i];
			int indiceEnAbc=abecedario.indexOf(letraOriginal);
			//Se selecciona la operacion
			switch(operacion) {
			case "C": //CODIFICAR
				nuevoIndiceEnAbc = indiceEnAbc + clave;
				//Ciudado con los errores "out of bounds"
				if (nuevoIndiceEnAbc >= cantLetrasAbc) {
					nuevoIndiceEnAbc -= cantLetrasAbc;
				}
				break;
			case "D": //DECODIFICAR
				nuevoIndiceEnAbc = indiceEnAbc - clave;
				//Ciudado con los errores "out of bounds"
				if (nuevoIndiceEnAbc < 0) {
					nuevoIndiceEnAbc += cantLetrasAbc;
				}
				break;
			}
			//letra (de)codificada se agrega al mensaje
			msjSalida+= abecedario.charAt(nuevoIndiceEnAbc);					
		} //end of for
		
		//Ahora se escribe el mensaje en el archivo de salida
		
		try {
			Files.writeString(rutaSalida,msjSalida);
			System.out.println("El mensaje ha sido escrito en el archivo de salida");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Algo saliò mal, no se pudo escribir en el archivo de salida");
		}
		
	}
				

}


