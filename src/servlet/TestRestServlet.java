package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Categorias;
import classes.Filme;
 
public class TestRestServlet extends HttpServlet {
 
  /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, NullPointerException, IOException {
    String path = request.getPathInfo();
    path = path.substring(path.lastIndexOf("/")+1,path.length());
    //System.out.println(path);
    	Categorias cat = new Categorias();
    	//Filme fil = new Filme();
       	String filmeOuCategoria =  cat.buscaNomeCategoria(path);
       	if(!(filmeOuCategoria==null)){
	       	//System.out.println("CATEGORIA"+ filmeOuCategoria);
		    request.setAttribute("nomeCategoriaAtual", (Object) cat.buscaNomeCategoria(path));
		    RequestDispatcher rd = request.getRequestDispatcher("/filmePorcategoria.jsp" );
		    rd.forward(request, response); 
       	} else{
       	Filme fil = new Filme();
  	   	String filme = fil.buscaNomeFilme(path);
	  		if(!(filme==null)){
		   		//System.out.println("FILME" +path);
		   	 	request.setAttribute("nomeFilmeAtual", (Object) fil.buscaNomeFilme(path));
		        RequestDispatcher rd = request.getRequestDispatcher("/filme.jsp" );
		        rd.forward(request, response); 
	  		}else{
	  			response.sendRedirect("/index-1.html");
	  		}
       	}

  }
  
}

 


