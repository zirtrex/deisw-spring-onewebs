package pe.edu.upc.onewebs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.onewebs.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}
