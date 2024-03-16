package my.com.cmg.iwp.maintenance.service.impl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemBrand;
import my.com.cmg.iwp.maintenance.model.NotificationDtl;
import my.com.cmg.iwp.maintenance.model.NotificationFacility;
import my.com.cmg.iwp.maintenance.model.NotificationHdr;
import my.com.cmg.iwp.maintenance.model.Reason;
import my.com.cmg.iwp.maintenance.service.NotificationAndDisseminateService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@SuppressWarnings("serial")
@Service
public class NotificationAndDisseminateServiceImpl implements NotificationAndDisseminateService{
	private BasisNextidDaoImpl<Reason>      reasonDAO;
	private BasisNextidDaoImpl<NotificationHdr> notificationDAO;
	private BasisNextidDaoImpl<ExternalFacility> externalFacilityDAO;
	private BasisNextidDaoImpl<NotificationFacility> notificationFacilityDAO;
	private BasisNextidDaoImpl<ItemBrand> itemBrandDAO;
	private BasisNextidDaoImpl<Brand> brandDAO;
	private BasisNextidDaoImpl<NotificationDtl> notificationDtlDAO;
	
	@SuppressWarnings("rawtypes")
	private BasisNextidDaoImpl dtlDAO;
	
	@SuppressWarnings("rawtypes")
	public BasisNextidDaoImpl getDtlDAO() {
		return dtlDAO;
	}
	@SuppressWarnings("rawtypes")
	public void setDtlDAO(BasisNextidDaoImpl dtlDAO) {
		this.dtlDAO = dtlDAO;
	}

