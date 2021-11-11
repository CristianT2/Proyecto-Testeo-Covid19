
package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un personal de salud (Director, testeador, vacunador)
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
public class Barrio {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	
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
	public Barrio(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * Getters y Setters
	 */
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Barrio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	

}
