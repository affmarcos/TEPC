package DAO;

import java.util.ArrayList;

import classes.Filme;

public interface CategoriaDAO {
	public ArrayList<Filme> getFilmcategoria();
	public String getNome();
	public String getCapa();
	public void setNome(String nome);
	public void setCapa(String capa);
}
