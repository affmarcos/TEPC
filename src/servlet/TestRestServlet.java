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

private class RestRequest {
    // Accommodate two requests, one for all resources, another for a specific resource
	//private String filme = montaStringFilmes(),categoria = montaStringCategorias();

	//private Pattern regExCategorias = Pattern.compile("/"+categoria+"$");
    //private Pattern regExFilme = Pattern.compile("/"+filme+"$");
 
    public RestRequest(String pathInfo) throws ServletException {
      // regex parse pathInfo
      //Matcher matcher;
 
      // Check for ID case first, since the All pattern would also match
      //matcher = regExCategorias.matcher(pathInfo);
      Categorias cat = new Categorias();
      String nome=cat.buscaNomeCategoria(pathInfo);
      System.out.println(cat.buscaNomeCategoria(pathInfo));
      System.out.println(nome);
      if (nome.equals(null)) {
    	  throw new ServletException("Invalid URI");
      }
 
    /*  matcher = regExAllPattern.matcher(pathInfo);
      if (matcher.find()) return;
      */
 
 
    }
 
  }

	protected String montaStringCategorias(){
		ArrayList<Categorias> categorias = new Categorias().getCategorias();
		String categoria="";
		int atual=1;
		if(categorias.size()>0){
			categoria = categorias.get(0).getUrl();
			while(atual<categorias.size()){
				categoria= categoria+"||"+categorias.get(atual).getUrl();
				atual++;
			}
		}
		return categoria;
	}
	
	protected String montaStringFilmes(){
		ArrayList<Filme> filmes = new Filme().getFilmes();
		String filme="";
		int atual=1;
		if(filmes.size()>0){
			filme = filmes.get(0).getUrl();
			while(atual<filmes.size()){
				filme= filme+"||"+filmes.get(atual).getUrl();
				atual++;
			}
		}
		return filme;
	}
	
	
 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    Categorias categoria = new Categorias();
    out.println("GET request handling");
    String path = request.getPathInfo();
    path = path.substring(path.lastIndexOf("/")+1,path.length());
    //System.out.println(path+" "+categoria.getCategorias());
   // out.println(request.getPathInfo());
    //out.println(request.getParameterMap());
    try {
    	System.out.println("Path "+path+" path info "+request.getPathInfo()+" nome categoria "+categoria.buscaNomeCategoria(path));
        RestRequest resourceValues = new RestRequest(path);
        request.setAttribute("nomeCategoriaAtual", (Object) categoria.buscaNomeCategoria(path));
        RequestDispatcher rd = request.getRequestDispatcher("/filmePorcategoria.jsp" );
        rd.forward(request, response); 
     // out.println("ID");
    } catch (ServletException e) {
      response.setStatus(400);
      response.resetBuffer();
      e.printStackTrace();
      out.println(e.toString());
    }
    out.close();
  }
 
}