package my.com.cmg.iwp.maintenance.service;


import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecUser;

public interface SecUserService {
	public List<SecUser> getAllUsers();
	SecUser getUser(SecUser user);
	SecUser getSecUserFetches(SecUser secUser);
	boolean isUserTypeBudget(SecUser secUser);
	SecUser getSecUserWithEternalFacility(Long userId);
}
