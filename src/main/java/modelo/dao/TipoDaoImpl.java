package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Evento;
import modelo.javabeans.Tipo;

public class TipoDaoImpl implements IntTipoDao {
	private List<Tipo> listaTipos;

	public TipoDaoImpl() {
		listaTipos = new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {
		listaTipos.add(new Tipo(1, "Boda", "Boda genérica"));
		listaTipos.add(new Tipo(2, "Comunión", "Comunion genérica"));
		listaTipos.add(new Tipo(3, "Bautizo", "Bautizo genérico"));
		listaTipos.add(new Tipo(4, "Despedida", "Despedida genérica"));
		listaTipos.add(new Tipo(5, "Cumpleaños", "Cumpleaños genérica"));
	}

	@Override
	public Tipo buscarTipoId(int idTipo) {
		// Creamos evento auxiliar para ayudar en la busqueda, asignandole el id que buscamos
		Tipo aux = new Tipo();
		aux.setIdTipo(idTipo);
		// Buscamos la posición del tipo en el listado que tenemos, 
		//si nos devuelve un número distinto a -1, existe y lo retorna.
		int pos = listaTipos.indexOf(aux);
		if (pos == -1) {
			return null;
		} else {
			return (listaTipos.get(pos));
		}
	}

	@Override
	public List<Tipo> buscarTodos() {
		return listaTipos;
	}

}
