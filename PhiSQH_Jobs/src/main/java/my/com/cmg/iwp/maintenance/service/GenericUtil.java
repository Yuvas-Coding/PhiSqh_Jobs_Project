package my.com.cmg.iwp.maintenance.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.ComboBean;
import my.com.cmg.iwp.maintenance.model.DeliveredTo;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.Manufacturer;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.model.VoteCode;

public interface GenericUtil extends Serializable {
	List findByProperty(String Query);

	List<ComboBean> getComboboxItems(String key);

	List getFacilityList();

	List getUsrId();

	Item getItem(String id);

	Supplier getSupplierDetail(String supCode);

	Manufacturer getManufacturerDetail(String manuCode);

	VoteCode getVoteCode(String voteSeqNo);

	List getDeliveryCode();

	DeliveredTo getDeliveredTo(String deliveredTo);

	List getCombGenericName();

	GenericName getGenericNameDetail(String genericCode);

	List getCmbAdmin();

	AdminRoute getAdminDetail(String routeCode);

	List getCmbDrugDurFreq();

	Frequency getCmbDrugDurFreqDetail(String freqDesc);

	SecUser getSecUserFromLoginName(String loginId);

	SecUser getSecUserNameFromId(Long Id);

	String getmoduleNo(String moduleName);

	String findVoteCodeDesc(String vCode);

	Package getPackageObject(String code);

	SecUser getLoggedInUserId(String userName);

	List getCmbDepart();

	public List<ComboBean> getComboboxBatchList();

	List getPaymentByVoteCOde(String lpoNo);

	VoteCode getVoteCodeSeqNo(String string);

	// By sharad For ADR 12.06.2012 Strt
	String getmoduleNo12Digit(String moduleName);

	String getRequesterUnitGroupCode(String moduleName);
	
	SecUser getLoggedInUserByLoginName(String loginName);
	
	List<Object[]> getDataByHQL(String hql, Map<String, Object> map) throws Exception;
	
	List<Object[]> getDataBySQL(String sql, Map<String, Object> mapForSql);
}
