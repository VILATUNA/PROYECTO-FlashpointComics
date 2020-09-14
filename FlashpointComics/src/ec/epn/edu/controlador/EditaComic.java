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

import ec.epn.edu.modelo.Comic;


/**
 * Servlet implementation class EditaComic
 */
@Transactional
@WebServlet("/EditaComic")
public class EditaComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@PersistenceContext (unitName="ComicPU")
	private EntityManager em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditaComic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		Comic l =em.find(Comic.class,new Integer(idStr));
		request.setAttribute("comic", l);
	
		request.setAttribute("valId",idStr);
		request.setAttribute("valTitulo", l.getCmc_titulo());
		request.setAttribute("valAutor", l.getCmc_autor());
		request.setAttribute("valResumen", l.getCmc_resumen());
		request.setAttribute("valEdicion", l.getCmc_edicion());
		request.setAttribute("valIdioma", l.getCmc_idioma());
		request.setAttribute("valFechaPublic", l.getCmc_fecha_publicacion());
		request.setAttribute("valNumPag", l.getCmc_num_paginas().toString());
		request.setAttribute("valImagen", l.getCmc_imagen());
		request.setAttribute("valComic", l.getCmc_comic());	
			System.out.println("Datos del comic a Editar: titulo:" + l.getCmc_titulo() 
					 + " autor: " + l.getCmc_autor()+ " resumen:" + l.getCmc_resumen());
			
			request.getRequestDispatcher("editarComic.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
