package ec.edu.ups.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.DAO.DAOFactory;
import ec.edu.ups.DAO.UsuarioDao;
import ec.edu.ups.conexion.ContextJDBC;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String usercorreo= request.getParameter("usercorreo");
		String passwprd=request.getParameter("password");
		
		UsuarioDao usuarioDao = DAOFactory.getFactory().getUsuarioDao();
		Usuario usuario=usuarioDao.readLogin(usercorreo, passwprd);
		
		try {
			String act = request.getParameter("act");
			if(act.equals("Iniciar Sesion")) {
				
				if(usuario != null) {
					request.getSession().setAttribute("usercorreo",usercorreo );
					response.sendRedirect("agendaVista.jsp");
				}else {
					request.setAttribute("error", "Aun no te has Registrado");
					response.sendRedirect("loginVista.jsp");
				}
			}else if(act.equals("Registrarme")) {
				response.sendRedirect("registroVista.jsp");
			}else if (act.equals("Salir")) {
				response.sendRedirect("index.html");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			out.println("error aqui: "+e );
		}
	}

}
