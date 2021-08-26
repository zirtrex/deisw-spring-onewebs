package pe.edu.upc.onewebs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.onewebs.entity.Detenido;

@Repository
public interface DetenidoRepository extends JpaRepository<Detenido, Integer> {
	Optional<Detenido> findByDni(String dni) throws Exception;
	List<Detenido> findByApellidos( String apellidos ) throws Exception;
	List<Detenido> findByNombres( String nombres ) throws Exception;
	List<Detenido> findByDistrito( String distrito ) throws Exception;
	
	@Query("SELECT d FROM Detenido d WHERE d.apellidos like %:apellidos%")
	List<Detenido> fetchByApellidos( String apellidos ) throws Exception;
}
