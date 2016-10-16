package uy.edu.ude.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "codigo", nullable = false)
	private String codigo;
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@JoinColumn(name = "id_categoria", referencedColumnName = "id", nullable = true)
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Categoria categoria = new Categoria();

	public Libro() {
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", cantidad=" + cantidad
				+ ", categorias=" + categoria + "]";
	}

}
