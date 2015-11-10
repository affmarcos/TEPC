<!DOCTYPE html>
<html lang="en">
     <head>
     <title>Filme</title>

     <meta charset="utf-8">
     <meta name="format-detection" content="telephone=no" />
     <link rel="icon" href="../images/favicon.ico">
     <link rel="shortcut icon" href="../images/favicon.ico" />
     <link rel="stylesheet" href="../css/style.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/script.js"></script> 
     <script src="js/superfish.js"></script>
     <script src="js/jquery.equalheights.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script>

    function goToByScroll(id){$('html,body').animate({scrollTop: $("#"+id).offset().top},'slow');}

     </script>

     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<%@ page import = "java.util.*"  %>	
	<%@ page import = "classes.Filme"  %>
    <jsp:useBean id="filme" class="classes.Filme" scope="request"/>
   
    <!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
         </a>
      </div>
    <![endif]-->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <link rel="stylesheet" media="screen" href="css/ie.css">


    <![endif]-->
     </head>
     <body class="" id="top">
<!--==============================header=================================-->
<header>

  <div class="container_12">
            <div class="grid_12">
                      <h2>
          <a href="../index-1.html">
            <img src="../images/logo.png" alt="Your Happy Family">
          </a>
        </h2>  
             
    </div>
  </div> 
  <div class="clear"></div>
  <div class="menu_block">
    <nav class="horizontal-nav full-width horizontalNav-notprocessed">
      <ul class="sf-menu">
       <li><a href="../index.html">Inicial</a></li>
       <li class="current"><a href="index-1.html">Categorias</a></li>
       <li><a href="../index-2.html">Fale Conosco</a></li>
       <li><a href="../index-3.html">Sobre</a></li>
       <a href="../index-4.html"></a></li>
     </ul>
    </nav>
    <div class="clear"></div>       
  </div>
</header>  

<%String filmeSelecionado =(String) request.getAttribute("nomeFilmeAtual");  
  filme.setNome(filmeSelecionado);
  filme = filme.getFilmePor();
  Filme fil = new Filme();
  fil.setNome(filmeSelecionado);
  String imagemAtual = filme.getImagem();
%>

<!--=====================Content======================-->
<section class="content">
  

	<div class="container_12">
		<div class="grid_12">
			<h1>${filme.nome}</h1>
		</div>
			
		
	
		<div class="grid_3">
			<a href="../${fil.imagem }" class="box">
				<div class="maxheight">
					<img src="../images/<%out.println(imagemAtual); %>" alt="Carregar Imagem" height = "270" width = "395">
						<div class="box_bot">
							<p>${filme.nome }</p>
						</div>
				</div>
			</a>
		</div>
	 
		<div class="grid_6">
				<h2>${filme.nome}</h2>
				<div class="rating">
					<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
				</div>
			
				<p><%  out.println(filme.getDescricao()); %>

		</div>
	  
		<div class="grid_3">
			<p>Titulo: filme.nome
			<br/>
			<p> Diretor: filme.diretor
			<br/>
			<p> Ano: filme.ano
			<br/>
			<p>Atores: filme.ator
			<br/>
			<p>

		</div>	
	</div>
</section>
<!--==============================Bot_block=================================-->
<!--==============================footer=================================-->
<div class="fb-comments" data-href="http://developers.facebook.com/docs/plugins/comments/" data-width="350" data-numposts="3"></div>


<footer> 
  <div class="container_12">
    <div class="row">
      <div class="grid_12">  
            <a href="#" onclick="goToByScroll('top'); return false;" class="top"></a><br> <a href="#" class="f_logo"><img src="../images/f_logo.png" alt=""></a>
          <div class="footer_socials">
            <a href="#" class="fa fa-twitter"></a>
            <a href="#" class="fa fa-facebook"></a>
            <a href="#" class="fa fa-google-plus"></a>
            <a href="#" class="fa fa-instagram"></a>
          </div>
          <div class="copy"><span class="brand">RecoMoo </span>  &copy; <span id="copyright-year"></span>  | <a href="#">Privacy Policy</a> 
            <div class="sub_copy">Website designed by ExtremeGoHorseCorporation</div>
          </div>
      </div>
    </div>
  </div>  
  <div class="clear"></div>
<div id="fb-root"></div>



</footer>




</body>
</html>

