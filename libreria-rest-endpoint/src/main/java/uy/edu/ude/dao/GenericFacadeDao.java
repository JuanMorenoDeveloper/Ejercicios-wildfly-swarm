package uy.edu.ude.dao;

import static java.util.Objects.nonNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import uy.edu.ude.exception.DaoException;

public abstract class GenericFacadeDao<T, K> implements GenericDao<T, K> {
	private Class<T> entityClass;

	public GenericFacadeDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	@Override
	public void save(T t) throws DaoException {
		getEntityManager().persist(getEntityManager().merge(t));
	}

	@Override
	public void delete(T t) throws DaoException {
		getEntityManager().remove(getEntityManager().merge(t));
	}

	@Override
	public void deleteById(K id) throws DaoException {
		T t = findById(id);
		if (nonNull(t)) {
			delete(t);
		} else {
			throw new DaoException("Objecto no encontrado");
		}
	}

	@Override
	public void update(T t) throws DaoException {
		getEntityManager().merge(t);
	}

	@Override
	public List<T> findAll() throws DaoException {
		CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}

	@Override
	public T findById(K id) throws DaoException {
		return getEntityManager().find(entityClass, id);
	}
}
