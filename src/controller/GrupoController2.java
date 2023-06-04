package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.lista.listaObj.Lista;
import model.Grupo;

public class GrupoController2<E> implements ActionListener {

	private JTextField tfidGrupo;
	private JComboBox<E> cbAreaTrabalho;
	private JTextField tftemaTrabalho;
	private JComboBox<E> cbOrientador;
	private JTextField tfmetodologia;
	private JTextArea taintegrantesGrupo;
	private JTextArea taAlunosSistema;
	private JTextField tfConsultaID;
	private JTextArea taInformacoesGrupo;
	
	

	public GrupoController2(JTextField tfidGrupo, JComboBox<E> cbAreaTrabalho, JTextField tftemaTrabalho,
			JComboBox<E> cbOrientador, JTextField tfmetodologia, JTextArea taintegrantesGrupo,
			JTextArea taAlunosSistema, JTextField tfConsultaID, JTextArea taInformacoesGrupo) {
		this.tfidGrupo = tfidGrupo;
		this.cbAreaTrabalho = cbAreaTrabalho;
		this.tftemaTrabalho = tftemaTrabalho;
		this.cbOrientador = cbOrientador;
		this.tfmetodologia = tfmetodologia;
		this.taintegrantesGrupo = taintegrantesGrupo;
		this.taAlunosSistema = taAlunosSistema;
		this.tfConsultaID = tfConsultaID;
		this.taInformacoesGrupo = taInformacoesGrupo;
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Gravar Grupo")) {
			try {
				GravarGrupo();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Consultar Alunos")) {
			try {
				ConsultarAlunos();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Consultar Grupo")) {
			try {
				consultarGrupo();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void consultarGrupo() throws IOException {

		
		String idGrupo = tfidGrupo.getText();

		String path = "C:\\TEMP\\Grupos.csv"; // Caminho para o arquivo CSV
		File file = new File(path);

		if (file.exists()) {
		    BufferedReader reader = new BufferedReader(new FileReader(file));
		    String linha = reader.readLine();

		    while (linha != null) {
		        String[] grupoInfo = linha.split(";");
		        String grupoId = grupoInfo[0]; // ID do grupo atual

		        if (grupoId.equals(idGrupo)) {
		            // Grupo encontrado, extrai as informações
		            String areaTrabalho = grupoInfo[1];
		            String temaTrabalho = grupoInfo[2];
		            String orientador = grupoInfo[3];
		            String metodologia = grupoInfo[4];
		            String integrantes = grupoInfo[5];

		            taInformacoesGrupo.setText("ID do Grupo: " + grupoId + "\n");
		            taInformacoesGrupo.append("Área de Trabalho: " + areaTrabalho + "\n");
		            taInformacoesGrupo.append("Tema de Trabalho: " + temaTrabalho + "\n");
		            taInformacoesGrupo.append("Orientador: " + orientador + "\n");
		            taInformacoesGrupo.append("Metodologia: " + metodologia + "\n");
		            taInformacoesGrupo.append("Integrantes: " + integrantes + "\n");

		            break;
		        }

		        linha = reader.readLine();
		    }

		    reader.close();
		} else {
		    throw new IOException("Arquivo Não Existe");
		}

		
		
		
		
		
		

	}

	private void ConsultarAlunos() throws IOException {
		String path = "C:\\TEMP";
		String nome = "Alunos.csv";

		File dir = new File(path);
		File arq = new File(path, nome);

		if (dir.exists() && dir.isDirectory()) {

			if (arq.exists() && arq.isFile()) {

				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					String[] alunos = linha.split(";");
					taAlunosSistema.append("Nome: " + alunos[0] + " - RA: " + alunos[1] + "\n");
					linha = buffer.readLine();

				}
				buffer.close();
				leitor.close();
				fluxo.close();

			} else {
				throw new IOException("Arquivo Não Existe");
			}

		} else {
			throw new IOException("Diretório Inválido");
		}

	}

	private void GravarGrupo() throws IOException {
		Grupo grupo = new Grupo();

		grupo.idGrupo = tfidGrupo.getText();
		String areaTrabalho = (String) cbAreaTrabalho.getSelectedItem();
		grupo.areaTrabalho = areaTrabalho;
		grupo.temaTrabalho = tftemaTrabalho.getText();
		String orientadorEsc = (String) cbOrientador.getSelectedItem();
		grupo.orientador = orientadorEsc;
		grupo.metodologia = tfmetodologia.getText();
		String integrantes = taintegrantesGrupo.getText();

		String path = "C:\\TEMP";
		String nome = "Grupos.csv";

		Lista lista = new Lista();
		String[] alunosIntegrantes = integrantes.split("\n");
		String alunosIntegrantesString = Arrays.toString(alunosIntegrantes);

		for (String name : alunosIntegrantes) {
			lista.addFirst(name);
		}

		String linha = grupo.idGrupo + ";" + grupo.areaTrabalho + ";" + grupo.temaTrabalho + ";" + grupo.orientador
				+ ";" + grupo.metodologia + ";" + alunosIntegrantesString;

		File dir = new File(path);
		File arq = new File(path, nome);

		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String informacoes = CriaGrupoCsv(linha);
			FileWriter escreveArquivo = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(escreveArquivo);
			print.write(informacoes);
			print.flush();
			print.close();

		} else {
			throw new IOException("Diretório Inválido");
		}

	}

	private String CriaGrupoCsv(String linha) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(linha);
		buffer.append("\n");
		return buffer.toString();

	}


	
	
}