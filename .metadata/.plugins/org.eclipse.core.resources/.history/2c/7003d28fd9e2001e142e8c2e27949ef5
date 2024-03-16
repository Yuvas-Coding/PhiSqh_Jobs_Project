package my.com.cmg.iwp.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.spring.SpringUtil;

import my.com.cmg.iwp.maintenance.model.BudgetMovement;
import my.com.cmg.iwp.maintenance.model.CBMaster;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.service.BudgetADTService;
import my.com.cmg.iwp.maintenance.service.PaymentService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.webui.MessageConstant;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.util.CommonUtil;
import my.com.cmg.phis.util.budget.BudgetMovementUtilDTO;
import my.com.cmg.phis.util.budget.BudgetMovmentEventTypes;
import my.com.cmg.phis.util.constant.InventoryConstants;

public class BudgetUtil {

	private static BudgetADTService budgetADTService;
	private static PaymentService paymentService;
	@Autowired
	private  BudgetUtil budgetUtil;
	static DecimalFormat Two_df = new DecimalFormat(".##");
	
	// Accessors
	private static BudgetADTService getBudgetADTService() {
		budgetADTService = (null == budgetADTService ? (BudgetADTService) SpringUtil.getBean("budgetADTService") : budgetADTService);
		return budgetADTService;
	}
	
	private static PaymentService getPaymentService() {
		paymentService = (null == paymentService ? (PaymentService) SpringUtil.getBean("paymentService") : paymentService);
		return paymentService;
	}
	
