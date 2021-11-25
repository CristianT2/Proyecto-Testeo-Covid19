package ar.edu.unju.fi.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Vacuna;
import ar.edu.unju.fi.service.IVacunaService;

@Controller
public class VacunaController {
	
	@Autowired
	IVacunaService vacunaService;
	
	@GetMapping("/vacuna/nueva")
	public String getVacunaFormPage(Model model) {
		
		model.addAttribute("vacuna", vacunaService.getVacuna());
		
		return "newvacuna";
	}
	
	@PostMapping("/vacuna/guadar")
	public ModelAndView guardarNewVacuna(Model model, @RequestParam("file") MultipartFile file, @Valid @ModelAttribute(name = "vacuna") Vacuna vacuna, BindingResult result) {
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("newvacuna");
			return modelView;
		}else {
			modelView = new ModelAndView("newvacuna");
			String mensaje = "El objeto se ha guardado correctamente en la base de datos.";
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("vacuna", vacunaService.getVacuna());
			vacunaService.addVacuna(file, vacuna);
			
			return modelView;
		}
	}

	@GetMapping("/vacuna/lista")
	public String getListaVacunasPage(Model model) {
		
		model.addAttribute("vacuna", vacunaService.getVacuna());
		model.addAttribute("vacunas", vacunaService.getVacunas());
		
		return "listavacunas";
	}
	
	@PutMapping("/vacuna/editar{nombre}")
	public ModelAndView editarVacuna(Model model, @PathVariable String nombre) {
		
		Optional<Vacuna> vacuna = vacunaService.getVacuna(nombre);
		model.addAttribute("vacuna", vacuna);
		ModelAndView modelView = new ModelAndView("newvacuna");
		
		return modelView;
	}
	
	@DeleteMapping("/vacuna/eliminar/{nombre}")
	public String eliminarVacuna(@PathVariable String nombre) {
		
		vacunaService.deleteVacuna(nombre);
		
		return "redirect:/vacuna/lista";
	}
	
	@GetMapping("/vacuna/seleccionar/{nombre}")
	public String selectVacuna(@PathVariable String nombre, Model model) {
		
		Optional<Vacuna> vacuna = vacunaService.getVacuna(nombre);
		String  msj = "Estas seguro que quieres eliminar este registro: "+vacuna.get().getNombre();
		model.addAttribute("msjEliminar", msj);
		model.addAttribute("vacuna", vacuna);
		model.addAttribute("vacunas", vacunaService.getVacunas());
		
		return "listavacunas";
	}
}
