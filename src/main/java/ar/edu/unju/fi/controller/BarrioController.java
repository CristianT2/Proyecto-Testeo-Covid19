package ar.edu.unju.fi.controller;

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
import ar.edu.unju.fi.service.IBarrioService;

@Controller
public class BarrioController {
	
	@Autowired
	IBarrioService barrioService;
	
	@GetMapping("/barrio/nuevo")
	public String getBarrioFormPage(Model model) {
		
		model.addAttribute("barrio", barrioService.getBarrio());
		
		return "nuevobarrio";
	}
	
	@PostMapping("/barrio/guardar")
	public ModelAndView guardarBarrio(Model model, @Valid @ModelAttribute (name = "barrio") Barrio barrio, BindingResult result) {
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("nuevobarrio");
			
			return modelView;
		}else{
			modelView = new ModelAndView("nuevobarrio");
			String msj = "El objeto se guardó correctamente en la base de datos.";
			model.addAttribute("mensaje", msj);
			model.addAttribute("barrio", barrioService.getBarrio());
			barrioService.addBarrio(barrio);
			
			return modelView;
		}
	}
	
	@GetMapping("/barrio/lista")
	public String getListaBarrioPage(Model model) {
		
		model.addAttribute("barrio", barrioService.getBarrio());
		model.addAttribute("barrios", barrioService.getBarrios());
		
		return "listabarrios";
	}
	
	@GetMapping("/barrio/editar/{nombre}")
	public ModelAndView editarBarrio(@PathVariable String nombre, Model model) {
		
		Optional<Barrio> barrio = barrioService.getBarrio(nombre);
		model.addAttribute("barrio", barrio);
		ModelAndView modelView = new ModelAndView("nuevobarrio");
		
		return modelView;
	}
	
	@GetMapping("/barrio/eliminar/{nombre}")
	public String eliminarBarrio(Model model, @PathVariable String nombre) {
		
		barrioService.deleteBarrio(nombre);
		
		return "redirect:/barrio/lista";
	}
	
	@GetMapping("/barrio/seleccionar/{nombre}")
	public String selectBarrio(Model model, @PathVariable String nombre) {
	
		Optional<Barrio> barrio = barrioService.getBarrio(nombre);
		String msj = "Estas seguro que deseas eliminar este registro: "+barrio.get().getNombre();
		model.addAttribute("mensajeElim", msj);
		model.addAttribute("barrio", barrio);
		model.addAttribute("barrios", barrioService.getBarrios());
		
		return "listabarrios";
	}

}
