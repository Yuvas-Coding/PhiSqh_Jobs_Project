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
import my.com.cmg.iwp.maintenance.model.NePProgram;
import my.com.cmg.iwp.maintenance.service.NePProgramService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;


@Service
public class NePProgramServiceImpl implements NePProgramService {
	
	private BasisNextidDaoImpl<NePProgram> nepProgramDAO;
	
	@Override
	public List<NePProgram> getProgramList() {

		DetachedCriteria criteria = DetachedCriteria.forClass(NePProgram.class);
		
		criteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		criteria.add(Restrictions.eq("isAllowedInPhis", RefCodeConstant.BOOLEAN_TRUE));		
		List<NePProgram> nepProgram = nepProgramDAO.findByCriteria(criteria);
		return nepProgram;
	}
	
	@Override
	public void saveOrUpdate(NePProgram nePProgram) {
		nepProgramDAO.saveOrUpdate(nePProgram);
	}

	public BasisNextidDaoImpl<NePProgram> getNepProgramDAO() {
		return nepProgramDAO;
	}

	public void setNepProgramDAO(BasisNextidDaoImpl<NePProgram> nepProgramDAO) {
		this.nepProgramDAO = nepProgramDAO;
	}

	@Override
	public List<NePProgram> findByProgram(Map<Object, Object> map) {
		String programCode=null;
		String programGroup=null,programDesc=null;
		 List<Object> nePProgramobj = new ArrayList<Object>(); 
	       List<NePProgram> nePProgramList = new ArrayList<NePProgram>(); 
		StringBuilder qry = new StringBuilder();
		qry.append("  select active_flag,created_by,created_date,tahun_kewangan,is_allowed,kod_program,perihal,group_program,program_seqno,status_kod,updated_by,updated_date from t_ep_program where 1=1 ");
		if(map.containsKey("programCode")){
			programCode=(String)map.get("programCode");
		}
		if(map.containsKey("programGroup")){
			programGroup=(String)map.get("programGroup");
		}
		if(map.containsKey("programDesc")){
			programDesc=(String)map.get("programDesc");
		}
		if(programCode!=null && programCode!="")
		{
			qry.append( " and lower(kod_program) like lower('%"+programCode+"%')");
		}
		if(programGroup!=null && programGroup!="")
		{
			qry.append( " and lower(group_program) like lower('%"+programGroup+"%')");
		}
		if(programDesc!=null && programDesc!="")
		{
			qry.append( " and lower(perihal) like lower('%"+programDesc+"%')");
		}
		qry.append( " order by updated_date desc, kod_program asc");
		SessionFactory sessionFactory = nepProgramDAO.getSessionFactory();
		Session session = sessionFactory.openSession();
		nePProgramobj= session.createSQLQuery(qry.toString()).list();
		for (Object objects : nePProgramobj) {
			//System.out.println(objects.getClass());
			int i=0;
			Object[] object=(Object[]) objects;
			NePProgram nePProgram=new NePProgram();
			
			nePProgram.setActiveFlag(object[i]!=null?(object[i].toString().charAt(0)):null);
			nePProgram.setCreatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProgram.setCreatedDate(object[++i]!=null?(Date)object[i]:null);
			nePProgram.setFinancialYear(object[++i]!=null?Integer.parseInt(object[i].toString()):null);
			nePProgram.setIsAllowedInPhis(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePProgram.setProgramCode(object[++i]!=null?(object[i].toString()):null);
			nePProgram.setProgramDescription(object[++i]!=null?(object[i].toString()):null);
			nePProgram.setProgramGroup(object[++i]!=null?(object[i].toString()):null);
			nePProgram.setProgramSeqno(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProgram.setStatusCode(object[++i]!=null?(object[i].toString().charAt(0)):null);
			nePProgram.setUpdatedBy(object[++i]!=null?Long.parseLong(object[i].toString()):null);
			nePProgram.setUpdatedDate(object[++i]!=null?(Date)object[i]:null);
			nePProgramList.add(nePProgram);
		}
		return nePProgramList;
	}

	@Override
	public List<NePProgram> findActiveAllowByList(List<NePProgram> nePProjectList) {
		List<NePProgram> keyList = new ArrayList();
		for(NePProgram l1:nePProjectList){
			if(l1.getActiveFlag().equals(RefCodeConstant.ACTIVE_FLAG_TRUE)&& l1.getIsAllowedInPhis().equals(RefCodeConstant.BOOLEAN_TRUE)){
				keyList.add(l1);
			}
		}
		return keyList;
	}

}
