<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<a href='<s:url action="view.action"/>'>Display Record</a>
	<s:form action="updates">
		<s:textfield label="Number" value="%{#application.a}" name="mybean.no" readonly="true" cssClass="bord"/>
		<s:textfield label="Name" value="%{#application.b}" name="mybean.nam"/>
		<s:textfield label="Country" value="%{application.c} name="mb.ct" cssClass="bord"/>
		<s:submit value="update"/>
	</s:form>
</body>
</html>