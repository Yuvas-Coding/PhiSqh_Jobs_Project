package my.com.cmg.iwp.backend.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.NotificationHdr;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.NotificationHdrService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.util.CommonUtil;
import my.com.cmg.iwp.webui.util.DateUtil;
@Service
public class NotificationHdrServiceImpl implements NotificationHdrService {
	
	private BasisNextidDaoImpl<NotificationHdr> notificationHdrDAO;

	@Override
	public List<NotificationHdr> getNotification(SecUser user) {
		StringBuffer querySql = new StringBuffer();
		querySql.append("select distinct e from NotificationHdr e ").append(" left join fetch e.notificationDtls dtl ").append(" left join fetch e.notificationFacilities nf ").append(" where ");
		boolean isBelongToMainStore = true;
		if (isBelongToMainStore) {
			querySql.append(" (( ").append(" e.where = '").append(InventoryConstant.INDENT_BTWN_FACILITY).append("' ").append(" and (e.categories = 'MSG' or e.categories = 'NE' or e.categories = 'NE') ").append(" ) ").append(" or ").append(" (").append(" e.extNRefNoPk is not null and (e.categories = 'MSG' or e.categories = 'PR') ").append(" ) ").append(" or ").append(" ( ").append(" e.where = '")
					.append(InventoryConstant.INDENT_WITH_FACILITY).append("' ").append(" and (e.categories = 'MSG' or e.categories = 'NE' or e.categories = 'SMI') and (nf.fromRqstrCode = :requesterUnitCode or nf.toRqstrCode = :requesterUnitCode) ").append(" )) ");
		} else {
			querySql.append(" ((e.where = '").append(InventoryConstant.INDENT_WITH_FACILITY).append("'  and (e.categories = 'MSG' or e.categories = 'NE' or e.categories = 'SMI')  and (nf.fromRqstrCode = :requesterUnitCode or nf.toRqstrCode = :requesterUnitCode))) ");
		}
		querySql.append(" and (e.notificationStartDate <= :today and e.notificationEndDate >= :today)  ");
		querySql.append(" and (e.activeFlag = :activeFlag) ");
		List results = null;
		Session session = null;
		try {
			session = this.notificationHdrDAO.getSessionFactory().openSession();
			org.hibernate.query.Query query = session.createQuery(querySql.toString());
			Date today = DateUtil.startDate(new Date());
			query.setParameter("today", today);
			query.setParameter("activeFlag", CommonUtil.toAICharacter(true));
			results = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return results;
	}


	public BasisNextidDaoImpl<NotificationHdr> getNotificationHdrDAO() {
		return this.notificationHdrDAO;
	}

	public void setNotificationHdrDAO(BasisNextidDaoImpl<NotificationHdr> notificationHdrDAO) {
		this.notificationHdrDAO = notificationHdrDAO;
	}

	public List<NotificationHdr> getAllNotificationHdr(String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationHdr.class);
		criteria.add(Restrictions.eq("status", status));
		return this.notificationHdrDAO.findByCriteria(criteria);
	}


	@Override
	public NotificationHdr getNotificationHdrByExtNRefNoPk(String extNRefNoPk) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationHdr.class);
		criteria.add(Restrictions.eq("extNRefNoPk", extNRefNoPk));
		List<NotificationHdr> notificationHdrs = notificationHdrDAO.findByCriteria(criteria);
		if(notificationHdrs.size()>0) return notificationHdrs.get(0);
		else return null;
	}

	@Override
	public boolean isExist(NotificationHdr notificationHdr) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationHdr.class);
		criteria.add(Restrictions.eq("notificationHdrNo", notificationHdr.getNotificationHdrNo()));
		criteria.add(Restrictions.isNotNull("extNRefNoPk"));
		criteria.add(Restrictions.eq("extNRefNoPk", notificationHdr.getNotificationHdrNo()));
		return notificationHdrDAO.findByCriteria(criteria).isEmpty();
	}





}
