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

import java.util.List;

import javax.naming.directory.SearchResult;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

import my.com.cmg.iwp.maintenance.dao.HibernateSearchSupport;


/**
 * @author bbruhns
 * 
 */
@Repository
public  class HibernateSearchSupportImpl implements HibernateSearchSupport {
	private JPASearchProcessor hibernateSearchProcessor;

	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#count(java.lang.
	 * Class, com.trg.search.Search)
	 */
	public int count(Class<?> searchClass, Search search) {
		return hibernateSearchProcessor.count(getCurrentSession(), searchClass,
				search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#count(com.trg
	 * .search .Search)
	 */
	public int count(Search search) {
		return hibernateSearchProcessor.count(getCurrentSession(), search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#generateQL(java.
	 * lang.Class, com.trg.search.Search, java.util.List)
	 */
	public String generateQL(Class<?> entityClass, Search search,
			List<Object> paramList) {
		return hibernateSearchProcessor.generateQL(entityClass, search,
				paramList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#generateRowCountQL
	 * (java.lang.Class, com.trg.search.Search, java.util.List)
	 */
	public String generateRowCountQL(Class<?> entityClass, Search search,
			List<Object> paramList) {
		return hibernateSearchProcessor.generateRowCountQL(entityClass, search,
				paramList);
	}

	private Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#getFilterFromExample
	 * (java.lang.Object)
	 */
	public Filter getFilterFromExample(Object example) {
		return hibernateSearchProcessor.getFilterFromExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#getFilterFromExample
	 * (java.lang.Object, com.trg.search.ExampleOptions)
	 */
	public jakarta.servlet.Filter getFilterFromExample(Object example, ExampleOptions options) {
		return (jakarta.servlet.Filter) hibernateSearchProcessor.getFilterFromExample(example, options);
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#search(java.lang
	 * .Class, com.trg.search.Search)
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> search(Class<T> searchClass, Search search) {
		return hibernateSearchProcessor.search(getCurrentSession(),
				searchClass, search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#search(com.trg
	 * .search .Search)
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> search(Search search) {
		return hibernateSearchProcessor.search(getCurrentSession(), search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#searchAndCount
	 * (java .lang.Class, com.trg.search.Search)
	 */


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#searchUnique(java
	 * .lang.Class, com.trg.search.Search)
	 */
	@SuppressWarnings("unchecked")
	public <T> T searchUnique(Class<T> entityClass, Search search)
			throws NonUniqueResultException {
		return (T) hibernateSearchProcessor.searchUnique(getCurrentSession(),
				entityClass, search);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * my.com.cmg.iwp.backend.dao.impl.HibernateSearchSupport#searchUnique(com
	 * .trg.search.Search)
	 */
	public Object searchUnique(Search search) throws NonUniqueResultException {
		return hibernateSearchProcessor.searchUnique(getCurrentSession(),
				search);
	}

	public void setHibernateSearchProcessor(
			JPASearchProcessor hibernateSearchProcessor) {
		this.hibernateSearchProcessor = hibernateSearchProcessor;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public <T> com.googlecode.genericdao.search.SearchResult<T> searchAndCount(Class<T> searchClass, Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> com.googlecode.genericdao.search.SearchResult<T> searchAndCount(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

}
