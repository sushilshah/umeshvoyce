<%@page import="com.voyce.util.JsonUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@ page import="com.voyce.model.User" %>
	<% 
      User usr = (User)request.getSession().getAttribute("USER");
      if(usr == null)
      {
    	//response.sendRedirect("./login");
      }
 	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/jquery.mobile-1.4.0.min.css"> 
<link rel="stylesheet" href="../css/jqm-demos.css">
<script src="../js/jquery-1.11.0.js"></script>
<script src="js/jquery.mobile-1.4.0.min.js"></script>
<script src="js/jquery.raty.js"></script>

</head>
<script>

var questionCount = 0;
var pageNumber = 1;
var _pageNumber = pageNumber + 1; 
var allResponses = {'1' : [], '2':[], '3' : [], '4' :[], '5':[]};
var thisPageResponses = {'1' : [], '2':[], '3' : [], '4' :[], '5':[]};
var lastQues = false;
var multiQues = true;
var isFirstQues = 1;
var L2Responses = {'1' : [], '2':[], '3' : [], '4' :[], '5':[]};
var overAllResponse = 3;
var userComments = '';
var custName = "";
var custNumber = "";
var resturantId = "";
var tableNumber = "";

var outputResponse = {};

$( document ).ready(function() {
	
	$().submit(function(){
		outputResponse["allResponses"] = allResponses;
		outputResponse["overAllRating"] = overAllResponse;
		outputResponse["userComments"] = userComments;
		outputResponse["custName"] = custName;
		outputResponse["custNumber"] = custNumber;
		outputResponse["resturantId"] = resturantId;
		outputResponse["tableNumber"] = tableNumber;
		outputResponse["userId"] = "";
		outputResponse["publicProfile"] = "facebook";
		
	});
	
	$("#btn_3_5").click(function(){
	//submit allResponses ..
		outputResponse["allResponses"] = allResponses;
		outputResponse["overAllRating"] = overAllResponse;
		//outputResponse["userComments"] = userComments;
		//outputResponse["custName"] = custName;
		//outputResponse["custNumber"] = custNumber;
		//outputResponse["resturantId"] = resturantId;
		//outputResponse["tableNumber"] = tableNumber;
	});

	$("#btn__comment").click(function(){
		userComments = $("#userComments").html();
		outputResponse["userComments"] = userComments.trim() ;
	});
	
	$('.rating').raty({ score: 3,
						size: 40,
						click: function(score, evt) {
							if(score <= 2){
								//$.mobile.changePage('#popup', { transition: "pop", role: "dialog", reverse: false } );
							}
						}
		});
	 //getNextQues();
	 
});

function getNextQues(_queNo, _rating, _numberOfQues, _multi){
	var outputJson;

	$.ajax({
		url: "/question",
		type: "POST",
		data : {questionNumber : _queNo, rating: _rating, numberOfQues : _numberOfQues, multi: _multi},
		dataType : "text"
	}).done(function( msg ){
		var newPages;
		jsonreq = $.parseJSON(msg);
		outputJson = msg;
		//createNextPage(jsonreq);
		if(!jsonreq.questions.empty){
			var ques = jsonreq.questions.questions;
			$.each(ques, function(index, value){
				newPages += '<h2>' + value.questionText + '</h2>';
				newPages += '<div class="rating" name='+ index +'> </div>';
				
				//setting up by default rating of 3
				if(allResponses["3"].indexOf(index) == -1){
					allResponses["3"].push(index );
					thisPageResponses["3"].push(index );
				}
			});
		}
		$("#main_two").append(newPages);
		applyStars();
	});
}

function applyStars(){
	$('.rating').raty({ score: 3,
		size: 40,
		click: function(score, evt) {
			var _quesno = $(this).attr('name');
			//alert('name: ' + $(this).attr('name') + "\nscore: " + score + "\nevent: " + evt);
			
			//TODO improve this.Two loops might not be required. Removing exiting rating and then adding the changed one.
			/* Belive can be achieved using IndexOf check  
			arr = arr.filter(function (e, i, arr) {
					return arr.lastIndexOf(e) === i;
				});*/
			$.each(allResponses , function (key, val){
				$.each(val, function(index, result) {
					if( result == _quesno){
						allResponses[key].splice(index, 1);
						thisPageResponses[key].splice(index, 1);
					}
				});
			} );
			allResponses[score].push(_quesno); //pushing rating and question number for final response
			thisPageResponses[score].push(_quesno);
			if(score <= 2){
				//$.mobile.changePage('#popup', { transition: "pop", role: "dialog", reverse: false } );
			}
		}
	});
}

