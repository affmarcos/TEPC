package classes;

import java.util.ArrayList;

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
	
	public ArrayList<Filme> getFilmeDaCategoria(){
		
		return getFilmcategoria(getNome());
		
	}
	
	public ArrayList<ArrayList<Filme>> getFilmePorCategoria(){
		ArrayList<ArrayList<Filme>> filmePorCategoria = new ArrayList<ArrayList<Filme>>();
		ArrayList<Categorias> categoria = getCategorias();
		for(int i=0;i<categoria.size();i++){
			filmePorCategoria.add(getFilmcategoria(categoria.get(i).getNome()));
		}		
		
		return filmePorCategoria;
	}
}
