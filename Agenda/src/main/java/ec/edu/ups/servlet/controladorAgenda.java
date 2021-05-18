package ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.TelefonoDao;
import ec.edu.ups.DAO.UsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class controladorAgenda
 */
@WebServlet("/controladorAgenda")
public class controladorAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorAgenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cod= request.getParameter("id");
		TelefonoDao telefonoDao=DAOFactory.getFactory().getTelefonoDao();
		telefonoDao.delete(telefonoDao.read(Integer.parseInt(cod)));
		
		String num=request.getParameter("numero");
		System.out.println(num);
		response.sendRedirect("agendaVista.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo=0;
		TelefonoDao telefonoDao=DAOFactory.getFactory().getTelefonoDao();
		UsuarioDao usuarioDao=DAOFactory.getFactory().getUsuarioDao();
		RequestDispatcher rd;
		request.getSession().getAttribute("usercorreo");
		String correo=(String) request.getSession().getAttribute("usercorreo");
		
		try {		
			
			codigo= telefonoDao.contadorTelefono()+1;
			Usuario usuario=usuarioDao.readUsuario(correo);
			String act = request.getParameter("act");
			if(act.equals("guardar")) {
				Telefono telefono=new Telefono(codigo, request.getParameter("numero"), request.getParameter("tipo"), request.getParameter("operadora"), usuario);
				telefonoDao.create(telefono);
				response.sendRedirect("agendaVista.jsp");
			}else if (act.equals("actualizar") & codigo != 0) {
				codigo=Integer.valueOf(request.getParameter("cod"));
				Telefono telefono=new Telefono(codigo, request.getParameter("numero"), request.getParameter("tipo"), request.getParameter("operadora"), usuario);
				telefonoDao.update(telefono);
				response.sendRedirect("agendaVista.jsp");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
