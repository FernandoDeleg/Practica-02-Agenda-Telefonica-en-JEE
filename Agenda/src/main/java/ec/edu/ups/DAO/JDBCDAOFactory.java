package ec.edu.ups.DAO;

public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		// TODO Auto-generated method stub
		this.getUsuarioDao().createTable();
	}
	
	@Override
	public UsuarioDao getUsuarioDao() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}

	@Override
	public TelefonoDao getTelefonoDao() {
		// TODO Auto-generated method stub
		return new JDBCTelefonoDAO();
	}

}
