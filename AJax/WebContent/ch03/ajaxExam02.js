var xhr;
var sw = 0;
function startMethod(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = resultProcess;
	xhr.open("GET","ajaxExam02.xml",true);
	xhr.send(null);
}
function remove(){
	//크롬에서는 trChild.length가 하나 지울때마다 다시 계산을 해서 index의 값이 바뀐다.
	//그래서 거꾸로 돌리면 된다.
	let trChild = document.getElementById("resultDisplay").childNodes;
	for(let i = trChild.length-1; i >= 0; i--){
		trChild[i].remove();
	}
	sw = 0;
}
function resultProcess(){
	if(xhr.readyState == 4){
		if(xhr.status == 200){
			processXML();
		}
	}
}
function processXML(){
	
	let xmlDoc = xhr.responseXML;
	let trTag = "";
	let tdTag = "";
	if(sw==0){
		let subjects = xmlDoc.getElementsByTagName("subject");
		for(let i=0; i<subjects.length; i++){
			trTag = document.createElement("tr");
			
			let childs = subjects[i].childNodes;
			for(let j=0; j < childs.length; j++){
				if(childs[j].firstChild!=null){
					tdTag = document.createElement("td");
					tdTag.appendChild(childs[j].firstChild);
					trTag.appendChild(tdTag);
				}
			} // for }
			document.getElementById("resultDisplay").appendChild(trTag);
		}
	}
	sw = 1;
}
