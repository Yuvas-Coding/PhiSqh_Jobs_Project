package my.com.cmg.iwp.integration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import my.com.cmg.iwp.backend.model.integration.IntegrationLog;
import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;
import my.com.cmg.iwp.backend.model.integration.PNCronInt;
import my.com.cmg.iwp.backend.model.integration.PatientInt;
import my.com.cmg.iwp.backend.model.integration.decorator.NotificationsHdrIntList;
import my.com.cmg.iwp.backend.model.integration.indent.IndentDtlsInt;
import my.com.cmg.iwp.backend.model.integration.indent.IndentHdrsInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueBatchesInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.IssueHdrsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueDtlsInt;
import my.com.cmg.iwp.backend.model.integration.issue.RejectIssueHdrsInt;
import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterDtlsInt;
import my.com.cmg.iwp.backend.model.integration.returns.ReturnInterHdrsInt;
import my.com.cmg.iwp.backend.model.integration.spub.NormalDoseFreqAlternateInt;
import my.com.cmg.iwp.backend.model.integration.spub.NormalDoseFrequencyInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubAllergiesInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubAlternateInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubCorInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubDiagnosisInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubDtlsInt;
import my.com.cmg.iwp.backend.model.integration.spub.SpubHdrsInt;
import my.com.cmg.iwp.backend.model.integration.spub.SuborderTaperStatInt;
import my.com.cmg.iwp.backend.model.integration.tdm.SamplingDetailsInt;
import my.com.cmg.iwp.backend.model.integration.tdm.TdmOrderInt;
import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyHdr;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugAdditionalDoc;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugPatient;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrder;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugRequestOrderV1823;
import my.com.cmg.iwp.backend.model.sdr.SpecialDrugTreatment;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrDoseFrequencyIntService;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrHdrIntService;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrInfusionDrugsIntService;
import my.com.cmg.iwp.backend.service.integration.cdr.CdrNormalDrugsIntService;
import my.com.cmg.iwp.backend.service.integration.indent.IndentIntService;
import my.com.cmg.iwp.backend.service.integration.issue.IssueIntegrationService;
import my.com.cmg.iwp.backend.service.integration.pn.PnNutritionalAssmntIntService;
import my.com.cmg.iwp.backend.service.integration.pn.PnOrderRegimenIntService;
import my.com.cmg.iwp.backend.service.integration.pn.PnOrderTotalEnergyIntService;
import my.com.cmg.iwp.backend.service.integration.returns.ReturnIntegrationService;
import my.com.cmg.iwp.backend.service.integration.spub.NormalDoseFrequencyIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubAllergiesIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubAlternateIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubCorIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubDiagnosisIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubDtlsIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SpubHdrsIntService;
import my.com.cmg.iwp.backend.service.integration.spub.SuborderTaperStatIntService;
import my.com.cmg.iwp.backend.service.integration.tdm.TdmOrderIntService;
import my.com.cmg.iwp.maintenance.model.DistributionFacList;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.NotificationDtl;
import my.com.cmg.iwp.maintenance.model.NotificationFacility;
import my.com.cmg.iwp.maintenance.model.NotificationHdr;
import my.com.cmg.iwp.maintenance.service.DrugService;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.maintenance.service.IntegrationLogService;
import my.com.cmg.iwp.maintenance.service.NotificationAndDisseminateService;
import my.com.cmg.iwp.maintenance.service.OutsourceOrderIntService;
import my.com.cmg.iwp.maintenance.service.PNCronIntService;
import my.com.cmg.iwp.maintenance.service.RefCodesService;
import my.com.cmg.iwp.maintenance.service.SpecialDrugPatientService;
import my.com.cmg.iwp.maintenance.service.SpecialDrugRequestOrderService;
import my.com.cmg.iwp.maintenance.service.SpecialDrugTreatmentService;
import my.com.cmg.iwp.util.RestUtil;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@Controller
public class IntegrationRest {

	@Autowired
	private CdrHdrIntService cdrHdrIntService;

	@Autowired
	private SpecialDrugRequestOrderService specialDrugRequestOrderService;
	
	@Autowired
	private SpecialDrugPatientService specialDrugPatientService;
	
	@Autowired
	private SpecialDrugTreatmentService specialDrugTreatmentService;
	
	@Autowired
	private SpubHdrsIntService spubHdrsIntService;
	
	@Autowired
	private SpubAllergiesIntService spubAllergiesIntService;
	
	@Autowired
	private SpubDtlsIntService spubDtlsIntService;
	
	@Autowired
	private SpubDiagnosisIntService spubDiagnosisIntService;
	
	@Autowired
	
	private IndentIntService indentIntService;
	
	@Autowired
	private CdrInfusionDrugsIntService cdrInfusionDrugsIntService;
	
	@Autowired
	private CdrNormalDrugsIntService cdrNormalDrugsIntService;
	
	@Autowired
	private CdrDoseFrequencyIntService cdrDoseFrequencyIntService;
	
	@Autowired
	private OutsourceOrderIntService outsourceOrderIntService;
	
	@Autowired
	private PnOrderRegimenIntService pnOrderRegimenIntService;
	
	@Autowired
	private PnNutritionalAssmntIntService pnNutritionalAssmntIntService;
	
	@Autowired
	private PnOrderTotalEnergyIntService pnOrderTotalEnergyIntService;
	
	@Autowired
	private IssueIntegrationService issueIntegrationService;
	
	@Autowired
	private TdmOrderIntService tdmOrderIntService;
	
	@Autowired
	private NotificationAndDisseminateService notificationAndDisseminateService;
	
	@Autowired
	private SuborderTaperStatIntService suborderTaperStatIntService;
	
	@Autowired
	private NormalDoseFrequencyIntService normalDoseFrequencyIntService;
	
//	@Autowired
//	private SpubAlternateIntService spubAlternateIntService;
	@Autowired
	private DrugService drugService;
	
	@Autowired
	private IntegrationLogService integrationLogService;
	

	@Autowired
	private SpubCorIntService spubCorIntService;
	

	@Autowired
	private PNCronIntService pnCronIntService;

	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private ExternalFacilityService externalFacilityService;

	@Autowired
	private RefCodesService refCodesService;

	@Autowired
	private ReturnIntegrationService returnIntegrationService;

	@Autowired
	private SpubAlternateIntService spubAlternateIntService;

	@RequestMapping(value = "/sdr/post", method = RequestMethod.POST, headers = "Accept= application/json")
	
