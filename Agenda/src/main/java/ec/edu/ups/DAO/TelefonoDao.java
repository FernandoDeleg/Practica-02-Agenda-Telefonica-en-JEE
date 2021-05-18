package ec.edu.ups.DAO;

import java.util.List;

import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public interface TelefonoDao extends GenericDAO<Telefono, Integer> {
	public int contadorTelefono();
	public List<Telefono> listContactos(String cedula);
	public Usuario usuario(String cedula);
}
