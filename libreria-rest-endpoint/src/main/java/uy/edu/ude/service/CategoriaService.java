package uy.edu.ude.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import uy.edu.ude.converter.CategoriaConverter;
import uy.edu.ude.dao.CategoriaDao;
import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.entity.Categoria;

@Stateless
@LocalBean
public class CategoriaService {

	@Inject
	private CategoriaDao categoriaDao;

	public List<CategoriaDto> findAll() {
		List<Categoria> categorias = categoriaDao.findAll();
		List<CategoriaDto> categoriaDtos = CategoriaConverter.toDtos(categorias);
		return categoriaDtos;
	}

	public void save(CategoriaDto categoriaDto) {
		Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
		categoriaDao.save(categoria);
	}

	public void delete(CategoriaDto categoriaDto) {
		Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
		categoriaDao.delete(categoria);
	}

	public void update(CategoriaDto categoriaDto) {
		Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
		categoriaDao.update(categoria);
	}

	public CategoriaDto findById(Long id) {
		Categoria categoria = categoriaDao.findById(id);
		CategoriaDto categoriaDto = CategoriaConverter.toDto(categoria);
		return categoriaDto;
	}

	public void deleteById(Long id) {
		categoriaDao.deleteById(id);
	}

}
