/**
 * 
 */
package ar.edu.unju.fi.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

/**
 * Clase que representa una persona vacunada
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
public class VacunacionPersona {
	
	//Atributos
	
	private String documento;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private Barrio barrio;
	private String direccion;
	private Vacuna vacuna;
	private LocalDateTime fechaHora;
	
	/**
	 *Constructores 
	 */
	public VacunacionPersona() {
		
	}

	/**
	 * @param documento
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param email
	 * @param barrio
	 * @param direccion
	 * @param vacuna
	 * @param fechaHora
	 */
	public VacunacionPersona(String documento, String nombre, String apellido, String telefono, String email,
			Barrio barrio, String direccion, Vacuna vacuna, LocalDateTime fechaHora) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.barrio = barrio;
		this.direccion = direccion;
		this.vacuna = vacuna;
		this.fechaHora = fechaHora;
	}
	
	//Getters y Setters

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the barrio
	 */
	public Barrio getBarrio() {
		return barrio;
	}

	/**
	 * @param barrio the barrio to set
	 */
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the vacuna
	 */
	public Vacuna getVacuna() {
		return vacuna;
	}

	/**
	 * @param vacuna the vacuna to set
	 */
	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "VacunacionPersona [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + ", email=" + email + ", barrio=" + barrio + ", direccion=" + direccion
				+ ", vacuna=" + vacuna + ", fechaHora=" + fechaHora + "]";
	}
	

}
