package DAO;

import classes.Usuario;

public interface UsuarioDAO {
	
	boolean cadastrarUsuario(Usuario usuario);
	Usuario getUsuario(String email);
	boolean validaUsuario(String email,String senha);
	

}
