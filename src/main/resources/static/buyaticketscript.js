function stringToView(str){
	
	var auditoriumDiv = document.getElementById("stringauditorium");
	var j= 1;
	var k = 0;
	for(var i = 1; i<str.length ; i++){
		console.log(str[i]);
		k++;
		var seat = document.createElement("input");
		seat.setAttribute("id","R"+j+"C"+k);
		seat.setAttribute("type","button");
		seat.setAttribute("onclick", "changeSeatButton(this.id)");
		
		if(str[i]==1){
			seat.setAttribute("style","background-color:white; width: 50px; height: 50px; border-radius: 25px;");
			seat.setAttribute("value","R"+j+"C"+k);
			auditoriumDiv.appendChild(seat);
		}else if(str[i]==0){
			seat.setAttribute("style","display:none;  width: 50px; height: 50px;");
			auditoriumDiv.appendChild(seat);
		}else if(str[i]==2){
			auditoriumDiv.appendChild(document.createElement("br"));
			k=0;
			j++;
		}else{
			seat.setAttribute("style","background-color:black; width: 50px; height: 50px; border-radius: 25px;");
			seat.disabled = true;
			auditoriumDiv.appendChild(seat);
		}
	}
	
	
	
}