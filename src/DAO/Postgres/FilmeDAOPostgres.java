package DAO.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Filme;
import util.BDConnection;
import DAO.FilmeDAO;

public class FilmeDAOPostgres implements FilmeDAO {

	@Override
	public boolean cadastrarFilme(Filme filme) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "INSERT INTO filmes(nome,descricao,capa,trailer,excluido) VALUES(?,?,?,?,'false')";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, filme.getNome());
			comandoSQL.setString(2, filme.getDescricao());
			comandoSQL.setString(3, filme.getImagem());
			comandoSQL.setString(4, filme.getTrailer());
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Filme filme) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Filme filme) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "Update Filmes set desativado = '1' where nome = ?,"
				+ " descricao = ?, capa = ?, trailer = ?";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, filme.getNome());
			comandoSQL.setString(2, filme.getDescricao());
			comandoSQL.setString(3, filme.getImagem());
			comandoSQL.setString(4, filme.getTrailer());
			comandoSQL.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Filme> listar() {
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null, descricao = null,imagem = null,trailer = null;
		//long visualizacoes = 0;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "SELECT * FROM FILMES;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("nome");
				descricao = resultado.getString("descricao");
				imagem = resultado.getString("capa");
				trailer = resultado.getString("trailer");
				//visualizacoes = resultado.getLong("visualizacoes");
				
				filmes.add(new Filme().novoFilme(nome, descricao, imagem, trailer));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return filmes;
		
	}
	
	public boolean verificaExistenciaFilme(String nomeFilme){
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		
		String sql = "SELECT * FROM FILMES WHERE NOME=?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, nomeFilme);
			resultado = comandoSQL.executeQuery();
			return resultado.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}



}
