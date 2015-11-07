package DAO;

import java.util.ArrayList;

import classes.Filme;

public interface FilmeDAO {
	
	boolean cadastrarFilme(Filme filme);
	boolean update(Filme filme, int id);
	boolean delete(int id);
	boolean adicionarCapa(Filme filme, String tipo, long imagem);
	ArrayList<Filme> getFilmes();
	ArrayList<Filme> getFilme(String nomeFilme);

}
