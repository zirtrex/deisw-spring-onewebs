package pe.edu.upc.onewebs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comisarias")
@Getter
@Setter
public class Comisaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Es obligatorio la denominación")
	@Column(name = "denominacion", length = 30, nullable = false)	
	private String denominacion;
	
	@NotBlank(message = "Por favor, ingrese el distrito")
	@Column(name = "distrito", length = 35, nullable = false)
	private String distrito;
	
	@NotBlank(message = "Coloque dirección")
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion; 
	
	// mappedBy: El objeto de relacion
	@ManyToMany(mappedBy = "comisarias")
	private List<Detenido> detenidos;	
	
	public Comisaria() {
		detenidos = new ArrayList<>();
	}
	public void addDetenido(Detenido detenido) {
		detenidos.add(detenido);
	}

}












