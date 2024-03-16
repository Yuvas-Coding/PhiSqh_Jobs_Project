package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.RequesterGroup;
import my.com.cmg.iwp.maintenance.model.RequesterUnit;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.RequesterUnitService;
@Service
public class RequesterUnitServiceImpl implements RequesterUnitService {

	private BasisNextidDaoImpl<RequesterUnit> requesterUnitDAO;

	public BasisNextidDaoImpl<RequesterUnit> getRequesterUnitDAO() {
		return requesterUnitDAO;
	}

	public void setRequesterUnitDAO(
			BasisNextidDaoImpl<RequesterUnit> requesterUnitDAO) {
		this.requesterUnitDAO = requesterUnitDAO;
	}

	@Override
	public RequesterUnit getNewRequesterUnit() {
		return new RequesterUnit();
	}

	@Override
	public void delete(RequesterUnit anRequesterUnit) {
		requesterUnitDAO.delete(anRequesterUnit);
	}

	@Override
	public void saveOrUpdate(RequesterUnit anRequesterUnit) {
		requesterUnitDAO.saveOrUpdate(anRequesterUnit);
	}

	@Override
	public RequesterUnit getRequesterUnit(String rqstrCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);
		criteria.add(Restrictions.eq("rqstrCode", rqstrCode).ignoreCase());
		return DataAccessUtils.uniqueResult(requesterUnitDAO
				.findByCriteria(criteria));

	}

	@Override
	public RequesterUnit getRequesterUnitByUnitName(String unitName) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);
		criteria.add(Restrictions.eq("rqstrDesc", unitName).ignoreCase());
		return DataAccessUtils.uniqueResult(requesterUnitDAO
				.findByCriteria(criteria));

	}

	@Override
	public RequesterUnit getRequesterUnitGroup(String Unit_group) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);
		criteria.add(Restrictions.eq("unitGroup", Unit_group));
		return requesterUnitDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public RequesterUnit getRequesterUnitBySeqNo(long rqstrSeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);
		criteria.add(Restrictions.eq("rqstrSeqno", rqstrSeqno));
		return requesterUnitDAO.findByCriteria(criteria).get(0);
	}

	@Override
	public ResultObject getAllRequesterUnitLikeText(String txtUnitCode,
			String txtDesc, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);

		if (!StringUtils.isEmpty(txtUnitCode)) {
			criteria.add(Restrictions.ilike("rqstrCode", txtUnitCode,
					MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(txtDesc)) {
			criteria.add(Restrictions.ilike("rqstrDesc", txtDesc,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("rqstrCode"));

		int totalCount = getRequesterUnitDAO().findByCriteria(criteria).size();

		List<RequesterUnit> list = getRequesterUnitDAO().findByCriteria(
				criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

	@Override
	public RequesterUnit getAllRequesterUnitBySeq_desc(long reqSeqNo,
			String desc) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterUnit.class);
		Criterion criterion1 = Restrictions.eq("rqstrSeqno", reqSeqNo);
		Criterion criterion2 = Restrictions.eq("rqstrDesc", desc);
		criteria.add(Restrictions.and(criterion1, criterion2));
		return DataAccessUtils.uniqueResult(requesterUnitDAO
				.findByCriteria(criteria));
	}

	@Override
	public RequesterGroup getRequesterGroupByUnitSeqno(long rqstrSeqno) {
		Session session = requesterUnitDAO.getSessionFactory().openSession();
		StringBuilder queryStr = new StringBuilder();
		queryStr.append(
				"select distinct rg from RequesterUnit e inner join e.requesterGroup rg ")
				.append(" where e.rqstrSeqno = :rqstrSeqno ");
		Query query = session.createQuery(queryStr.toString());
		query.setParameter("rqstrSeqno", rqstrSeqno);
		List<RequesterGroup> requestGroups = query.list();
		session.close();
		return requestGroups.isEmpty() ? null : requestGroups.get(0);
	}

}
