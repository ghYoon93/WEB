function checkWriteForm() {
	var sName = document.writeForm.name.value;
	var sId = document.writeForm.id.value;
	var sPwd = document.writeForm.password.value;
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
		document.writeForm.password.focus();
	}else if(isValueNotEqual(sPwd, sRepwd)){
		alert("비밀번호를 재확인해주세요.");
		document.writeForm.rePwd.focus();
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
	var sPwd = document.loginForm.password.value;
	if(isValueEmpty(sId)){
		alert("아이디를 입력해주세요.");
		document.loginForm.id.focus();
	}else if(isValueEmpty(sPwd)){
		alert("비밀번호를 입력해주세요.")
		document.loginForm.password.focus();
	} else{
		window.open(""
				, "viewer"
				, "width=300 height=100 left=500 top=100");
		document.loginForm.target = "viewer";
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

function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.availableId.value = id;
	opener.writeForm.password.focus();
	window.close();
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