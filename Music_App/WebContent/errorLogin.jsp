<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body
{
background-color: rgb(51, 102, 204);
background-image: url("F:\\registration.png");
background-size:cover;
background-repeat: no-repeat;
}


</style>
<title>HTML Table</title>
</head>
<body>
<h1 align="center">Wrong Details</h1>
<form action="login" method="post"  enctype="multipart/form-data">
<table border="2" align="center" width="400" bgcolor="rgb(51, 102, 204)" >
<caption>Login form</caption>
<tr>
<th>Enter your password</th>
<td><input type="password" name="pw" placeholder="enter your password " required/></td>
</tr>
<tr>
<th>Enter your email</th>
<td><input type="email" name="email" placeholder="enter your emailid" required ></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" onclick="alert('Are You sure you want to Login')"/>
<input type="reset" value="Reset Data" onclick="alert('Are You sure you want to Reset?')"/>
</td>
</tr>
</table>
</form>
</body>
</html>