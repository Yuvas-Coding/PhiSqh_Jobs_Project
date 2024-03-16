package my.com.cmg.iwp.backend.util;

/**
 * @author Tapan Kumar Sabat
 *
 */
public class ExternalFacilityBean {

	private String FACILITY_NAME;
	private String FACILITY_CODE;
	private String HOST_NAME;
	private String STATE;
	private String IS_QUEUE_ACTIVE;
	private String Q_QUEUE_NAME_FAC;
	private String Q_EXCHANGE_HQ_HOST;
	private String Q_EXCHANGE_DC_HOST;
	private String Q_EXCHANGE_UNAME;
	private String Q_EXCHANGE_PASSWORD;
	private String Q_QUEUE_NAME_HQ;
	private String Q_QUEUE_NAME_PUB;
	private String Q_QUEUE_NAME_DC;
	private String Q_EXCHANGE_NAME_HQ;
	private String Q_EXCHANGE_NAME_DC;
	private long MAX_DATA_PER_BATCH;
	private long NTHREDS;
	private long DATA_BATCH_SIZE;
	private long NACK_WAIT;
	private long WAIT_FOR_NEXT_DELV;
	
	public String getFACILITY_NAME(){return FACILITY_NAME;}
	public void setFACILITY_NAME(String fACILITY_NAME){FACILITY_NAME=fACILITY_NAME;}
	public String getFACILITY_CODE(){return FACILITY_CODE;}
	public void setFACILITY_CODE(String fACILITY_CODE){FACILITY_CODE=fACILITY_CODE;}
	public String getHOST_NAME(){return HOST_NAME;}
	public void setHOST_NAME(String hOST_NAME){HOST_NAME=hOST_NAME;}
	public String getSTATE() { return STATE; }
	public void setSTATE(String sTATE) { STATE = sTATE; }
	public String getIS_QUEUE_ACTIVE(){return IS_QUEUE_ACTIVE;}
	public void setIS_QUEUE_ACTIVE(String iS_QUEUE_ACTIVE){IS_QUEUE_ACTIVE=iS_QUEUE_ACTIVE;}
	public String getQ_QUEUE_NAME_FAC(){return Q_QUEUE_NAME_FAC;}
	public void setQ_QUEUE_NAME_FAC(String q_QUEUE_NAME_FAC){Q_QUEUE_NAME_FAC=q_QUEUE_NAME_FAC;}
	public String getQ_EXCHANGE_HQ_HOST(){return Q_EXCHANGE_HQ_HOST;}
	public void setQ_EXCHANGE_HQ_HOST(String q_EXCHANGE_HQ_HOST){Q_EXCHANGE_HQ_HOST=q_EXCHANGE_HQ_HOST;}
	public String getQ_EXCHANGE_DC_HOST(){return Q_EXCHANGE_DC_HOST;}
	public void setQ_EXCHANGE_DC_HOST(String q_EXCHANGE_DC_HOST){Q_EXCHANGE_DC_HOST=q_EXCHANGE_DC_HOST;}
	public String getQ_EXCHANGE_UNAME(){return Q_EXCHANGE_UNAME;}
	public void setQ_EXCHANGE_UNAME(String q_EXCHANGE_UNAME){Q_EXCHANGE_UNAME=q_EXCHANGE_UNAME;}
	public String getQ_EXCHANGE_PASSWORD(){return Q_EXCHANGE_PASSWORD;}
	public void setQ_EXCHANGE_PASSWORD(String q_EXCHANGE_PASSWORD){Q_EXCHANGE_PASSWORD=q_EXCHANGE_PASSWORD;}
	public String getQ_QUEUE_NAME_HQ(){return Q_QUEUE_NAME_HQ;}
	public void setQ_QUEUE_NAME_HQ(String q_QUEUE_NAME_HQ){Q_QUEUE_NAME_HQ=q_QUEUE_NAME_HQ;}
	public String getQ_QUEUE_NAME_PUB(){return Q_QUEUE_NAME_PUB;}
	public void setQ_QUEUE_NAME_PUB(String q_QUEUE_NAME_PUB){Q_QUEUE_NAME_PUB=q_QUEUE_NAME_PUB;}
	public String getQ_QUEUE_NAME_DC(){return Q_QUEUE_NAME_DC;}
	public void setQ_QUEUE_NAME_DC(String q_QUEUE_NAME_DC){Q_QUEUE_NAME_DC=q_QUEUE_NAME_DC;}
	public String getQ_EXCHANGE_NAME_HQ(){return Q_EXCHANGE_NAME_HQ;}
	public void setQ_EXCHANGE_NAME_HQ(String q_EXCHANGE_NAME_HQ){Q_EXCHANGE_NAME_HQ=q_EXCHANGE_NAME_HQ;}
	public String getQ_EXCHANGE_NAME_DC(){return Q_EXCHANGE_NAME_DC;}
	public void setQ_EXCHANGE_NAME_DC(String q_EXCHANGE_NAME_DC){Q_EXCHANGE_NAME_DC=q_EXCHANGE_NAME_DC;}
	public long getMAX_DATA_PER_BATCH(){return MAX_DATA_PER_BATCH;}
	public void setMAX_DATA_PER_BATCH(long mAX_DATA_PER_BATCH){MAX_DATA_PER_BATCH=mAX_DATA_PER_BATCH;}
	public long getNTHREDS(){return NTHREDS;}
	public void setNTHREDS(long nTHREDS){NTHREDS=nTHREDS;}
	public long getDATA_BATCH_SIZE(){return DATA_BATCH_SIZE;}
	public void setDATA_BATCH_SIZE(long dATA_BATCH_SIZE){DATA_BATCH_SIZE=dATA_BATCH_SIZE;}
	public long getNACK_WAIT(){return NACK_WAIT;}
	public void setNACK_WAIT(long nACK_WAIT){NACK_WAIT=nACK_WAIT;}
	public long getWAIT_FOR_NEXT_DELV(){return WAIT_FOR_NEXT_DELV;}
	public void setWAIT_FOR_NEXT_DELV(long wAIT_FOR_NEXT_DELV){WAIT_FOR_NEXT_DELV=wAIT_FOR_NEXT_DELV;}
	
