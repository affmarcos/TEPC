<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MOSTRA dados</title>
</head>
<body>
	<br/>
	
	<%@ page import = "classes.Singleton"  %>
	<%@ page import = "servlet.ListaNome"  %>
	<%@ page import = "java.util.ArrayList"  %>
	
	
	<% request.getParameter("nome"); %>  <%--Pega nome --%>
	<% request.getParameter("idade"); %> <%--Pega idade --%>
	<% request.getParameter("data"); %>  <%--Pega data --%>
	<% request.getParameter("email"); %> <%--Pega email --%>
	
	<%
	
	ArrayList<String> listaNomes;
	
	String nome = request.getParameter("nome");
	String idade = request.getParameter("idade");
	String data = request.getParameter("data");
	String email = request.getParameter("email");
	
	String nome1 = request.getParameter("nome");
	Singleton mSingleton = Singleton.getInstancia();
	
	
	//mSingleton.listaDeNome.add(nome+" "+idade+" "+email+" "+data);
	%>
	<br/>
	<% 
	for(int i =0;i<mSingleton.listaDeNome.size();i++){
		out.println(mSingleton.listaDeNome.get(i));
		out.println("\n");
	}%>
	
	
	
	

</body>
</html>