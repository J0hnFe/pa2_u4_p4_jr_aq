package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Propietario;

public interface IPropietarioRepo {


	public void insertar(Propietario propietario);
	public Propietario encontrarId(Integer id);
	public void actualizar(Propietario propietario);
	public void eliminar(Integer id);
	public List<Propietario> buscarTodos();
	
		
	}
