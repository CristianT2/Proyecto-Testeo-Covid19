package ar.edu.unju.fi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.model.VacunacionPersona;

public interface IVacunacionPersonaRepository extends CrudRepository<VacunacionPersona, String>{

	public List<VacunacionPersona> findAll();
	public Optional<VacunacionPersona> findByDocumento(String documento);
	public List<VacunacionPersona> findByBarrioNombreLike(String barrio);
	public List<VacunacionPersona> findByVacunaNombreLike(String vacuna);
	public List<VacunacionPersona> findByBarrioNombreAndVacunaNombreLike(String barrio, String vacuna);
}
