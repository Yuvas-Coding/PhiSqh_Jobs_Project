package my.com.cmg.iwp.maintenance.ppuss;

import java.awt.Button;
import java.awt.Component;
import java.awt.Window;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.SimpleConstraint;
import org.zkoss.zul.Textbox;

import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.PPUSSName;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.PPUSSNameService;
import my.com.cmg.iwp.util.ExceptionMessage;
import my.com.cmg.iwp.webui.CommonRenderer;
import my.com.cmg.iwp.webui.MessageConstant;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.ButtonStatusCtrl;
import my.com.cmg.iwp.webui.util.GFCBaseCtrl;
import my.com.cmg.iwp.webui.util.pagging.PagedListWrapper;

public class NewPpussNameDialogCtrl extends GFCBaseCtrl implements Serializable{

	protected Combobox cb_ppussState;
	protected Textbox tb_ppussName,tb_code;
	protected String oldVar_cb_ppussState, oldVar_tb_ppussName, oldVar_cmb_Status;
	protected Button btnNew, btnEdit, btnDelete, btnSave, btnCancel,btnClose;
	private transient ButtonStatusCtrl btnCtrl;
	private SecUser secUser;
	private transient final String btnCtroller_ClassPrefix = "button_PPUSSNameListCtrl_";
	private PPUSSName ppussName;
	protected PPUSSNameListCtrl ppussNameListCtrl;
	private PPUSSNameService ppussNameService;
	protected Combobox cmb_Status;
	private Window window_NewPPUSSNameDialog;
	private transient static final Logger logger = Logger.getLogger(NewPpussNameDialogCtrl.class);
	protected String flag = "New";
	private transient PagedListWrapper<PPUSSName> plwRefCode;
	private boolean validationOn;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doBeforeComposeChildren(Component comp) throws Exception {
		CommonRenderer.setCommonRenderers(comp, RefCodeConstant.STATUS);
		//CommonRenderer.setCommonRenderers(comp, RefCodeConstant.SPL_DRUG_REQ_APPROVER);
		super.doBeforeComposeChildren(comp);

		List<RefCodes> statusList = getRefCodesService().getRefCodesByDomain(RefCodeConstant.STATE_MY);
		statusList.sort((r1,r2)->Integer.parseInt(r1.getRcValue()) - Integer.parseInt(r2.getRcValue()));
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
	}
	
	public void onCreate$window_NewPPUSSNameDialog(Event event) throws Exception {
		btnCtrl = new ButtonStatusCtrl(getUserWorkspace(), btnCtroller_ClassPrefix, btnNew, btnEdit, btnDelete, btnSave, btnCancel, btnClose, null);
		secUser = (SecUser) session.getAttribute("loginInfo");
		Map<String, Object> args = getCreationArgsMap(event);
		if(args.containsKey("ppussName")) {
			this.ppussName = (PPUSSName) args.get("ppussName");
		}
		if(args.containsKey("ppussNameListCtrl")) {
			this.ppussNameListCtrl = (PPUSSNameListCtrl) args.get("ppussNameListCtrl");
		}
		doSetFieldProperties();
		doShowDialog(getPpussName());
	}

	private void doSetFieldProperties() {
		tb_ppussName.setMaxlength(500);
	}
	
