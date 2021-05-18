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
