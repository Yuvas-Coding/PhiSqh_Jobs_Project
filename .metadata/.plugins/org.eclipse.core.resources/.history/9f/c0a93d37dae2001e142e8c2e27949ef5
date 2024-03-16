package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.TdmGuidelineHdrs;
import my.com.cmg.iwp.maintenance.service.TdmGuidelineHdrsService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class TdmGuidelineHdrsServiceImpl implements TdmGuidelineHdrsService {

	private BasisNextidDaoImpl<TdmGuidelineHdrs> tdmGuidelineHdrsDAO;

	public BasisNextidDaoImpl<TdmGuidelineHdrs> getTdmGuidelineHdrsDAO() {
		return tdmGuidelineHdrsDAO;
	}

	public void setTdmGuidelineHdrsDAO(
			BasisNextidDaoImpl<TdmGuidelineHdrs> tdmGuidelineHdrsDAO) {
		this.tdmGuidelineHdrsDAO = tdmGuidelineHdrsDAO;
	}

	@Override
	public TdmGuidelineHdrs getNewTdmGuidelineHdrs() {
		return new TdmGuidelineHdrs();
	}

	@Override
	public void delete(TdmGuidelineHdrs tdmGuidelineHdrs) {
		tdmGuidelineHdrsDAO.delete(tdmGuidelineHdrs);
	}

	@Override
	public void saveOrUpdate(TdmGuidelineHdrs tdmGuidelineHdrs) {
		tdmGuidelineHdrsDAO.saveOrUpdate(tdmGuidelineHdrs);
	}

	@Override
	public TdmGuidelineHdrs findBySeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TdmGuidelineHdrs.class);
		criteria.add(Restrictions.eq("drug.drugSeqno", seqNo));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return DataAccessUtils.uniqueResult(tdmGuidelineHdrsDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public TdmGuidelineHdrs findByGuidelineSeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TdmGuidelineHdrs.class);
		criteria.setFetchMode("drug", FetchMode.JOIN);
		criteria.add(Restrictions.eq("hdrGuidlineSeqno", seqNo));
		criteria.createAlias("tdmGuidlines","guideline",
		CriteriaSpecification.LEFT_JOIN).createAlias("tdmCalculator","calculator",CriteriaSpecification.LEFT_JOIN);
		return DataAccessUtils.uniqueResult(tdmGuidelineHdrsDAO.findByCriteria(criteria));
	}

}
