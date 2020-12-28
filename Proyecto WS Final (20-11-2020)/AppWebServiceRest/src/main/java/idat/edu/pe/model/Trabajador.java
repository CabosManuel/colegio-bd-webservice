package idat.edu.pe.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Table
@Entity(name = "trabajadores")
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trabajadorId;

	@Column(nullable = false)
	private String cargo;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String dni;
	@Temporal(TemporalType.DATE)
	@Column
	private Date fechaNacimiento;
	@Column
	private String celular;
	@Column
	private String direccion;
	
	@Column(unique = true, nullable = false)
	private String correo;
	@Column
	private String pass;
	
	@Column
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false, updatable=false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(distrito_id) references distritos(distrito_id)"))
	private Distrito distrito;
	
	@OneToMany(mappedBy = "trabajador",cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private  Collection<HorarioCabecera> horarioCabecera = new ArrayList<>();

	public Trabajador() {
	}

	
	public Trabajador(Integer trabajadorId, String cargo, String nombres, String apellidos, String dni,
			Date fechaNacimiento, String celular, String direccion, String correo, String pass, Boolean estado) {
		this.trabajadorId = trabajadorId;
		this.cargo = cargo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.pass = pass;
		this.estado = estado;
	}


	public Integer getTrabajadorId() {
		return trabajadorId;
	}

	public void setTrabajadorId(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

}
