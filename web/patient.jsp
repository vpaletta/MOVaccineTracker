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
    <h2>Patient Record</h2>
    ${formattedDate}
    <br><br>
<form action="patient" method="post">
    <label>Update patient record if needed.</label><br><br>
     <label>Vaccine Eligibility:</label>
     <input type="text" id="vaccEligible" name="vaccEligible" value="${p.vaccEligible}" required>
                <br><br>
     <label>Patient ID:</label>
     <input type="text" id="patientID" name="patientID" value="${p.patientID}" readonly="true">
                <br><br>
     <label>First Name:</label>
     <input type="text" id="firstName" name="firstName" value="${p.firstName}" required>
                <br><br>
     <label>Middle Name:</label>
     <input type="text" id="middleName" name="middleName" value="${p.middleName}" required>
                <br><br>
     <label>Last Name:</label>
     <input type="text" id="lastName" name="lastName" value="${p.lastName}" required>
                <br><br>
     <label>DOB:</label>
     <input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd"
            id="DOB" name="DOB" value="${p.DOB}" required>
                <br><br>
     <label>Sex:</label>
     <input type="text" id="sex" name="sex" value="${p.sex}" required>
                <br><br>
     <label>Race:</label>
     <input type="text" id="race" name="race" value="${p.race}" required>
                 <br><br>
     <label>Facility:</label>
     <input type="text" id="facility" name="facility" value="${p.facility}" size="3" required>
               <br><br>
     <label>City:</label>
     <input type="text" id="city" name="city" value="${p.city}" required>
               <br><br>
     <label>State:</label>
     <input type="text" id="state" name="state" value="${p.state}" readonly="true" size="3" required>
               <br><br>
     <label>Email:</label>
     <input type="text" id="email" name="email" value="${p.email}"
            pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Must be valid email." required>
               <br><br>
     <label>Phone:</label>
     <input type="tel" id="phone" name="phone" value="${p.phone}"
       pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="###-###-####" required>
                <br><br>
     <label>Vaccine:</label>
     <input type="text" id="vaccine" name="vaccine" value="${p.vaccine}" required>
                <br><br>
     <label>Vaccine Administration Site (on body):</label><br><br>
     <input type="text" id="vaccineadminsite" name="vaccineadminsite" value="${p.vaccineAdminSite}" required>
               <br><br>
     <label>Dose:</label>
     <input type="text" id="dose" name="dose" value="${p.dose}" required>
               <br><br>
    <label>Administration Date:</label>
     <input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd"
            id="admindate" name="admindate" value="${p.admindate}" required>
               <br><br>
    <label>Adverse Reaction:</label>
    <input type="text" id="adversereact" name="adversereact" value="${p.adversereact}" size="3" required>
                <br><br>
    <input class="button" type="submit" value="Update Patient Record">
</form>
</main>
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
