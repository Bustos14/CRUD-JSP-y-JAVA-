package modelo.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.javabeans.Evento;
import modelo.javabeans.Tipo;

public class EventoDaoImpl implements IntEventoDao {

	private List<Evento> listadoEventos;

	public EventoDaoImpl() {
		listadoEventos = new ArrayList<>();
		cargarDatos();
	}

	//Cargamos el array con los datos
	private void cargarDatos() {
		IntTipoDao tipo = new TipoDaoImpl();
		listadoEventos.add(new Evento(1, "Boda", "Boda Paquito y Sara", new Date(), 10, "Calle evento numero 1",
				"Activo", true, 200, 100, 3500.2, tipo.buscarTipoId(1)));
		listadoEventos.add(new Evento(2, "Comunión", "Comunión de María", new Date(), 10, "Calle evento numero 2",
				"Activo", true, 200, 100, 3500.2, tipo.buscarTipoId(2)));
		listadoEventos.add(new Evento(3, "Bautizo", "Bautizo de Roberto", new Date(), 10, "Calle evento numero 3",
				"Activo", true, 200, 100, 3500.2, tipo.buscarTipoId(3)));
		listadoEventos.add(new Evento(4, "Cumpleaños", "Cumpleaños de Sara", new Date(), 10, "Calle evento numero 4",
				"Activo", true, 200, 100, 3500.2, tipo.buscarTipoId(5)));
		listadoEventos.add(new Evento(5, "Despedida de soltero", "Despedida de Paquito", new Date(), 10,
				"Calle evento numero 5", "Activo", true, 200, 100, 3500.2, tipo.buscarTipoId(4)));
	}

	public List<Evento> getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(List<Evento> listadoEventos) {
		this.listadoEventos = listadoEventos;
	}

	@Override
	//Añado al listado un evento siempre y cuando NO este contenido en el propio listado
	public int altaEvento(Evento evento) {
		if (!listadoEventos.contains(evento)) {
			listadoEventos.add(evento);
			return 1;
		}
		return 0;
	}
	@Override
	//Borro del listado el evento que paso por parametro
	public boolean eliminarEvento(Evento evento) {
		return listadoEventos.remove(evento);
	}

	@Override
	//Pongo el estado del evento que pasamos por parametro en "Cancelado"
	public int cancelarEvento(Evento evento) {
		if (listadoEventos.contains(evento)) {
			evento.setEstado("Cancelado");
			return 1;
		}
		return 0;
	}

	@Override
	public List<Evento> buscarActivos() {

		//Creo una lista auxiliar
		List<Evento> aux = new ArrayList<Evento>();
		//Si el listado base no es nulo, lo recorro y añado todos los objetos con estado: Activo
		if (listadoEventos != null) {
			for (Evento e: listadoEventos) {
				if (e.getEstado().equals("Activo")) {
					aux.add(e);
				}
			}
			//Retorno el listado auxiliar
			return aux;
		} else {
			System.out.println("Listado vacio");
		}
		return null;

	}

	@Override
	public Evento buscarUno(int idEvento) {
		Evento aux = new Evento();
		aux.setIdEvento(idEvento);
		int pos = listadoEventos.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return (listadoEventos.get(pos));
		}

	}

	@Override
	public List<Evento> buscarTodos() {
		return listadoEventos;
	}

}