	private void doShowDialog(PPUSSName ppussName) {
		
		if(ppussName==null)
		{
			ppussName=getPpussNameService().getNewPpussName();
		}
		
		if(isNewPpussName(ppussName))
		{
			btnCtrl.setInitNew();
			long createdby = secUser.getId();
			ppussName.setCreatedBy(createdby);
			ppussName.setCreatedDate(new Date());
			cmb_Status.setReadonly(true);
			cmb_Status.setDisabled(true);
			cmb_Status.setSelectedIndex(0);
		} else {
			btnCtrl.setInitEdit();
			doReadOnly();
		}
		tb_code.setDisabled(true);
		try {
			doWriteBeanToComponents(ppussName);
			doStoreInitValues();
			window_NewPPUSSNameDialog.doModal(); // open the dialog in modal
													// mode
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	private void doReadOnly() {
		cb_ppussState.setDisabled(true);
		tb_ppussName.setReadonly(true);
		cmb_Status.setDisabled(true);
		tb_code.setReadonly(true);
	}

	private boolean isNewPpussName(PPUSSName ppussName2) {
		if(null ==ppussName2.getPpussName())
		return true;
		
		return false;
	}

	private void doWriteComponentsToBean(PPUSSName ppussName) {
		if (cb_ppussState.getSelectedItem() != null) {
			ppussName.setPpussState(cb_ppussState.getSelectedItem().getValue());
			;
		}
		if (!tb_ppussName.getText().isEmpty())
			ppussName.setPpussName(tb_ppussName.getText());
		if ("A".equals(cmb_Status.getSelectedItem().getValue().toString()))
			ppussName.setActiveFlag(RefCodeConstant.STATUS_VALUE_ACTIVE);
		else
			ppussName.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE);
//		ppussName.setPpussCode(ppussName.getPpussSeqno().toString());
		ppussName.setUpdatedBy(secUser.getId());
		ppussName.setUpdatedDate(new Date());
		this.setPpussName(ppussName);
	}
	
	private void doWriteBeanToComponents(PPUSSName ppussName) {
		if (!isNewPpussName(ppussName)) {

			tb_ppussName.setValue(ppussName.getPpussName());
			cb_ppussState.setSelectedIndex(Integer.parseInt(ppussName.getPpussState()) -1);;
//			cmb_Status.setValue(ppussName.getActiveFlag());
			if (ppussName.getActiveFlag().equals(RefCodeConstant.STATUS_VALUE_ACTIVE))
				cmb_Status.setSelectedIndex(0);
			else
				cmb_Status.setSelectedIndex(1);
			tb_code.setValue(ppussName.getPpussCode());
		}		
	}
	
	public void onClick$btnNew(Event event) throws InterruptedException{
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}
		resetAllFields();
		this.ppussName = new PPUSSName();
		btnCtrl.setInitNew();
		long createdby = secUser.getId();
		ppussName.setCreatedBy(createdby);
		ppussName.setCreatedDate(new Date());
		cmb_Status.setReadonly(true);
		cmb_Status.setDisabled(true);
		cmb_Status.setSelectedIndex(0);
		this.tb_code.setReadonly(false);
		btnNew.setVisible(false);
		btnDelete.setVisible(false);
		btnEdit.setVisible(false);
		btnSave.setVisible(true);

		doEdit();
		setPpussName(ppussName);
	}
	
