<!DOCTYPE html>
<html lang="en">
     <head>
     <title>Categorias</title>

     <meta charset="utf-8">
     <meta name="format-detection" content="telephone=no" />
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/script.js"></script> 
     <script src="js/superfish.js"></script>
     <script src="js/jquery.equalheights.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script>

    function goToByScroll(id){$('html,body').animate({scrollTop: $("#"+id).offset().top},'slow');}

     </script>


        
   
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
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<%@ page import = "java.util.*"  %>	
	<jsp:useBean id="categoria" class="classes.Categorias" scope="request"/>
	

     
<!--==============================header=================================-->
<header>

  <div class="container_12">
            <div class="grid_12">
                      <h2>
          <a href="index.html">
            <img src="images/logo.png" alt="Your Happy Family">
          </a>
        </h2>  
             
    </div>
  </div> 
  <div class="clear"></div>
  <div class="menu_block">
    <nav class="horizontal-nav full-width horizontalNav-notprocessed">
      <ul class="sf-menu">
       <li><a href="/TEPC/index.html">Inicial</a></li>
       <li class="current"><a href="/TEPC/categorias.jsp">Categorias</a></li>
       <li><a href="/TEPC/formulario.jsp"> Cadastro de Filme </a></li>
       <li><a href="/TEPC/contato.html">Fale Conosco</a></li>
       <li><a href="/TEPC/sobre.html">Sobre</a></li>
       
     </ul>
    </nav>
    <div class="clear"></div>       
  </div>
</header>  

<!--=====================Content======================-->
<section class="content"><div class="ic">More Website Templates @ TemplateMonster.com - May 19, 2014!</div>
  

<div class="container_12">
<div class="grid_12">
      <h2>Categorias</h2>
    </div>
<c:forEach var="list" items="${categoria.categorias}">
    <div class="grid_3">
		<a href="/TEPC/Categoria/${list.url}" class="box"> <!-- seria legal completar a href dinamicamente, não sei como fazer preciso ver o teu link-->
         <div class="maxheight">
          <img src="images/${list.capa}" height = "271" width = "385" alt="">
          <div>
          		${list.nome}
          </div>
            
        </div>
      </a></div>
</c:forEach>

    
    <div class="clear"></div>
  </div>
</section>
<!--==============================Bot_block=================================-->
<!--==============================footer=================================-->
<div class="fb-comments" data-href="http://developers.facebook.com/docs/plugins/comments/" data-width="350" data-numposts="3"></div>


<footer> 
  <div class="container_12">
    <div class="row">
      <div class="grid_12">  
            <a href="#" onclick="goToByScroll('top'); return false;" class="top"></a><br> <a href="#" class="f_logo"><img src="images/f_logo.png" alt=""></a>
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

