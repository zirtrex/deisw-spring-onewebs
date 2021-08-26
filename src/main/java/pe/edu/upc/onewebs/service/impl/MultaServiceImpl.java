package pe.edu.upc.onewebs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.onewebs.entity.Multa;
import pe.edu.upc.onewebs.repository.MultaRepository;
import pe.edu.upc.onewebs.service.MultaService;

@Service
public class MultaServiceImpl implements MultaService {

	@Autowired
	private MultaRepository multaRepository;
	
	@Override
	@Transactional
	public Multa create(Multa entity) throws Exception {
		return multaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Multa> readAll() throws Exception {
		return multaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Multa> findById(Integer id) throws Exception {
		return multaRepository.findById(id);
	}

	@Override
	@Transactional
	public Multa update(Multa entity) throws Exception {
		return multaRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		multaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		multaRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Multa> fetchByMayorMonto(double monto) throws Exception {
		return multaRepository.fetchByMayorMonto(monto);
	}

}
