package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.PTJCode;
import my.com.cmg.iwp.maintenance.service.ptjCodeService;
@Service
public class ptjCodeServiceImpl implements ptjCodeService {

	private BasisNextidDaoImpl<PTJCode> ptjCodeDAO;

	@Override
	public PTJCode getNewPtjCode() {
		return new PTJCode();
	}

	@Override
	public void delete(PTJCode anPTJCode) {
		ptjCodeDAO.delete(anPTJCode);

	}

	@Override
	public void saveOrUpdate(PTJCode anPTJCode) {
		ptjCodeDAO.saveOrUpdate(anPTJCode);

	}

	public void setPtjCodeDAO(
			BasisNextidDaoImpl<PTJCode> ptjCodeDAO) {
		this.ptjCodeDAO = ptjCodeDAO;
	}

	public BasisNextidDaoImpl<PTJCode> getPtjCodeDAO() {
		return ptjCodeDAO;
	}

	public PTJCode findPtjCodeByCode(String ptjCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PTJCode.class);
		criteria.add(Restrictions.eq("ptjCode", ptjCode));
		return DataAccessUtils.uniqueResult(ptjCodeDAO
				.findByCriteria(criteria));
	}

	@Override
	public PTJCode findPtjCode(long queryString) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PTJCode.class);
		criteria.add(Restrictions.eq("itmCatSeqno", queryString));
		return DataAccessUtils.uniqueResult(ptjCodeDAO
				.findByCriteria(criteria));
	}

}
