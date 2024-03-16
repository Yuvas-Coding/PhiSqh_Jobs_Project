package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.PPUSSName;
import my.com.cmg.iwp.maintenance.service.PPUSSNameService;
@Service
public class PPUSSNameServiceImpl implements PPUSSNameService {

	private BasisNextidDaoImpl<PPUSSName> 	ppussNameDAO;

	
	@Override
	public PPUSSName getNewPpussName() {
		// TODO Auto-generated method stub
		return new PPUSSName();
	}

	@Override
	public void saveOrUpdate(PPUSSName ppussName) {
		ppussNameDAO.saveOrUpdate(ppussName);		
	}

	public BasisNextidDaoImpl<PPUSSName> getPpussNameDAO() {
		return ppussNameDAO;
	}

	public void setPpussNameDAO(BasisNextidDaoImpl<PPUSSName> ppussNameDAO) {
		this.ppussNameDAO = ppussNameDAO;
	}
	
}
