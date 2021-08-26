package pe.edu.upc.onewebs.service;

import java.util.List;

import pe.edu.upc.onewebs.entity.Comisaria;

public interface ComisariaService extends CrudService<Comisaria, Integer> {
	List<Comisaria> findByDistrito( String distrito ) throws Exception;
}
