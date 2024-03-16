package my.com.cmg.iwp.maintenance.service.impl;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.GenericNameAtc;
import my.com.cmg.iwp.maintenance.service.GenericNameAtcService;
@Service
public class GenericNameAtcServiceImpl implements GenericNameAtcService {

	private BasisNextidDaoImpl<GenericNameAtc> genericNameAtcDAO;

	public void setGenericNameAtcDAO(
			BasisNextidDaoImpl<GenericNameAtc> genericNameAtcDAO) {
		this.genericNameAtcDAO = genericNameAtcDAO;
	}

	public BasisNextidDaoImpl<GenericNameAtc> getGenericNameAtcDAO() {
		return genericNameAtcDAO;
	}

	@Override
	public GenericNameAtc getNewGenericNameAtc() {
		return new GenericNameAtc();
	}

	@Override
	public void delete(GenericNameAtc genericNameAtc) {

		genericNameAtcDAO.delete(genericNameAtc);

	}

	@Override
	public void saveOrUpdate(GenericNameAtc genericNameAtc) {

		genericNameAtcDAO.saveOrUpdate(genericNameAtc);

	}

	@Override
	public GenericNameAtc findAtcCode(AtcDetail atcDetail,
			GenericName genericName) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(GenericNameAtc.class);
		criteria.createAlias("atcDetail", "atcDetail");
		Criterion crit1 = Restrictions.eq("atcDetail", atcDetail);
		Criterion crit2 = Restrictions.eq("genericName", genericName);
		criteria.add(Restrictions.and(crit1, crit2));
		return DataAccessUtils.uniqueResult(genericNameAtcDAO
				.findByCriteria(criteria));

	}

	@Override
	public boolean isNewGenericNameAtc(GenericNameAtc genericNameAtc) {
		return genericNameAtc.getGenatcSeqno() == Long.MIN_VALUE;
	}
}
