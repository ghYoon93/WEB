<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
      .key{text-align:center;}
      textarea{overflow-y: scroll;}
      .errorDiv{display: inline-block;}
</style>
<form name="imageboardWriteForm" enctype="multipart/form-data" method="post" action="imageboardWrite.do">
<table border="1" cellpadding="3" cellspacing="0">
    <tr>
        <td width="70" align="center">상품코드</td>
        <td>
            <input type="text" id="imageId" value="img_" name="imageId" size="30">
            <div id = "imageIdDiv" class="errorDiv"></div>
        </td>
    </tr>
    
    <tr>
        <td width="70" align="center">상품명</td>
        <td>
            <input id="imageName" type="text" placeholder="상품명 입력" name="imageName"  size="30">
            <div id = "imageNameDiv" class="errorDiv"></div>
        </td>
    </tr>
    
    <tr>
        <td width="70" align="center">단가</td>
        <td>
            <input id="imagePrice" type="text" placeholder="단가 입력" name="imagePrice" size="30">
            <div id = "imagePriceDiv" class="errorDiv"></div>
            
        </td>
    </tr>
    
    <tr>
        <td width="70" align="center">개수</td>
        <td>
            <input id="imageQty" type="text" placeholder="개수 입력" name="imageQty" size="30">
            <div id = "imageQtyDiv" class="errorDiv"></div>
        </td>
    </tr>
    
    <tr>
        <td align="center" width="70">내용</td>
        <td>
            <textarea id="imageContent" placeholder="내용을 입력" name="imageContent" rows="15" cols="50"></textarea>
            <div id="imageContentDiv" class="errorDiv"></div>
        </td>
    </tr>
    
    <tr>
    <td colspan="2">
      <input id="image1" type="file" name="image1" size="50">
      <div id = "image1Div" class="errorDiv"></div>
    </td>
  </tr>
  
  <tr>
    <td colspan="2" align="center">
      <input type="button" id="imageboardFormBtn" value="이미지 등록">
      <input type="reset" value="다시작성">
  </tr>
</table>
</form>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type = "text/javascript" src="../js/member.js"></script>







