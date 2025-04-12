package clase;

public class Estudiante {
	
	private int cod;
	private String nombre;
	private double n1, n2;
	
	public Estudiante(int cod, String nombre, double n1, double n2) {
		this.cod = cod;
		this.nombre = nombre;
		this.n1 = n1;
		this.n2 = n2;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}
	
	public double Promedio() {
		return (n1 + n2)/2;
	}
	
	

}
