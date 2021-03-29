/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
package servlets;


import business.InsertPatient;
import business.NewPatient;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Create servelet class. All servlets extend "HttpServelet" class. 
public class NewPatientServlet extends HttpServlet {
    //Servlet method.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set the response object to the content type that is returned to the browser.
        response.setContentType("text/html;charset=UTF-8");
        //Set variables used in this servlet.
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatObj);
        String msg = "";
        String URL = "/newPatient.jsp";
        
       //Enter new patient data with a try/catch statement.
        try {
             //Grab user input and set to given vairable names.
            String vaccEligible = request.getParameter("vaccEligible");
            String patientID = request.getParameter("patientID");
            String firstName = request.getParameter("firstName");
            String middleName = request.getParameter("middleName");
            String lastName = request.getParameter("lastName");
            String DOB = request.getParameter("DOB");
            String sex = request.getParameter("sex");
            String race = request.getParameter("race");
            int facility = Integer.parseInt(request.getParameter("facility"));
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String vaccine = request.getParameter("vaccine");
            String vaccineadminsite = request.getParameter("vaccineadminsite");
            int dose = Integer.parseInt(request.getParameter("dose"));
            String admindate = request.getParameter("admindate");
            String adversereact = request.getParameter("adversereact");
            //Create a NewPatient object "p". 
            NewPatient p = new NewPatient();
            //Set all user input into the NewPatient object "p".
            p.setVaccEligible(vaccEligible);
            p.setPatientID(patientID);
            p.setFirstName(firstName);
            p.setMiddleName(middleName);
            p.setLastName(lastName);
            p.setDOB(DOB);
            p.setSex(sex);
            p.setRace(race);
            p.setFacility(facility);
            p.setCity(city);
            p.setState(state);
            p.setEmail(email);
            p.setPhone(phone);
            p.setVaccine(vaccine);
            p.setVaccineAdminSite(vaccineadminsite);
            p.setDose(dose);
            p.setAdmindate(admindate);
            p.setAdversereact(adversereact);
            //Use the SQL code in the InsertPatient class to insert all user input
            //from the new "p" object created here. 
            InsertPatient.insert(p);
                //msg = "Patient uploaded for " + p.getPatientID() + " on "; 
                URL = "/certificate.jsp";
                request.setAttribute("p", p);
                request.setAttribute("formattedDate", formattedDate);
            
        //Display error message if all the above fails. 
        } catch (Exception e) {
           msg += "Invalid. Try again.";
        } 
         //Set the "${msg}" tag in the newPatient.jsp page
         //depending on which message the "msg" variable is set to above.
         request.setAttribute("msg", msg);
         //Forward the URL to the URL "newPatient.jsp" page.
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
