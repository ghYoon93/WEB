
function isLogin(id, seq, pg) {
    if(id == '') {
        alert("로그인을 해주세요.");
    }else{
        location.href="imageboardView.do?seq="+seq+"&pg="+pg;
    }
}
function checkAll(){
    if($('#checkAll').is(':checked')){
	    $('input[name=checkItem]').prop("checked", true);
	}else{
	    $('input[name=checkItem]').prop("checked", false);
    }
}

$('#deleteBtn').click(function(){
	var checkList="";
	$('input[name=checkItem]:checked').each(function(){
		checkList = checkList + $(this).val()+",";
	});
	checkList = checkList.substring(0,checkList.lastIndexOf(','));
	if(confirm("정말 삭제하시겠습니까?")){
		var pg = $('input[name=pg]').val();
		location.href='../imageboard/imageboardDelete.do?seq='+checkList+'&pg='+pg;
	}
});