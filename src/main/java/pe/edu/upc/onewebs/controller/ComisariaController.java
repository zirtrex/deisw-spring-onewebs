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

import pe.edu.upc.onewebs.entity.Comisaria;
import pe.edu.upc.onewebs.service.ComisariaService;

@Controller
@RequestMapping("onewebs/policestations")
@SessionAttributes("comisaria")
public class ComisariaController {

	@Autowired
	private ComisariaService comisariaService;
	
	@GetMapping
	public String listAll(Model model) {		
		try {
			List<Comisaria> comisarias = comisariaService.readAll();
			model.addAttribute("comisarias", comisarias);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "/comisaria/listall";
	}
	@GetMapping("/new")
	public String nuevo(Model model) {
		Comisaria comisaria = new Comisaria();
		model.addAttribute("comisaria", comisaria);
		return "/comisaria/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("comisaria") Comisaria comisaria, Model model, SessionStatus status) {
		try {
			comisariaService.create(comisaria);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/onewebs/policestations";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Comisaria> optional = comisariaService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("comisaria", optional.get());
			}
			else {
				return "redirect:/onewebs/policestations";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/comisaria/edit";
	}
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Comisaria> optional = comisariaService.findById(id);
			if( optional.isPresent() ) {
				comisariaService.deleteById(id);
			}
			else {
				return "redirect:/onewebs/policestations";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/onewebs/policestations";
	}
}
