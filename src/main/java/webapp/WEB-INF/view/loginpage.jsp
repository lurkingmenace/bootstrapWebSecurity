<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--  Added for error handling -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
	<style>
		.failed { color: red; }
	</style>
</head>
<body>


	<!-- This is a Best Practice..use form:form for auth by spring framework
		 Default User name field: username
		 Default password field : password
		 Spring will read the field names and auth via the Spring Security Filters
		 
		 Context Root & Context Path are basically the same thing
	 -->
	<h3>Custom Login Page</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateUser"
				method="POST"> <!--  must be a POST method -->
		

<%-- 		<c:if test="${param.error != null}"> <!-- check for error during logging --> --%>
<%-- 			<i class="failed">Invalid Username or Password "${param.name}"</i> --%>
<%-- 		</c:if> --%>
		
		<p>
		User name: <input type="text" name="username" />
		</p>
		<p>
		Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
				
	</form:form>

</body>
</html>