package ar.edu.unju.fi.service.imp;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.model.Vacuna;
import ar.edu.unju.fi.repository.IVacunaRepository;
import ar.edu.unju.fi.service.IVacunaService;

@Service
public class VacunaServiceImp implements IVacunaService{

	@Autowired
	IVacunaRepository vacunaRepository;
	
	@Autowired
	Vacuna vacuna;

	@Override
	public Vacuna getVacuna() {
		// TODO Auto-generated method stub
		return vacuna;
	}

	@Override
	public void addVacuna(MultipartFile file, Vacuna vacuna) {
		// TODO Auto-generated method stub
		try {
			vacuna.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		vacunaRepository.save(vacuna);
	}

	@Override
	public void deleteVacuna(String nombre) {
		// TODO Auto-generated method stub
		vacunaRepository.deleteById(nombre);
	}

	@Override
	public Optional<Vacuna> getVacuna(String nombre) {
		// TODO Auto-generated method stub
		return vacunaRepository.findById(nombre);
	}

	@Override
	public List<Vacuna> getVacunas() {
		// TODO Auto-generated method stub
		return vacunaRepository.findAll();
	}

}
