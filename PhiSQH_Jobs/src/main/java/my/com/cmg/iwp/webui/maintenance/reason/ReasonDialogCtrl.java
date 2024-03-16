package my.com.cmg.iwp.webui.maintenance.reason;

import java.awt.Button;
import java.awt.Component;
import java.awt.Window;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Paging;
import org.zkoss.zul.SimpleConstraint;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import my.com.cmg.iwp.UserWorkspace;
import my.com.cmg.iwp.common.util.HibernateSearchObject;
import my.com.cmg.iwp.maintenance.model.Reason;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.service.ReasonService;
import my.com.cmg.iwp.maintenance.service.UserService;
import my.com.cmg.iwp.util.ExceptionMessage;
import my.com.cmg.iwp.webui.MessageConstant;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.ButtonStatusCtrl;
import my.com.cmg.iwp.webui.util.CommonUtil;
import my.com.cmg.iwp.webui.util.GFCBaseCtrl;
import my.com.cmg.iwp.webui.util.pagging.PagedListWrapper;

public class ReasonDialogCtrl extends GFCBaseCtrl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8971009427859377206L;
	public static final String HOLD = "H";
	public static final String CLOSE = "C";
	public static final String MODIFY = "M";
	public static final String RETURN_MEDICATION = "RetMed";
	public static final String REISSUE_MEDICATION = "ReiMed";
	public static final String RELEASE_BATCH = "RB";
	public static final String COUNTERCHECK = "CC";
	public static final String MEDICATION_NOT_ADMINISTERED = "MNA";
	public static final String QUARANTINED_ITEM = "QI";
	public static final String CONDEMNED_ITEM = "CI";
	public static final String RETURN_TO_SUPPLIER = "RTP";
	public static final String REJECT_UPON_RECEIVING = "REJ";
	public static final String STOCK_ADJUSTMENT = "SA";
	public static final String WRITE_OFF = "Write Off";
	public static final String OTHERS = "Others";

	private boolean isNew = true;

	private transient static final Logger logger = Logger.getLogger(ReasonDialogCtrl.class);

	/*
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * All the components that are defined here and have a corresponding
	 * component with the same 'id' in the zul-file are getting autowired by our
	 * 'extends GFCBaseCtrl' GenericForwardComposer.
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	protected Window window_ReasonsDialog; // autowired
	protected Component divCenterReason;
	protected ReasonListCtrl reasonListCtrl; // overhanded per param

	protected Textbox reasonCode; // autowired
	protected Textbox reasonDesc; // autowired
	protected Combobox reasonType; // autowired
	protected Combobox reasonStatus; // autowired
	protected Textbox tb_reasonJustification; // autowired
	protected Combobox cb_reasonJustification; // autowired

	// protected Checkbox all; // autowired
	// protected Checkbox inventory; // autowired
	// protected Checkbox manufacturer; // autowired
	// protected Checkbox outPatietPharm; // autowired
	// protected Checkbox mediCounselling; // autowired
	// protected Checkbox inPatientPharm; // autowired
	// protected Checkbox orderMgnt; // autowired
	// protected Checkbox mtac; // autowired
	// protected Checkbox wardPhram; // autowired
	// protected Checkbox adr; // autowired
	// protected Checkbox tdm; // autowired

	// old value vars for edit mode. that we can check if something
	// on the values are edited since the last init.

	private transient String oldVar_reasonCode;
	private transient String oldVar_reasonDesc;
	private transient String oldVar_reasonJustification;
	private transient Comboitem oldVar_reasonType;
	private transient Comboitem oldVar_reasonStatus;
	private transient String oldVar_cb_reasonJustification;

	// bandbox
	protected Listbox listBoxReasonCodeSearch; // autowired
	protected Paging paging_Reason_CodeSearchList; // autowired
	protected Textbox tb_reason_ReasonCode;
	protected Textbox tb_ReasonList_ReasonDesc;
	private PagedListWrapper<Reason> plwReasonList;
	protected Bandbox bandbox_Reason_ReasonCodeSearch;

	protected Listheader listheader_ReasonList_ReasonCode; // autowired
	protected Listheader listheader_ReasonList_ReasonDesc; // autowired

	// not wired vars
	private transient Reason reason; // overhanded per param

	private transient boolean validationOn;

	// Button Controller
	private transient final String btnCtroller_ClassPrefix = "button_ReasonsDialog_";

	private transient ButtonStatusCtrl btnCtrl;
	protected Button btnNew; // autowired
	protected Button btnEdit; // autowired
	protected Button btnDelete; // autowired
	protected Button btnSave; // autowired
	protected Button btnCancel; // autowired
	protected Button btnClose; // autowired

//	protected Button btnHelp; // autowire
	// ServiceDAOs
	private transient ReasonService reasonService;
	private transient UserService userService;
	private SecUser user;

	/**
	 * default constructor.<br>
	 */
	public ReasonDialogCtrl() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}

	/**
	 * Before binding reasons data and calling the dialog window we check, if
	 * the zul-file is called with a parameter for a selected reason object that
	 * is stored in a Map.
	 * 
	 * Code Convention: reasonDialogWindow is the 'id' in the zul-file
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void onCreate$window_ReasonsDialog(Event event) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		/* set components visible dependent of the users rights */
		doCheckRights();

		// create the Button Controller. Disable not used buttons during working
		btnCtrl = new ButtonStatusCtrl(getUserWorkspace(), btnCtroller_ClassPrefix, btnNew, btnEdit, btnDelete, btnSave, btnCancel, btnClose, null);

		// get the params map that are overhanded by creation.
		Map<String, Object> args = getCreationArgsMap(event);

		if (args.containsKey("reason")) {
			Reason anReason = (Reason) args.get("reason");
			setReason(anReason);
		} else {
			setReason(null);
		}

		// we get the listBox Object for the reasons list. So we have access
		// to it and can synchronize the shown data when we do insert, edit or
		// delete reasons here.
		if (args.containsKey("reasonListCtrl")) {
			reasonListCtrl = (ReasonListCtrl) args.get("reasonListCtrl");
		} else {
			reasonListCtrl = null;
		}

		// set Field Properties
		doSetFieldProperties();

		doShowDialog(getReason());

	}

	/**
	 * SetVisible for components by checking if there's a right for it.
	 */
	private void doCheckRights() {

		UserWorkspace workspace = getUserWorkspace();

		// window_ReasonsDialog.setVisible(workspace
		// .isAllowed("window_ReasonsDialog"));

//		btnHelp.setVisible(workspace.isAllowed("button_ReasonsDialog_btnHelp"));
		btnNew.setVisible(workspace.isAllowed("button_ReasonsDialog_btnNew"));
		btnEdit.setVisible(workspace.isAllowed("button_ReasonsDialog_btnEdit"));
		btnDelete.setVisible(workspace.isAllowed("button_ReasonsDialog_btnDelete"));
		btnSave.setVisible(workspace.isAllowed("button_ReasonsDialog_btnSave"));
		btnClose.setVisible(workspace.isAllowed("button_ReasonsDialog_btnClose"));
		btnCancel.setVisible(workspace.isAllowed("button_ReasonsDialog_btnCancel"));
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// +++++++++++++++++++++++ Components events +++++++++++++++++++++++
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * If we close the dialog window. <br>
	 * 
	 * @param event
	 * @throws Exception
	 */
	public void onClose$window_ReasonsDialog(Event event) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doClose();

	}

	/**
	 * when the "save" button is clicked. <br>
	 * 
	 * @param event
	 * @throws InterruptedException
	 */
	public void onClick$btnSave(Event event) throws InterruptedException {
		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		if (!doSetValidation()) {
			return;
		}

		if (isNewReason(getReason())) {
			// Show a confirm box
			
			int val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_SAVE);
			if(val == ExceptionMessage.YES)
			{
				try {
					doSave();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if(val == ExceptionMessage.NO){
				doRemoveValidation();
			}
		} else {
			// Show a confirm box

			
			int val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_CLOSE);
			if(val == ExceptionMessage.YES)
			{
				try {
					doSave();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if(val == ExceptionMessage.NO){
				doRemoveValidation();
				doCancel();
			}
		}
	}

	/**
	 * when the "edit" button is clicked. <br>
	 * 
	 * @param event
	 */
	public void onClick$btnEdit(Event event) {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doEdit();
		reasonCode.setReadonly(true);
		reasonStatus.setDisabled(false);
	}

	/**
	 * when the "help" button is clicked. <br>
	 * 
	 * @param event
	 * @throws InterruptedException
	 */
	public void onClick$btnHelp(Event event) throws InterruptedException {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		ExceptionMessage.showMessage(MessageConstant.NOT_IMPLEMENTED);
	}

	/**
	 * when the "new" button is clicked. <br>
	 * 
	 * @param event
	 */
	public void onClick$btnNew(Event event) {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doNew();
	}

	/**
	 * when the "delete" button is clicked. <br>
	 * 
	 * @param event
	 * @throws InterruptedException
	 */
	public void onClick$btnDelete(Event event) throws InterruptedException {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doDelete();
	}

	/**
	 * when the "cancel" button is clicked. <br>
	 * 
	 * @param event
	 */
	public void onClick$btnCancel(Event event) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		doRemoveValidation();

		if (isDataChanged()) {

			if (isNew) {
				// Show a confirm box
				if(ExceptionMessage.showMessage(MessageConstant.CONFIRM_RESET) == ExceptionMessage.YES)
				{
					doCancel();
				}
			} else {
				// Show a confirm box
				int val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_CLOSE);
				if(val == ExceptionMessage.YES)
				{
					try {
						doSave();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(val == ExceptionMessage.NO){
					doCancel();
				}
			}
		}
	}

	/**
	 * when the "close" button is clicked. <br>
	 * 
	 * @param event
	 * @throws InterruptedException
	 */
	public void onClick$btnClose(Event event) throws InterruptedException {

		if (logger.isDebugEnabled()) {
			logger.debug("--> " + event.toString());
		}

		try {
			doClose();
		} catch (Exception e) {
			// close anyway
			window_ReasonsDialog.onClose();
		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// ++++++++++++++++++++++++ GUI operations +++++++++++++++++++++++++
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * Closes the dialog window. <br>
	 * <br>
	 * Before closing we check if there are unsaved changes in <br>
	 * the components and ask the user if saving the modifications. <br>
	 * 
	 */
	private void doClose() throws Exception {

		doRemoveValidation();
		if (isDataChanged()) {
			int val = 0;
			if (isNewReason(getReason())) {
				val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_SAVE_BEFORE_EXIT);
			} else {
				val = ExceptionMessage.showMessage(MessageConstant.CONFIRM_CLOSE);
			}
			
			if(val == ExceptionMessage.YES)
			{
				try {
					if (!doSetValidation()) {
						return;
					} else {
						doSave();
						window_ReasonsDialog.onClose();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else if(val == ExceptionMessage.NO){
				doRemoveValidation();
				window_ReasonsDialog.onClose();
			}
		} else {
			// close anyway
			doRemoveValidation();
			window_ReasonsDialog.onClose();
		}
	}

	/**
	 * Cancel the actual operation. <br>
	 * <br>
	 * Resets to the original status.<br>
	 * 
	 */
	private void doCancel() {
		doResetInitValues();
	}

	/**
	 * Writes the bean data to the components.<br>
	 * 
	 * @param anReason
	 */
	public void doWriteBeanToComponents(Reason anReason) {

		reasonCode.setValue(anReason.getReasonCode());
		reasonDesc.setValue(anReason.getReasonDesc());

		RefCodes refCodes = getRefCodesService().getRefCodeByRcValue(RefCodeConstant.REASON_TYPE, anReason.getReasonType());
		if (refCodes == null) {
			refCodes = new RefCodes();
		}
		reasonType.setValue(refCodes.getRcDesc());

		if ("CI".equalsIgnoreCase(refCodes.getRcValue())) {
			RefCodes refCodesJustify = anReason.getReasonJustification() != null ? getRefCodesService().getRefCodeByRcValue(RefCodeConstant.CONDEMN_JUSTIFICATION,
					anReason.getReasonJustification()) : null;
			cb_reasonJustification.setValue(refCodesJustify != null ? refCodesJustify.getRcDesc() : "");
		} else {
			tb_reasonJustification.setValue(anReason.getReasonJustification());
		}

		doSetVisibleJustification(refCodes);
		if (isNewReason(anReason)) {
			reasonStatus.setSelectedIndex(0);
		} else {
			if (RefCodeConstant.STATUS_VALUE_ACTIVE.charAt(0) == anReason.getActiveFlag()) {
				RefCodes refCodeStatus = getRefCodesService().getRefCodeByRcValue("STATUS", "A");
				if (refCodeStatus == null) {
					refCodeStatus = new RefCodes();
				}
				reasonStatus.setValue(refCodeStatus.getRcDesc());
			} else {
				RefCodes refCodeStatus = getRefCodesService().getRefCodeByRcValue("STATUS", "I");
				if (refCodeStatus == null) {
					refCodeStatus = new RefCodes();
				}
				reasonStatus.setValue(refCodeStatus.getRcDesc());
			}
		}

		/*
		 * if (anReason.getManufacturingApplYn() == null ||
		 * anReason.getManufacturingApplYn() == 'N') {
		 * manufacturer.setChecked(false); } else {
		 * manufacturer.setChecked(true); } if (anReason.getInventoryApplYn() ==
		 * null || anReason.getInventoryApplYn() == 'N') {
		 * inventory.setChecked(false); } else { inventory.setChecked(true); }
		 * if (anReason.getOpApplYn() == null || anReason.getOpApplYn() == 'N')
		 * { outPatietPharm.setChecked(false); } else {
		 * outPatietPharm.setChecked(true); } if (anReason.getMcApplYn() == null
		 * || anReason.getMcApplYn() == 'N') {
		 * mediCounselling.setChecked(false); } else {
		 * mediCounselling.setChecked(true); } if (anReason.getIpApplYn() ==
		 * null || anReason.getIpApplYn() == 'N') {
		 * inPatientPharm.setChecked(false); } else {
		 * inPatientPharm.setChecked(true); } if (anReason.getMoApplYn() == null
		 * || anReason.getMoApplYn() == 'N') { orderMgnt.setChecked(false); }
		 * else { orderMgnt.setChecked(true); } if (anReason.getMtacApplYn() ==
		 * null || anReason.getMtacApplYn() == 'N') { mtac.setChecked(false); }
		 * else { mtac.setChecked(true); } if (anReason.getWardphApplYn() ==
		 * null || anReason.getWardphApplYn() == 'N') {
		 * wardPhram.setChecked(false); } else { wardPhram.setChecked(true); }
		 * if (anReason.getAdrApplYn() == null || anReason.getAdrApplYn() ==
		 * 'N') { adr.setChecked(false); } else { adr.setChecked(true); } if
		 * (anReason.getTdmApplYn() == null || anReason.getTdmApplYn() == 'N') {
		 * tdm.setChecked(false); } else { tdm.setChecked(true); } if
		 * (anReason.getTdmApplYn() == null && anReason.getAdrApplYn() == null
		 * && anReason.getWardphApplYn() == null && anReason.getMtacApplYn() ==
		 * null && anReason.getMoApplYn() == null && anReason.getIpApplYn() ==
		 * null && anReason.getMcApplYn() == null && anReason.getOpApplYn() ==
		 * null && anReason.getManufacturingApplYn() == null &&
		 * anReason.getInventoryApplYn() == null) { all.setChecked(false); }
		 * else if (anReason.getTdmApplYn() == 'Y' && anReason.getAdrApplYn() ==
		 * 'Y' && anReason.getWardphApplYn() == 'Y' && anReason.getMtacApplYn()
		 * == 'Y' && anReason.getMoApplYn() == 'Y' && anReason.getIpApplYn() ==
		 * 'Y' && anReason.getMcApplYn() == 'Y' && anReason.getOpApplYn() == 'Y'
		 * && anReason.getManufacturingApplYn() == 'Y' &&
		 * anReason.getInventoryApplYn() == 'Y') { all.setChecked(true); } else
		 * { all.setChecked(false); }
		 */
	}

	/**
	 * Writes the components values to the bean.<br>
	 * 
	 * @param anReason
	 */
	public void doWriteComponentsToBean(Reason anReason) {

		anReason.setUpdatedBy(user.getId());
		anReason.setUpdatedDate(new Date());
		anReason.setReasonStatus(reasonStatus.getValue());
		if (reasonStatus.getValue() == "Active") {
			anReason.setReasonStatus("A");
		} else {
			anReason.setReasonStatus("I");
		}

		RefCodes refCodeStatus = getRefCodesService().getRefCodeByRcDesc(RefCodeConstant.STATUS, reasonStatus.getValue());
		if (refCodeStatus.getRcDesc().equalsIgnoreCase("active")) {
			anReason.setActiveFlag(RefCodeConstant.STATUS_VALUE_ACTIVE.charAt(0));
		} else {
			anReason.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
		}

		RefCodes refCodeReasonType = getRefCodesService().getRefCodeByRcDesc(RefCodeConstant.REASON_TYPE, reasonType.getValue());
		anReason.setReasonType(refCodeReasonType.getRcValue());

		anReason.setReasonCode(reasonCode.getValue());
		anReason.setReasonDesc(reasonDesc.getValue());

		if (reasonType.getSelectedItem().getValue().equals("CI")) {
			anReason.setReasonJustification(cb_reasonJustification.getSelectedItem() != null ? cb_reasonJustification.getSelectedItem().getValue().toString() : "");
		} else {
			anReason.setReasonJustification(tb_reasonJustification.getValue());
		}

		/*
		 * if (inventory.isChecked() == true) {
		 * anReason.setInventoryApplYn('Y'); } else {
		 * anReason.setInventoryApplYn('N'); } if (manufacturer.isChecked() ==
		 * true) { anReason.setManufacturingApplYn('Y'); } else {
		 * anReason.setManufacturingApplYn('N'); } if
		 * (outPatietPharm.isChecked() == true) { anReason.setOpApplYn('Y'); }
		 * else { anReason.setOpApplYn('N'); } if (mediCounselling.isChecked()
		 * == true) { anReason.setMcApplYn('Y'); } else {
		 * anReason.setMcApplYn('N'); } if (inPatientPharm.isChecked() == true)
		 * { anReason.setIpApplYn('Y'); } else { anReason.setIpApplYn('N'); } if
		 * (orderMgnt.isChecked() == true) { anReason.setMoApplYn('Y'); } else {
		 * anReason.setMoApplYn('N'); } if (mtac.isChecked() == true) {
		 * anReason.setMtacApplYn('Y'); } else { anReason.setMtacApplYn('N'); }
		 * if (wardPhram.isChecked() == true) { anReason.setWardphApplYn('Y'); }
		 * else { anReason.setWardphApplYn('N'); } if (adr.isChecked() == true)
		 * { anReason.setAdrApplYn('Y'); } else { anReason.setAdrApplYn('N'); }
		 * if (tdm.isChecked() == true) { anReason.setTdmApplYn('Y'); } else {
		 * anReason.setTdmApplYn('N'); }
		 */

		// checkboxValidation();
	}

	/*
	 * public void checkboxValidation() { if (all.isChecked() == true) {
	 * inventory.setDisabled(true); manufacturer.setDisabled(true);
	 * outPatietPharm.setDisabled(true); mediCounselling.setDisabled(true);
	 * inPatientPharm.setDisabled(true); orderMgnt.setDisabled(true);
	 * mtac.setDisabled(true); wardPhram.setDisabled(true);
	 * adr.setDisabled(true); tdm.setDisabled(true); } else if (all.isChecked()
	 * == false) { inventory.setDisabled(false);
	 * manufacturer.setDisabled(false); outPatietPharm.setDisabled(false);
	 * mediCounselling.setDisabled(false); inPatientPharm.setDisabled(false);
	 * orderMgnt.setDisabled(false); mtac.setDisabled(false);
	 * wardPhram.setDisabled(false); adr.setDisabled(false);
	 * tdm.setDisabled(false); } }
	 */

	/*
	 * public void onCheck$all(Event event) { if (all.isChecked() == true) {
	 * inventory.setChecked(true); manufacturer.setChecked(true);
	 * outPatietPharm.setChecked(true); mediCounselling.setChecked(true);
	 * inPatientPharm.setChecked(true); orderMgnt.setChecked(true);
	 * mtac.setChecked(true); wardPhram.setChecked(true); adr.setChecked(true);
	 * tdm.setChecked(true); inventory.setDisabled(true);
	 * manufacturer.setDisabled(true); outPatietPharm.setDisabled(true);
	 * mediCounselling.setDisabled(true); inPatientPharm.setDisabled(true);
	 * orderMgnt.setDisabled(true); mtac.setDisabled(true);
	 * wardPhram.setDisabled(true); adr.setDisabled(true);
	 * tdm.setDisabled(true); } else { inventory.setChecked(false);
	 * manufacturer.setChecked(false); outPatietPharm.setChecked(false);
	 * mediCounselling.setChecked(false); inPatientPharm.setChecked(false);
	 * orderMgnt.setChecked(false); mtac.setChecked(false);
	 * wardPhram.setChecked(false); adr.setChecked(false);
	 * tdm.setChecked(false); inventory.setDisabled(false);
	 * manufacturer.setDisabled(false); outPatietPharm.setDisabled(false);
	 * mediCounselling.setDisabled(false); inPatientPharm.setDisabled(false);
	 * orderMgnt.setDisabled(false); mtac.setDisabled(false);
	 * wardPhram.setDisabled(false); adr.setDisabled(false);
	 * tdm.setDisabled(false); } }
	 */

	/**
	 * Opens the Dialog window modal.
	 * 
	 * It checks if the dialog opens with a new or existing object and set the
	 * readOnly mode accordingly.
	 * 
	 * @param anReason
	 * @throws InterruptedException
	 */
	public void doShowDialog(Reason anReason) throws InterruptedException {

		// if anReason == null then we opened the Dialog without
		// args for a given entity, so we get a new Obj().
		if (anReason == null) {
			/** !!! DO NOT BREAK THE TIERS !!! */
			// We don't create a new DomainObject() in the frontend.
			// We GET it from the backend.
			anReason = getReasonService().getNewReason();
		}

		// set Readonly mode accordingly if the object is new or not.
		if (isNewReason(anReason)) {
			anReason = new Reason();
			anReason.setCreatedDate(new Date());
			anReason.setCreatedBy(user.getId());
			btnCtrl.setInitNew();
			reasonStatus.setValue("Active");
			doEdit();
			reasonStatus.setDisabled(true);
			reasonCode.focus();
		} else {
			btnCtrl.setInitEdit();
			doReadOnly();
		}

		try {
			// fill the components with the data
			doWriteBeanToComponents(anReason);

			// stores the inital data for comparing if they are changed
			// during user action.
			doStoreInitValues();

			window_ReasonsDialog.doModal(); // open the dialog in modal mode
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);

		List<RefCodes> statusList = getRefCodesService().getRefCodesByDomain("STATUS");
		comp.setAttribute("statusModel", new ListModelList(statusList, true));
		comp.setAttribute("statusRenderer", new ComboitemRenderer() {
			public void render(Comboitem item, Object data) throws Exception {

				RefCodes anRefCode = (RefCodes) data;
				item.setLabel(anRefCode.getRcDesc());
				item.setValue(anRefCode);
			}

			@Override
			public void render(Comboitem item, Object data, int index) throws Exception {
				this.render(item, data);

			}
		});

		List<RefCodes> reasonTypeList = getRefCodesService().getRefCodesByDomain("REASON_TYPE");
		comp.setAttribute("reasonTypeModel", new ListModelList(reasonTypeList, true));
		comp.setAttribute("reasonTypeRenderer", new ComboitemRenderer() {
			public void render(Comboitem item, Object data) throws Exception {

				RefCodes anRefCode = (RefCodes) data;
				item.setLabel(anRefCode.getRcDesc());
				item.setValue(anRefCode);
			}

			@Override
			public void render(Comboitem item, Object data, int index) throws Exception {
				this.render(item, data);

			}
		});
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		CommonUtil.populateCombobox(this.cb_reasonJustification, RefCodeConstant.CONDEMN_JUSTIFICATION, null, true, false);
	}

	public void onChange$reasonStatus(Event event) {

		Comboitem ci = reasonStatus.getSelectedItem();
		RefCodes refCode = (RefCodes) ci.getValue();
		reasonStatus.setValue(refCode.getRcDesc());
	}

	public void onChange$reasonType(Event event) {

		Comboitem ci = reasonType.getSelectedItem();
		RefCodes refCode = (RefCodes) ci.getValue();
		doSetVisibleJustification(refCode);
		reasonType.setValue(refCode.getRcDesc());
	}

	private void doSetVisibleJustification(RefCodes refCode) {

		if ("CI".equalsIgnoreCase(refCode.getRcValue())) {
			cb_reasonJustification.setVisible(true);
			tb_reasonJustification.setVisible(false);
		} else {
			cb_reasonJustification.setVisible(false);
			tb_reasonJustification.setVisible(true);
		}

	}

	private boolean isNewReason(Reason anReason) {
		return anReason.getReasonSeqno() == Long.MIN_VALUE;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// ++++++++++++++++++++++++++++++ helpers ++++++++++++++++++++++++++
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * Set the properties of the fields, like maxLength.<br>
	 */
	private void doSetFieldProperties() {
		reasonCode.setMaxlength(10);
		reasonDesc.setMaxlength(60);
		tb_reasonJustification.setMaxlength(60);
	}

	/**
	 * Stores the init values in mem vars. <br>
	 */
	private void doStoreInitValues() {
		oldVar_reasonCode = reasonCode.getValue();
		oldVar_reasonDesc = reasonDesc.getValue();
		oldVar_reasonJustification = tb_reasonJustification.getValue();
		oldVar_reasonType = reasonType.getSelectedItem();
		oldVar_reasonStatus = reasonStatus.getSelectedItem();
		oldVar_cb_reasonJustification = cb_reasonJustification.getValue();

		/*
		 * oldVar_all = all.isChecked(); oldVar_inventory =
		 * inventory.isChecked(); oldVar_manufacturer =
		 * manufacturer.isChecked(); oldVar_outPatietPharm =
		 * outPatietPharm.isChecked(); oldVar_mediCounselling =
		 * mediCounselling.isChecked(); oldVar_inPatientPharm =
		 * inPatientPharm.isChecked(); oldVar_orderMgnt = orderMgnt.isChecked();
		 * oldVar_mtac = mtac.isChecked(); oldVar_wardPhram =
		 * wardPhram.isChecked(); oldVar_adr = adr.isChecked(); oldVar_tdm =
		 * tdm.isChecked();
		 */

	}

	/**
	 * Resets the init values from mem vars. <br>
	 */
	private void doResetInitValues() {

		reasonCode.setValue(oldVar_reasonCode);
		reasonDesc.setValue(oldVar_reasonDesc);
		reasonType.setSelectedItem(oldVar_reasonType);
		tb_reasonJustification.setValue(oldVar_reasonJustification);
		reasonStatus.setSelectedItem(oldVar_reasonStatus);
		cb_reasonJustification.setValue(oldVar_cb_reasonJustification);
		/*
		 * all.setChecked(oldVar_all); inventory.setChecked(oldVar_inventory);
		 * manufacturer.setChecked(oldVar_manufacturer);
		 * outPatietPharm.setChecked(oldVar_outPatietPharm);
		 * mediCounselling.setChecked(oldVar_mediCounselling);
		 * inPatientPharm.setChecked(oldVar_inPatientPharm);
		 * orderMgnt.setChecked(oldVar_orderMgnt); mtac.setChecked(oldVar_mtac);
		 * wardPhram.setChecked(oldVar_wardPhram); adr.setChecked(oldVar_adr);
		 * tdm.setChecked(oldVar_tdm);
		 */
	}

	/**
	 * Checks, if data are changed since the last call of <br>
	 * doStoreInitData() . <br>
	 * 
	 * @return true, if data are changed, otherwise false
	 */
	private boolean isDataChanged() {
		boolean changed = false;

		if (oldVar_reasonCode != reasonCode.getValue()) {
			changed = true;
		}
		if (oldVar_reasonDesc != reasonDesc.getValue()) {
			changed = true;
		}
		if (oldVar_reasonType != reasonType.getSelectedItem()) {
			changed = true;
		}
		if (oldVar_reasonStatus != reasonStatus.getSelectedItem()) {
			changed = true;
		}
		if (oldVar_reasonJustification != tb_reasonJustification.getValue()) {
			changed = true;
		}
		if (oldVar_cb_reasonJustification != cb_reasonJustification.getValue()) {
			changed = true;
		}
		/*
		 * if (oldVar_tdm != tdm.isChecked()) { changed = true; } if (oldVar_adr
		 * != adr.isChecked()) { changed = true; } if (oldVar_wardPhram !=
		 * wardPhram.isChecked()) { changed = true; } if (oldVar_mtac !=
		 * mtac.isChecked()) { changed = true; } if (oldVar_orderMgnt !=
		 * orderMgnt.isChecked()) { changed = true; } if (oldVar_inPatientPharm
		 * != inPatientPharm.isChecked()) { changed = true; } if
		 * (oldVar_mediCounselling != mediCounselling.isChecked()) { changed =
		 * true; } if (oldVar_outPatietPharm != outPatietPharm.isChecked()) {
		 * changed = true; } if (oldVar_manufacturer !=
		 * manufacturer.isChecked()) { changed = true; } if (oldVar_inventory !=
		 * inventory.isChecked()) { changed = true; }
		 */

		return changed;
	}

	/**
	 * check each of components' children inside a form to prevent the
	 * confirmation popup appear after validating only 2 component
	 * 
	 * @param component
	 */
	private void check(Component component) {
		checkIsValid(component);

		List<Component> children = component.getChildren();
		for (Component each : children) {
			check(each);
		}
	}

	private void checkIsValid(Component component) {
		if (component instanceof InputElement) {
			if (!((InputElement) component).isValid()) {
				// Force show errorMessage
				((InputElement) component).getText();
			}
		}
	}

	/**
	 * Sets the Validation by setting the accordingly constraints to the fields.
	 */
	private boolean doSetValidation() {

		setValidationOn(true);
		check(divCenterReason);
		reasonCode.setConstraint(new SimpleConstraint("NO EMPTY"));
		reasonDesc.setConstraint(new SimpleConstraint("NO EMPTY"));
		reasonType.setConstraint(new SimpleConstraint("NO EMPTY"));
		reasonStatus.setConstraint(new SimpleConstraint("NO EMPTY"));

		Reason tempReason = getReasonService().findByReasonCode(reasonCode.getValue());
		if (tempReason != null & isNewReason(getReason())) {
			ExceptionMessage.showMessage(MessageConstant.REASON_CODE_ALREADY_EXIST);
			return false;
		}  
		/*else {
			if (reasonCode.getValue().equalsIgnoreCase(oldVar_reasonCode)) {
				// code remain the same, do nothing
			} else {
				ExceptionMessage.showMessage(MessageConstant.REASON_CODE_ALREADY_EXIST);
				return false;
			}
		}*/

		return true;
	}
	/**
	 * Disables the Validation by setting empty constraints.
	 */
	private void doRemoveValidation() {

		setValidationOn(false);
		// to clear error messages (the red popup bubble)
		// since if you only setConstraint to null, you have
		// to close each red popup bubble
		reasonCode.clearErrorMessage();
		reasonDesc.clearErrorMessage();
		reasonType.clearErrorMessage();
		reasonStatus.clearErrorMessage();
		tb_reasonJustification.clearErrorMessage();

		reasonCode.setConstraint("");
		reasonDesc.setConstraint("");
		reasonType.setConstraint("");
		reasonStatus.setConstraint("");
		tb_reasonJustification.setConstraint("");
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// +++++++++++++++++++++++++ crud operations +++++++++++++++++++++++
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * Deletes a reason object from database.<br>
	 * 
	 * @throws InterruptedException
	 */
	private void doDelete() throws InterruptedException {
		if(ExceptionMessage.showMessage(MessageConstant.CONFIRM_DELETE) == ExceptionMessage.YES)
		{
			deleteReason();
		}
	}

	private void deleteReason() {

		final Reason anReason = getReason();
		// delete from database
		anReason.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
		anReason.setUpdatedBy(user.getId());
		anReason.setUpdatedDate(new Date());
		// anReason.setReasonStatus("Inactive");
		// save it to database
		try {
	
			getReasonService().saveOrUpdate(anReason);
		} catch (DataAccessException e) {
			// Reset to init values
			doResetInitValues();
			doReadOnly();
			btnCtrl.setBtnStatus_Save();
			e.printStackTrace();
			return;
		}
	
		HibernateSearchObject<Reason> soReason = new HibernateSearchObject<Reason>(Reason.class, getReasonListCtrl().getCountRows());
		// soReason.addFilter(new Filter("activeFlag", 'A'));
		soReason.addSort("updatedDate", true);
		soReason.addSort("reasonCode", false);
	
		// Set the ListModel for the Drugs.
		getReasonListCtrl().getPagedListWrapper().init(soReason, reasonListCtrl.listBoxReason, reasonListCtrl.paging_ReasonList);
		// ListModelList lml = (ListModelList)
		// getReasonListCtrl().listBoxReason
		// .getListModel();
		//
		// // Check if the branch object is new or updated
		// // -1 means that the obj is not in the list, so it's
		// // new.
		// if (lml.indexOf(anReason) == -1) {
		// } else {
		// lml.remove(lml.indexOf(anReason));
		// }
	
		window_ReasonsDialog.onClose(); // close the dialog
	}

	/**
	 * Create a new reason object. <br>
	 */
	private void doNew() {

		/** !!! DO NOT BREAK THE TIERS !!! */
		// We don't create a new DomainObject() in the frontend.
		// We GET it from the backend.
		// this.getReason().setCreateBy(Long.valueOf(super.doGetLoggedInUser()));
		// this.getReason().setCreateBy(super.doGetLoggedInUser());
		// this.getReason().setCreateDateTime(new Date());
		Reason reason = getReasonService().getNewReason();
		reason.setCreatedBy(user.getId());
		reason.setCreatedDate(new Date());

		// setReason(getReasonService().getNewReason());
		setReason(reason);
		reasonStatus.setValue("Active");
		doClear(); // clear all commponents
		doEdit(); // edit mode

		btnCtrl.setBtnStatus_New();

		doStoreInitValues();

		// set Focus
		reasonStatus.setDisabled(true);
		reasonStatus.setSelectedIndex(0);
		reasonCode.focus();
	}

	/**
	 * Set the components for edit mode. <br>
	 */
	private void doEdit() {

		reasonCode.setReadonly(false);
		reasonType.setDisabled(false);
		reasonDesc.setReadonly(false);
		tb_reasonJustification.setReadonly(false);
		tb_reasonJustification.setDisabled(false);
		cb_reasonJustification.setDisabled(false);
		reasonStatus.setReadonly(true);
		// all.setDisabled(false);
		// checkboxValidation();
		btnCtrl.setBtnStatus_Edit();

		// remember the old vars
		doStoreInitValues();
	}

	/**
	 * Set the components to ReadOnly. <br>
	 */
	public void doReadOnly() {
		reasonCode.setReadonly(true);
		reasonDesc.setReadonly(true);
		reasonType.setDisabled(true);
		tb_reasonJustification.setDisabled(true);
		tb_reasonJustification.setReadonly(true);
		reasonStatus.setDisabled(true);
		reasonStatus.setReadonly(true);
		cb_reasonJustification.setDisabled(true);
		/*
		 * all.setDisabled(true); inventory.setDisabled(true);
		 * manufacturer.setDisabled(true); outPatietPharm.setDisabled(true);
		 * mediCounselling.setDisabled(true); inPatientPharm.setDisabled(true);
		 * orderMgnt.setDisabled(true); mtac.setDisabled(true);
		 * wardPhram.setDisabled(true); adr.setDisabled(true);
		 * tdm.setDisabled(true);
		 */
	}

	/**
	 * Clears the components values. <br>
	 */
	public void doClear() {

		// remove validation, if there are a save before
		doRemoveValidation();
		reasonCode.setValue("");
		reasonDesc.setValue("");
		tb_reasonJustification.setValue("");
		reasonType.setValue("");
		reasonStatus.setValue("");
		cb_reasonJustification.setValue("");

		/*
		 * all.setChecked(false); inventory.setChecked(false);
		 * manufacturer.setChecked(false); outPatietPharm.setChecked(false);
		 * mediCounselling.setChecked(false); inPatientPharm.setChecked(false);
		 * orderMgnt.setChecked(false); mtac.setChecked(false);
		 * wardPhram.setChecked(false); adr.setChecked(false);
		 * tdm.setChecked(false);
		 */
	}

	/**
	 * Saves the components to table. <br>
	 * 
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes" })
	public void doSave() throws InterruptedException {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// force validation, if on, than execute by component.getValue()
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (!isValidationOn()) {
			if (!doSetValidation()) {
				return;
			}
		}

		Reason anReason = getReason();

		// fill the customer object with the components data
		doWriteComponentsToBean(anReason);

		if (reasonStatus.getSelectedIndex() == -1) {
			ExceptionMessage.showMessage(MessageConstant.SELECT_RIGHT_STATUS);
			return;
		}

		if (reasonType.getSelectedIndex() == -1) {
			ExceptionMessage.showMessage(MessageConstant.SELECT_RIGHT_TYPE);
			return;
		}

		// save it to database
		try {
			getReasonService().saveOrUpdate(anReason);
			ExceptionMessage.showMessage(MessageConstant.SAVE_SUCCESS);
		} catch (DataAccessException e) {
			e.printStackTrace();

			// Reset to init values
			doResetInitValues();

			doReadOnly();
			btnCtrl.setBtnStatus_Save();
			return;
		}

		// ++ create the searchObject and init sorting ++ //
		HibernateSearchObject<Reason> soReason = new HibernateSearchObject<Reason>(Reason.class, getReasonListCtrl().getCountRows());
		// soReason.addFilter(new Filter("activeFlag", 'A'));
		soReason.addSort("updatedDate", true);
		soReason.addSort("reasonCode", false);
		// Set the ListModel for the reasons.
		getReasonListCtrl().getPagedListWrapper().setSearchObject(soReason);

		// now synchronize the reasons listBox
		ListModelList lml = (ListModelList) getReasonListCtrl().listBoxReason.getListModel();

		doReadOnly();
		btnCtrl.setBtnStatus_Save();
		// init the old values vars new
		doStoreInitValues();

		// window_ReasonsDialog.onClose();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	// ++++++++++++++++++ getter / setter +++++++++++++++++++//
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	public void setValidationOn(boolean validationOn) {
		this.validationOn = validationOn;
	}

	public boolean isValidationOn() {
		return validationOn;
	}

	public void setReasonService(ReasonService reasonService) {
		this.reasonService = reasonService;
	}

	public ReasonService getReasonService() {
		return reasonService;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public ReasonListCtrl getReasonListCtrl() {
		return reasonListCtrl;
	}

	public void setReasonListCtrl(ReasonListCtrl reasonListCtrl) {
		this.reasonListCtrl = reasonListCtrl;
	}

	/*
	 * public void onOpen$reasonCode(Event event) throws Exception { if
	 * (logger.isDebugEnabled()) { logger.debug("--> " + event.toString()); }
	 * listheader_ReasonList_ReasonCode.setSortAscending(new FieldComparator(
	 * "reasonCode", true));
	 * listheader_ReasonList_ReasonCode.setSortAscending(new FieldComparator(
	 * "reasonCode", false));
	 * listheader_ReasonList_ReasonDesc.setSortAscending(new FieldComparator(
	 * "reasonDesc", true));
	 * listheader_ReasonList_ReasonDesc.setSortAscending(new FieldComparator(
	 * "reasonDesc", false)); // ++ create the searchObject and init sorting
	 * ++// HibernateSearchObject<Reason> soReason = new
	 * HibernateSearchObject<Reason>( Reason.class);
	 * soReason.addSort("reasonCode", false); // set the paging pa // Set the
	 * ListModel for the GenericNames. getPlwReasonList().init(soReason,
	 * listBoxReasonCodeSearch, paging_Reason_CodeSearchList); // set the
	 * itemRenderer listBoxReasonCodeSearch.setItemRenderer(new
	 * ReasonSearchListRenderer()); } public void onDoubleClicked(Event event)
	 * throws Exception { if (logger.isDebugEnabled()) { logger.debug("--> " +
	 * event.toString()); } // get the customer Listitem item =
	 * listBoxReasonCodeSearch.getSelectedItem(); if (item != null) { aReason =
	 * (Reason) item.getAttribute("data");
	 * reasonCode.setValue(aReason.getReasonCode());
	 * reasonDesc.setValue(aReason.getReasonDesc()); } // close the bandbox
	 * reasonCode.close(); } public void onClick$button_ReasonCode_Close(Event
	 * event) throws Exception { if (logger.isDebugEnabled()) {
	 * logger.debug("--> " + event.toString()); } reasonCode.close(); } public
	 * void onClick$button_ReasonCode_Search(Event event) throws Exception {
	 * HibernateSearchObject<Reason> soReason = new
	 * HibernateSearchObject<Reason>( Reason.class); soReason.addFilter(new
	 * Filter("reasonCode", "%" + tb_reason_ReasonCode.getValue() + "%",
	 * Filter.OP_ILIKE)); soReason.addFilter(new Filter("reasonDesc", "%" +
	 * tb_ReasonList_ReasonDesc.getValue() + "%", Filter.OP_ILIKE));
	 * getPlwReasonList().init(soReason, listBoxReasonCodeSearch,
	 * paging_Reason_CodeSearchList); // set the itemRenderer
	 * listBoxReasonCodeSearch.setItemRenderer(new ReasonSearchListRenderer());
	 * }
	 */

	public PagedListWrapper<Reason> getPlwReasonList() {
		return plwReasonList;
	}

	public void setPlwReasonList(PagedListWrapper<Reason> plwReasonList) {
		this.plwReasonList = plwReasonList;
	}

	public void setUserService(UserService userService) {
		String userName = super.doGetLoggedInUser();
		user = userService.getUserByLoginname(userName);
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

}
