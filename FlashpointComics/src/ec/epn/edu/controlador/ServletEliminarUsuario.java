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
 * Servlet implementation class ServletEliminarUsuario
 */
@Transactional
@WebServlet("/ServletEliminarUsuario")
public class ServletEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "ComicPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u = em.find(Usuario.class, Integer.valueOf(request.getParameter("id")));
		em.remove(u);
		request.getRequestDispatcher("ServletListaUsuarios").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
