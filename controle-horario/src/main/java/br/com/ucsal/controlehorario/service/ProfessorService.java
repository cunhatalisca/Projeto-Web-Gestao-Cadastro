package br.com.ucsal.controlehorario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.controlehorario.model.Professor;
import br.com.ucsal.controlehorario.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public void excluir(Long id) {
		 professorRepository.deleteById(id);
	}
	
	public Iterable<Professor> pegarTodosProfessores() {
		return professorRepository.findAll();
	}

	public Professor encontraPeloId(Long id) {
		return professorRepository.findById(id).get();
	}
}
