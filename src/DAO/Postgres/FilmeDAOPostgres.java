package DAO.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Filme;
import util.BDConnection;
import util.Utilidades;
import DAO.FilmeDAO;

public class FilmeDAOPostgres implements FilmeDAO {
	

	@Override
	public boolean cadastrarFilme(Filme filme) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		if(!verificaExistenciaFilme(filme.getNome())){
		
			String sql = "INSERT INTO filmes(nome,descricao,trailer,excluido,url_filme) VALUES(?,?,?,'false',?)";		
			try {
				conexao = BDConnection.getConnection();
				comandoSQL = conexao.prepareStatement(sql);
				comandoSQL.setString(1, filme.getNome());
				comandoSQL.setString(2, filme.getDescricao());
				comandoSQL.setString(3, filme.getTrailer());
				comandoSQL.setString(4, Utilidades.formatoURL(filme.getNome()));
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
	public ArrayList<Filme> getFilmes() {
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null, descricao = null,imagem = null,trailer = null;
		int id = 0;
		//long visualizacoes = 0;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "select * FROM filmes ,imagens WHERE filmes.id=imagens.id;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				id = resultado.getInt("id");
				nome = resultado.getString("nome");
				descricao = resultado.getString("descricao");
				trailer = resultado.getString("trailer");
				imagem =resultado.getString("name")+"."+resultado.getString("tipo");
				Filme x = new Filme();
				x.setId(id);
				x.setNome(nome);
				x.setImagem(imagem);
				x.setDescricao(descricao);
				x.setTrailer(trailer);
				filmes.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return filmes;
		
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
	
	public ArrayList<Filme> getFilme(String nomeFilme) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String descricao = null,nome=null ,imagem = null,trailer = null;
		int id;
		ArrayList<Filme> filmes =  new ArrayList<Filme>();;	
		String sql = "select * FROM filmes,imagens WHERE imagens.id=filmes.id and upper(translate(filmes.nome, 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü','ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu')) LIKE upper((translate(? , 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü','ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu')));;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1,"%"+nomeFilme+"%" );
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				id = resultado.getInt("filmes.id");
				nome = resultado.getString("nome");
				descricao = resultado.getString("descricao");
				trailer = resultado.getString("trailer");
				imagem =resultado.getString("name")+"."+resultado.getString("tipo");
				Filme x = new Filme();
				x.setId(id);
				x.setNome(nome);
				x.setImagem(imagem);
				x.setDescricao(descricao);
				x.setTrailer(trailer);
				filmes.add(x);
			}
		} catch (SQLException e) {
			return null;
		}
		return filmes;
	}
	
	public boolean updateUrl(String url,int id) {
		Connection conexao;
		PreparedStatement comandoSQL;
		
		String sql = "Update filmes set url_filme = ? where id= ?";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1, url);
			comandoSQL.setInt(2, id);
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

}
