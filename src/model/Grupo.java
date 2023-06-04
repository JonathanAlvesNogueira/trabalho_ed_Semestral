package model;

import java.util.Objects;

public class Grupo {
	
	public String idGrupo;
	public String areaTrabalho;
	public String temaTrabalho;
	public String orientador;
    public String metodologia;
    
    
	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", areaTrabalho=" + areaTrabalho + ", temaTrabalho=" + temaTrabalho
				+ ", orientador=" + orientador + ", metodologia=" + metodologia + "]";
	}


	@Override
	public int hashCode() {
		int posicao =  temaTrabalho.toLowerCase().charAt(0);
		posicao = posicao - 97;
		return posicao;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(areaTrabalho, other.areaTrabalho) && Objects.equals(temaTrabalho, other.temaTrabalho);
	}
	
	
    
    
	
    
	

}