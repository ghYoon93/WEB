
function isLogin(id, seq, pg) {
    if(id == '') {
        alert("로그인을 해주세요.");
    }else{
        location.href="imageboardView.do?seq="+seq+"&pg="+pg;
    }
}
function checkAll(){
//    if($('#checkAll').is(':checked')){
//	    $('input[name=checkItem]').prop("checked", true);
//	}else{
//	    $('input[name=checkItem]').prop("checked", false);
//    }
	// alert(document.getElementById("all").checked); == $('#checkAll').is(':checked')
	// document.getElementsByName("check").length; // Tag name이 check인 요소"들"의 개수
	let check = document.getElementsByName("check");
	if(document.getElementById("all").checked){
		for(i = 0; i<check.length; i++){
			check[i].checked = true;
		}
	}else{
		for(i = 0; i < check.length; i++){
			check[i].checked = false;
		}
	}
}

function choiceDelete(){
	let check = document.getElementsByName("check");
	let count = 0;
	for(i = 0; i<check.lengh; i++){
		if(check[i].checked) count++;
	}
	if(count==0)
		alert("항목을 선택하세요");
	else
		if(confirm("정말로 삭제하시겠습니까?")){
			document.submit();
		}
}

//$('#deleteBtn').click(function(){
//	var checkList="";
//	$('input[name=checkItem]:checked').each(function(){
//		checkList = checkList + $(this).val()+",";
//	});
//	checkList = checkList.substring(0,checkList.lastIndexOf(','));
//	if(confirm("정말 삭제하시겠습니까?")){
//		var pg = $('input[name=pg]').val();
//		location.href='../imageboard/imageboardDelete.do?seq='+checkList+'&pg='+pg;
//	}
//});