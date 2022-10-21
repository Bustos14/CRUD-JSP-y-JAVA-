package modelo.dao;

import java.util.List;
import modelo.javabeans.Evento;

public interface IntEventoDao {
	
	List<Evento> buscarActivos();
	List<Evento> buscarTodos();
	Evento buscarUno(int idEvento);
	int altaEvento(Evento evento);
	boolean eliminarEvento(Evento evento);
	int cancelarEvento (Evento evento);
}
