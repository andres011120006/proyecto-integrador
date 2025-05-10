package ORCLCONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarAOracle {

    private static final String URL = "jdbc:oracle:thin:@192.168.254.215:1521:orcl";
    private static final String USUARIO = "proy_int_am";
    private static final String CLAVE = "proy_int_am";

    private static Connection instancia;

    public Connection abrir() {
        if (!estaActiva()) {
            inicializarConexion();
        }
        return instancia;
    }

    public static void cerrar() {
        if (estaActiva()) {
            try {
                instancia.close();
                System.out.println("Sesión con Oracle cerrada");
            } catch (SQLException ex) {
                System.out.println("Error al finalizar la sesión: " + ex.getMessage());
            }
        }
    }

    private static boolean estaActiva() {
        try {
            return instancia != null && !instancia.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

    private static void inicializarConexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            instancia = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Sesión con Oracle iniciada");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No fue posible iniciar sesión: " + ex.getMessage());
        }
    }
}
