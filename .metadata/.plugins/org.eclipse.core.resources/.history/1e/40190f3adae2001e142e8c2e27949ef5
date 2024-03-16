package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.report.stg.BudgetSummaryStg;
import my.com.cmg.iwp.maintenance.service.BudgetSummaryService;
@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

	private final static transient Logger logger = Logger.getLogger(BudgetSummaryServiceImpl.class.getName());

	BasisNextidDaoImpl generalDAO;

	public BasisNextidDaoImpl getGeneralDAO() {
		return generalDAO;
	}

	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
		this.generalDAO = generalDAO;
	}

	@Override
	public List<BudgetSummaryStg> getListBudgetSummaryStgBean(long stgCreatedBy) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BudgetSummaryStg.class);
		detachedCriteria.add(Restrictions.eq("stgCreatedBy", stgCreatedBy));
		
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getGeneralDAO().findByCriteria(detachedCriteria);
	
	}
}
