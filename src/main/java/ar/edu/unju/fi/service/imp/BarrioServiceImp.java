package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.repository.IBarrioRepository;
import ar.edu.unju.fi.service.IBarrioService;

@Service
public class BarrioServiceImp implements IBarrioService{

	@Autowired
	IBarrioRepository barrioRepository;
	
	@Autowired
	Barrio barrio;
	
	@Override
	public Barrio getBarrio() {
		// TODO Auto-generated method stub
		return barrio;
	}

	@Override
	public void addBarrio(Barrio barrio) {
		// TODO Auto-generated method stub
		barrioRepository.save(barrio);
	}

	@Override
	public void deleteBarrio(String nombre) {
		// TODO Auto-generated method stub
		barrioRepository.deleteById(nombre);
	}

	@Override
	public Optional<Barrio> getBarrio(String nombre) {
		// TODO Auto-generated method stub
		return barrioRepository.findById(nombre);
	}

	@Override
	public List<Barrio> getBarrios() {
		// TODO Auto-generated method stub
		return barrioRepository.findAll();
	}

}
