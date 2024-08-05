package Metodos_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metodos_sql {

    private static PreparedStatement ps;
    private static ResultSet resultado;

    // Métodos de gestión de usuarios

   public int guardar(String nombre, String apellido, String fecha_de_nacimiento, String cedula, String numero_telefonico, String correo, String usuario, String contraseña) {
    Connection con = null;
    PreparedStatement ps = null;
    int resultado = 0;

    try {
        con = ConexionDB.getConexion(); // Obtener la conexión
        String sql = "INSERT INTO Usuarios (nombre, apellido, fecha_de_nacimiento, cedula, numero_telefonico, correo, usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, apellido);
        ps.setString(3, formatFecha(fecha_de_nacimiento)); // Formatear fecha
        ps.setString(4, cedula);
        ps.setString(5, numero_telefonico);
        ps.setString(6, correo);
        ps.setString(7, usuario);
        ps.setString(8, contraseña);

        resultado = ps.executeUpdate();
        System.out.println("Registro de usuario guardado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cierre de recursos
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return resultado;
}

    private String formatFecha(String fecha) {
        // Asumir formato DDMMYYYY
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(2, 4);
        String anio = fecha.substring(4, 8);
        
        return anio + "-" + mes + "-" + dia; // Formato YYYY-MM-DD
    }

    public static String buscarNombre(String correo) {
        String busqueda_nombre = null;
        Connection conexion = null;

        try {
            conexion = ConexionDB.getConexion();
            String sentencia_buscar = "SELECT nombre, apellido FROM Usuarios WHERE correo = ?";
            ps = conexion.prepareStatement(sentencia_buscar);
            ps.setString(1, correo);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                busqueda_nombre = nombre + " " + apellido;
            }
            
            ConexionDB.desconectar(conexion);
        } catch (SQLException e) {
            System.out.println(e);
        } 

        return busqueda_nombre;
    }

    public static String buscarUsuarioRegistrado(String usuario, String contraseña) {
        String busqueda_usuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionDB.getConexion();
            String sentencia_buscar_usuario = "SELECT nombre, correo, usuario, contraseña FROM Usuarios WHERE usuario = ? AND contraseña = ?";
            ps = conexion.prepareStatement(sentencia_buscar_usuario);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            resultado = ps.executeQuery();

            if (resultado.next()) {
                busqueda_usuario = "Usuario encontrado";
            } else {
                busqueda_usuario = "Usuario no encontrado";
            }
            
            ConexionDB.desconectar(conexion);
        } catch (Exception e) {
            System.out.println(e);
        } 

        return busqueda_usuario;
    }

    // Métodos de gestión de inventario

 

    public int actualizarInventario(int inventarioId, int productId, int etapaId, int cantidad, String fecha) {
        Connection con = null;
        PreparedStatement ps = null;
        int resultado = 0;

        try {
            con = ConexionDB.getConexion();
            String sql = "UPDATE Inventario SET product_id=?, etapa_id=?, cantidad=?, fecha=? WHERE inventario_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setInt(2, etapaId);
            ps.setInt(3, cantidad);
            ps.setDate(4, java.sql.Date.valueOf(fecha)); 
            ps.setInt(5, inventarioId);

            resultado = ps.executeUpdate();
            System.out.println("Registro de inventario actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public int eliminarInventario(int inventarioId) {
        Connection con = null;
        PreparedStatement ps = null;
        int resultado = 0;

        try {
            con = ConexionDB.getConexion();
            String sql = "DELETE FROM Inventario WHERE inventario_id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventarioId);

            resultado = ps.executeUpdate();
            System.out.println("Registro de inventario eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultado;
    }

    public ResultSet buscarInventario(String criterio) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultado = null;

        try {
            con = ConexionDB.getConexion();
            String sql = "SELECT * FROM Inventario WHERE inventario_id LIKE ? OR etapa_id LIKE ? OR fecha LIKE ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            ps.setString(3, "%" + criterio + "%");

            resultado = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

  public int agregar(String producto, String cantidad, String etapa, String fecha) {
    Connection con = null;
    PreparedStatement ps = null;
    int resultado = 0;

    try {
        con = ConexionDB.getConexion();
        
        // Convertir la fecha al formato YYYY-MM-DD
        String fechaFormateada = convertirFecha(fecha);
        
        String sql = "INSERT INTO Inventario (producto, cantidad, etapa, fecha) VALUES (?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, producto);
        ps.setString(2, cantidad);
        ps.setString(3, etapa);
        ps.setDate(4, java.sql.Date.valueOf(fechaFormateada));

        resultado = ps.executeUpdate();
        System.out.println("Registro de inventario guardado exitosamente.");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cierre de recursos
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return resultado;
}

private String convertirFecha(String fecha) {
    // Asumir que la fecha ingresada es en el formato DD-MM-YYYY
    String[] partes = fecha.split("-");
    if (partes.length == 3) {
        String dia = partes[0];
        String mes = partes[1];
        String anio = partes[2];
        
        // Formato esperado para la base de datos
        return anio + "-" + mes + "-" + dia;
    } else {
        throw new IllegalArgumentException("Formato de fecha incorrecto. Use DD-MM-YYYY.");
    }
}
   
}
