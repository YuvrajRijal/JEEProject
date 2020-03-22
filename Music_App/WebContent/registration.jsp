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

<form action="go" method="post"  enctype="multipart/form-data">
<table border="2" align="center" width="400" bgcolor="rgb(51, 102, 204)" >
<caption>Registration form</caption>
<tr>
<th>Enter your first name</th>
<td><input type="text" name="fn" id="fn1" maxlength="10" title="enter your first name" placeholder="enter your first name" required/></td>
</tr>
<tr>
<th>Enter your last name</th>
<td><input type="text" name="ln" maxlength="10" title="enter your last name" placeholder="enter your last name" required/></td>
</tr>
<tr>
<th>Enter your password</th>
<td><input type="password" name="pw" placeholder="enter your password " required/></td>
</tr>
<tr>
<th>Re-Enter your password</th>
<td><input type="password" name="cpw" placeholder="Confirm password" required/></td>
</tr>
<tr>
<th>Enter your email</th>
<td><input type="email" name="email" placeholder="enter your emailid" required ></td>
</tr>
<tr>
<th>Enter your mobile</th>
<td><input type="number" name="number"  placeholder="enter your mobile number" required/></td>
</tr>
<tr>
<th>Upload your pic</th>
<td><input type="file" name="photo" id="upload"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Save My Data" onclick="alert('Are You sure you want to submit')"/>
<input type="reset" value="Reset Data" onclick="alert('Are You sure you want to Reset?')"/>
</td>
</tr>
</table>
</form>
</body>
</html>