package classes;

import java.util.ArrayList;

public class Singleton {
	
	static Singleton instancia;
	public static ArrayList<Usuario> listaDeNome = new ArrayList<Usuario>() ;
	
	public static synchronized Singleton getInstancia(){
		if(instancia == null){
			instancia = new Singleton();
		}
		return instancia;
	}
	
	public ArrayList<Usuario> getLista(){
		return listaDeNome;
	}
	
}
