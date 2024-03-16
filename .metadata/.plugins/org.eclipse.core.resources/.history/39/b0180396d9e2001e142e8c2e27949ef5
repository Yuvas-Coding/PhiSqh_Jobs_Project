package my.com.cmg.iwp.backend.service.pharmacy.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.pharmacy.TownCodes;
import my.com.cmg.iwp.backend.service.pharmacy.TownCodeService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class TownCodeSreviceImpl implements TownCodeService {
	private BasisNextidDaoImpl generalDAO;

	@Override
	public void saveOrUpdate(TownCodes townCodes) {
		generalDAO.saveOrUpdate(townCodes);
	}

	public BasisNextidDaoImpl getGeneralDAO() {
		return generalDAO;
	}

	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
		this.generalDAO = generalDAO;
	}
	
	@Override
	public TownCodes findByTowncodes(String code){
		DetachedCriteria criteria = DetachedCriteria.forClass(TownCodes.class);
		criteria.add(Restrictions.ilike("tcCode", code, MatchMode.EXACT));
		return (TownCodes) DataAccessUtils.uniqueResult(generalDAO.findByCriteria(criteria));
	}

	@Override
	public TownCodes getTownCodes() {
		return new TownCodes();
	}

}
