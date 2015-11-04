package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Singleton;
import servlet.ListaNome;

@WebServlet("/mostrarNomes")
public class MostraNome extends HttpServlet {
	
	Singleton s;
	
	protected void service(HttpServletRequest requisicao,HttpServletResponse resposta) throws ServletException,IOException{ 
		PrintWriter out = resposta.getWriter();
		
		Singleton mSingleton =  s.getInstancia();
		
		
	
	}

}
