<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
$(document).ready(function () {
	$('#submitBtn').click(function(){
			console.log('[  JD IS ::: ]')
		console.log('question : ');
		$.ajax({
			
			url: "/question",
			type: "POST",
			data : {questionNumber : 1.1 , rating: 1, numberOfQues : 4},
			dataType : "html"
		}).done(function( msg ){
			jsonreq = $.parseJSON(msg);
			console.log(msg);
			console.log(jsonreq.questions.questions['2.0'].questionText)
			
		});
		
		
	});
});
 
</script>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="http://getbootstrap.com/docs-assets/ico/favicon.png">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
    

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    function launchFullscreen(element) {
    	  if(element.requestFullscreen) {
    	    element.requestFullscreen();
    	  } else if(element.mozRequestFullScreen) {
    	    element.mozRequestFullScreen();
    	  } else if(element.webkitRequestFullscreen) {
    	    element.webkitRequestFullscreen();
    	  }
    	}
    </script>
  </head>
  <body onload="launchFullscreen(document.documentElement);" >
    
    <div class="container" >
    <form action="" id="form1">
        <button class="btn btn-lg btn-primary btn-block" id="submitBtn" type="button">form 1</button>
    </form>
<!--       <form class="form-signin" role="form" action='login.action' method="post"> -->
<!--         <img src='img/logo.png' /> -->
<!--         <br /> -->
<!--         <br /> -->
<!--         <input type="text" name='user' class="form-control" placeholder="Email address" required="" autofocus=""> -->
<!--         <br /> -->
<!--         <input type="password" name='password' class="form-control" placeholder="Password" required=""> -->
<!--         <label class="checkbox"> -->
<!--           <input type="checkbox" value="remember-me"> Remember me -->
<!--         </label> -->
<!-- <!--         <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> --> -->
<!--       </form> -->
      <div id='1'> SUSHIL </div>
      
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    </body>
    </html>