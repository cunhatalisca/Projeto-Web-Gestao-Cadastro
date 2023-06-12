package br.com.ucsal.controlehorario.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ucsal.controlehorario.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
	
}
