package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Aluno;

public class AlunoController implements ActionListener{

	private JTextField tfNomeAluno;
	private JTextField tfRAAluno;
	
	public AlunoController(JTextField tfNomeAluno, JTextField tfRAAluno) {
		super();
		this.tfNomeAluno = tfNomeAluno;
		this.tfRAAluno = tfRAAluno;
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Gravar")) {
			grava();
		}
		if(cmd.equals("Excluir")) {
			exclui();
		}
		
	}






	private void exclui() {
		Aluno aluno = new Aluno();
		aluno.nome = "";
		aluno.codigo = "";
		
	}






	private void grava() {
		Aluno aluno = new Aluno();
		aluno.nome = tfNomeAluno.getText();
		aluno.codigo = tfRAAluno.getText();
	}

	
	
	
	
	
}
