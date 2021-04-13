<%-- 
    IS-241 
    Spring 2021 
    The A-Team's Missouri COVID-19 Vaccination Tracker 
    Victor Paletta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--JSP scriptlet tag <% %>--%>
<%--<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");%>--%>
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
	<h1>Missouri COVID-19 Vaccination Tracker</h1>  
</header>
<main>
	<h2>New Patient</h2>
        ${msg}
        <br><br>
<form action="newPatient" method="post">
<table class="patient-details">
    <tr>
    <td>Vaccine Eligibility: </td>
<td><select style="border: 2px solid #000033;" name="vaccEligible" id="vaccEligible" required>
    <option value=""></option>
    <option value="Has Appointment">Has Appointment</option>
    <option value="Approved">Approved</option>
</select></td></tr>
    <tr>
        <td><div class="helptip">Patient ID #:
        <span class="helptext">Enter Driver License number or State ID number.</span></div></td>
        <td><input type="text" autocomplete="off" name="patientID" id="patientID" value="" 
       pattern="[aA-zZ0-9]{10}" title="ID # must be 10 digits." required></td></tr>
    <tr>
<td>First Name:</td>
<td><input type="text" pattern="[a-zA-Z]+" title="Must use letters and not numbers." autocomplete="off" name="firstName" id="firstName" value="" required></td></tr>
   <tr>
<td>Middle Name:</td>   
<td><input type="text" pattern="[a-zA-Z]+" title="Must use letters and not numbers." autocomplete="off" name="middleName" id="middleName" value="" required></td></tr>
<tr>
<td>Last Name:</td> 
<td><input type="text" pattern="[a-zA-Z]+" title="Must use letters and not numbers." autocomplete="off" name="lastName" id="lastName" value="" required></td></tr>
<tr>
<td>DOB:</td>                 
<td><input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" 
       value="" autocomplete="off" name="DOB" id="DOB" required></td></tr>
<tr>
<td>Sex:</td>  
<td><select style="border: 2px solid #000033;" name="sex" id="sex" required>
    <option value=""></option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <option value="Other">Other</option>
</select></td></tr>
<tr>
<td>Race:</td>  
<td><select style="border: 2px solid #000033;" name="race" id="race" required>
    <option value=""></option>
    <option value="Asian">Asian</option>
    <option value="Black">Black</option>
    <option value="White">White</option>
    <option value="Latino">Latino</option>
    <option value="Native American">Native American</option>
    <option value="Pacific Islander">Pacific Islander</option>
</select></td></tr>
<tr>
<td>Facility:</td> 
<td><select style="border: 2px solid #000033;" name="facility" id="facility" required>
    <option value=""></option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
</select></td></tr>
<tr>
<td>City: </td>                  
<td><input type="text" pattern="[a-zA-Z]+" title="Must use letters and not numbers." autocomplete="off" name="city" id="city" value="" required></td></tr>
<tr>
<td>State:</td>                   
<td><input type="text" autocomplete="off" name="state" id="state" value="MO" size="10"></td></tr>
<tr>
<td>Email:</td>                  
<td><input type="text" autocomplete="off" name="email" id="email" value="" 
       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Must be valid email." required></td></tr>
<tr>
<td>Phone #:</td>
<td><input placeholder="xxx-xxx-xxxx" type="tel" autocomplete="off" value="" name="phone" id="phone" 
  pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="###-###-####" required></td></tr>
<tr>
<td>Vaccine:</td>
<td><select style="border: 2px solid #000033;" name="vaccine" id="vaccine" required>
    <option value=""></option>
    <option value="Pfizer">Pfizer</option>
    <option value="Moderna">Moderna</option>
    <option value="Johnson & Johnson">Johnson & Johnson</option>
</select></td></tr>
<tr>
<td>Vaccine Administration Site (on body):</td> 
<td><select style="border: 2px solid #000033;" name="vaccineadminsite" id="vaccineadminsite" required>
    <option value=""></option>
    <option value="Left Arm">Left Arm</option>
    <option value="Right Arm">Right Arm</option>
