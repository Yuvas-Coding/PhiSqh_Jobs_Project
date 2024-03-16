package my.com.cmg.iwp.backend.service.integration.cdr.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.cdr.CdrHdrInt;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrHdrIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class CdrHdrIntServiceImpl implements CdrHdrIntService {
	private BasisNextidDaoImpl<CdrHdrInt> cdrHdrIntDAO;

	@Override
	public void refresh(CdrHdrInt cdrHdrInt) {
		getCdrHdrIntDAO().refresh(cdrHdrInt);
		getCdrHdrIntDAO().initialize(cdrHdrInt);
	}

	@Override
	public void saveOrUpdate(CdrHdrInt cdrHdrInt) {
		getCdrHdrIntDAO().saveOrUpdate(cdrHdrInt);
	}

	@Override
	public void save(CdrHdrInt cdrHdrInt) {
		getCdrHdrIntDAO().save(cdrHdrInt);
	}

	@Override
	public void findById(long id) {
		getCdrHdrIntDAO().get(CdrHdrInt.class, id);
	}

	@Override
	public List<CdrHdrInt> getAllSendRecord() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CdrHdrInt.class);
		criteria.add(Restrictions.eq("sendFlag", RefCodeConstant.BOOLEAN_YES));
		criteria.setFetchMode("cdrInfusionDrugsInts", FetchMode.JOIN);
		criteria.setFetchMode("cdrNormalDrugsInts", FetchMode.JOIN);
		criteria.setFetchMode("cdrInfusionDrugsInts.cdrDoseFrequencyInts",
				FetchMode.JOIN);
		criteria.setFetchMode("cdrNormalDrugsInts.cdrDoseFrequencyInts",
				FetchMode.JOIN);
		return getCdrHdrIntDAO().findByCriteria(criteria);

	}

	public BasisNextidDaoImpl<CdrHdrInt> getCdrHdrIntDAO() {
		return cdrHdrIntDAO;
	}

	public void setCdrHdrIntDAO(BasisNextidDaoImpl<CdrHdrInt> cdrHdrIntDAO) {
		this.cdrHdrIntDAO = cdrHdrIntDAO;
	}

}
