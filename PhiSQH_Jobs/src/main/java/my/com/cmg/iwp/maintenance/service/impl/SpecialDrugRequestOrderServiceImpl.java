package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.management.Query;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.sdr.SpecialDrugAdditionalDoc;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugApproval;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrder;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrderArc;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.SpecialDrugRequestOrderService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.HQConstants;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class SpecialDrugRequestOrderServiceImpl implements
		SpecialDrugRequestOrderService {
	private BasisNextidDaoImpl<SpecialDrugRequestOrder> specialDrugRequestOrderDAO;
	private BasisNextidDaoImpl<SpecialDrugAdditionalDoc> specialDrugAdditionalDocDAO;
	private BasisNextidDaoImpl<SpecialDrugApproval> specialDrugApprovalDAO;
	private BasisNextidDaoImpl<SpecialDrugRequestOrderArc> specialDrugRequestArcOrderDAO;

	public BasisNextidDaoImpl<SpecialDrugRequestOrder> getSpecialDrugRequestOrderDAO() {
		return specialDrugRequestOrderDAO;
	}

	public void setSpecialDrugRequestOrderDAO(
			BasisNextidDaoImpl<SpecialDrugRequestOrder> specialDrugRequestOrderDAO) {
		this.specialDrugRequestOrderDAO = specialDrugRequestOrderDAO;
	}

	public BasisNextidDaoImpl<SpecialDrugRequestOrderArc> getSpecialDrugRequestArcOrderDAO() {
		return specialDrugRequestArcOrderDAO;
	}

	public void setSpecialDrugRequestArcOrderDAO(
			BasisNextidDaoImpl<SpecialDrugRequestOrderArc> specialDrugRequestArcOrderDAO) {
		this.specialDrugRequestArcOrderDAO = specialDrugRequestArcOrderDAO;
	}

	@Override
	public void saveOrUpdate(SpecialDrugRequestOrder specialDrugRequestOrder) {
		specialDrugRequestOrderDAO.saveOrUpdate(specialDrugRequestOrder);
	}

	@Override
	public List<SpecialDrugRequestOrder> getAllSendRecord() {
//		DetachedCriteria criteria = DetachedCriteria
//				.forClass(SpecialDrugRequestOrder.class);
//		criteria.add(Restrictions.eq("sendFlag", RefCodeConstant.BOOLEAN_YES));
		
		Session session = getSpecialDrugRequestOrderDAO().getSessionFactory().openSession();
		try {
		Query query =  session.createQuery("from SpecialDrugRequestOrder as sdr left join fetch sdr.specialDrugPatients as sdp left join fetch sdp.specialDrugTreatments sdt left join fetch sdr.specialDrugAdditionalDoc sdad left join fetch sdad.createdUser where sdr.sendFlag = 'Y'");
		return query.list();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session.isOpen()) session.close();
		}
		return new ArrayList<SpecialDrugRequestOrder>();
//		criteria.setFetchMode("specialDrugPatients", FetchMode.JOIN);
//		criteria.setFetchMode("specialDrugPatients.specialDrugTreatments", FetchMode.JOIN);
//		return getSpecialDrugRequestOrderDAO().findByCriteria(criteria);
	}
	
	
	@Override
	public SpecialDrugRequestOrder findByFacCodeHosReqNo(String facCode,String hosReqNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugRequestOrder.class);
		detachedCriteria.add(Restrictions.eq("facCode", facCode));
		detachedCriteria.add(Restrictions.eq("hosRequestNo", hosReqNo));
		return DataAccessUtils.uniqueResult(this.specialDrugRequestOrderDAO.findByCriteria(detachedCriteria));
	}

	@Override
	public SpecialDrugRequestOrder getSpecialDrugRequestByCode(String remarks) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SpecialDrugRequestOrder.class);
		criteria.add(Restrictions.eq("hosRequestNo", remarks));
		return DataAccessUtils.uniqueResult(this.specialDrugRequestOrderDAO.findByCriteria(criteria));
	}
	
	@Override
	public String getBpf(String regStatus) {
		Calendar calendar = new GregorianCalendar();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		Session session = getSpecialDrugRequestOrderDAO().getSessionFactory().openSession();
		char bpfType = 'X';
		if(regStatus!=null && regStatus.length()>0)
			bpfType = regStatus.charAt(0);
		BigDecimal iter = null;
		String sql = "";
		if (bpfType == 'A') {
			sql = "select T_SDR_BPFA_SEQ.nextval from dual";
		} else if (bpfType == 'B') {
			sql = "select T_SDR_BPFB_SEQ.nextval from dual";
		} else /*if (bpfType == 'C')*/ {
			sql = "select T_SDR_BPFC_SEQ.nextval from dual";
		}
		Query query = session.createSQLQuery(sql);
		iter = (BigDecimal) query.uniqueResult();
		String seqNo = String.format("%04d", iter.longValue());
		String bpf = regStatus + seqNo + "/" + year;
		session.close(); 
		return bpf;
	}
	
	@Override
	public SpecialDrugRequestOrder findByFacCodePPFRegNo(String facCode,String ppfRegNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugRequestOrder.class);
		detachedCriteria.setFetchMode("specialDrugPatients", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("facCode", facCode));
		detachedCriteria.add(Restrictions.eq("bpfRegisterNo", ppfRegNo));
		return DataAccessUtils.uniqueResult(this.specialDrugRequestOrderDAO.findByCriteria(detachedCriteria));
	}

	public BasisNextidDaoImpl<SpecialDrugAdditionalDoc> getSpecialDrugAdditionalDocDAO() {
		return specialDrugAdditionalDocDAO;
	}

	public void setSpecialDrugAdditionalDocDAO(BasisNextidDaoImpl<SpecialDrugAdditionalDoc> specialDrugAdditionalDocDAO) {
		this.specialDrugAdditionalDocDAO = specialDrugAdditionalDocDAO;
	}
	
	@Override
	public SpecialDrugAdditionalDoc findByHosReqNoFacCodePtjCode (String hosRequestNo, String facCode, String ptjCode, long addDocSeqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugAdditionalDoc.class);
		detachedCriteria.add(Restrictions.eq("hosRequestNo", hosRequestNo));
		detachedCriteria.add(Restrictions.eq("facilityCode", facCode));
		detachedCriteria.add(Restrictions.eq("ptjCode", ptjCode));
		detachedCriteria.add(Restrictions.eq("addDocSeqno", addDocSeqno));
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return DataAccessUtils.uniqueResult(this.specialDrugAdditionalDocDAO.findByCriteria(detachedCriteria));
	}

	@Override
	public void saveOrUpdate(SpecialDrugAdditionalDoc SpecialDrugAdditionalDoc) {
		specialDrugAdditionalDocDAO.saveOrUpdate(SpecialDrugAdditionalDoc);
	}

	public BasisNextidDaoImpl<SpecialDrugApproval> getSpecialDrugApprovalDAO() {
		return specialDrugApprovalDAO;
	}

	public void setSpecialDrugApprovalDAO(BasisNextidDaoImpl<SpecialDrugApproval> specialDrugApprovalDAO) {
		this.specialDrugApprovalDAO = specialDrugApprovalDAO;
	}
	
	@Override
	public List<SpecialDrugApproval> findByCategoryType (String category, String type) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugApproval.class);
		detachedCriteria.add(Restrictions.eq("splCategory", category.charAt(0)));
		detachedCriteria.add(Restrictions.eq("splType", type.charAt(0)));
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return this.specialDrugApprovalDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<SpecialDrugApproval> getLisResultSpecialDrugApproval(String where) {
		Session session = null;
		List<SpecialDrugApproval>  newList = null;
		String sqlQuery = new String("SELECT spl_drug_approval_seqno from t_spl_drug_approval ") + where;
		System.out.println("------------------- " + sqlQuery.toString());
		try {
			session = specialDrugApprovalDAO.getSessionFactory().openSession();
			List<BigDecimal> objectArrayList = session.createNativeQuery(sqlQuery).list();
			newList = getSpecialDrugApprovalListByOnjectArray(objectArrayList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
			session.close();
		}
	}

		return newList;
	}
	
	public SpecialDrugApproval getSpecialDrugApprovalBySeqnp(long seqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugApproval.class);
		detachedCriteria.add(Restrictions.eq("splDrugApprovalSeqno",seqno));
		return DataAccessUtils.uniqueResult(this.specialDrugApprovalDAO.findByCriteria(detachedCriteria));
	}
	
	private List<SpecialDrugApproval> getSpecialDrugApprovalListByOnjectArray(List<BigDecimal> objectArrayList) {
		List<SpecialDrugApproval> itemList = new ArrayList<SpecialDrugApproval>();
		for (BigDecimal objects : objectArrayList) {
			SpecialDrugApproval item = getSpecialDrugApprovalBySeqnp(((BigDecimal) objects).longValue());
			itemList.add(item);
		}
		return itemList;
	}
	
	@Override
	public SpecialDrugRequestOrderArc getSpecialDrugRequestOrderARC(long seqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpecialDrugRequestOrderArc.class);
		detachedCriteria.add(Restrictions.eq("sdrOrderSeqno",seqno));
		return DataAccessUtils.uniqueResult(getSpecialDrugRequestArcOrderDAO().findByCriteria(detachedCriteria));
	}
	
	
	@Override
	public void createSDRTasklist(SpecialDrugRequestOrder specialDrugRequestOrder) {
		Session session = null;
		try {
			session = getSpecialDrugRequestArcOrderDAO().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createSQLQuery("INSERT INTO t_task_lists(tl_seqno, tl_task_no, tl_doc_seqno, tl_rec_date_time, "
					+ " tl_event_type, tl_subject, tl_task_done, tl_acknowledge, "
					+ " active_flag,created_by, created_date, updated_by, updated_date,tl_doc_no, tl_transaction_type,"
					+ " tl_status, tl_trx_type,tl_trx_seqno, tl_task_status, tl_url,"
					+ " tl_ptj_code,tl_facility_code)"
					+ "  VALUES "
					+ " (t_task_lists_seq.nextval,'"+specialDrugRequestOrder.getBpfRegisterNo()+"','"+specialDrugRequestOrder.getSdrOrderSeqno()+"',SYSDATE,"
					+ " 'Send For Approval','Send For Approval','"+InventoryConstant.TASK_DONE_NO+"','"+InventoryConstant.TASK_ACKNOWLEDGE_YES+"',"
					+ " 'A',2,sysdate,2,sysdate,'"+specialDrugRequestOrder.getBpfRegisterNo()+"',2188, "
					+ " 'Send For Approval','Special Approval Medicine','"+specialDrugRequestOrder.getSdrOrderSeqno()+"','"+HQConstants.TASKLIST_STATUS_OPEN+"',"
					+ " '"+InventoryConstant.KPK_TASKLIST+"','"+specialDrugRequestOrder.getPtjCode()+"','"+specialDrugRequestOrder.getFacCode()+"') ");
			query.executeUpdate();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
}
