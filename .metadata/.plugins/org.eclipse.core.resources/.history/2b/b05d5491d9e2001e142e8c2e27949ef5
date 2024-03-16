package my.com.cmg.iwp.maintenance.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.DoDtl;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.Payment;
import my.com.cmg.iwp.maintenance.model.PaymentByVotecode;
import my.com.cmg.iwp.maintenance.model.PaymentDtl;
import my.com.cmg.iwp.maintenance.model.PoCfHdr;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.service.PaymentService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.CommonUtil;

@Service
public class  PaymentServiceimpl implements PaymentService{
	
	@SuppressWarnings("rawtypes")
	private BasisNextidDaoImpl paymentDAO;
	
	@SuppressWarnings("rawtypes")
	public BasisNextidDaoImpl getPaymentDAO() {
		return paymentDAO;
	}

	@SuppressWarnings("rawtypes")
	public void setPaymentDAO(BasisNextidDaoImpl paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	@Override
	public Payment getNewPayment() {
		return new Payment();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOrUpdate(Payment anPayment) {
		paymentDAO.saveOrUpdate(anPayment);
		
	}

	@Override
	public void delete(Payment anPayment) {
		
	}
	
	public boolean isNew(Payment anPayment) {
		if(anPayment.getPaymentNo()==null)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoDtl> findPodtl(String quary) {
		return paymentDAO.find(quary);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoDtl> findDoDetail(String quary) {
		return paymentDAO.find(quary);
	}

	@SuppressWarnings("unchecked")
	public List<PoDtl> getPoHdrObject(PoDtl podtl)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoDtl.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("poDtlSeqno", podtl.getPoDtlSeqno()));
		detachedCriteria.setFetchMode("poHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("voteCodesByVoteSeqno", FetchMode.JOIN);
		return paymentDAO.findByCriteria(detachedCriteria);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> getPayment(Payment payment)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		detachedCriteria.setProjection(Projections.distinct(Projections.property("poHdrSeqno")));
		detachedCriteria.add(Restrictions.eq("paymentSeqno", payment.getPaymentSeqno()));
		detachedCriteria.setFetchMode("poHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("suppliers", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonApplInvoices", FetchMode.JOIN);
		detachedCriteria.setFetchMode("applInvoices", FetchMode.JOIN);
		detachedCriteria.setFetchMode("paymentDtls", FetchMode.JOIN);
		detachedCriteria.setFetchMode("paymentByVotecodes", FetchMode.JOIN);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		return paymentDAO.findByCriteria(detachedCriteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Payment> getPaymentObject(Payment payment)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		detachedCriteria.setProjection(Projections.distinct(Projections.property("poHdrSeqno")));
		detachedCriteria.add(Restrictions.eq("paymentSeqno", payment.getPaymentSeqno()));
		detachedCriteria.setFetchMode("poHdr.supplier", FetchMode.JOIN);
		detachedCriteria.setFetchMode("externalFacility", FetchMode.JOIN);
		detachedCriteria.setFetchMode("paymentByVotecodes", FetchMode.JOIN);
		detachedCriteria.setFetchMode("paymentByVotecodes.voteCode", FetchMode.JOIN);
		
		return paymentDAO.findByCriteria(detachedCriteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<PoHdr> getPohdr(PoHdr pohdr)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PoHdr.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("poHdrSeqno", pohdr.getPoHdrSeqno()));
		detachedCriteria.setFetchMode("poDtls", FetchMode.JOIN);
		detachedCriteria.setFetchMode("poDtls.item", FetchMode.JOIN);
		/*detachedCriteria.setFetchMode("poDtls.voteCodesByVoteSeqno", FetchMode.JOIN);
		detachedCriteria.setFetchMode("poDtls.voteCodesByAddVotecodeSeqno", FetchMode.JOIN);*/
		
		
		/*detachedCriteria.setFetchMode("supplier", FetchMode.JOIN);*/
		return paymentDAO.findByCriteria(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	public List<PaymentByVotecode> getpaymentByVotecode(PaymentByVotecode paymentByVotecode)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PaymentByVotecode.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("paymentByVotecodeSeqno", paymentByVotecode.getPaymentByVotecodeSeqno()));
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		return paymentDAO.findByCriteria(detachedCriteria);
		
	}

	@Override
	public void savepoHdr(PoHdr poHdr) {
		paymentDAO.saveOrUpdate(poHdr);
	}

	@Override
	public SecUser getSecUser(SecUser secUser)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("id", secUser.getId()));
		detachedCriteria.setFetchMode("userDetail", FetchMode.JOIN);
		detachedCriteria.setFetchMode("userDetail.requesterUnit", FetchMode.JOIN);
		detachedCriteria.setFetchMode("userDetail.requesterUnit.requesterGroup", FetchMode.JOIN);
		
		return (SecUser) paymentDAO.findByCriteria(detachedCriteria).iterator().next();
	}

	@Override
	public Payment getPaymentforTaskList(String tlTaskNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		detachedCriteria.setProjection(Projections.distinct(Projections.property("poHdrSeqno")));
		detachedCriteria.add(Restrictions.eq("paymentNo",tlTaskNo));
		detachedCriteria.setFetchMode("poHdr.supplier", FetchMode.JOIN);
		detachedCriteria.setFetchMode("poHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("suppliers", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonApplInvoices", FetchMode.JOIN);
		detachedCriteria.setFetchMode("applInvoices", FetchMode.JOIN);
		return (Payment) paymentDAO.findByCriteria(detachedCriteria).iterator().next();
	}

	@Override
	public PoHdr getPoFromPayment(Long paymentSeqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("paymentSeqno", paymentSeqno));
		detachedCriteria.setFetchMode("poHdr", FetchMode.JOIN);
		List<Payment> paymentList = paymentDAO.findByCriteria(detachedCriteria);
		if(null != paymentList && paymentList.size() > 0)
		{
			return paymentList.iterator().next().getPoHdr();
		}
		return null;
	}
	
	public List<CBMaster> getCurrentBudgetMaster(VoteCode voteCode,BigDecimal financialYear) {
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(CBMaster.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteCode", voteCode));
		detachedCriteria.add(Restrictions.eq("financialYear",financialYear));
		return (List<CBMaster>) paymentDAO.findByCriteria(detachedCriteria);
		
	}

	@Override
	public void saveOrUpdate(CBMaster budgetMaster) {
	
		paymentDAO.saveOrUpdate(budgetMaster);
		
	}

	@Override
	public List<VoteCode> getvotecode(VoteCode voteCode) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(VoteCode.class);
		detachedCriteria.add(Restrictions.eq("voteSeqno", voteCode.getVoteSeqno()));
		return (List<VoteCode>) paymentDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<VoteCode> getvotecodebyCode(String voteCode) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(VoteCode.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("voteCode", voteCode));
		return paymentDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public void saveOrUpdate(VoteCode voteCodemaster) {
		paymentDAO.saveOrUpdate(voteCodemaster);
		
	}

	@Override
	public PaymentDtl getPaymentDtl(PaymentDtl paymentDtl) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PaymentDtl.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("paymentdtlSeqno", paymentDtl.getPaymentdtlSeqno()));
		detachedCriteria.setFetchMode("voteCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("payment", FetchMode.JOIN);
		detachedCriteria.setFetchMode("payment.poHdr", FetchMode.JOIN);
		detachedCriteria.setFetchMode("payment.poHdr.poDtls", FetchMode.JOIN);
		
		List<PaymentDtl> paymentList = paymentDAO.findByCriteria(detachedCriteria);
		if(null != paymentList && paymentList.size() > 0)
		{
			return paymentList.iterator().next();
		}
		return null;
	}

	@Override
	public DoDtl getDoDetailbyDoseqNo(Long doNo) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DoDtl.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("doSeqno", doNo));
		List<DoDtl> DoDetail_list=  paymentDAO.findByCriteria(detachedCriteria);
		
