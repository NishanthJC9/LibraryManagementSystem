<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
	<form action="readerLogin">
		<label for="registerEmail"></label>
		<input type="email" name="registerEmail" class="registerEmail" id="registerEmail" placeholder="Enter Email" required="required"><br><br>
		<label for="registerPassword"></label>
		<input type="password" name="registerPassword" class="registerPassword" id="registerPassword" placeholder="Enter Password" required="required"><br><br>
		<input type="submit" value="Login">
	</form>
	
	<a href="ReaderRegistration.jsp">Sign-Up</a>
</body>
</html>