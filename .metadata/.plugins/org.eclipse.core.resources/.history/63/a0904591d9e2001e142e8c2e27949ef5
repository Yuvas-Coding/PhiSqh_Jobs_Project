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
import my.com.cmg.iwp.maintenance.model.NePProject;
import my.com.cmg.iwp.maintenance.service.NePProjectService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Service
public class NePProjectServiceImpl implements NePProjectService {

	private BasisNextidDaoImpl<NePProject> nepProjectDAO;
	
	@Override
	public List<NePProject> getProjectList() {
		DetachedCriteria criteria = DetachedCriteria.forClass(NePProject.class);
		
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));		
		List<NePProject> nepProject = nepProjectDAO.findByCriteria(criteria);
		return nepProject;
	}

	public BasisNextidDaoImpl<NePProject> getNepProjectDAO() {
		return nepProjectDAO;
	}

	public void setNepProjectDAO(BasisNextidDaoImpl<NePProject> nepProjectDAO) {
		this.nepProjectDAO = nepProjectDAO;
	}

	@Override
	public void saveOrUpdate(NePProject nePProject) {
		nepProjectDAO.saveOrUpdate(nePProject);
		
	}
	public List<NePProject> findByProgram(Map<Object, Object> map) {
		String projectCode=null;
		String projectGroup=null,projectDesc=null;
		 List<Object> nePProjectbj = new ArrayList<Object>(); 
	       List<NePProject> nePProjectList = new ArrayList<NePProject>(); 
	       Session session=null;
		    try {
	       StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,tahun_kewangan,is_allowed,kod_projek,perihal,group_projek,projek_seqno,status_kod,updated_by,updated_date from t_ep_projek where 1=1 ");
		if(map.containsKey("projectCode")){
			projectCode=(String)map.get("projectCode");
		}
		if(map.containsKey("projectGroup")){
			projectGroup=(String)map.get("projectGroup");
		}
		if(map.containsKey("projectDesc")){
			projectDesc=(String)map.get("projectDesc");
		}
		if(projectCode!=null && projectCode!="")
		{
			qry.append( " and lower(kod_projek) like lower('%"+projectCode+"%')");
		}
		if(projectGroup!=null && projectGroup!="")
		{
			qry.append( " and lower(group_projek) like lower('%"+projectGroup+"%')");
		}
		if(projectDesc!=null && projectDesc!="")
		{
			qry.append( " and lower(perihal) like lower('%"+projectDesc+"%')");
		}
		qry.append( " order by updated_date desc, group_projek asc");
		SessionFactory sessionFactory = nepProjectDAO.getSessionFactory();
		 session = sessionFactory.openSession();
		nePProjectbj= session.createSQLQuery(qry.toString()).list();
			} catch (Exception e) {
			    e.printStackTrace();

			}finally{
			    if(session != null &&  session.isOpen()){
				session.close();
			    }
			}
		for (Object objects : nePProjectbj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePProject nePProject=new NePProject();
			
			nePProject.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePProject.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProject.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePProject.setFinancialYear(object[++i]!=null?Integer.parseInt(object[i].toString()):null);
			nePProject.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePProject.setProjectCode(object[++i]!=null?(object[i].toString()):null);
			nePProject.setProjectDescription(object[++i]!=null?(object[i].toString()):null);
			nePProject.setProjectGroup(object[++i]!=null?(object[i].toString()):null);
			nePProject.setProjectSeqno(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProject.setStatusCode(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePProject.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProject.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePProjectList.add(nePProject);
		}
		return nePProjectList;
	}

	@Override
	public List<NePProject> findActiveAllowByList(List<NePProject> nePProjectList) {
		List<NePProject> keyList = new ArrayList();
		for(NePProject l1:nePProjectList){
			if(l1.getActiveFlag().equals(RefCodeConstant.ACTIVE_FLAG_TRUE)&& l1.getIsAllowedInPhis().equals(RefCodeConstant.BOOLEAN_TRUE)){
				keyList.add(l1);
			}
		}
		return keyList;
	}
}
