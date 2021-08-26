package pe.edu.upc.onewebs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "denuncias")
@Getter
@Setter
public class Denuncia {
	@Id
	private Long id;
	
	@NotBlank(message = "Es obligatorio el denunciante")
	@Column(name = "denunciante", length = 50, nullable = false)	
	private String denunciante;
	
	@NotBlank(message = "Es obligatorio la manifestación")
	@Column(name = "manifestacion", nullable = false)
	private String manifestacion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
}
