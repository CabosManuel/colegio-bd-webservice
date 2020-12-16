package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String dniEstudiante;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	private Date fnacimiento;
	
	@Column
	private String celular;
	
	@Column
	private String correo;
	
	@Column
	private String direccion;
	
	@Column
	private String pass;
	
	@Column
	private Integer estado;

	@ManyToOne
	@JoinColumn(name ="distrito_id", nullable = false, updatable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(distrito_id) references distritos(distrito_id)"))
	private Distrito distrito;
	
	/*@ManyToMany(mappedBy = "itemsEstudiante", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Curso> itemsCurso = new HashSet<>();*/
	
	@ManyToOne//(fetch = FetchType.EAGER, targetEntity = Apoderado.class)
	@JoinColumn(name = "dni_apoderado", nullable = false, updatable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(dni_apoderado) references apoderados(dni_apoderado)"))
	private Apoderado apoderado;
	
	@OneToMany(mappedBy = "estudiante")
	private Collection<Matricula> itemsmatricula =  new ArrayList<>();
	
	/*@OneToOne
	@JoinColumn(name = "direccion_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(direccion_id) references direcciones(direccion_id)"))
	private Direccion direccion;*/
	
	public Estudiante() {
		
	}

	public Estudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}

	public Estudiante(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, String pass, Integer estado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
	}

	public String getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
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

	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public Collection<Matricula> getItemsmatricula() {
		return itemsmatricula;
	}

	public void setItemsmatricula(Collection<Matricula> itemsmatricula) {
		this.itemsmatricula = itemsmatricula;
	}
	
	

		
}
