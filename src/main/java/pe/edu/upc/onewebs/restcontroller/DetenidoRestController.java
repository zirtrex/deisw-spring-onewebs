package pe.edu.upc.onewebs.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.onewebs.entity.Detenido;
import pe.edu.upc.onewebs.entity.Multa;
import pe.edu.upc.onewebs.service.DetenidoService;
import pe.edu.upc.onewebs.service.MultaService;
/***
 * 
 * @author USUARIO
 *	
 *	/onewebs/api/detainees
 *		GET, POST
 *
 *	/onewebs/api/detainees/{id}
 *		GET, DELETE, PUT
 *
 *	/onewebs/api/detainees/{id}/mulcts
 *		GET, POST, 
 */
@RestController
@RequestMapping("/onewebs/api/detainees")
public class DetenidoRestController {
	
	@Autowired
	private DetenidoService detenidoService; 
	
	@Autowired
	private MultaService multaService;
	
	// Obteniendo todos los detenidos
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Detenido> > start() {
		try {
			List<Detenido> detenidos = detenidoService.readAll();
			return new ResponseEntity< List<Detenido> >(detenidos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Grabar un detenido
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Detenido > saveDetainee( @RequestBody Detenido detenido ) {
		try {
			Detenido newDetenido = detenidoService.create(detenido);
			return new ResponseEntity< Detenido >(newDetenido, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Detenido >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Buscando un detenido por Id
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Detenido > fetchById( @PathVariable("id") Integer id ) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				return new ResponseEntity< Detenido >( optional.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity< Detenido >( HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Detenido >( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Eliminar un detenido por id
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< ? > deleteById( @PathVariable("id") Integer id ) {
		try {
			// BUscar si existe el detenido
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				detenidoService.deleteById(id);
				return new ResponseEntity<>( HttpStatus.OK);
			}
			else {
				return new ResponseEntity< String >( "El id no existe", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< >( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// Actualizando un detenido por id
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< ? > updateById( @PathVariable("id") Integer id, @RequestBody Detenido detenido ) {
		try {
			if (id == detenido.getId()) {
				// Buscar si existe el detenido
				Optional<Detenido> optional = detenidoService.findById(id);
				if( optional.isPresent() ) {
					Detenido updateDetenido = detenidoService.update(detenido);
					return new ResponseEntity< Detenido >(updateDetenido, HttpStatus.OK);
				}
				else {
					return new ResponseEntity< String >( "El id no existe", HttpStatus.NOT_FOUND);
				}
			}
			else {
				return new ResponseEntity< >( HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity< >( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Devuelve todas las multas de un detenido
	@GetMapping(path = "/{id}/mulcts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Multa> > fetchMulctsById( @PathVariable("id") Integer id ) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				List<Multa> multas = optional.get().getMultas();
				return new ResponseEntity< List<Multa> >( multas, HttpStatus.OK);
			}
			else {
				return new ResponseEntity< List<Multa> >( HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< List<Multa> >( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// Grabar un detenido
	@PostMapping(path = "/{id}/mulcts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Multa > saveMulctDetainee( @PathVariable("id") Integer id, @RequestBody Multa multa ) {
		try {
			if (id == multa.getDetenido().getId()) {
				Optional<Detenido> optional = detenidoService.findById(id);
				if( optional.isPresent() ) {
					multa.setDetenido(optional.get());
					Multa newMulta = multaService.create(multa);
					return new ResponseEntity< Multa >( newMulta, HttpStatus.CREATED );
				}
				else {
					return new ResponseEntity< Multa >( HttpStatus.NOT_FOUND);
				}
			}
			else {
				return new ResponseEntity< >( HttpStatus.BAD_REQUEST);
			}				
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity< Multa >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
			
	
	
}
