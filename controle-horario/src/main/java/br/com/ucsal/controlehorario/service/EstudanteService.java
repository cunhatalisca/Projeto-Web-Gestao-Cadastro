package br.com.ucsal.controlehorario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.controlehorario.model.Estudante;
import br.com.ucsal.controlehorario.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public Estudante salvar(Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	
	public void excluir(Long id) {
		 estudanteRepository.deleteById(id);
	}
	
	public Iterable<Estudante> pegarTodosEstudantes() {
		return estudanteRepository.findAll();
	}

	public Estudante encontraPeloId(Long id) {
		return estudanteRepository.findById(id).get();
	}
}
