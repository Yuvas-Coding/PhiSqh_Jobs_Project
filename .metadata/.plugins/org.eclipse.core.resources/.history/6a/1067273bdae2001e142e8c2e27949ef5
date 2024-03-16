package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Sessions;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.CodeMaster;
import my.com.cmg.iwp.maintenance.model.ComboBean;
import my.com.cmg.iwp.maintenance.model.DeliveredTo;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.Manufacturer;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.service.GenericUtil;
import my.com.cmg.iwp.webui.util.CommonUtil;
@Service
public class GenericUtilImpl implements GenericUtil {
	private BasisNextidDaoImpl genericUtilDAO;

	public BasisNextidDaoImpl getGenericUtilDAO() {
		return genericUtilDAO;
	}

//	private AnnotationSessionFactoryBean annotationSessionFactoryBean;

	public void setGenericUtilDAO(BasisNextidDaoImpl genericUtilDAO) {
		this.genericUtilDAO = genericUtilDAO;
	}

	@Override
	public List findByProperty(String Query) {
		return genericUtilDAO.find(Query);
	}

	public List getCombobox() {
		return genericUtilDAO
				.find("from ContractDtls as temp where temp.contractHdrs=156");
	}

	/*
	 * public List<ComboBean> getComboboxItems(String key) { SysCategory
	 * temp=(SysCategory)
	 * genericUtilDAO.find("from SysCategory where sysCatId="+
	 * key).iterator().next(); List<ComboBean> cmbList=new
	 * ArrayList<ComboBean>();
	 * 
	 * Set<SystemParameter> tempParameter=temp.getSystemParameteres();
	 * Iterator<SystemParameter> it=tempParameter.iterator();
	 * while(it.hasNext()) { SystemParameter tempSysp=(SystemParameter)
	 * it.next(); ComboBean cmbItem=new ComboBean();
	 * cmbItem.setId(tempSysp.getSysSeqcode());
	 * cmbItem.setLabel(tempSysp.getSysValLongDesc());
	 * cmbItem.setValue(tempSysp.getSysValShortDesc()); cmbList.add(cmbItem); }
	 * return cmbList; }
	 */

	@Override
	public List<SecUser> getUsrId() {
		return genericUtilDAO.find("from SecUser");
	}

	/*
	 * @Override public SystemParameter getSystemParameter(String code) {
	 * SystemParameter systemParameter = (SystemParameter)
	 * genericUtilDAO.find("from SystemParameter where sysSeqcode="
	 * +code).iterator().next(); return systemParameter; }
	 * 
	 * @Override public SystemParameter getSysParameterOnShortDesc(String
	 * shortDesc) { SystemParameter systemParameter = (SystemParameter)
	 * genericUtilDAO
	 * .find("from SystemParameter where sysValShortDesc='"+shortDesc
	 * +"'").iterator().next(); return systemParameter; }
	 */

	@Override
	public Item getItem(String id) {
		Item item = (Item) genericUtilDAO
				.find("from Item where itemCode='" + id + "'").iterator()
				.next();
		return item;
	}

	@Override
	public List<DeliveredTo> getDeliveryCode() {
		return genericUtilDAO.find("from DeliveredTo");

	}

	@Override
	public DeliveredTo getDeliveredTo(String deliveredTo) {
		DeliveredTo deliveredToCode = (DeliveredTo) genericUtilDAO
				.find("from DeliveredTo where del_to_seqno=" + deliveredTo)
				.iterator().next();
		return deliveredToCode;
	}

	@Override
	public Supplier getSupplierDetail(String supSeqNo) {
		Supplier supplier = (Supplier) genericUtilDAO
				.find("from Supplier where sprSequenceNo=" + supSeqNo)
				.iterator().next();
		return supplier;
	}

	@Override
	public Manufacturer getManufacturerDetail(String manuSeqNo) {
		Manufacturer manufacturer = (Manufacturer) genericUtilDAO
				.find("from Manufacturer where manuSeqno=" + manuSeqNo)
				.iterator().next();
		return manufacturer;
	}

