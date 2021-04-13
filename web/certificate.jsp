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
   <meta charset="utf-8">
   <link rel="stylesheet" href="styles.css">
   <title>Missouri COVID-19 Vaccination Tracker</title> 
</head>
<body>
<div id="wrapper"> 
<header>
    <h1>Patient Certificate</h1>
</header>
<main>
    <br>
    ${msg}${formattedDate}
    <br><br>
<table class="patient-details">
          <%-- <tr>
                <td>Patient ID:</td>
                <td><input type="text" id="patientID" name="patientID"
                           value="${p.patientID}" readonly="true"></td>
         </tr>--%>
           <tr>
                <td>Last Name:</td>
                <td><input type="text" id="lastName" name="lastName"
                           value="${p.lastName}" readonly="true"></td>
         </tr>
           <tr>
                <td>First Name:</td>
                <td><input type="text" id="firstName" name="firstName" 
                           value="${p.firstName}" readonly="true"></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><input type="text" id="middleName" name="middleName" 
                           value="${p.middleName}" readonly="true"></td>
            </tr>
               <tr>
                <td>DOB:</td>
                <td><input type="text" id="DOB" name="DOB" 
                           value="${p.DOB}" readonly="true"></td>
            </tr>
            <tr>
                <td>Vaccine:</td>
                <td><input type="text" id="vaccine" name="vaccine" 
                           value="${p.vaccine}" readonly="true"></td>
            </tr>
               <tr>
                <td>Dose:</td>
                <td><input type="text" id="dose" name="dose" 
                           value="${p.dose}" readonly="true"></td>
            </tr>
            <tr>
                <td>Administration Date:</td>
                <td><input type="text" id="admindate" name="admindate" 
                           value="${p.admindate}" readonly="true"></td>
            </tr>
               <tr>
                <td>Facility ID:</td>
                <td><input type="text" id="facility" name="facility" 
                           value="${p.facility}" readonly="true"></td>
       </tr>
</table><br>
       <nav>
       <div id="printPageButton">
       <a href="next1.jsp" id="hide1" class="button">Back</a>
       <div class="helptip">
       <a href="https://vaers.hhs.gov/reportevent.html" target="blank" class="button">VAERS</a>
       <span class="helptext">This link will take you to the Vaccine Adverse Event Reporting System web site.</span>
       </div>
       <a class="button" onclick="window.print()">Print</a>
       <a href="index.jsp" id="hide3" class="button">Log Out</a>
       </div>
       </nav><br>
</main>
<footer>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
<br>  
</footer> 
</div>
</body>
</html>