	public static synchronized boolean processBudgetForKKPO(BudgetUtilDTO budgetUtilDTO) {
		Map<CBMaster,Double> tnxAmtMap = new LinkedHashMap<CBMaster,Double>();
		Map<CBMaster,Double> tnxPrevAmtMap = new LinkedHashMap<CBMaster,Double>();
		NumberFormat decimalFormat =new DecimalFormat("#########0.00");
		boolean isTransactionType = BudgetMovmentEventTypes.EP_APPROVED.equals(budgetUtilDTO.getTransactionType());
		boolean isEPCancel=BudgetMovmentEventTypes.EP_CANCEL.equals(budgetUtilDTO.getTransactionType());
		for(PoDtl poDtl : budgetUtilDTO.getPoHdr().getPoDtls()) {
			CBMaster cbMaster = getPaymentService().getCurrentBudgetMaster(poDtl.getCbMaster().getCbMstrSeqno());
			if (null != cbMaster) {
				poDtl.setCbMaster(cbMaster);
			}
			Double prevQty = new Double(InventoryConstants.PO_STATUS.PO_STATUS_EP_APPROVED.equals(budgetUtilDTO.getPoHdr().getOrderStatus()) ? poDtl.getApprovedQty() : 0);
			Double qty = new Double((RefCodeConstant.ITEM_TYPE_APPL.equals(budgetUtilDTO.getPoHdr().getPurchaseOrderType())
					&& budgetUtilDTO.getPoHdr().getApplOfflineYn().equals(InventoryConstant.N_FLAG_DB))
					? poDtl.getApprovedQty():(isTransactionType || isEPCancel) ? poDtl.getEpApprovedQty():poDtl.getApprovedQty());
			ExternalFacility anExternalFacility = getBudgetADTService().getExternalFacilityByFacilityCode(budgetUtilDTO.getPoHdr().getFacilityCode());
			if (Integer.parseInt(anExternalFacility.getFcICurFinCyc()) > poDtl.getCbMaster().getFinancialYear().intValue()) {
				CBMaster anCBMaster = getPaymentService().getNewCurrentBudgetMaster(poDtl.getCbMaster().getCbMstrSeqno());
				if (null != anCBMaster) {
					poDtl.setCbMaster(anCBMaster);
				}
			}
			if(tnxAmtMap.containsKey(poDtl.getCbMaster())) {
				Double tnxAmt = tnxAmtMap.get(poDtl.getCbMaster());
				tnxAmt =Double.valueOf(decimalFormat.format( tnxAmt + (poDtl.getUnitPrice()*qty)));
				tnxAmtMap.put(poDtl.getCbMaster(), tnxAmt);
				
				Double prevTnxAmt = tnxPrevAmtMap.get(poDtl.getCbMaster());
				prevTnxAmt = prevTnxAmt + (poDtl.getUnitPrice()*prevQty);
				tnxPrevAmtMap.put(poDtl.getCbMaster(), prevTnxAmt);
			} else {
				Double tnxAmt = new Double(0.0);
				//tnxAmt = tnxAmt+(poDtl.getUnitPrice()*qty);
				tnxAmt=Double.valueOf(decimalFormat.format(tnxAmt+(poDtl.getUnitPrice()*qty)));
				tnxAmtMap.put(poDtl.getCbMaster(), tnxAmt);
				
				Double prevTnxAmt = new Double(0.0);
				prevTnxAmt = prevTnxAmt+(poDtl.getUnitPrice()*prevQty);
				tnxPrevAmtMap.put(poDtl.getCbMaster(), prevTnxAmt);
			}
	    }
		
		boolean budgetIsValid = true;
		for(CBMaster cbMaster : tnxAmtMap.keySet()) {
			budgetUtilDTO.setVoteCode(cbMaster.getVoteCode());
	    	budgetUtilDTO.setPtjCode(cbMaster.getPtjCode());
	    	budgetUtilDTO.setFacilityCode(cbMaster.getFacilityCode());
	    	budgetUtilDTO.setBudgetType(cbMaster.getBudgetType());
	    	budgetUtilDTO.setFinancialYear(cbMaster.getFinancialYear());
	    	budgetUtilDTO.setTransactionAmount(tnxAmtMap.get(cbMaster));
	    	budgetUtilDTO.setPrevTransactionAmt(tnxPrevAmtMap.get(cbMaster));
	    	
	    	if(!validateBudget(cbMaster,budgetUtilDTO)) {
	    		budgetIsValid = false;
	    		break;
	    	}
		}
		
		if(budgetIsValid) {
			for(CBMaster cbMaster : tnxAmtMap.keySet()) {
				budgetUtilDTO.setVoteCode(cbMaster.getVoteCode());
				budgetUtilDTO.setCurrentBudgetMaster(cbMaster);
				budgetUtilDTO.setBudgetType(cbMaster.getBudgetType());
				budgetUtilDTO.setPtjCode(cbMaster.getPtjCode());
		    	budgetUtilDTO.setFacilityCode(cbMaster.getFacilityCode());
		    	budgetUtilDTO.setFinancialYear(cbMaster.getFinancialYear());
		    	budgetUtilDTO.setTransactionAmount(tnxAmtMap.get(cbMaster));
		    	budgetUtilDTO.setPrevTransactionAmt(tnxPrevAmtMap.get(cbMaster));

		    	BudgetUtil.budgetMovement(budgetUtilDTO);
			}
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param budgetUtilDTO
	 * @return
	 */
	public static synchronized boolean budgetMovement(BudgetUtilDTO budgetUtilDTO) {
		CBMaster cbMaster = init_CBMaster(budgetUtilDTO);
		BudgetMovement budgetMovement = init_BudgetMovement(cbMaster,budgetUtilDTO);
		return processBudgetMovement(cbMaster, budgetMovement,budgetUtilDTO);
	}

	/**
	 * Check for entry in table CBMaster and initalize
	 * @param budgetUtilDTO
	 * @return
	 */
	private static CBMaster init_CBMaster(BudgetUtilDTO budgetUtilDTO) {
		CBMaster cbMaster = getBudgetADTService().getCBMaster(budgetUtilDTO.getVoteCode(), budgetUtilDTO.getFinancialYear(), budgetUtilDTO.getBudgetType(),budgetUtilDTO.getFacilityCode(),budgetUtilDTO.getPtjCode());
		if(cbMaster == null) {
			cbMaster = new CBMaster();
			cbMaster.setCurrentActualAmount(0.0);
			cbMaster.setCurrentLiabilityAmount(0.0);
			cbMaster.setCurrentPendingAmount(0.0);
			cbMaster.setCurrentUtilizedAmount(0.0);
			cbMaster.setOpeningActualAmount(0.0);
			cbMaster.setOpeningLiabilityAmount(0.0);
			cbMaster.setOpeningPendingAmount(0.0);
			cbMaster.setOpeningUtilizedAmount(0.0);
			cbMaster.setVoteCode(budgetUtilDTO.getVoteCode());
			cbMaster.setFinancialYear(new Integer(budgetUtilDTO.getFinancialYear()));
			cbMaster.setCreatedBy(budgetUtilDTO.getUser().getId());
			cbMaster.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
			cbMaster.setCreatedDate(new Date());
			cbMaster.setBudgetType(budgetUtilDTO.getBudgetType());
			cbMaster.setFacilityCode(budgetUtilDTO.getFacilityCode());
			cbMaster.setPtjCode(budgetUtilDTO.getPtjCode());
		}
		else {
			if(cbMaster.getCurrentLiabilityAmount() == null) cbMaster.setCurrentLiabilityAmount(0.0);
			if(cbMaster.getCurrentActualAmount() == null) cbMaster.setCurrentActualAmount(0.0);
			if(cbMaster.getCurrentPendingAmount() == null) cbMaster.setCurrentPendingAmount(0.0);
			if(cbMaster.getCurrentUtilizedAmount() == null) cbMaster.setCurrentUtilizedAmount(0.0);
			if(cbMaster.getOpeningActualAmount() == null) cbMaster.setOpeningActualAmount(0.0);
			if(cbMaster.getOpeningLiabilityAmount() == null) cbMaster.setOpeningLiabilityAmount(0.0);
			if(cbMaster.getOpeningPendingAmount() == null) cbMaster.setOpeningPendingAmount(0.0);
			if(cbMaster.getOpeningUtilizedAmount() == null) cbMaster.setOpeningUtilizedAmount(0.0);
		}
			
		cbMaster.setUpdatedBy(budgetUtilDTO.getUser().getId());
		cbMaster.setUpdatedDate(new Date());
		
		return cbMaster;
	}
	
	/**
	 * initalize BudgetMovement
	 * @param budgetUtilDTO
	 * @return
	 */
	private static BudgetMovement init_BudgetMovement(CBMaster cbMaster,BudgetUtilDTO budgetUtilDTO) {
		BudgetMovement budgetMovement = new BudgetMovement();
		/*if(budgetMovement.getBudgetMovementSeqno().equals("null")){
			Long seqno=(long) 0;
			budgetMovement.setBudgetMovementSeqno(seqno);	
		}*/
		budgetMovement.setFacilityCode(cbMaster.getFacilityCode());
		budgetMovement.setPtjCode(cbMaster.getPtjCode());
		budgetMovement.setActiveFl(RefCodeConstant.ACTIVE_FLAG_TRUE);
		budgetMovement.setCreatedBy(cbMaster.getCreatedBy());
		budgetMovement.setUpdatedBy(cbMaster.getUpdatedBy());
		budgetMovement.setVoteSeqno(budgetUtilDTO.getVoteCode().getVoteSeqno());
		budgetMovement.setTransactionNumber(budgetUtilDTO.getTransactionNo());
		budgetMovement.setTransactionAmount(budgetUtilDTO.getTransactionAmount());
		budgetMovement.setWarrantType(budgetUtilDTO.getWarrantType());
		budgetMovement.setBudgetType(cbMaster.getBudgetType());
		budgetMovement.setCreatedDate(new Date());
		budgetMovement.setUpdatedDate(new Date());
		budgetMovement.setFinancialYear(cbMaster.getFinancialYear()+"");
		budgetMovement.setCBMaster(cbMaster);
		
		return budgetMovement;
	}
	
	/**
	 * @param cbMaster
	 * @param budgetMovement
	 * @param budgetUtilDTO
	 */
	private static synchronized  boolean processBudgetMovement(CBMaster cbMaster,BudgetMovement budgetMovement,BudgetUtilDTO budgetUtilDTO) {
		Double currentAmount;
		boolean isTransactionType = BudgetMovmentEventTypes.EP_APPROVED.equals(budgetUtilDTO.getTransactionType());
		 cbMaster = getBudgetADTService().getCbMasterBySeqno(cbMaster.getCbMstrSeqno());
		if(budgetUtilDTO.getTransactionType() != null) {
			/**STEP 1 
			 * 
			 * :: Calculation of Amount From BudgetMovementUtil **/
			BudgetMovementUtilDTO budgetMovementUtilDTO = new BudgetMovementUtilDTO();
			budgetMovementUtilDTO.setPendingAmount(cbMaster.getCurrentPendingAmount());
			budgetMovementUtilDTO.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
			budgetMovementUtilDTO.setActualAmount(cbMaster.getCurrentActualAmount());
			budgetMovementUtilDTO.setUtilizedAmount(cbMaster.getCurrentUtilizedAmount());
			budgetMovementUtilDTO.setCreditNoteAmount(budgetUtilDTO.getCreditNoteAmount());
			if(budgetUtilDTO.getPoHdr()!=null && (RefCodeConstant.ITEM_TYPE_APPL.equals(budgetUtilDTO.getPoHdr().getPurchaseOrderType()) 
					&& budgetUtilDTO.getPoHdr().getApplOfflineYn().equals(InventoryConstant.YES)))
			{
			budgetMovementUtilDTO.setTransactionAmount(budgetUtilDTO.getTransactionAmount());
			}
			else
			{
				budgetMovementUtilDTO.setTransactionAmount(isTransactionType && (budgetUtilDTO.getTransactionAmount()
						.doubleValue() > budgetUtilDTO.getPrevTransactionAmt().doubleValue())
								? budgetUtilDTO.getPrevTransactionAmt() : budgetUtilDTO.getTransactionAmount());
			}
			budgetMovementUtilDTO.setPrevTransactionAmount(budgetUtilDTO.getPrevTransactionAmt());
			budgetMovementUtilDTO.setTransactionType(budgetUtilDTO.getTransactionType());
			currentAmount=budgetMovementUtilDTO.getActualAmount();
			my.com.cmg.phis.util.budget.BudgetMovementUtil.budgetMovement(budgetMovementUtilDTO);

			/**STEP 2 
			 * 
			 * :: Population BUDGET MOVEMENT And CBMASTER From BudgetMovementUtil **/
			cbMaster.setCurrentLiabilityAmount(budgetMovementUtilDTO.getLiabilityAmount());
			cbMaster.setCurrentUtilizedAmount(budgetMovementUtilDTO.getUtilizedAmount());
			cbMaster.setCurrentPendingAmount(budgetMovementUtilDTO.getPendingAmount());
			cbMaster.setCurrentActualAmount(budgetMovementUtilDTO.getActualAmount());
			
			budgetMovement.setTransactionType(BudgetMovmentEventTypes.PO_CONTRACT_LP_KK.equals(budgetUtilDTO.getTransactionType()) ? BudgetMovmentEventTypes.EP_APPROVED.getBudgetTnxTypeValue() : budgetMovementUtilDTO.getTransactionType().getBudgetTnxTypeValue());
			budgetMovement.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
			budgetMovement.setUtilisedAmount(cbMaster.getCurrentUtilizedAmount());
			budgetMovement.setPendingAmount(cbMaster.getCurrentPendingAmount());
			budgetMovement.setBalance(cbMaster.getCurrentActualAmount());
			
			/**STEP 3 
			 * 
			 * :: Validate **/
			//if(cbMaster.getCurrentActualAmount().compareTo(BigDecimal.ZERO) < 0 ) {
			if(budgetMovementUtilDTO.getActualAmount().doubleValue()  < 0 ) {
				RefCodesService codesService =  CommonUtil.getService("refCodesService");
				RefCodes refCodes = codesService.getRefCodeByRcValue(RefCodeConstant.BUDGET_TYPE, cbMaster.getBudgetType());
				ExceptionMessage.showMessage(MessageConstant.INSUFFICIENT_BUDGET,cbMaster.getVoteCode().getVoteCode(),cbMaster.getVoteCode().getVoteName(),refCodes.getRcDesc());
				return false;
			}
			
			/**STEP 3 
			 * 
			 * :: Save into Database BUDGET MOVEMENT And CBMASTER **/
			getBudgetADTService().saveOrUpdateCurrentBudgetMaster(cbMaster);
			System.out.println("Data Inserted/Updated In CBMaster Successfully");
			
			getBudgetADTService().saveOrUpdateBudgetMovement(budgetMovement);
			System.out.println("Data Inserted/Updated In BudgetMovement Successfully");
			
			budgetUtilDTO.setCurrentBudgetMaster(cbMaster);
			if(isTransactionType)
			{
				if (budgetUtilDTO.getTransactionAmount().doubleValue() > budgetUtilDTO.getPrevTransactionAmt().doubleValue()) {
					
					budgetUtilDTO.setTransactionType(BudgetMovmentEventTypes.EP_APPROVED_EXC);
					budgetUtilDTO
							.setTransactionAmount(budgetUtilDTO.getTransactionAmount()
									- (budgetUtilDTO.getPrevTransactionAmt()));

					budgetMovementUtilDTO = new BudgetMovementUtilDTO();
					budgetMovementUtilDTO.setPendingAmount(cbMaster.getCurrentPendingAmount());
					budgetMovementUtilDTO.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
					budgetMovementUtilDTO.setActualAmount(cbMaster.getCurrentActualAmount());
					budgetMovementUtilDTO.setUtilizedAmount(cbMaster.getCurrentUtilizedAmount());
					budgetMovementUtilDTO.setCreditNoteAmount(budgetUtilDTO.getCreditNoteAmount());
					budgetMovementUtilDTO.setTransactionType(BudgetMovmentEventTypes.EP_APPROVED_EXC);
					budgetMovementUtilDTO.setTransactionAmount(isTransactionType && (budgetUtilDTO.getTransactionAmount()
									.doubleValue() > budgetUtilDTO.getPrevTransactionAmt().doubleValue())
									? budgetUtilDTO.getPrevTransactionAmt() : budgetUtilDTO.getTransactionAmount());
					budgetMovementUtilDTO.setPrevTransactionAmount(budgetUtilDTO.getPrevTransactionAmt());
					budgetMovementUtilDTO.setTransactionType(budgetUtilDTO.getTransactionType());
					currentAmount=budgetMovementUtilDTO.getActualAmount();
					my.com.cmg.phis.util.budget.BudgetMovementUtil.budgetMovement(budgetMovementUtilDTO);
					
					 cbMaster = init_CBMaster(budgetUtilDTO);
					 budgetMovement = init_BudgetMovement(cbMaster,budgetUtilDTO);
					
					 cbMaster.setCurrentLiabilityAmount(budgetMovementUtilDTO.getLiabilityAmount());
					cbMaster.setCurrentUtilizedAmount(budgetMovementUtilDTO.getUtilizedAmount());
					cbMaster.setCurrentPendingAmount(budgetMovementUtilDTO.getPendingAmount());
					cbMaster.setCurrentActualAmount(budgetMovementUtilDTO.getActualAmount());

					budgetMovement.setTransactionType(budgetMovementUtilDTO.getTransactionType().getBudgetTnxTypeValue());
					budgetMovement.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
					budgetMovement.setUtilisedAmount(cbMaster.getCurrentUtilizedAmount());
					budgetMovement.setPendingAmount(cbMaster.getCurrentPendingAmount());
					budgetMovement.setBalance(cbMaster.getCurrentActualAmount());
					getBudgetADTService().saveOrUpdateCurrentBudgetMaster(cbMaster);
					System.out.println("Data Inserted/Updated In CBMaster Successfully");
					
					getBudgetADTService().saveOrUpdateBudgetMovement(budgetMovement);
					System.out.println("Data Inserted/Updated In BudgetMovement Successfully");
					
	
				}
				else if (Double.valueOf(Two_df.format(budgetMovementUtilDTO.getTransactionAmount().doubleValue())) 
						< budgetMovementUtilDTO.getPrevTransactionAmount().doubleValue()) {
					
					budgetUtilDTO.setTransactionType(BudgetMovmentEventTypes.EP_REJECTED);
					budgetUtilDTO.setTransactionAmount(budgetUtilDTO.getPrevTransactionAmt()
									- (budgetUtilDTO.getTransactionAmount()));

					double transactionAmount = budgetMovementUtilDTO.getPrevTransactionAmount()- budgetMovementUtilDTO.getTransactionAmount();
					budgetMovementUtilDTO = new BudgetMovementUtilDTO();
					budgetMovementUtilDTO.setPendingAmount(cbMaster.getCurrentPendingAmount());
					budgetMovementUtilDTO.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
					budgetMovementUtilDTO.setActualAmount(cbMaster.getCurrentActualAmount());
					budgetMovementUtilDTO.setUtilizedAmount(cbMaster.getCurrentUtilizedAmount());
					budgetMovementUtilDTO.setCreditNoteAmount(budgetUtilDTO.getCreditNoteAmount());
					budgetMovementUtilDTO.setTransactionType(BudgetMovmentEventTypes.EP_REJECTED);
					budgetMovementUtilDTO.setTransactionAmount(transactionAmount);
					budgetMovementUtilDTO.setPrevTransactionAmount(budgetUtilDTO.getPrevTransactionAmt());
					budgetMovementUtilDTO.setTransactionType(budgetUtilDTO.getTransactionType());
					currentAmount=budgetMovementUtilDTO.getActualAmount();
					my.com.cmg.phis.util.budget.BudgetMovementUtil.budgetMovement(budgetMovementUtilDTO);
					
					 cbMaster = init_CBMaster(budgetUtilDTO);
					 budgetMovement = init_BudgetMovement(cbMaster,budgetUtilDTO);
					
					 cbMaster.setCurrentLiabilityAmount(budgetMovementUtilDTO.getLiabilityAmount());
					cbMaster.setCurrentUtilizedAmount(budgetMovementUtilDTO.getUtilizedAmount());
					cbMaster.setCurrentPendingAmount(budgetMovementUtilDTO.getPendingAmount());
					cbMaster.setCurrentActualAmount(budgetMovementUtilDTO.getActualAmount());

					budgetMovement.setTransactionType(budgetMovementUtilDTO.getTransactionType().getBudgetTnxTypeValue());
					budgetMovement.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
					budgetMovement.setUtilisedAmount(cbMaster.getCurrentUtilizedAmount());
					budgetMovement.setPendingAmount(cbMaster.getCurrentPendingAmount());
					budgetMovement.setBalance(cbMaster.getCurrentActualAmount());
					getBudgetADTService().saveOrUpdateCurrentBudgetMaster(cbMaster);
					System.out.println("Data Inserted/Updated In CBMaster Successfully");
					
					getBudgetADTService().saveOrUpdateBudgetMovement(budgetMovement);
					System.out.println("Data Inserted/Updated In BudgetMovement Successfully");
					
					
				}
			}
			
		}
		return true;
	}
	
	/**
	 * @param cbMaster
	 * @param budgetUtilDTO
	 * @return
	 */
	private static boolean validateBudget(CBMaster cbMaster,BudgetUtilDTO budgetUtilDTO) {
		if(budgetUtilDTO.getTransactionType() != null) {
			/**STEP 1 
			 * 
			 * :: Calculation of Amount From BudgetMovementUtil **/
			BudgetMovementUtilDTO budgetMovementUtilDTO = new BudgetMovementUtilDTO();
			budgetMovementUtilDTO.setPendingAmount(cbMaster.getCurrentPendingAmount());
			budgetMovementUtilDTO.setLiabilityAmount(cbMaster.getCurrentLiabilityAmount());
			budgetMovementUtilDTO.setActualAmount(cbMaster.getCurrentActualAmount());
			budgetMovementUtilDTO.setUtilizedAmount(cbMaster.getCurrentUtilizedAmount());
			budgetMovementUtilDTO.setCreditNoteAmount(budgetUtilDTO.getCreditNoteAmount());
			budgetMovementUtilDTO.setTransactionAmount(budgetUtilDTO.getTransactionAmount());
			budgetMovementUtilDTO.setTransactionType(budgetUtilDTO.getTransactionType());
			my.com.cmg.phis.util.budget.BudgetMovementUtil.budgetMovement(budgetMovementUtilDTO);
			
			if(budgetMovementUtilDTO.getActualAmount().doubleValue() < 0 ) {
				RefCodesService codesService =  CommonUtil.getService("refCodesService");
				RefCodes refCodes = codesService.getRefCodeByRcValue(RefCodeConstant.BUDGET_TYPE, cbMaster.getBudgetType());
				ExceptionMessage.showMessage(MessageConstant.INSUFFICIENT_BUDGET,cbMaster.getVoteCode().getVoteCode(),cbMaster.getVoteCode().getVoteName(),refCodes.getRcDesc());
				return false;
			} else 
				return true;
		} else {
			return false;
		}
	}
}
