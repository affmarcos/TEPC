package classes;

import java.util.ArrayList;

import DAO.Postgres.FilmeDAOPostgres;

public class Filme extends FilmeDAOPostgres {
	
	private String nome;
	private String descricao;
	private ArrayList<String> categoria;
	private String imagem;
	private String trailer;
	private long visualizacoes;
		
	public long getVisualizacoes() {
		return visualizacoes;
	}
	public void setVisualizacoes(long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public Filme novoFilme(String nome,String descricao,String trailer){
		this.nome = nome;
		this.descricao = descricao;
		this.trailer = trailer;
		//this.visualizacoes = visualizacoes;
		
		return this;
	}
	public ArrayList<String> getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria.add(categoria);
	}
	
	

}
