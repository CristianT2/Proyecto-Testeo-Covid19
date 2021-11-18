package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.PersonalSalud;

public interface IPersonalSaludService {

	public PersonalSalud getPersonalSalud();
	public void addPersonalSalud(PersonalSalud personalSalud);
	public void deletePersonalSalud(Integer id);
	public Optional<PersonalSalud> getPersonalSalud(Integer id);
	public List<PersonalSalud> getAllPersonalSalud();
	public List<PersonalSalud> searchPersonalSalud(String apellido, String rol);
}
