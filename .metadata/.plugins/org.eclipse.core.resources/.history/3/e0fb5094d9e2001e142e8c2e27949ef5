package my.com.cmg.iwp.backend.service.integration.issue.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.issue.IssueBatchesInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueHdrsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueHdrsInt;
import my.com.cmg.iwp.backend.service.integration.issue.IssueIntegrationService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class IssueIntegrationServiceImpl implements IssueIntegrationService {

	private BasisNextidDaoImpl<IssueHdrsInt> issueHdrsIntDAO;
	private BasisNextidDaoImpl<IssueDtlsInt> issueDtlsIntDAO;
	private BasisNextidDaoImpl<IssueBatchesInt> issueBatchesIntDAO;
	private BasisNextidDaoImpl<RejectIssueHdrsInt> rejectIssueHdrsIntDAO;
	private BasisNextidDaoImpl<RejectIssueDtlsInt> rejectIssueDtlsIntDAO;
	
	@Override
	public void save(IssueHdrsInt issueHdrsInt) {
		getIssueHdrsIntDAO().save(issueHdrsInt);
	}

	@Override
	public void save(IssueDtlsInt issueDtlsInt) {
		getIssueDtlsIntDAO().save(issueDtlsInt);
	}

	@Override
	public void save(IssueBatchesInt issueBatchesInt) {
		getIssueBatchesIntDAO().save(issueBatchesInt);
	}

	@Override
	public List<IssueHdrsInt> getAllSendIssue() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(IssueHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("sendFlag",
				RefCodeConstant.BOOLEAN_YES));
		return issueHdrsIntDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public void updateSendFlag(String sendFlagValue, String ptjCode,
			String factCode) {
		StringBuilder updateStr = new StringBuilder();
		updateStr
				.append("update IssueHdrsInt e ")
				.append(" set ")
				.append(" e.sendFlag = :sendFlagValue")
				.append(" where ")
				.append(" e.toFacilityCode = :factCode and e.toPtjCode = :ptjCode ");
		Session session = issueHdrsIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(updateStr.toString());
		query.setParameter("sendFlagValue", sendFlagValue);
		query.setParameter("factCode", factCode);
		query.setParameter("ptjCode", ptjCode);
		query.executeUpdate();
		session.close();

	}
	
	@Override
	public void save(RejectIssueHdrsInt rejectIssueHdrsInt) {
		getRejectIssueHdrsIntDAO().save(rejectIssueHdrsInt);
		
	}

	public BasisNextidDaoImpl<IssueHdrsInt> getIssueHdrsIntDAO() {
		return issueHdrsIntDAO;
	}

	public void setIssueHdrsIntDAO(
			BasisNextidDaoImpl<IssueHdrsInt> issueHdrsIntDAO) {
		this.issueHdrsIntDAO = issueHdrsIntDAO;
	}

	public BasisNextidDaoImpl<IssueDtlsInt> getIssueDtlsIntDAO() {
		return issueDtlsIntDAO;
	}

	public void setIssueDtlsIntDAO(
			BasisNextidDaoImpl<IssueDtlsInt> issueDtlsIntDAO) {
		this.issueDtlsIntDAO = issueDtlsIntDAO;
	}

	public BasisNextidDaoImpl<IssueBatchesInt> getIssueBatchesIntDAO() {
		return issueBatchesIntDAO;
	}

	public void setIssueBatchesIntDAO(
			BasisNextidDaoImpl<IssueBatchesInt> issueBatchesIntDAO) {
		this.issueBatchesIntDAO = issueBatchesIntDAO;
	}

	public BasisNextidDaoImpl<RejectIssueHdrsInt> getRejectIssueHdrsIntDAO() {
		return rejectIssueHdrsIntDAO;
	}

	public void setRejectIssueHdrsIntDAO(BasisNextidDaoImpl<RejectIssueHdrsInt> rejectIssueHdrsIntDAO) {
		this.rejectIssueHdrsIntDAO = rejectIssueHdrsIntDAO;
	}

	
	public BasisNextidDaoImpl<RejectIssueDtlsInt> getRejectIssueDtlsIntDAO() {
		return rejectIssueDtlsIntDAO;
	}

	public void setRejectIssueDtlsIntDAO(BasisNextidDaoImpl<RejectIssueDtlsInt> rejectIssueDtlsIntDAO) {
		this.rejectIssueDtlsIntDAO = rejectIssueDtlsIntDAO;
	}

	@Override
	public void save(RejectIssueDtlsInt rejectIssueDtlsInt) {
		getRejectIssueDtlsIntDAO().save(rejectIssueDtlsInt);
	}

	@Override
	public boolean issueavailable(IssueHdrsInt issueHdrsInt) {
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean isAvailable = false;
		String qry = "select issue_no from t_issue_hdrs_int where ext_inh_no='" + issueHdrsInt.getExtInhNo() + "' and to_facility_code='" + issueHdrsInt.getToFacilityCode() + "'"
				+ " and from_facility_code='" + issueHdrsInt.getFromFacilityCode() + "' and issue_no='" + issueHdrsInt.getIssueNo() + "' ";
		try {
			sessionFactory = issueHdrsIntDAO.getSessionFactory();
			session = sessionFactory.openSession();
			List objectArrayList = session.createNativeQuery(qry).list();
			if (!objectArrayList.isEmpty())
				isAvailable = true;
		} catch (Exception e) {
			e.printStackTrace();

		} finally { 
			if (session != null)
				session.close();
		}
		return isAvailable;
	}
	
	
}
