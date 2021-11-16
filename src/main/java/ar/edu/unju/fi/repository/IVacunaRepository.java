package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.Vacuna;

public interface IVacunaRepository extends CrudRepository<Vacuna, String>{
	
	public List<Vacuna> findAll();
	public Optional<Vacuna> findByNombre(String nombre);

}
