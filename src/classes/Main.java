package classes;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

import util.Utilidades;
import DAO.Postgres.ImagemPostgres;

public class Main {
 	public static void main(String[] args){
 		
 		Categorias x = new Categorias();
 		x.setNome("Aventura");
 		x.setId(1);
		//System.out.println(x.quantidadePaginasFilmeCategoria());
 		ArrayList<Filme> isso = x.getFilmePorCategoriaPagina();
 		for(int i=0;i<isso.size();i++){
 			System.out.println(isso.get(i).getNome()+" "+isso.get(i).getUrl());
 			//System.out.println(x.updateUrl(Utilidades.formatoURL(isso.get(i).getNome()),isso.get(i).getId()));
 		}
 		
 		//ArrayList<Filme> j = x.getFilmcategoria("Corrida");
 		//System.out.println(j);
 
  		
 		//System.out.println(limpa(teste));
 		
 	}
 	
	public static String limpa (String linha) {  
		    String atual = linha.replace ("[^A-Za-z]", "").replaceAll("\\p{Punct}", "").replaceAll("\\s+","-").toLowerCase();
		    return Normalizer.normalize(atual, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}  

 
}
