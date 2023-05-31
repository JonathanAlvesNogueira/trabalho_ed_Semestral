package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Aluno;

public class AlunoController implements ActionListener{

	private JTextField tfNomeAluno;
	private JTextField tfRAAluno;
	private JTextField tfWhatsappAluno;
	private JTextArea taAlunosCadastrados;

	public AlunoController(JTextField tfNomeAluno, JTextField tfRAAluno, JTextField tfWhatsappAluno
			,JTextArea taAlunosCadastrados) {
		super();
		this.tfNomeAluno = tfNomeAluno;
		this.tfRAAluno = tfRAAluno;
		this.tfWhatsappAluno = tfWhatsappAluno;
		this.taAlunosCadastrados = taAlunosCadastrados;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Gravar")) {
			try {
				Gravar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(cmd.equals("Excluir")) {
			try {
				Excluir();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}if(cmd.equals("Consultar")) {
			try {
				Consultar();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void Excluir() throws IOException {
		//Ainda em Análise

	}


	private void Consultar() throws IOException {
		String path = "C:\\TEMP";
		String nome = "Alunos.csv";

		File dir = new File(path);
		File arq = new File(path, nome);

		if (dir.exists() && dir.isDirectory()) {

			if(arq.exists() && arq.isFile()) {

				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while(linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();

				}
				buffer.close();
				leitor.close();
				fluxo.close();

			}else {
				throw new IOException("Arquivo Não Existe");
			}

		}else {
			throw new IOException("Diretório Inválido");
		}

	}

	private void Gravar() throws IOException {
		Aluno aluno = new Aluno();
		aluno.nome = tfNomeAluno.getText();
		aluno.codigo = tfRAAluno.getText();
		aluno.whatsapp = tfWhatsappAluno.getText();
        
		
		String path = "C:\\TEMP";
		String nome = "Alunos.csv";

	    taAlunosCadastrados.append(aluno.nome + " " + aluno.codigo + " " + aluno.whatsapp + "\n"); 
		String linha = aluno.nome + ";" + aluno.codigo + ";" + aluno.whatsapp;
		

		File dir = new File(path);
		File arq = new File(path, nome);

		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String informacoes = CriaCsv(linha);
			FileWriter escreveArquivo = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(escreveArquivo);
			print.write(informacoes);
			print.flush();
			print.close();
			
		}else {
			throw new IOException("Diretório Inválido");
		}

	}

	private String CriaCsv(String linha) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(linha);
		buffer.append("\n");
		return buffer.toString();
	}

}