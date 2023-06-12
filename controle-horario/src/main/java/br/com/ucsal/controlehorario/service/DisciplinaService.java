package br.com.ucsal.controlehorario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.controlehorario.model.Disciplina;
import br.com.ucsal.controlehorario.model.Professor;
import br.com.ucsal.controlehorario.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	public void excluir(Long id) {
		 disciplinaRepository.deleteById(id);
	}
	
	public Iterable<Disciplina> pegarTodasDisciplinas() {
		return disciplinaRepository.findAll();
	}

	public Disciplina encontraPeloId(Long id) {
		return disciplinaRepository.findById(id).get();
	}

	public List<Disciplina> buscarDisciplinasPorProfessor(Professor professor) {
		
		
		
		return professor.getDisciplina();
	}
}
