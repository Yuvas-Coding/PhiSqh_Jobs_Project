/**
 * Copyright 2010 the original author or authors.
 * 
 * This file is part of Zksample2. http://zksample2.sourceforge.net/
 *
 * Zksample2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Zksample2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Zksample2.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package my.com.cmg.iwp.maintenance.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;

/**
 * @author pramod
 * 
 */
@Repository
public abstract class BasisDAO<T> {
	private HibernateOperations hibernateTemplate;

	/**
	 * constructor
	 */
	protected BasisDAO() {
	}

	public HibernateOperations getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateOperations hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Update/delete all objects according to the given query.
	@Transactional
	public int bulkUpdate(String queryString) throws DataAccessException {
		try {
			return hibernateTemplate.bulkUpdate(queryString);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update/delete all objects according to the given query, binding one value
	// to a "?"
	@Transactional
	public int bulkUpdate(String queryString, T value)
			throws DataAccessException {
		try {
			return hibernateTemplate.bulkUpdate(queryString, value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update/delete all objects according to the given query, binding a number
	// of values to "?"

	@Transactional
	public int bulkUpdate(String queryString, T... values)
			throws DataAccessException {
		try {
			return hibernateTemplate.bulkUpdate(queryString, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Remove all objects from the Session cache, and cancel all pending saves,
	// updates and deletes.

	@Transactional
	public void clear() throws DataAccessException {
		try {
			hibernateTemplate.clear();
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Immediately close an Iterator created by any of the various iterate(..)
	@Transactional
	public void closeIterator(Iterator<T> it) throws DataAccessException {
		try {
			hibernateTemplate.closeIterator(it);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Check whether the given object is in the Session cache.

	@Transactional
	public boolean contains(T entity) throws DataAccessException {
		try {
			return hibernateTemplate.contains(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Delete the given persistent instance.

	@Transactional
	public void delete(T entity) throws DataAccessException {
		try {
			hibernateTemplate.delete(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Delete the given persistent instance.

	@Transactional
	public void delete(T entity, LockMode lockMode) throws DataAccessException {
		try {
			hibernateTemplate.delete(entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Delete the given persistent instance.

	@Transactional
	public void delete(String entityName, T entity) throws DataAccessException {
		try {
			hibernateTemplate.delete(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		}
	}

	@Transactional
	public void delete(String entityName, T entity, LockMode lockMode)
			throws DataAccessException {
		try {
			hibernateTemplate.delete(entityName, entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Delete all given persistent instances.
	@Transactional
	public void deleteAll(List<T> entities) throws DataAccessException {
		try {
			hibernateTemplate.deleteAll(entities);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return an enabled Hibernate Filter for the given filter name.
	@Transactional
	public org.hibernate.Filter enableFilter(String filterName) throws DataAccessException {
		try {
			return hibernateTemplate.enableFilter(filterName);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Remove the given object from the Session cache.
	@Transactional
	public void evict(T entity) throws DataAccessException {
		try {
			hibernateTemplate.evict(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute the action specified by the given action object within a Session.

	@Transactional
	public T execute(HibernateCallback<T> action) throws DataAccessException {
		try {
			return hibernateTemplate.execute(action);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute the specified action assuming that the result object is a List.

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> executeFind(HibernateCallback<T> action)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.execute(action);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> find(String queryString) throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.find(queryString);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query, binding one value to a "?"
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> find(String queryString, Object value)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.find(queryString, value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query, binding a number of values to "?"

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> find(String queryString, T... values)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.find(queryString, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query based on a given Hibernate criteria object.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByCriteria(DetachedCriteria criteria)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByCriteria(criteria);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query based on the given Hibernate criteria object.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) {
		return (List<T>) hibernateTemplate.findByCriteria(criteria, firstResult,
				maxResults);
	}

	// Execute a query based on the given example entity object.
	@Transactional
	public List<T> findByExample(T exampleEntity) throws DataAccessException {
		try {
			return hibernateTemplate.findByExample(exampleEntity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query based on the given example entity object.

	@Transactional
	public List<T> findByExample(String entityName, T exampleEntity)
			throws DataAccessException {
		try {
			return hibernateTemplate.findByExample(entityName, exampleEntity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query based on a given example entity object.

	@Transactional
	public List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) throws DataAccessException {
		try {
			return hibernateTemplate.findByExample(exampleEntity, firstResult,
					maxResults);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query based on a given example entity object.

	@Transactional
	public List<T> findByExample(String entityName, T exampleEntity,
			int firstResult, int maxResults) throws DataAccessException {
		try {
			return hibernateTemplate.findByExample(entityName, exampleEntity,
					firstResult, maxResults);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query, binding a number of values to ":" named parameters
	// in the query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedParam(String queryString, String paramName,
			T value) throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedParam(queryString, paramName,
					value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query, binding a number of values to ":" named parameters
	// in the query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedParam(String queryString, String[] paramNames,
			T[] values) throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQuery(String queryName, Long valueOf) {
		try {
			return (List<T>) hibernateTemplate.findByNamedQuery(queryName, valueOf);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQuery(String queryName)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQuery(queryName);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query, binding one value to a "?"
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQuery(String queryName, T value)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQuery(queryName, value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query binding a number of values to "?"
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQuery(String queryName, T... values)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQuery(queryName, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query, binding a number of values to ":" named parameters
	// in the query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, T[] values) throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQueryAndNamedParam(queryName,
					paramNames, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query, binding one value to a ":" named parameter in the
	// query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQueryAndNamedParam(String queryName,
			String paramName, T value) throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQueryAndNamedParam(queryName,
					paramName, value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a named query, binding the properties of the given bean to ":"
	// named parameters in the query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByNamedQueryAndValueBean(String queryName, T valueBean)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByNamedQueryAndValueBean(queryName,
					valueBean);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute an HQL query, binding the properties of the given bean to named
	// parameters in the query string.
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findByValueBean(String queryString, T valueBean)
			throws DataAccessException {
		try {
			return (List<T>) hibernateTemplate.findByValueBean(queryString, valueBean);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	@Transactional
	public void flush() throws DataAccessException {
		try {
			hibernateTemplate.flush();
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, or null if not found.
	@Transactional
	public T get(Class<T> entityClass, Serializable id)
			throws DataAccessException {
		try {
			return hibernateTemplate.get(entityClass, id);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, or null if not found.

	@Transactional
	public T get(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException {
		try {
			return hibernateTemplate.get(entityClass, id, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, or null if not found.
	@SuppressWarnings("unchecked")
	@Transactional
	public T get(String entityName, Serializable id) throws DataAccessException {
		try {
			return (T) hibernateTemplate.get(entityName, id);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, or null if not found.
	@SuppressWarnings("unchecked")
	@Transactional
	public T get(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException {
		try {
			return (T) hibernateTemplate.get(entityName, id, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Force initialization of a Hibernate proxy or persistent collection.
	@Transactional
	public void initialize(final Object proxy) throws DataAccessException {
		try {
			hibernateTemplate.initialize(proxy);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query for persistent instances.
	@SuppressWarnings("unchecked")
	@Transactional
	public Iterator<T> iterate(String queryString) throws DataAccessException {
		try {
			return (Iterator<T>) hibernateTemplate.iterate(queryString);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query for persistent instances, binding one value to a "?"
	@SuppressWarnings("unchecked")
	@Transactional
	public Iterator<T> iterate(String queryString, Object value)
			throws DataAccessException {
		try {
			return (Iterator<T>) hibernateTemplate.iterate(queryString, value);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Execute a query for persistent instances, binding a number of values to
	// "?"
	@SuppressWarnings("unchecked")
	@Transactional
	public Iterator<T> iterate(String queryString, Object... values)
			throws DataAccessException {
		try {
			return (Iterator<T>) hibernateTemplate.iterate(queryString, values);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, throwing an exception if not found.
	@Transactional
	public T load(Class<T> entityClass, Serializable id)
			throws DataAccessException {
		try {
			return hibernateTemplate.load(entityClass, id);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, throwing an exception if not found.
	@Transactional
	public T load(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException {
		try {
			return hibernateTemplate.load(entityClass, id, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Load the persistent instance with the given identifier into the given
	// object, throwing an exception if not found
	@Transactional
	public void load(T entity, Serializable id) throws DataAccessException {
		try {
			hibernateTemplate.load(entity, id);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, throwing an exception if not found.
	@SuppressWarnings("unchecked")
	@Transactional
	public T load(String entityName, Serializable id)
			throws DataAccessException {
		try {
			return (T) hibernateTemplate.load(entityName, id);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return the persistent instance of the given entity class with the given
	// identifier, throwing an exception if not found.
	@SuppressWarnings("unchecked")
	@Transactional
	public T load(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException {
		try {
			return (T) hibernateTemplate.load(entityName, id, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Return all persistent instances of the given entity class.
	@Transactional
	public List<T> loadAll(Class<T> entityClass) throws DataAccessException {
		try {
			return hibernateTemplate.loadAll(entityClass);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Obtain the specified lock level upon the given object, implicitly
	// checking whether the corresponding database entry still exists.
	@Transactional
	public void lock(Object entity, LockMode lockMode)
			throws DataAccessException {
		try {
			hibernateTemplate.lock(entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Obtain the specified lock level upon the given object, implicitly
	// checking whether the corresponding database entry still exists.
	@Transactional
	public void lock(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException {
		try {
			hibernateTemplate.lock(entityName, entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Copy the state of the given object onto the persistent object with the
	// same identifier.
	@Transactional
	public T merge(T entity) throws DataAccessException {
		try {
			return hibernateTemplate.merge(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Copy the state of the given object onto the persistent object with the
	// same identifier.
	@Transactional
	public T merge(String entityName, T entity) throws DataAccessException {
		try {
			return hibernateTemplate.merge(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the given transient instance.
	@Transactional
	public void persist(T entity) throws DataAccessException {
		try {
			hibernateTemplate.persist(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the given transient instance.
	@Transactional
	public void persist(String entityName, T entity) throws DataAccessException {
		try {
			hibernateTemplate.persist(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Re-read the state of the given persistent instance.
	@Transactional
	public void refresh(T entity) throws DataAccessException {
		try {
			hibernateTemplate.refresh(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Re-read the state of the given persistent instance.
	@Transactional
	public void refresh(T entity, LockMode lockMode) throws DataAccessException {
		try {
			hibernateTemplate.refresh(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the state of the given detached instance according to the given
	// replication mode, reusing the current identifier value.
	@Transactional
	public void replicate(T entity, ReplicationMode replicationMode)
			throws DataAccessException {
		try {
			hibernateTemplate.replicate(entity, replicationMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the state of the given detached instance according to the given
	// replication mode, reusing the current identifier value.
	@Transactional
	public void replicate(String entityName, T entity,
			ReplicationMode replicationMode) throws DataAccessException {
		try {
			hibernateTemplate.replicate(entityName, entity, replicationMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the given transient instance.
	@Transactional
	public Serializable save(T entity) throws DataAccessException {
		try {
			return hibernateTemplate.save(entity);
		} catch (DuplicateKeyException e) {
			throw new DuplicateKeyException("Data already exist");
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Persist the given transient instance.
	@Transactional
	public Serializable save(String entityName, T entity)
			throws DataAccessException {
		try {
			return hibernateTemplate.save(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		}
	}

	// Save or update the given persistent instance, according to its id
	// (matching the configured "unsaved-value"?).
	@Transactional
	public void saveOrUpdate(T entity) throws DataAccessException {
		try {
			hibernateTemplate.saveOrUpdate(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Save or update the given persistent instance, according to its id
	// (matching the configured "unsaved-value"?).
	@Transactional
	public void saveOrUpdate(String entityName, T entity)
			throws DataAccessException {
		try {
			hibernateTemplate.saveOrUpdate(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Save or update the given persistent instance, according to its id
	// (matching the configured "unsaved-value"?).
	@Transactional
	public void saveOrUpdateAll(Collection<T> entities)
			throws DataAccessException {
		try {
			hibernateTemplate.saveOrUpdate(entities);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update the given persistent instance, associating it with the current
	// Hibernate Session.
	@Transactional
	public void update(T entity) throws DataAccessException {
		try {
			hibernateTemplate.update(entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update the given persistent instance, associating it with the current
	// Hibernate Session.

	@Transactional
	public void update(T entity, LockMode lockMode) throws DataAccessException {
		try {
			hibernateTemplate.update(entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update the given persistent instance, associating it with the current
	// Hibernate Session.

	@Transactional
	public void update(String entityName, T entity) throws DataAccessException {
		try {
			hibernateTemplate.update(entityName, entity);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	// Update the given persistent instance, associating it with the current
	// Hibernate Session.

	@Transactional
	public void update(String entityName, T entity, LockMode lockMode)
			throws DataAccessException {
		try {
			hibernateTemplate.update(entityName, entity, lockMode);
		} catch (DataAccessException e) {
			throw BasisDAO.customisedDataAccessException(e);
		} finally {
			hibernateTemplate.flush();
		}
	}

	public static DataAccessException customisedDataAccessException(
			DataAccessException e) {
		DataAccessException ex = e;
		if (e instanceof DataAccessResourceFailureException) {
			DataAccessResourceFailureException drfe = (DataAccessResourceFailureException) e;
			if (drfe.contains(JDBCConnectionException.class)) {
				JDBCConnectionException jce = (JDBCConnectionException) drfe
						.getCause();
				String sqlstate = jce.getSQLState();
				if (sqlstate.equalsIgnoreCase("08000")) {
					ex = new DataAccessResourceFailureException(
							jce.getSQLState() + ":"
									+ "Connection closed by unknown interrupt.");
				} else if (sqlstate.equalsIgnoreCase("08003")) {
					ex = new DataAccessResourceFailureException(
							jce.getSQLState() + ":" + "No current connection.");
				} else if (sqlstate.equalsIgnoreCase("08004")) {
					ex = new DataAccessResourceFailureException(
							jce.getSQLState() + ":" + "Connection refused.");
				} else if (sqlstate.equalsIgnoreCase("08006")) {
					ex = new DataAccessResourceFailureException(
							jce.getSQLState() + ":" + "Database not exist");
				}
			} else if (e instanceof InvalidDataAccessResourceUsageException) {
				InvalidDataAccessResourceUsageException idarue = (InvalidDataAccessResourceUsageException) e;
				if (idarue.contains(SQLGrammarException.class)) {
					SQLGrammarException sge = (SQLGrammarException) idarue
							.getCause();
					String sqlstate = sge.getSQLState();
					ex = new InvalidDataAccessResourceUsageException(
							sge.getSQLState() + ":" + sge.getMessage());
				}
			} else if (e instanceof CannotAcquireLockException) {
				CannotAcquireLockException cale = (CannotAcquireLockException) e;
				if (cale.contains(LockAcquisitionException.class)) {
					LockAcquisitionException lae = (LockAcquisitionException) cale
							.getCause();
					ex = new InvalidDataAccessResourceUsageException(
							lae.getSQLState() + ":" + lae.getMessage());
				}
			} else if (e instanceof DataIntegrityViolationException) {
				DataIntegrityViolationException dive = (DataIntegrityViolationException) e;
				if (dive.contains(ConstraintViolationException.class)) {
					ConstraintViolationException cve = (ConstraintViolationException) dive
							.getCause();
					String sqlstate = cve.getSQLState();
					if (sqlstate.equalsIgnoreCase("23505")) {
						ex = new DuplicateKeyException(cve.getSQLState() + ":"
								+ "Unique key constraint violation");
					} else if (sqlstate.equalsIgnoreCase("23502")) {
						ex = new DataIntegrityViolationException(
								cve.getSQLState() + ":"
										+ "Null constraint violation");
					} else if (sqlstate.equalsIgnoreCase("23503")) {
						ex = new DataIntegrityViolationException(
								cve.getSQLState() + ":"
										+ "Foriegn key constraint violation");
					}
				} else if (dive.contains(DataException.class)) {
					DataException de = (DataException) dive.getCause();
					ex = new DataIntegrityViolationException(de.getSQLState()
							+ ":" + de.getMessage());
				}
			}
		}

		return ex;
	}
}
