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

import com.google.gson.Gson;

import uy.edu.ude.dto.LibroDto;
import uy.edu.ude.service.LibroService;

@Path("/v1/libro")
@Stateless
public class LibroEndpoint {

	@Inject
	private LibroService libroService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LibroDto> findAll() {
		return libroService.findAll();
	}

	@GET
	@Path("/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public LibroDto getPersonaById(@PathParam("id") Long id) {
		return libroService.findById(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPersonaById(@FormParam("libro") String libroString) {
		Gson gson = new Gson();
		LibroDto libroDto = gson.fromJson(libroString, LibroDto.class);
		libroService.save(libroDto);
		return "Guardado correctamente";
	}

	@PUT
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("libro") String libroString) {
		Gson gson = new Gson();
		LibroDto libroDto = gson.fromJson(libroString, LibroDto.class);
		libroService.update(libroDto);
		return "Guardado correctamente";
	}

	@DELETE
	@Path("/{id: \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteById(@PathParam("id") Long id) {
		libroService.deleteById(id);
		return "Borrado correctamente";
	}

}
