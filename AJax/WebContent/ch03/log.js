function log(msg){
	let console = document.getElementById("debugConsole");
	if(console!=null){
		console.innerHTML += msg+"<br>";
	}
}