package my.com.cmg.iwp.maintenance.service;

import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.NePGLAccount;


public interface NePGLAccountService {

	List<NePGLAccount> getGLAccountList();

	void saveOrUpdate(NePGLAccount nePGLAccount);
	
	List<NePGLAccount> findByProgram(Map<Object, Object> map);

	List<NePGLAccount> findActiveAllowByList(List<NePGLAccount> nePProjectList);

	List<NePGLAccount> getAllActiveAllowByCode(String code);

	List<NePGLAccount> findAllowByMap(Map<Object, Object> map);
	
	NePGLAccount getNewNePGLAccount();
}
