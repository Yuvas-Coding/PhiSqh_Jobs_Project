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
import my.com.cmg.iwp.maintenance.model.NePContractInfo;
import my.com.cmg.iwp.maintenance.service.NePContractInfoService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class NePContractInfoServiceImpl implements NePContractInfoService {

	
	private BasisNextidDaoImpl<NePContractInfo> nepContractInfoDAO;
	
	@Override
	public List<NePContractInfo> getContractInfoList() {
		DetachedCriteria criteria = DetachedCriteria.forClass(NePContractInfo.class);
		
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));	
		criteria.add(Restrictions.ge("expiredDate",  new Date()));
		List<NePContractInfo> nepContractInfo = nepContractInfoDAO.findByCriteria(criteria);
		return nepContractInfo;
	}

	public BasisNextidDaoImpl<NePContractInfo> getNepContractInfoDAO() {
		return nepContractInfoDAO;
	}

	public void setNepContractInfoDAO(BasisNextidDaoImpl<NePContractInfo> nepContractInfoDAO) {
		this.nepContractInfoDAO = nepContractInfoDAO;
	}

	@Override
	public void saveOrUpdate(NePContractInfo nePContractInfo) {
		nepContractInfoDAO.saveOrUpdate(nePContractInfo);
		
	}
	public List<NePContractInfo> findByProgram(Map<Object, Object> map) {
		String ePContractNo=null;
		
		 List<Object> nePcontractbj = new ArrayList<Object>(); 
	       List<NePContractInfo> nePcontractList = new ArrayList<NePContractInfo>(); 
		StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,is_allowed,ep_contract_no,physical_contract_no,action,contract_seqno,effective_date,expired_date,updated_by,updated_date from t_ep_contract_info where 1=1  ");
		if(map.containsKey("ePContractNo")){
			ePContractNo=(String)map.get("ePContractNo");
		}
		
		if(ePContractNo!=null && ePContractNo!="")
		{
			qry.append( " and lower(ep_contract_no) like lower('%"+ePContractNo+"%')");
		}
		
		qry.append( " order by updated_date desc");
		SessionFactory sessionFactory = nepContractInfoDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		nePcontractbj= session.createSQLQuery(qry.toString()).list();
		for (Object objects : nePcontractbj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePContractInfo nePcontract=new NePContractInfo();
			
			nePcontract.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePcontract.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePcontract.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePcontract.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePcontract.setePContractNo(object[++i]!=null?(object[i].toString()):null);
			nePcontract.setPhysicalContractNo(object[++i]!=null?(object[i].toString()):null);
			nePcontract.setAction(object[++i]!=null?(object[i].toString()):null);
			nePcontract.setContractSeqNo(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePcontract.setEffectiveDate(object[++i]!=null?(Date)object[i]:null);
			nePcontract.setExpiredDate(object[++i]!=null?(Date)object[i]:null);
			nePcontract.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePcontract.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePcontractList.add(nePcontract);
		}
		return nePcontractList;
	}
}
