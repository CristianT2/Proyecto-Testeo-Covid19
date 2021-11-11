/**
 * 
 */
package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * Clase que representa el rol de un personal de salud
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
public class Rol {
	
	private Integer id;
	private String nombreRol;
	private String descripcion;
	
	/**
	 * Constructores
	 */
	public Rol() {
		
	}

	/**
	 * @param id
	 * @param nombreRol
	 * @param descripcion
	 */
	public Rol(Integer id, String nombreRol, String descripcion) {
		super();
		this.id = id;
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
	}
	
	//GEtters y Setters

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
	 * @return the nombreRol
	 */
	public String getNombreRol() {
		return nombreRol;
	}

	/**
	 * @param nombreRol the nombreRol to set
	 */
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
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
		return "Rol [id=" + id + ", nombreRol=" + nombreRol + ", descripcion=" + descripcion + "]";
	}
	
}
