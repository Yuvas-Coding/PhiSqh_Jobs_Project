package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.SplDrugReqApprover;
import my.com.cmg.iwp.maintenance.service.SplDrugReqApproverService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class SplDrugReqApproverServiceImpl  implements SplDrugReqApproverService{
	
	private BasisNextidDaoImpl<SplDrugReqApprover> 	splDrugReqApproverDAO;

	public BasisNextidDaoImpl<SplDrugReqApprover> getSplDrugReqApproverDAO() {
		return splDrugReqApproverDAO;
	}

	public void setSplDrugReqApproverDAO(BasisNextidDaoImpl<SplDrugReqApprover> splDrugReqApproverDAO) {
		this.splDrugReqApproverDAO = splDrugReqApproverDAO;
	}
	
	
	@Override
	public SplDrugReqApprover getNewSplDrugReqApprover() {
		
		return new SplDrugReqApprover();
	}

	@Override
	public void saveOrUpdate(SplDrugReqApprover splDrugReqApprover) {
		
		splDrugReqApproverDAO.saveOrUpdate(splDrugReqApprover);
	}
	
	@Override
	public List getRecommendedByUser(String approverDomain)
	{
		List<SplDrugReqApprover> splDrugReqApprovers=new ArrayList<SplDrugReqApprover>();
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(SplDrugReqApprover.class);
		
		detachedCriteria.add(Restrictions.eq("approverDomain", approverDomain));
		detachedCriteria.add(Restrictions.eq("status",RefCodeConstant.STATUS_VALUE_ACTIVE));
		splDrugReqApprovers=splDrugReqApproverDAO.findByCriteria(detachedCriteria);
		if(splDrugReqApprovers.size()>0)
		return splDrugReqApprovers;
		else
		return null;

	}
	

	@Override
	public List getRecommendedByapproverValue(String approverValue)
	{
		List<SplDrugReqApprover> splDrugReqApprovers=new ArrayList<SplDrugReqApprover>();
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(SplDrugReqApprover.class);
		
		detachedCriteria.add(Restrictions.eq("approverValue", approverValue));
		detachedCriteria.add(Restrictions.eq("status",RefCodeConstant.STATUS_VALUE_ACTIVE));
		splDrugReqApprovers=splDrugReqApproverDAO.findByCriteria(detachedCriteria);
		if(splDrugReqApprovers.size()>0)
		return splDrugReqApprovers;
		else
		return null;

	}

}
