package my.com.cmg.iwp.maintenance.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.service.CommonService;

/**
 * Service implementation for methods that depends on <b>all DAO methods</b>.<br>
 * 
 * @author bbruhns
 * @author sgerth
 */
@Service
public class CommonServiceImpl implements CommonService {

	private HibernateOperations hibernateTemplate;

	@Override
	public Map<String, Object> getAllTablesRecordCounts() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SecGroup", getCountAllSecGroup());
		map.put("SecGroupright", getCountAllSecGroupright());
		map.put("SecRight", getCountAllSecRights());
		map.put("SecRole", getCountAllSecRole());
		map.put("SecRolegroup", getCountAllSecRolegroup());
		map.put("SecUser", getCountAllSecUser());
		map.put("SecUserrole", getCountAllSecUserrole());
		map.put("SysCountryCode", getCountAllSysCountrycode());
		map.put("SecLoginlog", getCountAllSecLoginlog());
		return map;
	}

	private Object getCountAllSecGroup() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecGroup"));
	}

	private Object getCountAllSecGroupright() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecGroupright"));
	}

	private Object getCountAllSecRights() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecRight"));
	}

	private Object getCountAllSecRole() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecRole"));
	}

	private Object getCountAllSecRolegroup() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecRolegroup"));
	}

	private Object getCountAllSecUser() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecUser"));
	}

	private Object getCountAllSecUserrole() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from SecUserrole"));
	}

	private Object getCountAllSysCountrycode() {
		return DataAccessUtils.intResult(getHibernateTemplate().find(
				"select count(*) from CountryCode"));
	}
	private Object getCountAllSecLoginlog() {
		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from SecLoginlog"));
	}

	@Override
	public HibernateOperations getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateOperations hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}