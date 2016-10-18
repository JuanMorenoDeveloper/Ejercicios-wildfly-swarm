package uy.edu.ude.service;

import static java.util.Objects.nonNull;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.rpc.ServiceException;

import uy.edu.ude.converter.CategoriaConverter;
import uy.edu.ude.dao.CategoriaDao;
import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.entity.Categoria;
import uy.edu.ude.exception.DaoException;

@Stateless
@LocalBean
public class CategoriaService {

	@Inject
	private CategoriaDao categoriaDao;

	public List<CategoriaDto> findAll() throws ServiceException {
		List<Categoria> categorias;
		try {
			categorias = categoriaDao.findAll();
			List<CategoriaDto> categoriaDtos = CategoriaConverter.toDtos(categorias);
			return categoriaDtos;
		} catch (DaoException e) {
			throw new ServiceException("Error al recuperar recurso", e);
		}
	}

	public void save(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.save(categoria);
		} catch (DaoException e) {
			throw new ServiceException("Error al guardar", e);
		}
	}

	public void delete(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.delete(categoria);
		} catch (DaoException e) {
			throw new ServiceException("Error al borrar recurso", e);
		}
	}

	public void update(CategoriaDto categoriaDto) throws ServiceException {
		try {
			Categoria categoria = CategoriaConverter.toEntity(categoriaDto);
			categoriaDao.update(categoria);
		} catch (DaoException e) {
			throw new ServiceException("Error al actualizar", e);
		}
	}

	public CategoriaDto findById(Long id) throws ServiceException {
		try {
			Categoria categoria = categoriaDao.findById(id);
			CategoriaDto categoriaDto = new CategoriaDto();
			if (nonNull(categoria)) {
				categoriaDto = CategoriaConverter.toDto(categoria);
			}
			return categoriaDto;
		} catch (DaoException e) {
			throw new ServiceException("Error al obtener recurso", e);
		}
	}

	public void deleteById(Long id) throws ServiceException {
		try {
			categoriaDao.deleteById(id);
		} catch (DaoException e) {
			throw new ServiceException("Error al borrar el recurso", e);
		}
	}

}