	public @ResponseBody SpecialDrugRequestOrderV1823 createSdrHdr(@RequestBody SpecialDrugRequestOrder sdrOrder) {
		sdrOrder.setSendFlag(RefCodeConstant.BOOLEAN_NO);
		SpecialDrugRequestOrder sdr = specialDrugRequestOrderService.findByFacCodeHosReqNo(sdrOrder.getFacCode(),
				sdrOrder.getHosRequestNo());
		if (sdr != null) {
			sdrOrder.setBpfRegisterNo(sdr.getBpfRegisterNo());
			sdrOrder.setStatus(RefCodeConstant.KPK_SENT);
		} else {
			String bpfNo = this.specialDrugRequestOrderService.getBpf(sdrOrder.getRegStatus());
			sdrOrder.setBpfRegisterNo(bpfNo);
			sdrOrder.setStatus(RefCodeConstant.KPK_SENT);
			if (null != sdrOrder.getGenericName() && !StringUtils.isEmpty(sdrOrder.getGenericName())
					&& StringUtils.isEmpty(sdrOrder.getActiveIngredient())) {
				Drug drug = getDrugService().findByDrugCode(sdrOrder.getGenericName().trim());
				sdrOrder.setFullDrugName(drug.getDrugName());
			} else {
				sdrOrder.setFullDrugName(sdrOrder.getActiveIngredient() == null ? ""
						: sdrOrder.getActiveIngredient() + " "
								+ (sdrOrder.getNewDrugStrength() == null ? ""
										: new BigDecimal(sdrOrder.getNewDrugStrength()))
								+ " " + (sdrOrder.getNewDrugUom() == null ? "" : sdrOrder.getNewDrugUom()) + " "
								+ (sdrOrder.getNewDrugDosageForm() == null ? "" : sdrOrder.getNewDrugDosageForm()));
			}
			try {
				this.specialDrugRequestOrderService.saveOrUpdate(sdrOrder);
				for (SpecialDrugPatient sdrPatient : sdrOrder.getSpecialDrugPatients()) {
					sdrPatient.setSpecialDrugRequestOrder(sdrOrder);
					this.specialDrugPatientService.saveOrUpdate(sdrPatient);
					System.out.println("alternative treatment size:" + sdrPatient.getSpecialDrugTreatments().size());
					for (SpecialDrugTreatment specialDrugTreatment : sdrPatient.getSpecialDrugTreatments()) {
						specialDrugTreatment.setSpecialDrugPatient(sdrPatient);
						this.specialDrugTreatmentService.saveOrUpdate(specialDrugTreatment);
					}
				}
				try {
					this.specialDrugRequestOrderService.createSDRTasklist(sdrOrder);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		SpecialDrugRequestOrderV1823 SpecialDrugRequestOrderV1823 = new SpecialDrugRequestOrderV1823();
		SpecialDrugRequestOrderV1823.setBpfRegisterNo(sdrOrder.getBpfRegisterNo());
		return SpecialDrugRequestOrderV1823;
	}

	@RequestMapping(value = "/sdrAddDoc/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createSdrAddDoc(@RequestBody SpecialDrugAdditionalDoc sdrAddDoc) {

		SpecialDrugAdditionalDoc sdrAdditionalDoc = specialDrugRequestOrderService.findByHosReqNoFacCodePtjCode(
				sdrAddDoc.getHosRequestNo(), sdrAddDoc.getFacilityCode(), sdrAddDoc.getPtjCode(),
				sdrAddDoc.getAddDocSeqno());
		if (sdrAdditionalDoc != null) {
			sdrAdditionalDoc.setTitle(sdrAddDoc.getTitle());
			sdrAdditionalDoc.setDescription(sdrAddDoc.getDescription());
			if (sdrAddDoc.getAttachment() != null)
				sdrAdditionalDoc.setAttachment(sdrAddDoc.getAttachment());
			if (sdrAddDoc.getAttachmentName() != null)
				sdrAdditionalDoc.setAttachmentName(sdrAddDoc.getAttachmentName());
			sdrAdditionalDoc.setUpdatedBy(sdrAddDoc.getUpdatedBy());
			sdrAdditionalDoc.setUpdatedDate(sdrAddDoc.getUpdatedDate());
			this.specialDrugRequestOrderService.saveOrUpdate(sdrAdditionalDoc);
		} else {
			SpecialDrugRequestOrder sdr = specialDrugRequestOrderService
					.findByFacCodeHosReqNo(sdrAddDoc.getFacilityCode(), sdrAddDoc.getHosRequestNo());
			sdrAddDoc.setSpecialDrugRequestOrder(sdr);
			this.specialDrugRequestOrderService.saveOrUpdate(sdrAddDoc);
		}

		return 88;
	}
	
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/spub/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createSPUB(@RequestBody SpubHdrsInt spubHdrsInt) {
		System.out.println(".........PHIS WS SPUB POST EXECUTED............");

		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(SpubHdrsInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("spubHdrSeqno");
		}

		primaryKeyValue = spubHdrsInt.getSpubHdrSeqno();

		try {
			if (spubHdrsIntService.isNotExisted(spubHdrsInt.getSpubNo(), spubHdrsInt.getPtjCode(),
					spubHdrsInt.getFacCode())) {
				System.out.println("\n\n==================>spubHdrsIntService: " + this.spubHdrsIntService);
				System.out.println("\n\nspubHdrsInt" + spubHdrsInt.getPatientMrn());
				spubHdrsInt.setSpubHdrSeqno(0);
				spubHdrsInt.setUpdatedDate(new Date());
				this.spubHdrsIntService.saveOrUpdate(spubHdrsInt);

				Set<SpubDtlsInt> spubDtlsInts = spubHdrsInt.getSpubDtlsInts();
				for (SpubDtlsInt spubDtlsInt : spubDtlsInts) {
					spubDtlsInt.setUpdatedDate(new Date());
					this.spubDtlsIntService.saveOrUpdate(spubDtlsInt);
					for (NormalDoseFrequencyInt normalDoseFrequencyInt : spubDtlsInt.getNormalDoseFrequencyInts()) {
						normalDoseFrequencyInt.setSpubDtlsInt(spubDtlsInt);
						normalDoseFrequencyInt.setUpdatedDate(new Date());
						this.normalDoseFrequencyIntService.create(normalDoseFrequencyInt);
					}
					for (SuborderTaperStatInt suborderTaperStatInt : spubDtlsInt.getSuborderTaperStatInts()) {
						suborderTaperStatInt.setSpubDtlsInt(spubDtlsInt);
						suborderTaperStatInt.setUpdatedDate(new Date());
						this.suborderTaperStatIntService.create(suborderTaperStatInt);
					}
				}

				Set<SpubAllergiesInt> spubAllergiesInts = spubHdrsInt.getSpubAllergiesInts();
				for (SpubAllergiesInt spubAllergiesInt : spubAllergiesInts) {
					spubAllergiesInt.setUpdatedDate(new Date());
					this.spubAllergiesIntService.saveOrUpdate(spubAllergiesInt);
				}
				/*
				 * Set<SpubDtlsInt> spubDtlsInts = spubHdrsInt.getSpubDtlsInts(); for
				 * (SpubDtlsInt spubDtlsInt : spubDtlsInts) { spubDtlsInt.setUpdatedDate(new
				 * Date()); this.spubDtlsIntService.saveOrUpdate(spubDtlsInt);
				 * for(NormalDoseFrequencyInt normalDoseFrequencyInt:
				 * spubDtlsInt.getNormalDoseFrequencyInts()){
				 * normalDoseFrequencyInt.setSpubDtlsInt(spubDtlsInt);
				 * normalDoseFrequencyInt.setUpdatedDate(new Date());
				 * this.normalDoseFrequencyIntService.create(normalDoseFrequencyInt); }
				 * for(SuborderTaperStatInt
				 * suborderTaperStatInt:spubDtlsInt.getSuborderTaperStatInts()){
				 * suborderTaperStatInt.setSpubDtlsInt(spubDtlsInt);
				 * suborderTaperStatInt.setUpdatedDate(new Date());
				 * this.suborderTaperStatIntService.create(suborderTaperStatInt); } }
				 */
				Set<SpubDiagnosisInt> spubDiagnosisInts = spubHdrsInt.getSpubDiagnosisInts();
				for (SpubDiagnosisInt spubDiagnosisInt : spubDiagnosisInts) {
					spubDiagnosisInt.setUpdatedDate(new Date());
					this.spubDiagnosisIntService.saveOrUpdate(spubDiagnosisInt);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
//		ExternalFacility externalFacility = externalFacilityService.findByFacilityCode(spubHdrsInt.getReferredFrom());
		ExternalFacility externalFacility = externalFacilityService
				.findBySeqNo(Long.valueOf(spubHdrsInt.getReferredFrom()));
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacility, refCodesService);

		return 88;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/cancelSpub/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody Integer cancelSPUB(@RequestBody final SpubCorInt spubCorInt) {
		System.out.println(".........TIMER SEND TO PHIS :WS CANCEL SPUB POST EXECUTED............");
		System.out.println("\n\n===========>spubHdrsInt.getSpubNo() ::  " + spubCorInt.getSpubNo());

		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(SpubCorInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("spubCorSeqno");
		}

		primaryKeyValue = spubCorInt.getSpubCorSeqno();

		if (!spubCorIntService.isExist(spubCorInt.getSpubNo())) {
			spubCorInt.setSpubCorSeqno(0);
			spubCorIntService.saveOrUpdate(spubCorInt);
		}

		SpubHdrsInt spubHdrsInt = spubHdrsIntService.getSpubBySpubNo(spubCorInt.getSpubNo());
		if (spubHdrsInt != null) {
			spubHdrsInt.setSpubRegistered(RefCodeConstant.SPUB_REGISTERED_CANCEL);
			spubHdrsInt.setUpdatedDate(new Date());
			spubHdrsIntService.saveOrUpdate(spubHdrsInt);
		}

		HttpEntity<SpubCorInt> httpSpubcorIntEntity = new HttpEntity<SpubCorInt>(spubCorInt);
//		insertIntegrationLog(integrationLog, "ACK", RefCodeConstant.RECEIVED_REQUEST, acknowledgement.getPrimaryKeyValues().size(), "", remark, 2,integrationLogService);

		ExternalFacility externalFacilityTo = externalFacilityService.findByFacilityCode(spubCorInt.getReferredTo());
		DistributionFacList distFacBean = externalFacilityTo != null
				? getExternalFacilityService().getDistributionFacListByFacCode(externalFacilityTo.getFacilityCode())
				: null;

		String uri = RestUtil.getUri(refCodesService, externalFacilityTo, RestUtil.SPUB_CANCEL_OR_REGISTER_POST);

		try {
			if (uri != null && RestUtil.ping(externalFacilityTo.getServerIp(), distFacBean)) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseEntity<Integer> httpRequest;
				httpRequest = getRestTemplate().postForEntity(uri, httpSpubcorIntEntity, Integer.class);
//					updateIntegrationLog(integrationLog, RefCodeConstant.SUCCESS, "",remark);

			}
		} catch (Exception e) {

		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
//		ExternalFacility externalFacilityFrom = externalFacilityService.findByFacilityCode(spubHdrsInt.getReferredFrom());
		ExternalFacility externalFacilityFrom = externalFacilityService
				.findBySeqNo(Long.valueOf(spubHdrsInt.getReferredFrom()));
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacilityFrom, refCodesService);
		System.out.println(".........END TO PHIS :WS CANCEL SPUB POST EXECUTED............");
		return 88;
	}

	@RequestMapping(value = "/registerSpub/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody Integer registerSPUB(@RequestBody final SpubCorInt spubCorInt) {
		System.err.println(".........TIMER SEND TO PHIS :WS REGISTER SPUB POST EXECUTED............");
		System.err.println("\n\n===========>spubCorInt.getSpubNo() ::  " + spubCorInt.getSpubNo());

//		SpubCorIntService spubCorIntService  = CommonUtil.getService("spubCorIntService");

		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(SpubCorInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("spubCorSeqno");
		}

		primaryKeyValue = spubCorInt.getSpubCorSeqno();

		if (!spubCorIntService.isExist(spubCorInt.getSpubNo())) {
			spubCorInt.setSpubCorSeqno(0);
			spubCorIntService.saveOrUpdate(spubCorInt);
		}

		SpubHdrsInt spubHdrsInt = spubHdrsIntService.getSpubBySpubNo(spubCorInt.getSpubNo());
		if (spubHdrsInt != null) {
			spubHdrsInt.setSpubRegistered(RefCodeConstant.SPUB_REGISTERED_REGISTERED);
			spubHdrsInt.setUpdatedDate(new Date());
			spubHdrsIntService.saveOrUpdate(spubHdrsInt);
		}

		HttpEntity<SpubCorInt> httpSpubcorIntEntity = new HttpEntity<SpubCorInt>(spubCorInt);
//		insertIntegrationLog(integrationLog, "ACK", RefCodeConstant.RECEIVED_REQUEST, acknowledgement.getPrimaryKeyValues().size(), "", remark, 2,integrationLogService);

		ExternalFacility externalFacilityFrom = externalFacilityService
				.findByFacilityCode(spubCorInt.getReferredFrom());
		DistributionFacList distFacBean = externalFacilityFrom != null
				? getExternalFacilityService().getDistributionFacListByFacCode(externalFacilityFrom.getFacilityCode())
				: null;

		String uri = RestUtil.getUri(refCodesService, externalFacilityFrom, RestUtil.SPUB_CANCEL_OR_REGISTER_POST);
		try {
			if (uri != null && RestUtil.ping(externalFacilityFrom.getServerIp(), distFacBean)) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseEntity<Integer> httpRequest;
				httpRequest = getRestTemplate().postForEntity(uri, httpSpubcorIntEntity, Integer.class);
//					updateIntegrationLog(integrationLog, RefCodeConstant.SUCCESS, "",remark);

			}
		} catch (Exception e) {

		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
//		ExternalFacility externalFacilityFromTo = externalFacilityService.findByFacilityCode(spubHdrsInt.getReferredTo());
		ExternalFacility externalFacilityFromTo = externalFacilityService
				.findBySeqNo(Long.valueOf(spubHdrsInt.getReferredTo()));
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacilityFromTo, refCodesService);

		return 88;
	}

	@RequestMapping(value = "/indent/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createIndent(@RequestBody IndentHdrsInt indentHdrsInt) {
		System.out.println(".........PHIS WS Indent POST EXECUTED............");
		this.indentIntService.saveOrUpdate(indentHdrsInt);
		List<IndentDtlsInt> indentDtlsInts = indentHdrsInt.getIndentDtlsInts();
		for (IndentDtlsInt indentDtlsInt : indentDtlsInts) {
			indentDtlsInt.setIndentHdrsInt(indentHdrsInt);
			this.indentIntService.saveOrUpdate(indentDtlsInt);
		}
		return 0;
	}

	@RequestMapping(value = "/tdm/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createTDM(@RequestBody TdmOrderInt tdmOrderInt) {
		System.out.println(".........PHIS WS TDM POST EXECUTED............");
		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		acknowledgement.setEntityName(TdmOrderInt.class.getSimpleName());
		acknowledgement.setUpdateColumnName("status");
		acknowledgement.setUpdateColumnValue(tdmOrderInt.getTdmOrderNo());
		acknowledgement.setPrimaryKeyColumnName("tdmOrderNo");

		primaryKeyValue = 1l;
		if (tdmOrderIntService.isNotExisted(tdmOrderInt.getTdmOrderNo(), tdmOrderInt.getToPtjCode(),
				tdmOrderInt.getToFacilityCode())) {
			tdmOrderInt.setUpdatedDate(new Date());
			this.tdmOrderIntService.save(tdmOrderInt);
			Set<SamplingDetailsInt> samplingDetailsInts = tdmOrderInt.getSamplingDetailsInts();
			for (SamplingDetailsInt samplingDetailsInt : samplingDetailsInts) {
				samplingDetailsInt.setTdmOrderInt(tdmOrderInt);
				this.tdmOrderIntService.save(samplingDetailsInt);
			}
		} else {
			TdmOrderInt anTdmOrderInt = tdmOrderIntService.getTdmOrderIntByTdmNo(tdmOrderInt.getTdmOrderNo(),
					tdmOrderInt.getFromPtjCode(), tdmOrderInt.getFromFacilityCode());
			if (anTdmOrderInt != null) {
				anTdmOrderInt.setSendFlag(RefCodeConstant.BOOLEAN_YES);
				anTdmOrderInt.setOutsourceStatus(tdmOrderInt.getOutsourceStatus());
				anTdmOrderInt.setUpdatedDate(new Date());
				Set<SamplingDetailsInt> samplingDetailsInts = tdmOrderInt.getSamplingDetailsInts();
				Set<SamplingDetailsInt> oriSamplingDetailInts = anTdmOrderInt.getSamplingDetailsInts();
				for (SamplingDetailsInt samplingDetailInt : samplingDetailsInts) {
					for (SamplingDetailsInt oriSampling : oriSamplingDetailInts) {
						if (samplingDetailInt.getSamplingType().equalsIgnoreCase(oriSampling.getSamplingType())) {
							oriSampling.setRejectedcode(samplingDetailInt.getRejectedcode());
							oriSampling.setRejectedDateTime(samplingDetailInt.getRejectedDateTime());
							this.tdmOrderIntService.saveOrUpdate(oriSampling);
						}
					}

				}

				this.tdmOrderIntService.saveOrUpdate(anTdmOrderInt);
			}
		}
		primaryKeyValues.add(primaryKeyValue);
		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
		ExternalFacility externalFacility = externalFacilityService
				.findByFacilityCode(tdmOrderInt.getFromFacilityCode());
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacility, refCodesService);

		return 0;
	}

	@RequestMapping(value = "/notification/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createDisseminate(@RequestBody NotificationHdr notificationHdr) {
		System.out.println(".........PHIS WS Disseminate POST EXECUTED............");
		NotificationHdr existNotificationHdr = notificationAndDisseminateService.getNotificationHdr(notificationHdr);
		if (existNotificationHdr != null) {
			existNotificationHdr.setStatus(RefCodeConstant.NOTIFICATION_STATUS_WITHDRAW_FOR_MSG);
			this.notificationAndDisseminateService.saveOrUpdate(existNotificationHdr);
			Set<NotificationDtl> notifactionDtls = existNotificationHdr.getNotificationDtls();
			System.out.println("==========>notificationHdr.getNotificationDtls().size():  "
					+ notificationHdr.getNotificationDtls().size());
			for (NotificationDtl notificationDtl : notifactionDtls) {
				notificationDtl.setNotificationHdr(existNotificationHdr);
				this.notificationAndDisseminateService.saveOrUpdate(notificationDtl);
			}
			System.out.println("==========>notificationHdr.getNotificationFacilities().size():  "
					+ notificationHdr.getNotificationFacilities().size());
			for (NotificationFacility notificationFacility : existNotificationHdr.getNotificationFacilities()) {
				notificationFacility.setNotificationHdr(existNotificationHdr);
				notificationFacility.setStatus(RefCodeConstant.RECALL_PRODUCTNOTIFICATION_STATUS_OPEN);
				this.notificationAndDisseminateService.saveOrUpdate(notificationFacility);
			}

		} else {
			this.notificationAndDisseminateService.save(notificationHdr);
			Set<NotificationDtl> notifactionDtls = notificationHdr.getNotificationDtls();
			System.out.println("==========>notificationHdr.getNotificationDtls().size():  "
					+ notificationHdr.getNotificationDtls().size());
			for (NotificationDtl notificationDtl : notifactionDtls) {
				notificationDtl.setNotificationHdr(notificationHdr);
				this.notificationAndDisseminateService.save(notificationDtl);
			}
			System.out.println("==========>notificationHdr.getNotificationFacilities().size():  "
					+ notificationHdr.getNotificationFacilities().size());
			for (NotificationFacility notificationFacility : notificationHdr.getNotificationFacilities()) {
				notificationFacility.setNotificationHdr(notificationHdr);
				notificationFacility.setStatus(RefCodeConstant.RECALL_PRODUCTNOTIFICATION_STATUS_OPEN);
				this.notificationAndDisseminateService.save(notificationFacility);
			}
		}
		return 0;
	}

	@RequestMapping(value = "/pn/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createPN(@RequestBody OutsourceOrderInt outsourceOrderInt) {
		System.out.println(".........PHIS WS PN POST EXECUTED............");
		if (!this.outsourceOrderIntService.isExists(outsourceOrderInt))
			this.outsourceOrderIntService.save(outsourceOrderInt);
		return 0;
	}

	@RequestMapping(value = "/issue/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createIssue(@RequestBody IssueHdrsInt issueHdrsInt) {

		boolean isavailable = getIssueIntegrationService().issueavailable(issueHdrsInt);
		if (!isavailable) {
			getIssueIntegrationService().save(issueHdrsInt);
			Set<IssueDtlsInt> issueDtlsInts = issueHdrsInt.getIssueDtlsInts();
			for (IssueDtlsInt issueDtlsInt : issueDtlsInts) {
				issueDtlsInt.setIssueHdrsInt(issueHdrsInt);
				getIssueIntegrationService().save(issueDtlsInt);
				Set<IssueBatchesInt> issueBatchesInts = issueDtlsInt.getIssueBatchesInts();
				for (IssueBatchesInt issueBatchesInt : issueBatchesInts) {
					issueBatchesInt.setIssueDtlsInt(issueDtlsInt);
					getIssueIntegrationService().save(issueBatchesInt);
				}
			}
		}
		return 0;
	}

	@RequestMapping(value = "/rejectIssue/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createRejectIssue(@RequestBody RejectIssueHdrsInt rejectIssueHdrsInt) {
		getIssueIntegrationService().save(rejectIssueHdrsInt);
		Set<RejectIssueDtlsInt> rejectIssueDtlsInts = rejectIssueHdrsInt.getRejectIssueDtlsInts();
		for (RejectIssueDtlsInt rejectIssueDtlsInt : rejectIssueDtlsInts) {
			rejectIssueDtlsInt.setRejectIssueHdrsInt(rejectIssueHdrsInt);
			getIssueIntegrationService().save(rejectIssueDtlsInt);
		}
		return 0;
	}

	@RequestMapping(value = "/return/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createReturn(@RequestBody ReturnInterHdrsInt returnInterHdrsInt) {
		getReturnIntegrationService().save(returnInterHdrsInt);
		Set<ReturnInterDtlsInt> returnInterDtlsInts = returnInterHdrsInt.getReturnInterDtlInt();
		for (ReturnInterDtlsInt returnInterDtlsInt : returnInterDtlsInts) {
			returnInterDtlsInt.setReturnInterHdrsInt(returnInterHdrsInt);
			getReturnIntegrationService().save(returnInterDtlsInt);

		}
		return 0;
	}

	@RequestMapping(value = "/rp/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createRP(@RequestBody OutsourceOrderInt outsourceOrderInt) {

		outsourceOrderInt.setSendFlag(RefCodeConstant.BOOLEAN_YES);
		if (!this.outsourceOrderIntService.isExists(outsourceOrderInt)) {
			this.outsourceOrderIntService.save(outsourceOrderInt);
		}
		return 0;
	}

	@RequestMapping(value = "/cdr/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createCDR(@RequestBody OutsourceOrderInt outsourceOrderInt) {
		System.out.println("====================> creating CDR running");
		outsourceOrderInt.setSendFlag(RefCodeConstant.BOOLEAN_YES);
		outsourceOrderInt.setOutsourceIntSeqno(new Long(0));
		PatientInt patientInt = outsourceOrderInt.getPatientInt();
		System.out.println("============> rp patientIntId: " + patientInt.getPatientIdno());
		System.out.println("============> rp patientIntIdType: " + patientInt.getPatientIdType());
		if (!this.outsourceOrderIntService.isExists(outsourceOrderInt))
			this.outsourceOrderIntService.save(outsourceOrderInt);
		return 0;
	}

	@RequestMapping(value = "/acknowledgement/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody Integer updateAcknowledgement(@RequestBody final Acknowledgement acknowledgement) {
		System.out.println("Acknowledgement receive from Facility to update");

		Session session = outsourceOrderIntService.getOutsourceOrderIntDAO().getSessionFactory().openSession();
		Transaction txn = null;
		IntegrationLog integrationLog = new IntegrationLog();
		String remark = "";
		if (acknowledgement != null) {
			if (acknowledgement.getPrimaryKeyValues().isEmpty())
				return 88;

			try {
				if (session != null) {
					remark = remark + "Acknowledgement received. For :" + acknowledgement.getEntityName();
					remark = remark.length() > 500 ? remark.substring(0, 499) : remark;
					insertIntegrationLog(integrationLog,
							my.com.cmg.iwp.webui.constant.RefCodeConstant.ACKNOWLEDGEMENT_MODULE,
							my.com.cmg.iwp.webui.constant.RefCodeConstant.RECEIVED_ACKNOWLEDGEMENT,
							acknowledgement.getPrimaryKeyValues().size(), "", remark, 2);
					StringBuilder querySql = new StringBuilder();
					if (acknowledgement.getAdditionalInfo() != null
							&& acknowledgement.getAdditionalInfo().containsKey("ContractNoList")) {
						querySql.append(
								"update T_CONTRACT_FACILITIES set send_flag = 'N', updated_Date = SYSDATE where facility_code = "
										+ " '" + acknowledgement.getAdditionalInfo().get("facilitycode").toString()
										+ "' "
										+ " and hdr_seqno IN (select hdr_seqno from t_contract_hdrs where contract_no in ('' ");
						List<String> contractNoList = (ArrayList<String>) acknowledgement.getAdditionalInfo()
								.get("ContractNoList");
						for (String contractNo : contractNoList) {
							querySql.append(",'" + contractNo + "'");
						}
						querySql.append("))");
						NativeQuery query = session.createSQLQuery(querySql.toString());
						query.executeUpdate();
						updateIntegrationLog(integrationLog, RefCodeConstant.UPDATED_SEND_FLAG_SUCCESS, "", remark);
					} else if (acknowledgement.getAdditionalInfo() != null
							&& acknowledgement.getAdditionalInfo().containsKey("NotificationList")) {
						querySql.append(
								"update T_NOTIFICATION_FACILITY set STATUS = 'NOTIFIED', updated_Date = SYSDATE where to_facility_code = "
										+ " '"
										+ acknowledgement.getAdditionalInfo().get("isFromNotification").toString()
										+ "' "
										+ " and N_HDR_SEQNO IN (select N_HDR_SEQNO from T_NOTIFICATION_HDR where (N_NOTIFICATION_HDR_NO || ':'||FROM_FACILITY_CODE) in ('' ");
						List<String> notifyNoList = (ArrayList<String>) acknowledgement.getAdditionalInfo()
								.get("NotificationList");
						for (String notificationNo : notifyNoList) {
							querySql.append(",'" + notificationNo + "'");
						}
						querySql.append("))");
						Transaction tx = session.beginTransaction();
						NativeQuery query = session.createSQLQuery(querySql.toString());
						query.executeUpdate();
						updateIntegrationLog(integrationLog, RefCodeConstant.UPDATED_SEND_FLAG_SUCCESS, "", remark);
						tx.commit();
					} else {
						querySql.append("update " + acknowledgement.getEntityName());

						if (acknowledgement.getEntityName() != null
								&& (acknowledgement.getEntityName().equals(PenaltyHdr.class.getSimpleName())))
							querySql.append(" set sentToFacility  = :sendFlag ");
						else
							querySql.append(" set " + acknowledgement.getUpdateColumnName() + "  = :sendFlag ");

						if (acknowledgement.getEntityName() != null
								&& (acknowledgement.getEntityName().equals(SpubHdrsInt.class.getSimpleName())
										|| acknowledgement.getEntityName().equals(SpubCorInt.class.getSimpleName()))) {
							querySql.append(" , spubStatus =:spubStatus ");
						}

						querySql.append(" where " + acknowledgement.getPrimaryKeyColumnName() + " in (:seqnos) ");

						if (acknowledgement.getEntityName().equals(NotificationFacility.class.getSimpleName())
								&& acknowledgement.getAdditionalInfo().containsKey("isFromNotification")) {
							querySql.append(" and toFacilityCode =:facilityCode");
						}

						txn = session.beginTransaction();

						org.hibernate.query.Query query = session.createQuery(querySql.toString());

						if (acknowledgement.getEntityName() != null && (acknowledgement.getEntityName()
								.equals(SpecialDrugRequestOrder.class.getSimpleName())))
							query.setParameter("sendFlag", RefCodeConstant.BOOLEAN_NO);
						else
							query.setParameter("sendFlag", acknowledgement.getUpdateColumnValue());
						query.setParameterList("seqnos", acknowledgement.getPrimaryKeyValues());

						if (acknowledgement.getEntityName() != null
								&& (acknowledgement.getEntityName().equals(SpubHdrsInt.class.getSimpleName())
										|| acknowledgement.getEntityName().equals(SpubCorInt.class.getSimpleName()))) {
							query.setParameter("spubStatus", RefCodeConstant.BOOLEAN_TRUE);
						}

						if (acknowledgement.getEntityName().equals(NotificationFacility.class.getSimpleName())
								&& acknowledgement.getAdditionalInfo().containsKey("isFromNotification")) {
							query.setParameter("facilityCode",
									acknowledgement.getAdditionalInfo().get("isFromNotification"));
						}
						if (acknowledgement.getEntityName() != null
								&& (acknowledgement.getEntityName().equals(PenaltyHdr.class.getSimpleName()))) {
							query.setParameter("sendFlag",
									acknowledgement.getUpdateColumnValue().equals("Y") ? RefCodeConstant.BOOLEAN_TRUE
											: RefCodeConstant.BOOLEAN_FALSE);
							query.setParameterList("seqnos", acknowledgement.getPrimaryKeyValues());
						}

						System.err.println("Acknowledgement Query : " + query.toString());

						remark = remark + "Acknowledgement received. Query :" + query.toString();
						remark = remark.length() > 500 ? remark.substring(0, 499) : remark;
						insertIntegrationLog(integrationLog,
								my.com.cmg.iwp.webui.constant.RefCodeConstant.ACKNOWLEDGEMENT_MODULE,
								my.com.cmg.iwp.webui.constant.RefCodeConstant.RECEIVED_ACKNOWLEDGEMENT,
								acknowledgement.getPrimaryKeyValues().size(), "", remark, 2);

						query.executeUpdate();
						txn.commit();
						updateIntegrationLog(integrationLog, RefCodeConstant.UPDATED_SEND_FLAG_SUCCESS, "", remark);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				String errorMsg = e.getMessage().length() > 500 ? e.getMessage().substring(0, 499) : e.getMessage();
				updateIntegrationLog(integrationLog, RefCodeConstant.UPDATED_SEND_FLAG_UNSUCCESS, errorMsg, remark);
			} finally {
				if (session != null) {
					session.close();
				}
			}

		}
		return 88;
	}

	@RequestMapping(value = "/spubNew/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody int createSPUBFromFacility(@RequestBody SpubHdrsInt spubHdrsInt) {
		System.out.println(".........PHIS WS SPUB POST New(With Alternate_int) EXECUTED............");

		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(SpubHdrsInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("spubHdrSeqno");
		}

		primaryKeyValue = spubHdrsInt.getSpubHdrSeqno();

		try {
			if (spubHdrsIntService.isNotExisted(spubHdrsInt.getSpubNo(), spubHdrsInt.getPtjCode(),
					spubHdrsInt.getFacCode())) {
				System.out.println("\n\n==================>spubHdrsIntService: " + this.spubHdrsIntService);
				System.out.println("\n\nspubHdrsInt" + spubHdrsInt.getPatientMrn());
				spubHdrsInt.setSpubHdrSeqno(0);
				spubHdrsInt.setUpdatedDate(new Date());
				this.spubHdrsIntService.saveOrUpdate(spubHdrsInt);

				Set<SpubDtlsInt> spubDtlsInts = spubHdrsInt.getSpubDtlsInts();
				for (SpubDtlsInt spubDtlsInt : spubDtlsInts) {
					spubDtlsInt.setUpdatedDate(new Date());
					this.spubDtlsIntService.saveOrUpdate(spubDtlsInt);
					for (NormalDoseFrequencyInt normalDoseFrequencyInt : spubDtlsInt.getNormalDoseFrequencyInts()) {
						normalDoseFrequencyInt.setSpubDtlsInt(spubDtlsInt);
						normalDoseFrequencyInt.setUpdatedDate(new Date());
						this.normalDoseFrequencyIntService.create(normalDoseFrequencyInt);
					}
					for (SuborderTaperStatInt suborderTaperStatInt : spubDtlsInt.getSuborderTaperStatInts()) {
						suborderTaperStatInt.setSpubDtlsInt(spubDtlsInt);
						suborderTaperStatInt.setUpdatedDate(new Date());
						this.suborderTaperStatIntService.create(suborderTaperStatInt);
					}
					if (null != spubDtlsInt.getSpubAlternateInts() || spubDtlsInt.getSpubAlternateInts().size() > 0) {
						Set<SpubAlternateInt> spubAlternateInts = spubDtlsInt.getSpubAlternateInts();
						for (SpubAlternateInt spubAlternateInt : spubAlternateInts) {
							spubAlternateInt.setSpubDtlsInt(spubDtlsInt);
							spubAlternateInt.setUpdatedDate(new Date());
							this.spubAlternateIntService.saveOrUpdate(spubAlternateInt);

							for (NormalDoseFreqAlternateInt normalDoseFrequencyInt : spubAlternateInt
									.getNormalDoseFreqAlternateInts()) {
								normalDoseFrequencyInt.setSpubAlternateInt(spubAlternateInt);
								normalDoseFrequencyInt.setUpdatedDate(new Date());
								this.normalDoseFrequencyIntService.create(normalDoseFrequencyInt);
							}
						}
					}
				}

				Set<SpubAllergiesInt> spubAllergiesInts = spubHdrsInt.getSpubAllergiesInts();
				for (SpubAllergiesInt spubAllergiesInt : spubAllergiesInts) {
					spubAllergiesInt.setUpdatedDate(new Date());
					this.spubAllergiesIntService.saveOrUpdate(spubAllergiesInt);
				}
				Set<SpubDiagnosisInt> spubDiagnosisInts = spubHdrsInt.getSpubDiagnosisInts();
				for (SpubDiagnosisInt spubDiagnosisInt : spubDiagnosisInts) {
					spubDiagnosisInt.setUpdatedDate(new Date());
					this.spubDiagnosisIntService.saveOrUpdate(spubDiagnosisInt);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
		ExternalFacility externalFacility = externalFacilityService
				.findBySeqNo(Long.valueOf(spubHdrsInt.getReferredFrom()));
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacility, refCodesService);

		return 88;
	}

	public void updateIntegrationLog(IntegrationLog integrationLog, String status, String errorMsg, String remarks) {
		integrationLog.setStatus(status);
		integrationLog.setErrorMsg(errorMsg);
//		integrationLog.setRemarks(remarks);
		integrationLog.setEndDate(new Date());
		getIntegrationLogService().saveOrUpdate(integrationLog);
	}

	public void insertIntegrationLog(IntegrationLog integrationLog, String moduleCode, String status, int recordCount,
			String errorMsg, String remarks, int createdBy) {
		integrationLog.setModuleCode(moduleCode);
		integrationLog.setStatus(status);
		integrationLog.setStartDate(new Date());
		integrationLog.setRecordCount(recordCount);
		integrationLog.setErrorMsg(errorMsg);
		integrationLog.setRemarks(remarks);
		integrationLog.setCreatedBy(createdBy);
		integrationLog.setCreatedDate(new Date());
		getIntegrationLogService().saveOrUpdate(integrationLog);
	}

	@RequestMapping(value = "/registerPNOutsource/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody Integer registerPNOutsource(@RequestBody final PNCronInt pnCronInt) {
		System.err.println(".........TIMER SEND TO PHIS :WS REGISTER PN OUTSOURCE POST EXECUTED............");
		System.err.println("\n\n===========pnCronInt.getSourceOutsourceNo() ::  " + pnCronInt.getSourceOutsourceNo());
		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(PNCronInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("pnCorSeqno");
		}

		primaryKeyValue = pnCronInt.getPnCorSeqno();

		if (!pnCronIntService.isExist(pnCronInt.getSourceOutsourceNo())) {
			pnCronInt.setPnCorSeqno(0);
			;
			pnCronIntService.saveOrUpdate(pnCronInt);
		}

		OutsourceOrderInt outsourceOrderInt = outsourceOrderIntService
				.findBySourceOutsourceNo(pnCronInt.getSourceOutsourceNo());
		if (outsourceOrderInt != null) {
			outsourceOrderInt.setIsProcessed(RefCodeConstant.PN_OUTSOURCE_REGISTERED.toString());
			outsourceOrderInt.setUpdatedDate(new Date());
			outsourceOrderIntService.saveOrUpdate(outsourceOrderInt);
		}

		HttpEntity<PNCronInt> httpSpubcorIntEntity = new HttpEntity<PNCronInt>(pnCronInt);
		ExternalFacility externalFacilityFrom = externalFacilityService.findByFacilityCode(pnCronInt.getReferredFrom());
		DistributionFacList distFacBean = externalFacilityFrom != null
				? getExternalFacilityService().getDistributionFacListByFacCode(externalFacilityFrom.getFacilityCode())
				: null;

		String uri = RestUtil.getUri(refCodesService, externalFacilityFrom,
				RestUtil.PN_ORDEROUTSOURCE_REGISTER_FROM_IWP_POST);
		// uri ="http://localhost:8080/iphis26/rest/PNOutsourceRegister/post";
		try {
			if (uri != null && RestUtil.ping(externalFacilityFrom.getServerIp(), distFacBean)) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseEntity<Integer> httpRequest;
				httpRequest = getRestTemplate().postForEntity(uri, httpSpubcorIntEntity, Integer.class);
			}
		} catch (Exception e) {

		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
		ExternalFacility externalFacilityFromTo = externalFacilityService.findByFacilityCode(pnCronInt.getReferredTo());
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacilityFromTo, refCodesService);

		return 88;
	}

	@RequestMapping(value = "/cancelPNOutsource/post", method = RequestMethod.POST, headers = "Accept= application/json")
	public @ResponseBody Integer cancelPNOutsource(@RequestBody final PNCronInt pnCronInt) {
		System.out.println(".........TIMER SEND TO PHIS :WS CANCEL PNOutsource POST EXECUTED............");
		System.out.println("\n\n===========>pnCronInt.getSourceOutsourceNo() ::  " + pnCronInt.getSourceOutsourceNo());

		Acknowledgement acknowledgement = new Acknowledgement();
		List<Long> primaryKeyValues = new ArrayList<Long>();
		Long primaryKeyValue = null;

		if (acknowledgement.getEntityName() == null) {
			acknowledgement.setEntityName(PNCronInt.class.getSimpleName());
			acknowledgement.setUpdateColumnName("sendFlag");
			acknowledgement.setUpdateColumnValue(RefCodeConstant.BOOLEAN_NO);
			acknowledgement.setPrimaryKeyColumnName("pnCorSeqno");
		}

		primaryKeyValue = pnCronInt.getPnCorSeqno();

		if (!pnCronIntService.isExist(pnCronInt.getSourceOutsourceNo())) {
			pnCronInt.setPnCorSeqno(0);
			;
			pnCronIntService.saveOrUpdate(pnCronInt);
		}

		OutsourceOrderInt outsourceOrderInt = outsourceOrderIntService
				.findBySourceOutsourceNo(pnCronInt.getSourceOutsourceNo());
		if (outsourceOrderInt != null) {
			outsourceOrderInt.setIsProcessed(RefCodeConstant.SPUB_REGISTERED_CANCEL.toString());
			outsourceOrderInt.setUpdatedDate(new Date());
			outsourceOrderIntService.saveOrUpdate(outsourceOrderInt);
		}

		HttpEntity<PNCronInt> httpSpubcorIntEntity = new HttpEntity<PNCronInt>(pnCronInt);
		ExternalFacility externalFacilityTo = externalFacilityService.findByFacilityCode(pnCronInt.getReferredTo());
		DistributionFacList distFacBean = externalFacilityTo != null
				? getExternalFacilityService().getDistributionFacListByFacCode(externalFacilityTo.getFacilityCode())
				: null;

		String uri = RestUtil.getUri(refCodesService, externalFacilityTo,
				RestUtil.PN_ORDEROUTSOURCE_CANCEL_FROM_IWP_POST);
		// uri ="http://localhost:8081/iphis26/rest/PNOutsourceCancel/post";

		try {
			if (uri != null && RestUtil.ping(externalFacilityTo.getServerIp(), distFacBean)) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseEntity<Integer> httpRequest;
				httpRequest = getRestTemplate().postForEntity(uri, httpSpubcorIntEntity, Integer.class);

			}
		} catch (Exception e) {

		}

		primaryKeyValues.add(primaryKeyValue);

		acknowledgement.setPrimaryKeyValues(primaryKeyValues);
		ExternalFacility externalFacilityFrom = externalFacilityService.findByFacilityCode(pnCronInt.getReferredFrom());
		RestUtil.submit(acknowledgement, integrationLogService, restTemplate, externalFacilityFrom, refCodesService);
		System.out.println(".........END TO PHIS :WS CANCEL PN OUTSOURCE POST EXECUTED............");
		return 88;
	}

	@RequestMapping(value = "/notification/{FacilityID}/{NotificationNo}/{ToFacility}", method = RequestMethod.GET, headers = "Accept= application/json")
	public @ResponseBody NotificationsHdrIntList getNotificationByNotification(
			@PathVariable("FacilityID") String fromFacilityId, @PathVariable("NotificationNo") String notificationNo,
			@PathVariable("ToFacility") String toFacilityCode) {
		System.err.println("TEST NOT : " + fromFacilityId + " " + notificationNo + " " + toFacilityCode);
		List<NotificationHdr> notificationHdrs = notificationAndDisseminateService
				.getNotitficationByHQNotitficationNumber(notificationNo, fromFacilityId, toFacilityCode);

		System.out.println("====================>notificationFacilities.size():  " + notificationHdrs.size());
		NotificationsHdrIntList notificationsHdrIntList = new NotificationsHdrIntList();
		for (NotificationHdr anNotificationHdr : notificationHdrs) {
			Set<NotificationFacility> notificationFacilities = new HashSet<NotificationFacility>();
			Set<NotificationDtl> notificationDtls = new HashSet<NotificationDtl>();
			anNotificationHdr.setNotificationFacilities(notificationFacilities);
			anNotificationHdr.setNotificationDtls(notificationDtls);
			notificationsHdrIntList.getNotificationHdrInts().add(anNotificationHdr);
		}
		return notificationsHdrIntList;
	}

	public CdrHdrIntService getCdrHdrIntService() {
		return this.cdrHdrIntService;
	}

	public void setCdrHdrIntService(CdrHdrIntService cdrHdrIntService) {
		this.cdrHdrIntService = cdrHdrIntService;
	}

	public SpecialDrugRequestOrderService getSpecialDrugRequestOrderService() {
		return this.specialDrugRequestOrderService;
	}

	public void setSpecialDrugRequestOrderService(SpecialDrugRequestOrderService specialDrugRequestOrderService) {
		this.specialDrugRequestOrderService = specialDrugRequestOrderService;
	}

	public SpecialDrugPatientService getSpecialDrugPatientService() {
		return this.specialDrugPatientService;
	}

	public void setSpecialDrugPatientService(SpecialDrugPatientService specialDrugPatientService) {
		this.specialDrugPatientService = specialDrugPatientService;
	}

	public SpecialDrugTreatmentService getSpecialDrugTreatmentService() {
		return this.specialDrugTreatmentService;
	}

	public void setSpecialDrugTreatmentService(SpecialDrugTreatmentService specialDrugTreatmentService) {
		this.specialDrugTreatmentService = specialDrugTreatmentService;
	}

	public SpubHdrsIntService getSpubHdrsIntService() {
		return this.spubHdrsIntService;
	}

	public void setSpubHdrsIntService(SpubHdrsIntService spubHdrsIntService) {
		this.spubHdrsIntService = spubHdrsIntService;
	}

	public SpubAllergiesIntService getSpubAllergiesIntService() {
		return this.spubAllergiesIntService;
	}

	public void setSpubAllergiesIntService(SpubAllergiesIntService spubAllergiesIntService) {
		this.spubAllergiesIntService = spubAllergiesIntService;
	}

	public SpubDtlsIntService getSpubDtlsIntService() {
		return this.spubDtlsIntService;
	}

	public void setSpubDtlsIntService(SpubDtlsIntService spubDtlsIntService) {
		this.spubDtlsIntService = spubDtlsIntService;
	}

	public SpubDiagnosisIntService getSpubDiagnosisIntService() {
		return this.spubDiagnosisIntService;
	}

	public void setSpubDiagnosisIntService(SpubDiagnosisIntService spubDiagnosisIntService) {
		this.spubDiagnosisIntService = spubDiagnosisIntService;
	}

	public IndentIntService getIndentIntService() {
		return this.indentIntService;
	}

	public void setIndentIntService(IndentIntService indentIntService) {
		this.indentIntService = indentIntService;
	}

	public CdrInfusionDrugsIntService getCdrInfusionDrugsIntService() {
		return this.cdrInfusionDrugsIntService;
	}

	public void setCdrInfusionDrugsIntService(CdrInfusionDrugsIntService cdrInfusionDrugsIntService) {
		this.cdrInfusionDrugsIntService = cdrInfusionDrugsIntService;
	}

	public CdrNormalDrugsIntService getCdrNormalDrugsIntService() {
		return this.cdrNormalDrugsIntService;
	}

	public void setCdrNormalDrugsIntService(CdrNormalDrugsIntService cdrNormalDrugsIntService) {
		this.cdrNormalDrugsIntService = cdrNormalDrugsIntService;
	}

	public CdrDoseFrequencyIntService getCdrDoseFrequencyIntService() {
		return this.cdrDoseFrequencyIntService;
	}

	public void setCdrDoseFrequencyIntService(CdrDoseFrequencyIntService cdrDoseFrequencyIntService) {
		this.cdrDoseFrequencyIntService = cdrDoseFrequencyIntService;
	}

	public OutsourceOrderIntService getOutsourceOrderIntService() {
		return this.outsourceOrderIntService;
	}

	public void setOutsourceOrderIntService(OutsourceOrderIntService outsourceOrderIntService) {
		this.outsourceOrderIntService = outsourceOrderIntService;
	}

	public PnOrderRegimenIntService getPnOrderRegimenIntService() {
		return this.pnOrderRegimenIntService;
	}

	public void setPnOrderRegimenIntService(PnOrderRegimenIntService pnOrderRegimenIntService) {
		this.pnOrderRegimenIntService = pnOrderRegimenIntService;
	}

	public PnNutritionalAssmntIntService getPnNutritionalAssmntIntService() {
		return this.pnNutritionalAssmntIntService;
	}

	public void setPnNutritionalAssmntIntService(PnNutritionalAssmntIntService pnNutritionalAssmntIntService) {
		this.pnNutritionalAssmntIntService = pnNutritionalAssmntIntService;
	}

	public PnOrderTotalEnergyIntService getPnOrderTotalEnergyIntService() {
		return this.pnOrderTotalEnergyIntService;
	}

	public void setPnOrderTotalEnergyIntService(PnOrderTotalEnergyIntService pnOrderTotalEnergyIntService) {
		this.pnOrderTotalEnergyIntService = pnOrderTotalEnergyIntService;
	}

	public IssueIntegrationService getIssueIntegrationService() {
		return this.issueIntegrationService;
	}

	public void setIssueIntegrationService(IssueIntegrationService issueIntegrationService) {
		this.issueIntegrationService = issueIntegrationService;
	}

	public TdmOrderIntService getTdmOrderIntService() {
		return this.tdmOrderIntService;
	}

	public void setTdmOrderIntService(TdmOrderIntService tdmOrderIntService) {
		this.tdmOrderIntService = tdmOrderIntService;
	}

	public NotificationAndDisseminateService getNotificationAndDisseminateService() {
		return this.notificationAndDisseminateService;
	}

	public void setNotificationAndDisseminateService(
			NotificationAndDisseminateService notificationAndDisseminateService) {
		this.notificationAndDisseminateService = notificationAndDisseminateService;
	}

	public SuborderTaperStatIntService getSuborderTaperStatIntService() {
		return suborderTaperStatIntService;
	}

	public void setSuborderTaperStatIntService(SuborderTaperStatIntService suborderTaperStatIntService) {
		this.suborderTaperStatIntService = suborderTaperStatIntService;
	}

	public NormalDoseFrequencyIntService getNormalDoseFrequencyIntService() {
		return normalDoseFrequencyIntService;
	}

	public void setNormalDoseFrequencyIntService(NormalDoseFrequencyIntService normalDoseFrequencyIntService) {
		this.normalDoseFrequencyIntService = normalDoseFrequencyIntService;
	}

	public DrugService getDrugService() {
		return drugService;
	}

	public void setDrugService(DrugService drugService) {
		this.drugService = drugService;
	}

	public IntegrationLogService getIntegrationLogService() {
		return integrationLogService;
	}

	public void setIntegrationLogService(IntegrationLogService integrationLogService) {
		this.integrationLogService = integrationLogService;
	}

	public SpubCorIntService getSpubCorIntService() {
		return spubCorIntService;
	}

	public void setSpubCorIntService(SpubCorIntService spubCorIntService) {
		this.spubCorIntService = spubCorIntService;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ExternalFacilityService getExternalFacilityService() {
		return externalFacilityService;
	}

	public void setExternalFacilityService(ExternalFacilityService externalFacilityService) {
		this.externalFacilityService = externalFacilityService;
	}

	public RefCodesService getRefCodesService() {
		return refCodesService;
	}

	public void setRefCodesService(RefCodesService refCodesService) {
		this.refCodesService = refCodesService;
	}

	public ReturnIntegrationService getReturnIntegrationService() {
		return returnIntegrationService;
	}

	public void setReturnIntegrationService(ReturnIntegrationService returnIntegrationService) {
		this.returnIntegrationService = returnIntegrationService;
	}

	public SpubAlternateIntService getSpubAlternateIntService() {
		return spubAlternateIntService;
	}

	public void setSpubAlternateIntService(SpubAlternateIntService spubAlternateIntService) {
		this.spubAlternateIntService = spubAlternateIntService;
	}

	public PNCronIntService getPnCronIntService() {
		return pnCronIntService;
	}

	public void setPnCronIntService(PNCronIntService pnCronIntService) {
		this.pnCronIntService = pnCronIntService;
	}

}
