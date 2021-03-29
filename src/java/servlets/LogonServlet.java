/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
//Specifies the package that corresponds to the directory that contains this servlet.
package servlets;
//Import the classes that are required by this servlet.
import business.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Create servelet class. All servlets extend "HttpServelet" class. 
public class LogonServlet extends HttpServlet {
      //Servlet method.
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Set response object to the content type that is returned to the browser.
        response.setContentType("text/html;charset=UTF-8");
        //Declare variables used in this servlet.
        User u;
        String username;
        long pwdattempt;
        String URL = "/index.jsp";
        String msg = "";
        String dbURL = "jdbc:mysql://localhost:3306/ateam";
        String dbusername = "root";
        String dbpassword = "sesame";
        //Authenticate user log in credentials with a try/catch statement.
         try {
           //Throw error message if both input feilds are left blank.  
            if (request.getParameter("username").isEmpty() || 
                    request.getParameter("password").isEmpty()) {
                 msg += "Must use correct username and password!";
                 request.setAttribute("msg", msg);
         } else {
            //Set "username" from user input.
            username = request.getParameter("username");
            //Set user password attempt to "pwdattempt".
            pwdattempt = Long.parseLong(request.getParameter("password"));
            //Set "connection" to the ateam database path and log in credentials.
            Connection connection = DriverManager.getConnection(dbURL,dbusername,dbpassword);
            //Select all from the doctor table in the ateam database and match with
            //email/username that the user enters.
            String sql = "SELECT * FROM doctor WHERE EMAIL = '" + username + "'";
            //Set "ps" to the database connection and prepared SQL statement. 
            PreparedStatement ps = connection.prepareStatement(sql);
            //Set the connection and prepared SQL statement to "r".
            ResultSet r = ps.executeQuery(sql);
            //Moves the cursor to the next row in the result set. If the next row exists
            //it will return a true value or false if otherwise. 
            if (r.next()) {
             //Create User object in User class. Set User object to "u".
             u = new User();
             //Set username in the User object.
             u.setUsername(username);
             //Set the password in the User object to the password in the database.
             u.setPassword(r.getLong("D_PASSWORD"));
             //Set the paswword attempt in the User object.
             u.setPwdattempt(pwdattempt);
             //Validate user input. 
              if (u.isAuthenticated()) {
                 msg += "User: " + username;
                 URL = "/next1.jsp";   
             //Return this statement if user input was invalid. 
            } else {
                msg += "Incorrect password! Try gain!<br>";
            }
            } else {
                msg += "Incorrect username! Try again!<br>";
            }
            //Close database connections. 
            r.close();
            ps.close();
            connection.close();
            }
            //Return this error statement if everything above fails.  
          } catch (SQLException e) {
            msg += "Invalid! Try again." + e.getMessage();
            
           } catch (NumberFormatException e) {
            msg += "Invalid! " + e.getMessage();
        } 
         //Set the "${msg}" tag in the index.jsp page
         //depending on which message the "msg" variable is set to above.
         request.setAttribute("msg", msg);
         //Forward the URL to the URL "next1" page. 
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

