<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Pokedex</title>
</head>
<body>
<h1><%= "Welcome to the Pokedex database!" %>
</h1>
<br/>
<h2><%= "Please enter your new entry below:"%></h2>
<br/>
<form action="data" method="get">
    <table>
        <tr> <td> Pokemon Name: </td><td><input type="text" name="pokemon"></td></tr>
        <tr> <td> Pokemon Type: </td><td><input type="text" name="type"></td></tr>
        <tr> <td> Area Seen: </td><td><input type="text" name="area"></td></tr>
        <tr> <td> </td><td><input type="submit" value="submit"></td></tr>
</body>
</html>