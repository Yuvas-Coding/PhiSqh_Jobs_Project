package my.com.cmg.iwp.common.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.zkoss.spring.SpringUtil;

import my.com.cmg.iwp.maintenance.model.GenericNameAtc;

public class LazyInitializer<T> {
	private Session session = null;

	public void WakeUpObject(Object obj) {
		setSession(getSessionFactory().openSession());

		try {
			getSession().refresh(obj);

		} catch (Exception e) {
			close();
			e.printStackTrace();
		} finally {
			// session.close();
		}
	}

	public void close() {
		getSession().close();

	}

	private SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = (SessionFactory) SpringUtil
				.getBean("sessionFactory");
		return sessionFactory;
	}

	private void setSession(Session session) {
		this.session = session;
	}

	private Session getSession() {
		return session;
	}

	public void initialize(Object obj) {
		if (!Hibernate.isInitialized(obj))
			Hibernate.initialize(obj);
	}

	private HashMap getPrimary(Object obj) throws Exception {
		HashMap objMap = new HashMap();
		Class clzz = obj.getClass();
		Method[] methods = clzz.getMethods();
		boolean isStoredId = false;
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {

				if (annotation instanceof Id) {
					if (method.getName().contains("get")) {
						objMap.put("value", method.invoke(obj));
						String atrributeName = method.getName().replace("get",
								StringUtils.EMPTY);
						atrributeName = atrributeName.substring(0, 1)
								.toLowerCase()
								+ atrributeName.substring(1,
										atrributeName.length());
						objMap.put("attribute", atrributeName);
						return objMap;
					}
				}

			}

		}
		if(objMap.isEmpty()){
			for (Field field : clzz.getDeclaredFields()) {
				Annotation[] annotations = field.getAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof Id) {
						String methodNameFirstChar = new Character(field.getName().charAt(0)).toString().toUpperCase();
						Method method = clzz.getMethod("get"+field.getName().replaceFirst(".", methodNameFirstChar));
							objMap.put("value", method.invoke(obj));
							objMap.put("attribute", field.getName());
							return objMap;
					}

				}
			}
		}
		return objMap;
	}

	public T join(SessionFactory anSessionFactory, T mainEntity,
			String... clssNames) {
		DetachedCriteria criteria = DetachedCriteria.forClass(mainEntity
				.getClass());
		// HibernateOperations hibernateTemplate= (HibernateOperations)
		// SpringUtil.getBean("hibernateTemplate");
		Object obj = null;
		HashMap pk = null;
		try {
			setSession(anSessionFactory.openSession());
			pk = getPrimary(mainEntity);
			String fieldName = pk.get("attribute").toString();
			Long pkValue = (Long) pk.get("value");
			criteria.add(Restrictions.eq(fieldName, pkValue));
			for (String name : clssNames) {
				criteria.setFetchMode(name, FetchMode.JOIN);
			}
			obj = criteria.getExecutableCriteria(getSession()).list().get(0);
			close();
			// return
			// DataAccessUtils.uniqueResult(hibernateTemplate.findByCriteria(criteria));
		} catch (Exception e) {
			close();
			e.printStackTrace();
		}
		return (T) obj;
	}

	public T join(T mainEntity, String... clssNames) {
		DetachedCriteria criteria = DetachedCriteria.forClass(mainEntity
				.getClass());
		// HibernateOperations hibernateTemplate= (HibernateOperations)
		// SpringUtil.getBean("hibernateTemplate");
		Object obj = null;
		HashMap pk = null;
		try {
			setSession(getSessionFactory().openSession());
			pk = getPrimary(mainEntity);
			String fieldName = pk.get("attribute").toString();
			Long pkValue = (Long) pk.get("value");
			criteria.add(Restrictions.eq(fieldName, pkValue));
			for (String name : clssNames) {
				criteria.setFetchMode(name, FetchMode.JOIN);
			}
			obj = criteria.getExecutableCriteria(getSession()).list().get(0);
			close();
			// return
			// DataAccessUtils.uniqueResult(hibernateTemplate.findByCriteria(criteria));
		} catch (Exception e) {
			close();
			e.printStackTrace();
		}
		return (T)obj;
	}

	protected GenericNameAtc initialize() throws ConcurrentException {
		// TODO Auto-generated method stub
		return null;
	}

}
