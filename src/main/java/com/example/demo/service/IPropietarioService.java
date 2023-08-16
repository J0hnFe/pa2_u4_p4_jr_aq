package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Propietario;

public interface IPropietarioService {

	public void agregar(Propietario propietario);
	public Propietario buscarId(Integer id);
	public void actualizar(Propietario propietario);
	public void borrar(Integer id);
	public List<Propietario> buscarTodos();
	
}
