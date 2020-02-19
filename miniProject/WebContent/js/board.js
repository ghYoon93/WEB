$('#boardFormBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	if($('#subject').val()==''){
		$('#subjectDiv').text('제목을 입력하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	} else if($('#content').val()==''){
		$('#contentDiv').text('내용을 입력하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	} else{
		document.forms[0].submit();
	}
});

//check imageboardForm
$('#imageboardFormBtn').click(function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imagePriceDiv').empty();
	$('#imageQtyDiv').empty();
	$('#contentDiv').empty();
	$('#image1Div').empty();
	
	if($('#imageId').val()=='img_'){
		$('#imageIdDiv').text('상품코드를 입력하세요')
		                .css('color','red')
		                .css('font-size','8pt')
		                .css('font-weight','bold');
	} else if($('#imageName').val()==''){
		$('#imageNameDiv').text('상품명을 입력하세요')
                         .css('color','red')
                         .css('font-size','8pt')
                         .css('font-weight','bold');
	}else if($('#imagePrice').val()==''){
		$('#imagePriceDiv').text('단가를 입력하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	}else if($('#imageQty').val()==''){
		$('#imageQtyDiv').text('개수를 입력하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	}else if($('#imageContent').val()==''){
		$('#imageContentDiv').text('내용을 입력하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	}else if($('#image1').val()==''){
		$('#image1Div').text('파일을 첨부하세요')
        .css('color','red')
        .css('font-size','8pt')
        .css('font-weight','bold');
	}  else{
		$('form[name=imageboardWriteForm]').submit();
	}
});