	public void onClick$btnCancel(Event event) throws InterruptedException {
		int val = -1;
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doRemoveValidation();
		if (isDataChanged()) {			
			val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_RESET);
			if (val == ExceptionMessage.YES) {
				doCancel();
			} else if (val == ExceptionMessage.NO) {
				doRemoveValidation();
			}
		} else {
			doReadOnly();
		}
	}
	
	public void resetAllFields() {
		cb_ppussState.setSelectedItem(null);
		tb_ppussName.setValue("");
		cmb_Status.setSelectedItem(null);
		tb_code.setValue("");
	}
	
	public void onClick$btnSave(Event event) throws InterruptedException {
		int val = -1;
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		if (!doSetValidation()) {
			return;
		}
		
		if (isDataChanged()) {
			if (isNewPpussName(getPpussName()))
			{
				val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_SAVE);
				if(val == ExceptionMessage.YES){
					try {
						doSave();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(val == ExceptionMessage.NO){
					doRemoveValidation();
				}
			}
			else {
				val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_SAVE);
				if (val == ExceptionMessage.YES) {
					doSave();
				}else if(val == ExceptionMessage.NO){
					doRemoveValidation();
					doCancel();
				}
			}
		}
		else {
			doRemoveValidation();
			window_NewPPUSSNameDialog.onClose();
		}
	}
	
	private boolean doSetValidation() {
		tb_ppussName.setConstraint(new SimpleConstraint("No Empty"));
		cb_ppussState.setConstraint(new SimpleConstraint("No Empty"));
		cmb_Status.setConstraint(new SimpleConstraint("No Empty"));
//		check(divspldrugreqApprover);
		return true;
	}
	
	private void doCancel() {
		doResetInitValues();		
	}
	
	private void doRemoveValidation() {
		setValidationOn(false);
		tb_ppussName.clearErrorMessage();
		cb_ppussState.clearErrorMessage();
		cmb_Status.clearErrorMessage();

		tb_ppussName.setConstraint("");
		cb_ppussState.setConstraint("");
		cmb_Status.setConstraint("");
		
	}
	
	public void doSave() throws InterruptedException {

		PPUSSName ppussName =getPpussName();

		if (ppussName == null) {
			ppussName = new PPUSSName();
		}
		doWriteComponentsToBean(ppussName);
		try {

			getPpussNameService().saveOrUpdate(ppussName);
			if(ppussName.getPpussSeqno()!= null) {
				ppussName.setPpussCode(ppussName.getPpussSeqno().toString());
				getPpussNameService().saveOrUpdate(ppussName);
			}
			ExceptionMessage.showMessage(MessageConstant.SAVE_SUCCESS);

		} catch (DataAccessException e) {
			e.printStackTrace();
			doResetInitValues();
			doReadOnly();
			btnCtrl.setBtnStatus_Save();
			btnDelete.setVisible(false);
			return;
		}
		refereshListingPage();
		doReadOnly();
		btnCtrl.setBtnStatus_Save();
		dovisibiltyOfallButtons();
		doStoreInitValues();

	}
	
	private void dovisibiltyOfallButtons()
	{
		btnDelete.setVisible(true);
		btnEdit.setVisible(true);
		btnNew.setVisible(true);
	}
	public void onClick$btnDelete(Event event) throws InterruptedException {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doDelete();
	}
	
	private void doDelete() throws InterruptedException {
		int val = -1;
		PPUSSName ppussName =getPpussName();

		// Show a confirm box
		val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_DELETE_1,ppussName.getPpussName());
		if (val == ExceptionMessage.YES) {
			deletePpussName(ppussName);
		}
	}
	
	private void deletePpussName(PPUSSName ppussName) {

		ppussName.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE);
		getPpussNameService().saveOrUpdate(ppussName);
		ExceptionMessage.showMessage(MessageConstant.DELETE_SUCCESS);
		refereshListingPage();
		window_NewPPUSSNameDialog.onClose();
	}
	
	private void refereshListingPage()
	{
		HibernateSearchObject<PPUSSName> ppussName = new HibernateSearchObject<PPUSSName>(PPUSSName.class);
		//approvers.addFilter(Filter.equal("status", RefCodeConstant.STATUS_VALUE_ACTIVE));
		ppussName.addSort("updatedDate", true);
		getPpussNameListCtrl().getplwRefCode().setSearchObject(ppussName);
	}
	
	private void doResetInitValues() 
	{
		tb_ppussName.setValue(oldVar_tb_ppussName);
		cb_ppussState.setValue(oldVar_cb_ppussState);
		cmb_Status.setValue(oldVar_cmb_Status);
		
	}
	
	private boolean isDataChanged() {
		boolean changed = false;

		if (oldVar_tb_ppussName != tb_ppussName.getValue()) {
			changed = true;
		}

		if (oldVar_cb_ppussState != cb_ppussState.getValue()) {
			changed = true;
		}

		if (oldVar_cmb_Status != cmb_Status.getValue()) {
			changed = true;
		}
		return changed;
	}
	
	private void doStoreInitValues() {

		oldVar_tb_ppussName =tb_ppussName.getValue();
		oldVar_cb_ppussState = cb_ppussState.getValue();
		oldVar_cmb_Status=cmb_Status.getValue().toString();
	}
	
	public void onClick$btnClose(Event event) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}
		doClose();
	}
	
	private void doClose() {
		window_NewPPUSSNameDialog.onClose();		
	}
	
	public void onClick$btnEdit(Event event) {
		flag = "Edit";
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}
		btnSave.setVisible(true);
		doEdit();
	}
	
	private void doEdit() {
		tb_ppussName.setReadonly(false);
		cb_ppussState.setReadonly(false);
		cb_ppussState.setDisabled(false);
		cmb_Status.setReadonly(false);
		cmb_Status.setDisabled(false);
		btnCtrl.setBtnStatus_Edit();
		//btnSave.setVisible(true);
		doStoreInitValues();
	}
	
	public PPUSSNameService getPpussNameService() {
		return ppussNameService;
	}

	public void setPpussNameService(PPUSSNameService ppussNameService) {
		this.ppussNameService = ppussNameService;
	}

	public PPUSSName getPpussName() {
		return ppussName;
	}

	public void setPpussName(PPUSSName ppussName) {
		this.ppussName = ppussName;
	}

	public PPUSSNameListCtrl getPpussNameListCtrl() {
		return ppussNameListCtrl;
	}

	public void setPpussNameListCtrl(PPUSSNameListCtrl ppussNameListCtrl) {
		this.ppussNameListCtrl = ppussNameListCtrl;
	}
	
	public PagedListWrapper<PPUSSName> getPlwRefCode() {
		return plwRefCode;
	}

	public void setPlwRefCode(PagedListWrapper<PPUSSName> plwRefCode) {
		this.plwRefCode = plwRefCode;
	}
	
	public boolean isValidationOn() {
		return validationOn;
	}

	public void setValidationOn(boolean validationOn) {
		this.validationOn = validationOn;
	}
		
}
