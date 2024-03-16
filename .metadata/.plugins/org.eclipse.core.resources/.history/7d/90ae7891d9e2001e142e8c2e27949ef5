package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.RPElementDrugs;
import my.com.cmg.iwp.maintenance.model.RpElement;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.RpElementService;
@Service
public class RpElementServiceImpl implements RpElementService {

	private BasisNextidDaoImpl<RpElement> rpElementDAO;

	public BasisNextidDaoImpl<RpElement> getRpElementDAO() {
		return rpElementDAO;
	}

	public void setRpElementDAO(BasisNextidDaoImpl<RpElement> rpElementDAO) {
		this.rpElementDAO = rpElementDAO;
	}

	@Override
	public void delete(RpElement anRpElement) {
		rpElementDAO.delete(anRpElement);
	}

	@Override
	public void saveOrUpdate(RpElement anRpElement) {
		rpElementDAO.saveOrUpdate(anRpElement);
	}

	public RpElement getNewRpElement() {

		return new RpElement();
	}
	
	public RPElementDrugs getNewRpElementDrugs() {
		return new RPElementDrugs();
	}

	@Override
	public RpElement getRpElementByElement(String groupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RpElement.class);
		criteria.add(Restrictions.eq("element", groupCode));

		return DataAccessUtils.uniqueResult(rpElementDAO
				.findByCriteria(criteria));
	}

	public List<RpElement> getAllRpElements() {

		DetachedCriteria criteria = DetachedCriteria.forClass(RpElement.class);
		criteria.addOrder(Order.asc("element"));

		return rpElementDAO.findByCriteria(criteria);
	}

	@Override
	public void addRpElementDrugs(RpElement rpElement, Drug drug, SecUser user) {
		if(rpElement.getRpElementDrugs() == null) rpElement.setRpElementDrugs(new HashSet<RPElementDrugs>());
		RPElementDrugs rpElementDrugs = getNewRpElementDrugs();
		rpElementDrugs.setRpElement(rpElement);
		rpElementDrugs.setDrug(drug);
		Date currentDate = new Date();
		rpElementDrugs.setCreatedDate(currentDate);
		rpElementDrugs.setUpdatedDate(currentDate);
		rpElementDrugs.setCreatedBy(user.getId());
		rpElementDrugs.setUpdatedBy(user.getId());
		rpElement.getRpElementDrugs().add(rpElementDrugs);
	}
}