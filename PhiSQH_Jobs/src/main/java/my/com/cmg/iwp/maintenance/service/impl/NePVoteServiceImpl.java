package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.NePVote;
import my.com.cmg.iwp.maintenance.service.NePVoteService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class NePVoteServiceImpl implements NePVoteService {
	private BasisNextidDaoImpl<NePVote> nepVoteDAO;
	@Override
	public List<NePVote> getVoteList()
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(NePVote.class);
		
//		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));		
		List<NePVote> nepVote = nepVoteDAO.findByCriteria(criteria);		
		
		return nepVote;
		
	}
	
	public List<NePVote> getActiveAllowVoteList()
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(NePVote.class);
		
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));		
		List<NePVote> nepVote = nepVoteDAO.findByCriteria(criteria);		
		
		return nepVote;
		
	}
	public BasisNextidDaoImpl<NePVote> getNepVoteDAO() {
		return nepVoteDAO;
	}
	public void setNepVoteDAO(BasisNextidDaoImpl<NePVote> nepVoteDAO) {
		this.nepVoteDAO = nepVoteDAO;
	}
	@Override
	public void saveOrUpdate(NePVote nePVote) {
		nepVoteDAO.saveOrUpdate(nePVote);
		
	}
	@Override
	public List<NePVote> findByVote(Map<Object, Object> map) {
		String voteCode=null;
		String voteGroup=null;
		 List<Object> nePvoteobj = new ArrayList<Object>(); 
	       List<NePVote> nePVoteList = new ArrayList<NePVote>(); 
		StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,tahun_kewangan,is_allowed,kod_vot,perihal,group_vot,vot_seqno,updated_by,updated_date,default_yn from t_ep_vot where 1=1 ");
		if(map.containsKey("voteCode")){
			voteCode=(String)map.get("voteCode");
		}
		if(map.containsKey("voteGroup")){
			voteGroup=(String)map.get("voteGroup");
		}
		if(voteCode!=null && voteCode!="")
		{
			qry.append( " and lower(kod_vot) like lower('%"+voteCode+"%')");
		}
		if(voteGroup!=null && voteGroup!="")
		{
			qry.append( " and lower(group_vot) like lower('%"+voteGroup+"%')");
		}
		qry.append( " order by updated_date desc, group_vot asc");
		SessionFactory sessionFactory = nepVoteDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		nePvoteobj= session.createSQLQuery(qry.toString()).list();
		for (Object objects : nePvoteobj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePVote nePVote=new NePVote();
			
			nePVote.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePVote.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePVote.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePVote.setFinancialYear(object[++i]!=null?Integer.parseInt(object[i].toString()):null);
			nePVote.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePVote.setVoteCode(object[++i]!=null?(object[i].toString()):null);
			nePVote.setVoteDescription(object[++i]!=null?(object[i].toString()):null);
			nePVote.setVoteGroup(object[++i]!=null?(object[i].toString()):null);
			nePVote.setVoteSeqno(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePVote.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePVote.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePVote.setDefaultYn(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePVoteList.add(nePVote);
		}
		return nePVoteList;
	}

	@Override
	public List<NePVote> findActiveAllowByList(List<NePVote> nePProjectList) {
		List<NePVote> keyList = new ArrayList();
		for(NePVote l1:nePProjectList){
			if(l1.getActiveFlag().equals(RefCodeConstant.ACTIVE_FLAG_TRUE)&& l1.getIsAllowedInPhis().equals(RefCodeConstant.BOOLEAN_TRUE)){
				keyList.add(l1);
			}
		}
		return keyList;
	}

	@Override
	public NePVote getNewNePVote() {		
		return new NePVote();
	}
	
	@Override
	public List<NePVote> getDefaultNepVote()
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(NePVote.class);
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));
		criteria.add(Restrictions.eq("defaultYn", RefCodeConstant.BOOLEAN_TRUE));
		List<NePVote> nepVote = nepVoteDAO.findByCriteria(criteria);
		return nepVote;
		
	}

	@Override
	public boolean getdefaultvlue() {
		SessionFactory sessionFactory = null;
		Session session = null;
		boolean isAvailable = false;
		String qry = " select default_yn from t_ep_vot where default_yn='Y'";
		try {
			sessionFactory = nepVoteDAO.getSessionFactory();
			session = sessionFactory.openSession();
			List objectArrayList = session.createSQLQuery(qry).list();
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
