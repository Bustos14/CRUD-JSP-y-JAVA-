package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.EventoDaoImpl;
import modelo.dao.IntEventoDao;
import modelo.dao.IntTipoDao;
import modelo.dao.TipoDaoImpl;
import modelo.javabeans.Evento;
import modelo.javabeans.Tipo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IntEventoDao eDao = new EventoDaoImpl();
		List<Evento> lista = null;
		List<Evento> listaEnSesion = (List<Evento>) request.getSession().getAttribute("listado");
		if (listaEnSesion == null) {
			lista = eDao.buscarActivos();
		} else {
			((EventoDaoImpl)eDao).setListadoEventos(listaEnSesion);
			lista = ((EventoDaoImpl) eDao).getListadoEventos();
		}
		request.setAttribute("eventos", lista);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
