package com.projeto.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.bean.Cargo;
import com.projeto.service.CargoService;

@Controller
@RequestMapping(value="/login/crud/Cargo")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("criar")
	public ModelAndView criar(HttpServletRequest request, @RequestParam(name = "id", required = false)Integer id) {
		
		if(id != null) {
			Optional<Cargo> cargo = cargoService.findById(id);
			if(cargo.isPresent()) {
				Cargo form = cargo.get();
				request.setAttribute("cargo", form);
			}
		}
		request.setAttribute("page", "cargoEntrada.jsp");
		return new ModelAndView("/login/crud/base");
	}

	@GetMapping("")
	public ModelAndView listar(HttpServletRequest request) {
		request.setAttribute("listaCargo", cargoService.findAll());
		request.setAttribute("page", "cargoListagem.jsp");
		return new ModelAndView("/login/crud/base");
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(Cargo cargo, RedirectAttributes redirectAttributes)  {
		try {
			cargoService.save(cargo);
			redirectAttributes.addFlashAttribute("sucesso", "Cargo salvo com sucesso");
			return new ModelAndView("redirect:/login/crud/Cargo");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("erro", "Erro : "+e.getMessage());
		}
		redirectAttributes.addFlashAttribute("cargo", cargo);
		return new ModelAndView("redirect:/login/crud/Cargo/criar");
	}
	
	@GetMapping("excluir")
	public ModelAndView excluir(@RequestParam(name = "id", required = true)Integer id,  RedirectAttributes redirectAttributes) {
		
		if(id != null){
			try {
				cargoService.deleteById(id);
				redirectAttributes.addFlashAttribute("sucesso", "Cargo deletado com sucesso");
			}catch(Exception e) {
				redirectAttributes.addFlashAttribute("erro", "Não foi possível excluir esse cargo.");
			}
		}
		
		return new ModelAndView("redirect:/login/crud/Cargo");
	}
	
}

