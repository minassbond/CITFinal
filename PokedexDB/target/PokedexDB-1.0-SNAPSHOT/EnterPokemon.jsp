
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>EnterPokemon</title>
  </head>
  <body>
  <h1>Enter a Pokemon</h1>
<form method=POST action=EnterPokemon>
  Pokemon Number:
 <input type=text name=number/>
 Pokemon Name:
 <input type=text name=name/>
  Pokemon Type:
<input type=text name=type/>
 <input type=submit value=Save />
 </form>
  <br>
  <a href=mainDex><button type=\\\"button\\\">Return to Database</button></a>
  </br>
  </body>
</html>
