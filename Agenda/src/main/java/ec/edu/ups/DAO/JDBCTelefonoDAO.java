package ec.edu.ups.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.conexion.ContextJDBC;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDao {

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Telefono telefono) {
		// TODO Auto-generated method stub
		System.out.println(telefono.getUsuario().getCedula());
		jdbc.update("INSERT telefono VALUES("
				+telefono.getId()+",'"+telefono.getNumero()+"','"+telefono.getTipo()+"','"+telefono.getOperadora()+"','"+telefono.getUsuario().getCedula()+"')");
		
	}

	@Override
	public Telefono read(Integer id) {
		Telefono telefono=null;
		ResultSet rs=jdbc.query("SELECT * FROM telefono where id="+id);
		try {
			if(rs != null && rs.next()) {
				telefono=new Telefono(rs.getInt("id"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (Telefono:read): " + e.getMessage());
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		// TODO Auto-generated method stub
		jdbc.update("UPDATE telefono SET numero='"+telefono.getNumero()+"', tipo='"+telefono.getTipo()+"', operadora='"+telefono.getOperadora()+"' where id="+telefono.getId());
	}

	@Override
	public void delete(Telefono telefono) {
		// TODO Auto-generated method stub
		jdbc.update("DELETE FROM telefono WHERE id="+telefono.getId());
	}

	@Override
	public List<Telefono> find() {
		// TODO Auto-generated method stub
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = jdbc.query("SELECT * FROM telefono");
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				String numero=rs.getString("numero");
				String tipo=rs.getString("tipo");
				String operadora=rs.getString("operadora");
				list.add(new Telefono(id,numero, tipo, operadora));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public int contadorTelefono() {
		// TODO Auto-generated method stub
		return find().size();
	}

	@Override
	public List<Telefono> listContactos(String buscar) {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs=null;
		UsuarioDao usuarioDao=DAOFactory.getFactory().getUsuarioDao();
		if(buscar.length()==10 ) {
			rs = jdbc.query("SELECT * FROM telefono where usu_cedula='"+buscar+"'");
		}else {
			rs = jdbc.query("SELECT * FROM telefono where usu_cedula='"+usuarioDao.buscarCedula(buscar)+"'");
		}
		
		try {
			while (rs.next()) {
				list.add(new Telefono(rs.getInt("id"), rs.getString("numero"), rs.getString("tipo"), rs.getString("operadora")));
				DAOFactory.getFactory().getTelefonoDao();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(">>>WARNING (JDBCTelefonoDAO:listContactos) : " + e.getMessage());
		}
		return list;
	}

	@Override
	public Usuario usuario(String cedula) {
		UsuarioDao usuarioDao=DAOFactory.getFactory().getUsuarioDao();
		Usuario usuario=usuarioDao.readCedula(cedula);
		return usuario;
	}

}