	@Override
	public VoteCode getVoteCode(String voteSeqNo) {
		VoteCode voteCode = (VoteCode) genericUtilDAO
				.find("from VoteCode where voteSeqno=" + voteSeqNo).iterator()
				.next();
		return voteCode;
	}

	@Override
	public List<GenericName> getCombGenericName() {
		return genericUtilDAO.find("from GenericName");
	}

	@Override
	public GenericName getGenericNameDetail(String genericCode) {
		GenericName genericName = (GenericName) genericUtilDAO
				.find("from GenericName where genericSeqno=" + genericCode)
				.iterator().next();
		return genericName;
	}

	/*
	 * @Override public List<Dosage> getCmbDosage() { return
	 * genericUtilDAO.find("from Dosage"); }
	 * 
	 * 
	 * @Override public Dosage getDosageDetail(String dosageCode) { Dosage
	 * dosage =
	 * (Dosage)genericUtilDAO.find("from Dosage where dosageSeqno="+dosageCode
	 * ).iterator().next(); return dosage; }
	 */

	@Override
	public List getCmbAdmin() {
		return genericUtilDAO.find("from AdminRoute");
	}

	@Override
	public AdminRoute getAdminDetail(String routeCode) {
		AdminRoute adminRoute = (AdminRoute) genericUtilDAO
				.find("from AdminRoute where routeSeqno=" + routeCode)
				.iterator().next();
		return adminRoute;
	}

	@Override
	public List getCmbDrugDurFreq() {
		return genericUtilDAO.find("from Frequency");
	}

	@Override
	public Frequency getCmbDrugDurFreqDetail(String freqDesc) {
		Frequency frequency = (Frequency) genericUtilDAO
				.find("from Frequency where freqSeqno=" + freqDesc).iterator()
				.next();
		return frequency;
	}

	@Override
	public SecUser getSecUserFromLoginName(String loginId) {

		SecUser secUser = (SecUser) genericUtilDAO
				.find("from SecUser where usrLoginname=" + "'" + loginId + "'")
				.iterator().next();
		return secUser;
	}

	@Override
	public SecUser getSecUserNameFromId(Long Id) {
		SecUser secUser = (SecUser) genericUtilDAO
				.find("from SecUser where id=" + "'" + Id + "'").iterator()
				.next();
		return secUser;
	}

	public List<ComboBean> getComboboxBatchList() {
		org.zkoss.zk.ui.Session session = (org.zkoss.zk.ui.Session) Sessions
				.getCurrent();
		Long itemseq = Long
				.parseLong(""
						+ ((org.zkoss.zk.ui.Session) session)
								.getAttribute("itemSeqNo"));

		Item templist = (Item) genericUtilDAO
				.find("from Item where itemSeqno=" + "'" + itemseq + "'")
				.iterator().next();
		System.out
				.println("*********************  getComboboxBatchList templist.getItemDesc()"
						+ templist.getItemDesc());
		List<ComboBean> cmbList = new ArrayList<ComboBean>();
		return cmbList;

	}

	@Override
	public String findVoteCodeDesc(String voteCode) {
		VoteCode vCode = (VoteCode) genericUtilDAO
				.find("from VoteCode where voteCode=" + "\'" + voteCode + "\'")
				.iterator().next();
		return vCode.getVoteName();
	}

	@Override
	public Package getPackageObject(String code) {
		Package pkg = (Package) genericUtilDAO
				.find("from Package where pkuCode = \'" + code + "\'")
				.iterator().next();
		return pkg;
	}

	@Override
	public SecUser getLoggedInUserId(String userName) {
		SecUser secUser = (SecUser) genericUtilDAO
				.find("from SecUser " +
						" where usrLoginname=" + "\'" + userName
						+ "\'").iterator().next();
		return secUser;
	}
	
