package pe.edu.upc.onewebs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "multas")
@Getter
@Setter
public class Multa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnoreProperties(value = "multas")
	@NotNull(message = "La multa require un detenido, por favor especifique el Detenido")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "detenido_id")
	private Detenido detenido;
	
	@Past(message = "Debe ser una fecha pasada")
	@Column(name = "fecha_detencion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDetencion;
	
	@NotBlank(message = "Coloque dirección")
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion;
	
	@NotBlank(message = "Coloque infracción")
	@Column(name = "infraccion", length = 10, nullable = false)
	private String infraccion;
	
	@Min(value = 98, message = "El valor ingresado no debe ser menos a 98")
	@Max(value = 600, message = "El valor ingresado no debe ser mayor a 600")
	@Column(name = "monto", nullable = false )
	private double monto;
	
}










