
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Languages</title>
<style>

#container {
	width: 1000px;
	margin: 0px auto;
}

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
 
tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<div id="container">
<h1>Languages</h1>

<table>
  <tr>
    <th>Name</th>
    <th>Creator</th>
    <th>Version</th>
	<th>Action</th>
  </tr>
<c:forEach items="${languages}" var="language" varStatus="loop">
<tr>    
    <td><a href="/${loop.index}">${language.name}</a></td>
    <td><c:out value="${language.creator}"/></td>
    <td><c:out value="${language.version}"/></td>
    <td><a href="/delete/${loop.index}">Delete</a> | <a href="/edit/${loop.index}">Edit</a></td>
</tr>
</c:forEach>
</table>
<br>
<br>

<h2>Add Language</h2>
<form:form method="POST" action="/new" modelAttribute="language">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label><br>
    
    <form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:input path="creator"/></form:label><br>
    
    <form:label path="version">Version
    <form:errors path="version"/>
    <form:input path="version"/></form:label><br>
    
    <input type="submit" value="Submit"/>
</form:form>

</div>

</body>
</html>