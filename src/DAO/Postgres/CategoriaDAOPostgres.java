package DAO.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.BDConnection;
import classes.Filme;
import DAO.CategoriaDAO;

public class CategoriaDAOPostgres implements CategoriaDAO {

	String nome,capa;
	
	@Override
	public ArrayList<Filme> getFilmcategoria() {
		Connection conexao;
		PreparedStatement comandoSQL;
		ResultSet resultado;
		String descricao = null ,imagem = null,trailer = null;
		//long visualizacoes = 0;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		String sql = "select * FROM filmes,categoria,imagens,categoria_filme WHERE categoria_filme.id_categoria=categoria.id and categoria_filme.id_filme=filmes.id and imagens.id=filmes.id and categoria.nome=?;";		
		try {
			conexao = BDConnection.getConnection();
			comandoSQL = conexao.prepareStatement(sql);
			comandoSQL.setString(1,getNome() );
			resultado = comandoSQL.executeQuery();
			while (resultado.next()) {
				nome = resultado.getString("nome");
				imagem =resultado.getString("name")+"."+resultado.getString("tipo");
				Filme x = new Filme();
				x.setNome(nome);
				x.setImagem(imagem);
				filmes.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return filmes;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getCapa() {
		return capa;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
		
	}

	@Override
	public void setCapa(String capa) {
		this.capa = capa;
		
	}
	



}