	@Override
	public SecUser getLoggedInUserByLoginName(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SecUser.class);
		criteria.add(Restrictions.eq("usrLoginname", userName));
		criteria.setFetchMode("externalFacility", FetchMode.JOIN);
		return (SecUser) DataAccessUtils.uniqueResult(genericUtilDAO.findByCriteria(criteria));
	}

	@Override
	public List getCmbDepart() {
		return genericUtilDAO.find("from Department");
	}

	@Override
	public List getPaymentByVoteCOde(String lpoNo) {

		Session session = genericUtilDAO.getSessionFactory().openSession();
		Query query = session
				.createSQLQuery(" select sum(p.amount) as amount,v.vote_code,v.vote_name,po.transaction_type,po.purchase_order_no from ph_po_dtl p "
						+ " join ph_vote_codes v on v.vote_seqno = p.vote_seqno "
						+ " join ph_po_hdr po on po.po_hdr_seqno = p.po_hdr_seqno "
						+ " where po.lpo_no = '"
						+ lpoNo
						+ "' group by v.vote_code,v.vote_name,po.transaction_type,po.purchase_order_no ");

		ArrayList list = (ArrayList) query.list();
		session.close();

		return list;
	}

	@Override
	public VoteCode getVoteCodeSeqNo(String votecode) {
		VoteCode vCode = (VoteCode) genericUtilDAO
				.find("from VoteCode where voteCode=" + "\'" + votecode + "\'")
				.iterator().next();
		return vCode;
	}

	@Override
	public List<ComboBean> getComboboxItems(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getFacilityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getmoduleNo(String moduleName) {
		Calendar calendar = new GregorianCalendar();
		String Year = String.valueOf(calendar.get(Calendar.YEAR));
		Year = Year.substring(2);

		CodeMaster codeMaster = (CodeMaster)genericUtilDAO.find("from CodeMaster where codeDesc="+"'" + moduleName + "'").iterator().next();
		Session session = genericUtilDAO.getSessionFactory().openSession();
		Query query = session.createSQLQuery( "SELECT "+codeMaster.getCodeSeqno().toString()+".nextval from dual" );
//		Iterator<BigInteger > iter = (Iterator<BigInteger>) query.list().iterator();
//		String SeqNo = iter.next().toString();
		long SeqNo = Long.parseLong(query.list().iterator().next().toString());
//		int count =  codeMaster.getCode().length()+ Year.length() + SeqNo.length();
		String moduleCodeNo =moduleName.equals("BRAND")?String.format("%05d", SeqNo): String.format("%06d", SeqNo);//(String.format("%"+(10 - count)+"s", "").replace(' ', '0').toString()); 
		moduleCodeNo = (codeMaster.getCode().toUpperCase()+Year+ moduleCodeNo);
		session.close();
		return moduleCodeNo;
	}

	@Override
	public String getmoduleNo12Digit(String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequesterUnitGroupCode(String moduleName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Object[]> getDataBySQL(String sql, Map<String, Object> map) {
		System.out.println("------------------\n"+sql+"\n-----------------------");
		Session session = genericUtilDAO.getSessionFactory().openSession();
		try {
			Query query = session.createSQLQuery(sql);
			for(String key:map.keySet()){
				query.setParameter(key, map.get(key));
			}
			System.out.println("QUERY: " + query.toString());
			List<Object[]> list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			CommonUtil.closeSession(session);
		}
		return null;
	}
	
	@Override
    public List<Object[]> getDataByHQL(String hql,Map<String, Object> map) throws Exception {
		System.out.println("------------------\n"+hql+"\n-----------------------");
		Session session = genericUtilDAO.getSessionFactory().openSession();
		try {
			Query query = session.createQuery(hql);
			for(String key:map.keySet()){
				query.setParameter(key, map.get(key));
			}
			System.out.println("QUERY: " + query.toString());
			List<Object[]> list = query.list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			CommonUtil.closeSession(session);
		}
		return null;
    }	
	
}
