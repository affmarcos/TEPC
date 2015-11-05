package DAO.Postgres;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import util.BDConnection;

public class ImagemPostgres {
	
	 public boolean getImagem(int idFilme)  {   
		    String sql = "select imagem,nome,tipo from imagens where id = ?";  
		    InputStream logo = null;  		  
		    Connection conn = BDConnection.getConnection();
		    PreparedStatement p =null;
		    ResultSet result =null;
		    String nome=null,tipo=null;
		    try {
				conn.setAutoCommit(false);
				p = conn.prepareStatement(sql);
				p.setInt(1,idFilme);
				result = p.executeQuery();
			    while(result.next()) {  
			    	Blob blob = result.getBlob("imagem");
			    	tipo = result.getString("tipo");
			    	nome = result.getString("nome")+"."+tipo;
			    	byte[] bin = blob.getBytes(1, (int) blob.length());  
			    	logo = new ByteArrayInputStream(bin); 
			    }  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			} 
		    
		    File outputFile = new File("workspace/TEPC/WebContent/images/"+nome);  
		       System.out.println("Gravando o arquivo.....");  
		       BufferedImage input =null;
			try {
				try {
					input = ImageIO.read(logo);
				} catch (IOException e) {
					return false;
				}
			    try {
					ImageIO.write(input, tipo, outputFile);
				} catch (IOException e) {
					return false;
				}
			    return true;
			       
			} catch (IllegalArgumentException  e) {
				//e.printStackTrace();
				return false;
			}  
		}  

}
