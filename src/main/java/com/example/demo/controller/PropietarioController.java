package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService iPropietarioService;
	
	
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Propietario>list =	this.iPropietarioService.buscarTodos();
	model.addAttribute("propietarios",list);

	
	
		
		return "vistaBuscarTodos";
	}
		
	
}
