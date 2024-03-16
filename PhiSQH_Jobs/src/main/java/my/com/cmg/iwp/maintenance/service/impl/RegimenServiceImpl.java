package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Regimen;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.RegimenService;
@Service
public class RegimenServiceImpl implements RegimenService {
	private BasisNextidDaoImpl<Regimen> regimenDAO;

	public BasisNextidDaoImpl<Regimen> getRegimenDAO() {
		return regimenDAO;
	}

	public void setRegimenDAO(BasisNextidDaoImpl<Regimen> regimenDAO) {
		this.regimenDAO = regimenDAO;
	}

	@Override
	public Regimen getNewRegimen() {
		return new Regimen();
	}

	@Override
	public void delete(Regimen anRegimen) {
		regimenDAO.delete(anRegimen);
	}

	@Override
	public void saveOrUpdate(Regimen anRegimen) {
		regimenDAO.saveOrUpdate(anRegimen);
	}

	@Override
	public List<Regimen> getAllRegimen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Regimen findByRegimenCode(String regimenCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Regimen.class);
		criteria.add(Restrictions.eq("rgmCode", regimenCode));
		return DataAccessUtils
				.uniqueResult(regimenDAO.findByCriteria(criteria));
	}
	
	@Override
	public Regimen getRegimenByRrmSeqNo(long rgmSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Regimen.class);
		criteria.add(Restrictions.eq("rgmSeqno", rgmSeqno));
		return DataAccessUtils.uniqueResult(regimenDAO.findByCriteria(criteria));
	}

	@Override
	public ResultObject getRegimensNameInfusionLikeText(
			String searchRegimenCode, String searchRegimenName,
			String searchCategory, int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Regimen.class);

		if (!StringUtils.isEmpty(searchRegimenName)) {
			criteria.add(Restrictions.ilike("rgmDesc", searchRegimenName,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchRegimenName)) {
			criteria.add(Restrictions.ilike("rgmCode", searchRegimenCode,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchCategory)) {
			criteria.add(Restrictions.ilike("category", searchCategory,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("rgmDesc"));

		int totalCount = getRegimenDAO().findByCriteria(criteria).size();

		List<Regimen> list = getRegimenDAO().findByCriteria(criteria, start,
				pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public List<Regimen> getRegimenByRgmCode(String rgmCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Regimen.class);
		criteria.add(Restrictions.eq("rgmCode", rgmCode));
		return regimenDAO.findByCriteria(criteria);
	}
}
