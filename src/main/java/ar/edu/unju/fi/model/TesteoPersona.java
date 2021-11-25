/**
 * 
 */
package ar.edu.unju.fi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * Clase que presenta una persona testeada
 * @author Torrejon Cristian
 * @version 2.0
 */

@Component
@Entity
@Table(name = "TESTEOS")
public class TesteoPersona {
	
	//Atributos
	
	@NotEmpty(message = "Ingrese su número de documento.")
	@Id
	@Column(name = "id_dni")
	private String documento;
	
	@NotEmpty(message = "Ingrese su/s nombre/s.")
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty(message = "Ingrese su/s apellido/s.")
	@Column(name = "apellido")
	private String apellido;
	
	@NotEmpty(message = "Ingrese su número de teléfono.")
	@Column(name = "telefono")
	private String telefono;
	
	@NotEmpty(message = "Ingrese su email.")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "Seleccione una opcion.")
	@ManyToOne()
	@JoinColumn(name = "barrio_id")
	private Barrio barrio;
	
	@NotEmpty(message = "Ingrese su dirección.")
	@Column(name = "direccion")
	private String direccion;
	
	@NotEmpty(message = "Ingrese el resultado del testeo.")
	@Column(name = "resultado")
	private String resultado;
	
	@Column(name = "fecha_hora")
	private LocalDateTime fechaHora;
	
	@NotNull(message = "Seleccione una opcion.")
	@ManyToOne()
	@JoinColumn(name = "personal_salud_id")
	private PersonalSalud personalSalud;
	
	/**
	 * Constructores 
	 */
	
	public TesteoPersona() {

	}
		
	/**
	 * @param documento
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param email
	 * @param barrio
	 * @param direccion
	 * @param resultado
	 * @param fechaHora
	 * @param personalSalud
	 */
	public TesteoPersona(String documento, String nombre, String apellido, String telefono, String email, Barrio barrio,
			String direccion, String resultado, LocalDateTime fechaHora, PersonalSalud personalSalud) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.barrio = barrio;
		this.direccion = direccion;
		this.resultado = resultado;
		this.fechaHora = fechaHora;
		this.personalSalud = personalSalud;
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
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
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

	/**
	 * @return the personalSalud
	 */
	public PersonalSalud getPersonalSalud() {
		return personalSalud;
	}

	/**
	 * @param personalSalud the personalSalud to set
	 */
	public void setPersonalSalud(PersonalSalud personalSalud) {
		this.personalSalud = personalSalud;
	}

	@Override
	public String toString() {
		return "TesteoPersona [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", email=" + email + ", barrio=" + barrio + ", direccion=" + direccion + ", resultado="
				+ resultado + ", fechaHora=" + fechaHora + ", personalSalud=" + personalSalud + "]";
	}
	
	
	
}
