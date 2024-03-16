package my.com.cmg.iwp.backend.dao.inventory.reports.budget;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import my.com.cmg.iwp.backend.model.inventory.reports.budget.PerincianMengikutObjekLanjutStg;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Repository
public class PerincianMengikutObjekLanjutDAO extends BasisNextidDaoImpl<PerincianMengikutObjekLanjutStg> {

	public void deleteBasedOnCreatedBy(long createdBy) {
		
	}

	public void insertPerincianMengikutObjekLanjutStg(Map<String,Object> mapForSearch) throws HibernateException{
		// 
		Session session = getSessionFactory().openSession();
		StringBuffer queryStr = new StringBuffer();
		queryStr.append(" INSERT INTO t_perincian_mengikut_stg ");
		queryStr.append(" (tl_perincian_mengikut_seqno , ");
		queryStr.append(" tl_session_id,");
		queryStr.append(" tl_created_by,");
		queryStr.append(" tl_vote_code,");
		queryStr.append(" tl_vote_name,");
		queryStr.append(" tl_vote_activity_code,");
		queryStr.append(" tl_vote_object_code,");
		queryStr.append(" tl_current_allocation_amount,");
		queryStr.append(" tl_remarks) ");
		queryStr.append(" ( ");
		queryStr.append(" SELECT ");
		queryStr.append(" t_perincian_mengikut_stg_seq.nextval ");
		queryStr.append(" ,"+mapForSearch.get("userId"));
		queryStr.append(" ,"+mapForSearch.get("userId"));
		queryStr.append(" , v.* ");
		queryStr.append(" FROM ");
		queryStr.append("( SELECT vcd.vote_code ");
		queryStr.append(" ,vcd.vote_name");
		queryStr.append(" ,vtatcod.activity_code");
		queryStr.append(" ,vtobj.object_code");
		queryStr.append(" ,sum(bdall.allocation_deduction_amount) ");
		queryStr.append(" ,bdall.remarks ");
		queryStr.append(" FROM t_budget_allocation_deduction bdall ");
		queryStr.append(" INNER JOIN t_current_budget_master cudgm on bdall.current_budget_master_seqno = cudgm.cb_mstr_seqno ");
		queryStr.append(" INNER JOIN t_vote_codes vcd on vcd.vote_seqno = cudgm.vote_seqno ");
		queryStr.append(" INNER JOIN t_vote_activities vtatcod on vtatcod.activity_seqno = vcd.activity_seqno ");
		queryStr.append(" INNER JOIN t_vote_objects vtobj on vtobj.object_seqno = vcd.object_seqno ");
		queryStr.append(" WHERE bdall.transaction_status='Verified' and bdall.transaction_type='Allocation'" );
		if(mapForSearch != null){
			if(mapForSearch.containsKey("budgetType")){
				queryStr.append(" AND bdall.budget_type = '"+mapForSearch.get("budgetType")+"' ");
			}
			
			if(mapForSearch.containsKey("startDate") && mapForSearch.containsKey("endDate")){
				queryStr.append(" AND bdall.updated_date >= TO_DATE('"+mapForSearch.get("startDate")+"', 'yyyy-MM-dd HH24:MI:SS') ");
				queryStr.append(" AND bdall.updated_date <= TO_DATE('"+mapForSearch.get("endDate")+"', 'yyyy-MM-dd HH24:MI:SS') ");			}
		}
		queryStr.append(" GROUP BY vcd.vote_code,vcd.vote_name,vtatcod.activity_code,vtobj.object_code,bdall.remarks ");
		queryStr.append(" ) v ");
		queryStr.append(" ) ");
		org.hibernate.query.Query query= session.createNativeQuery(queryStr.toString());
		query.executeUpdate();
		session.close();
	}

}
