package pe.edu.upc.onewebs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.onewebs.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByUsername(String username ) throws Exception;
}
