package my.com.cmg.iwp.maintenance.ppuss;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import my.com.cmg.iwp.maintenance.model.PPUSSName;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

public class PPUSSNameListRenderer implements ListitemRenderer, Serializable {
	private transient RefCodesService refCodesService;
	private transient SecUserService secUserService;
	List<RefCodes> statusList = getRefCodeService().getRefCodesByDomain(RefCodeConstant.STATE_MY);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public PPUSSNameListRenderer() {
//		Arrays.sort(statusList,Comparator.comparing(RefCodes::getRcValue));
		statusList.sort((r1,r2)->Integer.parseInt(r1.getRcValue()) - Integer.parseInt(r2.getRcValue()));
		
	}
	
	public void render(Listitem item, Object data) throws Exception {
		PPUSSName ppussName = (PPUSSName) data;
		
		Listcell lc = new Listcell(ppussName.getPpussCode());
		lc.setParent(item);

		lc = new Listcell(statusList.get(Integer.parseInt(ppussName.getPpussState())-1).getRcValue());
		lc.setParent(item);
		
		lc = new Listcell(statusList.get(Integer.parseInt(ppussName.getPpussState())-1).getRcDesc());
		lc.setParent(item);
		
		lc = new Listcell(ppussName.getPpussName());
		lc.setParent(item);
		
		lc = new Listcell(ppussName.getActiveFlag().equals(RefCodeConstant.STATUS_VALUE_ACTIVE)?"Active":"Inactive");
		lc.setParent(item);
		
		lc = new Listcell(sdf.format(ppussName.getCreatedDate()));
		lc.setParent(item);
		
		lc = new Listcell(sdf.format(ppussName.getUpdatedDate()));
		lc.setParent(item);

		item.setAttribute("data", data);
		//ComponentsCtrl.applyForward(item, "onClick=onReferenceCodesItemClicked");
		ComponentsCtrl.applyForward(item, "onDoubleClick=onDoubleClicked");
	}
	
	@Override
	public void render(Listitem item, Object data, int index) throws Exception {
		this.render(item, data);
		
	}

	public void setRefCodeService(RefCodesService refCodeService) {
		this.refCodesService = refCodeService;
	}

	public RefCodesService getRefCodeService() {
		if (this.refCodesService == null) {
			this.refCodesService = (RefCodesService) SpringUtil.getBean("refCodesService");
		}
		return refCodesService;
	}
	
	public void setSecUserService(SecUserService secUserService) {
		this.secUserService = secUserService;
	}
	
	public SecUserService getSecUserService() {
		if (this.secUserService == null) {
			this.secUserService = (SecUserService) SpringUtil.getBean("secUserService");
		}
		return secUserService;
	}
}
