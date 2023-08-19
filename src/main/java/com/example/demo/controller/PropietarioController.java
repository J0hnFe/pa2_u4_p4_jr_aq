package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {

	@Autowired
	private IPropietarioService iPropietarioService;

	// http://localhost:8080/concesionario/propietarios/buscarTodos
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model model) {
		List<Propietario> list = this.iPropietarioService.buscarTodos();
		model.addAttribute("propietarios", list);
		return "vistaBuscarTodos";
	}
	// http://localhost:8080/concesionario/propietarios/buscarPorId/1
	@GetMapping("/buscarPorId/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model){
		Propietario p = this.iPropietarioService.buscarId(id);
		//envio el propietario mandarlo en un modeo
		model.addAttribute("propietario", p);
		//devuelvo una vista
		return   "vistaBuscarPorId";
	}
	
	//recibe modelo, NO LO DEVUELVE
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) {
		this.iPropietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscarTodos";
	}

}
