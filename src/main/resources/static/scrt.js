function seatCheckBox(id) {

	// <div> elements kura likt sarakstu ar izveletajam sedvietam
	var checkedSeats = document.getElementById("chosenseats");

	// checkbox uz kuru tika nospiests
	var seat = document.getElementById(id);

	if (seat.checked == false) {
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
		var node = document.createTextNode(id);
		para.appendChild(node);

		checkedSeats.appendChild(para);
	}

	calculateTotal();

}

// sum total money
function calculateTotal() {

	var ticketCount = 0;

	// temporary price
	var ticketPrice = 5;

	var seats = document.getElementsByClassName("seatcheckbox");
	var total = 0;
	for (var i = 0; i < seats.length; i++) {
		if (seats[i].checked) {
			total += ticketPrice;
			ticketCount++;
		}
	}
	document.getElementById("counter").innerHTML = ticketCount;
	document.getElementById("total").innerHTML = total + "€";
}


/*/
 * iegust admin ievaditas vertibas par rindam un kolonnam
 * un ar "button" elementiem tiek uzzimeta auditorija
 */
function createAuditorium() {
	var auditorium = document.getElementById("auditorium");
	var tmp = document.getElementById("rows");
	if (tmp == null) {

		document.getElementById("message").innerHTML = "<h3>Create custom shape auditorium: click on the seat to remove/add it to the auditorium</h3>"
				+ "<h4 style='color: red'>ONLY SEATS WITH THE COLOUR GREEN WILL BE ADDED TO THE AUDITORIUM</h4>";
		
		var rows = document.getElementById("rowsInput").value;
		var columns = document.getElementById("columnsInput").value;

		// <div> elements

		var olrows = document.createElement("ol");
		olrows.setAttribute("id", "rows");
		olrows.setAttribute("class", "seats");

		for (var i = 0; i < columns; i++) {
			var olseats = document.createElement("ol");
			olseats.setAttribute("id", "seats");
			olseats.setAttribute("class", "rows");
			olseats.setAttribute("type", "A");

			for (var j = 0; j < rows; j++) {
				var listEl = document.createElement("li");
				listEl.setAttribute("class", "seat");

				var chB = document.createElement("input");
				chB.setAttribute("type", "button");
				chB.setAttribute("id", "R" + (j + 1) + "C" + (i + 1));
				chB.setAttribute(
								"style",
								"background-color:lightseagreen; width: 30px; height: 30px; border-radius: 15px;");
				chB.setAttribute("onclick", "changeSeatButton(this.id)");
				listEl.appendChild(chB);
				olseats.appendChild(listEl);

			}
			olrows.appendChild(olseats);
		}

		auditorium.appendChild(olrows);

	} else {
		tmp.parentNode.removeChild(tmp);
		createAuditorium();
	}

	var addColumnButton = document.createElement("input");
	addColumnButton.setAttribute("type", "button");
	addColumnButton.setAttribute("value", "Add Column");

	var addRowButton = document.createElement("input");
	addRowButton.setAttribute("type", "button");
	addRowButton.setAttribute("value", "Add Row");

	// auditorium.appendChild(addRowButton);
	// auditorium.appendChild(addColumnButton);

}
/*
 * function addColumn(){
 *  }
 * 
 * function addRow(){
 *  }
 */




/*/
 * maina pogas krasu starp baltu/zilu kas norada vai vieta eksiste/neeksiste
 */
function changeSeatButton(id) {
	var b = document.getElementById(id);

	b.style.backgroundColor = (b.style.backgroundColor == ('lightseagreen')) ? 'white':'lightseagreen';
}

/*/
 * no skata ar visam "button" tiek izveidots string objekts kur katrs simbols apzime vietu
 * ja vieta balta tad vieta neeksiste (0)
 * ja zala tad vieta eksiste (1)
 * 
 * 2 - rindas beigas
 */
function submitAuditorium() {
	//var array = [];
	var seatmapstring="";
	var rows = document.getElementById("rowsInput").value;
	var columns = document.getElementById("columnsInput").value;
	var id;
	var button;
	for(var i = 1; i<=rows; i++){
		for(var j = 1; j<=columns; j++){
			id = "R"+i+"C"+j;
			
			button = document.getElementById(id);
			if(button.style.backgroundColor == ('white')){
				//array.push(0);
				seatmapstring+="0";
			}else{
				seatmapstring+="1";
				//array.push(1);
			}
		}
		seatmapstring+="2";
		//array.push(2);
	}
	
	
	console.log(seatmapstring);

}
