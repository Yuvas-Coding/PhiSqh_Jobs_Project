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

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.com.cmg.iwp.maintenance.dao.NextidviewDAO;
import my.com.cmg.iwp.maintenance.model.Entity;

/**
 * @author bbruhns
 * 
 */
@Repository
abstract public class BasisNextidDaoImpl<T> extends BasisDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private NextidviewDAO nextidviewDAO;

	public NextidviewDAO getNextidviewDAO() {
		return nextidviewDAO;
	}

	public void setNextidviewDAO(NextidviewDAO nextidviewDAO) {
		this.nextidviewDAO = nextidviewDAO;
	}

	protected long getNextId() {
		return getNextidviewDAO().getNextId();
	}

	/**
	 * Hook to set the primary key for a new entity.
	 * 
	 * @param entity
	 *            entity
	 * @param nextId
	 *            The new ID
	 */
	protected void setPrimaryKey(T entity, long nextId) {
		((Entity) entity).setId(nextId);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
