package com.uce.edu.ec.service;

import java.util.List;

import com.uce.edu.ec.repository.modelo.Persona;

public interface IPersonaService {
	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public Persona buscarPorCedula(String cedula);

	public List<Persona> consultarTodos();

	public void eliminarPorCedual(String cedula);
}
