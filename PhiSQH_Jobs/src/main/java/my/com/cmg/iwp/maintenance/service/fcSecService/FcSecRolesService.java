package my.com.cmg.iwp.maintenance.service.fcSecService;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.fcSecurityModel.FcSecRoles;

public interface FcSecRolesService {

	FcSecRoles getNewSecRole();

	List<FcSecRoles> getAllRoles();

	/* List<SecRole> getRolesByUser(SecUser aUser); */

	FcSecRoles getRoleById(Long role_Id);

	List<FcSecRoles> getRolesLikeRoleName(String aRoleName);

	int getCountAllSecRoles();

	void saveOrUpdate(FcSecRoles role);

	void delete(FcSecRoles role);

	FcSecRoles getRoleByRoleGroup(String rplApprovalGroup);

	FcSecRoles getSimilarRoleByRoleName(String roleName);

	/*
	 * List<SecRole> getRolesByUserAndRolShortDesc(SecUser user, String nurseSubmit, String pharmacistConfirm);
	 */

}
