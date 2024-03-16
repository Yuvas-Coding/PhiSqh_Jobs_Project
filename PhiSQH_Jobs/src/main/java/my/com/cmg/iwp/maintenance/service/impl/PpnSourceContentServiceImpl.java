package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.PpnSourceContent;
import my.com.cmg.iwp.maintenance.service.PpnSourceContentService;
@Service
public class PpnSourceContentServiceImpl implements PpnSourceContentService {

	private BasisNextidDaoImpl<PpnSourceContent> ppnSourceContentDAO;

	public BasisNextidDaoImpl<PpnSourceContent> getPpnSourceContentDAO() {
		return ppnSourceContentDAO;
	}

	public void setPpnSourceContentDAO(
			BasisNextidDaoImpl<PpnSourceContent> ppnSourceContentDAO) {
		this.ppnSourceContentDAO = ppnSourceContentDAO;
	}

	@Override
	public PpnSourceContent getNewPpnSourceContent() {
		return new PpnSourceContent();
	}

	@Override
	public void delete(PpnSourceContent ppnSourceContent) {
		ppnSourceContentDAO.delete(ppnSourceContent);
	}

	@Override
	public void saveOrUpdate(PpnSourceContent ppnSourceContent) {
		ppnSourceContentDAO.saveOrUpdate(ppnSourceContent);
	}

	@Override
	public PpnSourceContent findBySeqNo(long seqNo) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PpnSourceContent.class);
		criteria.add(Restrictions.eq("ppnSourceContentSeqno", seqNo));
		return DataAccessUtils.uniqueResult(ppnSourceContentDAO
				.findByCriteria(criteria));
	}

	@Override
	public PpnSourceContent findByDrugSeqNo(Drug drug) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PpnSourceContent.class);
		criteria.add(Restrictions.eq("drug", drug));
		return DataAccessUtils.uniqueResult(ppnSourceContentDAO
				.findByCriteria(criteria));
	}

}
