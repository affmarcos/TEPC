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
 		
 		Filme x = new Filme();
 		x.setNome("Aventura");
 		x.setId(1);
		//System.out.println(x.quantidadePaginasFilmeCategoria());
 		ArrayList<Filme> isso = x.getRecomendados();
 		for(int i=0;i<isso.size();i++){
 			System.out.println(isso.get(i).getNome()+" "+isso.get(i).getImagem());
 			//System.out.println(x.updateUrl(Utilidades.formatoURL(isso.get(i).getNome()),isso.get(i).getId()));
 		}
 		
 		/*Usuario x = new Usuario();
 		x.setEmail("cabral.mpa@gmail.com");
 		x.setNome("Marcos Azeredo");
 		x.setSenha("123456");
 		//x.cadastrarUsuario(x);
 		System.out.println(x.getUsuario(x.getEmail()).getNome());
 		//ArrayList<Filme> j = x.getFilmcategoria("Corrida");
 		//System.out.println(j);
 */
  		
 		//System.out.println(limpa(teste));
 		
 	}
 	
	public static String limpa (String linha) {  
		    String atual = linha.replace ("[^A-Za-z]", "").replaceAll("\\p{Punct}", "").replaceAll("\\s+","-").toLowerCase();
		    return Normalizer.normalize(atual, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}  

 
}
