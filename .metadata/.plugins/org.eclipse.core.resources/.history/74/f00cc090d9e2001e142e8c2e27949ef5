package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.ContractHQDAOImpl;
import my.com.cmg.iwp.maintenance.model.Brand;
import my.com.cmg.iwp.maintenance.model.ContractDtl;
import my.com.cmg.iwp.maintenance.model.ContractFacility;
import my.com.cmg.iwp.maintenance.model.ContractHdr;
import my.com.cmg.iwp.maintenance.model.ContractItemQty;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.ExternalFacility;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.ItemSubgroup;
import my.com.cmg.iwp.maintenance.model.NonDrug;
import my.com.cmg.iwp.maintenance.model.RefCodes;
import my.com.cmg.iwp.maintenance.model.SecUser;
import my.com.cmg.iwp.maintenance.model.Supplier;
import my.com.cmg.iwp.maintenance.service.ContractHQService;
import my.com.cmg.iwp.maintenance.service.ExternalFacilityService;
import my.com.cmg.iwp.webui.budget.InventoryConstant;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
import my.com.cmg.iwp.webui.contractHQ.ContractHQConstant;
import my.com.cmg.iwp.webui.util.CommonUtil;


@Service
public class ContractHQServiceImpl implements ContractHQService {

	private ContractHQDAOImpl contractHqDAO;

	public ContractHQDAOImpl getContractHqDAO() {
		return this.contractHqDAO;
	}

	public void setContractHqDAO(final ContractHQDAOImpl contractHqDAO) {
		this.contractHqDAO = contractHqDAO;
	}

	@Override
	public void saveOrUpdateContractHQ(final ContractHdr contractHdr) {
		this.contractHqDAO.saveOrUpdate(contractHdr);
	}

