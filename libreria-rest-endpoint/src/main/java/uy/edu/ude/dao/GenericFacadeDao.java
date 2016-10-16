package uy.edu.ude.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericFacadeDao<T, K> implements GenericDao<T, K> {
	private Class<T> entityClass;

	public GenericFacadeDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	@Override
	public void save(T t) {
		getEntityManager().persist(getEntityManager().merge(t));
	}

	@Override
	public void delete(T t) {
		getEntityManager().remove(getEntityManager().merge(t));
	}

	@Override
	public void deleteById(K id) {
		T t = findById(id);
		delete(t);
	}

	@Override
	public void update(T t) {
		getEntityManager().merge(t);
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		criteriaQuery.select(criteriaQuery.from(entityClass));
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}

	@Override
	public T findById(K id) {
		return getEntityManager().find(entityClass, id);
	}
}
