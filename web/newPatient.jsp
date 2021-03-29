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
<label for="vaccEligible">Vaccine Eligibility: </label>
<select name="vaccEligible" id="vaccEligible" required>
    <option value=""></option>
    <option value="Has Appointment">Has Appointment</option>
    <option value="Approved">Approved</option>
</select><br><br>
	
<label for="patientID">Patient ID #: </label>
<input type="text" autocomplete="off" name="patientID" id="patientID" value="" 
       pattern="[aA-zZ0-9]{10}" title="ID # must be 10 digits." required><br><br>

<label for="firstName">First Name: </label>
<input type="text" autocomplete="off" name="firstName" id="firstName" value="" required><br><br>

<label for="middleName">Middle Name: </label>
<input type="text" autocomplete="off" name="middleName" id="middleName" value="" required><br><br>

<label for="lastName">Last Name: </label>
<input type="text" autocomplete="off" name="lastName" id="lastName" value="" required><br><br>

<label for="DOB">DOB: </label>                   
<input type="text" placeholder="yyyy-mm-dd" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" 
       value="" autocomplete="off" name="DOB" id="DOB" required><br><br>

<label for="sex">Sex: </label>
<select name="sex" id="sex" required>
    <option value=""></option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <option value="Other">Other</option>
</select><br><br>

<label for="race">Race: </label>
<select name="race" id="race" required>
    <option value=""></option>
    <option value="Asian">Asian</option>
    <option value="Black">Black</option>
    <option value="White">White</option>
    <option value="Latino">Latino</option>
    <option value="Native American">Native American</option>
    <option value="Pacific Islander">Pacific Islander</option>
</select>
<br><br>

<label for="facility">Facility: </label>
<select name="facility" id="facility" required>
    <option value=""></option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
</select>
<br><br>

<label for="city">City: </label>                  
<input type="text" autocomplete="off" name="city" id="city" value="" required><br><br>

<label for="state">State: </label>                  
<input type="text" autocomplete="off" name="state" id="state" value="MO" size="10"><br><br>

<label for="email">Email: </label>                   
<input type="text" autocomplete="off" name="email" id="email" size="30" value="" 
       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Must be valid email." required><br><br>

<label for="phone">Phone #: </label>
<input placeholder="xxx-xxx-xxxx" type="tel" autocomplete="off" value="" name="phone" id="phone" 
  pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" title="###-###-####" required><br><br>

<label for="vaccine">Vaccine: </label>
<select name="vaccine" id="vaccine" required>
    <option value=""></option>
    <option value="Pfizer">Pfizer</option>
    <option value="Moderna">Moderna</option>
    <option value="Johnson & Johnson">Johnson & Johnson</option>
</select><br><br>
  
<label for="vaccineadminsite">Vaccine Administration Site (on body):</label><br>
<select name="vaccineadminsite" id="vaccineadminsite" required>
    <option value=""></option>
    <option value="Left Arm">Left Arm</option>
    <option value="Right Arm">Right Arm</option>
</select><br><br>

<label for="dose">Dose:</label>
<select name="dose" id="dose" required>
    <option value=""></option>
    <option value="1">Dose 1</option>
    <option value="2">Dose 2</option>
</select><br><br>

<label for="admindate">Administration Date: </label>                  
<input type="text" placeholder="yyyy-mm-dd" autocomplete="off" name="admindate" id="admindate" 
       <%--JSP expression tag <%= %> <%=df.format(new java.util.Date())%>--%>
       value="" 
       pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" title="yyyy-mm-dd" size="20" required><br><br>
<label for="adversereact">Adverse Reaction:</label>
<select name="adversereact" id="adversereact" required>
    <option value=""></option>
    <option value="Yes">Yes</option>
    <option value="No">No</option>
</select><br><br>
<input class="button" type="submit" value="Submit" id="submit"><br><br>
</form>
<nav>
<div id="mv4">
  <div id="mv3">
  <form method="post" action="https://vaers.hhs.gov/reportevent.html" onsubmit="return validateExit();">
  <input type="submit" class="button" value="VAERS" is="submit">
</form></div>
    <div id="mv2">
    <form method="post" action="index.jsp" onsubmit="return validateExit();">
  <input type="submit" class="button" value="Log Out" is="submit">
  </form></div>
 <div id="mv1">
<form method="post" action="next1.jsp" onsubmit="return validateExit();">
  <input type="submit" class="button" value="Back" is="submit">
</form>
 </div>
 </div>
</nav><br>
</main>
<footer>
   <img style="text-align: center; max-width: 150px" src="images/MO.gif" alt="Missouri">
   <p>&copy; 2021 The A-Team</p>
<br> 
<script>
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
var d = new Date();
document.getElementById("admindate").value = d.getFullYear() +"-"+ 
        ("0"+(d.getMonth()+1)).slice(-2)+ "-" + d.getDate();

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
    
    (vaccEligible.value && patientID.value && firstName.value && middleName.value &&
      lastName.value && DOB.value && sex.value && race.value && facility.value &&
      city.value && state.value && email.value && phone.value && 
      vaccine.value && vaccineadminsite.value && dose.value && admindate.value
      && adversereact.value) ?
        
        alert("Patient uploaded!") : alert("Please fill out all fields correctly.");
}
 document.getElementById("submit").addEventListener("click", submitInfo, false);
 </script>
</footer> 
</div>
</body>
</html>