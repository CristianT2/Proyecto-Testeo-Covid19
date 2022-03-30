package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.TesteoPersona;
import ar.edu.unju.fi.repository.ITesteoPersonaRepository;
import ar.edu.unju.fi.service.ITesteoPersonaService;

@Service
public class TesteoPersonaServiceImp implements ITesteoPersonaService{

	@Autowired
	ITesteoPersonaRepository testeoRepository;
	
	@Autowired
	TesteoPersona testeoPersona;
	
	@Override
	public TesteoPersona getTesteoPersona() {
		// TODO Auto-generated method stub
		return testeoPersona;
	}

	@Override
	public void addTesteo(TesteoPersona testeoPersona) {
		// TODO Auto-generated method stub
		testeoRepository.save(testeoPersona);
	}

	@Override
	public void deleteTesteo(String documento) {
		// TODO Auto-generated method stub
		testeoRepository.deleteById(documento);
	}

	@Override
	public Optional<TesteoPersona> getPersonaTesteada(String documento) {
		// TODO Auto-generated method stub
		return testeoRepository.findById(documento);
	}

	@Override
	public List<TesteoPersona> getPersonasTesteadas() {
		// TODO Auto-generated method stub
		return testeoRepository.findAll();
	}

	@Override
	public List<TesteoPersona> searchTesteoPersona(String resultado, String barrio) {
		
		List<TesteoPersona> testeos = new ArrayList<TesteoPersona>();
		
		if(!resultado.isEmpty() && !barrio.isEmpty()){
			testeos = testeoRepository.findByResultadoAndBarrioNombreLike(resultado, barrio); 
		}else if(!resultado.isEmpty() && barrio.isEmpty()){
			testeos = testeoRepository.findByResultadoLike(resultado);
		}else if(resultado.isEmpty() && !barrio.isEmpty()){
			testeos = testeoRepository.findByBarrioNombreLike(barrio);
		}else if(resultado.isEmpty() && barrio.isEmpty()) {
			testeos = testeoRepository.findAll();
		}
		
		return testeos;
	}

}
