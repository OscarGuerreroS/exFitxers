package ventaVehicles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

public class Concessionaris {
	private String adreca;
	private static TreeSet<Vehicles> vehicles;
	public static final int limitVehiclesConcesionario = 15;

	public Concessionaris(String adreca) {
		this.adreca = adreca;
		this.vehicles = new TreeSet<Vehicles>();
	}

	public boolean leerFichero(String archivo) throws MatriculaInvalidaException {
		File file = new File(archivo);
		Vehicles v;

		if (file.exists()) {
			try (BufferedReader bReader = new BufferedReader(new FileReader(archivo))) {
				String linea = "";
				String[] palabras = linea.split("; ");
				while ((linea = bReader.readLine()) != null) {
					if (!linea.startsWith("#")) {
						// System.out.println(linea);
						palabras = linea.split("; ");
						if (palabras[0].equals("cotxe")) {
							vehicles.add(new Coche(palabras[1], Integer.parseInt(palabras[2]),
									Boolean.parseBoolean(palabras[3])));
						}

						if (palabras[0].equals("moto")) {
							vehicles.add(new Motos(palabras[1], Integer.parseInt(palabras[2]),
									Integer.parseInt(palabras[3])));
						}
					}
					for (int i = 0; i < palabras.length; i++) {
						// System.out.println(palabras[i] + "; ");
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Fitxer no existeix");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Hay algo que esta mal");
			}

			return true;
		}

		System.out.println("el fitxer NO existeix");
		return false;

	}

	public void añadirVehiculo(Vehicles vehicle) {
		vehicles.add(vehicle);
	}

	public Vehicles borrarVehiculo(String matricula) {
		Iterator<Vehicles> iter = vehicles.iterator();
		while (iter.hasNext()) {
			Vehicles v = iter.next();
			if (matricula.equals(v.getMatricula())) {
				iter.remove();
				System.out.println("Vehiculo eliminado: " + matricula);
				return v;
			}
		}
		System.out.println("No se ha encontrado el vehiculo con la matricula: " + matricula);
		return null;
	}

	public int totalVehicles() {
		return vehicles.size();
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public TreeSet<Vehicles> getVehicles() {
		return vehicles;
	}

	public void setVehicles(TreeSet<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Concessionaris [adreca=" + adreca + " + vehicles= " + vehicles + "]";
	}

}
