package ec.epn.edu.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.epn.edu.modelo.Comic;

/**
 * Servlet implementation class MuestraComic
 */
@WebServlet("/MuestraComic")
public class MuestraComic extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@PersistenceContext (unitName="ComicPU")
	private EntityManager em;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuestraComic() {
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
		
		
		FileInputStream ficheroInput = new FileInputStream( "C:\\Users\\ALEX\\eclipse-workspace\\PROYECTO-FlashpointComics\\FlashpointComics\\WebContent\\COMINCS_PDF\\"+l.getCmc_comic());
		int tamanoInput = ficheroInput.available();
		byte[] datosPDF = new byte[tamanoInput];
		ficheroInput.read( datosPDF, 0, tamanoInput);
		 
		response.setHeader("Content-disposition","inline; filename=comic.pdf" );
		response.setContentType("application/pdf");
		response.setContentLength(tamanoInput);
		response.getOutputStream().write(datosPDF);
		ficheroInput.close();	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
