package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Filme;

/**
 * Servlet implementation class Filme
 */
//@WebServlet("/Filme")
public class FilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 /*   public FilmeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	Filme fil = new Filme();
        String path = request.getPathInfo();
        path = path.substring(path.lastIndexOf("/")+1,path.length());
  	   	String filme = fil.buscaNomeFilme(path);
	  		if(!(filme==null)){
		   		//System.out.println("FILME" +path);
		   	 	request.setAttribute("nomeFilmeAtual", (Object) fil.buscaNomeFilme(path));
		   	 	//ArrayList<Filme> isso = fil.getRecomendados();
		   	 	//request.setAttribute("recomendados", (Object) isso);
		        RequestDispatcher rd = request.getRequestDispatcher("/filme.jsp" );
		        rd.forward(request, response); 
	  		}else{
	  			response.sendRedirect("/TEPC/erro.jsp");
	  		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
