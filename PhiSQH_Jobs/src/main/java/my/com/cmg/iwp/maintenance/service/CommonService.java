package my.com.cmg.iwp.maintenance.service;

import java.util.Map;

import org.springframework.orm.hibernate5.HibernateOperations;

public interface CommonService {

	/**
	 * Gets the recordCounts for all tables in a Map.
	 * 
	 * @return Map <String, Object> String = key, i.e. "Customer". Object is the
	 *         value of recordCounts
	 */
	public Map<String, Object> getAllTablesRecordCounts();

	HibernateOperations getHibernateTemplate();
}
