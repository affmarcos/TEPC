package controle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import classes.Filme;
import DAO.Postgres.FilmeDAOPostgres;

@WebServlet("/AdicionarFilme")
public class AdicionarFilme extends HttpServlet{

private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
	public AdicionarFilme() {
	    super();
	    // TODO Auto-generated constructor stub
	}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			        PrintWriter out = response.getWriter();
			        out.println("<html>");
			        out.println("<body>");
			        out.println("<h1>Hello Servlet Get</h1>");
			        out.println("</body>");
			        out.println("</html>");
}

/** 
 * Processes requests for both HTTP <code>GET</code> 
 *   and <code>POST</code> methods.
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    response.setContentType("text/html;charset=UTF-8");  
    try {  
        MultipartRequest multipartRequest = new MultipartRequest(request, getServletContext().getRealPath("/APPS/adm/upload/tmp/"), /* 150MB */ 153600 * 153600, new DefaultFileRenamePolicy());  
        if (multipartRequest.getParameter("Enviar") != null) {  
            upload(request, response, multipartRequest);  
        } else {  
            throw new IOException();  
        }  
    } catch (IOException ex) {  
    }  

}  



private void upload(HttpServletRequest request, HttpServletResponse response, MultipartRequest multipartRequest) throws IOException, ServletException { //OK  

    PrintWriter out = response.getWriter();
	FilmeDAOPostgres cadastro = new FilmeDAOPostgres();
	
	String nome = request.getParameter("nome");
	String descricao = request.getParameter("descricao");
	File tmpFile = multipartRequest.getFile("foto"); //esse daqui é o name do input file 
	BufferedImage input = ImageIO.read(tmpFile);
	File outputFile = new File("WebContent/teste/teste.jpg");
	ImageIO.write(input, "JPG", outputFile);
	//String imagem;
	String[] categoria = request.getParameterValues("categoria");
	String trailer = request.getParameter("trailer");
	
	Filme filme = new Filme();
	
	if ("".equals(nome.trim()) || "".equals(descricao.trim()) || "".equals(trailer.trim())) {
		out.println("<font color=red>Nome, Descrição ou Trailer vazios!</font>");
		RequestDispatcher rs = request.getRequestDispatcher("formulario.jsp");
		rs.include(request, response);
	}else if (cadastro.verificaExistenciaFilme(nome)) {
		out.println("<font color=red>Telefone já cadastrado!</font>");
		RequestDispatcher rs = request.getRequestDispatcher("formulario.jsp");
		rs.include(request, response);
	}else {
		filme.setNome(nome);
		filme.setDescricao(descricao);
		filme.setTrailer(trailer);
		filme.setCategoria((ArrayList<String>)Arrays.asList(categoria));
		
		out.println(nome+" "+descricao+" "+" "+trailer);
		//cadastro.cadastrarFilme(filme);
		
		response.sendRedirect("index.jsp");
	}

}  

}
