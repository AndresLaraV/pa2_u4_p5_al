package com.uce.edu.ec.repository;

import java.util.List;

import com.uce.edu.ec.repository.modelo.Persona;

public interface IPersonaRepository {
	
	public void inserta(Persona persona);

	public void actualizar(Persona persona);

	public Persona consultarPorCedula(String cedula);
	
	public List<Persona> consultarTodos ();

	public void eliminarPorCedula(String cedula);
}
