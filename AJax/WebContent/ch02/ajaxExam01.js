var xhr = null;
function startMethod(){
    xhr = new XMLHttpRequest();
    xhr.onreadystatechange = resultProcess;
    xhr.open("GET", "ajaxExam01.xml", true);
    xhr.send(null);
}

function resultProcess(){
	if(xhr.readyState == 4){
		if(xhr.status == 200){
			let displayArea = document.getElementById("displayArea");
			displayArea.innerHTML = xhr.responseText;
//			displayArea.style.style.display = "block";
			if(displayArea.style.visibility == "hidden"){
				displayArea.style.visibility = "visible";				
			}else{
				displayArea.style.visibility = "hidden";
			}
		}
	}
}