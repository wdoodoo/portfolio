<%@page import="net.minidev.json.JSONArray"%>
<%@page import="test.JsonUtil"%>
<%@page import="net.minidev.json.JSONObject"%>
<%@page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
PreparedStatement stmt = null;//class의 초기값은 null , 안에서만 쓰는게 지역변수 , 바깥에서 공통으로 사용가능한게 전역변수.
//Statement stmt = null;
ResultSet rs = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");//try안에 선언한건 지역변수들 , 외부사용시 괄호밖으로 전역변수로 만들어줘라.
	String jdbcurl = "jdbc:oracle:thin:@localhost:1521:orcl";
	conn = DriverManager.getConnection(jdbcurl,"scott","tiger");

	StringBuffer sql = new StringBuffer().append("select * from emp"); //null값이 아니면 1번을 넣어줘라.
		
	stmt = conn.prepareStatement(sql.toString()); //sql + .tostring = stringbuffer를 넣어준다

	rs = stmt.executeQuery();
	
	JSONArray jarray=new JSONArray();
	JSONObject jmain = new JSONObject();
	
	while(rs.next()) {
		Map<String, Object> map = new HashMap<>();
		map.put("empno", rs.getInt("empno"));
		map.put("ename", rs.getString("ename"));
		map.put("job", rs.getString("job"));
		map.put("hiredate", rs.getString("hiredate"));
		
		JSONObject jobj = JsonUtil.getJsonStringFromMap(map);
		jarray.add(jobj);
		
		System.out.println(jobj);
		
	}
	
	jmain.put("Resultset", jarray);
	jmain.put("SQL", sql.toString());
	%>

	<%=jmain %>
	<br>

	<%
		
	System.out.println(jmain);
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	try {
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
		if(conn != null)conn.close();
	} catch (Exception e) {
		
	}
	
}

%>
</body>
</html>