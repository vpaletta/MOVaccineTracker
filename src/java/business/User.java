/**
 *  IS-241 
 *  Spring 2021 
 *  The A-Team's Missouri COVID-19 Vaccination Tracker 
 *  Victor Paletta
 */
package business;
    //Declare instance vairiables and data types in User class.
    public class User {
    private String username;
    private long pwdattempt,  password;
    //Create User constructor and set variables.
    public User() {
        password = 0;
        pwdattempt = -1;
        username = "";
    }
    //Get and set methods for User class.
    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public long getPwdattempt() {
        return pwdattempt;
    }

    public void setPwdattempt(long pwdattempt) {
        this.pwdattempt = pwdattempt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    //Check to see if there is user input and if it matches the correct user password.
    public boolean isAuthenticated() {
         if (this.password > 0 ) {
            if (this.password == this.pwdattempt) {
                return true;
            }
         }
        return false;
    }
    
}


