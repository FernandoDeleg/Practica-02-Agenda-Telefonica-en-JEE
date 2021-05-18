package ec.edu.ups.DAO;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JDBCDAOFactory();
	public static DAOFactory getFactory(){
		return factory;
	}
	
	public void createTables() {};
	public abstract UsuarioDao getUsuarioDao();
	public abstract TelefonoDao getTelefonoDao();
}
