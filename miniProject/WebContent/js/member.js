//function checkWriteForm(){
	//유효성 체크
//	if(document.writeForm.name.value=="")
//		alert("이름을 입력하세요");
//	else if(document.writeForm.id.value=="")
//		alert("아이디를 입력하세요");
	//else if(document.writeForm.pwd.value=="")
//	else if(document.getElementById("pwd").value=="")	
//		alert("비밀번호를 입력하세요");
//	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
//		alert("비밀번호가 맞지 않습니다");
//	else if(document.writeForm.id.value != document.writeForm.check.value)
//		alert("중복체크 하세요");
//	else
//		document.writeForm.submit();
//}
$('#writeFormBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	if($('#name').val()==''){
		$('#nameDiv').text('이름을 입력하세요');
		$('#nameDiv').css('color','red')
		$('#nameDiv').css('font-size','8pt')
		$('#nameDiv').css('font-weight','bold')
	} else if($('#loginId').val()==''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('color','red')
		$('#idDiv').css('font-size','8pt')
		$('#idDiv').css('font-weight','bold')
	} else if($('#loginPwd').val()==''){
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwdDiv').css('color','red')
		$('#pwdDiv').css('font-size','8pt')
		$('#pwdDiv').css('font-weight','bold')
	} else if($('#loginRepwd').val()==''){
		$('#repwdDiv').text('비밀번호를 재확인 하세요.');
		$('#repwdDiv').css('color','red')
		$('#repwdDiv').css('font-size','8pt')
		$('#repwdDiv').css('font-weight','bold')
	} else{
		$('form[name=writeForm]').submit();
	}
});

function checkId(){
	let sId = document.writeForm.id.value;
	if(sId=="") 
		alert("먼저 아이디를 입력하세요");
	else
		window.open("checkId.do?id="+sId, "", "width=600 height=200 left=500 top=100");
}

function checkIdClose(id){
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();	
}

//function checkLoginForm(){
//	if(document.loginForm.id.value=="")
//		alert("아이디를 입력하세요");
//	else if(document.loginForm.pwd.value=="")	
//		alert("비밀번호를 입력하세요");
//	else
//		document.loginForm.submit();
//}

$('#loginFormBtn').click(function(){
	$('#nameDiv').empty();
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	if($('#loginId').val()==''){
		$('#loginIdDiv').text('아이디를 입력하세요')
		                .css('color','red')
		                .css('font-size','8pt')
		                .css('font-weight','bold');
	} else if($('#loginPwd').val()==''){
		$('#loginPwdDiv').text('비밀번호를 입력하세요')
                         .css('color','red')
                         .css('font-size','8pt')
                         .css('font-weight','bold');
	}  else{
		$('form[name=loginForm]').submit();
	}
});

function checkPost(){
	window.open("checkPost.do","","width=400 height=400 scrollbars=yes");
}

function checkModifyForm(){
	//유효성 체크
	if(document.modifyForm.name.value=="")
		alert("이름을 입력하세요");
	else if(document.getElementById("pwd").value=="")	
		alert("비밀번호를 입력하세요");
	else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value)
		alert("비밀번호가 맞지 않습니다");
	else
		document.modifyForm.submit();
}



















