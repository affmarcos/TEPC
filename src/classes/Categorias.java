package classes;

import java.util.ArrayList;

import DAO.Postgres.CategoriaDAOPostgres;

public class Categorias extends CategoriaDAOPostgres {
	private int id;
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
	
	public ArrayList<CategoriaFilme> getFilmePorCategoria(){
		ArrayList<CategoriaFilme> filmePorCategoria = new ArrayList<CategoriaFilme>();
		ArrayList<Categorias> categoria = getCategorias();
		for(int i=0;i<categoria.size();i++){
			CategoriaFilme x = new CategoriaFilme();
			x.setNomeCategoria(categoria.get(i).getNome());
			x.setFilme(getFilmcategoria(categoria.get(i).getNome()));
			filmePorCategoria.add(x);
		}		
		
		return filmePorCategoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
