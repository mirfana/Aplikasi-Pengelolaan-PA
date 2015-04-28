package aplikasiPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Database {
    Statement stmt;
    Connection con;
    private ResultSet rs;
    
    public Database(){
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database .class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con = DriverManager.getConnection("jdbc:sqlite:src/aplikasiPA.sqlite");
            } catch (SQLException ex) {
                Logger.getLogger(Database .class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = con.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public ResultSet getData(String SQL){
        try {
            rs = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }
    
    public void query(String SQL){
        try {
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
}
