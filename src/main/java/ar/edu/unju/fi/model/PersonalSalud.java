/**
 * 
 */
package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un personal de salud (Director, testeador, vacunador)
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
public class PersonalSalud {
	
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private Rol rol;
	
	/**
	 *Contructores 
	 */
	
	public PersonalSalud() {
	
	}
	
	/**
	 * @param usuario
	 * @param password
	 * @param nombre
	 * @param apellido
	 * @param rol
	 */
	public PersonalSalud(String usuario, String password, String nombre, String apellido, Rol rol) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}
	
	//Getters y Setters
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}
	
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "PersonalSalud [usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", apellido="
				+ apellido + ", rol=" + rol + "]";
	}
	
}
