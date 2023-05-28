package model;

public class Professor{

	String nome;
	String area;
	String formatacao = "%s;%s\r\n";
	
	public Professor() {
		super();
	}
	
	public Professor(String nome, String area) {
		this.nome = nome;
		this.area = area;
	}
	
	@Override
	public String toString() {
		return String.format(formatacao, nome, area);
	}
	
	
	
	
}
