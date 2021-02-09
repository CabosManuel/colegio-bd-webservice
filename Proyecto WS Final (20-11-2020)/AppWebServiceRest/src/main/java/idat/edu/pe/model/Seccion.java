package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "secciones")
public class Seccion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seccionId;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(grado_id) references grados(grado_id)"))
	private Grado grado;
	
	@OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Matricula> itemsMatricula = new ArrayList<>();
	
	@OneToMany(mappedBy = "seccion")
	private Collection<HorarioCabecera> HorariosCabecera = new ArrayList<>();
	
	@OneToMany(mappedBy = "seccion")
	private Collection<Nota> itemsNota = new ArrayList<>();
	
	public Seccion() {
	}

	public Seccion(Integer seccionId, String nombre) {
		this.seccionId = seccionId;
		this.nombre = nombre;
	}

	public Seccion(Integer seccionId, String nombre, Grado grado) {
		this.seccionId = seccionId;
		this.nombre = nombre;
		this.grado = grado;
	}

	public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Grado getGrado() {
		return grado;
	}


	public void setGrado(Grado grado) {
		this.grado = grado;
	}


	public Collection<Matricula> getItemsMatricula() {
		return itemsMatricula;
	}


	public void setItemsMatricula(Collection<Matricula> itemsMatricula) {
		this.itemsMatricula = itemsMatricula;
	}

	public Collection<HorarioCabecera> getHorariosCabecera() {
		return HorariosCabecera;
	}

	public void setHorariosCabecera(Collection<HorarioCabecera> horariosCabecera) {
		HorariosCabecera = horariosCabecera;
	}

	public Collection<Nota> getItemsNota() {
		return itemsNota;
	}

	public void setItemsNota(Collection<Nota> itemsNota) {
		this.itemsNota = itemsNota;
	}
}
