package my.com.cmg.iwp.backend.service.inventory.reports.budget.impl;

import java.awt.Component;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.Executions;
//import org.zkoss.zul.Window;

import my.com.cmg.iwp.backend.dao.inventory.reports.budget.PerincianMengikutObjekLanjutDAO;
import my.com.cmg.iwp.backend.model.inventory.reports.budget.PerincianMengikutObjekLanjutStg;
import my.com.cmg.iwp.backend.service.inventory.reports.budget.PerincianMengikutObjekLanjutService;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
@Service
public class PerincianMengikutObjekLanjutServiceImpl implements PerincianMengikutObjekLanjutService {

	private final static transient Logger logger = Logger.getLogger(PerincianMengikutObjekLanjutServiceImpl.class .getName());
	
	private PerincianMengikutObjekLanjutDAO perincianMengikutObjekLanjutDAO;
	
	/************************Accessors and Mutators*******************/

	public PerincianMengikutObjekLanjutDAO getPerincianMengikutObjekLanjutDAO() {
		return perincianMengikutObjekLanjutDAO;
	}

	public void setPerincianMengikutObjekLanjutDAO(
			PerincianMengikutObjekLanjutDAO perincianMengikutObjekLanjutDAO) {
		this.perincianMengikutObjekLanjutDAO = perincianMengikutObjekLanjutDAO;
	}	
	
	/*****************************************************************/
	
	@Override
	public void saveOrUpdate(
			PerincianMengikutObjekLanjutStg perincianMengikutObjekLanjutStg) {
		
	}

	@Override
	public List<PerincianMengikutObjekLanjutStg> getUserRecords(long createdBy) {
		return null;
	}

	@Override
	public void deleteBasedOnCreatedBy(long createdBy) {
		try {
			getPerincianMengikutObjekLanjutDAO().deleteBasedOnCreatedBy(createdBy);
		} catch (HibernateException hbExp) {
			logger.error(hbExp.getMessage());
		}
	}

	@Override
	public void insertPerincianMengikutObjekLanjutStg(Map<String,Object> mapForSearch) {
		try {
			getPerincianMengikutObjekLanjutDAO().insertPerincianMengikutObjekLanjutStg(mapForSearch);
		} catch (HibernateException hbExp) {
			logger.error(hbExp.getMessage());
			hbExp.printStackTrace();
		}
	}

	@Override
	public void printReport(Map<String, Object> paramMap) {
		SecUser user = (SecUser) paramMap.get("user");
		Object durationPeriod = paramMap.get("durationPeriod");
		Object budgetType = paramMap.get("budgetType");
		Connection conn = null;

		try {
			DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
			conn = DataSourceUtils.doGetConnection(ds);
			Calendar cal = Calendar.getInstance();
			Map<Object, Object> params = new HashMap<Object, Object>();

			params.put("imagepathlogo", InventoryConstant.LOGOPATH);
			params.put("printedby", user.getUsrName() != null ? user.getUsrName() : "");
			params.put("userId", user.getId());
			//params.put("facilityName",user.getExternalFacility() != null ? user.getExternalFacility().getFacilityName() : "");
			params.put("currentYear",String.valueOf(cal.get(Calendar.YEAR)));
			params.put("tempohLaporan", "");
			params.put("jabatab", "");
			params.put("budgetTypeName", budgetType);
			params.put("unitName", "");
			if (durationPeriod != null) {
				params.put("DurationPeriod", durationPeriod);
			}
			params.put("REPORT_CONNECTION", conn);
			org.zkoss.zk.ui.Component comp = Executions.createComponents(InventoryConstant.REPORT_ZUL_PATH, null, params);
			comp.setAttribute("REPORT_PATH",InventoryConstant.PERINCIANMENGIKUTOBJEKLANJUT_REPORT);
			comp.setAttribute("PARAMETERS_MAP", params);
			/*
			 * if (comp instanceof Window) { ((Window) comp).doModal(); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
