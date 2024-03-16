package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.VoteCode;
import my.com.cmg.iwp.maintenance.service.VoteCodeService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class VoteCodeServiceImpl implements VoteCodeService {
	private BasisNextidDaoImpl<VoteCode> voteCodeDAO;

	public BasisNextidDaoImpl<VoteCode> getVoteCodeDAO() {
		return voteCodeDAO;
	}

	public void setVoteCodeDAO(BasisNextidDaoImpl<VoteCode> voteCodeDAO) {
		this.voteCodeDAO = voteCodeDAO;
	}

	@Override
	public void saveOrUpdate(VoteCode anVoteCode) {
		// TODO Auto-generated method stub
		voteCodeDAO.saveOrUpdate(anVoteCode);

	}

	@Override
	public VoteCode getNewFunction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(VoteCode anVoteCode) {
		// TODO Auto-generated method stub
		voteCodeDAO.delete(anVoteCode);

	}

	@Override
	public VoteCode getNewVoteCode() {
		// TODO Auto-generated method stub
		return new VoteCode();
	}

	@Override
	public VoteCode getVoteName(long voteCodeSeqNo) {

		DetachedCriteria criteria = DetachedCriteria.forClass(VoteCode.class);
		criteria.add(Restrictions.eq("voteSeqno", voteCodeSeqNo));
		return DataAccessUtils.uniqueResult(voteCodeDAO
				.findByCriteria(criteria));

	}

	@Override
	public VoteCode findByVoteCode(String voteCode, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteCode.class);
		criteria.add(Restrictions.eq("voteCode", voteCode));
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return DataAccessUtils.uniqueResult(voteCodeDAO
				.findByCriteria(criteria));
	}
	
	@Override
	public VoteCode findByVoteCodeAllStatus(String voteCode, String facilityCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteCode.class);
		criteria.add(Restrictions.eq("voteCode", voteCode));
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		return DataAccessUtils.uniqueResult(voteCodeDAO.findByCriteria(criteria));
	}
	
	@Override
	public VoteCode findByExternalFaclity(ExternalFacility externalFacility) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteCode.class);
		criteria.add(Restrictions.eq("facilityCode", externalFacility.getFacilityCode()));
		return DataAccessUtils.uniqueResult(voteCodeDAO
				.findByCriteria(criteria));
	}
	

    public List<BigDecimal> getVoteSeqNobyItemGroup(String itemGroup,String facCode,String ptjcode,long itemseq) {
		List<BigDecimal> reqList = new ArrayList<BigDecimal>(); 
		//String qry = "";
		//qry = "select distinct(vote_seqno) from t_vote_codes voteCode inner join t_vote_objects voteObj on  votecode.object_seqno=voteobj.object_seqno where voteobj.use_by_others='Y' and votecode.facility_code='"+facCode+"' and votecode.vote_ptj_code='"+ptjcode+"'";
		/*StringBuilder query = new StringBuilder(" select voteobj.object_seqno from t_vote_objects voteObj inner join  t_vote_codes voteCode on  votecode.object_seqno=voteobj.object_seqno inner join T_DRUGS drug on drug.OBJECT_SEQNO=voteobj.object_seqno inner join t_items item on drug.drug_seqno=item.drug_seqno"
				+ " where votecode.facility_code='"+facCode+"' and votecode.vote_ptj_code='"+ptjcode+"' and voteobj.use_by_others='Y' and voteCode.active_flag='A' or(item.item_seqno='"+itemseq+"' and voteobj.use_by_others='N')  group by voteobj.object_seqno");
		
		query.append(" union ");
		
		query.append(" select voteobj.object_seqno from t_vote_objects voteObj inner join  t_vote_codes voteCode on  votecode.object_seqno=voteobj.object_seqno inner join t_non_drugs drug on drug.OBJECT_SEQNO=voteobj.object_seqno inner join t_items item on drug.nondrug_seqno=item.nondrug_seqno "
				+ "where votecode.facility_code='"+facCode+"' and votecode.vote_ptj_code='"+ptjcode+"' and voteobj.use_by_others='Y' and voteCode.active_flag='A' or(item.item_seqno='"+itemseq+"' and voteobj.use_by_others='N') group by voteobj.object_seqno ");*/
		
		StringBuilder query = new StringBuilder("select obj.object_seqno from t_vote_objects obj where obj.use_by_others='Y' or object_seqno in (select COALESCE(d.object_seqno,nd.object_seqno) from t_items it left join t_drugs d on d.drug_seqno = it.drug_seqno left join t_non_drugs nd on nd.nondrug_seqno = it.nondrug_seqno where it.item_seqno='"+itemseq+"') ");
		
		System.out.println("QRY=== "+query);
		SessionFactory sessionFactory = voteCodeDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<BigDecimal> objectArrayList = session.createSQLQuery(query.toString()).list();
		/*for (Object objects : objectArrayList) {
			//System.out.println(objects.getClass());
			reqList.add((BigDecimal) objects);
		}*/
		session.close();
		//sessionFactory.close();
		return objectArrayList;
    }
	
	@Override
	public VoteCode findByVoteCodes(String voteCode, String facilityCode,String minitrydept,String votecodestatus) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VoteCode.class);
		criteria.add(Restrictions.eq("voteCode", voteCode));
		criteria.add(Restrictions.eq("facilityCode", facilityCode));
		criteria.createAlias("nePVote", "nePVote", CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("nePVote.voteCode", minitrydept));
		if(votecodestatus!=null)
		{
		if(votecodestatus.equalsIgnoreCase("active"))
		criteria.add(Restrictions.eq("activeFlag",RefCodeConstant.STATUS_VALUE_ACTIVE.charAt(0)));	
		else 
		criteria.add(Restrictions.eq("activeFlag",RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0)));		
		}
		else
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return DataAccessUtils.uniqueResult(voteCodeDAO.findByCriteria(criteria));
	}

	
}
