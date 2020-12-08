package idat.edu.pe.model;

import java.time.LocalDate;

import javax.persistence.*;

@Table
@Entity(name = "trabajadores")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrabajador;

	@Column
	private String cargo;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String dni;
	//@Temporal(TemporalType.DATE)
	@Column
	private LocalDate fechaNacimiento;
	@Column
	private String celular;
	@Column
	private String direccion;
	@Column
	private String correo;
	@Column
	private String pass;

	@ManyToOne
	@JoinColumn(name = "id_distrito", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_distrito) references distritos(distrito_id)"))
	private Distrito distrito;

	public Trabajador() {
	}

	public Trabajador(Integer idTrabajador, String cargo, String nombres, String apellidos, String dni,
			LocalDate fechaNacimiento, String celular, String direccion, String correo, String pass) {
		super();
		this.idTrabajador = idTrabajador;
		this.cargo = cargo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.pass = pass;
	}

	public Integer getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(Integer idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}
