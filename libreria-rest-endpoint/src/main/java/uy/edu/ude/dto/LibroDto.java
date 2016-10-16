package uy.edu.ude.dto;

import java.io.Serializable;

public class LibroDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String codigo;
	private Integer cantidad;

	private CategoriaDto categoria = new CategoriaDto();

	public LibroDto() {
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

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategorias(CategoriaDto categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", cantidad=" + cantidad
				+ ", categoria=" + categoria + "]";
	}

}
