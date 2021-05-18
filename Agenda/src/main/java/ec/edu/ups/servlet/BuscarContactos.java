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

/**
 * Servlet implementation class BuscarContactos
 */
@WebServlet("/BuscarContactos")
public class BuscarContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarContactos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TelefonoDao telefonoDao= DAOFactory.getFactory().getTelefonoDao();
		String buscar=request.getParameter("buscar");
		String act = request.getParameter("listar");
		
		if(buscar != null) {
			List<Telefono> list = telefonoDao.listContactos(buscar);
			request.setAttribute("listarO", list);
			RequestDispatcher rd;
			rd= request.getRequestDispatcher("/agendaVista.jsp");
			rd.forward(request, response);
		}else if(act.equals("listar")) {
			List<Telefono> list = telefonoDao.listContactos((String) request.getSession().getAttribute("usercorreo"));
			request.setAttribute("listar", list);
			RequestDispatcher rd;
			rd= request.getRequestDispatcher("/agendaVista.jsp");
			rd.forward(request, response);
		}
	}

}
