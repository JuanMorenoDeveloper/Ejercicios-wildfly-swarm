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

import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.service.CategoriaService;

@Path("/v1/categoria")
@Stateless
public class CategoriaEndpoint {

	@Inject
	private CategoriaService categoriaService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaDto> findAll() {
		return categoriaService.findAll();
	}

	@GET
	@Path("/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaDto getPersonaById(@PathParam("id") Long id) {
		return categoriaService.findById(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPersonaById(@FormParam("categoria") String categoriaString) {
		Gson gson = new Gson();
		CategoriaDto categoriaDto = gson.fromJson(categoriaString, CategoriaDto.class);
		categoriaService.save(categoriaDto);
		return "Guardado correctamente";
	}

	@PUT
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("categoria") String categoriaString) {
		Gson gson = new Gson();
		CategoriaDto categoriaDto = gson.fromJson(categoriaString, CategoriaDto.class);
		categoriaService.update(categoriaDto);
		return "Actualizado correctamente";
	}

	@DELETE
	@Path("/{id: \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteById(@PathParam("id") Long id) {
		categoriaService.deleteById(id);
		return "Borrado correctamente";
	}

}
