package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Singleton;



@WebServlet("/adicionarNome")
public class ListaNome extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Singleton s;
	ArrayList<String> listaNomes;
	
	protected void service(HttpServletRequest requisicao,HttpServletResponse resposta) throws ServletException,IOException{
		
		//PrintWriter out = resposta.getWriter();
		
		//Printando
//		out.println("<html>");
//		out.println("<title>");
//		out.println("Servlet funfando!");
//		out.println("</title>");
//		out.println("<body>");
//		out.println("Teste");
//		out.println("</body>");
//		out.println("</html>");
		
		String nome = requisicao.getParameter("nome");
		Singleton mSingleton = s.getInstancia();
		//mSingleton.listaDeNome = new ArrayList<Usuario>();
		
		//mSingleton.listaDeNome.add(nome);
		
		//String nome = requisicao.getParameter("nome");
		//listaNomes = new ArrayList<String>(); 
		//listaNomes.add(nome);
				
	
		
		
		
		
	}

}
