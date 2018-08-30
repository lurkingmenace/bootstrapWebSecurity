<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
</head>
<body>
	Main landing page!!!

	<%-- User: <sec:authentication property="principal.username" />  Displays user id of current logged in user 
		Keeping logic out of the main page and in the contoller
	--%>
	<p>
		User: ${userName}
	</p>
	<p>
		Role(s): <%-- this could have been this:
					<security:authentication property="principal.authorities" --%>
		<c:forEach var="auth" items="${authorities}" >
			${auth}
		</c:forEach>
	</p>
	<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
		<p>
			<input type="submit" value="Logout" />
		</p>
	</form:form>
</body>
</html>