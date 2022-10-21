package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class GestionEventos
 */
@WebServlet("/eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IntEventoDao eDao = new EventoDaoImpl();
	private List<Evento> listaEvento = eDao.buscarActivos();
	private IntTipoDao tipo = new TipoDaoImpl();
	List<Tipo> listaTipo = tipo.buscarTodos();
	String mensaje;

	public GestionEventos() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "eliminar":
			procEliminarEvento(request, response);
			break;
		case "alta":
			procNuevoEvento(request, response);
			break;
		case "editar":
			procEditarEvento(request, response);
			break;
		case "cancelar":
			procCancelarEvento(request, response);
			break;
		// Prueba de reset para comprobar que funciona el borrado de sesión
		/*
		 * case "reset": procReset(request, response); break;
		 */
		case "activo":
			procActivos(request, response);
			break;
		case "todos":
			procTodos(request, response);
			break;
		}
	}

	// Procedimiento de control para eliminar un evento en funcion a su id
	protected void procEliminarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Evento ev = eDao.buscarUno(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("eventos", eDao.eliminarEvento(ev));
		request.getSession().setAttribute("listado", eDao.buscarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);

	}

	// Procedimiento de control para eliminar un evento en funcion a su id
	protected void procActivos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mensaje = "Eventos activos";
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listado", eDao.buscarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);

	}

	// Procedimiento de control para eliminar un evento en funcion a su id
	protected void procTodos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mensaje = "Todos los eventos";
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listado", eDao.buscarTodos());
		request.getRequestDispatcher("inicio").forward(request, response);

	}

	// Procedimiento para dar de alta nuevo evento
	protected void procNuevoEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creo un evento vacio
		Evento ev = new Evento();
		// Busco el listado de eventos existentes para obtener la ultima ID de los
		// eventos y poder hacer que el nuevo evento tenga
		// el id del anterior + 1.
		List<Evento> listEv = eDao.buscarTodos();
		int autoId = listEv.get(listEv.size() - 1).getIdEvento() + 1;
		// Agrego datos al evento anteriormente inicializado. Estos datos se recogen a
		// través del formulario
		ev.setIdEvento(autoId);
		ev.setNombre(request.getParameter("nombre"));
		ev.setDescripcion(request.getParameter("descripcion"));
		ev.setFechaInicio(new Date());
		ev.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		ev.setEstado("Activo");
		ev.setAforoMax(Integer.parseInt(request.getParameter("aforoMax")));
		ev.setAsistMin(Integer.parseInt(request.getParameter("asisMin")));
		ev.setPrecioDec(Double.parseDouble(request.getParameter("precio")));
		// Creo un objeto tipo
		Tipo t = new Tipo();
		// Compruebo si la ID del evento que han introducido esta entre 1 y 5, ya que
		// son los eventos existentes
		// para en caso de que no sea asi, asignarle el tipo 1 por defecto y evitar
		// errores
		if (Integer.parseInt(request.getParameter("idTipo")) < 1
				|| Integer.parseInt(request.getParameter("idTipo")) > 5) {
			t = tipo.buscarTipoId(1);
		} else {
			t = tipo.buscarTipoId(Integer.parseInt(request.getParameter("idTipo")));
		}
		ev.setIdTipo(t);
		if (eDao.altaEvento(ev) == 1) {
			mensaje = "Se ha añadido el evento: "+ev.getIdEvento();
		} else {
			mensaje = "Hubo un error en el alta";
		}
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listado", eDao.buscarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);
	}

	// Procedimiento de pruebas para resetear la sesión y comprobar que funciona
	// bien el eliminar
	/*
	 * protected void procReset(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * request.getSession().invalidate();
	 * request.getRequestDispatcher("inicio").forward(request, response);
	 * 
	 * }
	 */

	// Busco el objeto por ID y lo paso al atribuo editEvento para mostarlo en
	// pantalla
	protected void procEditarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Evento ev = eDao.buscarUno(Integer.parseInt(request.getParameter("id")));
		mensaje = "Datos del evento: "+ev.getIdEvento();
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("editEvento", ev);
		request.getRequestDispatcher("inicio").forward(request, response);
		;
	}

	// Cancelo el evento por ID
	protected void procCancelarEvento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Evento ev = eDao.buscarUno(Integer.parseInt(request.getParameter("id")));
		if(eDao.cancelarEvento(ev)==1) {
			mensaje = "Evento "+ ev.getIdEvento() + " cancelado";
			request.setAttribute("eventos", eDao.cancelarEvento(ev));
		}else {
			mensaje ="No se pudo cancelar el evento" ;
		}
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("listado", eDao.buscarActivos());
		request.getRequestDispatcher("inicio").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
