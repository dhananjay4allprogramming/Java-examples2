<%@page import="com.JDBCstrutsCRUD.Mybean"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*;" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrive</title>
<script type="text/javascript">
	function deleteRecord(){
		document.fom.action="del.action";
		document.fom.submit();
	}
	function editr(val) {
		document.fom.action="saveLink.action?fid="+val;
		document.fom.submit();
	}
</script>
</head>
<body>
	<a href='<s:url action="saveLink"/>'>Insert</a>
	<br><br>
	<form name="form" method="post">
		<table>
			<%
				List l = (List)request.getAttribute("disp");
				if(l!=null){
					Iterator it = l.iterator();
					while(it.hasNext()){
						Mybean mybean = (Mybean) it.next();
						int tempNum = mybean.getNo();
						String tempName = mybean.getNam();
						String tempCountry = mybean.getCt();
						%>
						<tr>
							<td><input type="checkbox" value="<%=tempNum %>" name="rdel"></td>
							<td><%= tempNum %></td>
							<td><%= tempName %></td>
							<td><%= tempCountry %></td>
							<td><a href="javascript:editr('<%= tempNum%>')">Edit</a></td>
						</tr>
						
						<%
					}
				}
			%>
			<input type="button" value="delete" onclick="deleteRecord();">
		</table>
	</form>
</body>
</html>