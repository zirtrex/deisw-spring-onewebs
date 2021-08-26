package pe.edu.upc.onewebs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.onewebs.entity.Comisaria;
import pe.edu.upc.onewebs.repository.ComisariaRepository;
import pe.edu.upc.onewebs.service.ComisariaService;

@Service 
public class ComisariaServiceImpl implements ComisariaService {

	@Autowired
	private ComisariaRepository comisariaRepository; 
	
	@Override
	@Transactional
	public Comisaria create(Comisaria entity) throws Exception {
		return comisariaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comisaria> readAll() throws Exception {
		return comisariaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Comisaria> findById(Integer id) throws Exception {
		return comisariaRepository.findById(id);
	}

	@Override
	@Transactional
	public Comisaria update(Comisaria entity) throws Exception {
		return comisariaRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		comisariaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		comisariaRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comisaria> findByDistrito(String distrito) throws Exception {
		return comisariaRepository.findByDistrito(distrito);
	}

}
