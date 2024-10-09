package modelo.entidad;

import java.util.Objects;

public class Videojuego {
	private String nombre;
	private int nota;
	private String compania;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	@Override
	public int hashCode() {
		return Objects.hash(compania, nombre, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(compania, other.compania) && Objects.equals(nombre, other.nombre) && nota == other.nota;
	}
	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", nota=" + nota + ", compania=" + compania + "]";
	}
	
	
}
