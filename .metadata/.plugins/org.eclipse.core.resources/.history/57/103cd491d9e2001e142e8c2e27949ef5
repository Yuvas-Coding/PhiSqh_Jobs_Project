package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.LoginActivation;

public interface LoginActivationService {

	LoginActivation getNewLoginActivation();

	void saveOrUpdate(LoginActivation anLoginActivation);

	void delete(LoginActivation anLoginActivation);

	LoginActivation getActiveLoginActivation(String activationId);

	LoginActivation findByUserLoginnameAndActivationId(String activationId, String usrLoginname);

	LoginActivation findByUserLoginnameAndTempPassword(String usrLoginname, String tempPassword);

	List<LoginActivation> findByUserLoginname(String usrLoginname);

	void saveOrUpdate(List<LoginActivation> listLoginActivation);

	List<LoginActivation> findAllByUserLoginname(String usrLoginname);

}
