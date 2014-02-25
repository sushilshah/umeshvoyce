<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    
    
    
    
  </head>
  <body  >
    
    <div class="container" >
    
      <form class="form-signin" role="form" action='login.action' method="post">
        <img src='img/logo.png' />
        <br />
        <br />
        <input type="text" name='user' class="form-control" placeholder="Email address" required="" autofocus="">
        <br />
        <input type="password" name='password' class="form-control" placeholder="Password" required="">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
       
             <!-- Button trigger modal -->
         <button class="btn btn-lg btn-primary btn-block" data-toggle="modal" data-target="#myModal">
  			Sign up
		</button>
 
   </form>
      
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      
      <div class="modal-body">
       
       <table width="100%">
       <tr>
       <td width="50%">
        <input type="text" id="regusername" name='username' class="form-control" placeholder="Email address" required="" autofocus="true">
        <br />
         <input type="password"  name='password' class="form-control" placeholder="password" required="" autofocus="">
         <br />
          <input type="password" id="regconfirmpassword" name='confirmpassword' class="form-control" placeholder="confirm password" required="" autofocus="">
          <div class="modal-footer">
          <button type="button" id="register" class="btn btn-primary">Register</button>
          </div>
          </td>
          <td width="50%">
          <img src="img/cor.jpg" />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          </td>
          </tr>
      
      </div>
      
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
       
      
          
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript">	  	
    	$("#register").click(function(){
    	
    	 var usernameval  = document.getElementsByName("username")[0].value;
    	 var passwordval = document.getElementsByName("password")[0].value; 
    	 var request = $.ajax({
    		  url: "/manage/signup",
    		  type: "POST",
    		  data: { username: usernameval, password: passwordval },
    		  dataType: "html"
    		});
    		request.done(function( msg ) {
    			  jsonres =	$.parseJSON(msg);
    			  if(jsonres.signupSuccessFull=="false")
    			  {
    				alert("Please try Again, I guess User Already Exists!!!");  
    				  
    			  }
    			   if(jsonres.signupSuccessFull=="true")
    			   {
    				   alert("Conrats Registration Done !!! Login Please");
    				   
    			   }
    		});
    });
    </script>
    </body>
    </html>