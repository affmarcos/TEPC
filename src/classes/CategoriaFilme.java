package classes;

import java.util.ArrayList;

public class CategoriaFilme {
	
	String nomeCategoria;
	ArrayList<Filme> filme;
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public ArrayList<Filme> getFilme() {
		return filme;
	}
	public void setFilme(ArrayList<Filme> filme) {
		this.filme = filme;
	}
	
	

}
