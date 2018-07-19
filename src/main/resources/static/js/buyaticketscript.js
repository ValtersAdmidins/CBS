function stringToView(str) {

	var auditoriumDiv = document.getElementById("stringauditorium");
	var j = 1;
	var k = 0;
	for (var i = 0; i < str.length; i++) {
		
		k++;
		var seat = document.createElement("input");
		seat.setAttribute("id", "R" + j + "C" + k);
		seat.setAttribute("type", "button");
		seat.setAttribute("class", "chooseseatbutton");
		seat.setAttribute("onclick", "seatCheckBox(this.id)");

		if (str[i] == 1) {
			
			seat
					.setAttribute("style",
							"background-color:Linen; width: 50px; height: 50px; border-radius: 25px;");
			seat.setAttribute("value", "R" + j + "C" + k);
			auditoriumDiv.appendChild(seat);
		} else if (str[i] == 0) {
			console.log("ayo");
			seat
					.setAttribute(
							"style",
							" background-color:red;  background:none;border:0;  margin:0; padding:0; width: 50px; height: 50px;");
			auditoriumDiv.appendChild(seat);
			seat.disabled = true;
		} else if (str[i] == 2) {
			var brln = document.createElement("br");
			brln.setAttribute("class","newline");
			auditoriumDiv.appendChild(brln);
			
			k = 0;
			j++;
		} else {
			seat
					.setAttribute("style",
							"background-color:black; width: 50px; height: 50px; border-radius: 25px;");
			seat.disabled = true;
			auditoriumDiv.appendChild(seat);
		}

	}
}

function changeSeatButtonBuying(id) {
	var b = document.getElementById(id);
	
	b.style.backgroundColor = (b.style.backgroundColor == ('lightseagreen')) ? 'Linen':'lightseagreen';
	
}


function seatCheckBox(id) {
	changeSeatButtonBuying(id);
	// <div> elements kura likt sarakstu ar izveletajam sedvietam
	var checkedSeats = document.getElementById("chosenseats");

	// checkbox uz kuru tika nospiests
	var seat = document.getElementById(id);

	if (seat.style.backgroundColor != ('lightseagreen')) {
		// ja checkbox jau bija iezimets iegust <p> elementu kura ierakstita
		// izveleta bilete
		// un to izdzes
		var para = document.getElementById("p" + id);
		checkedSeats.removeChild(para);

	} else {
		// izveido <p> elementu kur paradit izveleto bileti un to pievieto <div>
		// elemetnam
		// ar id checkedseats
		var para = document.createElement("p");
		para.setAttribute("id", "p" + id);
		para.setAttribute("class","CHT");
		var node = document.createTextNode(id);
		para.appendChild(node);

		checkedSeats.appendChild(para);
	}
	makingSeatsTaken();
	calculateTotal(id);

}

function makingSeatsTaken() {
	
	var newseatmapstring = "";
	var seats = document.getElementsByClassName("chooseseatbutton");
	var rowCount = document.getElementsByClassName("newline").length;
	var k = seats.length/rowCount;
	for (var i = 0; i < seats.length; i++) {
		if(seats[i].style.backgroundColor == ('lightseagreen')){
			newseatmapstring += "3";
		}else if(seats[i].style.backgroundColor == ('linen')){
			newseatmapstring += "1";
		}else if(seats[i].style.backgroundColor == ('black')){
			newseatmapstring += "3";
		}else if(seats[i].style.backgroundColor == ('white')){
			newseatmapstring += "0";
		}
		
		if(k==i){
			newseatmapstring += "2";
			k += i;
			
		}
		
		
	}
	
	document.getElementById("newseatmapstring").value = newseatmapstring;
	console.log(document.getElementById("newseatmapstring"));
	
}

function calculateTotal(id) {

	var ticketCount = 0;

	// temporary price
	var ticketPrice = 5;

	var seats = document.getElementsByClassName("chooseseatbutton");
	var total = 0;
	for (var i = 0; i < seats.length; i++) {

		if (seats[i].style.backgroundColor == ('lightseagreen')) {
			total += ticketPrice;
			ticketCount++;
		}
	}
	document.getElementById("counter").innerHTML = ticketCount;
	document.getElementById("total").innerHTML = total + "€";
}

function doBuy(){
	var x = document.getElementsByClassName("CHT");
	var str = "";
	for(var i = 0; i<x.length ; i++){
		str += (i+1) + ". " + x[i].innerHTML + "\n";
	}
	if(confirm("Do you really want to buy these tickets? \n" + str)){
		document.getElementById("buyForm").submit();
	}else{
		
	}
		
}