package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.LoginActivation;
import my.com.cmg.iwp.maintenance.service.LoginActivationService;
@Service
public class LoginActivationServiceImpl implements LoginActivationService {

	BasisNextidDaoImpl<LoginActivation> loginActivationDAO;

	public BasisNextidDaoImpl<LoginActivation> getLoginActivationDAO() {
		return loginActivationDAO;
	}

	public void setLoginActivationDAO(BasisNextidDaoImpl<LoginActivation> loginActivationDAO) {
		this.loginActivationDAO = loginActivationDAO;
	}

	@Override
	public LoginActivation getNewLoginActivation() {
		return new LoginActivation();
	}
	
	@Override
	public void saveOrUpdate(LoginActivation anLoginActivation) {
		getLoginActivationDAO().saveOrUpdate(anLoginActivation);
	}
	
	@Override
	public void saveOrUpdate(List<LoginActivation> listLoginActivation) {
		getLoginActivationDAO().saveOrUpdateAll(listLoginActivation);
	}

	@Override
	public void delete(LoginActivation anLoginActivation) {
		getLoginActivationDAO().delete(anLoginActivation);
	}
	
	@Override
	public LoginActivation getActiveLoginActivation(String activationId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginActivation.class);
		criteria.add(Restrictions.eq("activationId", activationId));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.desc("createdDate"));
		List<LoginActivation> LoginActivations = getLoginActivationDAO().findByCriteria(criteria);
		return LoginActivations != null && LoginActivations.size() > 0 ? LoginActivations.get(0) : null;
	}
	
	@Override
	public LoginActivation findByUserLoginnameAndActivationId(String activationId, String usrLoginname) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginActivation.class);
		criteria.add(Restrictions.eq("activationId", activationId));
		criteria.add(Restrictions.eq("usrLoginname", usrLoginname));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.desc("createdDate"));
		List<LoginActivation> LoginActivations = getLoginActivationDAO().findByCriteria(criteria);
		return LoginActivations != null && LoginActivations.size() > 0 ? LoginActivations.get(0) : null;
	}
	
	@Override
	public LoginActivation findByUserLoginnameAndTempPassword(String usrLoginname, String tempPassword) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginActivation.class);
		criteria.add(Restrictions.eq("tempPassword", tempPassword));
		criteria.add(Restrictions.eq("usrLoginname", usrLoginname));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.desc("createdDate"));
		List<LoginActivation> LoginActivations = getLoginActivationDAO().findByCriteria(criteria);
		return LoginActivations != null && LoginActivations.size() > 0 ? LoginActivations.get(0) : null;
	}
	
	@Override
	public List<LoginActivation> findByUserLoginname(String usrLoginname) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginActivation.class);
		criteria.add(Restrictions.eq("usrLoginname", usrLoginname));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.desc("createdDate"));
		return getLoginActivationDAO().findByCriteria(criteria);
	}
	
	@Override
	public List<LoginActivation> findAllByUserLoginname(String usrLoginname) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginActivation.class);
		criteria.add(Restrictions.eq("usrLoginname", usrLoginname));
		criteria.addOrder(Order.desc("createdDate"));
		return getLoginActivationDAO().findByCriteria(criteria);
	}
}
