package com.uce.edu.ec.controller;

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

import com.uce.edu.ec.repository.modelo.Persona;
import com.uce.edu.ec.service.IPersonaService;

//http://localhost:8080/personas/buscarTodos
//http://localhost:8080/personas/actualizar

@Controller
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	public IPersonaService iPersonaService;
	
	// Diferentes tipos de request
	// verbos o metodos HTTP

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista = this.iPersonaService.consultarTodos();
		// Conectar con la vista
		modelo.addAttribute("personas", lista);
		return "vistaListaPersonas";
	}

	// Path
	// GET
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
		Persona persona = this.iPersonaService.buscarPorCedula(cedula);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";

	}

	// PUT
	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar(@PathVariable("cedulaPersona") Persona persona, String cedula) {
		persona.setCedula(cedula);
		
		Persona perAux = this.iPersonaService.buscarPorCedula(cedula);
		perAux.setApellido(persona.getApellido());
		perAux.setNombre(persona.getNombre());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());

		this.iPersonaService.actualizar(perAux);

		return "redirect:/personas/buscarTodos";
	}

	// Post
	@PostMapping("/insertar")
	public String insertar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}
	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo, Persona persona) {
		modelo.addAttribute("persona", persona);
		return "vistaNuevaPersona";
		
	}

	// Delete
	@DeleteMapping("/borrar/{cedulaPersona}")
	public String borrar(@PathVariable("cedulaPersona") Model modelo, String cedula) {
		this.iPersonaService.eliminarPorCedula(cedula);
		return "";
	}

}
