<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>Cadastro usuário</title>
	
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	
</head>
<body>


<div class="container">
	<h1>Cadastro usuário:</h1>
	<form action="cadastroJSTL.jsp" class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Nome:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="nome" required placeholder="Nome"/><br/>
			</div>
		</div>
		
		<!--Nome: <input type= "text" required placeholder="Nome" name="nome"/><br/>-->
	
		<div class="form-group">
      		<label class="control-label col-sm-2" for="nome" pattern="[1-9]|[1-9][0-9]|[1-9][0-9][0-9]">Idade:</label>
      		<div class="col-sm-10">
        		<input type="text" class="form-control" placeholder="Idade" name="idade"/><br/>
      		</div>
    	</div>
	
		<!--Idade: <input type="text" required placeholder="Idade" pattern="[1-9]|[1-9][0-9]|[1-9][0-9][0-9]" name="idade"/><br/>-->
		
		<div class="form-group">
      		<label class="control-label col-sm-2" for="nome" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,}"">Email:</label>
      		<div class="col-sm-10">
        		<input type="email" class="form-control" placeholder="Email" name="email"/><br/>
      		</div>
    	</div>
			
		<!--  Email: <input type="email" required placeholder="Email" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,}" name="email"/><br/>-->
		
		<div class="form-group">
      		<label class="control-label col-sm-2" for="nome" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,}"">Data de nascimento:</label>
      		<div class="col-sm-10">
        		<input type="date" class="form-control" name="data"  maxlength="10" required placeholder="ddMMyyyy" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" max="2015-08-10"/><br/>
      		</div>
    	</div>
			
			
		<!--  Data de nascimento: <input type="date" maxlength="10" required placeholder="ddMMyyyy" pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1900-01-01" max="2015-08-10" name="data"/><br/>-->
		
		</div>
			<div class="col-sm-offset-2 col-sm-10">	
				<input type="submit" class="btn btn-default" value="Adicionar"><br/>
			</div> 
	</form>
	
	<form action="exibirJSTL.jsp">
		<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value= "Exibir"> <br/>
		</div>
	</form>
	
</div>


	

</body>
</html>


