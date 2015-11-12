package DAO.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.BDConnection;
import util.Utilidades;
import classes.Filme;
import classes.Usuario;
import DAO.UsuarioDAO;

public class UsuarioDAOPostgres implements UsuarioDAO {

	@Override
	public boolean cadastrarUsuario(Usuario usuario) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
			String sql = "INSERT INTO usuario(nome,email,senha) VALUES(?,?,md5(?)::text)";		
			try {
				conexao = BDConnection.getConnection();
				comandoSQL = conexao.prepareStatement(sql);
				comandoSQL.setString(1, usuario.getNome());
				comandoSQL.setString(2, usuario.getEmail());
				comandoSQL.setString(3, usuario.getSenha());
				comandoSQL.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}

	@Override
	public Usuario getUsuario(String email) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null, senha=null;
		//long visualizacoes = 0;
		Usuario x = new Usuario();
		String sql = "select nome,senha FROM usuario WHERE email=?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, email);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("nome");
				senha = resultado.getString("senha");
				x.setNome(nome);
				x.setSenha(senha);
				x.setEmail(email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return x;
		
	}

	@Override
	public boolean validaUsuario(String email, String senha) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null;
		//long visualizacoes = 0;
		Usuario x = new Usuario();
		String sql = "select * FROM usuario WHERE email=? and senha=md5(?)::text;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, email);
			comandoSQL.setString(2, senha);
			resultado = comandoSQL.executeQuery();
			return resultado.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
