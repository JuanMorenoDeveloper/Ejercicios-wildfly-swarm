package uy.edu.ude.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.edu.ude.entity.Categoria;

@Stateless
@LocalBean
public class CategoriaDao extends GenericFacadeDao<Categoria, Long> {

	public CategoriaDao() {
		super(Categoria.class);
	}

	@PersistenceContext(unitName = "libreria-pu")
	private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
