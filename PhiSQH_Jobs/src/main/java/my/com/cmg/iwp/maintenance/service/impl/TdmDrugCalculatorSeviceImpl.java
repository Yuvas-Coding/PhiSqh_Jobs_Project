package my.com.cmg.iwp.maintenance.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.TdmDrugCalculator;
import my.com.cmg.iwp.maintenance.model.TdmGuidelineHdrs;
import my.com.cmg.iwp.maintenance.service.TdmDrugCalculatorService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class TdmDrugCalculatorSeviceImpl implements TdmDrugCalculatorService {

	private BasisNextidDaoImpl<TdmDrugCalculator> tdmDrugCalculatorDAO;

	/**
	 * @return the tdmDrugCalculatorDAO
	 */
	public BasisNextidDaoImpl<TdmDrugCalculator> getTdmDrugCalculatorDAO() {
		return tdmDrugCalculatorDAO;
	}

	/**
	 * @param tdmDrugCalculatorDAO the tdmDrugCalculatorDAO to set
	 */
	public void setTdmDrugCalculatorDAO(
			BasisNextidDaoImpl<TdmDrugCalculator> tdmDrugCalculatorDAO) {
		this.tdmDrugCalculatorDAO = tdmDrugCalculatorDAO;
	}
	
	@Override
	public TdmDrugCalculator getNewTdmDrugCalculator(){
		return new TdmDrugCalculator();
	}
	
	@Override
	public void delete(TdmDrugCalculator tdmDrugCalculator){
		tdmDrugCalculatorDAO.delete(tdmDrugCalculator);
	}
	
	@Override
	public void saveOrUpdate(TdmDrugCalculator tdmDrugCalculator){
		tdmDrugCalculatorDAO.saveOrUpdate(tdmDrugCalculator);
	}
	
	@Override
	public Set<TdmDrugCalculator> getTdmDrugCalculators(TdmGuidelineHdrs tdmGuidelineHdrs){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TdmDrugCalculator.class);
		detachedCriteria.add(Restrictions.eq("tdmGuidelineHdrs", tdmGuidelineHdrs));
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		
		Set<TdmDrugCalculator> tdmDrugCalculators = new HashSet<TdmDrugCalculator>();
		tdmDrugCalculators.addAll(tdmDrugCalculatorDAO.findByCriteria(detachedCriteria));
		return tdmDrugCalculators;
	}
	
	@Override
	public TdmDrugCalculator getTdmDrugCalculator(String calculatorCode,TdmGuidelineHdrs tdmGuidelineHdrs){
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TdmDrugCalculator.class);
		criteria.add(Restrictions.eq("tdmGuidelineHdrs", tdmGuidelineHdrs));
		criteria.add(Restrictions.eq("calculatorCode", calculatorCode));
		
		return DataAccessUtils.uniqueResult(tdmDrugCalculatorDAO.findByCriteria(criteria));
	}
}
