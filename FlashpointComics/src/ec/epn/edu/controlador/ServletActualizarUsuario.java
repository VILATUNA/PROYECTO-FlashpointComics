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
 * Servlet implementation class ServletActualizarUsuario
 */
@Transactional
@WebServlet("/ServletActualizarUsuario")
public class ServletActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActualizarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String contraseña = request.getParameter("contraseña");
		if (nombre.trim().equals("") || email.trim().equals("") || contraseña.trim().equals("")||id == null) {
			request.setAttribute("valId", String.valueOf(id));
			request.setAttribute("valUser", nombre);
			request.setAttribute("valEmail", email);
			request.setAttribute("valContraseña", contraseña);
			request.setAttribute("valError", "Por favor LLenar todos los campos ");
			request.getRequestDispatcher("EditarUsuario.jsp").forward(request, response);
		} else {
			Usuario u = em.find(Usuario.class, id);
			u.setNombre(nombre);
			u.setEmail(email);
			u.setContraseña(contraseña);
			em.persist(u);
			request.getRequestDispatcher("ServletListaUsuarios").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
