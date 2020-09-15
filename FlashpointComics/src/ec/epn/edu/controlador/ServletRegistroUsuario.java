package ec.epn.edu.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import ec.epn.edu.modelo.Usuario;



/**
 * Servlet implementation class ServletRegistroUsuario
 */
@Transactional
@WebServlet("/ServletRegistroUsuario")
public class ServletRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistroUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Nombre = request.getParameter("username");
		String Email = request.getParameter("Email");
		String Contraseña = request.getParameter("password");
		String RepetirContraseña = request.getParameter("Repitepassword");

		if (Nombre.trim().equals("") || Email.trim().equals("") || Contraseña.trim().equals("")
				|| RepetirContraseña.trim().equals("")) {
			request.setAttribute("valUser", Nombre);
			request.setAttribute("valEmail", Email);
			request.setAttribute("valContraseña", Contraseña);
			request.setAttribute("valContraseña", RepetirContraseña);
			request.setAttribute("valError", "Por favor LLenar todos los campos ");
			request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
		} else if (!Contraseña.equals(RepetirContraseña)) {
			System.out.println(Contraseña + RepetirContraseña);
			request.setAttribute("valUser", Nombre);
			request.setAttribute("valEmail", Email);
			request.setAttribute("valContraseña", Contraseña);
			request.setAttribute("valRepiteContraseña", RepetirContraseña);
			request.setAttribute("valError", "Las contraseñas no coinciden ");
			request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
		} else {
			
			Usuario U = new Usuario();
			U.setNombre(Nombre);
			U.setEmail(Email);			
			U.setContraseña(Contraseña);			
			
			em.persist(U);

			System.out.println(
					"Datos de usuario a guardar: Nombre:" + Nombre + " email: " + Email + " Contraseña:" + Contraseña);
			request.getRequestDispatcher("ServletListaUsuarios").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
