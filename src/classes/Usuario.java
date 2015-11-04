package classes;

import java.util.Calendar;
import java.util.Date;


public class Usuario {
	
	private String nome;
	private int idade;
	private Calendar data;
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Date getData() {
		return data.getTime();
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
