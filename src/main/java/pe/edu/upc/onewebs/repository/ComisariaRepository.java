package pe.edu.upc.onewebs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.onewebs.entity.Comisaria;

@Repository
public interface ComisariaRepository extends JpaRepository<Comisaria, Integer> {
	List<Comisaria> findByDistrito( String distrito ) throws Exception;
}
