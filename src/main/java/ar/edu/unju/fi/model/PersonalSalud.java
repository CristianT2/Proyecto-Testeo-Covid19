/**
 * 
 */
package ar.edu.unju.fi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Clase que representa un personal de salud (Director, testeador, vacunador)
 * @author Torrejon Cristian
 * @version 1.0
 */

@Component
@Entity
@Table(name = "PERSONAL_SALUD")
public class PersonalSalud {
	
	@Id
	@Column(name = "id_personal_salud")
	private Integer id;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "contraseña")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
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
	 */
	public PersonalSalud(Integer id, String usuario, String password, String nombre, String apellido, Rol rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
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

	@Override
	public String toString() {
		return "PersonalSalud [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", rol=" + rol + "]";
	}
	
	
	
}
