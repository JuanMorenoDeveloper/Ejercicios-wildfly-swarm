package uy.edu.ude.converter;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.entity.Categoria;

public class CategoriaConverter {

	public static CategoriaDto toDto(Categoria entity) {
		CategoriaDto dto = new CategoriaDto();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		return dto;
	}

	public static Categoria toEntity(CategoriaDto dto) {
		Categoria entity = new Categoria();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		return entity;
	}

	public static List<CategoriaDto> toDtos(List<Categoria> entities) {
		List<CategoriaDto> dtos = new ArrayList<>();
		for (Categoria entity : entities) {
			CategoriaDto CategoriaDto = toDto(entity);
			dtos.add(CategoriaDto);
		}
		return dtos;
	}

	public static List<Categoria> toEntities(List<CategoriaDto> dtos) {
		List<Categoria> entities = new ArrayList<>();
		for (CategoriaDto dto : dtos) {
			Categoria Categoria = toEntity(dto);
			entities.add(Categoria);
		}
		return entities;
	}
}
