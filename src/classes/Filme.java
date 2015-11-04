package classes;

import java.util.ArrayList;

import DAO.Postgres.FilmeDAOPostgres;

public class Filme extends FilmeDAOPostgres {
	
	private String nome;
	private String descricao;
	private String imagem;
	private ArrayList<String> categoria;
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public Filme novoFilme(String nome,String descricao, String imagem,String trailer){
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.trailer = trailer;
		//this.visualizacoes = visualizacoes;
		
		return this;
	}
	public ArrayList<String> getCategoria() {
		return categoria;
	}
	public void setCategoria(ArrayList<String> categoria) {
		this.categoria = categoria;
	}
	
	

}
