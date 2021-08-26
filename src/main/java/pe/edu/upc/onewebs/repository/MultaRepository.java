package pe.edu.upc.onewebs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.onewebs.entity.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {
	@Query("SELECT m FROM Multa m WHERE m.monto > :monto")
	List<Multa> fetchByMayorMonto( double monto ) throws Exception;	
}
