<%-- 
    IS-241 
    Spring 2021 
    The A-Team's Missouri COVID-19 Vaccination Tracker 
    Victor Paletta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <br>
        ${msg} 
        <br><br>
<form action="next1" method="post">
    <label>Enter existing patient ID#:</label><br><br>
        <input placeholder="Patient ID#" autocomplete="off" name="patientID" id="patientID" value="">
        <br><br>
        <input class="button" type="submit" value="Submit">
</form><br>
</main>
<nav>
<a href="newPatient.jsp" class="button">New Patient</a>
<a href="dailyReport.jsp" class="button">Daily Report</a>
<a href="index.jsp" class="button">Log Out</a> 
</nav><br>
<footer>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
   <br> 
</footer>
</div>
</body>
</html>
