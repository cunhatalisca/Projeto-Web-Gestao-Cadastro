package br.com.ucsal.controlehorario.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_disciplina", nullable = false)
	private Long codDisciplina;
	
	@Column(name="nome_disciplina", nullable = false)
	private String nomeDisciplina;
	
	@ManyToOne
	@JoinColumn(name="cod_professor", nullable = true)
	private Professor professor;

	public Long getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(Long codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
