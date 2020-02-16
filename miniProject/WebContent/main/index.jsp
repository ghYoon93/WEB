<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <style type="text/css">
            body{margin:0px;}
            .mainTable{height:100%; width:100%; position:absolute; top:0px; bottom:0px; left:0px; right:0px; border:1px solid;}
            .lnb{vertical-align: top;}
            .contentArea{vertical-align: top;}
        </style>
    </head>
    <body>
        <table class="mainTable" cellpadding="3" cellspacing="0" border="1">
            <tr style="height:15%">
                <td colspan="2" align="center"><jsp:include page="../template/top.jsp"/></td>
            </tr>
            <tr style="height:70%">
                <td class="lnb" style="width:20%"><jsp:include page="../template/left.jsp"/></td>
                <td class="contentArea" style="width:80%" align="center"><jsp:include page="${display }"/></td>
            </tr>
            <tr style="height:15%">
                <td colspan="2" align="center"><jsp:include page="../template/bottom.jsp"/></td>
            </tr>

        </table>
    </body>
</html>