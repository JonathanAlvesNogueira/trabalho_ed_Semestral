package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

import model.Aluno;

public class AlunoController implements ActionListener {

	private JTextField tfNomeAluno;
	private JTextField tfRAAluno;
	private JTextField tfWhatsaapAluno;

	public AlunoController(JTextField tfNomeAluno, JTextField tfRAAluno) {
		super();
		this.tfNomeAluno = tfNomeAluno;
		this.tfRAAluno = tfRAAluno;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Gravar")) {
			grava();
		}
		if (cmd.equals("Excluir")) {
			exclui();
		}

	}

	private void exclui() {
		Aluno aluno = new Aluno();
		aluno.nome = "";
		aluno.codigo = "";

	}

	private void grava() throws IOException {
		Aluno aluno = new Aluno();
		aluno.nome = tfNomeAluno.getText();
		aluno.codigo = tfRAAluno.getText();
		aluno.whatsapp = tfWhatsaapAluno.getText();
		try {
			gravandoAluno("alunos.csv", aluno.nome, aluno.codigo, aluno.whatsapp);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void gravandoAluno(String nomeArq, String nomeAluno, String codigoAluno, String whatsappAluno) throws IOException {
		String csvFilePath = "C:\\TEMP\\alunos.csv"; // Caminho completo para o arquivo alunos.csv

        File file = new File(csvFilePath);

        FileWriter writer = new FileWriter(file); 
        PrintWriter pw = new PrintWriter(writer);

        if (!file.exists()) {
            // Se o arquivo não existir, cria o cabeçalho
            pw.println("Nome,Telefone,RA");
        }

        // Aqui você deve substituir "tfNomeAluno", "tfWhatsappAluno" e "tfRAAluno" pelas variáveis corretas que armazenam os dados do aluno
        

        // Grava os dados do aluno no arquivo CSV
        pw.println(nomeAluno + "," + whatsappAluno + "," + codigoAluno);

        pw.flush();
        pw.close();

        System.out.println("Dados do aluno foram gravados no arquivo CSV.");
		
		
		
		
		
	}

}
