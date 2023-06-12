package br.com.ucsal.controlehorario.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="estudante")
public class Estudante implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="matricula_estudante", nullable = false)
	private Long matriculaEstudante;
	
	@Column(name="nome_completo_estudante", nullable = false)
	private String nomeCompletoEstudante;
	
	@Column(name="email_estudante", nullable = false)
	private String emailEstudante;
	
	@Column(name ="ano_egresso_estudante", nullable = false)
	private String anoEgressoEstudante;

	@ManyToMany
	@JoinColumn(nullable = true, name="cod_disciplina")
	private List<Disciplina> disciplina;

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

	public Long getMatriculaEstudante() {
		return matriculaEstudante;
	}

	public void setMatriculaEstudante(Long matriculaEstudante) {
		this.matriculaEstudante = matriculaEstudante;
	}

	public String getNomeCompletoEstudante() {
		return nomeCompletoEstudante;
	}

	public void setNomeCompletoEstudante(String nomeCompletoEstudante) {
		this.nomeCompletoEstudante = nomeCompletoEstudante;
	}

	public String getEmailEstudante() {
		return emailEstudante;
	}

	public void setEmailEstudante(String emailEstudante) {
		this.emailEstudante = emailEstudante;
	}

	public String getAnoEgressoEstudante() {
		return anoEgressoEstudante;
	}

	public void setAnoEgressoEstudante(String anoEgressoEstudante) {
		this.anoEgressoEstudante = anoEgressoEstudante;
	}


	
	
}
