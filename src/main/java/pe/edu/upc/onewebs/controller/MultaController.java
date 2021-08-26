package pe.edu.upc.onewebs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.onewebs.entity.Detenido;
import pe.edu.upc.onewebs.entity.Multa;
import pe.edu.upc.onewebs.service.DetenidoService;
import pe.edu.upc.onewebs.service.MultaService;

@Controller
@RequestMapping("onewebs/mulcts")
@SessionAttributes("multa")
public class MultaController {

	@Autowired
	private MultaService multaService;
	
	@Autowired
	private DetenidoService detenidoService;
		
	@GetMapping
	public String listAll(Model model) {		
		try {
			List<Multa> multas = multaService.readAll();
			model.addAttribute("multas", multas);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "/multa/listall";
	}
	@GetMapping("/new")
	public String nuevo(Model model) {
		Multa multa = new Multa();
		model.addAttribute("multa", multa);
		
		try {
			List<Detenido> detenidos = detenidoService.readAll();
			model.addAttribute("detenidos", detenidos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return "/multa/nuevo";
	}
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute("multa") Multa multa, BindingResult result, 
			Model model, SessionStatus status) {
		if( result.hasErrors() ) {
			try {
				List<Detenido> detenidos = detenidoService.readAll();
				model.addAttribute("detenidos", detenidos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return "/multa/nuevo";
		} 
		else {
			try {
				multaService.create(multa);
				status.setComplete();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return "redirect:/onewebs/mulcts";
		}
		
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Multa> optional = multaService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("multa", optional.get());
				
				List<Detenido> detenidos = detenidoService.readAll();
				model.addAttribute("detenidos", detenidos);
			}
			else {
				return "redirect:/onewebs/mulcts";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/multa/edit";
	}
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Multa> optional = multaService.findById(id);
			if( optional.isPresent() ) {
				multaService.deleteById(id);
			}
			else {
				return "redirect:/onewebs/mulcts";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/onewebs/mulcts";
	}
	
}
