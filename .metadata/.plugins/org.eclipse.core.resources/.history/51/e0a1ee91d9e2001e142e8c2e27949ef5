package my.com.cmg.iwp.maintenance.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemBrand;
import my.com.cmg.iwp.maintenance.model.NotificationDtl;
import my.com.cmg.iwp.maintenance.model.NotificationFacility;
import my.com.cmg.iwp.maintenance.model.NotificationHdr;
import my.com.cmg.iwp.maintenance.model.Reason;


public interface NotificationAndDisseminateService extends Serializable{
	/**
	 * method getReasonComboValues
	 * @param string  String
	 * @return List<Reason>
	 * this method returns all the reason related to product recall
	 */
	public List<Reason> getReasonForRecallProduct(String reasonType);

	public void saveOrUpdate(NotificationHdr currentNotificationHdr);

	public List<NotificationHdr> getAllNotifications();

	public List<NotificationHdr> getSearchNotifications(NotificationHdr notificationHdrCriteria);
	
	List<NotificationFacility> getNotificationFacility(String status);
	
	void updateNotifFacility(String status, long notifFacilitySeqno);

	public List<ExternalFacility> getExternalFacilityList();

	public List<ItemBrand> findByItem(Item anItem);

	public List<ItemBrand> searchByItemDescription(String brandName,Item item);

	public void saveOrUpdate(NotificationDtl notificationDtls);

	public void saveOrUpdate(NotificationFacility notificationFacility);

	public List<NotificationDtl> getUniqueNotificationDtls(String itemCode,String batchNo, Date expiryDate);

	void save(NotificationHdr currentNotificationHdr);

	void save(NotificationDtl notificationDtl);

	void save(NotificationFacility notificationFacility);
	
	public List<Brand> getBrandNameForCode(String brandCode);

	NotificationHdr getNotficationByTitle(String title);

	public List<NotificationDtl> getNotitficationDtlsByHQNotitficationNumber(String hqNotificationNumber);

	public NotificationFacility getNotificationFacilityByFacility(NotificationFacility notificationFacility);
	
	public NotificationHdr getNotificationFromDashbord(long notificationSeqNo);
	
	public void deleteNotificationDtl(NotificationDtl dtl);

	public NotificationHdr getNotificationHdr(NotificationHdr notificationHdr);

	List<NotificationHdr> getNotitficationByHQNotitficationNumber(
			String hqNotificationNumber, String fromFacilityCode,
			String toFacilityCode);

	/*	public List getUserDetail(long id);

	public List<RequesterUnit> getUnitList(RequesterUnit requesterUnit);*/

}
