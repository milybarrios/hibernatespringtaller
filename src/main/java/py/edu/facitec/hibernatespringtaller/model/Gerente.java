package py.edu.facitec.hibernatespringtaller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Gerente {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String ci;
	private String nombre;
//Uno para Uno  /en uno de ellos va el mappeby	
	@OneToOne
	private Departamento departamento;
	
	
	public Gerente() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	@Override
	public String toString() {
		return "Gerente [id=" + id + ", ci=" + ci + ", nombre=" + nombre + ", departamento=" + departamento + "]";
	}

	
	
	
}
