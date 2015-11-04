<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>MOSTRA dados</title>
</head>
<body>
	<br/>
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<%@ page import = "classes.Singleton"  %>
	<%@ page import = "servlet.ListaNome"  %>
	<%@ page import = "java.util.*"  %>
	<%@ page import = "classes.Usuario"  %>
	

    <% request.getParameter("nome"); %>  
	<% request.getParameter("idade"); %>  
	<% request.getParameter("data"); %>  
	<% request.getParameter("email"); %> 

	<jsp:useBean id="singleton" class="classes.Singleton"/>	
	<%
	
	ArrayList<String> listaNomes;
	
	String nome = request.getParameter("nome");
	String idade = request.getParameter("idade");
	String data = request.getParameter("data");
	String email = request.getParameter("email");
	
	//String nome1 = request.getParameter("nome");
		
	/*int year = Integer.parseInt(data.substring(0, 3));
	int month = Integer.parseInt(data.substring(4, 5));
	int date = Integer.parseInt(data.substring(6, 7));*/
	
	Usuario user = new Usuario();
	user.setNome(nome);
	user.setIdade(Integer.parseInt(idade));
	//user.setData( new Date(year, month, date));
	user.setEmail(email);
	
	Singleton.listaDeNome.add(user);
	%>
	<br/>
	<%-- 
	
	<% 
	for(int i =0;i<mSingleton.listaDeNome.size();i++){
		out.println(mSingleton.listaDeNome.get(i));
		out.println("\n");
	}%>
	
	--%>
	
	<table>
	<tr><th>Nome</th><th>Idade</th><th>Data</th><th>Email</th></tr>
	<c:forEach var="list" items="${singleton.lista}">
		<tr>
			<td>${list.nome}</td>
			<td>${list.idade}</td>
			<%-- <td><fmt:formatDate pattern="dd/MM/yyyy"  value="${data}"/></td> --%>
			<td>${list.email}</td>
		</tr>
	</c:forEach>
	</table>
	
	<%--out.print(Singleton.listaDeNome.size()); --%>>
	
	<%-- out.print(mSingleton.listaDeNome.toString()); --%>

</body>
</html>