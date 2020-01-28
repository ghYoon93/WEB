function checkWriteForm() {
    let sId = document.writeForm.id.value;
    let sName = document.writeForm.name.value;
    let sPwd = document.writeForm.password.value;
    let sRepwd = document.writeForm.repw.value;
    checkId(sId);
    checkName(sName);
    checkPwd(sPwd);
    checkPwdEquals(sPwd, sRepwd);
	
    window.open(""
			  ,"viewer"
			  ,"width=300 height=100 left=500 top=100");
	document.writeForm.target = "viewer";
    document.writeForm.submit();
	
}

function checkPost(){
	 new daum.Postcode({
         oncomplete: function(data) {
             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

             // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
             var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수

             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                 extraRoadAddr += data.bname;
             }
             // 건물명이 있고, 공동주택일 경우 추가한다.
             if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
             }
             // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
             if(extraRoadAddr !== ''){
                 extraRoadAddr = ' (' + extraRoadAddr + ')';
             }

             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('zipcode').value = data.zonecode;
             document.getElementById("addr1").value = roadAddr;
             document.getElementById("addr2").value = data.jibunAddress;
             

             var guideTextBox = document.getElementById("guide");
             // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
             if(data.autoRoadAddress) {
                 var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                 guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                 guideTextBox.style.display = 'block';

             } else if(data.autoJibunAddress) {
                 var expJibunAddr = data.autoJibunAddress;
                 guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                 guideTextBox.style.display = 'block';
             } else {
                 guideTextBox.innerHTML = '';
                 guideTextBox.style.display = 'none';
             }
         }
     }).open();
}

function checkId(){
	let sId = document.writeForm.id.value;
	if(sId=="") {
		alert("아이디를 먼저 입력해주세요.");
	} else{
		  window.open("http://localhost:8080/memberServlet/checkIdServlet?id="+sId
				  ,""
				  ,"width=300 height=100 left=500 top=100");
	  }
			
}
function checkId(sId){
	if(sId=="") {
		alert("아이디를 입력하지 않았습니다.");
		location.history(0);
	}
}
function checkPw(sPw){
	if(sPw=="") {
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
	if(sPw != sRepw){
		alert("비밀번호가 맞지않습니다.");
		location.history(0);
	}
}

function login(){
	let sId = document.loginForm.id.value;
	let sPw = document.loginForm.password.value;
	checkId(sId);
	checkPw(sPw);
//	document.loginForm.submit();
	window.open(""
			  ,"viewer"
			  ,"width=300 height=100 left=500 top=100");
	document.loginForm.target = "viewer";
	document.loginForm.submit();
}

function signIn(){
	
}