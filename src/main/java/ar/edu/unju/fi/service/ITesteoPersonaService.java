package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.model.TesteoPersona;

public interface ITesteoPersonaService {
	
	public TesteoPersona getTesteoPersona();
	public void addTesteo(TesteoPersona testeoPersona);
	public void deleteTesteo(String documento);
	public Optional<TesteoPersona> getPersonaTesteada(String documento);
	public List<TesteoPersona> getPersonasTesteadas();
	public List<TesteoPersona> searchTesteoPersona(String resultado, String barrio);
	

}
