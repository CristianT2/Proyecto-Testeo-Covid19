package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Rol;
import ar.edu.unju.fi.repository.IRolRepository;
import ar.edu.unju.fi.service.IRolService;

@Service
public class RolServiceImp implements IRolService{

	@Autowired
	IRolRepository rolRepository;
	
	@Autowired
	Rol rol;
	
	@Override
	public Rol getRol() {
		// TODO Auto-generated method stub
		return rol;
	}

	@Override
	public void addRol(Rol rol) {
		// TODO Auto-generated method stub
		rolRepository.save(rol);
	}

	@Override
	public void deleteRol(String nombreRol) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(nombreRol);
	}

	@Override
	public Optional<Rol> getRol(String nombreRol) {
		// TODO Auto-generated method stub
		return rolRepository.findById(nombreRol);
	}

	@Override
	public List<Rol> getRoles() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

}