</select></td></tr>
<tr>
<td>Dose:</td> 
<td><select style="border: 2px solid #000033;" name="dose" id="dose" required>
    <option value=""></option>
    <option value="1">Dose 1</option>
    <option value="2">Dose 2</option>
</select></td></tr>
<tr>
<td>Administration Date:</td>                  
<td><input type="text" placeholder="yyyy-mm-dd" autocomplete="off" name="admindate" id="admindate" 
       <%--JSP expression tag <%= %> <%=df.format(new java.util.Date())%>--%>
       value="" 
       pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" size="20" required></td></tr>
<tr>
<td>Adverse Reaction:</td>
<td><select style="border: 2px solid #000033;" name="adversereact" id="adversereact" required>
    <option value=""></option>
    <option value="Yes">Yes</option>
    <option value="No">No</option>
</select></td></tr>
<tr>
<td></td>
<td><input class="button" type="submit" value="Submit" id="submit"></td></tr>
</table>
</form><br>
<nav>
<div id="mv4">
    <div id="mv3">
    <button onclick="topFunction()" class="button" title="Go to top">Top</button>
    </div>
    <div id="mv2">
    <form method="post" action="index.jsp" onsubmit="return validateExit();">
  <input type="submit" class="button" value="Log Out" id="submit">
  </form></div>
 <div id="mv1">
<form method="post" action="next1.jsp" onsubmit="return validateExit();">
  <input type="submit" class="button" value="Back" id="submit">
</form></div>
 </div>
</nav><br>
</main>
<footer>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
<br>
<script>
  function topFunction() {
  // For Safari.
  document.body.scrollTop = 0;
  // For Chrome, Firefox, IE and Opera.
  document.documentElement.scrollTop = 0; 
}
</script>
<script>
    //Confirm popup window. True for "yes" and false for "no".
   function validateExit() {
       var condition = confirm("Sure you want to leave?\n"
       + "Changes you made may not be saved.");
    if (condition === true) {
	return true;
} else {
	return false;
    }	
}
</script>
<script>
//Fills date field with current date. 
var d = new Date();
document.getElementById("admindate").value = d.getFullYear() +"-"+ 
        ("0"+(d.getMonth()+1)).slice(-2)+ "-" + ("0"+(d.getDate())).slice(-2);
//Grabs all user input and sets to variable object.
function submitInfo() {
    var vaccEligible = document.getElementById("vaccEligible");
    var patientID = document.getElementById("patientID");
    var firstName = document.getElementById("firstName");
    var middleName = document.getElementById("middleName");
    var lastName = document.getElementById("lastName");
    var DOB = document.getElementById("DOB");
    var sex = document.getElementById("sex");
    var race = document.getElementById("race");
    var facility = document.getElementById("facility");
    var city = document.getElementById("city");
    var state = document.getElementById("state");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    var vaccine = document.getElementById("vaccine");
    var vaccineadminsite = document.getElementById("vaccineadminsite");
    var dose = document.getElementById("dose");
    var admindate = document.getElementById("admindate");
    var adversereact = document.getElementById("adversereact");
    //Checks all fields for a value and displays alert if condition is true or false.
    (vaccEligible.value && patientID.value && firstName.value.match("[a-zA-Z]+", firstName) && 
      middleName.value.match("[a-zA-Z]+", middleName) && lastName.value.match("[a-zA-Z]+", lastName) 
      && DOB.value && sex.value && race.value && facility.value && city.value && state.value && email.value && phone.value && 
      vaccine.value && vaccineadminsite.value && dose.value && admindate.value && adversereact.value) ?
      alert("Patient uploaded.") : alert("Please fill out all fields correctly.");
}
 document.getElementById("submit").addEventListener("click", submitInfo, false);
 </script>
 <script>
     function submitInfo() {
   var adversereact = document.getElementById("adversereact");
   if (adversereact.value === "Yes") {
   alert("Follow the VAERS link on next page to report adverse reaction case.");
   return true;
   } else {
   return false;
   }
     }
  document.getElementById("submit").addEventListener("click", submitInfo, false);
 </script>
</footer> 
</div>
</body>
</html>