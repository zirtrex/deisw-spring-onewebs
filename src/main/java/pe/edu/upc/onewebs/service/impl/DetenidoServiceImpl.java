package pe.edu.upc.onewebs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.onewebs.entity.Detenido;
import pe.edu.upc.onewebs.repository.DetenidoRepository;
import pe.edu.upc.onewebs.service.DetenidoService;

@Service
public class DetenidoServiceImpl implements DetenidoService {

	@Autowired
	private DetenidoRepository detenidoRepository;
	
	@Override
	@Transactional
	public Detenido create(Detenido entity) throws Exception {
		return detenidoRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detenido> readAll() throws Exception {
		return detenidoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detenido> findById(Integer id) throws Exception {
		return detenidoRepository.findById(id);
	}

	@Override
	@Transactional
	public Detenido update(Detenido entity) throws Exception {
		return detenidoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		detenidoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		detenidoRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detenido> findByDni(String dni) throws Exception {
		return detenidoRepository.findByDni(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detenido> findByApellidos(String apellidos) throws Exception {
		return detenidoRepository.findByApellidos(apellidos);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detenido> findByNombres(String nombres) throws Exception {
		return detenidoRepository.findByNombres(nombres);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detenido> findByDistrito(String distrito) throws Exception {
		return detenidoRepository.findByDistrito(distrito);
	}

	@Override
	public List<Detenido> fetchByApellidos(String apellidos) throws Exception {
		return detenidoRepository.fetchByApellidos(apellidos);
	}

}
