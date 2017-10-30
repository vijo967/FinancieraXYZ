package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author roddycorrea
 */
public class ConnectionDb {
    Connection con;
    String server = "jdbc:mysql://localhost:8889/atmdb";
    String user = "root";
    String pass = "root";
    public Connection conexion() throws ClassNotFoundException {
        try {
            //Cargamos el puente JDBC =&gt; Mysql
            Class.forName("com.mysql.jdbc.Driver");
            //Intentamos conectarnos a la base de Datos en este caso una base llamada temp
            con = DriverManager.getConnection(server, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error de mysql: " + ex.getMessage());
        } 
        return con;
    }
}
