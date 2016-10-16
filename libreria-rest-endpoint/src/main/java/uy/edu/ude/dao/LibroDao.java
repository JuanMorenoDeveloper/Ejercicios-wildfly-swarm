package uy.edu.ude.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.edu.ude.entity.Libro;

@Stateless
@LocalBean
public class LibroDao extends GenericFacadeDao<Libro, Long> {

	public LibroDao() {
		super(Libro.class);
	}

	@PersistenceContext(unitName = "libreria-pu")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
