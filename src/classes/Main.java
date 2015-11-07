package classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Postgres.ImagemPostgres;

public class Main {
 	public static void main(String[] args){
 		
 		Filme x = new Filme();
 		//x.setNome("Corrida");
 		ArrayList<Filme> isso = x.getFilme("amor");
 		for(int i=0;i<isso.size();i++){
 			System.out.println(isso.get(i).getNome()+" "+isso.get(i).getImagem());
 		}
 		//ArrayList<Filme> j = x.getFilmcategoria("Corrida");
 		//System.out.println(j);
 	}
 	
 
}
