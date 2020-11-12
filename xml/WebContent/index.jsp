<%@page import="java.util.List"%>
<%@page import="test.XmlParsingVO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.XmlParsing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
XmlParsing xml = new XmlParsing();
List<XmlParsingVO> al = xml.xmlParse();
Iterator<XmlParsingVO> it = al.iterator();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
while(it.hasNext()){
	out.print("#########################" + "<br>");
	XmlParsingVO s = it.next();
	out.print("금융사  : " + s.getKor_co_nm() + "<br>");
	out.print("상품 코드  : " + s.getFin_prdt_cd() + "<br>");
	out.print("상품명 : " + s.getFin_prdt_nm() + "<br>");
	out.print("연평균 수익률  : " + s.getAvg_prft_rate() + "<br>");
	out.print("공시 이율  : " + s.getDcls_rate() + "<br>");
	
	
}
%>
</body>
</html>