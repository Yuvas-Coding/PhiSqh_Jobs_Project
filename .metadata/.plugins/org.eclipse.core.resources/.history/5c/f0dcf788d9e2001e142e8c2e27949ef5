package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AltUom;
import my.com.cmg.iwp.maintenance.service.AltUomService;
@Service
public class AltUomServiceImpl implements AltUomService {

	private BasisNextidDaoImpl<AltUom> altUomDAO;

	public void setAltUomDAO(BasisNextidDaoImpl<AltUom> altUomDAO) {
		this.altUomDAO = altUomDAO;
	}

	public BasisNextidDaoImpl<AltUom> getAltUomDAO() {
		return altUomDAO;
	}

	@Override
	public AltUom getAltUomSeqno(AltUom altUom) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AltUom.class);
		criteria.add(Restrictions.eq("altUomSeqno", altUom.getAltUomSeqno()));
		return DataAccessUtils.uniqueResult(altUomDAO.findByCriteria(criteria));
	}
}
