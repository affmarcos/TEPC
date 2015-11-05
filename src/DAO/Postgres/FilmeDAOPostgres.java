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
		
		if(!verificaExistenciaFilme(filme.getNome())){
		
			String sql = "INSERT INTO filmes(nome,descricao,trailer,excluido) VALUES(?,?,?,'false')";		
			try {
				conexao = BDConnection.getConnection();
				comandoSQL = conexao.prepareStatement(sql);
				comandoSQL.setString(1, filme.getNome());
				comandoSQL.setString(2, filme.getDescricao());
				comandoSQL.setString(3, filme.getTrailer());
				comandoSQL.executeUpdate();
				
			} catch (SQLException e) {
				return false;
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(Filme filme,int id) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "Update Filmes set nome = ?,"
				+ " descricao = ?, trailer = ? where id= ?";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, filme.getNome());
			comandoSQL.setString(2, filme.getDescricao());
			comandoSQL.setString(3, filme.getTrailer());
			comandoSQL.setInt(4, id);
			comandoSQL.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "Update Filmes set desativado = '1' where id = ?";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setInt(1, id);
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
				trailer = resultado.getString("trailer");
				
				filmes.add(new Filme().novoFilme(nome, descricao, trailer));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return filmes;
		
	}
	
	
	public ArrayList<String> listarCategorias(){
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null, descricao = null,imagem = null,trailer = null;
		//long visualizacoes = 0;
		ArrayList<String> categorias = new ArrayList<String>();
		
		String sql = "SELECT NOME FROM categoria;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("nome");
				
				categorias.add(nome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categorias;
		
		
	}
	
	public int buscaId(String filmeNome) {
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;		
		int id=0;
		String sql = "SELECT ID FROM FILMES where nome = ?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, filmeNome);
			resultado = comandoSQL.executeQuery();
			resultado.next();
			id = resultado.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
		return id;
		
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

	@Override
	public boolean adicionarCapa(Filme filme, String extensao, long imagem) {
		Connection conn;
		PreparedStatement ps;
		
		if(verificaExistenciaFilme(filme.getNome())){
		
			int idFilme = buscaId(filme.getNome());
			String sql = "INSERT INTO imagens(id,tipo,imagem) VALUES (?,?, ?)";		
			try {
				conn = BDConnection.getConnection();
                conn.setAutoCommit(false);
                // salva o arquivo
                              
                //adiciona ao banco
                ps = conn.prepareStatement("INSERT INTO imagens(id,tipo,imagem) VALUES (?,?, ?)");
                ps.setInt(1, idFilme);
                ps.setString(2, extensao);
                ps.setLong(3, imagem);
                ps.executeUpdate();
                conn.commit();
				
			} catch (SQLException e) {
				return false;
			}
			return true;
		}else{
			return false;
		}
	}
	



}
