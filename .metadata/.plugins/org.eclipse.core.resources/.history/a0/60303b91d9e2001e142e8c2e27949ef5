package my.com.cmg.iwp.maintenance.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	private BasisNextidDaoImpl<SecUser> userDAO;

	@Override
	public SecUser getLoginUser(String usrLoginName, String usrPassword) {
		if (StringUtils.isBlank(usrLoginName)) {
			return null;
		}
		if (StringUtils.isBlank(usrPassword)) {
			return null;
		}
		return getUserByNameAndPassword(usrLoginName, usrPassword);
	}

	public SecUser getUserByNameAndPassword(final String userName,
			final String userPassword) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		criteria.add(Restrictions.eq("usrPassword", userPassword));

		return (SecUser) DataAccessUtils.uniqueResult(userDAO
				.findByCriteria(criteria));
	}

	public void setUserDAO(BasisNextidDaoImpl<SecUser> userDAO) {
		this.userDAO = userDAO;
	}

	public BasisNextidDaoImpl<SecUser> getUserDAO() {
		return userDAO;
	}
}