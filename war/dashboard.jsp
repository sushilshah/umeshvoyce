<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.voyce.model.User" %>
<% 
      User usr = (User)request.getSession().getAttribute("USER");
      if(usr ==null)
      {
    	response.sendRedirect("./login");
      }
 %>

<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Voyce Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
	
	<!-- Google Chart-->
	<script src='/_ah/channel/jsapi'></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" language="javascript">
     
    $(document).ready(function() {
	       
    	  window.resizeTo(400,400);
    	  $(".panel-bodynoti").css("height",$( document ).height());
          $.getJSON('/LiveFeeds', function(jd) {          
             //alert(jd.token);
             channel 			= new goog.appengine.Channel(jd.token);
             socket 			= channel.open();
             socket.onopen 		= onOpened;
             socket.onmessage 	= onMessage;
             socket.onerror 	= onError;
             socket.onclose 	= onClose;
          });
          
         // alert("Connection toek:" + token)
   });
   
   onOpened = function(){
	   
	  // alert("connection done!!!");
   }
   
   onClose = function(){
	   
	   alert("Connection Closed!!!");
   }
   onMessage = function(message){
	   //alert(message.data+" recieved");
	   var input = "<div class='alert alert-success alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button><strong>Feedback!</strong><span style='font-size:12pt'>"+message.data+"</span></div>";
	   $('#livefeed').prepend(input);
	   //alert(message.data+"  here we got");
   }
   
   onError  = function(errorobj){
	   $('#livefeed').append('<p>Error Recieved: ' +errorobj.description + '</p>');
	   
	  
	   alert("error recieved" +errorobj.description );
   }
   
   
   
   </script>
   <!-- End with the notification system -->
	

	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year,Month,Week,Day', 'Previous CHI', 'Current CHI'],
          ['Year',1000,400],
          ['Month', 1170,460],
          ['Week',660,1120],
          ['Daily',1030,540]
        ]);

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
     
    </script>
  </head>
  <body data-spy="scroll" data-target=".navbar-example">

    <!--Navigation Bar at the Top-->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Voyce Dashboard</a>
        </div>
      </div>
    </div>
    <!-- Navigation End -->
	
    <!-- Main Content -->
    <div class="container">
    <div class="jumbotron">
		      
				        <table class="table-responsive">
							        <table class="table">
									<tr>
									<td width="70%">
										<div class="row">
										<div class="col-md-5">
											<div class="panel panel-info">
													<div class="panel-heading"><h3 class="panel-title">Today's Mood</h3></div>
															<table class="table">
															<tr>
															<td><span class="scorebadge" ><s:property value="%{dashboard.chi.customerHappyIndex}"></s:property></span></td>
															<td align="right"><img src="<s:property value='%{dashboard.chi.imageUrl}'/>" alt="..." class="img-rounded"></td>
															<tr>
															</table>
													<div class="panel-body"> 
															<table class="table">
															<thead style="font-size:10pt;">
															<tr>
															<th>Visited</th>
															<th>Happy</th>
															<th>Sad</th>
															<th>No Feeling</th>
															</tr>
															</thead>
															<tbody style="font-size:10pt;">
															<tr class="active">
															<td align="center"><s:property value="%{dashboard.chi.customersGivenFeedback}"></s:property></td>
															<td ><s:property value="%{dashboard.chi.customerHappy}"></s:property></td>
															<td align="center"><s:property value="%{dashboard.chi.customerNoFeeling}"></s:property></td>
															<td align="center"><s:property value="%{dashboard.chi.customerHateUs}"></s:property></td>
															</tr>
															</tbody>
															</table>
													</div>
											</div>
				                        </div>
  
				                        <div class="col-md-5">
				                             <div class="panel panel-info">
					                                 <div class="panel-heading"><h3 class="panel-title">Comparison Chart</h3></div>
					                                 <div class="panel-body"> 
					                                   <div id="chart_div" ></div>
					                                 </div>
				                             </div>
				                        </div>
										
				                        </div><!--Row ends-->
				                        
										<div class="row"><!--Other row starts-->
						                <div class="col-md-10">
						                     <div class="panel panel-info">
											 <div class="panel-heading"><h3 class="panel-title">Level One Ratings</h3></div>
											 <div class="panel-body"> 
												<table class="table table-hover">
												<thead style="font-size:10pt;">
												  <tr>
													<th></th>
													<th align="center">Total</th>
													<th align="center">Cumulative</th>
													<th align="center">Industry Stand.</th>
												  </tr>
												</thead>
												<tbody   style="font-size:10pt;">
												  <tr class="active">
													<td >Food</td>
													<td align="center">3</td>
													<td align="center">4</td>
													<td align="center">4</td>
												  </tr>
												  <tr>
													<td >Ambience</td>
													<td align="center">3</td>
													<td align="center">4</td>
													<td align="center">4</td>
												  </tr>
												  <tr class="success">
													<td >Temperature</td>
													<td align="center">3</td>
													<td align="center">4</td>
													<td align="center">4</td>
												  </tr>
												  <tr>  
													<td >Speed</td>
													<td align="center">3</td>
													<td align="center">4</td>
													<td align="center">4</td>
												  </tr>
												  <tr class="warning"> 
													<td> Drinks</td>
													<td align="center">3</td>
													<td align="center">4</td>
													<td align="center">4</td>
												  </tr>
												</tbody>
											  </table>
	                                         </div>
	                                         </div>
	                                    </div>
	                                    </div> 
										<div class="row">
										<div class="col-md-5">
													 <div class="list-group">
													  <a  class="list-group-item active">
														<span style="font-size:13pt">Wrong</size>
													  </a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Food was worst!!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Ambience Was worst!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Service Was bad!!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">No response!!!</size></a>
													</div>
										</div>
									    <div class="col-md-5">
													  <div class="list-group">
													  <a class="list-group-item active">
														<span style="font-size:13pt">Right</size>
													  </a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Good Service!!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Good Stuff keep it up !!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Good Going...!!!</size></a>
													  <a href="#" class="list-group-item"><span style="font-size:13pt">Great Ambience!!!!</size></a>
													</div>
										 </div>
										 </div>
	 
  </td>
  <td width="30%" >
				  <div class="col-md-">
					  <div class="panel panel-info">
						<div class="panel-heading"><h3 class="panel-title">Live Feeds</h3></div>
						 <div class="panel-bodynoti" id="livefeed"> 
						      				      <div class="alert alert-success alert-dismissable">
									  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
									  <strong>Warning!</strong><span style="font-size:12pt"> Best check yo self, you're not looking too good.</span>
						      </div>
					     </div>
					  </div>
				  </div>
  </td>
  </tr>
  </table>
  </table class="table-responsive">
  </div>
  </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.js"></script>
    <script src="js/bootstrap.js"></script>
</body></html>