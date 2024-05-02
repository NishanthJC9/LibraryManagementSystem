<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerReader">
	<h1>Register</h1>
		<label for="registerUser"></label>
		<input type="text" name="registerUser" class="registerUser" id="registerUser" placeholder="Enter Name" required="required"><br><br>
		<label for="registerEmail"></label>
		<input type="email" name="registerEmail" class="registerEmail" id="registerEmail" placeholder="Enter Mail-id" required="required"><br><br>
		<label for="registerMobile"></label>
		<input type="number" name="registerMobile" class="registerMobile" id="registerMobile" placeholder="Enter MobileNumber" required="required"><br><br>
		<label for="registerPassword"></label>
		<input type="password" name="registerPassword" class="registerPassword" id="registerPassword" placeholder="Enter Password" required="required"><br><br>
		<label for="confirm"></label>
		<input type="password" name="confirm" class="confirm" id="confirm" placeholder="Confirm Password" required="required"><br><br>
		<input type="submit" value="Register">
	</form>
	<a href="ReaderLogin.jsp">Sign In</a>
</body>
</html>