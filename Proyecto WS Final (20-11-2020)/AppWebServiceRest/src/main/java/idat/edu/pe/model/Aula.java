package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "aulas")
public class Aula implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aulaId;
	
	@Column
	private Integer aforo;
	
	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(seccion_id) references secciones(seccion_id)" ))
	private Seccion seccion;

	public Aula() {
	}

	public Aula(Integer aulaId, Integer aforo) {
		this.aulaId = aulaId;
		this.aforo = aforo;
	}

	public Integer getAulaId() {
		return aulaId;
	}

	public void setAulaId(Integer aulaId) {
		this.aulaId = aulaId;
	}

	public Integer getAforo() {
		return aforo;
	}

	public void setAforo(Integer aforo) {
		this.aforo = aforo;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
	
}
