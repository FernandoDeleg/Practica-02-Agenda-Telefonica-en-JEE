package ec.edu.ups.conexion;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContextJDBC {
	private final String driverName="com.mysql.jdbc.Driver";
	private final String conexionUrl="jdbc:mysql://localhost:3306/agenda";
	private final String nombreusuario="agenda";
	private final String contrasena="agenda";
	
	private static ContextJDBC jdbc=null;
	private Statement statement=null;
	
	public ContextJDBC() {this.crearconexion();}
	public static ContextJDBC getJDBC() {
		if(jdbc == null) 
			jdbc=new ContextJDBC();
		return jdbc;
	}
	
	private void crearconexion() {
		try {
			Class.forName(driverName);
			Connection connection = DriverManager.getConnection(conexionUrl, nombreusuario,contrasena);
			this.statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Problemas con la DB");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas con el Driver");
			e.printStackTrace();
			
		}
		
	}
	
	public ResultSet query(String sql) {
		try {
			return this.statement.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean update(String sql) {
		try {
			this.statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
