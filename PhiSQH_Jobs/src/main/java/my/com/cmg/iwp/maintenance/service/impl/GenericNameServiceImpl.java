package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.GenericNameService;
@Service
public class GenericNameServiceImpl implements GenericNameService {

	private BasisNextidDaoImpl<GenericName> genericNameDAO;

	public BasisNextidDaoImpl<GenericName> getGenericNameDAO() {
		return genericNameDAO;
	}

	public void setGenericNameDAO(BasisNextidDaoImpl<GenericName> genericNameDAO) {
		this.genericNameDAO = genericNameDAO;
	}

	@Override
	public void delete(GenericName genericName) {
		genericNameDAO.delete(genericName);
	}

	@Override
	public void saveOrUpdate(GenericName genericName) {

		genericNameDAO.saveOrUpdate(genericName);

	}

	@Override
	public GenericName getNewGenericName() {
		return new GenericName();
	}

	@Override
	public List<GenericName> getAllGenericName() {
		return genericNameDAO.loadAll(GenericName.class);
	}

	@Override
	public AtcDetail getNewAtcDetail() {
		return new AtcDetail();
	}

	@Override
	public List<GenericName> findByGenericDesc(String genericDesc) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(GenericName.class);
		criteria.add(Restrictions.eq("genericDesc", genericDesc));
		return genericNameDAO.findByCriteria(criteria);
	}

	@Override
	public ResultObject getAllGenericNameLikeText(String searchGenericCode,
			String searchGenericName, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(GenericName.class);

		// if (!StringUtils.isEmpty(searchGenericCode)) {
		// criteria.add(Restrictions.ilike("genericCode", searchGenericCode,
		// MatchMode.START));
		// }
		if (!StringUtils.isEmpty(searchGenericCode)) {
			criteria.add(Restrictions.ilike("genericCode", searchGenericCode,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchGenericName)) {
			criteria.add(Restrictions.ilike("genericDesc", searchGenericName,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("genericCode"));

		int totalCount = getGenericNameDAO().findByCriteria(criteria).size();

		List<GenericName> list = getGenericNameDAO().findByCriteria(criteria,
				start, pageSize);

		return new ResultObject(list, totalCount);

	}

	@Override
	public GenericName findByGenericCode(String genericCode) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(GenericName.class);
		criteria.add(Restrictions.eq("genericCode", genericCode));
		return DataAccessUtils.uniqueResult(genericNameDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public boolean isNewGenericName(GenericName genericName) {
		return genericName.getGenericSeqno() == Long.MIN_VALUE;
	}

	@Override
	public String getMimsMapping(GenericName genericName) {		
		Session session = null;
		String returnValue = "";
		String sql = "select (phis_acti_code || ' ; '|| mims_acti_desc) FROM T_MIMS_ACT_INGR_MAPPING WHERE PHIS_ACTI_CODE = '" +genericName.getGenericDesc() + "'"; 
		try {
			session = genericNameDAO.getSessionFactory().openSession();
			Query que = session.createSQLQuery(sql);
			List<Object> list = que.list();
			returnValue = null != list && !list.isEmpty() ? list.get(0).toString() : "";
			for (int i = 1; i < list.size()-1; i++) {
				returnValue += "; "+list.get(i).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnValue;
	}
}
