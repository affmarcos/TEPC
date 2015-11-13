package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

import DAO.Postgres.ImagemPostgres;
import classes.Filme;
import util.BDConnection;
 
/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class AdicionarFilme extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
  //  private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

	private String categorias;
 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	  	
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
        
        String nome = null,descricao = null, categorias = null,trailer = null, nomeArquivo = null, extensao = null;
        File storeFile = null;
        long oid = 0;
    	
        
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = "/home/guest/workspace/TEPC/WebContent/teste";
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // parses the request's content to extract file data
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();

                if (!item.isFormField()) {
                	String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    nomeArquivo=fileName;
                    extensao = nomeArquivo.substring(nomeArquivo.lastIndexOf(".")+1, nomeArquivo.length());
                    storeFile = new File(filePath);
                    // salva o arquivo
                    item.write(storeFile);
                    Connection conn = BDConnection.getConnection();
                    conn.setAutoCommit(false);
                    oid = retornaImgLong(storeFile,BDConnection.getConnection());
                    /*Connection conn = BDConnection.getConnection();
                    conn.setAutoCommit(false);
                    oid = retornaImgLong(storeFile,conn);
                    
                    //adiciona ao banco
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO imagens(id,tipo,imagem) VALUES (1,?, ?)");
                    ps.setString(1, "TIPO");
                    ps.setLong(2, oid);
                    ps.executeUpdate();
                    conn.commit();
                    */
                    
                    request.setAttribute("message","Upload has been done successfully!");
                }else{
                	String resultado = item.getFieldName();
                	
                	if(resultado.equals("name")){
                		nome = item.getString();
                	}
                	else if(resultado.equals("categoria")){
                		categorias = item.getString();
                	}
                	else if(resultado.equals("trailer_link")){
                		trailer = item.getString();
                	}
                	else if(resultado.equals("descricao")){
            			descricao = item.getString();
                	} 
                	
                }
                
            }
            
	            Filme x = new Filme();
	            x.novoFilme(nome, descricao, trailer);
	            //adiciona novo filme
	            x.cadastrarFilme(x);
	            //adiciona a capa
	            if(x.adicionarCapa(x, extensao, oid)){
		            //cria a imagem na pasta de imagens
		            ImagemPostgres i = new ImagemPostgres();
		            i.getImagem(x.buscaId(nome)); 
	            }
	           //deleta o temporario
	            storeFile.delete();
              
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
            ex.printStackTrace();
        }
        // redirects client to message page
        
        PrintWriter out = response.getWriter();
       // boolean valida = extensao.matches("(BMP|jpeg|WBMP|GIF|bmp|jpg|JPG|wbmp|png|PNG|JPEG|gif|tiff)$");
        out.println(nome +" "+ descricao +" "+ categorias +" "+ trailer + " "+nomeArquivo+" "+ extensao );
        System.out.println(nome +" "+ descricao +" "+ categorias +" "+ trailer + " "+nomeArquivo+" "+ extensao);
       //getServletContext().getRequestDispatcher("/formulario.jsp").forward(
       //        request, response);
    }
    
    public long retornaImgLong(File file, Connection conn) throws SQLException, IOException{
        // Get the Large Object Manager to perform operations with
        LargeObjectManager lobj = ((org.postgresql.PGConnection)conn).getLargeObjectAPI();
    	
        long oid = lobj.createLO(LargeObjectManager.READ | LargeObjectManager.WRITE);

        // Open the large object for writing
        LargeObject obj = lobj.open(oid, LargeObjectManager.WRITE);

        // Now open the file
        FileInputStream fis = new FileInputStream(file);

        // Copy the data from the file to the large object
        byte buf[] = new byte[2048];
        int s;
        while ((s = fis.read(buf, 0, 2048)) > 0) {
            obj.write(buf, 0, s);
          //  tl += s;
        }

        // Close the large object
        obj.close();
        fis.close();
        
        return oid;
    }
    
}
