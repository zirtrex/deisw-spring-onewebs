package pe.edu.upc.onewebs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.onewebs.entity.Detenido;
import pe.edu.upc.onewebs.service.DetenidoService;

@Controller
@RequestMapping("onewebs/detainee")
@SessionAttributes("detenido")
public class DetenidoController {
	
	@Autowired
	private DetenidoService detenidoService; 
	
	@GetMapping
	public String start(Model model) {		
		try {
			// Objeto detenido utilizado para la busqueda
			Detenido detenido = new Detenido();
			// Activar en el caso de que salga error por los Validations
			/*detenido.setDni("99999999");
			detenido.setNombres("nombres");
			detenido.setDistrito("distrito");*/
			model.addAttribute("detenido", detenido);
			
			List<Detenido> detenidos = detenidoService.readAll();			
			model.addAttribute("detenidos", detenidos);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "/detenido/start";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		Detenido detenido = new Detenido();
		model.addAttribute("detenido", detenido);
		return "/detenido/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("detenido") Detenido detenido, Model model, SessionStatus status) {
		try {
			detenidoService.create(detenido);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/onewebs/detainee";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("detenido", optional.get());
			}
			else {
				return "redirect:/onewebs/detainee";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/detenido/edit";
	}
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				detenidoService.deleteById(id);
			}
			else {
				return "redirect:/onewebs/detainee";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/onewebs/detainee";
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("detenido") Detenido detenido, Model model) {
		try {
			List<Detenido> detenidos = detenidoService.fetchByApellidos( detenido.getApellidos() );
			model.addAttribute("detenidos", detenidos);			
			model.addAttribute("detenido", detenido);
			// Mensajes
			if (detenidos.size() > 0) {
				model.addAttribute("mensajeOK", "Se encontraron: " + detenidos.size() + " detenidos");
			} else {
				model.addAttribute("mensajeError", "No se encontro ningún detenido");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		return "/detenido/start";
	}
	
	
	
	
	
	
	
	
	
}
