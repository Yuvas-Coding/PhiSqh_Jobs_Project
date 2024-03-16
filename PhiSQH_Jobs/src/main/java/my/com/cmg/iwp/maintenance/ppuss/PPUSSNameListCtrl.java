package my.com.cmg.iwp.maintenance.ppuss;

import java.awt.Button;
import java.awt.Component;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.xml.crypto.dsig.spec.XPathType.Filter;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;

import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.PPUSSName;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.PPUSSNameService;
import my.com.cmg.iwp.maintenance.service.SecUserService;
import my.com.cmg.iwp.webui.component.Datebox;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.maintenance.referenceCodes.ReferenceCodesListCtrl;
import my.com.cmg.iwp.webui.util.GFCBaseListCtrl;
import my.com.cmg.iwp.webui.util.pagging.PagedListWrapper;

public class PPUSSNameListCtrl extends GFCBaseListCtrl<PPUSSName> implements Serializable{
	private transient static final Logger logger = Logger.getLogger(ReferenceCodesListCtrl.class);
	protected Textbox tb_ppussName;
	protected Paging paging_ppussNameList;
	protected Listbox listBoxPpussName;
	protected Combobox cb_ppussState,cb_createdBy;
	protected Listheader listheader_ppussCode,listheader_ppussStateCode,listheader_ppussState,listheader_ppussName,
	listheader_activeFlag,listheader_createdOn,	listheader_updatedOn;
	protected Button button_Search,btnRefresh;
	private transient PagedListWrapper<PPUSSName> plwRefCode;
	private transient PPUSSNameService  ppussNameService;
	private transient SecUserService secUserService;
	protected Datebox db_createdDateFrom,db_createdDateTo;

	public PPUSSNameListCtrl() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doBeforeComposeChildren(Component comp) throws Exception {
		//CommonRenderer.setCommonRenderers(comp, RefCodeConstant.SPL_DRUG_REQ_APPROVER);
		super.doBeforeComposeChildren(comp);

		List<RefCodes> statusList = getRefCodesService().getRefCodesByDomain(RefCodeConstant.STATE_MY);
		statusList.sort((r1,r2)->Integer.parseInt(r1.getRcValue()) - Integer.parseInt(r2.getRcValue()));
		RefCodes refCode = new RefCodes();
		refCode.setRcValue("ALL");
		refCode.setRcDesc("All");
		statusList.add(0, refCode);
		comp.setAttribute("ppussNameModel", new ListModelList(statusList, true));
		comp.setAttribute("ppussNameRenderer", new ComboitemRenderer() {

			public void render(Comboitem item, Object data) throws Exception {

				RefCodes refCode = (RefCodes) data;
				item.setLabel(refCode.getRcDesc());
				item.setValue(refCode.getRcValue());
				if (refCode.getRcValue().equals("ALL"))
					cb_ppussState.setSelectedItem(item);

			}

			@Override
			public void render(Comboitem item, Object data, int arg2) throws Exception {

				this.render(item, data);

			}
			

		});
		
		List<SecUser> secUser = secUserService.getAllUsers();
		SecUser sec = new SecUser();
		sec.setUsrName("All");
		sec.setId(-1);
		secUser.add(0, sec);
		comp.setAttribute("createdByModel", new ListModelList(secUser, true));
		comp.setAttribute("createdByRenderer", new ComboitemRenderer() {

			public void render(Comboitem item, Object data) throws Exception {

				SecUser secUser = (SecUser) data;
				item.setLabel(secUser.getUsrName());
				item.setValue(secUser.getId());
				if (secUser.getUsrName().equals("All"))
					cb_createdBy.setSelectedItem(item);

			}

			@Override
			public void render(Comboitem item, Object data, int arg2) throws Exception {

				this.render(item, data);

			}

		});
	}
	
