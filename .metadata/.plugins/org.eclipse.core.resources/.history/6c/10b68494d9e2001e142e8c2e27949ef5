package my.com.cmg.iwp.backend.service.integration.spub.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SuborderTaperStatInt;
import my.com.cmg.iwp.backend.service.integration.spub.SuborderTaperStatIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;


/**
 *
 *@author DavidLeow
 *
 */

@Service
public class SuborderTaperStatIntServiceImpl implements SuborderTaperStatIntService{
	BasisNextidDaoImpl<SuborderTaperStatInt> genericUtilDAO;

	public BasisNextidDaoImpl<SuborderTaperStatInt> getGenericUtilDAO() {
		return genericUtilDAO;
	}

	public void setGenericUtilDAO(
			BasisNextidDaoImpl<SuborderTaperStatInt> genericUtilDAO) {
		this.genericUtilDAO = genericUtilDAO;
	}
	
	@Override
	public void saveOrUpdate(SuborderTaperStatInt suborderTaperStatInt) {
		getGenericUtilDAO().saveOrUpdate(suborderTaperStatInt);
	}

	@Override
	public void create(SuborderTaperStatInt suborderTaperStatInt) {
		getGenericUtilDAO().save(suborderTaperStatInt);
	}
}
