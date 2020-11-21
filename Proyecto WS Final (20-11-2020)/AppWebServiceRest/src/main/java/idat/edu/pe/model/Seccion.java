package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

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
	
	@OneToMany(mappedBy = "seccion")
	private Collection<Aula> itemsaula = new ArrayList<>();
	
	public Seccion() {
	}


	public Seccion(Integer seccionId, String nombre) {
		this.seccionId = seccionId;
		this.nombre = nombre;
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


	public Collection<Aula> getItemsaula() {
		return itemsaula;
	}


	public void setItemsaula(Collection<Aula> itemsaula) {
		this.itemsaula = itemsaula;
	}
	
	
	
	
}
