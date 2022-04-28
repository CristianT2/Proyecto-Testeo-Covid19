/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Torrejon Cristian
 *
 */

@Controller
public class PublicController {
	
	@GetMapping("/clinica/inicio")
	public String getIndexPage() {
		
		return "index";
	}

}
