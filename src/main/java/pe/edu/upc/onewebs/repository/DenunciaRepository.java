package pe.edu.upc.onewebs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.onewebs.entity.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

}
