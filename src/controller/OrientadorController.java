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

	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String cmd = e.getActionCommand();
//		if(cmd.equals("Lançar")) {
//			try {
//				lancar();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		}
//		if(cmd.equals("Consultar")) {
//			try {
//				consultar();
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		}
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	private void consultar() throws Exception {
//		
//		  String path = "C:\\TEMP";
//		  String nome = "orientador.csv";
//		  Pilha pilha = new Pilha();
//
//		  File dir = new File(path);
//		  File arq = new File(path, nome);
//
//		  if (dir.exists() && dir.isDirectory()) {
//
//		   if(arq.exists() && arq.isFile()) {
//
//		    FileInputStream fluxo = new FileInputStream(arq);
//		    InputStreamReader leitor = new InputStreamReader(fluxo);
//		    BufferedReader buffer = new BufferedReader(leitor);
//		    String linha = buffer.readLine();
//
//		    while(linha != null) {
//		    // System.out.println(linha);
//		    pilha.push(linha);
//		     linha = buffer.readLine();
//		     System.out.println(pilha.pop());
//
//		    }
//		    buffer.close();
//		    leitor.close();
//		    fluxo.close();
////		    while(!pilha.isEmpty()) {
////		    	System.out.println(pilha.pop());
////		    }
//		    
//
//		   }else {
//		    throw new IOException("Arquivo Não Existe");
//		   }
//
//		  }else {
//		   throw new IOException("Diretório Inválido");
//		  }
//
//		 }
//		
//		
//		
//	
//
//	private void lancar() throws IOException{
//		
//		Orientador ori = new Orientador();
//		ori.id = tfIDGrupo.getText();
//		ori.descricao = tfEscrita.getText();
//		
//		// mudar para textearea
//		//tfHistorico.append("O id do grupo é " + ori.id + "e essa foi a orientação: " + ori.descricao);
//		  
//		  String path = "C:\\TEMP";
//		  String nome = "orientador.csv";
//
//
//		  File dir = new File(path);
//		  File arq = new File(path, nome);
//
//		  if(dir.exists() && dir.isDirectory()) {
//		   boolean existe = false;
//		   if(arq.exists()) {
//		    existe = true;
//		   }
//		   
//		   String informacoes = ori.descricao;
//		   FileWriter escreveArquivo = new FileWriter(arq, existe);
//		   PrintWriter print = new PrintWriter(escreveArquivo);
//		   print.write("Id do grupo : " + ori.id + ";" + informacoes);
//		   print.write("\n");
//		   print.flush();
//		   print.close();
//		   
//		   
//		  }else {
//		   throw new IOException("Diretório Inválido");
//		  }
//
//		 }
//		
		
		
	}
	


	
	
	
	
	
	
	


