package my.com.cmg.iwp.maintenance.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.RegimenCategory;
import my.com.cmg.iwp.maintenance.service.RegimenCategoryService;
@Service
public class RegimenCategoryServiceImpl implements RegimenCategoryService {

	private BasisNextidDaoImpl<RegimenCategory> regimenCategoryDAO;

	public BasisNextidDaoImpl<RegimenCategory> getRegimenCategoryDAO() {
		return regimenCategoryDAO;
	}

	public void setRegimenCategoryDAO(
			BasisNextidDaoImpl<RegimenCategory> regimenCategoryDAO) {
		this.regimenCategoryDAO = regimenCategoryDAO;
	}

	@Override
	public void saveOrUpdate(RegimenCategory regimenCategory) {
		regimenCategoryDAO.saveOrUpdate(regimenCategory);

	}

	@Override
	public void delete(RegimenCategory regimenCategory) {
		regimenCategoryDAO.delete(regimenCategory);

	}

	@Override
	public List<RegimenCategory> getRegimenCategoryByCategory(String category) {
		Session session = regimenCategoryDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RegimenCategory.class);
		criteria.add(Restrictions.eq("category", category));
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		List<RegimenCategory> regimenCategories = criteria.list();
		session.close();
		return regimenCategories;
	}

	@Override
	public Set<RegimenCategory> getAllRegimenCategory(String category) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RegimenCategory.class);
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		if(null != category)
			criteria.add(Restrictions.eq("category", category));
		return new HashSet<RegimenCategory>(regimenCategoryDAO.findByCriteria(criteria));
	}
}
