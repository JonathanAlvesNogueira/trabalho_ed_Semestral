package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import service.Pilha;

public class OrientadorController implements ActionListener {

	private JTextField tfIDGrupo;
	private JTextField tfEscrita;
	private JTextArea taHistorico;
	Pilha pilha = new Pilha();
	
	public OrientadorController(JTextField tfIDGrupo, JTextField tfEscrita, JTextArea taHistorico) {
		super();
		this.tfIDGrupo = tfIDGrupo;
		this.tfEscrita = tfEscrita;
		this.taHistorico = taHistorico;
	}
	
	
	@Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Lançar")) {
            try {
                lancar();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else if (cmd.equals("Consultar")) {
            try {
				consultar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }

    private void lancar() throws IOException {
        String idGrupo = tfIDGrupo.getText();
        String descricao = tfEscrita.getText();

        pilha.push(descricao);
	
        String path = "C:\\TEMP";
        String nome = "orientador.csv";

        File dir = new File(path);
        File arq = new File(path, nome);

        if (dir.exists() && dir.isDirectory()) {
            boolean existe = false;
            if (arq.exists()) {
                existe = true;
            }

            FileWriter escreveArquivo = new FileWriter(arq, existe);
            PrintWriter print = new PrintWriter(escreveArquivo);
            print.write(idGrupo + ";" + descricao);
            print.write("\n");
            print.flush();
            print.close();
        } else {
            throw new IOException("Diretório Inválido");
        }
    }

    private void consultar() throws Exception {
        taHistorico.setText(""); // Limpa o campo de histórico

        String path = "C:\\TEMP";
        String nome = "orientador.csv";

        File dir = new File(path);
        File arq = new File(path, nome);

        if (dir.exists() && dir.isFile()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(arq));
                String linha;
                while ((linha = bufferedReader.readLine()) != null) {
                    pilha.push(linha);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
        	System.out.println("Arquivo nao encontrado ");
        }

        StringBuilder historico = new StringBuilder();
        while (!pilha.isEmpty()) {
            String orientacao = pilha.pop();
            historico.append(orientacao).append("\n");
        }

        taHistorico.setText(historico.toString());
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	


