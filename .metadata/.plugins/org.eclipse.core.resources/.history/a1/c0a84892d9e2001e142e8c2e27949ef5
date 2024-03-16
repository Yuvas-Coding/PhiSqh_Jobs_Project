package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.SecUserrole;

public interface SecUserroleService {

	int getCountAllSecUserroles();

	boolean isUserInRole(SecUser aUser, SecRole aRole);

	SecUserrole getUserroleByUserAndRole(SecUser aUser, SecRole aRole);

	List<SecUserrole> getAllUserRoles();

	SecUserrole getNewSecUserrole();

	void saveOrUpdate(SecUserrole userRole);

	void delete(SecUserrole userRole);

}
