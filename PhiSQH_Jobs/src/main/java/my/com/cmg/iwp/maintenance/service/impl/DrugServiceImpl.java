package my.com.cmg.iwp.maintenance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.AdminRoute;
import my.com.cmg.iwp.maintenance.model.AtcDetail;
import my.com.cmg.iwp.maintenance.model.DosageForm;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugRoute;
import my.com.cmg.iwp.maintenance.model.GenericName;
import my.com.cmg.iwp.maintenance.model.ResultObject;
import my.com.cmg.iwp.maintenance.service.DrugService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class DrugServiceImpl implements DrugService {
	private BasisNextidDaoImpl<Drug> drugDAO;

	@Override
	public Drug getNewDrug() {
		return new Drug();
	}

	@Override
	public void delete(Drug anDrug) {
		drugDAO.delete(anDrug);

	}

	@Override
	public void saveOrUpdate(Drug anDrug) {

		drugDAO.saveOrUpdate(anDrug);

	}

	public void setDrugDAO(BasisNextidDaoImpl<Drug> drugDAO) {
		this.drugDAO = drugDAO;
	}

	public BasisNextidDaoImpl<Drug> getDrugDAO() {
		return drugDAO;
	}

	@Override
	public Drug findByDrugCode(String drugCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.ilike("drugCode", drugCode));
		return DataAccessUtils.uniqueResult(drugDAO.findByCriteria(criteria));
	}

	@Override
	public Drug findByDrugSeqno(long drugSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("drugSeqno", drugSeqno));
		return DataAccessUtils.uniqueResult(drugDAO.findByCriteria(criteria));
	}

	@Override
	public ResultObject getAllDrugsDrugNameLikeText(String textDrugName,
			int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(textDrugName)) {
			criteria.add(Restrictions.ilike("drugName", textDrugName,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("drugName"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

	@Override
	public ResultObject getAllDrugsDrugNameLikeText(String textDrugName,
			String textCategory, String textFormulary, int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(textDrugName)) {
			criteria.add(Restrictions.ilike("drugName", textDrugName,
					MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(textFormulary)) {
			criteria.add(Restrictions.ilike("formulary", textFormulary,
					MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(textCategory)) {
			criteria.add(Restrictions.ilike("category", textCategory,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("drugName"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

	@Override
	public ResultObject getAllDrugsGenericNameLikeText(
			String searchGenericName, String searchAdminRoute,
			String searchDosageForm, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(searchGenericName)) {
			criteria.add(Restrictions.ilike("genericName", searchGenericName,
					MatchMode.START));
		}

		if (!StringUtils.isEmpty(searchAdminRoute)) {
			criteria.add(Restrictions.ilike("defaultRoute", searchAdminRoute,
					MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(searchDosageForm)) {
			criteria.add(Restrictions.ilike("dosageForm", searchDosageForm,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("genericName"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

	public ResultObject getAllDrugsGenericNameLikeText(
			String searchGenericName, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.createAlias("genericName", "genericname",
				CriteriaSpecification.LEFT_JOIN);

		;
		if (!StringUtils.isEmpty(searchGenericName)) {
			criteria.add(Restrictions.or(Restrictions.ilike(
					"genericname.genericDesc", searchGenericName,
					MatchMode.START), Restrictions.ilike("drugName",
					searchGenericName, MatchMode.START)));

		}
		/*
		 * if (!StringUtils.isEmpty(searchAdminRoute)) {
		 * criteria.add(Restrictions.ilike("defaultRoute", searchAdminRoute,
		 * MatchMode.ANYWHERE)); } if (!StringUtils.isEmpty(searchDosageForm)) {
		 * criteria.add(Restrictions.ilike("dosageForm", searchDosageForm,
		 * MatchMode.ANYWHERE)); }
		 */

		criteria.addOrder(Order.asc("drugName"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);

	}

	@Override
	public ResultObject getAllDrugsATCLikeText(String searchLevel1,
			String searchLevel2, String searchLevel3, String searchLevel4,
			String searchLevel5, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(searchLevel1)) {
			criteria.add(Restrictions.ilike("level1Desc", searchLevel1,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchLevel2)) {
			criteria.add(Restrictions.ilike("level2Desc", searchLevel2,
					MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(searchLevel3)) {
			criteria.add(Restrictions.ilike("level3Desc", searchLevel3,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchLevel4)) {
			criteria.add(Restrictions.ilike("level4Desc", searchLevel4,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchLevel5)) {
			criteria.add(Restrictions.ilike("level5Desc", searchLevel5,
					MatchMode.ANYWHERE));
		}
		criteria.addOrder(Order.asc("genericName"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public List<Drug> getAllDrugs() {

		return drugDAO.loadAll(Drug.class);
	}

	@Override
	public ResultObject getAllDrugsDrugNameInfusionLikeText(
			String searchDrugCode, String searchDrugName, int start,
			int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(searchDrugCode)) {
			criteria.add(Restrictions.ilike("drugCode", searchDrugCode,
					MatchMode.ANYWHERE));
		}

		if (!StringUtils.isEmpty(searchDrugName)) {
			criteria.add(Restrictions.ilike("drugName", searchDrugName,
					MatchMode.ANYWHERE));
		}

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public Drug findByFluidDrug(boolean ivFluidYn, boolean ivDrugYn) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		Criterion crit1 = Restrictions.eq("ivFluidYn", ivFluidYn);
		Criterion crit2 = Restrictions.eq("ivDrugYn", ivDrugYn);
		criteria.add(Restrictions.or(crit1, crit2));
		List<Drug> list = drugDAO.findByCriteria(criteria);
		return DataAccessUtils.uniqueResult(list);
	}

	@Override
	public ResultObject getDrugsDrugNameInfusionLikeText(boolean ivFluidYn,
			boolean ivDrugYn, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		Criterion crit1 = Restrictions.eq("ivFluidYn", ivFluidYn);
		Criterion crit2 = Restrictions.eq("ivDrugYn", ivDrugYn);
		criteria.add(Restrictions.or(crit1, crit2));

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public ResultObject getAllAlternateDrugsLikeAtcCode(String atcCode,
			String requestedDrug, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(atcCode)) {
			criteria.add(Restrictions.ilike("drugCode", atcCode,
					MatchMode.START));
		}

		if (!StringUtils.isEmpty(requestedDrug)) {
			criteria.add(Restrictions.not(Restrictions.eq("drugCode",
					requestedDrug)));
		}

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public List<Drug> findLikeATC(String atcCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.like("drugCode", atcCode, MatchMode.ANYWHERE));
		return drugDAO.findByCriteria(criteria);
	}

	@Override
	public ResultObject getAlternateDrugsLikeGenericName(String genericName,
			String requestedDrug, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);

		if (!StringUtils.isEmpty(genericName)) {
			criteria.add(Restrictions.eq("genericName", genericName));
		}

		if (!StringUtils.isEmpty(requestedDrug)) {
			criteria.add(Restrictions.not(Restrictions.eq("drugCode",
					requestedDrug)));
		}

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public ResultObject getAllDrugsIVFluidLikeText(String drugCode,
			String drugName, boolean IVFluid, int start, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		Criterion crit1 = Restrictions.ilike("drugCode", drugCode,
				MatchMode.ANYWHERE);
		Criterion crit2 = Restrictions.ilike("drugName", drugName,
				MatchMode.ANYWHERE);
		Criterion crit3 = Restrictions.like("ivFluidYn", true);

		criteria.add(Restrictions.and(crit1, crit3));
		criteria.add(Restrictions.and(crit2, crit3));

		criteria.addOrder(Order.asc("drugCode"));

		int totalCount = getDrugDAO().findByCriteria(criteria).size();

		List<Drug> list = getDrugDAO()
				.findByCriteria(criteria, start, pageSize);

		return new ResultObject(list, totalCount);
	}

	@Override
	public List<Drug> getAllDrugsFromDate(Date date) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.ge("createDate", date));
		List<Drug> results = getDrugDAO().findByCriteria(criteria);
		return results;
	}

	@Override
	public List<Drug> getAlternateDrugs(GenericName genericName, Drug drug) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.createCriteria("genericName").add(
				Restrictions.eq("genericSeqno", genericName.getGenericSeqno()));
		// criteria.createCriteria("dosageForm").add(Restrictions.eq("dosageSeqno",drug.getDosageForm().getDosageSeqno()));
		criteria.add(Restrictions.ne("drugSeqno", drug.getDrugSeqno()));
		List<Drug> list = getDrugDAO().findByCriteria(criteria);

		return list;
	}

	@Override
	public List<Drug> getDrugsByCriteria(DosageForm dosageForm,
			AdminRoute adminRoute, String genericName) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);

		detachedCriteria.add(Restrictions.eq("activeFlag", true));
		detachedCriteria.setFetchMode("dosageForm", FetchMode.JOIN);
		detachedCriteria.setFetchMode("genericName", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes.adminRoute", FetchMode.JOIN);
		if (!StringUtils.isEmpty(genericName)) {
			DetachedCriteria criteriaGenericName = detachedCriteria
					.createCriteria("genericName");
			criteriaGenericName.add(Restrictions.ilike("genericDesc", "%"
					+ genericName + "%"));
		}
		if (null != adminRoute) {
			DetachedCriteria criteriaDrugRoutes = detachedCriteria
					.createCriteria("drugRoutes");
			criteriaDrugRoutes.setFetchMode("drugRoutes", FetchMode.JOIN);
			criteriaDrugRoutes.setFetchMode("adminRoute", FetchMode.JOIN);
			criteriaDrugRoutes.add(Restrictions.eq("adminRoute", adminRoute));

		}
		/*
		 * else { DetachedCriteria criteria =
		 * detachedCriteria.createCriteria("drugRoutes");
		 * criteria.setFetchMode("adminRoute", FetchMode.JOIN); }
		 */

		if (null != dosageForm) {
			detachedCriteria.add(Restrictions.eq("dosageForm", dosageForm));
		}
		/*
		 * List<Drug> drugList = getDrugDAO().findByCriteria(detachedCriteria);
		 * for (Drug drug : drugList) { Set<DrugRoute> drugRoutes =
		 * drug.getDrugRoutes(); for (DrugRoute rt : drugRoutes) {
		 * System.out.println(rt.getDrugRouteSeqno()); } }
		 */
		detachedCriteria.add(Restrictions.in("drugType", new String[] {
				RefCodeConstant.DRUG_TYPE_GL, RefCodeConstant.DRUG_TYPE_PN }));

		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getDrugDAO().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Drug> getDrugsByDrugNameAndCategory(String drugName,
			String drugCategory) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);

		detachedCriteria.add(Restrictions.eq("activeFlag", true));
		detachedCriteria.setFetchMode("dosageForm", FetchMode.JOIN);
		detachedCriteria.setFetchMode("genericName", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes.adminRoute", FetchMode.JOIN);

		detachedCriteria.add(Restrictions.in("drugType", new String[] {
				RefCodeConstant.DRUG_TYPE_GL, RefCodeConstant.DRUG_TYPE_PN }));

		if (drugName != null)
			detachedCriteria.add(Restrictions.ilike("drugName", "%" + drugName
					+ "%"));

		if (drugCategory != null)
			detachedCriteria.add(Restrictions.ilike("drugCategory", "%"
					+ drugCategory + "%"));

		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return getDrugDAO().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Drug> getDrugsByAtcDetail(AtcDetail atcDetail, Integer level) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		detachedCriteria.setFetchMode("dosageForm", FetchMode.JOIN);
		// detachedCriteria.setFetchMode("genericName", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes", FetchMode.JOIN);
		detachedCriteria.setFetchMode("drugRoutes.adminRoute", FetchMode.JOIN);
		// detachedCriteria.setFetchMode("atcDetail", FetchMode.JOIN);

		detachedCriteria
				.createAlias("genericName", "gn",
						CriteriaSpecification.LEFT_JOIN)
				.createAlias("gn.genericNameAtcs", "gATCs",
						CriteriaSpecification.LEFT_JOIN)
				.createAlias("gATCs.atcDetail", "ad",
						CriteriaSpecification.LEFT_JOIN);

		// detachedCriteria.setFetchMode("mimsMapping", FetchMode.JOIN);
		if (atcDetail != null)
			detachedCriteria.add(Restrictions.ilike("ad.atcCode",
					atcDetail.getAtcCode() + "%"));

		if (level != null) {
			detachedCriteria.add(Restrictions.eq("ad.atcLevel", level));
		}

		detachedCriteria.add(Restrictions.in("drugType", new String[] { "GL",
				"PN" }));

		return getDrugDAO().findByCriteria(detachedCriteria);
	}

	@Override
	public Drug getDrug(long drugSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("drugSeqno", drugSeqno));
		criteria.setFetchMode("skuUomBean", FetchMode.JOIN);
		List<Drug> drugs = getDrugDAO().findByCriteria(criteria);
		return drugs.isEmpty() ? null : drugs.get(0);
	}

	@Override
	public List<Drug> getDrugsHavingGenericName(GenericName genericName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("genericName", genericName));
		return drugDAO.findByCriteria(criteria);
	}

	@Override
	public void refresh(Drug anDrug) {
		drugDAO.refresh(anDrug);
		drugDAO.initialize(anDrug);
	}

	@Override
	public boolean isDrugDangerous(String drugSchedule) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("drugSchedule", drugSchedule));
		criteria.setProjection(Projections.rowCount());

		int count = DataAccessUtils.intResult(drugDAO.findByCriteria(criteria));
		return count > 0;
	}

	@Override
	public List<Drug> getDrugsIlikeName(String drugName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.ilike("drugName", drugName + "%"));
		return drugDAO.findByCriteria(criteria);
	}

	@Override
	public List<Drug> getDrugTdmDrugs(String drugCode, String drugName) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);

		detachedCriteria.setFetchMode("tdmGuidelineHdrs", FetchMode.JOIN);
		detachedCriteria.setFetchMode("tdmGuidelineHdrs.tdmGuidlines",
				FetchMode.JOIN);
		detachedCriteria.setFetchMode("dosageForm", FetchMode.JOIN);
		detachedCriteria.setFetchMode("strengthUom", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("tdmYn", true));
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (drugCode != null) {

			detachedCriteria.add(Restrictions.eq("drugCode", drugCode));
		}
		if (drugName != null) {

			detachedCriteria.add(Restrictions.ilike("drugName", "%" + drugName
					+ "%"));
		}
		detachedCriteria.add(Restrictions.isNotEmpty("tdmGuidelineHdrs"));
		return drugDAO.findByCriteria(detachedCriteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> getDiluentDrugs(List<Long> drugSeqno) {
		Session session = drugDAO.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Drug.class);
		criteria.setFetchMode("quantityUom", FetchMode.JOIN);
		List<Drug> drugs = new ArrayList<Drug>(0);
		if (drugSeqno.size() > 0) {
			criteria.add(Restrictions.in("drugSeqno", drugSeqno));
			drugs = criteria.list();
		}
		session.close();
		return drugs;
	}

	@Override
	public List<Drug> getDrugsHavingGenericNameAndDrugRoute(
			GenericName genericName, DrugRoute drugRoute) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("genericName", genericName));
		criteria.createCriteria("drugRoutes").add(
				Restrictions.eq("adminRoute", drugRoute.getAdminRoute()));
		return drugDAO.findByCriteria(criteria);
	}

	@Override
	public List<Drug> getDrugsListByStatus() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);
		detachedCriteria.add(Restrictions.eq("activeFlag", true));
		return drugDAO.findByCriteria(detachedCriteria);

	}

	@Override
	public List<Drug> getAlternateDrugsForPn(Drug drug) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Drug.class);
		detachedCriteria.add(Restrictions.eq("activeFlag", true));
		detachedCriteria.add(Restrictions.eq("pnType", "T"));
		detachedCriteria.add(Restrictions.ne("drugSeqno", drug.getDrugSeqno()));
		return drugDAO.findByCriteria(detachedCriteria);
	}
}
