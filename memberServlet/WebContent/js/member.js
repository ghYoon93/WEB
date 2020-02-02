function checkWriteForm() {
  var sName = document.writeForm.name.value;
  checkName(sName);
  var sId = document.writeForm.id.value;
  checkId(sId);
  var sPwd = document.writeForm.password.value;
  checkPwd(sPwd);
  var sRepwd = document.writeForm.repwd.value;
  var sAvailableId = document.writeForm.availableId.value;
  checkPwdEquals(sPwd, sRepwd);
  checkIdEquals(sId, sAvailableId);
  window.open(""
			       ,"viewer"
			       ,"width=300 height=100 left=500 top=100");
  document.writeForm.target = "viewer";
  document.writeForm.submit();

}
function login(){
	var sId = document.loginForm.id.value;
	var sPwd = document.loginForm.password.value;
	checkId(sId);
	checkPwd(sPwd);
	window.open(""
			  ,"viewer"
			  ,"width=300 height=100 left=500 top=100");
	document.loginForm.target = "viewer";
	document.loginForm.submit();
}

function checkIdClose(id){
	opener.writeForm.id.value=id;
	opener.writeForm.availableId.value=id;
	opener.writeForm.password.focus();
	window.close();
}

function checkDuplication(){
	var sId = document.writeForm.id.value;
	if(sId=="") {
		alert("아이디를 먼저 입력해주세요.");
	} else{
		  window.open("http://localhost:8080/memberServlet/checkIdServlet?id="+sId
				  ,""
				  ,"width=300 height=100 left=500 top=100");
	  }
}

function idChecked(){
	idChecked = true;
}

function checkId(sId){
	if(sId=="") {
		alert("아이디를 입력하지 않았습니다.");
		location.history(0);
	}
}
function checkPwd(sPwd){
	if(sPwd=="") {
		alert("비밀번호를 입력하지 않았습니다.");
		location.history(0);
	}
}
function checkName(sName){
	if(sName==""){
		alert("이름을 입력하지 않았습니다.");
		location.history(0);
	}
}

function checkPwdEquals(sPwd, sRepwd) {
	if(sPwd != sRepwd){
		alert("비밀번호가 맞지않습니다.");
		location.history(0);
	}
}

function checkIdEquals(sAvailableId, sId) {
	if(sAvailableId != sId){
		alert("아이디 중복 확인을 하지 않았습니다.");
		location.history(0);
	}
}



function checkPost(){
	 new daum.Postcode({
         oncomplete: function(data) {
             var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수
             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                 extraRoadAddr += data.bname;
             }
             if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
             }
             if(extraRoadAddr !== ''){
                 extraRoadAddr = ' (' + extraRoadAddr + ')';
             }
             document.getElementById('zipcode').value = data.zonecode;
             document.getElementById("addr1").value = roadAddr;
             document.getElementById("addr2").value = data.jibunAddress;
         }
     }).open();
}
