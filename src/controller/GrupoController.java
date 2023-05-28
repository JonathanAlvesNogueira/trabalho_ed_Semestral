package controller;

import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Grupo;

public class GrupoController {

	public void criaGrupo(){
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
		String aluno = JOptionPane.showInputDialog("Informe o aluno");
		String orientador = JOptionPane.showInputDialog("Informe o orientador");
		String tema = JOptionPane.showInputDialog("Informe o tema");
		String areaTrabalho = JOptionPane.showInputDialog("Informe a area");
		
		Grupo grupo = new Grupo(codigo, aluno, areaTrabalho, orientador, tema);
		
		
		
	}
	
	
	
	
	
	
	
}
