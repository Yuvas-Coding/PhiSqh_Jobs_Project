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
package my.com.cmg.iwp.maintenance.dao;

import java.util.List;

import javax.naming.directory.SearchResult;

import org.hibernate.NonUniqueResultException;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Search;

import jakarta.servlet.Filter;

public interface HibernateSearchSupport {

	int count(Class<?> searchClass, Search search);

	int count(Search search);

	String generateQL(Class<?> entityClass, Search search,
			List<Object> paramList);

	String generateRowCountQL(Class<?> entityClass, Search search,
			List<Object> paramList);

	Filter getFilterFromExample(Object example, ExampleOptions options);

	com.googlecode.genericdao.search.Filter getFilterFromExample(Object example);

	<T> List<T> search(Class<T> searchClass, Search search);

	<T> List<T> search(Search search);

	<T> com.googlecode.genericdao.search.SearchResult<T> searchAndCount(Class<T> searchClass, Search search);

	<T> com.googlecode.genericdao.search.SearchResult<T> searchAndCount(Search search);

	<T> T searchUnique(Class<T> entityClass, Search search)
			throws NonUniqueResultException;

	Object searchUnique(Search search) throws NonUniqueResultException;

}
