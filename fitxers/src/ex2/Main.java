package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu el nom del fitxer:");
		String fitxer = sc.nextLine();
		escribirLetra(fitxer);

	}

	public static boolean escribirLetra(String fichero) {
		boolean append = false;
		try (PrintWriter pWriter = new PrintWriter(new FileWriter(fichero, append))) {
			Scanner sc = new Scanner(System.in);
			String nuevaLinea;
			int totalPalabras = 0;
			System.out.println("Escriu una paraula o linea (escriu 'fi' per acabar): ");
			nuevaLinea = sc.nextLine();

			while (!nuevaLinea.equals("fi")) {
				// aqui dividimos la linea por palabras por contar
				String[] palabras = nuevaLinea.split(" ");

				// se cuenta por espacios
				totalPalabras += palabras.length;

				// escribimos el archivo
				pWriter.println(nuevaLinea);

				System.out.println("Se ha añadido.");
				nuevaLinea = sc.nextLine();

			}

			System.out.println("Total de palabras escritas: " + totalPalabras);
			System.out.println("fi");

		} catch (IOException e) {
			System.out.println("Error");
		}

		return true;

	}

}