		return DoDetail_list.iterator().next();
	}

	@Override
	public List<Supplier> getsupplierByCode(String supplier_code) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Supplier.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("supplierCode", supplier_code));
		return paymentDAO.findByCriteria(detachedCriteria);
		
		
	}

	@Override
	public List<DoDtl> getDoDtlBylpoNo(String lpoNo,Item item) {
		if(lpoNo!=null && !lpoNo.isEmpty() && lpoNo.contains("'"))
			lpoNo=lpoNo.replace("'", "''");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DoDtl.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq(("lpoNo").trim(), lpoNo));
		if (null != item)
			detachedCriteria.add(Restrictions.eq("itemCode", item.getItemCode()));
		return paymentDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public PoDtl getpoDetail(PoHdr poHdr, Item item) {
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(PoDtl.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("poHdr", poHdr));
		detachedCriteria.add(Restrictions.eq("item", item));
		
		List<PoDtl> poDetailList = paymentDAO.findByCriteria(detachedCriteria);
		if(null != poDetailList && poDetailList.size() > 0)
		{
			return poDetailList.iterator().next();
		}
		return null;
	}

	@Override
	public Payment getPaymentForTaskList(Long paymentSeqno) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		detachedCriteria.add(Restrictions.eq("paymentSeqno", paymentSeqno));
		return (Payment) DataAccessUtils.uniqueResult(getPaymentDAO().findByCriteria(detachedCriteria));
	}

	@Override
	public List<Payment> getPaymentsByLPONoAndStatus(String lpoNo, String facilityCode, String... status) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		if(lpoNo!=null && !lpoNo.isEmpty() && lpoNo.contains("'"))
			lpoNo=lpoNo.replace("'", "''");
		detachedCriteria.add(Restrictions.eq("lpoNo", lpoNo));
		if(facilityCode!=null)
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		if(status!=null && status.length>0){
			detachedCriteria.add(Restrictions.in("status", status));
		}
		return getPaymentDAO().findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<Payment> getLPOdtlsBypayment(boolean isHqUser,String ptjCode,String lpono)
	{
		Session session = null;
		List<Object> paymentObj = new ArrayList<Object>(); 
		List<Payment> paymentList = new ArrayList<Payment>();
		try {
		    StringBuilder qry = new StringBuilder(); 
		    qry.append(" SELECT PAY.PAYMENT_SEQNO,PAY.PO_HDR_SEQ,PAY.LPO_NO,POHDR.LPO_DATE "
		    	+ " FROM T_PAYMENTS PAY INNER JOIN T_PO_HDR POHDR ON  POHDR.PO_HDR_SEQNO=PAY.PO_HDR_SEQ ") ;
		    if(!isHqUser)
		    	qry.append(" where pay.PTJ_CODE='"+ptjCode+"' ");
		    if(isHqUser && lpono!=null)
		    	qry.append(" where PAY.LPO_NO='"+lpono+"' ");
		    if(!isHqUser && lpono!=null)
		    	qry.append(" and PAY.LPO_NO='"+lpono+"' ");
		    qry.append( " UNION ALL "
		    	+ " SELECT PAY.PAYMENT_SEQNO,PAY.PO_HDR_SEQ,PAY.LPO_NO,POBACK.LPO_DATE FROM T_PAYMENTS PAY INNER JOIN"
		    	+ " T_PO_HDR_BACK  POBACK ON  POBACK.PO_HDR_SEQNO=PAY.PO_HDR_SEQ  "
		    	+ " WHERE POBACK.PO_HDR_SEQNO  NOT IN (SELECT PO_HDR_SEQNO FROM T_PO_HDR)  ");
		    if(!isHqUser)
		    	qry.append(" and pay.PTJ_CODE='"+ptjCode+"' ");
		    if(isHqUser && lpono!=null)
		    	qry.append(" where PAY.LPO_NO='"+lpono+"' ");
		    if(!isHqUser && lpono!=null)
		    	qry.append(" and PAY.LPO_NO='"+lpono+"' ");
		    SessionFactory sessionFactory = getPaymentDAO().getSessionFactory();
			session = sessionFactory.openSession();
			paymentObj= session.createSQLQuery(qry.toString()).list();
		} catch (Exception e) {
		    e.printStackTrace();

		}finally{
		    if(session != null &&  session.isOpen()){
			session.close();
		    }
		}
		for (Object objects : paymentObj) {
			int i=0;
			Object[] object=(Object[]) objects;
			Payment payment=new Payment();
			payment.setPoHdr(new PoHdr());
			payment.setPaymentSeqno(object[i]!=null?Long.parseLong(object[i].toString()):null);
			payment.getPoHdr().setPoHdrSeqno(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			payment.setLpoNo(object[++i]!=null?object[i].toString():null);
			payment.getPoHdr().setLpoDate(object[++i]!=null?(Date)(object[i]):null);
			paymentList.add(payment);
		}
		return paymentList;
		
	}
	
	@Override
	public Double getLpoAmountFromPoHdrBack(long poHdrSeqno) {		
		Session session = getPaymentDAO().getSessionFactory().openSession();
		Double lpoAmount = null;
		try {
			Query query = session.createSQLQuery("SELECT LPO_AMOUNT FROM T_PO_HDR_BACK WHERE PO_HDR_SEQNO=(SELECT PO_HDR_SEQ FROM T_PAYMENTS WHERE PAYMENT_SEQNO='"+poHdrSeqno+"') AND LPO_NO IS NOT NULL ");
			List list = query.list();
			lpoAmount = list!=null && list.size() > 0 && list.get(0) !=null?(double)((BigDecimal) list.get(0)).doubleValue():null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lpoAmount;
	}
	
	/**
	 * Parse the DOCreate XML from Facility and insert into IWP
	 * 
	 * @param doXML
	 * @return
	 */
	@Override
	public boolean createDO(String doXML) {
		PreparedStatement pstmtAPPL = null;
		PreparedStatement pstmtLPCP = null;
		PreparedStatement pstmtPO = null;
		Connection con = null;
		String doQuery = "INSERT INTO T_DO_DTL (DO_SEQ_NO, RUN_NO, LAMPIRAN_NO, BATCH_NO, CUSTOMER_ID, " +
				" CUSTOMER_ACC_NO,CUSTOMER_REF_NO, LPO_NO, ITEM_CODE,ITEM_DESC, PACKAGE_DESC, SKU_CODE," +
				" DEL_QTY, EXP_DATE, DO_DATE,STATUS, MANU_CODE, MANU_DESC,MANUFACTURING_DATE, SEND_TO_EP," +
				" BRD_CODE, BRD_NAME, CREATED_BY,CREATED_DATE, UPDATED_BY, UPDATED_DATE,LOCAL_UPDATE_FLAG, " +
				" PO_HDR_SEQNO, KK_RCV_QTY,KK_RCV_FLAG, KK_RECEIVED_DATE ) VALUES (T_DO_DTL_SEQ.nextval, ?, ?, ?, ?, ?, ?, " +
				" ?, ?, ?, ?, ?, ?, ?, ?, 'A', ?, ?, ?, 'N', ?, ?, 'dmiuser', SYSDATE, 'dmiuser', SYSDATE," +
				" 'Y', ?, ?, 'Y',?)";
		String poDtlUpdate = "UPDATE T_PO_DTL SET RECEIVED_QTY = ? WHERE PO_HDR_SEQNO = ? AND ITEM_SEQNO = ?";
		
		String doUpdateQuery = "UPDATE T_DO_DTL SET KK_RCV_QTY = ?, KK_RECEIVED_DATE =? , KK_RCV_FLAG = 'Y', UPDATED_DATE = SYSDATE WHERE LPO_NO = ? AND LAMPIRAN_NO = ? AND RUN_NO = ? AND ITEM_CODE = ? AND DEL_QTY = ? AND PO_HDR_SEQNO= ? ";
		try {
//			con =  getPaymentDAO().getSessionFactory().getCurrentSession().connection;
			con = getPaymentDAO().getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
			pstmtPO = con.prepareStatement(poDtlUpdate);
			pstmtPO.clearBatch();		 	

			pstmtAPPL = con.prepareStatement(doUpdateQuery);
			pstmtAPPL.clearBatch();
			
			pstmtLPCP = con.prepareStatement(doQuery);
			pstmtLPCP.clearBatch();
			
			Document document = CommonUtil.convertStringToDocument(doXML);			
			NodeList doInfo = document.getElementsByTagName("do");
			Map<Long, Map<Long, Long>> poUpdateMap = new HashMap<Long, Map<Long,Long>>();
			Long poSeq = 0l;
			for (int temp = 0; temp < doInfo.getLength(); temp++) {
				Node doNode = doInfo.item(temp);
				if (doNode.getNodeType() == Node.ELEMENT_NODE) {
					Element doElement = (Element) doNode;
					String facilityCode = doElement.getAttribute("customer-id").trim();
					String ptjCode = doElement.getAttribute("ptj-code").trim();
					String lpoNo = doElement.getAttribute("lpo-no").trim();
					String poNo = doElement.getAttribute("po-no").trim();
					poSeq = getPoSeq(poNo, facilityCode, ptjCode, lpoNo, con);
					String purchaseOrdertype = getPoType(poNo, facilityCode, ptjCode, lpoNo, con);
					Long rcvQty = Long.parseLong(doElement.getAttribute("kk-rcv-qty").trim());
					String itemCode = doElement.getAttribute("item-code").trim();
					Long itemSeq = getItemSeq(con, itemCode);
					if (poUpdateMap.containsKey(poSeq)) {
						Map<Long, Long> rcvQtyItemMap = poUpdateMap.get(poSeq);
						if (rcvQtyItemMap.containsKey(itemSeq)) {
							Long rcQty = rcvQtyItemMap.get(itemSeq).longValue() + rcvQty.longValue();
							rcvQtyItemMap.remove(itemSeq);
							rcvQtyItemMap.put(itemSeq, rcQty);
						} else {
							poUpdateMap.get(poSeq).put(itemSeq, rcvQty);
						}
					} else {
						Map<Long, Long> rcvQtyItemMap = new HashMap<Long, Long>();
						rcvQtyItemMap.put(itemSeq, rcvQty);
						poUpdateMap.put(poSeq, rcvQtyItemMap);
					}
					if (purchaseOrdertype.equals("APPL")) {						
						pstmtAPPL.setLong(1, rcvQty);
						pstmtAPPL.setString(3, lpoNo);
						pstmtAPPL.setString(4, doElement.getAttribute("lampiran-no").trim());
						pstmtAPPL.setString(5, doElement.getAttribute("line-no").trim());
						pstmtAPPL.setString(6, itemCode);
						pstmtAPPL.setLong(7, Long.parseLong(doElement.getAttribute("do-qty").trim()));
						pstmtAPPL.setLong(8, poSeq);
						if  (doElement.hasAttribute("received-date")){
							//pstmtAPPL.setDate(2, new java.sql.Date(new  SimpleDateFormat().parse(doElement.getAttribute("received-date")).getTime()));
							pstmtAPPL.setDate(2, new java.sql.Date(CommonUtil.getDODateTime(doElement.getAttribute("received-date").trim()).getTime()));
						}else
							pstmtAPPL.setNull(2, Types.DATE);
						pstmtAPPL.addBatch();
						
					} else {	
						if(temp == 0) {
							PreparedStatement deleteStatement = con.prepareStatement("delete from t_do_dtl where lpo_no ='"+lpoNo+"'");
							deleteStatement.executeUpdate();
							deleteStatement.close();	
						}
						pstmtLPCP.setString(1, doElement.getAttribute("line-no").trim());
						pstmtLPCP.setString(2, doElement.getAttribute("lampiran-no").trim());
						pstmtLPCP.setString(3, doElement.getAttribute("batch-no").trim());
						pstmtLPCP.setString(4, facilityCode);
						pstmtLPCP.setString(5, ptjCode);
						pstmtLPCP.setString(6, poNo);
						pstmtLPCP.setString(7, lpoNo);
						pstmtLPCP.setString(8, itemCode);
						pstmtLPCP.setString(9, doElement.getAttribute("item-desc").trim());
						pstmtLPCP.setString(10, doElement.getAttribute("packaging").trim());
						pstmtLPCP.setString(11, doElement.getAttribute("sku-code").trim());
						pstmtLPCP.setLong(12, Long.parseLong(doElement.getAttribute("do-qty").trim()));
						if (doElement.getAttribute("expiry-date").trim().length() > 0) {
							pstmtLPCP.setDate(13,new java.sql.Date(CommonUtil.getDODateTime(doElement.getAttribute("expiry-date").trim()).getTime()));
					 	} else {
					 		pstmtLPCP.setNull(13, java.sql.Types.DATE);
					 	}
						pstmtLPCP.setDate(14, new java.sql.Date(doElement.getAttribute("do-date").trim().length() > 0 ? CommonUtil.getDODateTime(doElement.getAttribute("do-date").trim()).getTime():new Date().getTime()));
						pstmtLPCP.setString(15, doElement.getAttribute("manu-code").trim());
						pstmtLPCP.setString(16, doElement.getAttribute("manu-desc").trim());
						if (doElement.getAttribute("manufacturing-date").trim().length() > 0) {
							pstmtLPCP.setDate(17, new java.sql.Date(CommonUtil.getDODateTime(doElement.getAttribute("manufacturing-date").trim()).getTime()));
						} else {
							pstmtLPCP.setNull(17, java.sql.Types.DATE);
						}
						pstmtLPCP.setString(18, doElement.getAttribute("brand-code").trim());
						pstmtLPCP.setString(19, doElement.getAttribute("brand-name").trim());
						pstmtLPCP.setLong(20, poSeq);
						pstmtLPCP.setLong(21, rcvQty);
						if  (doElement.hasAttribute("received-date"))
							pstmtLPCP.setDate(22, new java.sql.Date(CommonUtil.getDODatewithTime(doElement.getAttribute("received-date")).getTime()));
						else
							pstmtLPCP.setNull(22, Types.DATE);
						pstmtLPCP.addBatch();
					}
				}
			}
			if (document.getElementsByTagName("poDtl") == null) {
				for (Long poSeqs : poUpdateMap.keySet()) {
					Map<Long, Long> rcvQtyItemMap = poUpdateMap.get(poSeqs);
					for (Long itemSeq : rcvQtyItemMap.keySet()) {
						Long rcvQty = rcvQtyItemMap.get(itemSeq);
						pstmtPO.setLong(1, rcvQty);
						pstmtPO.setLong(2, poSeq);
						pstmtPO.setLong(3, itemSeq);
						pstmtPO.addBatch();
					}
				}
			} else {
				NodeList poDtlInfo = document.getElementsByTagName("poDtl");
				for (int temp = 0; temp < poDtlInfo.getLength(); temp++) {
					Node poNode = poDtlInfo.item(temp);
					if (poNode.getNodeType() == Node.ELEMENT_NODE) {
						Element poElement = (Element) poNode;
						Long itemSeqno = Long.parseLong(poElement.getAttribute("item-seqno"));
						Long receivedQty = Long.parseLong(poElement.getAttribute("received-qty"));
	
						pstmtPO.setLong(1, receivedQty);
						pstmtPO.setLong(2, poSeq);
						pstmtPO.setLong(3, itemSeqno);
						pstmtPO.addBatch();
					}
				}
			}
			pstmtLPCP.executeBatch();
			pstmtAPPL.executeBatch();
			pstmtPO.executeBatch();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		} catch (SAXException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return false;
		} finally {
			try {
				if (null != pstmtAPPL) pstmtAPPL.close();
				if (null != pstmtLPCP) pstmtLPCP.close();
				if(null != pstmtPO) pstmtPO.close();
				if( null != con) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private static long getPoSeq(String pono, String facilityCode, String ptjCode,
			String lpoNo, Connection con) {		
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		long poSeq = 0l;
		try {			
			String sql = "select po_hdr_seqno from t_po_hdr where purchase_order_no = ? "
					+ "and facility_code = ?  and ptj_code = ? and lpo_no = ? and ORD_TYPE=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pono);
			pstmt.setString(2, facilityCode);
			pstmt.setString(3, ptjCode);
			pstmt.setString(4, lpoNo);
			pstmt.setString(5, "NPO");
			rst = pstmt.executeQuery();
			if (rst.next()) {
				poSeq = rst.getLong("po_hdr_seqno");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			try {
				if(null != rst) rst.close();
				if(null != pstmt) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poSeq;
	}
	
	private static String getPoType(String pono, String facilityCode, String ptjCode,
			String lpoNo, Connection con) {		
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String poType = "",offlineflag="";
		try {			
			String sql = "select PURCHASE_ORDER_TYPE,APPL_OFFLINE_YN from t_po_hdr where purchase_order_no = ? "
					+ "and facility_code = ?  and ptj_code = ? and lpo_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pono);
			pstmt.setString(2, facilityCode);
			pstmt.setString(3, ptjCode);
			pstmt.setString(4, lpoNo);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				poType = rst.getString("PURCHASE_ORDER_TYPE");
				offlineflag= rst.getString("APPL_OFFLINE_YN");
			}
			if(poType.equals("APPL") && offlineflag.equals(RefCodeConstant.BOOLEAN_YES))
				poType="APPLOFFLINE";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			try {
				if(null != rst) rst.close();
				if(null != pstmt) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return poType;
	}
	
	private static Long getItemSeq(Connection conn, String itemCode) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Long itemSeq = 0l;
		try {
			pstmt = conn.prepareStatement("SELECT ITEM_SEQNO FROM T_ITEMS WHERE ITEM_CODE = ?");
			pstmt.setString(1, itemCode);
			rst = pstmt.executeQuery();			
			while (rst.next()) {
				itemSeq = rst.getLong("ITEM_SEQNO");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != rst) rst.close();
				if(null != pstmt) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return itemSeq;
	}
	

	
	@Override
	public CBMaster getNewCurrentBudgetMaster(long oldCbMsterSeqno) {		
		String query = " SELECT cb_mstr_seqno_new FROM  t_vote_forward_log WHERE cb_mstr_seqno_old =  " + oldCbMsterSeqno;

		CBMaster cbMstr = null;
		Session session = null;
		try {
			session = paymentDAO.getSessionFactory().openSession();
			List objectArrayList = session.createSQLQuery(query).list();
			Long cbMstrNewSeqo = null;
			if (objectArrayList != null && objectArrayList.size()>0) {
				cbMstrNewSeqo =  Long.parseLong(objectArrayList.get(0).toString());
			} 
			if (null != cbMstrNewSeqo) {
				List<CBMaster> cbs = paymentDAO.find("from CBMaster where cbMstrSeqno = " +cbMstrNewSeqo );
				cbMstr = null != cbs ? cbs.get(0) : null;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cbMstr;
	}

	@Override
	public PoCfHdr getCarryForwardRecord(String lpoNo, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PoCfHdr.class);
		List<String> statusList = new ArrayList<String>();
		statusList.add("PEN_YEP");
		statusList.add("PEND_VOTE");
		statusList.add("Closed");
		criteria.add(Restrictions.in("orderStatus",statusList));
		criteria.add(Restrictions.eq("lpoNo",lpoNo));
		criteria.add(Restrictions.eq("facilityCode",facilityCode));
		List<PoCfHdr> poCfHdrs = paymentDAO.findByCriteria(criteria);
		return null!= poCfHdrs && !poCfHdrs.isEmpty() ? poCfHdrs.get(0):null;
	}

	@Override
	public CBMaster getCurrentBudgetMaster(long oldCbMsterSeqno) {		
		String query = " SELECT cb_mstr_seqno FROM  t_current_budget_master  WHERE cb_mstr_seqno =  " + oldCbMsterSeqno;

		CBMaster cbMstr = null;
		Session session = null;
		try {
			session = paymentDAO.getSessionFactory().openSession();
			List objectArrayList = session.createSQLQuery(query).list();
			Long cbMstrNewSeqo = null;
			if (objectArrayList != null && objectArrayList.size()>0) {
				cbMstrNewSeqo =  Long.parseLong(objectArrayList.get(0).toString());
			} 
			if (null != cbMstrNewSeqo) {
				List<CBMaster> cbs = paymentDAO.find("from CBMaster where cbMstrSeqno = " +cbMstrNewSeqo );
				cbMstr = null != cbs ? cbs.get(0) : null;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cbMstr;
	}
	
	@Override
	public List<Payment> getPaymentsByInvoiceNoAndStatus(String invoiceNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Payment.class);
		if(invoiceNo!=null && !invoiceNo.isEmpty())
		detachedCriteria.add(Restrictions.eq("invoiceNo", invoiceNo));
		return getPaymentDAO().findByCriteria(detachedCriteria);
	}
	
}


