package uy.edu.ude.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import uy.edu.ude.converter.LibroConverter;
import uy.edu.ude.dao.LibroDao;
import uy.edu.ude.dto.LibroDto;
import uy.edu.ude.entity.Libro;

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

	public void save(LibroDto libroDto) {
		Libro libro = LibroConverter.toEntity(libroDto);
		libroDao.save(libro);
	}

	public void delete(LibroDto libroDto) {
		Libro libro = LibroConverter.toEntity(libroDto);
		libroDao.delete(libro);
	}

	public void update(LibroDto libroDto) {
		Libro libro = LibroConverter.toEntity(libroDto);
		libroDao.update(libro);
	}

	public LibroDto findById(Long id) {
		Libro libro = libroDao.findById(id);
		LibroDto libroDto = LibroConverter.toDto(libro);
		return libroDto;
	}

	public void deleteById(Long id) {
		libroDao.deleteById(id);
	}
}
