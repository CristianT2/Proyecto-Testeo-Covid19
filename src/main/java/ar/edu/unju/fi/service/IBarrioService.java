package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.Barrio;

public interface IBarrioService {
	
	public Barrio getBarrio();
	public void addBarrio(Barrio barrio);
	public void deleteBarrio(String nombre);
	public Optional<Barrio> getBarrio(String nombre);
	public List<Barrio> getBarrios();
	

}
