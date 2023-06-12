package br.com.ucsal.controlehorario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ucsal.controlehorario.model.Estudante;
import br.com.ucsal.controlehorario.service.EstudanteService;

@RestController
@RequestMapping("/gestao/estudante")
public class GestaoController {
	
	@Autowired
	EstudanteService estudanteService;
	
	
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.PUT})
	public Estudante salvarEstudante(Estudante estudante) {
		return estudanteService.salvar(estudante); 
	}
	
	@GetMapping(path="/{id}")
	public Estudante getStudentById(@PathVariable Long id) {
		return estudanteService.encontraPeloId(id);
	}
	
	@GetMapping
	public Iterable<Estudante> getAllStudents(){
		return estudanteService.pegarTodosEstudantes();
	}
	
}