	@Override
	public List<Reason> getReasonForRecallProduct(String reasonType) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Reason.class);
		detachedCriteria.add(Restrictions.eq("reasonType", reasonType));
		detachedCriteria.add(Restrictions.eq("reasonStatus", InventoryConstant.ACTIVE_DB_VALUE));
		detachedCriteria.addOrder(Order.asc("reasonDesc"));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return reasonDAO.findByCriteria(detachedCriteria);
	}
	public BasisNextidDaoImpl<Reason> getReasonDAO() {
		return reasonDAO;
	}

	public void setReasonDAO(BasisNextidDaoImpl<Reason> reasonDAO) {
		this.reasonDAO = reasonDAO;
	}
	@Override
	public void saveOrUpdate(NotificationHdr currentNotificationHdr) {	
		notificationDAO.saveOrUpdate(currentNotificationHdr);
	}
	
	@Override
	public void save(NotificationHdr currentNotificationHdr) {	
		notificationDAO.save(currentNotificationHdr);
	}
	
	public BasisNextidDaoImpl<NotificationHdr> getNotificationDAO() {
		return notificationDAO;
	}
	
	public void setNotificationDAO(
			BasisNextidDaoImpl<NotificationHdr> notificationDAO) {
		this.notificationDAO = notificationDAO;
	}
	@Override
	public List<NotificationHdr> getAllNotifications() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationHdr.class);
		detachedCriteria.setFetchMode("notificationDtls",  FetchMode.JOIN);
		detachedCriteria.setFetchMode("notificationFacilities",  FetchMode.JOIN);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.addOrder(Order.desc("createdDate"));
		return notificationDAO.findByCriteria(detachedCriteria);
	}
	@Override
	public List<NotificationHdr> getSearchNotifications(NotificationHdr notificationHdrCriteria) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationHdr.class);
		detachedCriteria.setFetchMode("notificationDtls",  FetchMode.JOIN);
		detachedCriteria.setFetchMode("notificationFacilities",  FetchMode.JOIN);
		if(notificationHdrCriteria.getNotificationHdrNo()!=null){
			detachedCriteria.add(Restrictions.eq("notificationHdrNo", notificationHdrCriteria.getNotificationHdrNo().trim()));
		}
		if(notificationHdrCriteria.getCategories()!=null){
			detachedCriteria.add(Restrictions.ilike("categories", notificationHdrCriteria.getCategories(), MatchMode.ANYWHERE));
		} else {
			List<String> notifications = new ArrayList<String>();
			notifications.add(RefCodeConstant.NOTIFICATION_MESSAGE);
			notifications.add(RefCodeConstant.NOTIFICATION_PR);
			detachedCriteria.add(Restrictions.in("categories",notifications));
		}
		if(notificationHdrCriteria.getStatus()!=null){
			detachedCriteria.add(Restrictions.ilike("status", notificationHdrCriteria.getStatus()));
		}
		if (notificationHdrCriteria.getNotificationStartDate()!=null && notificationHdrCriteria.getNotificationEndDate()==null) {
			Date dateFrom = notificationHdrCriteria.getNotificationStartDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFrom);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			detachedCriteria.add(Restrictions.ge("createdDate",	calendar.getTime()));
		}
		if (notificationHdrCriteria.getNotificationStartDate()==null && notificationHdrCriteria.getNotificationEndDate()!=null) {
			Calendar calendar2 = Calendar.getInstance();
			Date dateTo = notificationHdrCriteria.getNotificationEndDate();
			calendar2.setTime(dateTo);
			calendar2.set(Calendar.HOUR, 23);
			calendar2.set(Calendar.MINUTE, 59);
			calendar2.set(Calendar.SECOND, 59);	
			detachedCriteria.add(Restrictions.le("createdDate",	calendar2.getTime()));
		}
		if(notificationHdrCriteria.getNotificationStartDate()!=null && notificationHdrCriteria.getNotificationEndDate()!=null){
			Date dateFrom = notificationHdrCriteria.getNotificationStartDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFrom);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			
			Calendar calendar2 = Calendar.getInstance();
			Date dateTo = notificationHdrCriteria.getNotificationEndDate();
			calendar2.setTime(dateTo);
			calendar2.set(Calendar.HOUR, 23);
			calendar2.set(Calendar.MINUTE, 59);
			calendar2.set(Calendar.SECOND, 59);	
			detachedCriteria.add(Restrictions.between("createdDate", calendar.getTime(),calendar2.getTime()));
		}
		if(notificationHdrCriteria.getTitle()!=null && !notificationHdrCriteria.getTitle().trim().equals("")){
			detachedCriteria.add(Restrictions.ilike("title", notificationHdrCriteria.getTitle(), MatchMode.ANYWHERE));
		}
		detachedCriteria.addOrder(Order.desc("notificationHdrNo"));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationDAO.findByCriteria(detachedCriteria);
	}
	/*	@SuppressWarnings("rawtypes")
	@Override
	public List getUserDetail(long query) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(UserDetail.class);
		detachedCriteria.setFetchMode("requesterUnit", FetchMode.JOIN);
		detachedCriteria.setFetchMode("requesterUnit.requesterGroup",FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("usrId", query));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationDAO.findByCriteria(detachedCriteria);
	}
	@Override
	public List<RequesterUnit> getUnitList(RequesterUnit requesterUnit) {
		String levelOne = InventoryConstant.mainStoreLevel;
		String levelTwo = InventoryConstant.subStoreLevel;
		String levelThree = InventoryConstant.wardUnitLevel;
		RequesterGroup requesterGroup = requesterUnit.getRequesterGroup();
		String lavel = requesterGroup.getUnitGroupLevel();
		List<String> levelList = new ArrayList<String>();
		
		if(lavel.equals(levelOne)){
			levelList.add(levelTwo);
			levelList.add(levelThree);
		}
		else if(lavel.equals(levelTwo)){
			levelList.add(levelTwo);
			levelList.add(levelThree);
		}
		else if(lavel.equals(levelThree)){
			levelList.add(levelThree);
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RequesterUnit.class);
		detachedCriteria.createCriteria("requesterGroup").add(Restrictions.in("unitGroupLevel", levelList));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return requesterUnitDAO.findByCriteria(detachedCriteria);
		
	}
	public BasisNextidDaoImpl<RequesterUnit> getRequesterUnitDAO() {
		return requesterUnitDAO;
	}
	public void setRequesterUnitDAO(
			BasisNextidDaoImpl<RequesterUnit> requesterUnitDAO) {
		this.requesterUnitDAO = requesterUnitDAO;
	}
	*/
	
	@Override
	public List<NotificationFacility> getNotificationFacility(String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationFacility.class);
		//criteria.setFetchMode("notificationHdr", FetchMode.JOIN);
		//criteria.setFetchMode("notificationHdr.notificationDtls", FetchMode.JOIN);
		//criteria.setFetchMode("notificationHdr.notificationFacilities", FetchMode.JOIN);
		criteria.add(Restrictions.eq("status", status));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationFacilityDAO.findByCriteria(criteria);

	}

	@Override
	public NotificationFacility getNotificationFacilityByFacility(NotificationFacility notificationFacility) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationFacility.class);
		criteria.setFetchMode("notificationHdr", FetchMode.JOIN);
		criteria.setFetchMode("notificationHdr.notificationDtls", FetchMode.JOIN);
		criteria.setFetchMode("notificationHdr.notificationFacilities", FetchMode.JOIN);
		criteria.add(Restrictions.eq("nfSeqno", notificationFacility.getNfSeqno()));
		
		return DataAccessUtils
		.uniqueResult(notificationFacilityDAO.findByCriteria(criteria));
		
	}
	@Override
	public void updateNotifFacility(String status, long notifFacilitySeqno) {
		StringBuilder queryStr = new StringBuilder("update NotificationFacility set status = :status where nfSeqno = :notifFacilitySeqno ");
		Session session = notificationDAO.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr.toString());
		query.setParameter("status", status);
		query.setParameter("notifFacilitySeqno", notifFacilitySeqno);
		query.executeUpdate();
		session.flush();
		session.close();
	}
	
	
	@Override
	public List<ExternalFacility> getExternalFacilityList() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		detachedCriteria.add(Restrictions.isNotNull("serverPort"));
		detachedCriteria.add(Restrictions.isNotNull("serverIp"));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return externalFacilityDAO.findByCriteria(detachedCriteria);
	}
	public BasisNextidDaoImpl<ExternalFacility> getExternalFacilityDAO() {
		return externalFacilityDAO;
	}
	public void setExternalFacilityDAO(
			BasisNextidDaoImpl<ExternalFacility> externalFacilityDAO) {
		this.externalFacilityDAO = externalFacilityDAO;
	}
	
	@Override
	public List<ItemBrand> findByItem(Item item) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ItemBrand.class);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("item", item));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return itemBrandDAO.findByCriteria(detachedCriteria);
	}
	public BasisNextidDaoImpl<ItemBrand> getItemBrandDAO() {
		return itemBrandDAO;
	}
	public void setItemBrandDAO(BasisNextidDaoImpl<ItemBrand> itemBrandDAO) {
		this.itemBrandDAO = itemBrandDAO;
	}
	@Override
	public List<ItemBrand> searchByItemDescription(String brandName,Item item) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ItemBrand.class);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("item", item));
		detachedCriteria.createCriteria("brand").add(Restrictions.ilike("brdName", "%"+brandName.trim()+"%"));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return itemBrandDAO.findByCriteria(detachedCriteria);
	}

	public BasisNextidDaoImpl<NotificationFacility> getNotificationFacilityDAO() {
		return notificationFacilityDAO;
	}
	public void setNotificationFacilityDAO(
			BasisNextidDaoImpl<NotificationFacility> notificationFacilityDAO) {
		this.notificationFacilityDAO = notificationFacilityDAO;
	}
	
	public BasisNextidDaoImpl<NotificationDtl> getNotificationDtlDAO() {
		return notificationDtlDAO;
	}
	public void setNotificationDtlDAO(
			BasisNextidDaoImpl<NotificationDtl> notificationDtlDAO) {
		this.notificationDtlDAO = notificationDtlDAO;
	}

	@Override
	public void saveOrUpdate(NotificationDtl notificationDtl) {
		notificationDtlDAO.saveOrUpdate(notificationDtl);
	}
	
	@Override
	public void save(NotificationDtl notificationDtl) {
		notificationDtlDAO.save(notificationDtl);
	}
	
	@Override
	public void saveOrUpdate(NotificationFacility notificationFacility) {
		notificationFacilityDAO.saveOrUpdate(notificationFacility);
	}
	
	@Override
	public void save(NotificationFacility notificationFacility) {
		notificationFacilityDAO.save(notificationFacility);
	}
	
	@Override
	public List<NotificationDtl> getUniqueNotificationDtls(String itemCode,	String batchNo, Date expiryDate) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationDtl.class);
		detachedCriteria.add(Restrictions.ilike("itemCode", itemCode));
		detachedCriteria.add(Restrictions.ilike("batchno", batchNo));
		detachedCriteria.add(Restrictions.eq("batchExpdate", expiryDate));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationDtlDAO.findByCriteria(detachedCriteria);
	}
	public BasisNextidDaoImpl<Brand> getBrandDAO() {
		return brandDAO;
	}
	public void setBrandDAO(BasisNextidDaoImpl<Brand> brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	public List<Brand> getBrandNameForCode(String brandCode){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		detachedCriteria.add(Restrictions.eq("brdCode", brandCode));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return brandDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public NotificationHdr getNotficationByTitle(String title) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NotificationHdr.class);
		criteria.add(Restrictions.eq("title", title));
		criteria.add(Restrictions.ge("notificationEndDate", new Date()));
		return DataAccessUtils
				.uniqueResult(notificationDAO.findByCriteria(criteria));
	}
	@Override
	public List<NotificationDtl> getNotitficationDtlsByHQNotitficationNumber(String hqNotificationNumber) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationDtl.class);
		detachedCriteria.createAlias("notificationHdr", "notificationHdr");
		detachedCriteria.add(Restrictions.eq("notificationHdr.notificationHdrNo", hqNotificationNumber));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationDtlDAO.findByCriteria(detachedCriteria);
	}

    @Override
    public NotificationHdr getNotificationFromDashbord(long notificationSeqNo) {
	DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationHdr.class);
	detachedCriteria.add(Restrictions.eq("notificationHdrSeqno", notificationSeqNo));
	detachedCriteria.setFetchMode("notificationDtls", FetchMode.JOIN);
	detachedCriteria.setFetchMode("notificationFacilities", FetchMode.JOIN);
	detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
	detachedCriteria.addOrder(Order.desc("notificationHdrNo"));
	List<NotificationHdr> notificationHdrsList = this.notificationDAO.findByCriteria(detachedCriteria);
	return notificationHdrsList.get(0);
    }
    
	@Override
	public void deleteNotificationDtl(NotificationDtl dtl)
	{
		dtlDAO.delete(dtl);
	}
	@Override
	public NotificationHdr getNotificationHdr(NotificationHdr notificationHdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationHdr.class);
		detachedCriteria.setFetchMode("notificationDtls", FetchMode.JOIN);
		detachedCriteria.setFetchMode("notificationFacilities", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("notificationHdrNo", notificationHdr.getNotificationHdrNo()));
		detachedCriteria.add(Restrictions.eq("fromFacilityCode", notificationHdr.getFromFacilityCode()));
		List<NotificationHdr> notificationHdrsList = this.notificationDAO.findByCriteria(detachedCriteria);
		return notificationHdrsList.size()>0? notificationHdrsList.get(0):null;
	}

	@Override
	public List<NotificationHdr> getNotitficationByHQNotitficationNumber(String hqNotificationNumber, String fromFacilityCode, String toFacilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(NotificationHdr.class);		
		detachedCriteria.add(Restrictions.eq("notificationHdrNo", hqNotificationNumber));
		detachedCriteria.add(Restrictions.eq("fromFacilityCode", fromFacilityCode));
//		detachedCriteria.setFetchMode("notificationDtls", FetchMode.JOIN);
		detachedCriteria.createAlias("notificationFacilities", "nf");
		detachedCriteria.add(Restrictions.eq("nf.toFacilityCode", toFacilityCode));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return notificationDAO.findByCriteria(detachedCriteria);
	}
	
	
}
