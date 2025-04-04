package ventaVehicles;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Vehicles implements Comparable<Vehicles> {
	protected String matricula;
	protected double km;
	private static final List<String> CODIGOS_PROVINCIALES = Arrays.asList("A", "AB", "AL", "AV", "B", "BA", "BI", "BU",
			"C", "CA", "CC", "CS", "CR", "CO", "CU", "GE", "GR", "GU", "H", "HU", "J", "L", "LE", "LO", "LU", "M", "MA",
			"MU", "O", "OR", "P", "NA", "PM", "PO", "S", "SA", "SS", "SG", "SE", "SO", "T", "TE", "GC", "TF", "TO", "V",
			"VA", "VI", "Z", "ZA", "CE", "ML", "GI", "OU", "IB");

	public Vehicles(String matricula, double km) throws MatriculaInvalidaException {
		if (!compruebaMatricula(matricula)) {
			throw new MatriculaInvalidaException("Matrícula inválida: " + matricula);
		}
		this.matricula = matricula;
		this.km = km;
	}

	public static boolean compruebaMatricula(String matricula) {
		String validacion = (CODIGOS_PROVINCIALES + "{1,2}-[0-9]{4}-[A-Z]{1,2}||[0-9]{4}-[BCDFGHJKLMNPRSTVWXYZ]{3}");
		boolean matchFound = Pattern.matches(validacion, matricula);
		return matchFound;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (!compruebaMatricula(matricula)) {
			throw new IllegalArgumentException("Matrícula inválida: " + matricula);
		}
		this.matricula = matricula;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Override
	public int compareTo(Vehicles other) {
		return this.matricula.compareTo(other.matricula);
	}

	@Override
	public String toString() {
		return "Vehicles [matricula=" + matricula + ", km=" + km + "]";
	}

	public abstract double calcularDescompte();

}
