package my.com.cmg.iwp.backend.service.integration.returns.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterDtlsInt;
import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterHdrsInt;
import my.com.cmg.iwp.backend.service.integration.returns.ReturnIntegrationService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class ReturnIntegrationServiceImpl implements ReturnIntegrationService{

	private BasisNextidDaoImpl<ReturnInterHdrsInt> returnInterHdrsIntDAO;
	private BasisNextidDaoImpl<ReturnInterDtlsInt> returnInterDtlsIntDAO;


	@Override
	public void save(ReturnInterHdrsInt returnInterHdrsInt) {
		getReturnInterHdrsIntDAO().save(returnInterHdrsInt);
		
	}

	@Override
	public void save(ReturnInterDtlsInt returnInterDtlsInt) {
		getReturnInterDtlsIntDAO().save(returnInterDtlsInt);
		
	}

	@Override
	public List<ReturnInterHdrsInt> getAllSendReturn() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ReturnInterHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("sendFlag",
				RefCodeConstant.BOOLEAN_YES));
		return returnInterHdrsIntDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public void updateSendFlag(String sendFlagValue, String ptjCode, String factCode) {
		StringBuilder updateStr = new StringBuilder();
		updateStr
				.append("update ReturnInterHdrsInt e ")
				.append(" set ")
				.append(" e.sendFlag = :sendFlagValue")
				.append(" where ")
				.append(" e.toFacilityCode = :factCode and e.toPtjCode = :ptjCode ");
		Session session = returnInterHdrsIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(updateStr.toString());
		query.setParameter("sendFlagValue", sendFlagValue);
		query.setParameter("factCode", factCode);
		query.setParameter("ptjCode", ptjCode);
		query.executeUpdate();
		session.close();

	}
	
	public BasisNextidDaoImpl<ReturnInterHdrsInt> getReturnInterHdrsIntDAO() {
		// TODO Auto-generated method stub
		return returnInterHdrsIntDAO;
	}

	

	public BasisNextidDaoImpl<ReturnInterDtlsInt> getReturnInterDtlsIntDAO() {
		return returnInterDtlsIntDAO;
	}

	public void setReturnInterDtlsIntDAO(BasisNextidDaoImpl<ReturnInterDtlsInt> returnInterDtlsIntDAO) {
		this.returnInterDtlsIntDAO = returnInterDtlsIntDAO;
	}

	public void setReturnInterHdrsIntDAO(BasisNextidDaoImpl<ReturnInterHdrsInt> returnInterHdrsIntDAO) {
		this.returnInterHdrsIntDAO = returnInterHdrsIntDAO;
	}

	
	
	
	
	
	
	
}
