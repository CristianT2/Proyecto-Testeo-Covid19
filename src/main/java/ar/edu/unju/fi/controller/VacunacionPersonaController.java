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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Barrio;
import ar.edu.unju.fi.model.PersonalSalud;
import ar.edu.unju.fi.model.Vacuna;
import ar.edu.unju.fi.model.VacunacionPersona;
import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonalSaludService;
import ar.edu.unju.fi.service.IVacunaService;
import ar.edu.unju.fi.service.IVacunacionPersonaService;

@Controller
public class VacunacionPersonaController {
	
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	IVacunaService vacunaService;
	
	@Autowired
	IPersonalSaludService personalSaludService;
	
	@Autowired
	IVacunacionPersonaService vacunacionService;
	
	List<Barrio> barrios = new ArrayList<Barrio>();
	List<Vacuna> vacunas = new ArrayList<Vacuna>();
	List<PersonalSalud> allPerSalud = new ArrayList<PersonalSalud>();
	
	
	@GetMapping("/vacunaciones/nuevo")
	public String getVacunacionFormPage(Model model) {
		
		this.barrios = barrioService.getBarrios();
		this.vacunas = vacunaService.getVacunas();
		this.allPerSalud = personalSaludService.getAllPersonalSalud();
		model.addAttribute("vacunacionPersona", vacunacionService.getVacunacionPersona());
		model.addAttribute("barrios", barrios);
		model.addAttribute("vacunas", vacunas);
		model.addAttribute("personalSalud", allPerSalud);
		
		return "nuevovacunacion";
	}
	
	@PostMapping("/vacunaciones/guardar")
	public ModelAndView guardarNewVacunacion(Model model, @Valid @ModelAttribute(name = "vacunacionPersona") VacunacionPersona vacunacionPersona, BindingResult result) {
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("nuevoVacunacion");
			modelView.addObject("barrios", barrioService.getBarrios());
			modelView.addObject("vacunas", vacunaService.getVacunas());
			modelView.addObject("personalSalud", personalSaludService.getAllPersonalSalud());
			return modelView;
		}else {
			this.barrios = barrioService.getBarrios();
			this.vacunas = vacunaService.getVacunas();
			this.allPerSalud = personalSaludService.getAllPersonalSalud();
			modelView = new ModelAndView("nuevoVacunacion");
			String mensaje = "El objeto se ha guardado correctamente en la base de datos";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("personaVacunada", vacunacionService.getVacunacionPersona());
			modelView.addObject("barrios", barrios);
			modelView.addObject("vacunas", vacunas);
			modelView.addObject("personalSalud", allPerSalud);
			vacunacionService.addVacunacion(vacunacionPersona);
			
			return modelView;
		}
	}	
		
	@GetMapping("/vacunaciones/lista")
	public String getListaVacunadosPage(Model model) {
			
		model.addAttribute("vacunacionPersona", vacunacionService.getVacunacionPersona());
		model.addAttribute("personasVacunadas", vacunacionService.getPersonasVacunadas());
			
		return "listavacunacion";
	}
	
	@GetMapping("/vacunaciones/editar/{documento}")
	public ModelAndView editarPersonaVacunada(Model model, @PathVariable(name = "documento") String documento) {
		
		this.barrios = barrioService.getBarrios();
		this.vacunas = vacunaService.getVacunas();
		this.allPerSalud = personalSaludService.getAllPersonalSalud();
		Optional<VacunacionPersona> personaVacunada = vacunacionService.getPersonaVacunada(documento);
		ModelAndView modelView = new ModelAndView("nuevovacunacion");
		modelView.addObject("barrios", barrios);
		modelView.addObject("vacunas", vacunas);
		modelView.addObject("personalSalud", allPerSalud);
		model.addAttribute("vacunacionPersona", personaVacunada);
		
		return modelView;
	}
	
	@GetMapping("/vacunaciones/eliminar/{documento}")
	public String eliminarPersonaVacunada(@PathVariable(name = "documento") String documento) {
		
		vacunacionService.deleteVacunacion(documento);
		
		return "redirect:/vacunaciones/lista";
	}
	
	@GetMapping("/vacunaciones/seleccionar/{documento}")
	public String selectPersonaVacunada(Model model, @PathVariable(name = "documento")String documento) {
		
		Optional<VacunacionPersona> personaVacunada = vacunacionService.getPersonaVacunada(documento);
		String msj = "Estas seguro que desea eliminar este registro: "+personaVacunada.get().getDocumento();
		model.addAttribute("msjEliminar", msj);
		model.addAttribute("vacunacionPersona", vacunacionService.getVacunacionPersona());
		model.addAttribute("personasVacunadas", vacunacionService.getPersonasVacunadas());
		
		return "listavacunacion";
	}

	@GetMapping("/vacunaciones/buscar")
	public String filtrarPersonasVacunadas(Model model, @ModelAttribute VacunacionPersona vacunacionPersona) {
		
		model.addAttribute("vacunacionPersona", vacunacionService.getVacunacionPersona());
		model.addAttribute("personasVacunadas", vacunacionService.searchVacunacionPersona(vacunacionPersona.getBarrio().getNombre(), vacunacionPersona.getVacuna().getNombre()));
		
		return "listavacunacion";
	}
	
}
