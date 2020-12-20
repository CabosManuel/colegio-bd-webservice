package idat.edu.pe.mapper;

public class NotaMapper {

	private String curso;
	private Integer nota1;
	private Integer nota2;
	private Integer nota3;
	//private String fecha;

	public NotaMapper() {
	}

	public NotaMapper(String curso, Integer nota1, Integer nota2, Integer nota3/*, String fecha*/) {
		this.curso = curso;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		//this.fecha = fecha;
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
	
	/*public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}*/
}
