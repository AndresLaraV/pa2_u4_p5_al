package com.uce.edu.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.repository.IPersonaRepository;
import com.uce.edu.ec.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	private IPersonaRepository iPersonaRepository;

	@Override
	public void guardar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.inserta(persona);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.actualizar(persona);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.consultarPorCedula(cedula);
	}

	@Override
	public void eliminarPorCedual(String cedula) {
		// TODO Auto-generated method stub
		this.iPersonaRepository.eliminarPorCedual(cedula);
	}

	@Override
	public List<Persona> consultarTodos() {
		// TODO Auto-generated method stub
		return this.iPersonaRepository.consultarTodos();
	}

}
