package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "apoderados")
public class Apoderado implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer apoderadoId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column(unique = true)
	private Long dni;
	
	@Column
	private String correo;
	
	@Column
	private String celular;
	
	@Column
	private String pass;
	
	@OneToMany(mappedBy = "apoderado")
	private Collection<Estudiante> itemsestudiante = new ArrayList<>();
	
	public Apoderado() {
	}

	public Apoderado(Integer apoderadoId, String nombre, String apellido, Long dni, String correo, String celular,
			String pass) {
		this.apoderadoId = apoderadoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.correo = correo;
		this.celular = celular;
		this.pass = pass;
	}


	public Integer getApoderadoId() {
		return apoderadoId;
	}


	public void setApoderadoId(Integer apoderadoId) {
		this.apoderadoId = apoderadoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Long getDni() {
		return dni;
	}


	public void setDni(Long dni) {
		this.dni = dni;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	public Collection<Estudiante> getItemsestudiante() {
		return itemsestudiante;
	}

	public void setItemsestudiante(Collection<Estudiante> itemsestudiante) {
		this.itemsestudiante = itemsestudiante;
	}
	
	
}
