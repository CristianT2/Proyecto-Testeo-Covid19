package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.VacunacionPersona;

public interface IVacunacionPersonaService {
	
	public VacunacionPersona getVacunacionPersona();
	public void addVacunacion(VacunacionPersona vacunacionPersona);
	public void deleteVacunacion(String documento);
	public Optional<VacunacionPersona> getPersonaVacunada(String documento);
	public List<VacunacionPersona> getPersonasVacunadas();
	public List<VacunacionPersona> searchVacunacionPersona(String barrio, String vacuna);

}
