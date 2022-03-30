/**
 * 
 */
package ar.edu.unju.fi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un personal de salud (Director, testeador, vacunador)
 * @author Torrejon Cristian
 * @version 2.0
 */

@Component
@Entity
@Table(name = "PERSONAL_SALUD")
public class PersonalSalud {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personal_salud")
	private Integer id;
	
	@NotEmpty(message = "Ingrese un nombre de usuario.")
	@Column(name = "usuario")
	private String usuario;
	
	@NotEmpty(message = "Ingrese una contraseña.")
	@Column(name = "contraseña")
	private String password;
	
	@NotEmpty(message = "Ingrese su/s nombre/s.")
	@Column(name = "nombre")
	private String nombre;
	
	@NotEmpty(message = "Ingrese su apellido.")
	@Column(name = "apellido")
	private String apellido;
	
	@NotEmpty(message = "Ingrese su email.")
	@Column(name = "email")
	private String email;
	
	@NotEmpty(message = "Ingrese un número telefonico.")
	@Column(name = "telefono")
	private String telefono;
	
	@NotEmpty(message = "Ingrese su número de documento.")
	@Column(name="documento")
	private String documento;
	
	@NotNull(message = "Seleccione un rol.")
	@ManyToOne()
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	@OneToMany(mappedBy = "personalSalud", cascade = CascadeType.ALL)
	private List<TesteoPersona> testeoPersona;
	
	@OneToMany(mappedBy = "personalSalud", cascade = CascadeType.ALL)
	private List<VacunacionPersona> vacunacionPersona;
	
	/**
	 *Contructores 
	 */
	
	public PersonalSalud() {
	
	}
	
	/**
	 * @param id
	 * @param usuario
	 * @param password
	 * @param nombre
	 * @param apellido
	 * @param rol
	 * @param email 
	 * @param telefono 
	 * @param documento 
	 */
	public PersonalSalud(Integer id, String usuario, String password, String nombre, String apellido, Rol rol, String email, String telefono, String documento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.email = email;
		this.telefono = telefono;
		this.documento = documento;
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

	@Override
	public String toString() {
		return "PersonalSalud [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", documento=" + documento
				+ ", rol=" + rol + "]";
	}

	
	
}
