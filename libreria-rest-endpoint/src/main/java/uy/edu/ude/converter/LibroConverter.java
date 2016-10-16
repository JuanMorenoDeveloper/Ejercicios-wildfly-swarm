package uy.edu.ude.converter;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.dto.LibroDto;
import uy.edu.ude.entity.Categoria;
import uy.edu.ude.entity.Libro;

public class LibroConverter {

	public static LibroDto toDto(Libro entity) {
		LibroDto dto = new LibroDto();
		CategoriaDto categoriaDto = CategoriaConverter.toDto(entity.getCategoria());
		dto.setCantidad(entity.getCantidad());
		dto.setCategorias(categoriaDto);
		dto.setCodigo(entity.getCodigo());
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
	}

	public static Libro toEntity(LibroDto dto) {
		Libro entity = new Libro();
		Categoria categoria = CategoriaConverter.toEntity(dto.getCategoria());
		entity.setCantidad(dto.getCantidad());
		entity.setCategoria(categoria);
		entity.setCodigo(dto.getCodigo());
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity;
	}

	public static List<LibroDto> toDtos(List<Libro> entities) {
		List<LibroDto> dtos = new ArrayList<>();
		for (Libro entity : entities) {
			LibroDto libroDto = toDto(entity);
			dtos.add(libroDto);
		}
		return dtos;
	}

	public static List<Libro> toEntities(List<LibroDto> dtos) {
		List<Libro> entities = new ArrayList<>();
		for (LibroDto dto : dtos) {
			Libro libro = toEntity(dto);
			entities.add(libro);
		}
		return entities;
	}

}
