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

	/*	protected String montaStringCategorias(){
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
	
*/
 
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getPathInfo();
    path = path.substring(path.lastIndexOf("/")+1,path.length());
    //System.out.println(path+" "+categoria.getCategorias());
   // out.println(request.getPathInfo());
    //out.println(request.getParameterMap());
    try {
    	Categorias cat = new Categorias();
    	Filme fil = new Filme();
       	String filmeOuCategoria =  buscaUrl(path, path);
       	if(filmeOuCategoria.equals("categoria")){
	        request.setAttribute("nomeCategoriaAtual", (Object) cat.buscaNomeCategoria(path));
	        RequestDispatcher rd = request.getRequestDispatcher("/filmePorcategoria.jsp" );
	        rd.forward(request, response); 
       	}else{
       		request.setAttribute("nomeFilmeAtual", (Object) fil.buscaNomeFilme(path));
	        RequestDispatcher rd = request.getRequestDispatcher("/filme.jsp" );
	        rd.forward(request, response); 
       	}
    } catch (NullPointerException e) {

    }  catch (ServletException e) {
        response.setStatus(400);
        response.resetBuffer();
        e.printStackTrace();
      }
  }
  
  
  protected String buscaUrl( String path, String nome) throws ServletException{
	  
	  Categorias cat = new Categorias();
	  Filme fil = new Filme();
	  if(cat.buscaNomeCategoria(path).length()>0) return "categoria"; //categoria
	  if(fil.buscaNomeFilme(path).length()>0) return "filme"; //categoria

	  throw new ServletException("Invalid URI");
  }

}

 


