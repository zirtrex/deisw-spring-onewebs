package pe.edu.upc.onewebs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "apelacion")
@Getter
@Setter
public class Apelacion {
	@Id
	private Long id;
	
	@NotBlank(message = "Es obligatorio el apelador")
	@Column(name = "apelador", length = 50, nullable = false)	
	private String apelador;
}
