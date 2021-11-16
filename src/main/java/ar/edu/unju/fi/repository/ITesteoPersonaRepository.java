package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.TesteoPersona;

public interface ITesteoPersonaRepository extends CrudRepository<TesteoPersona, String>{
	
	public List<TesteoPersona> findAll();
	public Optional<TesteoPersona> findByDocumento(String documento);
	public List<TesteoPersona> findByResultadoLike(String resultado);
	public List<TesteoPersona> findByBarrioBarrioLike(String barrio);
	public List<TesteoPersona> findByResultadoAndBarrioBarrioLike(String resultado, String Barrio);

}
