/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import User.Professor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enriqueohernandez
 */
//https://github.com/MNoya/CloudDataBase/blob/master/JDBCTutorial/src/com/oracle/tutorial/jdbc/StoredProcedureJavaDBSample.java
public class DBHandler {

    private static Connection connection;

    public DBHandler() {
        try {
          
            connection = DriverManager.getConnection("jdbc:mysql://104.131.19.102:3306/jeopardy", "root", "hinojosar00t");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * The function saves into Professor the attributes from the Database.
     * 
     * @param prof
     * @return boolean
     */
    public static boolean getLogin(Professor prof) {
        boolean valid = false;
        String email = prof.getEmail();
        String password = prof.getPassword();
        try {
            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery("SELECT * FROM Professors where email='"+email+"' AND password='"+password+"'");

            if (results.next()) {
                prof.setId(Integer.parseInt(results.getString(1)));
                prof.setFname(results.getString(2));
                prof.setLname(results.getString(3));
                prof.setStatus(Integer.parseInt(results.getString(5)));
                prof.setTries(Integer.parseInt(results.getString(6)));
                valid = true;
            }
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(!valid){
             try {
                Statement statement2 = connection.createStatement();
                ResultSet results2 = statement2.executeQuery("SELECT * FROM Professors WHERE email='"+email+"'");
                if (results2.next()) {
                    prof.setId(Integer.parseInt(results2.getString(1)));
                    prof.setFname(results2.getString(2));
                    prof.setLname(results2.getString(3));
                    prof.setStatus(Integer.parseInt(results2.getString(5)));
                    prof.setTries(Integer.parseInt(results2.getString(6)));
                    
                }
                statement2.close();
              } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         return valid;   
    }/**
     * The function changes the password of the Professor
     * @param prof
     * @param newPass
     * @return boolean
     */
     public static boolean changePass(Professor prof, String newPass) {
             boolean valid = false;
        try {
            Statement statement = connection.createStatement();
            String email = prof.getEmail();
            String password = prof.getPassword();
            String query = "UPDATE Professors SET password = '"+newPass+"' WHERE Id= '"+prof.getId()+"'";
            statement.executeUpdate(query);
            statement.close();
            valid =true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return valid;

    }
     /**
      * The function changes the status of the professor
      * @param prof
      * @param status
      * @return boolean
      */
     public static boolean changeStatus (Professor prof, int status) {
             boolean valid = false;
        try {
            Statement statement = connection.createStatement();
            String email = prof.getEmail();
            String password = prof.getPassword();
            String query = "UPDATE Professors SET status = "+status+"  WHERE Id= '"+prof.getId()+"'";
            statement.executeUpdate(query);
            statement.close();
            valid =true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return valid;
    }/**
     * The function changes the tries of the Professor
     * @param prof
     * @param tries
     * @return 
     */
     public static boolean changeTries (Professor prof, int tries) {
             boolean valid = false;
        try {
            Statement statement = connection.createStatement();
            String email = prof.getEmail();
            String password = prof.getPassword();
            String query = "UPDATE Professors SET tries = "+tries+" WHERE Id= '"+prof.getId()+"'";
            statement.executeUpdate(query);
            statement.close();
            valid =true;
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return valid;
    }
     /**
      * The function changes the tries of the Professor
      * @param prof
      * @return boolean
      */
     public static boolean getTries (Professor prof) {
             boolean valid = false;
        try {
            Statement statement = connection.createStatement();
            String email = prof.getEmail();
            String password = prof.getPassword();
            int tries  = 0;
            String query = "SELECT tries FROM Professors WHERE Id= '"+prof.getId()+"'";
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
                valid = true;
               tries = Integer.parseInt(results.getString(1));
               prof.setTries(tries);
            }
            statement.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return valid;
    }
    /*
    public static void storeMessage(Mensaje mensaje) {
        try {
            Statement statement = connection.createStatement();
            String de = mensaje.getDe();
            String para = mensaje.getPara();
            String contenido = mensaje.getContenido();
            String query = "insert into mensajes (de, para, contenido) values ('" + de + "','" + para + "','" + contenido + "')";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList getMessages(String para) {
        ArrayList list = new ArrayList();
        try {            
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT de, contenido, contenido FROM mensajes where para='"+para+"'");
            while (results.next()) {
                String de=results.getString(1);
                String contenido=results.getString(2);
                Mensaje mensaje = new Mensaje(de, para, contenido);
                list.add(mensaje);
            }
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
   
        public static boolean addUser(Usuario usr) {
             boolean valid = false;
        try {
            Statement statement = connection.createStatement();
            String usuario = usr.getUser();
            String password = usr.getPassword();
            String query = "insert into usuarios (users, passwords) values ('" + usuario + "','" + password + "')";
            statement.executeUpdate(query);
            statement.close();
            valid =true;
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return valid;

    }
    
   */

}
