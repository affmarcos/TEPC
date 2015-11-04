package DAO;

import java.util.ArrayList;

import classes.Filme;

public interface FilmeDAO {
	
	boolean cadastrarFilme(Filme filme);
	boolean update(Filme filme);
	boolean delete(Filme filme);
	ArrayList<Filme> listar();
	

}