	public void onCreate$window_ppussName(Event event)  {
		
		
		paging_ppussNameList.setPageSize(10);
		paging_ppussNameList.setDetailed(true);

		listheader_ppussCode.setSortAscending(new FieldComparator("ppussCode", true));
		listheader_ppussCode.setSortDescending(new FieldComparator("ppussCode", false));
		listheader_ppussStateCode.setSortAscending(new FieldComparator("activeFlag", true));
		listheader_ppussStateCode.setSortDescending(new FieldComparator("activeFlag", false));
		listheader_ppussState.setSortAscending(new FieldComparator("ppussState", true));
		listheader_ppussState.setSortDescending(new FieldComparator("ppussState", false));
		listheader_ppussName.setSortAscending(new FieldComparator("ppussName", true));
		listheader_ppussName.setSortDescending(new FieldComparator("ppussName", false));
		listheader_activeFlag.setSortAscending(new FieldComparator("activeFlag", true));
		listheader_activeFlag.setSortDescending(new FieldComparator("activeFlag", false));
		listheader_updatedOn.setSortAscending(new FieldComparator("updatedDate", true));
		listheader_updatedOn.setSortDescending(new FieldComparator("updatedDate", false));
		listheader_createdOn.setSortAscending(new FieldComparator("createdDate", true));
		listheader_createdOn.setSortDescending(new FieldComparator("createdDate", false));
		HibernateSearchObject<PPUSSName> ppussName = new HibernateSearchObject<PPUSSName>(PPUSSName.class);
		//approvers.addFilter(Filter.equal("status", RefCodeConstant.STATUS_VALUE_ACTIVE));
		ppussName.addSort("updatedDate", true);
		getplwRefCode().init(ppussName, listBoxPpussName, paging_ppussNameList);

		listBoxPpussName.setItemRenderer(new PPUSSNameListRenderer());
	}
	
	public void onClick$button_Search(Event event) throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}
		doSearch();
	}
	
	public void onClick$button_addPPUSSName(Event event) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}
		PPUSSName ppussName = getPpussNameService().getNewPpussName();

		showDetailView(ppussName);
	}
	
	public void onClick$btnRefresh(Event event) {
		cb_ppussState.setSelectedIndex(0);
		tb_ppussName.setValue("");
		db_createdDateFrom.setValue(null);
		db_createdDateTo.setValue(null);
		cb_createdBy.setSelectedIndex(0);
		doSearch();
	}
	
	private void doSearch() {
		
		HibernateSearchObject<PPUSSName> ppussName = new HibernateSearchObject<PPUSSName>(PPUSSName.class);

		if (cb_ppussState.getSelectedIndex()!=0) {
			ppussName.addFilter(new Filter("ppussState", cb_ppussState.getSelectedItem().getValue(), Filter.OP_EQUAL));
		}
		if (tb_ppussName.getValue()!= null) {
			ppussName.addFilter(new Filter("ppussName", "%"+tb_ppussName.getValue()+"%", Filter.OP_ILIKE));
		}
		if (db_createdDateFrom.getValue()!= null) {
			ppussName.addFilter(new Filter("createdDate",db_createdDateFrom.getValue() , Filter.OP_GREATER_OR_EQUAL));
		}
		if (db_createdDateFrom.getValue()!= null) {
			ppussName.addFilter(new Filter("createdDate",db_createdDateFrom.getValue() , Filter.OP_LESS_OR_EQUAL));
		}
		if (cb_createdBy.getSelectedIndex()!=0) {
			ppussName.addFilter(new Filter("createdBy", cb_createdBy.getSelectedItem().getValue(), Filter.OP_EQUAL));
		}
		ppussName.addSort("updatedDate", true);
		getPagedListWrapper().init(ppussName, listBoxPpussName, paging_ppussNameList);
	}

	private void showDetailView(PPUSSName ppussName) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ppussName", ppussName);
		map.put("ppussNameListCtrl", this);
		try {
			Executions.createComponents("/pages/maintenance/pharmacy/ppussName/NewPpussNameDialog.zul", null, map);
		} catch (Exception e) {
			logger.error("onOpenWindow:: error opening window / " + e.getMessage());
			e.printStackTrace();

		}
	}
	
	public void onDoubleClicked(Event event) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		Listitem item = listBoxPpussName.getSelectedItem();

		if (item != null) {
			PPUSSName ppussName = (PPUSSName) item.getAttribute("data");

			if (logger.isDebugEnabled()) {
				logger.debug("--> " + ppussName.getPpussName());
			}

			showDetailView(ppussName);
		}
	}
	
	public void setPlwRefCode(PagedListWrapper<PPUSSName> plwRefCode) {
		this.plwRefCode = plwRefCode;
	}

	public PagedListWrapper<PPUSSName> getplwRefCode() {
		return plwRefCode;
	}
	
	public PPUSSNameService getPpussNameService() {
		return ppussNameService;
	}

	public void setPpussNameService(PPUSSNameService ppussNameService) {
		this.ppussNameService = ppussNameService;
	}
	
	public SecUserService getSecUserService() {
		return secUserService;
	}

	public void setSecUserService(SecUserService secUserService) {
		this.secUserService = secUserService;
	}
}
