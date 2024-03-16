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
import my.com.cmg.iwp.maintenance.model.NePGLAccount;
import my.com.cmg.iwp.maintenance.service.NePGLAccountService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class NePGLAccountServiceImpl implements NePGLAccountService {

	private BasisNextidDaoImpl<NePGLAccount> nepGLAccountDAO;
	
	@Override
	public List<NePGLAccount> getGLAccountList() {
		DetachedCriteria criteria = DetachedCriteria.forClass(NePGLAccount.class);
		
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));		
		List<NePGLAccount> nepGLAccount = nepGLAccountDAO.findByCriteria(criteria);
		return nepGLAccount;	}

	
	public BasisNextidDaoImpl<NePGLAccount> getNepGLAccountDAO() {
		return nepGLAccountDAO;
	}

	public void setNepGLAccountDAO(BasisNextidDaoImpl<NePGLAccount> nepGLAccountDAO) {
		this.nepGLAccountDAO = nepGLAccountDAO;
	}


	@Override
	public void saveOrUpdate(NePGLAccount nePGLAccount) {
		nepGLAccountDAO.saveOrUpdate(nePGLAccount);
	}
	public List<NePGLAccount> findByProgram(Map<Object, Object> map) {
		String accountCode=null;
		String satusCode=null;
		 List<Object> nePGlacountctbj = new ArrayList<Object>(); 
	       List<NePGLAccount> nePGlacountList = new ArrayList<NePGLAccount>(); 
		StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,tahun_kewangan,is_allowed,kod_akaun_gl,perihal,akaun_seqno,status_kod,updated_by,updated_date from t_ep_akaun where 1=1 ");
		if(map.containsKey("accountCode")){
			accountCode=(String)map.get("accountCode");
		}
		if(map.containsKey("satusCode")){
			satusCode=(String)map.get("satusCode");
		}
		if(accountCode!=null && accountCode!="")
		{
			qry.append( " and lower(kod_akaun_gl) like lower('%"+accountCode+"%')");
		}
		if(satusCode!=null && satusCode!="")
		{
			qry.append( " and lower(status_kod) like lower('%"+satusCode+"%')");
		}
		qry.append( " and active_flag='"+RefCodeConstant.ACTIVE_FLAG_TRUE+"'");
		qry.append( " order by updated_date desc ");
		SessionFactory sessionFactory = nepGLAccountDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		nePGlacountctbj= session.createSQLQuery(qry.toString()).list();
		for (Object objects : nePGlacountctbj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePGLAccount nePGLAccount=new NePGLAccount();
			
			nePGLAccount.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePGLAccount.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePGLAccount.setFinancialYear(object[++i]!=null?Integer.parseInt(object[i].toString()):null);
			nePGLAccount.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePGLAccount.setAccountCode(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setAccountDescription(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setAccountSeqNo(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setSatusCode(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePGlacountList.add(nePGLAccount);
		}
		return nePGlacountList;
	}
	
	@Override
	public List<NePGLAccount> getAllActiveAllowByCode(String code){
		DetachedCriteria criteria = DetachedCriteria.forClass(NePGLAccount.class);
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));
		criteria.add(Restrictions.isNotNull("isAllowedInPhis"));
		criteria.add(Restrictions.eq("accountCode",code));
		List<NePGLAccount> nepGLAccount = nepGLAccountDAO.findByCriteria(criteria);
		return nepGLAccount;
	}
	
	@Override
	public List<NePGLAccount> findAllowByMap(Map<Object, Object> map) {
		String accountCode=null;
		String satusCode=null;
		String accountDescription=null;
		 List<Object> nePGlacountctbj = new ArrayList<Object>(); 
	       List<NePGLAccount> nePGlacountList = new ArrayList<NePGLAccount>(); 
		StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,tahun_kewangan,is_allowed,kod_akaun_gl,perihal,akaun_seqno,status_kod,updated_by,updated_date from t_ep_akaun where 1=1 ");
		if(map.containsKey("accountCode")){
			accountCode=(String)map.get("accountCode");
		}
		if(map.containsKey("satusCode")){
			satusCode=(String)map.get("satusCode");
		}
		if(map.containsKey("accountDescription")){
			accountDescription=(String)map.get("accountDescription");
		}
		if(accountCode!=null && accountCode!="")
		{
			qry.append( " and lower(kod_akaun_gl) like lower('%"+accountCode+"%')");
		}
		if(satusCode!=null && satusCode!="")
		{
			qry.append( " and lower(status_kod) like lower('%"+satusCode+"%')");
		}
		if(accountDescription!=null && !accountDescription.isEmpty())
		{
			qry.append( " and lower(perihal) like lower('%"+accountDescription+"%')");
		}
		qry.append( " and active_flag='"+RefCodeConstant.ACTIVE_FLAG_TRUE+"'");
		qry.append( " and IS_ALLOWED='"+RefCodeConstant.BOOLEAN_TRUE+"'");
		qry.append( " order by updated_date desc ");
		SessionFactory sessionFactory = nepGLAccountDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		nePGlacountctbj= session.createSQLQuery(qry.toString()).list();
		for (Object objects : nePGlacountctbj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePGLAccount nePGLAccount=new NePGLAccount();
			
			nePGLAccount.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePGLAccount.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePGLAccount.setFinancialYear(object[++i]!=null?Integer.parseInt(object[i].toString()):null);
			nePGLAccount.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePGLAccount.setAccountCode(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setAccountDescription(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setAccountSeqNo(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setSatusCode(object[++i]!=null?(object[i].toString()):null);
			nePGLAccount.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePGLAccount.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePGlacountList.add(nePGLAccount);
		}
		return nePGlacountList;
	}
	
	@Override
	public List<NePGLAccount> findActiveAllowByList(List<NePGLAccount> nePProjectList) {
		List<NePGLAccount> keyList = new ArrayList();
		for(NePGLAccount l1 : nePProjectList){
			if(l1.getIsAllowedInPhis().equals(RefCodeConstant.BOOLEAN_TRUE)){
				keyList.add(l1);
			}
		}
		return keyList;
	}


	@Override
	public NePGLAccount getNewNePGLAccount() {
		return new NePGLAccount();
	}
	
	

}
