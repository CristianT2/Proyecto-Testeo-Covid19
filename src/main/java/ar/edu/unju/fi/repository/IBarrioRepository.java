package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.Barrio;

public interface IBarrioRepository extends CrudRepository<Barrio, String>{

	public List<Barrio> findAll();
	public Optional<Barrio> findByNombre(String nombre);
	
}
