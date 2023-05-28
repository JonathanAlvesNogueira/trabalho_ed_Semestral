package model;

import java.util.List;

public class Grupo {

	int idGrupo;
	String[] alunos;
	String areaTrabalho;
	String orientador;
	String tema;
	
	String[] tarefas;
	
	
	public Grupo(int codigo, String alunos, String area, String orientador, String tema) {
		super();
		this.idGrupo = codigo;
		colocaAluno(alunos);
		this.areaTrabalho = area;
		this.orientador = orientador;
		this.tema = tema;
	}


	@Override
	public String toString() {
		return "Grupo [codigo=" + idGrupo + ", alunos=" + alunos + ", area=" + areaTrabalho + ", professor=" + orientador
				+ ", tema=" + tema + "]";
	}


	public void colocaAluno(String aluno) {
		int i = alunos.length;
		alunos[i] = aluno; 
	}
	
	public void colocaTarefas() {
		
	}
	
	
	
	
	
	
}
