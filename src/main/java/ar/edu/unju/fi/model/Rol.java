/**
 * 
 */
package ar.edu.unju.fi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Clase que representa el rol de un personal de salud
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
@Entity
@Table(name = "ROLES")
public class Rol {
	
	@Id
	@Column(name= "id_nombre_rol")
	private String nombreRol;
	
	@Column(name= "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
	private List<PersonalSalud> personalSalud;
	
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
	public Rol(String nombreRol, String descripcion) {
		super();
		this.nombreRol = nombreRol;
		this.descripcion = descripcion;
	}
	
	//GEtters y Setters

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

	/**
	 * @return the personalSalud
	 */
	public List<PersonalSalud> getPersonalSalud() {
		return personalSalud;
	}

	/**
	 * @param personalSalud the personalSalud to set
	 */
	public void setPersonalSalud(List<PersonalSalud> personalSalud) {
		this.personalSalud = personalSalud;
	}

	@Override
	public String toString() {
		return "Rol [nombreRol=" + nombreRol + ", descripcion=" + descripcion + "]";
	}
	
}
