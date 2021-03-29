/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
package business;
    //Import SQL from java library.
import java.sql.*;
    //Class name. 
public class InsertPatient {
    //Method for inputing patient data into the ateam database.
    public static int insert(NewPatient p) {
    
    try {
        //SQL code needed to enter patient data into the ateam database patient table.
    String query = "INSERT INTO patient (PatientID, firstName, middleName, lastName, DOB, "
            + "SEX, RACE, FACILITY, CITY, STATE, EMAIL, PHONE, VACCINE, VaccAdminSite, DOSE,"
            + "AdminDate, AdverseReact, vaccEligible) " + 
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    //Required path, username and password to enter the ateam database.
    String dbURL = "jdbc:mysql://localhost:3306/ateam";
    String dbusername = "root";
    String dbpassword = "sesame";
    //Make the connection to the ateam database. 
    Connection connection = DriverManager.getConnection(dbURL,dbusername,dbpassword);
        //Set "ps" object with connection and SQL string query.
        PreparedStatement ps = connection.prepareStatement(query);
        //Set the SQL code to the user input in the order that they are given in the SQL string.
        ps.setString(1, p.getPatientID());
        ps.setString(2, p.getFirstName());
        ps.setString(3, p.getMiddleName());
        ps.setString(4, p.getLastName());
        ps.setString(5, p.getDOB());
        ps.setString(6, p.getSex());
        ps.setString(7, p.getRace());
        ps.setInt(8, p.getFacility());
        ps.setString(9, p.getCity());
        ps.setString(10, p.getState());
        ps.setString(11, p.getEmail());
        ps.setString(12, p.getPhone());
        ps.setString(13, p.getVaccine());
        ps.setString(14, p.getVaccineAdminSite());
        ps.setInt(15, p.getDose());
        ps.setString(16, p.getAdmindate());
        ps.setString(17, p.getAdversereact());
        ps.setString(18, p.getVaccEligible());
        return ps.executeUpdate();
        
     //Display error message if SQL code fails.   
 } catch(SQLException e) {
    System.out.println(e);
    return 0;
    //Close the database connection with the method from the DBUtil class.
}  finally {
        //Clear the "ps" object connection.
        Statement ps = null;
        //Retrieve DBUtil class method to close the "ps" object.
        DBUtil.closePreparedStatement(ps);
    } 
   }   
}
