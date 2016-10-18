package uy.edu.ude.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import uy.edu.ude.dto.LibroDto;
import uy.edu.ude.exception.ServiceException;
import uy.edu.ude.service.LibroService;

@Path("/v1/libro")
@Stateless
public class LibroEndpoint {

	private final static Logger log = Logger.getLogger(LibroEndpoint.class);

	@Inject
	private LibroService libroService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibroDto> findAll() throws ServiceException {
		return libroService.findAll();
	}

	@GET
	@Path("/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public LibroDto getLibroById(@PathParam("id") Long id) throws ServiceException {
		return libroService.findById(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String addLibro(@FormParam("libro") String libroString) {
		Gson gson = new Gson();
		try {
			LibroDto libroDto = gson.fromJson(libroString, LibroDto.class);
			libroService.save(libroDto);
		} catch (ServiceException | JsonSyntaxException e) {
			log.error(e);
			return "Error al guardar recurso";
		}
		return "Guardado correctamente";
	}

	@PUT
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("libro") String libroString) {
		Gson gson = new Gson();		
		try {
			LibroDto libroDto = gson.fromJson(libroString, LibroDto.class);
			libroService.update(libroDto);
		} catch (ServiceException | JsonSyntaxException e) {
			log.error(e);			
			return "Error al actualizar";
		}
		return "Actualizado correctamente";
	}

	@DELETE
	@Path("/{id: \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteById(@PathParam("id") Long id) {
		try {
			libroService.deleteById(id);
		} catch (ServiceException e) {
			log.error(e);
			return "Error al borrar recurso";
		}
		return "Borrado correctamente";
	}

}
