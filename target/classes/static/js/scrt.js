

/*
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
*/



/*/
 * iegust admin ievaditas vertibas par rindam un kolonnam
 * un ar "button" elementiem tiek uzzimeta auditorija
 */
function createAuditorium() {
	var auditorium = document.getElementById("auditorium");
	var tmp = document.getElementById("rows");
	if (tmp == null) {

		document.getElementById("message").innerHTML = "<h3>Create custom shape auditorium: click on the seat to remove/add it to the auditorium</h3>"
				+ "<h5 style='color: red'>ONLY SEATS WITH THE COLOUR GREEN WILL BE ADDED TO THE AUDITORIUM</h5>";
		
		var rows = document.getElementById("rowsInput").value;
		var columns = document.getElementById("columnsInput").value;

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
				chB.setAttribute("value", "R" + (j + 1) + "C" + (i + 1));
				chB.setAttribute(
								"style",
								"background-color:lightseagreen; width: 50px; height: 50px; border-radius: 25px;");
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

	
	document.getElementById("addrowbutton").style.display = "inline";
	document.getElementById("addcolumnbutton").style.display = "inline";
	document.getElementById("submitauditoriumbutton").style.display = "block";

}

function addColumn(){
	  document.getElementById("columnsInput").value+=1;
		
	 var seatmap = document.getElementById("rows");
	 if(seatmap == null){
		 document.createElement("ol");
		 column.setAttribute("id", "rows");
		 column.setAttribute("class", "seats");
	 }
	 
	 var column = document.createElement("ol");
	 column.setAttribute("id", "seats");
	 column.setAttribute("class", "rows");
	 var columnCount = document.getElementsByClassName("rows").length;
	 var j = document.getElementsByClassName("seat").length/columnCount;
	 
	 for(var i = 0; i < j; i++){
		 var listEl = document.createElement("li");
			listEl.setAttribute("class", "seat");

			var chB = document.createElement("input");
			chB.setAttribute("type", "button");
			chB.setAttribute("value", "R" + (i + 1) + "C" + (columnCount+1));
			chB.setAttribute("id", "R" + (i + 1) + "C" + (columnCount+1));
			chB.setAttribute(
							"style",
							"background-color:lightseagreen; width: 50px; height: 50px; border-radius: 25px;");
			chB.setAttribute("onclick", "changeSeatButton(this.id)");
			listEl.appendChild(chB);
			column.appendChild(listEl);
	 }
	 seatmap.appendChild(column);
	 
 }
 
 
 
 function addRow(){
	 document.getElementById("rowsInput").value+=1;
	 var columns = document.getElementsByClassName("rows");
	 var j = (document.getElementsByClassName("seat").length / columns.length) + 1;
	 console.log(j);
	 for(var i = 0 ; i<columns.length; i++){
		 var listEl = document.createElement("li");
			listEl.setAttribute("class", "seat");

			var chB = document.createElement("input");
			chB.setAttribute("type", "button");
			chB.setAttribute("id", "R" + (j) + "C" + (i+1));
			chB.setAttribute("value", "R" + (j) + "C" + (i+1));
			chB.setAttribute(
							"style",
							"background-color:lightseagreen; width: 50px; height: 50px; border-radius: 25px;");
			chB.setAttribute("onclick", "changeSeatButton(this.id)");
			listEl.appendChild(chB);
		 columns[i].appendChild(listEl);
	 }
 
 }
 




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
	var rows = document.getElementsByClassName("rows").length;
	var columns = document.getElementsByClassName("seat").length/rows;
	console.log("rowcount: " + rows);
	console.log("column count: " + columns);
	
	var id;
	var button;
	for(var i = 1; i<=columns; i++){
		for(var j = 1; j<=rows; j++){
			id = "R"+i+"C"+j;
			
			button = document.getElementById(id);
			if(button.style.backgroundColor != ('white')){
				seatmapstring+="1";
			}else{
				seatmapstring+="0";
			}
		}
		seatmapstring+="2";
	}
	
	document.getElementById("seatmapstring").value = seatmapstring;
	console.log(seatmapstring);

}

function getCinemaID(){
	console.log("called");
	var url_string = window.location.href;
	var url = new URL(url_string);
	document.getElementById("cinemaid").value = url.searchParams.get("cinemaId");
}
