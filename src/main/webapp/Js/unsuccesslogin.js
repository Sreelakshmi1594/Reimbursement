/**
 * 
 */
 window.onload = function(){
 console.log("window is loading");
 getRegDetails();
 }
 
 function getRegDetails(){
 
 	let xhttp = new XMLHttpRequest();
 	xhttp.onreadystatechange = function(){
 		if(xhttp.readyState==4 && xhttp.status == 200){
			let empobj = JSON.parse(xhttp.responseText);
			console.log(empobj);
			document.getElementById("Registration").innerText=`Successfully Registered ${empobj.firstname}`;
		}
 		
 	}
 		xhttp.open('GET', "http://localhost:8080/Reimbursement/RegisteringEmployee.json");
 		xhttp.send();
 
 }