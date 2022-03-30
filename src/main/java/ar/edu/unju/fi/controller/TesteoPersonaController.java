package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.model.PersonalSalud;
import ar.edu.unju.fi.model.TesteoPersona;
import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonalSaludService;
import ar.edu.unju.fi.service.ITesteoPersonaService;

@Controller
public class TesteoPersonaController {

	@Autowired
	ITesteoPersonaService testPersonaService;
	
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	IPersonalSaludService perSaludService;
	
	
	List<Barrio> barrios = new ArrayList<Barrio>();
	List<PersonalSalud> allPersonalSalud = new ArrayList<PersonalSalud>();
	
	@GetMapping("/testeos/nuevo")
	public String getTesteoPersFormPage(Model model) {
	
		this.barrios = barrioService.getBarrios();
		this.allPersonalSalud = perSaludService.getAllPersonalSalud();
		model.addAttribute("testeoPersona", testPersonaService.getTesteoPersona());
		model.addAttribute("barrios", barrios);
		model.addAttribute("personalSalud", allPersonalSalud);
		
		return "nuevotesteo";
	}
	
	@PostMapping("/testeos/guardar")
	public ModelAndView guardarTesteoPers(Model model, @Valid @ModelAttribute TesteoPersona testeoPersona, BindingResult result) {
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("nuevotesteo");
			modelView.addObject("barrios", barrioService.getBarrios());
			modelView.addObject("allPerSalud", perSaludService.getAllPersonalSalud());
			return modelView;
		} else {
			modelView = new ModelAndView("nuevotesteo");
			String mensaje = "El objeto se ha guardado correctamente en la base de datos";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("testeoPersona", testPersonaService.getTesteoPersona());
			modelView.addObject("barrios", barrioService.getBarrios());
			modelView.addObject("allPerSalud", perSaludService.getAllPersonalSalud());
			testPersonaService.addTesteo(testeoPersona);
			
			return modelView;
		}
	}
	
	@GetMapping("/testeos/lista")
	public String getlistaTesteosPage(Model model) {
		
		model.addAttribute("personaTesteada", testPersonaService.getTesteoPersona());
		model.addAttribute("personasTesteadas", testPersonaService.getPersonasTesteadas());
		
		return "listatesteos";
	}
	
	@GetMapping("/testeos/editar/{documento}")
	public ModelAndView editarPersonaTesteada(@PathVariable String documento, Model model) {
		
		this.barrios = barrioService.getBarrios();
		this.allPersonalSalud = perSaludService.getAllPersonalSalud();
		ModelAndView modelView = new ModelAndView("nuevotesteo");
		Optional<TesteoPersona> personaTesteada = testPersonaService.getPersonaTesteada(documento);
		modelView.addObject("barrios", barrios);
		modelView.addObject("allPerSalud", allPersonalSalud);
		model.addAttribute("persona", personaTesteada);
		
		return modelView;
	}
	
	@GetMapping("/testeos/eliminar/{documento}")
	public String eliminarPersonaTesteada(@PathVariable String documento) {
		
		testPersonaService.deleteTesteo(documento);
		
		return "redirect:/testeos/lista";
	}
	
	@GetMapping("/testeos/seleccionar/{documento}")
	public String selectPersonaTesteada(@PathVariable String documento, Model model) {
		
		Optional<TesteoPersona> personaTesteada = testPersonaService.getPersonaTesteada(documento);
		String msj ="Estas seguro que deceas eliminar este registro: "+personaTesteada.get().getDocumento();
		model.addAttribute("msjEliminar", msj);
		model.addAttribute("personaTesteada", personaTesteada);
		model.addAttribute("personasTesteadas", testPersonaService.getPersonasTesteadas());
		
		return "listatesteos";
	}
	
	@GetMapping("/testeos/buscar")
	public String findPersonasTesteadas(Model model, @RequestParam(name = "resultado") String resultado, @ModelAttribute(name = "testeoPersona") TesteoPersona testeoPersona) {
		
		model.addAttribute("personaTesteada", testPersonaService.getTesteoPersona());
		model.addAttribute("personasTesteadas", testPersonaService.searchTesteoPersona(resultado, testeoPersona.getBarrio().getNombre()));
		
		return "listatesteos";
	}
	
}
