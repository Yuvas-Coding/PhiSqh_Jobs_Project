package my.com.cmg.iwp.maintenance.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BudgetADTDAOImpl;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.report.stg.YtdPurchaseByItemStg;
import my.com.cmg.iwp.maintenance.service.YTDPurchaseByItemService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class YTDPurchaseByItemServiceImpl implements YTDPurchaseByItemService {
	private BudgetADTDAOImpl budgetADTdao;

	public SecUser getSecUserFetches(SecUser secUser) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if(secUser!=null)
			detachedCriteria.add(Restrictions.eq("usrLoginname",secUser.getUsrLoginname()));
		
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		return (SecUser) budgetADTdao.findByCriteria(detachedCriteria).get(0);
	}
	@Override
	public List<ExternalFacility> getCLNListByPtjCode(String ptjCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(ExternalFacility.class);
		List<String> facilityList = new ArrayList<String>();
		facilityList.add(RefCodeConstant.FACILITY_CATEGORY_KK);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		detachedCriteria.add(Restrictions.in("facilityList", facilityList));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

	public BudgetADTDAOImpl getBudgetADTdao() {
		return budgetADTdao;
	}


	public void setBudgetADTdao(BudgetADTDAOImpl budgetADTdao) {
		this.budgetADTdao = budgetADTdao;
	}
	@Override
	public List<YtdPurchaseByItemStg> getYtdPurchaseByItemStg(long userid) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(YtdPurchaseByItemStg.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("createdBy", userid));
		return budgetADTdao.findByCriteria(detachedCriteria);
	}

}
