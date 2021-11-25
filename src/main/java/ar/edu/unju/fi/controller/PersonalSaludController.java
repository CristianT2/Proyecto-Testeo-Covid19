package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.PersonalSalud;
import ar.edu.unju.fi.model.Rol;
import ar.edu.unju.fi.service.IPersonalSaludService;
import ar.edu.unju.fi.service.IRolService;

@Controller
public class PersonalSaludController {
	
	List<Rol> roles = new ArrayList<Rol>();
	
	@Autowired
	IPersonalSaludService personalSaludService;
	
	@Autowired
	IRolService rolService;
	
	@GetMapping("/personaldeSalud/nuevo")
	public String getPersonalSaludFormPage(Model model) {
		
		this.roles = rolService.getRoles();
		model.addAttribute("roles", roles);
		model.addAttribute("personalSalud", personalSaludService.getPersonalSalud());
		
		return "nuevopersalud";
	}
	
	@PostMapping("/personaldeSalud/guardar")
	public ModelAndView guardarPersonalSalud(Model model, @Valid @ModelAttribute(name = "personalSalud") PersonalSalud personalSalud, BindingResult result){
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("nuevopersalud");
			modelView.addObject("roles", rolService.getRoles());
			return modelView;
		}else {
			this.roles = rolService.getRoles();
			modelView = new ModelAndView("nuevopersalud");
			String msj = "El objeto se ha guardado correctamente en la base de datos.";
			model.addAttribute("mensaje", msj);
			model.addAttribute("personalSalud", personalSaludService.getPersonalSalud());
			personalSaludService.addPersonalSalud(personalSalud);
			modelView.addObject("roles", roles);
			return modelView;
		}
	}
	
	@GetMapping("/personaldeSalud/lista")
	public String getListaPersonalSaludPage(Model model) {
		
		model.addAttribute("personalSalud", personalSaludService.getPersonalSalud());
		model.addAttribute("allPersonalSalud", personalSaludService.getAllPersonalSalud());
		
		return "listapersalud";
	}
	
	
	@PutMapping("/personaldeSalud/editar/{id}")
	public ModelAndView editarPersonalSalud(@PathVariable Integer id, Model model) {
		
		this.roles = rolService.getRoles();
		ModelAndView modelView = new ModelAndView("nuevopersalud");
		Optional<PersonalSalud> perSalud = personalSaludService.getPersonalSalud(id);
		model.addAttribute("personalSalud", perSalud);
		modelView.addObject("roles", roles);
		
		return modelView;
	}
	
	@DeleteMapping("/personaldeSalud/eliminar/{id}")
	public String eliminarPersonalSalud(@PathVariable Integer id, Model model) {
		
		personalSaludService.deletePersonalSalud(id);
		
		return "redirect:/personaldeSalud/lista";
	}
	
	@GetMapping("/personaldeSalud/seleccionar/{id}")
	public String selectPersonalSalud(@PathVariable Integer id, Model model) {
		
		Optional<PersonalSalud> persSalud = personalSaludService.getPersonalSalud(id);
		String msjElim = "Estas seguro que deseas eliminar este registro: "+persSalud.get().getNombre();
		model.addAttribute("mensaje", msjElim);
		model.addAttribute("personal", persSalud);
		model.addAttribute("allPersonal", personalSaludService.getAllPersonalSalud());
		
		return "listapersalud";
	}
	
	@GetMapping("/personaldeSalud/buscar")
	public String filtrarPersonalSalud(@RequestParam(name = "apellido") String apellido, Model model, @ModelAttribute(name = "personalSalud") PersonalSalud personalSalud) {
		
		model.addAttribute("personalSalud", personalSaludService.getPersonalSalud());
		model.addAttribute("allPersonalSalud", personalSaludService.searchPersonalSalud(apellido, personalSalud.getRol().getNombreRol()));
		
		return "listapersalud";
	}
	
}
