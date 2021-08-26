package pe.edu.upc.onewebs.service;

import java.util.Optional;

import pe.edu.upc.onewebs.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername( String username ) throws Exception;
}
