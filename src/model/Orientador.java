package model;

import br.edu.fateczl.lista.listaObj.*;

public class Orientador extends Professor{

	String descricao;
	
	public Orientador(String descricao) {
		super();
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Orientador [descricao=" + descricao + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
