# Practica-02-Agenda-Telefonica-en-JEE
 	
PRÁCTICA DE LABORATORIO
CARRERA: INGENIERIA DE SISTEMAS	ASIGNATURA: APLICACIONES DISTRIBUIDAS

NRO. PRÁCTICA:	
2	TÍTULO PRÁCTICA: Desarrollo de una aplicación JEE basado en Servlets, JSP y JDBC
para el intercambio de datos en un modelo de tres capas aplicando los patrones diseño de software MVC y DAO
OBJETIVOS
•	Diseña y desarrolla modelos de software en diferentes niveles de abstracción y modelos de datos a nivel transaccional y analítico con entornos de desarrollo actuales

















INSTRUCCIONES	
Se pide desarrollar una aplicación JEE que permita implementar una agenda telefónica en donde se tendrán usuarios con datos como cedula, nombres, apellidos, correo y contraseña. Y cada uno de estos usuarios podrá tener asignado uno o más teléfonos de contacto de diferente tipo y operador, por ejemplo:

•	El usuario “Juanito” tiene los teléfonos 0998121212 de tipo celular y operadora Movistar; así como también tiene asignado el teléfono 0728222111 de tipo convencional y operador CNT.

Para lo cual, se propone el siguiente diagrama de clases:

 

 

 


 
Los requerimientos funcionales del sistema son:
•	Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.
•	Un usuario puede iniciar sesión usando su correo y contraseña.
•	Una vez iniciado sesión el usuario podrá:
 

	o	Registrar, modificar, eliminar, buscar y listar sus teléfonos
o	Listar los números de teléfono de un usuario usando su número de cédula o correo electrónico
o	Podrá llamar o enviar un correo electrónico desde el sistema usando aplicaciones externas.
	•	Los datos siempre deberán ser validados cuando se trabaje a través de formularios.
De igual manera, se pide manejar sesiones y filtros para que exista seguridad en el sistema de agenda telefónica. Por lo qué, debe existir una parte pública y una privada. La parte privada ha sido descrita en los requisitos antes planteados. Y la parte pública será una página index.html a través de la cual podrán acceder al sistema. No obstante, se debe generar una página con la experiencia e interfaz de usuario apropiada, como la que se muestra en la Fig 3. Finalmente, el sistema de agenda telefónica debe aplicar los patrones de diseño de software MVC y DAO, en donde, el modelo será clases POJOs de Java, la vista será JSP
+ JSTL y los controladores serán a través de DAOs y Servlets.

 


Fig 3. Pagina pública index.html propuesta para el sistema de agenda telefónica

ACTIVIDADES POR DESARROLLAR
 




1.	Desarrollar una aplicación con tecnología JEE para gestionar requerimientos de una agenda telefónica.

Creación de los paquetes y clases:
Como punto de partida empezamos por las clases y el paquete en donde se encuentran es en el ec.edu.ups.modelo.
 
Dentro de la clase Telefono tenemos el siguiente código:
package ec.edu.ups.modelo;

import java.io.Serializable;

public class Telefono implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String numero;
	private String tipo;
	private String operadora;
	private Usuario usuario;
	
	public Telefono() {
		super();
	}

	public Telefono(int id, String numero, String tipo, String operadora) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}

	public Telefono(int id, String numero, String tipo, String operadora, Usuario usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.usuario = usuario;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario=" + usuario + "]";
	}	
}

Dentro de la clase Usuario tenemos el siguiente código:
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String password;
	private List<Telefono> listatelefonos;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String cedula, String nombres, String apellidos, String correo, String password) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
	}
	
	public Usuario(List<Telefono> listatelefonos) {
		super();
		this.listatelefonos = listatelefonos;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Telefono> getListatelefonos() {
		return listatelefonos;
	}

	public void setListatelefonos(List<Telefono> listatelefonos) {
		this.listatelefonos = listatelefonos;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", password=" + password + "]";
	}
}


Como siguiente se debe realizar la creación de los siguientes paquetes:

 


Dentro del paquete conexión tenemos la clase en donde vamos a realizar la conexión con la base de datos mysql con el siguiente código:

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


A continuación, tenemos el paquete ec.edu.ups.DAO que contiene las siguientes clases:

 
En el paquete ec.edu.ups.filtro tenemos una única clase:
 

En el paquete ec.edu.ups.servlets tenemos los siguientes servlets:

 


Para la parte de la interfaz se utilizó Bootstrap para tener una interfaz mucho mas interactiva para el usuario:

 



Interfaz de inicio:

 


Se tiene una pagina de inicio en donde se puede encontrar un poco de información de la aplicación y su uso.
La parte de Login esta de la siguiente manera:

 

Como cualquier otro Login se debe tener registrado el correo y la contraseña caso contrario deberá ir al botón de “Registrarme” y llenar el formulario que se muestra a continuación.

 
Al llenar ese formulario los datos se guardarán en la base de datos de MySQL.






Una vez se tenga registrado podremos acceder mediante nuestro correo y contraseña, dándonos la siguiente interfaz:

 

Como vemos tenemos varias opciones que podemos aplicar como puede ser dar click en el botón “Nuevo Teléfono”, Listar mis Números o ingresamos en la barra de búsqueda ya sea la cédula o el correo de cualquier contacto que exista.

Nuevo Teléfono:
Esta parte es en donde se van a ingresar los números que posea el usuario, llenando la siguiente interfaz:
 
Listar mis Números:
Al dar click en ese botón se van a listar todos los números propios que registramos para ese usuario.

Por último, tenemos la barra de búsqueda donde tenemos que ingresar la cédula o el correo del usuario que queramos saber su número y poder realizar así una llamada o enviar un correo:

 









CONCLUSIONES:
•	Los estudiantes podrán implementar sistemas JEE basado en Servlets, JSP y JDBC.
RECOMENDACIONES:
•	Aplicar conceptos de interacción humano máquina para el desarrollo de la GUI.




                                                           
Est.Roberto Pacho							Est.Fernando Deleg
