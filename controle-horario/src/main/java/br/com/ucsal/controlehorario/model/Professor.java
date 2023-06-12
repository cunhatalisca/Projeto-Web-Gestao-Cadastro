package br.com.ucsal.controlehorario.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="professor")
public class Professor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="matricula_professor", nullable = false)
	private Long matriculaProfessor;
	
	@Column(name="nome_completo_professor", nullable = false)
	private String nomeCompletoProfessor;
	
	@Column(name="email_professor", nullable = false)
	private String emailProfessor;
	
	@Column(name ="ano_egresso_professor", nullable = false)
	private String anoEgressoProfessor;
	
	@OneToMany
	@JoinColumn(nullable = true, name="cod_disciplina")
	private List<Disciplina> disciplina;

	
	public Long getMatriculaProfessor() {
		return matriculaProfessor;
	}

	public void setMatriculaProfessor(Long matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}

	public String getNomeCompletoProfessor() {
		return nomeCompletoProfessor;
	}

	public void setNomeCompletoProfessor(String nomeCompletoProfessor) {
		this.nomeCompletoProfessor = nomeCompletoProfessor;
	}

	public String getEmailProfessor() {
		return emailProfessor;
	}

	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}

	public String getAnoEgressoProfessor() {
		return anoEgressoProfessor;
	}

	public void setAnoEgressoProfessor(String anoEgressoProfessor) {
		this.anoEgressoProfessor = anoEgressoProfessor;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
