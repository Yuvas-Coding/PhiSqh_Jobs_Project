package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService {

	private BasisNextidDaoImpl<Brand> brandDAO;

	@Override
	public Brand getNewBrand() {

		return new Brand();
	}

	public void setBrandDAO(BasisNextidDaoImpl<Brand> brandDAO) {
		this.brandDAO = brandDAO;
	}

	public BasisNextidDaoImpl<Brand> getBrandDAO() {
		return brandDAO;
	}

	@Override
	public Brand get(Class<Brand> entityClass, long brandSeqNo) {

		return brandDAO.get(entityClass, brandSeqNo);
	}

	@Override
	public void delete(Brand anBrand) {
		brandDAO.delete(anBrand);
	}

	@Override
	public void saveOrUpdate(Brand anBrand) {
		brandDAO.saveOrUpdate(anBrand);
	}

	@Override
	public String findbyBrandCode(String value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Brand.class);
		criteria.add(Restrictions.eq("brdCode", value));
		if (brandDAO.findByCriteria(criteria).get(0) != null) {
			return "invalid";
		} else {
			return "valid";
		}
	}

	@Override
	public String findbyBrandName(String value) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Brand.class);
		criteria.add(Restrictions.eq("brdName", value));
		if (brandDAO.findByCriteria(criteria).get(0) != null) {
			return "invalid";
		} else {
			return "valid";
		}
	}
	@Override
	public Brand findByBrandName(String brandrName) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Brand.class).add(Restrictions.sqlRestriction("rownum =1"));
		criteria.add(Restrictions.eq("brdName", brandrName).ignoreCase());
		return DataAccessUtils.uniqueResult(brandDAO
				.findByCriteria(criteria));
	}
	@Override
	public Brand findByBrandCode(String brandCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Brand.class);
		criteria.add(Restrictions.ilike("brdCode", brandCode, MatchMode.EXACT));
		return DataAccessUtils.uniqueResult(brandDAO.findByCriteria(criteria));
	}

	public ResultObject getAllDrugsBrandNameLikeText(String searchBrandName,
			int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Brand.class);

		if (!StringUtils.isEmpty(searchBrandName)) {
			criteria.add(Restrictions.ilike("brdName", searchBrandName,
					MatchMode.START));
		}

		/*
		 * if (!StringUtils.isEmpty(searchAdminRoute)) {
		 * criteria.add(Restrictions.ilike("defaultRoute", searchAdminRoute,
		 * MatchMode.ANYWHERE)); } if (!StringUtils.isEmpty(searchDosageForm)) {
		 * criteria.add(Restrictions.ilike("dosageForm", searchDosageForm,
		 * MatchMode.ANYWHERE)); }
		 */

		criteria.addOrder(Order.asc("brdName"));

		int totalCount = getBrandDAO().findByCriteria(criteria).size();

		List<Brand> list = brandDAO.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

}
