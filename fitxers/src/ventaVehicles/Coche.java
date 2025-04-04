package ventaVehicles;

class Coche extends Vehicles {
	private boolean esClassic;

	@Override
	public String toString() {
		return "\nCoche [esClassic=" + esClassic + ", matricula=" + matricula + ", km=" + km + "]";
	}

	@Override
	public double calcularDescompte() {
		if (esClassic) {
			return 0.0;
		}
		double percentatgeDescompte = (km / 10000);
		if (percentatgeDescompte > 10) {
			return percentatgeDescompte = 10;
		}

		return (int) percentatgeDescompte;
	}

	public Coche(String matricula, double km, boolean esClassic) throws MatriculaInvalidaException {
		super(matricula, km);
		this.esClassic = esClassic;
	}

	public boolean isEsClassic() {
		return esClassic;
	}

	public void setEsClassic(boolean esClassic) {
		this.esClassic = esClassic;
	}

}
