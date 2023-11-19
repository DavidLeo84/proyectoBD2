package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";//XE
	private static final String USERNAME = "C_TRAVEL";
	private static final String PASSWORD = "123456";

	public Conexion() {

	}
	
	public static Connection conectar() {

		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("CONNECCION ESTABLECIDA");
		} catch (ClassNotFoundException e) {
	        System.out.println("Error al cargar el controlador: " + e.getMessage());
	        e.printStackTrace();
	    } catch (SQLException e) {
	        System.out.println("Error al conectar a la base de datos: " + e.getMessage());
	        e.printStackTrace();
	    }

		return connection;
	}
	
	 public static void desconectar(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
    	        System.out.println("DESCONECTAR ");
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar el error seg�n tus necesidades
        }
    }


	
}
