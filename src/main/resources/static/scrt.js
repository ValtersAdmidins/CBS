
function seatCheckBox(id) {
	
	//<div> elements kura likt sarakstu ar izveletajam sedvietam
	var checkedSeats = document.getElementById("chosenseats");
	
	//checkbox uz kuru tika nospiests
	var seat = document.getElementById(id);
	
	
	if(seat.checked == false){
		// ja checkbox jau bija iezimets iegust <p> elementu kura ierakstita izveleta bilete
		//un to izdzes
		var para = document.getElementById("p"+id);
		checkedSeats.removeChild(para);
	
	}else{
		//izveido <p> elementu kur paradit izveleto bileti un to pievieto <div> elemetnam 
		//ar id checkedseats
		var para = document.createElement("p");
		para.setAttribute("id","p"+id);
		var node = document.createTextNode(id);
		para.appendChild(node);

		
		checkedSeats.appendChild(para);
	}
	
	calculateTotal();
	
		
}


//sum total money
function calculateTotal() {
	
	var ticketCount = 0;
	
	//temporary price
	var ticketPrice = 5;
	
	var seats = document.getElementsByClassName("seatcheckbox");
	var total = 0;
	for (var i = 0; i < seats.length; i++) {
	    if(seats[i].checked){
	    	total+=ticketPrice;
	    	ticketCount++;
	    }
	}
	document.getElementById("counter").innerHTML = ticketCount;
	document.getElementById("total").innerHTML = total + "€";
}