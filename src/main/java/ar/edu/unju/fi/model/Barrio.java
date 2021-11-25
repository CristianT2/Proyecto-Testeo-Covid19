
package ar.edu.unju.fi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un barrio de la provincia
 * @author Torrejon Cristian
 * @version 2.0
 */

@Component
@Entity
@Table(name = "BARRIOS")
public class Barrio {
	
	@NotEmpty(message = "Ingrese el nombre del barrio.")
	@Id
	@Column(name = "id_nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "barrio", cascade = CascadeType.ALL)
	private List<TesteoPersona> testeoPersona;
	
	@OneToMany(mappedBy = "barrio", cascade = CascadeType.ALL)
	private List<VacunacionPersona> vacunacionPersona;
	
	/**
	 * Constructores
	 */
	
	public Barrio() {
		
	}

	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public Barrio(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * Getters y Setters
	 */
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the testeoPersona
	 */
	public List<TesteoPersona> getTesteoPersona() {
		return testeoPersona;
	}

	/**
	 * @param testeoPersona the testeoPersona to set
	 */
	public void setTesteoPersona(List<TesteoPersona> testeoPersona) {
		this.testeoPersona = testeoPersona;
	}

	/**
	 * @return the vacunacionPersona
	 */
	public List<VacunacionPersona> getVacunacionPersona() {
		return vacunacionPersona;
	}

	/**
	 * @param vacunacionPersona the vacunacionPersona to set
	 */
	public void setVacunacionPersona(List<VacunacionPersona> vacunacionPersona) {
		this.vacunacionPersona = vacunacionPersona;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	

}
