package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer direccionId;
	
	@Column
	private String nombreCalle;
	
	@Column
	private Integer numeroCalle;
	
	@OneToOne(mappedBy = "direccion")
	private Estudiante estudiante;

	public Direccion() {
	}

	public Direccion(Integer direccionId, String nombreCalle, Integer numeroCalle) {
		this.direccionId = direccionId;
		this.nombreCalle = nombreCalle;
		this.numeroCalle = numeroCalle;
	}

	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public Integer getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(Integer numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	

}
