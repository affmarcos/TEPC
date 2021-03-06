<!DOCTYPE html>
<html lang="en">
     <head>
     <title>Contacts</title>
     <meta charset="utf-8">
     <meta name="format-detection" content="telephone=no" />
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/form.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/script.js"></script> 
     <script src="js/superfish.js"></script>
     <script src="js/jquery.equalheights.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/TMForm.js"></script>
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
       <li><a href="index.html">Inicial</a></li>
       <li><a href="index-1.html">Categorias</a></li>
       <li><a href="index-2.html">Fale Conosco</a></li>
       <li><a href="index-3.html">Sobre</a></li>
       <li class="current"><a href="index-4.html"></a></li>
     </ul>
    </nav>
    <div class="clear"></div>       
  </div>
</header>  

<!--=====================Content======================-->
<section class="content">
	<!--<div class="ic">More Website Templates @ TemplateMonster.com - May 19, 2014!</div>-->
  <div class="container_12">
<!--
    <div class="grid_5">
 
  <h4>How to Find Us</h4>
            <div class="map">
            <figure class="">
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d24214.807650104907!2d-73.94846048422478!3d40.65521573400813!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sus!4v1395650655094" style="border:0"></iframe>
            </figure>
           <p>You can be sure that you get 24/7 support for all <span class="color1"><a href="http://www.templatemonster.com/" rel="nofollow">premium templates</a></span> you purchase at TemplateMonster. Free themes go without it.</p>
           <p><span class="color1"><a href="http://www.templatetuning.com/" rel="nofollow">TemplateTuning</a></span> will assist you in customization of any theme you choose.</p>
           The Company Name Inc. <br>
           9870 St Vincent Place,<br>
           Glasgow, DC 45 Fr 45.<br>
           Telephone: +1 800 603 6035<br>
           FAX: +1 800 889 9898<br>
           E-mail: <a href="#">mail@demolink.org</a>
          </div>
    </div>
-->
    <div class="grid_8">
      <h3>Cadastro Filme</h3>
      <form id="form" action="/AdicionarFilme/" method="POST" enctype="multipart/form-data">                            
      <div class="success_wrapper">
      <div class="success-message">Cadastro realizado!</div>
    </div>
	
	<div class="grid_8">
      <label class="name">
      <input type="text" placeholder="Name:" />
      
      </label>
    </div>
	
	<div class="grid_8">
      <label class="categoria">
      <input type="text" placeholder="Categoria:" />
      
      </label>
    </div>
	


<div class="grid_8">
      <label class="trailer_link">
      <input type="text" placeholder="Link do trailer:" />
     
      </label>
    </div>	
    
    <%--div class="grid_8"> --%>
      <label class="image">
      <input type="file"  size="40" name="Imagem:" ></input>     
      </label>
    <%--/div--%>
	
	<div class="grid_8">
      <label class="descricao">
      <textarea type="text" placeholder="Descri��o:" ></textarea>
     
      </label>
    </div>

<!--
      <label class="message">
      <textarea placeholder="Message:" data-constraints='@Required @Length(min=20,max=999999)'></textarea>
      <span class="empty-message">*This field is required.</span>
      <span class="error-message">*The message is too short.</span>
      </label>
-->	

<div class="grid_8">
      
      <div class="clear"></div>
      <div class="btns">
      <a href="#" data-type="reset" class="link1">Limpar</a>
      <a href="#" data-type="submit" class="link1">Enviar</a></div>
	</div>
      </form>   
    </div>
    <div class="clear"></div>
  </div>
</div>
</section>
<!--==============================Bot_block=================================-->


<!--==============================footer=================================-->
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
</footer>
</body>
</html>

