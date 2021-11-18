package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.model.Vacuna;

public interface IVacunaService {
	
	public Vacuna getVacuna();
	public void addVacuna(MultipartFile file, Vacuna vacuna);
	public void deleteVacuna(String nombre);
	public Optional<Vacuna> getVacuna(String nombre);
	public List<Vacuna> getVacunas();
}
