/**
 * 
 */
function getXMLHttpRequest(){
	return new XMLHttpRequest();
}
let xhr = null;
function sendRequest(url, params, callback, method){
	xhr = getXMLHttpRequest();
	var xhMethod = method?method:'GET';
	if(xhMethod != 'GET' && xhMethod!='POST'){
		xhMethod = 'GET';
	}
	var xhParams = (params == null || params == '')? null:params;
	var xhUrl = url;
	if(xhMethod == 'GET' && xhParams != null) {
		xhUrl = xhUrl+"?"+xhParams;
	}
	xhr.open(xhMethod, xhUrl, true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.onreadystatechange = callback;
	xhr.send(xhMethod=='POST'?xhParams:null);
}
   	
     