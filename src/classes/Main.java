package classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Postgres.ImagemPostgres;

public class Main {
 	public static void main(String[] args){
 		
 		Categorias x = new Categorias();
 		x.setNome("Corrida");
 		String isso = x.getFilmcategoria().get(1).getNome();
 		System.out.println(isso);
 		//ArrayList<Filme> j = x.getFilmcategoria("Corrida");
 		//System.out.println(j);
 	}
 	
 
}
