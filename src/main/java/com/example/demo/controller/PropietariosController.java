package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietariosController {

	@Autowired
	private IPropietarioService propietarioService;

	// http://localhost:8080/concesionario/propietarios/buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.propietarioService.buscarTodos();
		modelo.addAttribute("propietarios", lista);
		return "vistaListaPropietarios";
	}

	// http://localhost:8080/concesionario/propietarios/buscarPorID/1
	@GetMapping("/buscarPorID/{idPropietario}")
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model modelo) {
		Propietario prop = this.propietarioService.buscarPorId(id);
		modelo.addAttribute("propietario", prop);
		return "vistaPropietario";

	}

	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) {
		this.propietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscar";
	}

	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorID(@PathVariable("idPropietario") Integer id) {
		this.propietarioService.eliminar(id);
		return "redirect:/propietarios/buscar";
	}

	// http://localhost:8080/concesionario/propietarios/guardar
	@PostMapping("/guardar")
	public String insertarPropietario(Propietario propietario) {
		this.propietarioService.insertar(propietario);
		return "redirect:/propietarios/buscar";
	}

	// Metodo pg de redireccionamiento
	//	http://localhost:8080/concesionario/propietarios/nuevo
	@GetMapping("/nuevo")
	public String paginaNuevoPropietario() {
		return "";
	}

}
