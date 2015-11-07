package DAO;

import java.util.ArrayList;

import classes.Categorias;
import classes.Filme;

public interface CategoriaDAO {
	public ArrayList<Filme> getFilmcategoria(String nomeCategoria);
	ArrayList<Categorias> getCategorias();
}
