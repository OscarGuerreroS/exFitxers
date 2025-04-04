package ventaVehicles;

class Motos extends Vehicles {

	@Override
	public String toString() {
		return "\nMoto [cilindrada=" + cilindrada + ", matricula=" + matricula + ", km=" + km + "]";
	}

	private int cilindrada;

	public Motos(String matricula, double km, int cilindrada) throws MatriculaInvalidaException {
		super(matricula, km);
		this.cilindrada = cilindrada;
	}

	@Override
	public double calcularDescompte() {
		double percentatgeDescompte;

		if (cilindrada <= 125) {
			percentatgeDescompte = ((km / 5000) * 2);
		} else {
			percentatgeDescompte = (km / 10000);
		}
		if (percentatgeDescompte > 20) {
			return percentatgeDescompte = 20;
		}

		return (int) percentatgeDescompte;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

}
