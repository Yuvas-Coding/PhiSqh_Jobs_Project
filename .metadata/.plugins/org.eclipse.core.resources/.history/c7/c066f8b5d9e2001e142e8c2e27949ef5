package my.com.cmg.iwp.backend.service.pharmacy.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.pharmacy.Occupation;
import my.com.cmg.iwp.backend.service.pharmacy.OccupationService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class OccupationServiceImpl implements OccupationService {
    private BasisNextidDaoImpl generalDAO;

    @Override
    public void saveOrUpdate(Occupation occupation) {
	generalDAO.saveOrUpdate(occupation);
    }

    public BasisNextidDaoImpl getGeneralDAO() {
	return generalDAO;
    }

    public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
	this.generalDAO = generalDAO;
    }
    
    @Override
    public Occupation getOccupationByOccupationCode(String code){
    	DetachedCriteria criteria = DetachedCriteria.forClass(Occupation.class);
		criteria.add(Restrictions.ilike("occuCode", code, MatchMode.EXACT));
		return (Occupation) DataAccessUtils.uniqueResult(generalDAO.findByCriteria(criteria));
    }

	@Override
	public Occupation getOccupation() {
		return new Occupation();
	}

}
