package my.com.cmg.iwp.maintenance.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.TdmGuidline;
import my.com.cmg.iwp.maintenance.service.TdmGuidlineService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class TdmGuidlineServiceImpl implements TdmGuidlineService {

	private BasisNextidDaoImpl<TdmGuidline> tdmGuidlineDAO;

	public BasisNextidDaoImpl<TdmGuidline> getTdmGuidlineDAO() {
		return tdmGuidlineDAO;
	}

	public void setTdmGuidlineDAO(BasisNextidDaoImpl<TdmGuidline> tdmGuidlineDAO) {
		this.tdmGuidlineDAO = tdmGuidlineDAO;
	}

	@Override
	public TdmGuidline getNewTdmGuidline() {
		return new TdmGuidline();
	}

	@Override
	public void delete(TdmGuidline tdmGuidline) {
		tdmGuidlineDAO.delete(tdmGuidline);
	}

	@Override
	public void saveOrUpdate(TdmGuidline tdmGuidline) {
		tdmGuidlineDAO.saveOrUpdate(tdmGuidline);
	}
	
	@Override
	public Set<TdmGuidline> findGuidelinesByHdrSeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TdmGuidline.class);
		criteria.setFetchMode("tdmGuidelineHdrs", FetchMode.JOIN);
		criteria.setFetchMode("uom", FetchMode.JOIN);
		criteria.add(Restrictions.eq("tdmGuidelineHdrs.hdrGuidlineSeqno", seqNo));	
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		List<TdmGuidline> list = tdmGuidlineDAO.findByCriteria(criteria);
		Set<TdmGuidline> set = new HashSet<TdmGuidline>(list);
		return set;
	}
}
