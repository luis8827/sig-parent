package ld.ejb;

public class Persona {

	String nombre;
	int Edad;

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		Edad = edad;
	}

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

}
