package pruebas;

public class CommandLineArgsTest {

	public static void main(String[] args) {
		//Prueba para pasar paràmetros al método main
		//args es una array de Strings. Cuidado cuando lo que se quiere pasar con tipos primitivos
		// hay que hacer la conversión correspondiente !
		
		//Se pasarán Strings a ser tratado como numeros como argumentos
		
		for(String parametro: args) {
			int parametroNumerico = Integer.parseInt(parametro);
			System.out.println("Este es un parámetro pasado a main " + parametroNumerico);
			
		}

	}

}
