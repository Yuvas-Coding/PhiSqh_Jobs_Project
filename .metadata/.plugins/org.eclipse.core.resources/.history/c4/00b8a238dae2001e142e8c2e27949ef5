package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.PkdApprovalDAOImpl;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.PoHdr;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.PkdApprovalService;
import my.com.cmg.iwp.maintenance.service.VoteCodeService;
@Service
public class PkdApprovalServiceImpl implements PkdApprovalService {
	private PkdApprovalDAOImpl pkdApprovalDAO;
	private VoteCodeService voteCodeService;

	public PkdApprovalDAOImpl getPkdApprovalDAO() { return pkdApprovalDAO; }

	public void setPkdApprovalDAO(PkdApprovalDAOImpl pkdApprovalDAO) { this.pkdApprovalDAO = pkdApprovalDAO; }

	public VoteCodeService getVoteCodeService() { return voteCodeService; }

	public void setVoteCodeService(VoteCodeService voteCodeService) { this.voteCodeService = voteCodeService; }

	@Override
	public List<ExternalFacility> getListForClinicName() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		criteria.setFetchMode("externalFacility", FetchMode.JOIN);

		criteria.addOrder(Order.asc("facilityCode"));
		return pkdApprovalDAO.findByCriteria(criteria);

		/*
		 * String query = "select distinct(facilityCode) from ExternalFacility";
		 * System.out.println("query ----------- >> "+query); return
		 * pkdApprovalDAO.find(query);
		 */
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PoHdr> getPkdApprovalPoHdrHqList() {
		String query = "from PoHdr as PoHdr join fetch PoHdr.poDtls as poDtls "
				// + "join fetch PoHdr.externalFacility "
				// + "join fetch poDtls.itemBrand as itemBrand "
				// + "join fetch itemBrand.item as item "
				+ "join fetch poDtls.item as item";
//				+ "join fetch item.itemBatch ";

		System.out.println("query ----------- >> " + query);
		return pkdApprovalDAO.find(query);
	}

	@Override
	public List<ExternalFacility> getFacilityListasPerPTJCode(String ptjCode) {
		String query = "select all ef from ExternalFacility ef where ef.facilityCode="
				+ "'" + ptjCode + "'";
		return pkdApprovalDAO.find(query);

		/*
		 * String query = "select distinct(facilityCode) from ExternalFacility";
		 * System.out.println("query ----------- >> "+query); return
		 * pkdApprovalDAO.find(query);
		 */
	}
	@Override
	public String getRefCodeDescription(String rcDomain, String rcValue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(RefCodes.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("rcDomain", rcDomain));
		detachedCriteria.add(Restrictions.eq("rcValue", rcValue));
		List<RefCodes> refCodes = pkdApprovalDAO.findByCriteria(detachedCriteria);
		if (null != refCodes && refCodes.size() > 0) {
			RefCodes refCode = refCodes.iterator().next();
			return refCode.getRcDesc();
		} else
			return null;
	}
	
	
	public List<RefCodes> getRefCodeDescription(String rcDomain) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(RefCodes.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("rcDomain", rcDomain));
		//detachedCriteria.add(Restrictions.eq("rcValue", rcValue));
		List<RefCodes> refCodes = pkdApprovalDAO.findByCriteria(detachedCriteria);
		if (null != refCodes && refCodes.size() > 0) {
		//	RefCodes refCode = refCodes.iterator().next();
			return refCodes;
		} else
			return null;
	}
	
	@Override
	public SecUser getPoHdrUser(String userId)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SecUser.class);
		return (SecUser)pkdApprovalDAO.get(SecUser.class,Long.parseLong(userId));
	}
}
