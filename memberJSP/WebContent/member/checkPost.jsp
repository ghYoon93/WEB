<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.dao.PostDAO" %>
<%@ page import = "member.bean.PostDTO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%
  request.setCharacterEncoding("UTF-8");
  String sido = request.getParameter("sido");
  String sigungu = request.getParameter("sigungu");
  String roadname = request.getParameter("roadname");
  PostDAO postDAO = PostDAO.getInstance();
  List<PostDTO> list = new ArrayList<PostDTO>();
  if(sido != null){
      if(sido!=""&&roadname!=""){
      list = postDAO.select(sido, sigungu, roadname);          
      }
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/member.css">
  </head>
  <body>
    <form action="checkPost.jsp" method="get">
    <table border="1" width="100%" cellspacing="0" cellpadding="3">
      <tr>
          <td class=label>시도</td>
          <td>
            <select name="sido">
              <option value="">시/도 선택</option>
              <option value="서울">서울</option>
              <option value="인천">인천</option>
              <option value="대전">대전</option>
              <option value="대구">대구</option>
              <option value="울산">울산</option>
              <option value="세종">세종</option>
              <option value="광주">광주</option>
              <option value="경기">경기</option>
              <option value="강원">강원</option>
              <option value="전남">전남</option>
              <option value="전북">전북</option>
              <option value="충남">충남</option>
              <option value="충북">충북</option>
              <option value="부산">부산</option>
              <option value="제주">제주</option>
              
            </select>
          </td>
          <td class=label>시.군.구</td>
          <td><input type="text" name="sigungu"/></td>
        </tr>
        <tr>
          <td class=label>도로명</td>
          <td colspan="3">
            <input type="text" name="roadname"/>
            <input type="submit" value="검색"/>
          </td>
        </tr>
        <tr>
          <td class=label>우편번호</td>
          <td class=label colspan="3">주소</td>
        </tr>
          <%if(list != null){
              for(PostDTO postDTO : list){
                  String zipcode = postDTO.getZipcode();
                  String addr1 = postDTO.getSido()+" "
                                +postDTO.getSigungu()+" "
                                +postDTO.getYubmyundong()+" "
                                +postDTO.getRi()+" "
                                +postDTO.getRoadname()+" "
                                +postDTO.getBuildingname();
          %>
          <tr>
          <td class=label><a class="addressA" href="javascript:closeCheckPost('<%=zipcode%>', '<%=addr1%>');"><%=zipcode%></a></td>
          <td colspan = "3"><%= addr1%></td>
          </tr>
          <%}
          }
          %>
      </table>
    </form>    
  </body>
  <script type = "text/javascript" src="../js/member.js"></script>
</html>