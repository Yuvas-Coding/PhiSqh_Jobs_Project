package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.SecRole;
import my.com.cmg.iwp.maintenance.model.SecUser;

public interface SecRoleService {

	SecRole getNewSecRole();

	List<SecRole> getAllRoles();

	List<SecRole> getRolesByUser(SecUser aUser);

	SecRole getRoleById(Long role_Id);

	List<SecRole> getRolesLikeRoleName(String aRoleName);

	int getCountAllSecRoles();

	void saveOrUpdate(SecRole role);

	void delete(SecRole role);

	SecRole getSimilarRoleByRoleName(String roleName);

	SecRole getRoleByRoleGroup(String rcValue);
}
