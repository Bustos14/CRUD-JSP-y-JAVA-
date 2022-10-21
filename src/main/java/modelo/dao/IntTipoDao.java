package modelo.dao;

import java.util.List;

import modelo.javabeans.Tipo;

public interface IntTipoDao {

	Tipo buscarTipoId(int idTipo);
	List<Tipo> buscarTodos();
}
