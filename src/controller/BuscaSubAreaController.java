package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.lista.listaObj.Lista;

public class BuscaSubAreaController implements ActionListener {

	private JTextField tfSubArea;
	private JTextArea taSubArea;
	Lista[] tabelaHashSubArea;

	
	
	
	public BuscaSubAreaController(JTextField tfSubArea, JTextArea taSubArea) {
		this.tfSubArea = tfSubArea;
		this.taSubArea = taSubArea;
		tabelaHashSubArea = new Lista[26];
		inicializarTabela();
	}

	private void inicializarTabela() {
		int tamanho = tabelaHashSubArea.length;
		for(int i = 0; i < tamanho; i++) {
			tabelaHashSubArea[i] = new Lista();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Buscar Grupos")) {
			taSubArea.setText("");
			try {
				if (!tfSubArea.getText().isEmpty()) {
					achaPorSubArea();
				} else {
					JOptionPane.showMessageDialog(null, "Insira a Subarea do grupo", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void adicionarTabelaHash(String palavra) {
		int posicao = palavra.hashCode();
		tabelaHashSubArea[posicao].addFirst(palavra);
	}
	
	
	public void achaPorSubArea() throws Exception {
		taSubArea.setText("");
		int palavra = tfSubArea.getText().toLowerCase().charAt(0);
		palavra = palavra - 97;
		int tamanho = tabelaHashSubArea.length;
		
		for(int i = 0; i < tamanho ; i++) {
			int primeiraPos = (int) tabelaHashSubArea[i].get(0);
			int tamanhoLista = tabelaHashSubArea[i].size();
			if(palavra == primeiraPos) {
				for(int j = 0; j< tamanhoLista; j++) {
					taSubArea.append( (String ) tabelaHashSubArea[i].get(i));
				}
				
				
			}
			
					}
		
	}
	
	
	
	
	
}
