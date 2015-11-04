<!DOCTYPE html>
<html lang="pt-br">
<head>

<head>
	<meta charset="utf-8">
	<title>MOSTRA dados</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

</head>
<body>
	<br/>
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<jsp:useBean id="singleton" class="classes.Singleton"/>	
	<div class="container">
		<table class="table table-striped">
		<thead>
		<tr><th>Nome</th><th>Idade</th><th>Data</th><th>Email</th></tr>
		</thead>
			<c:forEach var="list" items="${singleton.lista}">
				<tr>
					<td>${list.nome}</td>
					<td>${list.idade}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"  value="${list.data}"/></td>
					<td>${list.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>