	@Override
	public String toString() {
		return "ExternalFacilityBean [FACILITY_NAME=" + FACILITY_NAME + ", FACILITY_CODE=" + FACILITY_CODE
				+ ", HOST_NAME=" + HOST_NAME + ", STATE=" + STATE + ", IS_QUEUE_ACTIVE=" + IS_QUEUE_ACTIVE
				+ ", Q_QUEUE_NAME_FAC=" + Q_QUEUE_NAME_FAC + ", Q_EXCHANGE_HQ_HOST=" + Q_EXCHANGE_HQ_HOST
				+ ", Q_EXCHANGE_DC_HOST=" + Q_EXCHANGE_DC_HOST + ", Q_EXCHANGE_UNAME=" + Q_EXCHANGE_UNAME
				+ ", Q_EXCHANGE_PASSWORD=" + Q_EXCHANGE_PASSWORD + ", Q_QUEUE_NAME_HQ=" + Q_QUEUE_NAME_HQ
				+ ", Q_QUEUE_NAME_PUB=" + Q_QUEUE_NAME_PUB + ", Q_QUEUE_NAME_DC=" + Q_QUEUE_NAME_DC
				+ ", Q_EXCHANGE_NAME_HQ=" + Q_EXCHANGE_NAME_HQ + ", Q_EXCHANGE_NAME_DC=" + Q_EXCHANGE_NAME_DC
				+ ", MAX_DATA_PER_BATCH=" + MAX_DATA_PER_BATCH + ", NTHREDS=" + NTHREDS + ", DATA_BATCH_SIZE="
				+ DATA_BATCH_SIZE + ", NACK_WAIT=" + NACK_WAIT + ", WAIT_FOR_NEXT_DELV=" + WAIT_FOR_NEXT_DELV + "]";
	}
}