function applyStars1(){
	
	$('.rating1').raty({ score: 3,
		size: 40,
		click: function(score, evt) {
			var _quesno = $(this).attr('name');
			//alert('name: ' + $(this).attr('name') + "\nscore: " + score + "\nevent: " + evt);
			
			//TODO improve this.Two loops might not be required. Removing existing rating and then adding the changed one.
			
			$.each(allResponses , function (key, val){
				var idx = allResponses[key].indexOf(_quesno);
				if(idx > -1)
					allResponses[key].splice(idx, 1);
		
				idx = L2Responses[key].indexOf(_quesno);
		
				if(idx > -1)	
					L2Responses[key].splice(idx, 1);
				
			});

			allResponses[score].push(_quesno); //pushing rating and question number for final response
			L2Responses[score].push(_quesno);
			if(score <= 2){
				//$.mobile.changePage('#popup', { transition: "pop", role: "dialog", reverse: false } );
			}
		}
	});
}
</script>

<body class="ui-mobile-viewport ui-overlay-a">
<script>
$( document ).ready(function() {
	 $("#btn-pg1").click(function(){
		var noOfReqQues = 4; //this should generally come from some setting or from question modal
		 overAllResponse = $('.rating').raty('score');
		
		var abc = getNextQues("1.1", overAllResponse , noOfReqQues, false); //TODO: remove the hard coded question number.
	 });
	
});
</script>

<!-- Start of first page: #one -->
<div data-role="page" id="one" data-url="one" tabindex="0" class="ui-page ui-page-theme-a ui-page-active" style="min-height: 690px;">

	<div data-role="header" role="banner" class="ui-header ui-bar-inherit">
		<h1 class="ui-title" role="heading" aria-level="1">Multi-page</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>Welcome Mr <%= usr.getTableStatus().getCustName()%></h2>
		<p>How was your overall experience</p>
		<div class='rating' name='one'> </div>
		<p><a href="#two" id="btn-pg1" class="ui-btn ui-shadow ui-corner-all">Show page "two"</a></p>
<!-- 		<p><a href="#popup" class="ui-btn ui-shadow ui-corner-all" data-rel="dialog" data-transition="pop">Show page "popup" (as a dialog)</a></p> -->
	</div><!-- /content -->

	<div data-role="footer" data-theme="a" role="contentinfo" class="ui-footer ui-bar-a">
		<h4 class="ui-title" role="heading" aria-level="1">Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page one -->


<!-- Start of second page: #two -->
<div data-role="page" id="two" data-theme="a" data-url="two">
	<script>
	thisPageResponses = {'1' : [], '2':[], '3' : [], '4' :[], '5':[]};
	$(document).ready(function(){
		$("#btn_next_pg2").click(function(){
			_thisPageResponses = JSON.stringify(thisPageResponses);
			//var abc = getNextQues("1.1", '1', '4', false);
			$.ajax({
				url: "/question",
				type: "POST",
				data : {ratingAndQuesMap: _thisPageResponses , numberOfQues: 5, multi: true},
				dataType : "text"
			}).done(function( msg ){
				var newPages;
				jsonreq = $.parseJSON(msg);
				outputJson = msg;
				//createNextPage(jsonreq);
				if(!jsonreq.questions.empty){
					var ques = jsonreq.questions.questions;
					var quesCount = 1;

					$.each(ques, function(index, value){
						var ratingDiv = "";
						ratingDiv += '<h2>' + value.questionText + '</h2>';
	     				ratingDiv += '<div class="rating1" name='+ index +'> </div>';
						$('#main_3_' + quesCount).append(ratingDiv);
						quesCount++;
						
						//setting up by default rating of 3
						if(allResponses["3"].indexOf(index) == -1){
							allResponses["3"].push(index );
							L2Responses["3"].push(index );
						}
					});
				}
				//$("#main_two").append(newPages);
				applyStars1();
			});
		});
	});
	</script>

	<div data-role="header">
		<h1>Two</h1>
	</div><!-- /header -->

	<div role="main"  class="ui-content">
		<h2>Two</h2>
		Page two
		<div id="main_two">
		</div>
				
		<p><a href="#3_1" id='btn_next_pg2' data-direction="reverse" class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go Next</a></p>

	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->

