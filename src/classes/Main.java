package classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Postgres.ImagemPostgres;

public class Main {
 	public static void main(String[] args){
 		
 		Filme x = new Filme();
 		//String isso = x.listar().get(1).getImagem();
 		ArrayList<Categorias> j = x.getCategorias();
 		ImagemPostgres d = new ImagemPostgres();
 		for(int i=1438;i<10450;i++){
 			System.out.println(d.getImagem(i));
 			System.out.println(i);
 
 		}
 		
 	}
 	
 
}
