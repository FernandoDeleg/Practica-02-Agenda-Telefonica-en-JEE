package ec.edu.ups.DAO;

import ec.edu.ups.conexion.ContextJDBC;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	protected ContextJDBC jdbc = ContextJDBC.getJDBC();
}
