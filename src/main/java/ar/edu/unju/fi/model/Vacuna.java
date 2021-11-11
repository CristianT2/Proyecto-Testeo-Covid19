/**
 * 
 */
package ar.edu.unju.fi.model;

/**
 * Clase que representa a una vacuna
 * @author Torrejon Cristian
 * @version 1.0
 */

public class Vacuna {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String image;
	
	/**
	 *Contructores 
	 */
	
	public Vacuna() {
		
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param image
	 */
	public Vacuna(Integer id, String nombre, String descripcion, String image) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.setDescripcion(descripcion);
		this.setImage(image);
	}
	
	//Getters y Setters
	
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
	
	@Override
	public String toString() {
		return "Vacuna [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", image=" + image + "]";
	}

	
}
