package br.com.ucsal.controlehorario.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ucsal.controlehorario.model.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long>{
	
}
