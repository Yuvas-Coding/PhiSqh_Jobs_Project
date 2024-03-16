package my.com.cmg.iwp.backend.service.integration.pn.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.pn.PnOrderRegimenInt;
import my.com.cmg.iwp.backend.service.integration.pn.PnOrderRegimenIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class PnOrderRegimenIntServiceImpl implements PnOrderRegimenIntService {

	private BasisNextidDaoImpl<PnOrderRegimenInt> pnOrderRegimenIntDAO;

	@Override
	public PnOrderRegimenInt findById(long id) {
		return getPnOrderRegimenIntDAO().get(PnOrderRegimenInt.class, id);
	}

	@Override
	public void saveOrUpdate(PnOrderRegimenInt pnOrderRegimenInt) {
		getPnOrderRegimenIntDAO().saveOrUpdate(pnOrderRegimenInt);
	}

	@Override
	public void save(PnOrderRegimenInt pnOrderRegimenInt) {
		getPnOrderRegimenIntDAO().save(pnOrderRegimenInt);
	}

	@Override
	public List<PnOrderRegimenInt> getAllSendRecord() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PnOrderRegimenInt.class);
		criteria.createCriteria("outsourceOrderInt", "out").add(
				Restrictions.eq("out.sendFlag", RefCodeConstant.BOOLEAN_YES));
		return getPnOrderRegimenIntDAO().findByCriteria(criteria);
	}

	public BasisNextidDaoImpl<PnOrderRegimenInt> getPnOrderRegimenIntDAO() {
		return pnOrderRegimenIntDAO;
	}

	public void setPnOrderRegimenIntDAO(
			BasisNextidDaoImpl<PnOrderRegimenInt> pnOrderRegimenIntDAO) {
		this.pnOrderRegimenIntDAO = pnOrderRegimenIntDAO;
	}

}
