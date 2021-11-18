package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.PersonalSalud;
import ar.edu.unju.fi.repository.IPersonalSaludRepository;
import ar.edu.unju.fi.service.IPersonalSaludService;

@Service
public class PersonalSaludServiceImp implements IPersonalSaludService{

	@Autowired
	IPersonalSaludRepository personalSaludRepository;
	
	@Autowired
	PersonalSalud personalSalud;
	
	@Override
	public PersonalSalud getPersonalSalud() {
		// TODO Auto-generated method stub
		return personalSalud;
	}

	@Override
	public void addPersonalSalud(PersonalSalud personalSalud) {
		// TODO Auto-generated method stub
		personalSaludRepository.save(personalSalud);
	}

	@Override
	public void deletePersonalSalud(Integer id) {
		// TODO Auto-generated method stub
		personalSaludRepository.deleteById(id);
	}

	@Override
	public Optional<PersonalSalud> getPersonalSalud(Integer id) {
		// TODO Auto-generated method stub
		return personalSaludRepository.findById(id);
	}

	@Override
	public List<PersonalSalud> getAllPersonalSalud() {
		// TODO Auto-generated method stub
		return personalSaludRepository.findAll();
	}

	@Override
	public List<PersonalSalud> searchPersonalSalud(String apellido, String rol) {
		// TODO Auto-generated method stub
		List<PersonalSalud> personal = new ArrayList<PersonalSalud>();
		
		if(!apellido.isEmpty() && !rol.isEmpty()) {
			personal = personalSaludRepository.findByApellidoAndRolLike(apellido, rol);
		}else if(!apellido.isEmpty() && rol.isEmpty()){
			personal = personalSaludRepository.findByApellidoLike(apellido);
		}else if(apellido.isEmpty() && !rol.isEmpty()) {
			personal = personalSaludRepository.findByRolLike(rol);
		}
		
		return personal;
	}

}
