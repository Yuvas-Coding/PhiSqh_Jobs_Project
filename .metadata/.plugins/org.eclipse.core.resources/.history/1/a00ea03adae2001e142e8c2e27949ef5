package my.com.cmg.iwp.webui.constant;

public class HQConstants {
	public static final String PO_IN_PATH = "/home/integration/";
	public static final String POHDR_SEQNAME = "T_PO_HDR_SEQ";
	public static String POHDR_INSERT = "INSERT INTO T_PO_HDR(PO_HDR_SEQNO, PURCHASE_ORDER_NO, REQUEST_TYPE, PURCHASE_ORDER_TYPE, EP_ENABLE_FLAG, "
			+ "CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, PTJ_CODE, FACILITY_CODE, ORDER_DATE, LPO_NO, LPO_DATE, REMARKS, "
			+ "TOTAL_ORDER_AMOUNT, ITEM_GROUP, DEL_TO_SEQNO, ACTIVE_FLAG, DELIVERY_LEAD_TIME, ORDER_STATUS, FINANCIAL_YEAR, ORD_TYPE, " 
			+ "SUPPLIER_CODE, LPO_TRANSMITTED_DATE, DELIVERY_DUE_DATE, LPO_AMOUNT, ORDER_BY, PKD_SYNC_FLAG) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static String PODTL_INSERT = "INSERT INTO T_PO_DTL(PO_DTL_SEQNO, PO_HDR_SEQNO, PKU, ORDER_QTY,AMOUNT, UNIT_PRICE, ACTIVE_FLAG, "
			+ "CREATED_BY, CREATED_DATE, UPDATED_BY, UPDATED_DATE, ITEM_SEQNO, PRICE_CODE, APPROVED_QTY, " +
					" VOTE_CODE, LAMPIRAN_NO, BATCH_NO, BUDGET_TYPE, EP_APPROVED_QTY, CB_MSTR_SEQNO, BRAND_CODE, BRAND_NAME, MANUFACTURER_CODE," +
					"MANUFACTURER_NAME) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static String PO_SELECT = "SELECT po.*, dos.DEL_TO_CODE as DEL_TO_CODE FROM T_PO_HDR po, T_DELIVERED_TOS dos WHERE "
			+ " po.PTJ_CODE = ? "
			+ "AND po.FACILITY_CODE = ? AND po.DEL_TO_SEQNO = dos.DEL_TO_SEQNO AND UPDATE_LOCAL_FLAG = 'N' "
			+ "AND CANCELLATION_DATE IS NOT NULL AND CANCELLATION_REMARKS IS NOT NULL ";
	
	public static String PO_SELECTLPO = "SELECT po.*, dos.DEL_TO_CODE as DEL_TO_CODE, DELIVERY_DUE_DATE FROM T_PO_HDR po, " +
			" T_DELIVERED_TOS dos WHERE  po.PTJ_CODE = ? AND po.FACILITY_CODE = ? AND " +
			"po.DEL_TO_SEQNO = dos.DEL_TO_SEQNO AND LPO_NO IS NOT NULL AND UPDATE_LOCAL_FLAG = 'N' ";

	public static String PODTL_SELECT = "SELECT DTL.APPROVED_QTY AS APPROVED_QTY, DTL.EP_APPROVED_QTY AS EP_APPROVED_QTY, ITM.ITEM_CODE AS ITEM_CODE "
			+ "FROM T_PO_DTL DTL, T_PO_HDR HDR, T_ITEMS ITM "
			+ "WHERE HDR.PURCHASE_ORDER_NO =  ? AND DTL.PO_HDR_SEQNO = HDR.PO_HDR_SEQNO AND ITM.ITEM_SEQNO = DTL.ITEM_SEQNO";
	
	public static String DODTL_SELECT = "SELECT * FROM T_DO_DTL WHERE CUSTOMER_ID = ? AND CUSTOMER_ACC_NO = ? AND LOCAL_UPDATE_FLAG='N'";// AND LPO_NO = ?";

	public static String DODTL_UPDATE = "UPDATE T_DO_DTL SET LOCAL_UPDATE_FLAG = 'Y' WHERE RUN_NO = ? "
			+ "AND LAMPIRAN_NO = ? AND CUSTOMER_ID = ? AND CUSTOMER_ACC_NO = ? AND LPO_NO = ?";
	
	public static String PO_HDR_UPDATE = "UPDATE T_PO_HDR SET UPDATE_LOCAL_FLAG = 'Y' WHERE PURCHASE_ORDER_NO = ? AND FACILITY_CODE = ? AND PTJ_CODE = ?";

	public static String INTERNAL_ERR = "Internal Process Error! Please Try Again Later";
	
	public static String INVALID_INPUT = "PO Creation Failed! Invalid Input";
	
	public static String PO_HDR_UPDATELPO = "UPDATE T_PO_HDR SET UPDATE_LOCAL_FLAG = 'Y', LPO_TRANSMITTED_DATE = SYSDATE WHERE PURCHASE_ORDER_NO in (?) AND FACILITY_CODE = ? AND PTJ_CODE = ?";
	public static final String FACILITY_TYPE = "HOS";
	public static final String PURCHASE_ORDER_TYPE_CONTRACT =  "Contract";
	public static final String PODTL_SEQNAME = "T_PO_DTL_SEQ";
	public static String DELIVERTOS_SELECT = "SELECT * FROM T_DELIVERED_TOS WHERE DEL_TO_CODE = ?";
	public static String ITEM_SELECT = "SELECT * FROM T_ITEMS WHERE ITEM_CODE = ?";
	
	/*******************************************ZUL Files*******************************************/
	public static final String TASK_LIST_ZUL = "/pages/taskList.zul";
	
	/*******************************************KEY FOR SET ATTRIBUTES*******************************************/
	public static final String DASHBOARD_INTERVAL="DASHBOARD_INTERVAL";
	public static final String CURRENT_USER="CURRENT_USER";
	public static final String TASKLIST_STATUS_OPEN = "O";
	public static final String TASKLIST_STATUS_CLOSE = "C";
	
	/*******************************************GENERAL ATTRIBUTES*******************************************/
	public static final String FRAME_HEIGHT = "25%";
	public static final String CONTROLLER = "controller";
	public static final String TAB_MENU_ITEM_HOME = "tab_menu_Item_Home";
	public static final String BUDGET_ADT_TRX_TYPE_ALLOCATION="Budget Allocation";
	public static final String BUDGET_ADT_TRX_TYPE_DEDUCT="Budget Deduction";
	public static final String BUDGET_ADT_TRX_TYPE_TRANSFER="Budget Transfer";
	public static final String BUDGET_ADT_TRX_TYPE_VIREMENT="Budget Virement";
	public static final String BUDGET_ADT_TRX_TYPE_ADJUST="Budget Adjustment";
	
	public static final String PKD_CREATE = "PKD_CREATE";
	
	public static String PASSWORD_UPDATE_SUCCESSFULL = "INFO0652";
	public static String PASSWORD_NOT_SAME = "ERR0478";
	public static String PASSWORD_OLD_NEW_SAME = "ERR0477";
	public static String PASSWORD_LENGTH_ERROR = "ERR0476";
	public static String PASSWORD_CURRENT_ERROR = "ERR0475";
	public static String PASSWORD_NOT_EMPTY = "ERR0474";
	public static String PASSWORD_NOT_MATCH = "ERR0463";
	public static String PAYMENT_CREATION_PENDING = "Pending For Payment Creation";
	
//	public static final  String REPO_CONFIG_PATH= "C:\\Properties\\OracleRepo.properties";
	public static final  String REPO_CONFIG_PATH= "/home/phisesb/phisbackprops/OracleRepo.properties";
	
}