	@Override
	public List<Item> getItemDetails(final String type, final String itemGroup, final Drug drug,
			final NonDrug nonDrug) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Item.class);
		detachedCriteria.add(Restrictions.eq("activeFlag",'A'));

		/*
		 * detachedCriteria.add(Restrictions.ilike("itemType", type)); if(null
		 * != itemGroup &&
		 * itemGroup.equalsIgnoreCase(InventoryConstant.DRUG_DB_VALUE)) {
		 * detachedCriteria.add(Restrictions.eq("drug", drug)); } else if(null
		 * != itemGroup &&
		 * itemGroup.equalsIgnoreCase(InventoryConstant.NON_DRUG_DB_VALUE)) {
		 * detachedCriteria.add(Restrictions.eq("nonDrug", nonDrug)); }
		 * detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 */
		List<Item> asd = this.contractHqDAO.findByCriteria(detachedCriteria);
		return asd;
	}

	@Override
	public Item getItem(final Item item) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Item.class);
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.add(Restrictions.eq("itemSeqno", item.getItemSeqno()));
		detachedCriteria.setFetchMode("pkuUom", FetchMode.JOIN);
		detachedCriteria.setFetchMode("itemBrands", FetchMode.JOIN);
		detachedCriteria.setFetchMode("itemBrands.brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		List<Item> itemList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != itemList && itemList.size() > 0)
		{
			return itemList.iterator().next();
		}
		return null;
	}

	@Override
	public List<Item> getItemDetailsByCriteria(final String itemGroup, final Drug drug,
			final NonDrug nonDrug, final String itemCode, final String itemDesc, final String type) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Item.class);
		if (null != itemGroup && !itemGroup.isEmpty()
				&& !itemGroup.equalsIgnoreCase(ContractHQConstant.ALL_DB_VALUE)) {
			detachedCriteria.add(Restrictions.eq("itemGroup", itemGroup));
		}
		if (null != drug) {
			detachedCriteria.createAlias("drug", "drug");
			detachedCriteria.add(Restrictions.eq("drug.drugSeqno",
					drug.getDrugSeqno()));
			detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		} else if (null != nonDrug) {
			detachedCriteria.createAlias("nonDrug", "nonDrug");
			detachedCriteria.add(Restrictions.eq("nonDrug.nondrugSeqno",
					nonDrug.getNondrugSeqno()));
			detachedCriteria.setFetchMode("nonDrug", FetchMode.JOIN);
		}
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));

		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		if (itemCode != null && !itemCode.equalsIgnoreCase("")) {
			detachedCriteria.add(Restrictions.ilike("itemCode", "%" + itemCode
					+ "%"));

		}

		if (itemDesc != null && !itemDesc.equalsIgnoreCase("")) {
			detachedCriteria.add(Restrictions.ilike("itemDesc", "%" + itemDesc
					+ "%"));

		}

		if (type != null && !type.equalsIgnoreCase("")) {
			detachedCriteria.add(Restrictions.ilike("itemType", type));
		}

		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractHdr> getHQContractHdrList(final String itemCode,
			final ContractHdr hdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractHdr.class);
		if (!itemCode.isEmpty()
				|| null != hdr.getItemGroup() && !hdr.getItemGroup().isEmpty()) {
			DetachedCriteria dtlCriteria = detachedCriteria
					.createCriteria("hqContractDtlses");
			dtlCriteria
			.add(Restrictions.eq("activeFlag", 'A'));
			DetachedCriteria dtlCriteriaItem = dtlCriteria
					.createCriteria("item");
			if (!itemCode.isEmpty()) {
				dtlCriteriaItem.add(Restrictions.ilike("itemCode", itemCode));
			}
			if (null != hdr.getItemGroup() && !hdr.getItemGroup().isEmpty()) {
				dtlCriteriaItem.add(Restrictions.ilike("itemGroup",
						hdr.getItemGroup()));
			}
		}
		if (hdr.getContractNo() != null && hdr.getContractNo() != "") {
			detachedCriteria.add(Restrictions.ilike("contractNo",
					hdr.getContractNo()));
		}
		if (hdr.getContractStatus() != null && hdr.getContractStatus() != "") {
			if (!hdr.getContractStatus().equalsIgnoreCase(
					InventoryConstant.CONTRACT_HQ_STATUS_ALL)) {
				detachedCriteria.add(Restrictions.ilike("contractStatus",
						hdr.getContractStatus()));
			}
		}
		detachedCriteria.setFetchMode("hqContractDtlses", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.manufacturer",
				FetchMode.JOIN);
		// detachedCriteria.setFetchMode("phHqContractDtlses.phSuppliers",
		// FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.supplier",
				FetchMode.JOIN);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.addOrder(Order.desc("createDate"));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractHdr> getContractHQHdr(final ContractHdr hqContractHdrs) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractHdr.class);
		detachedCriteria.setFetchMode("hqContractDtlses", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.manufacturer", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.item", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.item.drug", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.item.nonDrug", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.item.drug.itemSubgroup", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.item.nonDrug.itemSubgroup", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.brand", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.supplier", FetchMode.JOIN);
		//		detachedCriteria.setFetchMode("hqContractDtlses.countryCode", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractFacilities", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractFacilities.externalFacility", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractItemQty", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDeliveryPeriod", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractPenaltyDtl", FetchMode.JOIN);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("hqHdrSeqno", hqContractHdrs.getHqHdrSeqno()));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ItemSubgroup> getDrugSubGroup() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("itmGroupCode",
				InventoryConstant.DRUG_DB_VALUE));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		return this.contractHqDAO.findByCriteria(detachedCriteria);

	}

	@Override
	public List<ItemSubgroup> getNonDrugSubGroup() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("itmGroupCode",
				InventoryConstant.NON_DRUG_DB_VALUE));
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<RefCodes> getContractStatus(final String contractHqStatus,
			final String contractStatus) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(RefCodes.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("rcDomain", contractHqStatus));
		detachedCriteria.add(Restrictions.eq("rcValue", contractStatus));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public void saveOrupdate(final ContractDtl hqContractDtl) {
		this.contractHqDAO.saveOrUpdate(hqContractDtl);
	}

	@Override
	public List<ContractDtl> getContractDtlfordelete(final Long seqno) {
		String query = "select all contractdtl from ContractDtl contractdtl"
				+ " join fetch contractdtl.item as item"
				+ " where contractdtl.hqDtlSeqno=" + seqno;
		return this.contractHqDAO.find(query);
	}

	@Override
	public List<ContractHdr> getContractHdrListByDrugCode(final String drugCode) {
		String query = "select all hqConHdr from ContractHdr hqConHdr"
				+ " join fetch hqConHdr.hqContractDtlses as hqConDtl"
				+ " join fetch hqConDtl.brand as brand"
				+ " join fetch hqConDtl.supplier as supplier"
				+ " join fetch hqConDtl.item as item"
				+ " join fetch item.drug as drug" + " where drug.drugCode="
				+ "'" + drugCode + "'";
		return this.contractHqDAO.find(query);
	}

	@Override
	public List<ContractHdr> getContractHdrListByDrugName(final String drugName) {
		String query = "select all hqConHdr from ContractHdr hqConHdr"
				+ " join fetch hqConHdr.hqContractDtlses as hqConDtl"
				+ " join fetch hqConDtl.brand as brand"
				+ " join fetch hqConDtl.supplier as supplier"
				+ " join fetch hqConDtl.item as item"
				+ " join fetch item.drug as drug" + " where drug.drugName="
				+ "'" + drugName + "'";
		return this.contractHqDAO.find(query);
	}

	@Override
	public List<ContractHdr> getContractHdrListwithDrugDetails(final Long seqno) {
		String query = "select all hqConHdr from ContractHdr hqConHdr"
				+ " join fetch hqConHdr.hqContractDtlses as hqConDtl"
				+ " join fetch hqConDtl.brand as brand"
				+ " join fetch hqConDtl.supplier as supplier"
				+ " join fetch hqConDtl.item as item"
				+ " join fetch item.drug as drug"
				+ " where hqConHdr.hqHdrSeqno=" + seqno;
		return this.contractHqDAO.find(query);
	}

	@Override
	public List<ContractHdr> findRecords(final String kkmContract, final String supplierName, final String status, Drug drug, NonDrug nondrug, Date StartDate, Date EndDate) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractHdr.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("hqContractDtlses", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.supplier",FetchMode.JOIN);
		DetachedCriteria detachedCriteriaDtls = detachedCriteria.createCriteria("hqContractDtlses");
		detachedCriteria.add(Restrictions.eq("activeFlag",'A'));
		DetachedCriteria detachedCriteriaItem = detachedCriteriaDtls.createCriteria("item");
		if (!kkmContract.isEmpty()) {
			detachedCriteria.add(Restrictions.eq("contractNo", kkmContract));
		}
		if (!status.isEmpty()  && !status.equalsIgnoreCase("ALL")) {

			detachedCriteria.add(Restrictions.eq("contractStatus",status.trim()));
		}
		if (!supplierName.isEmpty()) {
			DetachedCriteria detachedCriteriaSupplier = detachedCriteriaDtls.createCriteria("supplier");
			detachedCriteriaSupplier.add(Restrictions.eq("supplierName",supplierName.trim()));
		}
		if(drug != null){
			
			DetachedCriteria detachedCriteriaDrug = detachedCriteriaItem.createCriteria("drug");
			detachedCriteriaDrug.add(Restrictions.eq("drugSeqno",drug.getDrugSeqno()));
		}
		if(nondrug != null){
			DetachedCriteria detachedCriteriaNonDrug = detachedCriteriaItem.createCriteria("nonDrug");
			detachedCriteriaNonDrug.add(Restrictions.eq("nondrugSeqno",nondrug.getNondrugSeqno()));
		}
		if(StartDate != null && EndDate != null){
			detachedCriteria.add(Restrictions.and(Restrictions.gt("createDate", StartDate), Restrictions.lt("createDate", EndDate)));
		}
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ExternalFacility> getExternalFacility(final String facilityType,
			final String state) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("facilityList", facilityType));
		detachedCriteria.add(Restrictions.eq("activeFlag",'A'));
		detachedCriteria.add(Restrictions.eq("state", state));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractDtl> getActiveItem(final ContractHdr hqContractHdrs) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractDtl.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag",'A'));
		detachedCriteria.add(Restrictions.eq("hqContractHdr", hqContractHdrs));
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item.drug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item.nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("supplier", FetchMode.JOIN);
		detachedCriteria.setFetchMode("manufacturer", FetchMode.JOIN);
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractDtl> checkSupplier(final ContractHdr hqContractHdr,
			final Supplier supplier) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractDtl.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("hqContractHdr.hqHdrSeqno",
				hqContractHdr.getHqHdrSeqno()));
		detachedCriteria.createAlias("supplier", "supplier");
		detachedCriteria.add(Restrictions.eq("supplier.supplierCode",
				supplier.getSupplierCode()));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractDtl> checkActiveItem(final ContractHdr hqContractHdr) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractDtl.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag",'A'));
		return this.contractHqDAO.findByCriteria(detachedCriteria);

	}

	@Override
	public int totalAllocatedQty(final ContractHdr hqContractHdr) {
		int totalAllocatedQty = 0;
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ContractFacility.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("allocatedQty"));
		criteria.add(Restrictions.eq("hqContractHdr", hqContractHdr));
		criteria.setProjection(projectionList);
		List<Object[]> contractHqList = criteria.list();
		if (null != contractHqList) {
			totalAllocatedQty = null != contractHqList.iterator().next() ? Integer
					.parseInt(((Object) contractHqList.iterator().next())
							.toString()) : 0;
		}
		session.close();
		return totalAllocatedQty;
	}

	@Override
	public int totalAdditionalQty(final ContractHdr hqContractHdr) {
		int totalAdditionalQty = 0;
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ContractFacility.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("additionalQty"));
		criteria.add(Restrictions.eq("hqContractHdr", hqContractHdr));
		criteria.setProjection(projectionList);
		List<Object[]> contractHqList = criteria.list();
		if (null != contractHqList) {
			totalAdditionalQty = null != contractHqList.iterator().next() ? Integer
					.parseInt(((Object) contractHqList.iterator().next())
							.toString()) : 0;
		}
		session.close();
		return totalAdditionalQty;
	}

	@Override
	public List checkUniqueContractNo(final String trim) {
		// TODO Auto-generated method stub
		return this.contractHqDAO.find("from HqContractHdr where contractNo= \'"
				+ trim + "\'");
	}

	@Override
	public List<Item> getDefaultItemsFromDrug(final Drug drug) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Item.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("drug", drug));
		detachedCriteria.add(Restrictions.eq("activeFlag",RefCodeConstant.ACTIVE_FLAG_TRUE));
		detachedCriteria.add(Restrictions.eq("itemType",ContractHQConstant.ITEM_TYPE_CP));
		detachedCriteria.setFetchMode("itemBrands", FetchMode.JOIN);
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Item> getDefaultItemsFromNonDrug(final NonDrug nonDrug) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Item.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("nonDrug", nonDrug));
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		detachedCriteria.add(Restrictions.eq("itemType",ContractHQConstant.ITEM_TYPE_CP));
		detachedCriteria.setFetchMode("itemBrands", FetchMode.JOIN);
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ItemSubgroup> getItemSubgroup(final String drugDbValue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ItemSubgroup.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("itmGroupCode", drugDbValue));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}
	
	@Override
	public List<ExternalFacility> getAllFacilityName(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
		detachedCriteria.addOrder(Order.asc("state"));
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public RefCodes getRefCodeByRcValue(final String domain, final String rcValue) {

		DetachedCriteria criteria = DetachedCriteria.forClass(RefCodes.class);
		Criterion criterion = Restrictions.eq("rcDomain", domain);
		Criterion criterion2 = Restrictions.eq("rcValue", rcValue);
		criteria.add(Restrictions.and(criterion, criterion2));
		return (RefCodes) DataAccessUtils
				.uniqueResult(this.contractHqDAO.findByCriteria(criteria));
	}
	
	@Override
	public List<ExternalFacility> getAllFacilityName(final String facilityDesc,final String facilityCode,final String state,final String type){
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ExternalFacility.class);
		if(facilityDesc!=null){
			detachedCriteria.add(Restrictions.ilike("facilityName", "%"+facilityDesc+"%"));
		}
		if(facilityCode!=null){
			detachedCriteria.add(Restrictions.ilike("facilityCode", "%"+facilityCode+"%"));
		}
		if(state!=null){
			detachedCriteria.add(Restrictions.ilike("state", "%"+state+"%"));
		}
		if(type!=null){
			detachedCriteria.add(Restrictions.ilike("facilityList", "%"+type+"%"));
		}
		return this.contractHqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<ContractHdr> getHdrList(String contractNo) {
		List<ContractHdr> list = new ArrayList<ContractHdr>();
		if(!contractNo.equals("")){
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractHdr.class);
			detachedCriteria.add(Restrictions.ilike("contractNo", "%"+contractNo+"%"));
			detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			//			List<ContractHdr> hdrList = this.contractHqDAO.find("from ContractHdr where contractNo like \'"+"%"+contractNo+"\'" );
			List<ContractHdr> hdrList = this.contractHqDAO.findByCriteria(detachedCriteria);
			if(hdrList != null && hdrList.size() > 0){
				for(ContractHdr anContractHdr : hdrList){
					list.add(anContractHdr);
				}
				//				ContractHdr hdr = (ContractHdr) hdrList.iterator().next();
				//				list.add(hdr);
			}

		}else{
			List objectList =  this.contractHqDAO.find("SELECT max(revisedNo) as revisedNo ,h.contractNo"
					+" FROM ContractHdr as h"
					+" where  h.contractStatus in('CON','OPEN')"
					+" group by h.contractNo");

			Iterator itr = objectList.iterator();

			while(itr.hasNext()){
				Object[] obj = (Object[]) itr.next();
				Long revisedNo = null;
				for(int i = 0;i<obj.length;i++){
					switch (i){
					case 0 : revisedNo = (Long) obj[i]; break;
					case 1 : contractNo = (String) obj[i]; break;
					}
				}
				ContractHdr hdr = (ContractHdr) this.contractHqDAO.find("from ContractHdr where contractNo = \'"+contractNo+"\' and revisedNo ="+revisedNo).iterator().next();
				list.add(hdr);
			}
		}
		return list;
	}

	@Override
	public SecUser getSecUserFromLoginName(final String loginId) {
		List<SecUser>  userList = this.contractHqDAO.find("from SecUser where usrLoginname="+"'" + loginId + "'");
		SecUser secUser = null;
		if(userList != null &&  !userList.isEmpty()) {
			secUser = userList.iterator().next();
		}
		return secUser;
	}

	@Override
	public Item getItemFromItemCode(final String itemCode)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Item.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("itemCode", itemCode));
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drug.skuUomBean", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonDrug.uom", FetchMode.JOIN);
		detachedCriteria.setFetchMode("pkuUom", FetchMode.JOIN);
		List<Item> itemList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != itemList && itemList.size() > 0)
		{
			return itemList.iterator().next();
		}
		else
		{
			return null;
		}
	}

	@Override
	public String getStateNameFromStateCode(final String facilityState) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(RefCodes.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("rcDomain", ContractHQConstant.STATE_MY));
		detachedCriteria.add(Restrictions.eq("rcValue", facilityState));
		List<RefCodes> listRefCode = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != listRefCode && listRefCode.size() > 0)
		{
			return listRefCode.iterator().next().getRcDesc();
		}
		return "";
	}

	@Override
	public String getFacilityNameFromFacilityCode(final String facilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		List<ExternalFacility> itemList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != itemList && itemList.size() > 0)
		{
			return itemList.iterator().next().getFacilityName();
		}
		else
		{
			return "-";
		}

	}

	@Override
	public Supplier getSupplierFromSupplierCode(final long supplierSeqNo) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Supplier.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("sprSequenceNo", supplierSeqNo));
		List<Supplier> supplierList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != supplierList && supplierList.size() > 0)
		{
			return supplierList.iterator().next();
		}
		return null;
	}

	@Override
	public Brand getBrand(final long BrandSeqNo) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("brdSeqno", BrandSeqNo));
		List<Brand> brandList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != brandList && brandList.size() > 0)
		{
			return brandList.iterator().next();
		}
		return null;
	}

	@Override
	public Item getItemFromItemSeq(final long itemSeqNo) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Item.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("itemSeqno", itemSeqNo));
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drug.skuUomBean", FetchMode.JOIN);
		detachedCriteria.setFetchMode("nonDrug.uom", FetchMode.JOIN);
		detachedCriteria.setFetchMode("pkuUom", FetchMode.JOIN);
		detachedCriteria.setFetchMode("itemBrands", FetchMode.JOIN);
		detachedCriteria.setFetchMode("itemBrands.brand", FetchMode.JOIN);
		List<Item> itemList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != itemList && itemList.size() > 0)
		{
			return itemList.iterator().next();
		}
		else
		{
			return null;
		}
	}

	@Override
	public ContractItemQty getHqContractItemQty(final ContractItemQty contractItemQty) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractItemQty.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("hqContractItemQtySeqNo", contractItemQty.getHqContractItemQtySeqNo()));
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractHdr", FetchMode.JOIN);
		List<ContractItemQty> itemQtyList =  this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != itemQtyList && itemQtyList.size() > 0)
		{
			return itemQtyList.iterator().next();
		}
		else
		{
			return null;
		}
	}

	@Override
	public ContractDtl getContractDtl(final ContractDtl contractDtl) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(ContractDtl.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item.drug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("item.nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("supplier", FetchMode.JOIN);
		detachedCriteria.setFetchMode("manufacturer", FetchMode.JOIN);
		if(contractDtl!=null && contractDtl.getHqDtlSeqno()!=null)
		detachedCriteria.add(Restrictions.eq("hqDtlSeqno", contractDtl.getHqDtlSeqno()));
		List<ContractDtl> contractDtlList =  this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != contractDtlList && contractDtlList.size() > 0)
		{
			return contractDtlList.iterator().next();
		}
		else
		{
			return null;
		}
	}

	@Override
	public ContractFacility getContractFacility(
			final ContractFacility contractFacility) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractFacility.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("hqFacilitiesSeqno", contractFacility.getHqFacilitiesSeqno()));
		List<ContractFacility> contractFacilityList =  this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != contractFacilityList && contractFacilityList.size() > 0)
		{
			return contractFacilityList.iterator().next();
		}
		else
		{
			return null;
		}
	}

	@Override
	public ContractHdr findBySeqno(final Long hqHdrSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ContractHdr.class);
		criteria.add(Restrictions.eq("hqHdrSeqno", hqHdrSeqno));
		criteria.setFetchMode("hqContractFacilities", FetchMode.JOIN);
		criteria.setFetchMode("hqContractItemQty", FetchMode.JOIN);
		criteria.setFetchMode("hqContractDtlses", FetchMode.JOIN);
		criteria.setFetchMode("hqContractDeliveryPeriod", FetchMode.JOIN);
		criteria.setFetchMode("hqContractPenaltyDtl", FetchMode.JOIN);
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return (ContractHdr) DataAccessUtils.uniqueResult(this.contractHqDAO.findByCriteria(criteria));
	}

	@Override
	public List<ContractFacility> findContractFacility(final String activeFlag) {
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		StringBuilder querySql = new StringBuilder();
		querySql.append("select distinct e from ContractFacility e ")
		.append(" inner join fetch e.hqContractHdr cth ")
		.append(" inner join fetch  cth.hqContractDtlses dtl ")
		.append(" inner join fetch  dtl.brand brd ")
		.append(" inner join fetch  cth.hqContractItemQty iqty ")
		.append(" inner join fetch  dtl.item item ")
		.append(" inner join fetch  dtl.supplier supplier ")
		.append(" left join fetch  cth.itemSubGroup isg")
		.append(" where ")
		.append(" cth.contractStatus = :contractStatus and e.sendFlag = :sendFlag")
		.append(" and e.facilityCode in (select facilityCode from ExternalFacility where serverPort is not null and serverIp is not null)");
		org.hibernate.query.Query query = session.createQuery(querySql.toString());
		query.setParameter("contractStatus", InventoryConstant.CONTRACT_HQ_STATUS_VRF);
		query.setParameter("sendFlag", RefCodeConstant.BOOLEAN_YES);
		List<ContractFacility> results = query.list();
		session.close();
		return results;
	}

	@Override
	public void updateContract(final List<Long> seqnos, final String sendFlag) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("update ContractFacility e set e.sendFlag = :sendFlag where e.hqFacilitiesSeqno in (:seqnos) ");
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(querySql.toString());
		query.setParameter("sendFlag", sendFlag);
		query.setParameterList("seqnos", seqnos);
		query.executeUpdate();
		session.close();
	}

	@Override
	public Brand getBrandByBrandCode(String brandCode) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Brand.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("brdCode", brandCode));
		List<Brand> brandList = this.contractHqDAO.findByCriteria(detachedCriteria);
		if(null != brandList && brandList.size() > 0)
		{
			return brandList.iterator().next();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getNewRevisedNumber(ContractHdr contractHdr) {
		Session session = getContractHqDAO().getSessionFactory().openSession();
		NativeQuery query = session.createSQLQuery("select max(revised_no) from T_CONTRACT_HDRS where contract_no='"+contractHdr.getContractNo()+"'");
		List<Object> list = query.list();
		BigDecimal newRevisedNo = (BigDecimal) list.get(0);
		session.close();
		return null !=newRevisedNo ?  newRevisedNo.longValue() : 0;
	}

	
	
	@Override
	public int effectiveStartDateEndDateCheckForContractItem(final String contractNo,final Long revisedNo,final Long itemSeqNo,String startDate,String endDate, ContractHdr contractHdr) {
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		StringBuilder querySql = new StringBuilder();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		/*deMorgan's law
		(StartA <= EndB) and (EndA >= StartB)
		
		StartA : contractDTL.effectivestartDate
		EndA   : contractDTL.effectiveEndDate
		
		StartB : startDate
		EndB   : endDate
		*/
		
		querySql.append("SELECT COUNT(T.CONTRACT_NO) ");
		querySql.append("FROM (  ");
		querySql.append("SELECT MAX(REVISED_NO) as max_rev ,contracthd1_.CONTRACT_NO as CONTRACT_NO ");
		querySql.append("FROM ");
		querySql.append("	T_CONTRACT_HDRS contracthd1_ "); 
		querySql.append("	LEFT JOIN T_CONTRACT_DTLS contractdt0_ ON contractdt0_.HDR_SEQNO = contracthd1_.HDR_SEQNO ");
		querySql.append("WHERE ");
		querySql.append("	contractdt0_.hdr_seqno = contracthd1_.hdr_seqno ");
		querySql.append("	AND 1 = 1 ");
		querySql.append("	AND contractdt0_.effective_start_date <= TO_DATE('"+endDate+"', 'yyyy-mm-dd hh24:mi:ss' ) ");
		querySql.append("	AND contractdt0_.effective_end_date >= TO_DATE('"+startDate+"', 'yyyy-mm-dd hh24:mi:ss' ) ");
		querySql.append("	AND contractdt0_.itm_seqno ="+itemSeqNo);
		querySql.append("	AND( contracthd1_.contract_status NOT IN('REJ', 'CANCEL') ");
		if(contractHdr.getContractNo()!=null)
		querySql.append(" and CONTRACT_NO !='"+contractHdr.getContractNo()+"' ");
		querySql.append(" ) ");
		querySql.append("GROUP BY contracthd1_.CONTRACT_NO ");
		querySql.append(") T ");
		querySql.append("WHERE T.max_rev = ( SELECT max(REVISED_NO) FROM T_CONTRACT_HDRS con_hdr WHERE con_hdr.CONTRACT_NO =  T.CONTRACT_NO) ");
		
		NativeQuery query = session.createSQLQuery(querySql.toString());
		List<Object> results = query.list();
		session.close();
		return Integer.parseInt(results.get(0) != null ? results.get(0).toString() : "0");
	}
	
	@Override
	public Map<String, Long> getItemAllocatedQty(Long hdrSeqno, String facSeqnos) {
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		Map<String, Long> itemQtyAllocatedMap = new HashMap<String, Long>();
		StringBuffer sb = new StringBuffer();
		sb.append("select  item_Code, sum(allocated_qty) from T_CONTRACT_FACILITIES where hdr_seqno = "+hdrSeqno+" and facilities_seqno not in ( "+facSeqnos.toString()+" ) group by item_Code");
		NativeQuery query = session.createSQLQuery(sb.toString());
		List results = ((org.hibernate.query.Query) query).list();
		session.close();
		Iterator itr = results.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			itemQtyAllocatedMap.put(obj[0].toString(), Long.parseLong(obj[1].toString()));
		}
			
		return itemQtyAllocatedMap;
	}

	@Override
	public ContractHdr getContractHdr(String contractNo, Integer revision) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractHdr.class);
		detachedCriteria.add(Restrictions.ne("contractStatus", InventoryConstant.CONTRACT_HQ_STATUS_REJ));
		detachedCriteria.add(Restrictions.ne("contractStatus", InventoryConstant.CONTRACT_HQ_STATUS_CANCEL));
		if(contractNo!=null)
			detachedCriteria.add(Restrictions.eq("contractNo", contractNo));
		if(revision!=null)
			detachedCriteria.add(Restrictions.eq("revisedNo", revision.longValue()));
		List<ContractHdr> contractHdrs =  contractHqDAO.findByCriteria(detachedCriteria);
		if(null != contractHdrs && contractHdrs.size() > 0){
			return contractHdrs.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public ContractHdr getContractHdrByContractNoAndRevision(String contractNo,long revision) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ContractHdr.class);
		criteria.add(Restrictions.eq("contractNo", contractNo));
		criteria.add(Restrictions.eq("revisedNo", revision));
		criteria.add(Restrictions.in("contractStatus",InventoryConstant.CONTRACT_HQ_STATUS_VRF,InventoryConstant.CONTRACT_HQ_STATUS_REJ,InventoryConstant.CONTRACT_HQ_STATUS_CANCEL));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		//return (ContractHdr) DataAccessUtils.uniqueResult(this.contractHqDAO.findByCriteria(criteria));
		List<ContractHdr> contractHdrs =  contractHqDAO.findByCriteria(criteria);
		if(null != contractHdrs && contractHdrs.size() > 0){
			return contractHdrs.get(0);
		}else{
			return null;
		}
	}

	@Override
	public ContractFacility getNewContractFacility(ContractHdr contractHdr,String itemCode,SecUser secUser,ExternalFacility externalFacility) {
		ContractFacility contractFacility = new ContractFacility();
		contractFacility.setCreateDate(new Date());
		contractFacility.setUpdateBy(secUser.getId());
		contractFacility.setUpdateDate(new Date());
		contractFacility.setFacilityCode(externalFacility.getFacilityCode());
		contractFacility.setFacilityName(externalFacility.getFacilityName());
		contractFacility.setSendFlag(RefCodeConstant.BOOLEAN_NO);
		contractFacility.setPtjCode(externalFacility.getPtjCode());
		contractFacility.setItemCode(itemCode);
		contractFacility.setFacilityState(externalFacility.getState());
		contractFacility.setHqContractHdr(contractHdr);
		
		return contractFacility;
	}

	@Override
	public ContractHdr addAllFacilities(ContractHdr contractHdr, String itemCode, SecUser secUser,List<ExternalFacility> externalFacilities,BigDecimal remainingQTY) {
		BigDecimal minAllocatedQTY = new BigDecimal(1);
		int duplicateFacilityCount=0;
		for(ExternalFacility externalFacility : externalFacilities) {
			boolean isFacilityExists = false;
			for (ContractFacility contractFacility : contractHdr.getHqContractFacilities()) {
				//if(contractFacility.getFacilityCode().equals(externalFacility.getFacilityCode()) && itemCode.equals(contractFacility.getItemCode())) {
					if(contractFacility.getFacilityCode().equals(externalFacility.getFacilityCode())){
					isFacilityExists = true;
					duplicateFacilityCount++;
					break;
				}
			}
			/*if(duplicateFacilityCount==1){
				ExceptionMessage.showMessage(MessageConstant.FACILITY_NAME_AND_ITEM_DESCRIPTION_ALREADY_PRESENT);
				break;
			}*/
			if(!isFacilityExists) {
				ContractFacility contractFacility = getNewContractFacility(contractHdr,itemCode,secUser,externalFacility);
				remainingQTY = remainingQTY.subtract(minAllocatedQTY);
				contractFacility.setAllocatedQty(minAllocatedQTY);
				contractHdr.getHqContractFacilities().add(contractFacility);
			}
		}
		for(ContractItemQty contractItemQty : contractHdr.getHqContractItemQty()) {
			if(contractItemQty.getItemCode().equals(itemCode)) {
				contractItemQty.setUpdateBy(secUser.getId());
				contractItemQty.setUpdateDate(new Date());
				contractItemQty.setRemainingQty(remainingQTY.longValue());
				break;
			}
		}
		return contractHdr;
	}
	
	@Override
	public List<ExternalFacility> getFilteredExternalFacilitiesForContract(String facilityCode,String state,String facType,ArrayList<String> facilityseq,Character isMohType) {
		ExternalFacilityService externalFacilityService = CommonUtil.getService("externalFacilityService");
		
		List<String> type = new ArrayList<String>();
		if(facType == null || facType.isEmpty()) {
			type.addAll(getContractFacilityCategories());
		} else {
			type.add(facType);
		}
		
		return externalFacilityService.getFilteredExternalFacilities(facilityCode, state, type,facilityseq,isMohType);
	}

	@Override
	public List<String> getContractFacilityCategories() {
		List<String> selectedFacType = new ArrayList<String>();
		selectedFacType.add(RefCodeConstant.FACILITY_CATEGORY_HOSPITAL);
		selectedFacType.add(RefCodeConstant.FACILITY_CATEGORY_KK);
		selectedFacType.add(RefCodeConstant.FACILITY_CATEGORY_PKD);
		selectedFacType.add(RefCodeConstant.FACILITY_CATEGORY_MUSN_PBFN);
		return selectedFacType;
	}

	@Override
	public boolean checkFacilityType(String facilityCode, String facilityType) {
		@SuppressWarnings("unchecked")
		List<ExternalFacility> list = contractHqDAO
				.find("from ExternalFacility where facilityCode = '" + facilityCode + "' and facilityList = '"+facilityType+"' and activeFlag = 'A' ");
		if(null != list && list.size() > 0)
			return true;
		return false;
	}
	
	@Override
	public List<ContractFacility> getcontractFacilitiesByContractHdr(ContractHdr contractHdr)
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractFacility.class);
		detachedCriteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("hqContractHdr", contractHdr));
		List<ContractFacility> contractFacilityList =  this.contractHqDAO.findByCriteria(detachedCriteria);
		return contractFacilityList;
	}

	@Override
	public ContractHdr getContractFacilityDtlList(ContractHdr hdr) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ContractHdr.class);

		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.setFetchMode("hqContractDtlses", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.item", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.item.drug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.item.nonDrug", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.brand", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDtlses.supplier", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractItemQty", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractFacilities", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractDeliveryPeriod", FetchMode.JOIN);
		detachedCriteria.setFetchMode("hqContractPenaltyDtl", FetchMode.JOIN);
		//detachedCriteria.add(Restrictions.eq("contractStatus", InventoryConstant.CONTRACT_HQ_STATUS_APPROVED));
		detachedCriteria.add(Restrictions.eq("hqHdrSeqno", hdr.getHqHdrSeqno()));

		return (ContractHdr) DataAccessUtils.uniqueResult(contractHqDAO.findByCriteria(detachedCriteria));
	}

	public void deleteContractFacilityDetails(List<String> deletedfinalContractFacilities,Long hqHdrSeqno) {
		try{
		Session session = this.contractHqDAO.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		NativeQuery query = session.createSQLQuery("delete from T_CONTRACT_FACILITIES e  where e.hdr_seqno='"+hqHdrSeqno+"' and e.facility_code in  ('"+StringUtils.join(deletedfinalContractFacilities,"','")+"') ");
		query.executeUpdate();
		tx.commit();
		session.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteContractPenaltyDetails(String formulacode, Long hqHdrSeqno) {
		try{
			Session session = this.contractHqDAO.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			javax.persistence.Query query = session.createSQLQuery("delete from t_contract_penalty_dtl e  where e.hdr_seqno='"+hqHdrSeqno+"' and e.formula_code not in ("+formulacode+") ");
			Query.executeUpdate();
			tx.commit();
			session.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	@Override
	public ContractHdr getcontract(Item item){
		DetachedCriteria criteria = DetachedCriteria.forClass(ContractHdr.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("hqContractDtlses","contractdtl" ,CriteriaSpecification.LEFT_JOIN);
		criteria.setFetchMode("hqContractPenaltyDtl", FetchMode.JOIN);
		criteria.setFetchMode("hqContractDeliveryPeriod", FetchMode.JOIN);
		criteria.add(Restrictions.eq("contractdtl.item", item));
		criteria.add(Restrictions.and(Restrictions.le("contractdtl.effectivestartDate",new Date()),Restrictions.ge("contractdtl.effectiveEndDate",new Date())));
		List<ContractHdr> contractHdrs =  contractHqDAO.findByCriteria(criteria);
		if(null != contractHdrs && contractHdrs.size() > 0){
			return contractHdrs.get(0);
		}else{
			return null;
		}
		//return (ContractHdr) DataAccessUtils.uniqueResult(contractHqDAO.findByCriteria(criteria));
	}
	
}
