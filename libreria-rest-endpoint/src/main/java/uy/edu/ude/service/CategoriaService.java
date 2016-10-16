package uy.edu.ude.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.rpc.ServiceException;

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

	public void save(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.save(categoria);
		} catch (Exception e) {
			throw new ServiceException("Error al guardar", e);
		}
	}

	public void delete(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.delete(categoria);
		} catch (Exception e) {
			throw new ServiceException("Error al borrar", e);
		}
	}

	public void update(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.update(categoria);
		} catch (Exception e) {
			throw new ServiceException("Error al actualizar", e);
		}
	}

	public CategoriaDto findById(Long id) throws ServiceException {
		try {
			Categoria categoria = categoriaDao.findById(id);
			CategoriaDto categoriaDto = CategoriaConverter.toDto(categoria);
			return categoriaDto;
		} catch (Exception e) {
			throw new ServiceException("Error al obtener recurso", e);
		}
	}

	public void deleteById(Long id) throws ServiceException {
		try {
			categoriaDao.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Error al borrar el recurso", e);
		}
	}

}
