package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPropietarioRepo;
import com.example.demo.repo.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepo propietarioRepo;

	@Override
	public void agregar(Propietario propietario) {
		this.propietarioRepo.insertar(propietario);
	}

	@Override
	public Propietario buscarId(Integer id) {
		return this.propietarioRepo.encontrarId(id);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.propietarioRepo.actualizar(propietario);
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepo.eliminar(id);
	}

	@Override
	public List<Propietario> buscarTodos() {
		return this.propietarioRepo.buscarTodos();
	}
	
	
	
}
