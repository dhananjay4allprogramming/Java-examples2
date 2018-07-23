<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertr</title>
</head>
<body>
<a href="<s:url action="view.action"/>"></a>
<br><br>
<h1>insert details</h1>
<s:form action="insert">
	<s:textfield label="Number" name="mybean.no" cssClass="bord"/>
	<s:textfield label="Name" name="mybean.nam" cssClass="bord"/>
	<s:textfield label="Country" name="mybean.ct" cssClass="bord"/>
	<s:submit value="insert"/>

</s:form>
</body>
</html>