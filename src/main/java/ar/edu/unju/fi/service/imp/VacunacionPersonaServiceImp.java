package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.VacunacionPersona;
import ar.edu.unju.fi.repository.IVacunacionPersonaRepository;
import ar.edu.unju.fi.service.IVacunacionPersonaService;

@Service
public class VacunacionPersonaServiceImp implements IVacunacionPersonaService{

	@Autowired
	IVacunacionPersonaRepository vacunacionRepository;
	
	@Autowired
	VacunacionPersona vacunacionPersona;
	
	@Override
	public VacunacionPersona getVacunacionPersona() {
		// TODO Auto-generated method stub
		return vacunacionPersona;
	}

	@Override
	public void addVacunacion(VacunacionPersona vacunacionPersona) {
		// TODO Auto-generated method stub
		vacunacionRepository.save(vacunacionPersona);
	}

	@Override
	public void deleteVacunacion(String documento) {
		// TODO Auto-generated method stub
		vacunacionRepository.deleteById(documento);
	}

	@Override
	public Optional<VacunacionPersona> getPersonaVacunada(String documento) {
		// TODO Auto-generated method stub
		return vacunacionRepository.findById(documento);
	}

	@Override
	public List<VacunacionPersona> getPersonasVacunadas() {
		// TODO Auto-generated method stub
		return vacunacionRepository.findAll();
	}

	@Override
	public List<VacunacionPersona> searchVacunacionPersona(String barrio, String vacuna) {
		// TODO Auto-generated method stub
		List<VacunacionPersona> vacunaciones = new ArrayList<VacunacionPersona>();
		
		if(!barrio.isEmpty() && !vacuna.isEmpty()) {
			vacunaciones = vacunacionRepository.findByBarrioAndVacunaLike(barrio, vacuna);
		}else if(!barrio.isEmpty() && vacuna.isEmpty()) {
			vacunaciones = vacunacionRepository.findByBarrioLike(barrio);
		}else if(barrio.isEmpty() && !vacuna.isEmpty()) {
			vacunaciones = vacunacionRepository.findByVacunaLike(vacuna);
		}
		
		return vacunaciones;
	}

}