<!-- Start of third page: #popup -->
<div data-role="page" id="popup" data-url="popup">

	<div data-role="header" data-theme="b">
		<h1>Dialog</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>Popup</h2>
		<p>I have an id of "popup" on my page container and only look like a dialog because the link to me had a <code>data-rel="dialog"</code> attribute which gives me this inset look and a <code>data-transition="pop"</code> attribute to change the transition to pop. Without this, I'd be styled as a normal page.</p>
		<p><a href="#one" data-rel="back" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-icon-back ui-btn-icon-left">Lets Go Next</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page popup -->

<!-- Start of second page: #two -->
<div data-role="page" id="3_1" data-theme="a" data-url="3_1">

	<div data-role="header">
		<h1>3_1</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>3_1</h2>
		3_1 attribute
		<div id="main_3_1">
		</div>
		<p><a href="#3_2" data-direction="reverse" class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go Next</a></p>

	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->

<!-- Start of second page: #two -->
<div data-role="page" id="3_2" data-theme="a" data-url="3_2">

	<div data-role="header">
		<h1>3_2</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>3_2</h2>
		3_2 attribute
		<div id="main_3_2">
		</div>
		<p><a href="#3_3" data-direction="reverse" class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go Next</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->


<!-- Start of second page: #two -->
<div data-role="page" id="3_3" data-theme="a" data-url="3_3">

	<div data-role="header">
		<h1>3_3</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>3_3</h2>
		3_3 attribute
		<div id="main_3_3">
		</div>
		<p><a href="#3_4" data-direction="reverse" class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go Next</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->

<!-- Start of second page: #two -->
<div data-role="page" id="3_4" data-theme="a" data-url="3_4">

	<div data-role="header">
		<h1>3_4</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>3_4</h2>
		3_4 attribute
		<div id="main_3_4">
		</div>
		<p><a href="#3_5" data-direction="reverse" class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go Next</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->


<!-- Start of second page: #two -->
<div data-role="page" id="3_5" data-theme="a" data-url="3_5">

	<div data-role="header">
		<h1>3_5</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>3_5</h2>
		3_5 attribute
		<div id="main_3_5">
		</div>
		<p><a href="#_comment" data-direction="reverse" id='btn_3_5' class="ui-btn ui-shadow ui-corner-all ui-btn-b">Lets Go to the First Page</a></p>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page two -->
<!-- Start of second page: #two -->
<div data-role="page" id="_comment" data-theme="a" data-url="_comment">


	<div data-role="header">
		<h1>Comment</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<h2>Comment</h2>
		We would to hear something specific from you.
		
		<div id="main__comment">
<!-- 		Enter a comment here -->
			<TEXTAREA NAME=address ROWS=4 COLS=40 id="userComments">
    			How can I better serve you...
    		</TEXTAREA>		
<!-- 		 <input type="text" ></input> -->
		</div>
<!-- 		need to remove hardcoding from here  -->
		<p><a href="#" data-direction="reverse" id='btn__comment' class="ui-btn ui-shadow ui-corner-all ui-btn-b" onClick='finalSubmit()'>last Page</a></p>
	</div><!-- /content -->
	<script type="text/javascript">
		function finalSubmit(){
			var custInfoObj =  <%=  JsonUtils.convertToJson(usr.getTableStatus()) %>;
			outputResponse["allResponses"] = allResponses;
			outputResponse["overAllRating"] = overAllResponse;
			outputResponse["userComments"] = $("#userComments").val().trim();
			outputResponse["userId"] = "";
			outputResponse["publicProfile"] = "facebook";
			outputResponse["custInfo"] = JSON.stringify(custInfoObj);  

			console.log("outputResponse");
			console.log(JSON.stringify(outputResponse));
			
		}

	</script>

	<!-- <div data-role="footer">
		<h4>Page Footer</h4>
	</div>/footer -->
</div><!-- /page two -->

<div class="ui-loader ui-corner-all ui-body-a ui-loader-default"><span class="ui-icon-loading"></span><h1>loading</h1></div>


</body>
</html>