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
import javax.xml.rpc.ServiceException;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import uy.edu.ude.dto.CategoriaDto;
import uy.edu.ude.service.CategoriaService;

@Path("/v1/categoria")
@Stateless
public class CategoriaEndpoint {

	private final static Logger log = Logger.getLogger(CategoriaEndpoint.class);

	@Inject
	private CategoriaService categoriaService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaDto> findAll() throws ServiceException {
		return categoriaService.findAll();
	}

	@GET
	@Path("/{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoriaDto getCategoriaById(@PathParam("id") Long id) throws ServiceException {
		return categoriaService.findById(id);
	}

	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCategoria(@FormParam("categoria") String categoriaString) throws ServiceException {
		Gson gson = new Gson();
		try {
			CategoriaDto categoriaDto = gson.fromJson(categoriaString, CategoriaDto.class);
			categoriaService.save(categoriaDto);
		} catch (ServiceException | JsonSyntaxException e) {
			log.error(e);
			return "Error al guardar recurso";
		}
		return "Guardado correctamente";
	}

	@PUT
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@FormParam("categoria") String categoriaString) throws ServiceException {
		Gson gson = new Gson();
		try {
			CategoriaDto categoriaDto = gson.fromJson(categoriaString, CategoriaDto.class);
			categoriaService.update(categoriaDto);
		} catch (ServiceException | JsonSyntaxException e) {
			log.error(e);
			return "Error al actualizar";
		}
		return "Actualizado correctamente";
	}

	@DELETE
	@Path("/{id: \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteById(@PathParam("id") Long id) throws ServiceException {
		try {
			categoriaService.deleteById(id);
		} catch (ServiceException e) {
			log.error(e);
			return "Error al borrar recurso";
		}
		return "Borrado correctamente";
	}

}
