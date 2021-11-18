package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.PersonalSalud;

public interface IPersonalSaludRepository extends CrudRepository<PersonalSalud, Integer>{
	
	public List<PersonalSalud> findAll();
	public Optional<PersonalSalud> findById(Integer id);
	public List<PersonalSalud> findByApellidoLike(String apellido);
	public List<PersonalSalud> findByRolLike(String rol);
	public List<PersonalSalud> findByApellidoAndRolLike(String apellido, String rol);
	

}
