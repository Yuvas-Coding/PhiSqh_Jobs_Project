package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.TpnSourceContent;
import my.com.cmg.iwp.maintenance.service.TpnSourceContentService;
@Service
public class TpnSourceContentServiceImpl implements TpnSourceContentService {

	private BasisNextidDaoImpl<TpnSourceContent> tpnSourceContentDAO;

	public BasisNextidDaoImpl<TpnSourceContent> getTpnSourceContentDAO() {
		return tpnSourceContentDAO;
	}

	public void setTpnSourceContentDAO(
			BasisNextidDaoImpl<TpnSourceContent> tpnSourceContentDAO) {
		this.tpnSourceContentDAO = tpnSourceContentDAO;
	}

	@Override
	public TpnSourceContent getNewTpnSourceContent() {
		return new TpnSourceContent();
	}

	@Override
	public void delete(TpnSourceContent tpnSourceContent) {
		tpnSourceContentDAO.delete(tpnSourceContent);
	}

	@Override
	public void saveOrUpdate(TpnSourceContent tpnSourceContent) {
		tpnSourceContentDAO.saveOrUpdate(tpnSourceContent);
	}

	@Override
	public TpnSourceContent findBySeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TpnSourceContent.class);
		criteria.add(Restrictions.eq("tpnSourceContentSeqno", seqNo));
		return DataAccessUtils.uniqueResult(tpnSourceContentDAO
				.findByCriteria(criteria));
	}

	@Override
	public TpnSourceContent findByDrugSeqNo(Drug drug) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TpnSourceContent.class);
		criteria.add(Restrictions.eq("drug", drug));
		return DataAccessUtils.uniqueResult(tpnSourceContentDAO
				.findByCriteria(criteria));
	}

}
