function register(){
	
	nameofRestaurant 	= document.getElementById("resName");
	if(nameofRestaurant && nameofRestaurant.value){
		  
		nameofRestaurant = nameofRestaurant.value;
	}
	else{
		
		document.getElementById("resNameError").innerHTML = "Please Fill Name Of Restaurant!!:"
		nameofRestaurant.focus();
	}
		
	addressLineOne 		= document.getElementById("resAdd1");
	if(addressLineOne && addressLineOne.value){
		
		
	}
	else
	{
		
	}
	
	
	addressLineTwo 		= document.getElementById("resAdd2");
	if(addressLineTwo && addressLineTwo.value){
		
		
	}
	else{
		
		
	}	
		
	locality 			= document.getElementById("locality");
	if(locality && locality.value){
		
	}
	else{
		
		
	}
	
	city 				= document.getElementById("city").value;
	if(city && city.value){
		
		
	}
	else{
		
		
	}
		
	state 				= document.getElementById("state").value;
	if(state && state.value){
		
	}
	else{
		
	}
	
	country 			= document.getElementById("country").value;
    if(state && state.value){
		
	}
    else{
    	
    }
    
	telephone 			= document.getElementById("resTel");
    if(telephone && telephone.value){
		
	}
    else{
    	
    }
    
	mobile 				= document.getElementById("resMob");
    if(mobile && mobile.value){
		
	}
    else{
    	
    }
    
    facebookPage 		= document.getElementById("resFB");
    if(facebookPage && facebookPage.value){
		
	}
    else{
    	
    }
    
    website 			= document.getElementById("resWeb");
    if(website && website.value){
		
	}
    else{
    	
    }
    
    ownerDetails 		= document.getElementById("resOwnDetail");
    if(ownerDetails && ownerDetails.value){
		
	}
    else{
    	
    }
    
	ownerNumber 		= document.getElementById("resOwnNumber");
    if(ownerNumber && ownerNumber.value){
		
	}
    else{
    	
    }
    
    ownerEmail 			= document.getElementById("resOwnEmail");
    if(ownerEmail && ownerEmail.value){
		
	}
    else{
    	
    }
    
	//Restaurant Category
	resCategory 		= document.getElementById("rescatselect");
    if(resCategory && resCategory.value){
		
	}
    else{
    	
    }
    
	//Facilities
	dinein 				= document.getElementById("fcdinein").checked;
	delivery 			= document.getElementById("fcdelivery").checked;
	takeAway 			= document.getElementById("fctakeaway").checked;
	catering 			= document.getElementById("fccatering").checked;
	
	
	//Features
	pureVeg 			= document.getElementById("fcfeature").checked;
	halal 				= document.getElementById("fcpureveg").checked;
	aircon 				= document.getElementById("fcaircon").checked;
	wifiInternet 		= document.getElementById("fcwifiinternet").checked;
	bar 				= document.getElementById("fcbar").checked;
	smokingArea 		= document.getElementById("fcsmokingarea").checked;
	shisha 				= document.getElementById("fcshisha").checked;
	liveMusic 			= document.getElementById("fclivemusic").checked;
	carParking 			= document.getElementById("fccarparking").checked;
	valetParking 		= document.getElementById("fcvaletparking").checked;
	swimPool 			= document.getElementById("fcswimpool").checked;
	outdoorSeating 		= document.getElementById("fcoutdoorseating").checked;
	
	
	
	//PaymentOption
	cash 				= document.getElementById("fccash").checked;
	credit 				= document.getElementById("fccredit").checked;
	sodexo 				= document.getElementById("fcsodexo").checked;
	citibankOffer 		= document.getElementById("fccitibankoffers").checked;
	onlineOrders 		= document.getElementById("fconlineorders").checked;
	
	//reservation
	reservation 		= document.getElementById("catreservation");
    if(reservation && reservation.value){
		
	}
    else{
    	
    	
    }
    
	//open hours
	openFromHrs 		= document.getElementById("fcopenfromhrs");
    if(openFromHrs && openFromHrs.value){
		
	}
    else{
    	
    } 
    
	openToHrs 			= document.getElementById("fcopentohrs");
    if(openToHrs && openToHrs.value){
		
	}
    else{
    	
    }
    
	//cusisines
	cusineOne 			= document.getElementById("catcusine1");
    if(cusineOne && cusineOne.value){
		
	}
    else{
    	
    }
    
	cusineTwo 			= document.getElementById("catcusine2");
    if(cusineTwo && cusineTwo.value){
		
	}
    else{
    	
    	
    }
    
	cusineThree 		= document.getElementById("catcusine3");
    if(cusineThree && cusineThree.value){
		
	}
    else{
    	
    }
    
    cusineFour 			= document.getElementById("catcusine4");
    if(cusineFour && cusineFour.value){
		
	}
    else{
    	
    }
	
	
	serviceJson = "{'emailId':"+ ownerEmail +",'facilitiesAvail': {'dineIn':"+ dinein+",'delivery':"+ delivery+",'takeAway':"+ takeAway+",'catering':"+ catering+"},'featuresAvail': {'pureVeg':"+pureVeg+",'halal':"+halal+",'airCondition':"+ aircon +",'wifiInternet':"+ wifiInternet +",'bar':"+ bar+",'somkingArea':"+smokingArea+",'shisha':"+ shisha+",'liveMusic':"+ liveMusic+",'carParking':"+ carParking+",'valetParking':"+ valetParking+",'swimPool':"+ swimPool+",'outdoorSeating':"+ outdoorSeating +"},'paymentOptionsAvail': {'cash':"+ cash+",'credit':"+ credit +",'sodexo':"+ sodexo +",'citiBankOffers':"+ citibankOffer+",'onlineOders':"+ onlineOrders+",'reservation': "+reservation+",'fromOpenHours':"+ openFromHrs+",'fromToOpenHours':"+ openToHrs+ "},'cusines': [ '"+cusineOne+"','"+cusineTwo+"','"+cusineThree+"','"+cusineFour+"'],'restaurantCategory':"+ resCategory+"}";
   
	alert(serviceJson);
}











