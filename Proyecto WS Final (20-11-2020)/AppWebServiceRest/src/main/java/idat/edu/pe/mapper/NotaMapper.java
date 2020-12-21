package idat.edu.pe.mapper;

public class NotaMapper {

	private Integer nota_id;
	private String curso;
	private Integer nota1;
	private Integer nota2;
	private Integer nota3;
	private EstudianteMapper dni_estudiante;
	private CursoMapper cursom;
	private String fecha;

	public NotaMapper() {
	}

	public NotaMapper(Integer nota_id, String curso, Integer nota1, Integer nota2, Integer nota3/*, String fecha*/, EstudianteMapper dni_estudiante, CursoMapper cursom) {
		this.nota_id = nota_id;
		this.curso = curso;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.dni_estudiante = dni_estudiante;
		this.cursom = cursom;
		this.fecha = fecha;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getNota1() {
		return nota1;
	}

	public void setNota1(Integer nota1) {
		this.nota1 = nota1;
	}

	public Integer getNota2() {
		return nota2;
	}

	public void setNota2(Integer nota2) {
		this.nota2 = nota2;
	}

	public Integer getNota3() {
		return nota3;
	}

	public void setNota3(Integer nota3) {
		this.nota3 = nota3;
	}

	public EstudianteMapper getDni_estudiante() {
		return dni_estudiante;
	}

	public void setDni_estudiante(EstudianteMapper dni_estudiante) {
		this.dni_estudiante = dni_estudiante;
	}

	public CursoMapper getCursom() {
		return cursom;
	}

	public void setCursom(CursoMapper cursom) {
		this.cursom = cursom;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getNota_id() {
		return nota_id;
	}

	public void setNota_id(Integer nota_id) {
		this.nota_id = nota_id;
	}
	
	
}
