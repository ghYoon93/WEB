function checkWriteForm() {
	var sName = document.writeForm.name.value;
	var sId = document.writeForm.id.value;
	var sPwd = document.writeForm.pwd.value;
	var sRepwd = document.writeForm.repwd.value;
	var sAvailableId = document.writeForm.availableId.value;

	if(isValueEmpty(sName)){
		alert("이름을 입력해주세요.");
		document.writeForm.name.focus();
	}else if(isValueEmpty(sId)){
		alert("아이디를 입력해주세요.");
		document.writeForm.id.focus();
	}else if(isValueEmpty(sPwd)){
		alert("비밀번호를 입력해주세요.");
		document.writeForm.pwd.focus();
	}else if(isValueNotEqual(sPwd, sRepwd)){
		alert("비밀번호를 재확인해주세요.");
		document.writeForm.repwd.focus();
	}else if(isValueNotEqual(sId, sAvailableId)){
		alert("아이디 중복확인을 해주세요.");
	}else{
		window.open("", "viewer", "width=300 height=100 left=500 top=100");
		document.writeForm.target="viewer";
		document.writeForm.submit();
	}

}
function login() {
	var sId = document.loginForm.id.value;
	var sPwd = document.loginForm.pwd.value;
	if(isValueEmpty(sId)){
		alert("아이디를 입력해주세요.");
		document.loginForm.id.focus();
	}else if(isValueEmpty(sPwd)){
		alert("비밀번호를 입력해주세요.")
		document.loginForm.pwd.focus();
	} else{
//		window.open(""
//				, "viewer"
//				, "width=300 height=100 left=500 top=100");
//		document.loginForm.target = "viewer";
		document.loginForm.submit();

	}
}
function isValueEmpty(value){
	if(value=="") return true;
	return false;
}
function isValueNotEqual(value1, value2){
	if(value1!=value2) return true;
	return false;
}

function checkId(){
	var sId = document.writeForm.id.value;
	if(isValueEmpty(sId)){
		alert("아이디를 먼저 입력해주세요.");
	} else{
		window.open("http://localhost:8080/memberJSP/member/checkId.jsp?id="+sId
				  , ""
				  , "width=300 height=100 left=500 top=100");
	}
}
function setAttr(gender, email2, tel1){
	window.resizeTo(500,480);
	document.getElementById(gender).checked = true;
	document.modifyForm.email2.value = email2;
	document.modifyForm.tel1.value = tel1;


}

function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.availableId.value = id;
	opener.writeForm.pwd.focus();
	window.close();
}
function checkModifyForm(){
	var sName = document.modifyForm.name.value;
	var sPwd = document.modifyForm.pwd.value;
	var sRepwd = document.modifyForm.repwd.value;

	if(isValueEmpty(sName)){
		alert("이름을 입력해주세요.");
		document.modifyForm.name.focus();
	}else if(isValueEmpty(sPwd)){
		alert("비밀번호를 입력해주세요.");
		document.modifyForm.pwd.focus();
	}else if(isValueNotEqual(sPwd, sRepwd)){
		alert("비밀번호를 재확인해주세요.");
		document.modifyForm.repwd.focus();
	}else{
		document.modifyForm.submit();
	}
}
function checkPost(){
    window.open("checkPost.jsp","","width=410 height=400");
}
function closeCheckPost(zipcode, addr1){
	var form = opener.document.forms[0];
	form.zipcode.value = zipcode;
	form.addr1.value = addr1;
	window.close();
	form.addr2.focus();
}

function checkBoardWriteForm(){
	if(document.boardWriteForm.subject.value==""){
		alert("제목을 입력해주세요.");
		document.boardWriteForm.subject.focus();
	}else if(document.boardWriteForm.content.value==""){
		alert("내용을 입력해주세요.");
		document.boardWriteForm.content.focus();
	}else{
		document.boardWriteForm.submit();		
	}
}
