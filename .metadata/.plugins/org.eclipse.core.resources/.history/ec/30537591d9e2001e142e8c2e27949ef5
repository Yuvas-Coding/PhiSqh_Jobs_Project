package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.RequesterGroup;
import my.com.cmg.iwp.maintenance.service.RequesterUnitGroupService;
@Service
public class RequesterUnitGroupServiceImpl implements RequesterUnitGroupService {

	private BasisNextidDaoImpl<RequesterGroup> requesterGroupDAO;

	// private BasisNextidDaoImpl<AddressBook> addressBookDAO;

	public BasisNextidDaoImpl<RequesterGroup> getRequesterGroupDAO() {
		return requesterGroupDAO;
	}

	public void setRequesterGroupDAO(
			BasisNextidDaoImpl<RequesterGroup> requesterGroupDAO) {
		this.requesterGroupDAO = requesterGroupDAO;
	}

	@Override
	public void delete(RequesterGroup anRequesterGroup) {
		requesterGroupDAO.delete(anRequesterGroup);
	}

	@Override
	public void saveOrUpdate(RequesterGroup anRequesterGroup) {
		requesterGroupDAO.saveOrUpdate(anRequesterGroup);
	}

	public RequesterGroup getNewRequesterUnitGroup() {

		return new RequesterGroup();
	}

	@Override
	public RequesterGroup getRequesterUnitGroup(String groupCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterGroup.class);
		criteria.add(Restrictions.eq("groupCode", groupCode));

		return DataAccessUtils.uniqueResult(requesterGroupDAO
				.findByCriteria(criteria));
	}

	public List<RequesterGroup> getAllRequesterUnitGroupCodes() {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterGroup.class);
		criteria.add(Restrictions.eq("activeFlag", 'A'));
		criteria.addOrder(Order.asc("groupCode"));

		return requesterGroupDAO.findByCriteria(criteria);
	}

	@Override
	public RequesterGroup getRequesterUnitGroupByGroupName(String groupName) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterGroup.class);
		criteria.add(Restrictions.eq("groupName", groupName));

		return DataAccessUtils.uniqueResult(requesterGroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public RequesterGroup getRequesterUnitGroupByGroupSeqno(Long groupSeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RequesterGroup.class);
		criteria.add(Restrictions.eq("groupSeqno", groupSeqno));

		return DataAccessUtils.uniqueResult(requesterGroupDAO
				.findByCriteria(criteria));
	}

	@Override
	public boolean isNewItem(RequesterGroup requesterGroup) {
		return requesterGroup.getGroupSeqno() == Long.MIN_VALUE;
	}
	
	@Override
	public String getUnitGroupCode() {
		Session session = requesterGroupDAO.getSessionFactory().openSession();
		Query query = session.createSQLQuery( "SELECT T_REQUESTER_GROUPS_SEQ.nextval from dual" );
		String SeqNo = query.list().iterator().next().toString();
		String unitGroupCode = "UG";
		int len = SeqNo.length();
		String txnDummy = "";
		if (len < 3) {
			for (int i = 0; i < 3 - len; i++) {
				txnDummy += "0";
			}
		}
		unitGroupCode += txnDummy + SeqNo;
		session.close();
		return unitGroupCode;
	}
}
