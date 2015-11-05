package classes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Postgres.ImagemPostgres;

public class Main {
 	public static void main(String[] args){
 		
 		Filme x = new Filme();
 		//String isso = x.listar().get(1).getImagem();
 		ArrayList<Filme> j = x.getFilmes();
 		for (int i=0;i<j.size();i++){
 			System.out.println(j.get(i).getImagem() +j.get(i).getNome());
 		}
 		
 	}
 	
 
}
