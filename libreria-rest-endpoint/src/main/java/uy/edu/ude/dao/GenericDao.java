package uy.edu.ude.dao;

import java.util.List;

public interface GenericDao<T, K> {

	public T findById(K id);

	public List<T> findAll();

	public void save(T t);

	public void update(T t);

	public void delete(T t);

	public void deleteById(K id);
}
