package classes;

import DAO.Postgres.CategoriaDAOPostgres;

public class Categorias extends CategoriaDAOPostgres {
	
	private String nome;
	private String capa;

	public String getNome(){
		return nome;
	}
	
	public String getCapa(){
		return capa;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setCapa(String capa){
		this.capa = capa;
	}
}
