/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
package servlets;


import business.NewPatient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Create servelet class. All servlets extend "HttpServelet" class. 
public class Next1Servlet extends HttpServlet {
//Servlet method.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set the response object to the content type that is returned to the browser.
        response.setContentType("text/html;charset=UTF-8");
        //Set variables used in this servlet.
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatObj);
        String URL = "/next1.jsp";
        String msg = "";
        NewPatient p;
        String patattempt;
        String dbURL = "jdbc:mysql://localhost:3306/ateam";
        String dbusername = "root";
        String dbpassword = "sesame";
     
        //Validate patient ID# with a try/catch statement.
         try {
            //Set "patattempt" from user input.
            patattempt = request.getParameter("patientID").trim();
            //Set "connection" to the ateam database path and log in credentials.
            Connection connection = DriverManager.getConnection(dbURL,dbusername,dbpassword);
            //Select all from the patient table in the ateam database and matches it with
            //the "patattempt" that the user entered.
            String sql = "SELECT * FROM patient WHERE PatientID = '" + patattempt + "'";
            //Set "ps" to the database connection and prepared SQL statment.
            PreparedStatement ps = connection.prepareStatement(sql);
            //Set the connection and prepared SQL statement to "r".
            ResultSet r = ps.executeQuery(sql);
            //Moves the cursor to the next row in the result set. If the next row exists
            //it will return a true value or false if otherwise.
            if (r.next()) {
             //Create NewPatient obect in NewPatient class. Set NewPatient object to "p".
             p = new NewPatient();
             p.setPatientID(r.getString("PatientID"));
             p.setPatattempt(patattempt);
             //Validate patient ID#. If valid it will query the ateam database patient table 
             //through the "r" variable and grab all fields from the mathcing PatientID row, 
             //set them in the "p" object and forward the URL to the "patient.jsp" page.
            if (p.isAuthenticated()) {
             p.setVaccEligible(r.getString("vaccEligible"));
             p.setFirstName(r.getString("firstName"));
             p.setMiddleName(r.getString("middleName"));
             p.setLastName(r.getString("lastName"));
             p.setDOB(r.getString("DOB"));
             p.setSex(r.getString("SEX"));
             p.setRace(r.getString("RACE"));
             p.setFacility(Integer.parseInt(r.getString("FACILITY")));
             p.setCity(r.getString("CITY"));
             p.setState(r.getString("STATE"));
             p.setEmail(r.getString("EMAIL"));
             p.setPhone(r.getString("PHONE"));
             p.setVaccine(r.getString("VACCINE"));
             p.setVaccineAdminSite(r.getString("VaccAdminSite"));
             p.setDose(Integer.parseInt(r.getString("DOSE")));
             p.setAdmindate(r.getString("AdminDate"));
             p.setAdversereact(r.getString("AdverseReact"));
                  URL = "/patient.jsp";
                  request.setAttribute("p", p);
                  request.setAttribute("formattedDate", formattedDate);
              }
            //Return this statement if user input is invalid.
           } else {
                msg += "Patient not found in database. Try again. <br>";
            }
            //Close database connections.
            r.close();
            ps.close();
            connection.close();
            //Return this error statement if everything above fails. 
          } catch (SQLException e) {
            msg += "Invalid patient ID# " + e.getMessage();
          }
           //Sets the "${msg}" tag in the index.jsp page
           //depending on which message the "msg" variable is set to above.
           request.setAttribute("msg", msg);
          //Forward URL to the URL "patient.jsp" page once all new patient
          //data uploads successfully.
          RequestDispatcher disp = 
                getServletContext().getRequestDispatcher(URL);
          //Pass content through the request and response objects.
        disp.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
