package Metodos_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/registrar_usuario"; // URL de la base de datos
    private static final String USUARIO = "root"; // Usuario de la base de datos
    private static final String CONTRASEÑA = "2022"; // Contraseña de la base de datos
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver para MySQL

    // Método para obtener una conexión a la base de datos
    public static Connection getConexion() {
        Connection cn = null;
        try {
            // Cargar el driver de MySQL
            Class.forName(DRIVER);
            // Establecer y devolver la conexión
            cn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    // Método para cerrar la conexión a la base de datos
    public static void desconectar(Connection cn) {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
                System.out.println("Conexión cerrada con éxito.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Implementación del método conectar
    public Connection conectar() {
        return getConexion();
    }
}
