package com.uce.edu.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		return "";

	}

	// PUT
	@PutMapping("/actualizar")
	public String actualizar(String cedula) {
		return "";
	}

	// Delete
	@DeleteMapping("/borrar")
	public String borrar() {
		return "";
	}

	// Post
	@PostMapping("/guardar")
	public String guardar() {
		return "";
	}
}
