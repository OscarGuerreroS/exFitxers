package ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

	public static boolean leerFichero(String archivo) {
		File file = new File(archivo);

		if (file.exists()) {
			try (BufferedReader bReader = new BufferedReader(new FileReader(archivo))) {
				String linea;
				int total = 0;

				while ((linea = bReader.readLine()) != null) {
					try {
						total = total + Integer.parseInt(linea);
						System.out.println(linea);
					} catch (NumberFormatException e) {
						System.out.println("Esto no es un numero: " + linea);
					}
				}
				System.out.println("La suma total de los números es de: " + total);

			} catch (FileNotFoundException e) {
				System.out.println("Fitxer no existeix");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

			return true;
		}

		System.out.println("el fitxer NO existeix");
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Busca un archivo por su nombre, si no lo encuentra lo creara: ");
		String archivo = sc.nextLine();

		leerFichero(archivo);

		sc.close();
	}

}
