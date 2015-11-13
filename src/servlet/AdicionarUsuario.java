package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Usuario;

public class AdicionarUsuario extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	    /**
	     * Upon receiving file upload submission, parses the request to read
	     * upload data and saves the file on disk.
	     */
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	    	  	
         
	 
	        try {
	            // parses the request's content to extract file data
	        		String nome = request.getParameter("name");
	        		String email = request.getParameter("email");
	        		String password = request.getParameter("password");
		            Usuario x = new Usuario();
		            x.setNome(nome);
		            x.setEmail(email);
		            x.setSenha(password);
		            //adiciona novo filme
		            x.cadastrarUsuario(x);
		            
	              
	        } catch (Exception ex) {
	            response.sendRedirect("/TEPC/erro.html");
	        }

	    }
}
