package uy.edu.ude.dao;

import java.util.List;

import uy.edu.ude.exception.DaoException;

public interface GenericDao<T, K> {

	public T findById(K id) throws DaoException;

	public List<T> findAll() throws DaoException;

	public void save(T t) throws DaoException;

	public void update(T t) throws DaoException;

	public void delete(T t) throws DaoException;

	public void deleteById(K id) throws DaoException;
}
