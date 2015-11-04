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
	
	<%@ page import = "java.util.*"  %>	
	<%@ page import = "classes.Singleton"  %>
	
	<jsp:useBean id="user" class="classes.Usuario" scope="request"/>
	
	<%
	
	String nome = request.getParameter("nome");
	String idade = request.getParameter("idade");
	String data = request.getParameter("data");
	String email = request.getParameter("email");
		
	int year = Integer.parseInt(data.substring(0, 4));
	int month = Integer.parseInt(data.substring(5, 7));
	int day = Integer.parseInt(data.substring(8, 10));
	
	user.setNome(nome);
	user.setIdade(Integer.parseInt(idade));
	
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR,year);
	c.set(Calendar.MONTH,month);
	c.set(Calendar.DAY_OF_MONTH,day);
	user.setData(c);
	user.setEmail(email);
	
	Singleton.listaDeNome.add(user);
	
	response.sendRedirect("sucesso.jsp");
	%>

		


</body>
</html>