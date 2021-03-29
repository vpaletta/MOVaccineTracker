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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "/dailyReport.jsp";
        String daily;
        String msg = "";
        NewPatient d;
        int i = 1;
        String dbURL = "jdbc:mysql://localhost:3306/ateam";
        String dbusername = "root";
        String dbpassword = "sesame";
       
       try {
          daily = request.getParameter("date");
          Connection connection = DriverManager.getConnection(dbURL,dbusername,dbpassword);
          //Match database date with the user input date.
          String sql = "SELECT * FROM patient WHERE AdminDate = '" + daily + "'";
          PreparedStatement ps = connection.prepareStatement(sql);
          ResultSet r = ps.executeQuery(sql);
            //Create a new object "dts" that will hold a new list. 
            ArrayList<NewPatient> dts = new ArrayList<>();
           //Search rows until all data has been collected from stated columns.
           //Also create a new column adding "1" each run with the "i++".
            while (r.next()) {
              d = new NewPatient();
              d.setNumber(i);
              i++;
              d.setAdmindate(daily);
              d.setVaccine(r.getString("VACCINE"));
              d.setDose(r.getInt("DOSE"));
              d.setAdversereact(r.getString("AdverseReact"));
              d.setFacility(r.getInt("FACILITY"));
              dts.add(d);
            }
            msg+= "";
            request.setAttribute("dts", dts);
            //Close database connections. 
            r.close();
            ps.close();
            connection.close();
            URL = "/dailyReport.jsp";
       //Throw this error message if no data is added to the "dts" object.      
    if (dts.isEmpty()) {
        msg+= "No record found.";
    }
     } catch (SQLException e) {
         msg ="Date error: " + e.getMessage();
         URL = "/dailyReport.jsp";
     
     } catch (Exception e) {
         msg ="Date error: " + e.getMessage();
         URL = "/dailyReport.jsp";
     }
     request.setAttribute("msg", msg);
     RequestDispatcher disp = 
                getServletContext().getRequestDispatcher(URL);
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
