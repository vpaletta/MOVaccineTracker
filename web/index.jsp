<%-- 
    IS-241 
    Spring 2021 
    The A-Team's Missouri COVID-19 Vaccination Tracker 
    Victor Paletta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css" type="text/css">
        <title>Missouri COVID-19 Vaccination Tracker</title>
    </head>
<body>
<div id="wrapper">
    <header>
        <h1>Missouri COVID-19 Vaccination Tracker</h1>
    </header>
<main>
    <h2>Welcome</h2>
<form action="logon" method="post">
   <input autocomplete="off" placeholder="Username" type="text" name="username" id="username" size="30">
        <br><br>
   <input autocomplete="off" placeholder="Password" type="password" name="password" id="password" size="30">
        <br><br>
<input class="button" type="submit" value="Log In">
</form><br>
        ${msg} 
        <br>
</main>
<footer>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
<br>  
</footer>
</div>
</body>
</html>
