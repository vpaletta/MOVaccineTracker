/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
package business;
//Declare instance vairiables and data types in NewPatient class.
public class NewPatient { 
    private String patientID, firstName, middleName, lastName, DOB, sex, race, city, state, email, phone, vaccine, vaccineAdminSite, 
            admindate, adversereact, patattempt, vaccEligible;
    private int facility, dose, number;
    //Create NewPatient constructor and set variables.
    public NewPatient() {
        patientID = "";
        firstName = "";
        middleName = "";
        lastName = "";
        DOB = "";
        sex = "";
        race = "";
        facility = 0;
        city = "";
        state = "";
        email = "";
        phone = "";
        vaccine = "";
        vaccineAdminSite = "";
        dose = 0;
        admindate = "";
        adversereact = "";
        patattempt = "";
        vaccEligible = "";
        number = 0;
    }
    //Get and set methods for all NewPatient variables.
    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
    return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDOB() {
        return DOB;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public String getSex() {
    return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getRace() {
    return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public int getFacility() {
    return facility;
    }
    public void setFacility(int facility) {
    this.facility = facility;
    }
    public String getCity() {
    return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
    return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getEmail() {
    return email;
    }
    public void setEmail(String email) {
    this.email = email;
    }
    public String getPhone() {
    return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getVaccine() {
        return vaccine;
    }
    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }
    public String getVaccineAdminSite() {
       return vaccineAdminSite;
    }
    public void setVaccineAdminSite(String vaccineAdminSite) {  
       this.vaccineAdminSite = vaccineAdminSite;
    }
    public int getDose() {
        return dose;
    }
    public void setDose(int dose) {
        this.dose = dose;
    }
    public String getAdmindate() {
        return admindate;
    }
    public void setAdmindate(String admindate) {
        this.admindate = admindate;
    }
    public String getAdversereact() {
        return adversereact;
    }
    public void setAdversereact(String adversereact) {
        this.adversereact = adversereact;
    }
    public String getPatattempt() {
        return patattempt;
    }
    public void setPatattempt(String patattempt) {
        this.patattempt = patattempt;
    }
      public String getVaccEligible() {
        return vaccEligible;
    }
    public void setVaccEligible(String vaccEligible) {
        this.vaccEligible = vaccEligible;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    //Checks to see if there is user input and if it matches the correct patient ID#.
    public boolean isAuthenticated() {
         if (!this.patientID.isEmpty()) {
            if (this.patientID.equals(this.patattempt)) {
                return true;
            }
         }
    return false;
    }
}
