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
 * Clase que representa a una vacuna
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
@Entity
@Table(name = "VACUNAS")
public class Vacuna {
	
	@Id
	@Column(name = "id_nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "imagen")
	private String image;
	
	@OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL)
	private List<VacunacionPersona> vacunacionPersona;
	
	/**
	 *Contructores 
	 */
	
	public Vacuna() {
		
	}
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param image
	 */
	public Vacuna(String nombre, String descripcion, String image) {
		super();
		this.nombre = nombre;
		this.setDescripcion(descripcion);
		this.setImage(image);
	}
	
	//Getters y Setters
	
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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
		return "Vacuna [nombre=" + nombre + ", descripcion=" + descripcion + ", image=" + image + "]";
	}

	
}
