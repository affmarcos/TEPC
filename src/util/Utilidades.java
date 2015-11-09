package util;

import java.text.Normalizer;

public class Utilidades {
	
	public static String formatoURL (String linha) {  
	    String atual = linha.replace ("[^A-Za-z]", "").replaceAll("\\p{Punct}", "").replaceAll("\\s+","-").toLowerCase();
	    return Normalizer.normalize(atual, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}  

}
