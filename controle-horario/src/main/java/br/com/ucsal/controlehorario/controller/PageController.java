package br.com.ucsal.controlehorario.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ucsal.controlehorario.model.Disciplina;
import br.com.ucsal.controlehorario.model.Estudante;
import br.com.ucsal.controlehorario.model.Professor;
import br.com.ucsal.controlehorario.service.DisciplinaService;
import br.com.ucsal.controlehorario.service.EstudanteService;
import br.com.ucsal.controlehorario.service.ProfessorService;

@Controller
public class PageController {

	@Autowired
	private EstudanteService estudanteService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private DisciplinaService disciplinaService;

	@RequestMapping(value = "/gestao")
	public String getInit() {
		return "Index";
	}

	@RequestMapping("/estudantes")
	public ModelAndView listaEstudante() {
		ModelAndView mv = new ModelAndView("/estudante");
		Integer i = 0;
		Iterable<Estudante> estudantes = estudanteService.pegarTodosEstudantes();
		mv.addObject("estudantes", estudantes);
		mv.addObject("i",i);
		
		return mv;
	}

	@RequestMapping("/deletar-estudante/{id}")
	public String deletarEstudante(@PathVariable Long id) {
		estudanteService.excluir(id);
		return "redirect:/estudantes";
	}

	@RequestMapping(value = "/cadastrarEstudante", method=RequestMethod.GET)
	public String cadastrarEstudante() {
		return "CadastroEstudante";
	}
	
	@RequestMapping(value = "/cadastrarEstudante", method=RequestMethod.POST)
	public String cadastrarEstudante(Estudante estudante) {
		estudanteService.salvar(estudante);
		return "redirect:/estudantes";
	}
	
	@RequestMapping("/matricularEstudante/{id}")
	public ModelAndView matricularEstudante(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("/MatricularEstudante");
		Estudante estudante = estudanteService.encontraPeloId(id);
		mv.addObject("estudante", estudante);
		
		Iterable<Disciplina> disciplinas = disciplinaService.pegarTodasDisciplinas();
		mv.addObject("disciplinas", disciplinas);
		return mv;
	}
	
	@RequestMapping(value="/matricularEstudante/{matriculaEstudante}/{codDisciplina}")
	public String matricularEstudante(@PathVariable Long matriculaEstudante, @PathVariable Long codDisciplina){
		
		Estudante estudante = estudanteService.encontraPeloId(matriculaEstudante);
		if(estudante.getDisciplina() == null) {
			List<Disciplina> disciplinas = new ArrayList<>();
			disciplinas.add(disciplinaService.encontraPeloId(codDisciplina));
		}else {
			estudante.getDisciplina().add(disciplinaService.encontraPeloId(codDisciplina));
		}
			
		estudanteService.salvar(estudante);
		
		return "redirect:/estudantes";
	}

	@RequestMapping("/professores")
	public ModelAndView listaProfessor() {
		ModelAndView mv = new ModelAndView("/professor");
		Iterable<Professor> professores = professorService.pegarTodosProfessores();
		mv.addObject("professores", professores);
		return mv;
	}
	
	@RequestMapping("/deletar-professor/{id}")
	public String deletarProfessor(@PathVariable Long id) {
		professorService.excluir(id);
		return "redirect:/professores";
	}
	
	@RequestMapping(value = "/cadastrarProfessor", method=RequestMethod.GET)
	public String cadastrarProfessor() {
		return "CadastroProfessor";
	}
	
	@RequestMapping(value = "/cadastrarProfessor", method=RequestMethod.POST)
	public String cadastrarProfessor(Professor professor) {
		professorService.salvar(professor);
		return "redirect:/professores";
	}
	

	@RequestMapping("/disciplinas")
	public ModelAndView listaDisciplina() {
		ModelAndView mv = new ModelAndView("/disciplina");
		Iterable<Disciplina> displicinas = disciplinaService.pegarTodasDisciplinas();
		mv.addObject("disciplinas", displicinas);
		return mv;
	}
	
	@RequestMapping("/deletar-disciplina/{id}")
	public String deletarDisciplina(@PathVariable Long id) {
		disciplinaService.excluir(id);
		return "redirect:/disciplinas";
	}
	
	@RequestMapping(value = "/cadastrarDisciplina", method=RequestMethod.GET)
	public String cadastrarDisciplina() {
		return "CadastroDisciplina";
	}
	
	@RequestMapping(value = "/cadastrarDisciplina", method=RequestMethod.POST)
	public String cadastrarDisciplina(Disciplina disciplina) {
		
		disciplinaService.salvar(disciplina);
	
		return "redirect:/disciplinas";
	}
}
