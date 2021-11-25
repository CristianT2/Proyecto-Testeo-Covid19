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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Rol;
import ar.edu.unju.fi.service.IRolService;

@Controller
public class RolController {

	@Autowired
	IRolService rolService;
	
	@GetMapping("/rol/nuevo")
	public String getRolFormPage(Model model) {
		
		model.addAttribute("rol", rolService.getRol());
		
		return "nuevorol";
	}
	
	@PostMapping("/rol/guardar")
	public ModelAndView saveNewRol(Model model, @Valid @ModelAttribute(name = "rol") Rol rol, BindingResult result) {
		
		ModelAndView modelView;
		
		if(result.hasErrors()) {
			modelView = new ModelAndView("nuevorol");
			return modelView;
		}else{
			modelView = new ModelAndView("nuevorol");
			String mensaje = "El objeto se guardo correctamente en la base de datos: "+ rol.getNombreRol();
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("rol", rolService.getRol());
			rolService.addRol(rol);
			
			return modelView;
		}	
	}
	
	@GetMapping("/rol/lista")
	public String listarRolPage(Model model) {
		
		model.addAttribute("rol",rolService.getRol());
		model.addAttribute("roles", rolService.getRoles());
		
		return "listaroles"; 
	}
	
	@PutMapping("/rol/editar/{nombreRol}")
	public ModelAndView editarRol(@PathVariable String nombreRol, Model model) {
		
		Optional<Rol> rolOp = rolService.getRol(nombreRol);
		model.addAttribute("rol", rolOp);
		ModelAndView modelView = new ModelAndView("nuevorol");
		
		return modelView;
	}
	
	@DeleteMapping("/rol/eliminar/{nombreRol}")
	public String eliminarRol(@PathVariable String nombreRol, Model model) {
		
		rolService.deleteRol(nombreRol);
		
		return "redirect:/rol/lista";
	}
	
	@GetMapping("/rol/seleccionar/{nombreRol}")
	public String seleccionarRol(@PathVariable String nombreRol, Model model) {
		
		Optional<Rol> rol = rolService.getRol(nombreRol);
		String msjEliminar = "Estas seguro que desea eliminar este registro: " + rol.get().getNombreRol()+ "";
		model.addAttribute("mensajeElim", msjEliminar);
		model.addAttribute("rol", rol);
		model.addAttribute("roles", rolService.getRoles());
		
		return "listaroles";
	}
	
}
