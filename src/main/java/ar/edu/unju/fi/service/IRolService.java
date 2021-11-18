package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.Rol;

public interface IRolService {

	public Rol getRol();
	public void addRol(Rol rol);
	public void deleteRol(String nombreRol);
	public Optional<Rol> getRol(String nombreRol);
	public List<Rol> getRoles();
	
}
