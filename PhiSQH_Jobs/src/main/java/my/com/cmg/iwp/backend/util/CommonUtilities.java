package my.com.cmg.iwp.backend.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.spring.SpringUtil;

import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.util.Message;
import my.com.cmg.iwp.util.MyApplicationContextAware;
import my.com.cmg.iwp.util.RefCodesUtils;


public class CommonUtilities {
	
	public static Map<String, Message> loadMessageMap(Connection conn) {
		Map<String, Message> messageMap = new HashMap<String, Message>();
		Map<String, String> titleMap = new HashMap<String, String>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Message message = null;
		String sql1 = "SELECT rc_value , rc_desc FROM t_ref_codes WHERE rc_domain = 'MESSAGE_TYPE'";
		String sql2 = "SELECT message_code, message, message_type, module FROM t_messages";
		try {
			pstmt = conn.prepareStatement(sql1);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				titleMap.put(rst.getString("rc_value"), rst.getString("rc_desc"));
			}
			
			pstmt = conn.prepareStatement(sql2);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				message = new Message();
				message.setMessageCode(rst.getString("message_code"));
				message.setMessage(rst.getString("message_code")+": "+rst.getString("message"));
				message.setMessageType(rst.getString("message_type"));
				message.setModule(rst.getString("module"));
				message.setTitle(rst.getString("message_type") != null ? titleMap.get(rst.getString("message_type")) : "");
				
				messageMap.put(rst.getString("message_code"), message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rst)
					rst.close();
				if (null != pstmt) 
					pstmt.close();
				if (null != conn)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return messageMap; 
	}
	
	public static void loadRefCodesMap() {
		Map<String,Map<String,RefCodes>> refCodesMap = getRefCodesUtils().getRefCodesMap();
		MyApplicationContextAware.isRefCodesMapExists = (refCodesMap.size() > 0);
		MyApplicationContextAware.setRefCodesMap(refCodesMap);
	}

	public static RefCodesUtils getRefCodesUtils() {
		return (RefCodesUtils) MyApplicationContextAware.getBean("refCodesUtils");
	}	
	
	public static List<ExternalFacilityBean> getExternalFacilityJMSConfigList(String facilityName, String facilityCode, String state, String is_queue_active) {
		List<ExternalFacilityBean> listJMSFacilityConfig = new ArrayList<ExternalFacilityBean>(); 
		DataSource dataSource = (DataSource) SpringUtil.getBean("dataSource");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ExternalFacilityBean extFacBean = null;
		String sql1 = "SELECT FACILITY_NAME, "
					   +" FACILITY_CODE, "
					   +" EXT_FAC.SERVER_IP AS HOST_NAME, "
					   +" REF_CODE.RC_DESC AS STATE, " 
					   +" IS_QUEUE_ACTIVE, "
					   +" Q_QUEUE_NAME_FAC, "
					   +" Q_EXCHANGE_HQ_HOST, "
					   +" Q_EXCHANGE_DC_HOST, "
					   +" Q_EXCHANGE_UNAME, "
					   +" Q_EXCHANGE_PASSWORD, "
					   +" Q_QUEUE_NAME_HQ, "
					   +" Q_QUEUE_NAME_PUB, "
					   +" Q_QUEUE_NAME_DC, "
					   +" Q_EXCHANGE_NAME_HQ, "
					   +" Q_EXCHANGE_NAME_DC, "
					   +" MAX_DATA_PER_BATCH, "
					   +" NTHREDS, "
					   +" DATA_BATCH_SIZE, "
					   +" NACK_WAIT, "
					   +" WAIT_FOR_NEXT_DELV "
					+" FROM T_FAC_QUEUE_CONFIG CONFIG "
					  +" JOIN T_EXTERNAL_FACILITIES EXT_FAC ON EXT_FAC.FACILITY_CODE = CONFIG.Q_QUEUE_NAME_FAC "
					  + "JOIN T_REF_CODES REF_CODE ON REF_CODE.RC_VALUE = EXT_FAC.STATE " 
					  +" WHERE  REF_CODE.RC_DOMAIN = 'STATE_MY' AND 1 = 1 ";
		
		if(StringUtils.isNotEmpty(facilityName)) sql1 += " AND FACILITY_NAME like '%"+facilityName+"%'";
		if(StringUtils.isNotEmpty(facilityCode)) sql1 += " AND FACILITY_CODE like '%"+facilityCode+"%'";
		if(StringUtils.isNotEmpty(state)) sql1 += " AND STATE like '%"+state+"%'";
		if(StringUtils.isNotEmpty(is_queue_active)) sql1 += " AND is_queue_active like '%"+is_queue_active+"%'";
		
		System.out.println(sql1);
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql1);
			
			rst = pstmt.executeQuery();
			while (rst.next()) {
				extFacBean = new ExternalFacilityBean();
				
				extFacBean.setFACILITY_NAME(rst.getString("FACILITY_NAME"));
				extFacBean.setFACILITY_CODE(rst.getString("FACILITY_CODE"));
				extFacBean.setHOST_NAME(rst.getString("HOST_NAME"));
				extFacBean.setSTATE(rst.getString("STATE"));
				extFacBean.setIS_QUEUE_ACTIVE(rst.getString("IS_QUEUE_ACTIVE"));
				extFacBean.setQ_QUEUE_NAME_FAC(rst.getString("Q_QUEUE_NAME_FAC"));
				extFacBean.setQ_EXCHANGE_DC_HOST(rst.getString("Q_EXCHANGE_HQ_HOST"));
				extFacBean.setQ_EXCHANGE_HQ_HOST(rst.getString("Q_EXCHANGE_DC_HOST"));
				extFacBean.setQ_EXCHANGE_UNAME(rst.getString("Q_EXCHANGE_UNAME"));
				extFacBean.setQ_EXCHANGE_PASSWORD(rst.getString("Q_EXCHANGE_PASSWORD"));
				extFacBean.setQ_QUEUE_NAME_HQ(rst.getString("Q_QUEUE_NAME_HQ"));
				extFacBean.setQ_QUEUE_NAME_PUB(rst.getString("Q_QUEUE_NAME_PUB"));
				extFacBean.setQ_QUEUE_NAME_DC(rst.getString("Q_QUEUE_NAME_DC"));
				extFacBean.setQ_EXCHANGE_NAME_HQ(rst.getString("Q_EXCHANGE_NAME_HQ"));
				extFacBean.setQ_EXCHANGE_NAME_DC(rst.getString("Q_EXCHANGE_NAME_DC"));
				extFacBean.setMAX_DATA_PER_BATCH(rst.getLong("MAX_DATA_PER_BATCH"));
				extFacBean.setNTHREDS(rst.getLong("NTHREDS"));
				extFacBean.setDATA_BATCH_SIZE(rst.getLong("DATA_BATCH_SIZE"));
				extFacBean.setNACK_WAIT(rst.getLong("NACK_WAIT"));
				extFacBean.setWAIT_FOR_NEXT_DELV(rst.getLong("WAIT_FOR_NEXT_DELV"));
				
				listJMSFacilityConfig.add(extFacBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (null != pstmt) {
					pstmt.close();
				}
				if (null != rst) {
					rst.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listJMSFacilityConfig;
	}
}
