package idat.edu.pe.model;

public class TrabajadorCurso {
	
	private Trabajador trabajador;
	private Curso curso;
	public TrabajadorCurso() {
	}
	public TrabajadorCurso(Trabajador trabajador, Curso curso) {
		this.trabajador = trabajador;
		this.curso = curso;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
