<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
Main landing page!!!
<p>
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<p>
			<input type="submit" value="Logout" />
		</p>
	</form:form>
</body>
</html>