package pe.edu.upc.onewebs.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.onewebs.entity.Detenido;

public interface DetenidoService extends CrudService<Detenido, Integer> {
	Optional<Detenido> findByDni(String dni) throws Exception;
	List<Detenido> findByApellidos( String apellidos ) throws Exception;
	List<Detenido> findByNombres( String nombres ) throws Exception;
	List<Detenido> findByDistrito( String distrito ) throws Exception;
	List<Detenido> fetchByApellidos( String apellidos ) throws Exception;
}
