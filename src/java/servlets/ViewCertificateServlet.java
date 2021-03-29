/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
//Specifies the package that corresponds to the directory that contains this servlet.
package servlets;
//Import the classes that are required by this servlet.
import business.NewPatient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Create servelet class. All servlets extend "HttpServelet" class. 
public class ViewCertificateServlet extends HttpServlet {
//Servlet method.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set the response object to the content type that is returned to the browser.
        response.setContentType("text/html;charset=UTF-8");
        //Set variables used in this servlet.
               LocalDateTime date = LocalDateTime.now();
               DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
               String formattedDate = date.format(formatObj);
               String URL = "/patient.jsp";
               String msg= "", vaccEligible="", patientID="", firstName="", middleName="",
                  lastName="", DOB="", sex="", race="", city="", state="", email="", phone="",
                  vaccine="", vaccineAdminSite="", admindate="", adversereact="";
               int facility=0, dose=0;
               String dbURL = "jdbc:mysql://localhost:3306/ateam";
               String dbusername = "root";
               String dbpassword = "sesame";
        //Updtate patient record with try/catch statement. 
        try {
            //Create a NewPatient object "p". 
            NewPatient p = new NewPatient();
           //Validate user input.
           try { 
               //Grab user input. 
                vaccEligible = request.getParameter("vaccEligible");
                //If user input is not empty set "p" object. 
                if (!vaccEligible.isEmpty()) {
                    p.setVaccEligible(vaccEligible);
                } else {
                    //Throw this error message if input fails.
                    msg += "Vaccine eligibility must be filled out.<br>";
                    //Keep original record in input field. 
                    request.setAttribute("p", p); 
                }
                //Throw error message if all above fials.
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
           //Repeat the above code for the next 17 input field attempts. 
         try {
                patientID = request.getParameter("patientID");
                if (!patientID.isEmpty()) {
                    p.setPatientID(patientID);
                } else {
                    msg += "Patient ID must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
           try {
                firstName = request.getParameter("firstName");
                if (!firstName.isEmpty()) {
                    p.setFirstName(firstName);
                } else {
                    msg += "First name must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
             try {
                middleName = request.getParameter("middleName");
                if (!middleName.isEmpty()) {
                    p.setMiddleName(middleName);
                } else {
                    msg += "Middle name must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
              try {
                lastName = request.getParameter("lastName");
                if (!lastName.isEmpty()) {
                    p.setLastName(lastName);
                } else {
                    msg += "Last name must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
              try {
                DOB = request.getParameter("DOB");
                if (!DOB.isEmpty()) {
                    p.setDOB(DOB);
                } else {
                    msg += "DOB must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
               try {
                sex = request.getParameter("sex");
                if (!sex.isEmpty()) {
                    p.setSex(sex);
                } else {
                    msg += "Sex must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                    try {
                race = request.getParameter("race");
                if (!race.isEmpty()) {
                    p.setRace(race);
                } else {
                    msg += "Race must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
              try {
                  if (request.getParameter("facility").isEmpty()) { 
                    msg += "Facility must be filled out.<br>";
                    request.setAttribute("p", p);
                    } else {
                facility = Integer.parseInt(request.getParameter("facility"));
                if (facility > 0) {
                    p.setFacility(facility);
                }  
              }
            } catch (NumberFormatException e) {
                 msg += "Error: " + e.getMessage() + "<br>";
            }
                   try {
                city = request.getParameter("city");
                if (!city.isEmpty()) {
                    p.setCity(city);
                } else {
                    msg += "City must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                   try {
                state = request.getParameter("state");
                if (!state.isEmpty()) {
                    p.setState(state);
                } else {
                    msg += "State must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
              try {
                email = request.getParameter("email");
                if (!email.isEmpty()) {
                    p.setEmail(email);
                } else {
                    msg += "Email must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                   try {
                phone = request.getParameter("phone");
                if (!phone.isEmpty()) {
                    p.setPhone(phone);
                } else {
                    msg += "Phone must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
               try {
                vaccine = request.getParameter("vaccine");
                if (!vaccine.isEmpty()) {
                    p.setVaccine(vaccine);
                } else {
                    msg += "Vaccine must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                   try {
                vaccineAdminSite = request.getParameter("vaccineadminsite");
                if (!vaccineAdminSite.isEmpty()) {
                    p.setVaccineAdminSite(vaccineAdminSite);
                } else {
                    msg += "Vaccine administration site must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
               try {
                     if (request.getParameter("dose").isEmpty()) { 
                    msg += "Dose must be filled out.<br>";
                    request.setAttribute("p", p);
               
                    } else {
                dose = Integer.parseInt(request.getParameter("dose"));
                if (dose > 0) {
                     p.setDose(dose);
                }
              }
           } catch (NumberFormatException e) {
                 msg += "Error: " + e.getMessage() + "<br>";
            }
                   try {
                admindate = request.getParameter("admindate");
                if (!admindate.isEmpty()) {
                    p.setAdmindate(admindate);
                } else {
                    msg += "Administration date must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                try {
                adversereact = request.getParameter("adversereact");
                if (!adversereact.isEmpty()) {
                    p.setAdversereact(adversereact);
                } else {
                    msg += "Adverse reaction must be filled out.<br>";
                    request.setAttribute("p", p);
                }
            } catch (Exception e) {
                msg += "Error: " + e.getMessage() + "<br>";
            }
                if (msg.isEmpty()) {
                //Connect to ateam database
                Connection connection = 
                        DriverManager.getConnection(dbURL, dbusername, dbpassword);
                //Update patient based on "p" object. 
                String sql = "UPDATE patient SET" + 
                        " firstName = ?, " + 
                        " middleName = ?, " +
                        " lastName = ?, " +
                        " DOB = ?, " +
                        " SEX = ?, " + 
                        " RACE = ?, " + 
                        " FACILITY = ?, " +
                        " CITY = ?, " + 
                        " STATE = ?, " + 
                        " EMAIL = ?, " + 
                        " PHONE = ?, " + 
                        " VACCINE = ?, " + 
                        " VaccAdminSite = ?, " +
                        " DOSE = ?, " +
                        " AdminDate = ?, " +
                        " AdverseReact = ?, " +
                        " vaccEligible = ? " +
                        " WHERE PatientID = ? ";
                //Set above sql to PreparedStatement object "ps" and ateam database connection. 
                PreparedStatement ps = connection.prepareStatement(sql);
                //Set first sql string to "p" object input field "firstName". 
                //Repeat the same for the next 17 strings. 
                    ps.setString(1, p.getFirstName());
                    ps.setString(2, p.getMiddleName()); 
                    ps.setString(3, p.getLastName()); 
                    ps.setString(4, p.getDOB()); 
                    ps.setString(5, p.getSex()); 
                    ps.setString(6, p.getRace()); 
                    ps.setInt(7, p.getFacility()); 
                    ps.setString(8, p.getCity());
                    ps.setString(9, p.getState());
                    ps.setString(10, p.getEmail()); 
                    ps.setString(11, p.getPhone()); 
                    ps.setString(12, p.getVaccine()); 
                    ps.setString(13, p.getVaccineAdminSite()); 
                    ps.setInt(14, p.getDose());
                    ps.setString(15, p.getAdmindate()); 
                    ps.setString(16, p.getAdversereact()); 
                    ps.setString(17, p.getVaccEligible());
                    ps.setString(18, p.getPatientID());
                    //Set rc to the "ps" object and execute update. 
                    int rc = ps.executeUpdate();
                    //If "rc" equals "0" nothing was updated.
                       if (rc == 0) {
                    msg += "Patient was not updated!<br>";
                  //If "rc" equals "1" the record was updated.   
                } else if (rc == 1) {
                    URL = "/certificate.jsp";
                    request.setAttribute("p", p);
                    request.setAttribute("formattedDate", formattedDate);
                    //Throw this error message if multiple recods were updated. 
                } else {
                    msg += "Warning! Multiple records changed.<br>";  
                } 
            }
     } catch (SQLException e) {
            msg += "Sql error: " + e.getMessage() + "<br>";
            
        } catch (Exception e) {
            msg += "Servlet error: " + e.getMessage() + "<br>";  
        }
        //Set the "${msg}" tag in the index.jsp page
         //depending on which message the "msg" variable is set to above.
        request.setAttribute("msg", msg);
        //Forward the URL to the URL "certificate.jsp" page. 
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
