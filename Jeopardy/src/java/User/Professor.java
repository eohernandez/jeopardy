/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author enriqueohernandez
 */
public class Professor {
    private String fname;
    private String lname;
    private String password;
    private String email;
    private int status;
    private int tries;

    public Professor(String fname, String lname, String password, String email, int status, int tries) {
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.email = email;
        this.status = status;
        this.tries = tries;
    }
    public Professor(String email, String passowrd) {
        this.fname = "";
        this.lname = "";
        this.password = password;
        this.email = email;
        this.status = 0;
        this.tries = 0;
    }

    public Professor() {
        this.fname = "";
        this.lname = "";
        this.password = "";
        this.email = "";
        this.status = 0;
        this.tries = 0;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }
    

    
    
}