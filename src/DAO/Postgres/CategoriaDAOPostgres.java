package DAO.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.BDConnection;
import classes.Categorias;
import classes.Filme;
import DAO.CategoriaDAO;

public class CategoriaDAOPostgres implements CategoriaDAO {

	//String nome,capa;
	
	@Override
	public ArrayList<Filme> getFilmcategoria(String nomeCategoria) {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String descricao = null,nome=null ,imagem = null,trailer = null;
		//long visualizacoes = 0;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "select * FROM filmes,categoria,imagens,categoria_filme WHERE categoria_filme.id_categoria=categoria.id and categoria_filme.id_filme=filmes.id and imagens.id=filmes.id and categoria.nome=?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1,nomeCategoria );
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("nome");
				descricao = resultado.getString("descricao");
				trailer = resultado.getString("trailer");
				imagem =resultado.getString("name")+"."+resultado.getString("tipo");
				Filme x = new Filme();
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
	
public ArrayList<Categorias> getCategorias(){
		
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String nome = null,capa=null;
		int id =0;
		//long visualizacoes = 0;
		ArrayList<Categorias> categorias = new ArrayList<Categorias>();
		
		String sql = "SELECT * FROM categoria;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				Categorias cat = new Categorias();
				id = resultado.getInt("id");
				nome = resultado.getString("nome");
				capa = resultado.getString("capaimagem");
				cat.setNome(nome);
				cat.setCapa(capa);
				cat.setId(id);
				
				
				categorias.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return categorias;
			
	}

public boolean updateUrl(String url,int id) {
	Connection conexao;
	PreparedStatement comandoSQL;
	
	String sql = "Update categoria set url_categoria = ? where id= ?";		
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
