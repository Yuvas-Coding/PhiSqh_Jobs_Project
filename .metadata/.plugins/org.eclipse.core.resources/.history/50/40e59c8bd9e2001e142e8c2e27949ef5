package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;

import my.com.cmg.iwp.maintenance.dao.impl.SecUserDAOImpl;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class SecUserServiceImpl implements SecUserService {
	
	SecUserDAOImpl secUserDAO;
	
	@Override
	public List<SecUser> getAllUsers() {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrEnabled", RefCodeConstant.BOOLEAN_TRUE));
		return secUserDAO.findByCriteria(criteria);
	}

	@Override
	public SecUser getUser(SecUser user) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class,"secUser");
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("id", user.getId()));
		detachedCriteria.createAlias("secUserroles", "secUserrole", CriteriaSpecification.LEFT_JOIN ).createAlias("secUserrole.secRole", "secRole", CriteriaSpecification.LEFT_JOIN);
		return (SecUser) getSecUserDAO().findByCriteria(detachedCriteria).iterator().next();
	}
	
	@Override
	public SecUser getSecUserFetches(SecUser secUser) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("usrLoginname",secUser.getUsrLoginname()));
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.createAlias("secUserroles", "secUserrole", CriteriaSpecification.LEFT_JOIN ).createAlias("secUserrole.secRole", "secRole", CriteriaSpecification.LEFT_JOIN);
		return (SecUser) getSecUserDAO().findByCriteria(detachedCriteria).iterator().next();
	}
	
	@Override
	public boolean isUserTypeBudget(SecUser secUser) {
		RefCodesService refCodesService = (RefCodesService) SpringUtil.getBean("refCodesService");
		List<RefCodes> allowedUsers = refCodesService.getRefCodesByDomain(RefCodeConstant.BUDGET_MOVEMENT_FAC_TYPE);
		for(RefCodes refCodes : allowedUsers) {
			if(refCodes.getRcValue().equals(secUser.getUsrType())) return true;
		}
		return false;
	}

	@Override
	public SecUser getSecUserWithEternalFacility(Long userId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("id",userId));
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		return (SecUser) getSecUserDAO().findByCriteria(detachedCriteria).iterator().next();
	}
	
	/********************ACCESSORS AND MUTATORS********************/
	public SecUserDAOImpl getSecUserDAO() { return secUserDAO; }
	public void setSecUserDAO(SecUserDAOImpl secUserDAO) { this.secUserDAO = secUserDAO; }
}
