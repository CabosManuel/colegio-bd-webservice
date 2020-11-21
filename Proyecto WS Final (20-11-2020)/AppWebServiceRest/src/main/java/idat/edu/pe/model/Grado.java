package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="grados")
public class Grado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradoId;
	
	@Column
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name ="nivel_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(nivel_id) references niveles(nivel_id)"))
	private Nivel nivel;
	
	@OneToMany(mappedBy = "grado")
	private Collection<Seccion> itemsseccion = new ArrayList<>();

	public Grado() {
	}

	public Grado(Integer gradoId, String nombre) {
		this.gradoId = gradoId;
		this.nombre = nombre;
	}

	public Integer getGradoId() {
		return gradoId;
	}

	public void setGradoId(Integer gradoId) {
		this.gradoId = gradoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Collection<Seccion> getItemsseccion() {
		return itemsseccion;
	}

	public void setItemsseccion(Collection<Seccion> itemsseccion) {
		this.itemsseccion = itemsseccion;
	}
	
	
	
}
