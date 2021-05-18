package ec.edu.ups.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ec.edu.ups.modelo.Usuario;

public interface UsuarioDao extends GenericDAO<Usuario, Integer> {
	//metodos que son aparte
	public Usuario readLogin(String correo, String password);
	public String buscarCedula(String correo);
	public Usuario readUsuario(String correo);
	public Usuario readCedula(String cedula);
}
