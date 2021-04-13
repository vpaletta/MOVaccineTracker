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
<form action="ViewCertificate" method="post">
    <table class="patient-details">
    <tr>
    <td>Vaccine Eligibility: </td>
<td><input style="border: 2px solid #000033;" name="vaccEligible" value="${p.vaccEligible}" id="vaccEligible" required>
</td></tr>
    <tr>
    <td>Patient ID #:</td>
<td><input type="text" autocomplete="off" name="patientID" id="patientID" value="${p.patientID}" readonly="true" 
       pattern="[aA-zZ0-9]{10}" title="ID # must be 10 digits." required></td></tr>
    <tr>
<td>First Name:</td>
<td><input type="text" autocomplete="off" name="firstName" id="firstName" value="${p.firstName}" required></td></tr>

   <tr>
<td>Middle Name:</td>   
<td><input type="text" autocomplete="off" name="middleName" id="middleName" value="${p.middleName}" required></td></tr>
<tr>
<td>Last Name:</td> 
<td><input type="text" autocomplete="off" name="lastName" id="lastName" value="${p.lastName}" required></td></tr>
<tr>
<td>DOB:</td>                 
<td><input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" 
       autocomplete="off" name="DOB" id="DOB" value="${p.DOB}" required></td></tr>
<tr>
<td>Sex:</td>  
<td><input style="border: 2px solid #000033;" name="sex" id="sex" value="${p.sex}" required>
</td></tr>
<tr>
<td>Race:</td>  
<td><input style="border: 2px solid #000033;" name="race" id="race" value="${p.race}" required>
</td></tr>
<tr>
<td>Facility:</td> 
<td><input style="border: 2px solid #000033;" name="facility" id="facility" value="${p.facility}" required>
</td></tr>
<tr>
<td>City: </td>                  
<td><input type="text" autocomplete="off" name="city" id="city" value="${p.city}" required></td></tr>
<tr>
<td>State:</td>                   
<td><input type="text" autocomplete="off" name="state" id="state" value="${p.state}" required></td></tr>
<tr>
<td>Email:</td>                  
<td><input type="text" autocomplete="off" name="email" id="email" value="${p.email}" 
       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Must be valid email." required></td></tr>
<tr>
<td>Phone #:</td>
<td><input placeholder="xxx-xxx-xxxx" type="tel" autocomplete="off" value="${p.phone}" name="phone" id="phone" 
  pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="###-###-####" required></td></tr>
<tr>
<td>Vaccine:</td>
<td><input style="border: 2px solid #000033;" name="vaccine" id="vaccine" value="${p.vaccine}" required>
</td></tr>
<tr>
<td>Vaccine Administration Site (on body):</td> 
<td><input style="border: 2px solid #000033;" name="vaccineadminsite" id="vaccineadminsite" value="${p.vaccineAdminSite}" required>
</td></tr>
<tr>
<td>Dose:</td> 
<td><input style="border: 2px solid #000033;" name="dose" id="dose" value="${p.dose}" required>
</td></tr>
<tr>
<td>Administration Date:</td>                  
<td><input type="text" placeholder="yyyy-mm-dd" autocomplete="off" name="admindate" id="admindate" 
       <%--JSP expression tag <%= %> <%=df.format(new java.util.Date())%>--%>
       value="${p.admindate}"  
       pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" size="20" required></td></tr>
<tr>
<td>Adverse Reaction:</td>
<td><input style="border: 2px solid #000033;" name="adversereact" value="${p.adversereact}" id="adversereact" required>
</td></tr>
<tr>
<td></td>
<td><input class="button" type="submit" value="View Certificate" id="submit"></td></tr>
</table>
</form>
</main>
<nav>
  <a href="next1.jsp" class="button">Back</a>
  <a href="index.jsp" class="button">Log Out</a>
  <button onclick="topFunction()" class="button" title="Go to top">Top</button>
</nav><br>
<footer>
<script>
  function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}
</script>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
   <br> 
</footer>
</div>
</body>
</html>