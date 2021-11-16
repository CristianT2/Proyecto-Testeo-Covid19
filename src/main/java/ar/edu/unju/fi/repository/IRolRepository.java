package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.Rol;

public interface IRolRepository extends CrudRepository<Rol, String>{

	public List<Rol> findAll();
	public Optional<Rol> findByNombreRol(String nombreRol);
}
