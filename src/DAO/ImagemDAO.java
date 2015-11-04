package DAO;

import classes.Imagem;

public interface ImagemDAO {
	
	boolean cadastrarImagem(Imagem image);
	boolean verificarExistenciaImagem(String nome);
	
}
