package uy.edu.ude.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import uy.edu.ude.converter.LibroConverter;
import uy.edu.ude.dao.LibroDao;
import uy.edu.ude.dto.LibroDto;
import uy.edu.ude.entity.Libro;
import uy.edu.ude.exception.ServiceException;

@Stateless
@LocalBean
public class LibroService {

	@Inject
	private LibroDao libroDao;

	public List<LibroDto> findAll() {
		List<Libro> libros = libroDao.findAll();
		List<LibroDto> libroDtos = LibroConverter.toDtos(libros);
		return libroDtos;
	}

	public void save(LibroDto libroDto) throws ServiceException {
		try {
			Libro libro = LibroConverter.toEntity(libroDto);
			libroDao.save(libro);
		} catch (Exception e) {
			throw new ServiceException("Error al guardar", e);
		}
	}

	public void delete(LibroDto libroDto) throws ServiceException {
		try {
			Libro libro = LibroConverter.toEntity(libroDto);
			libroDao.delete(libro);
		} catch (Exception e) {
			throw new ServiceException("Error al borrar recurso", e);
		}
	}

	public void update(LibroDto libroDto) throws ServiceException {
		try {
			Libro libro = LibroConverter.toEntity(libroDto);
			libroDao.update(libro);
		} catch (Exception e) {
			throw new ServiceException("Error al actualizar recurso", e);
		}
	}

	public LibroDto findById(Long id) throws ServiceException {
		try {
			Libro libro = libroDao.findById(id);
			LibroDto libroDto = LibroConverter.toDto(libro);
			return libroDto;
		} catch (Exception e) {
			throw new ServiceException("Error al recuperar recurso", e);
		}
	}

	public void deleteById(Long id) throws ServiceException {
		try {
			libroDao.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Error al borrar", e);
		}
	}
}
