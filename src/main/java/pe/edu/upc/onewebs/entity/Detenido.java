package pe.edu.upc.onewebs.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detenidos")
public class Detenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 8, max = 8, message = "El DNI debe ser de 8 digitos")
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Size(min = 2, message = "El Apellido debe ser como minimo de 2 caracteres")
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@NotBlank(message = "No se aceptan nombres vacios")
	@Column(name = "nombres", length = 30, nullable = false)
	private String nombres;
	
	@Past(message = "La fecha de nacimiento debe ser una fecha pasada")
	@Column(name = "fecha_nacimiento", nullable = false)	
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@NotBlank(message = "Por favor, ingrese el distrito")
	@Column(name = "distrito", length = 40, nullable = false)
	private String distrito;
	
	// mappedBy: El objeto de relacion
	// fetch: 
	//@NotEmpty(message = "Un detenido debe tener un multa")
	@JsonIgnoreProperties("detenido")
	@OneToMany(mappedBy = "detenido", fetch = FetchType.LAZY)
	private List<Multa> multas;
	
	// joinColumns: Son los atributos de la clase Origen (actual)
	// inverseJoinColumns: Son los atributos de la clase Destino (a relacionarme)
	//@NotEmpty(message = "Por favor, especifique la comisaria")
	@JsonIgnoreProperties("detenidos")
	@ManyToMany
	@JoinTable(name = "detenido_comisaria", 
		joinColumns = { @JoinColumn(name = "detenido_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "comisaria_id", referencedColumnName = "id") } )
	private List<Comisaria> comisarias;
	
	public Detenido() {
		multas =  new ArrayList<>();
		comisarias = new ArrayList<>();
	}
	public void addComisaria(Comisaria comisaria) {
		comisarias.add(comisaria);
	}
	public void addMulta(Multa multa) {
		multas.add(multa);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	public List<Comisaria> getComisarias() {
		return comisarias;
	}
	public void setComisarias(List<Comisaria> comisarias) {
		this.comisarias = comisarias;
	}
	
	
}

