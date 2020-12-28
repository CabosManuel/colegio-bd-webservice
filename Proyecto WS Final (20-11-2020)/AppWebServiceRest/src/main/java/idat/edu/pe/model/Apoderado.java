package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "apoderados")
public class Apoderado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String dniApoderado;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private String correo;

	@Column
	private String celular;

	@Column
	private String pass;

	@Column
	private String direccion;

	@Column
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(distrito_id) references distritos(distrito_id)"))
	private Distrito distrito;

	@OneToMany(mappedBy = "apoderado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Estudiante> itemsestudiante = new ArrayList<>();

	public Apoderado() {
	}

	public Apoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public Apoderado(String dniApoderado, String nombre, String apellido, String correo, String celular, String pass,
			String direccion, Boolean estado) {
		super();
		this.dniApoderado = dniApoderado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.celular = celular;
		this.pass = pass;
		this.direccion = direccion;
		this.estado = estado;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}

	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
