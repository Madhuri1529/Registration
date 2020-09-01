<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration Form</title>
</head>
<body>
<form action="Register" method="post">
<table>
<tr><td>E-mail Address: </td><td><input type="email" size =100 name="email" required></td></tr>
<tr><td>Title: </td><td><input type="text" name="title" size =5 required></td></tr>
<tr><td>First Name: </td><td><input type="text" size=50 name="firstname" required></td></tr>
<tr><td>Last Name: </td><td><input type="text" size =50  name="lastname" required></td></tr>
<tr><td>Address Line 1: </td><td><input type="text" size =100 name="addressLine1" required></td></tr>
<tr><td>Address Line 2: </td><td><input type="text" size =100 name="addressLine2"></td></tr>
<tr><td>City: </td><td><input type="text" name="city" size =100></td></tr>
<tr><td>PostCode: </td><td><input type="text" name="postcode" size =10 required></td></tr>
<tr><td>Telephone Number: </td><td><input type="text"  size =20 name="telephonenumber"></td></tr>
<tr><td></td><td><input type="submit" value="Register"></td></tr>
</table>
</form>
</body>
</html>