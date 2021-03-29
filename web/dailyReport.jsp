<%-- 
    IS-241 
    Spring 2021 
    The A-Team's Missouri COVID-19 Vaccination Tracker 
    Victor Paletta
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="dailyReport" method="post">
    <label for="date">Enter Report Date:</label><br><br> 
        <input <input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" 
               title="yyyy-mm-dd" value="" name="date" id="date" required>
        <br><br>
        <input class="button" type="submit" value="Submit">
</form><br>
<h2>Daily Report Log</h2>
      <table class="patient-details">
          <tr>
                <th>Quantity:</th>
                <th>Date:</th>
                <th>Vaccine:</th>
                <th>Dose:</th>
                <th>Adverse Reaction:</th>
                <th>Facility:</th>
            </tr>
               <c:forEach var="d" items="${dts}">
                <tr>
                    <td align="left">${d.number}</td>
                    <td align="left">${d.admindate}</td>
                    <td align="left">${d.vaccine}</td>
                    <td align="left">${d.dose}</td>
                    <td align="left">${d.adversereact}</td>
                    <td align="left">${d.facility}</td>
                </tr>
            </c:forEach>  
        </table>
</main><br><br>
<nav>
 <a href="next1.jsp" class="button">Back</a>
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
