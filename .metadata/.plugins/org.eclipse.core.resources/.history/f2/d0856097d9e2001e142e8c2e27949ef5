package my.com.cmg.iwp.backend.service.integration.spub.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.spub.SpubHdrsInt;
import my.com.cmg.iwp.backend.service.integration.spub.SpubHdrsIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;


@Service
public class SpubHdrsIntServiceImpl implements SpubHdrsIntService {
	private BasisNextidDaoImpl<SpubHdrsInt> spubHdrsIntDAO;

	public BasisNextidDaoImpl<SpubHdrsInt> getSpubHdrsIntDAO() {
		return spubHdrsIntDAO;
	}

	public void setSpubHdrsIntDAO(BasisNextidDaoImpl<SpubHdrsInt> spubHdrsIntDAO) {
		this.spubHdrsIntDAO = spubHdrsIntDAO;
	}

	@Override
	public void refresh(SpubHdrsInt spubHdrsInt) {
		spubHdrsIntDAO.refresh(spubHdrsInt);
		spubHdrsIntDAO.initialize(spubHdrsInt);

	}

	@Override
	public void saveOrUpdate(SpubHdrsInt spubHdrsInt) {
		spubHdrsIntDAO.saveOrUpdate(spubHdrsInt);
	}

	@Override
	public List<SpubHdrsInt> getSpubHdrsInts(String sendFlag) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(SpubHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("sendFlag", sendFlag));
		detachedCriteria.setFetchMode("spubAllergiesInts", FetchMode.JOIN);
		//detachedCriteria.setFetchMode("spubDtlsInts", FetchMode.JOIN);
		detachedCriteria.setFetchMode("spubDiagnosisInts", FetchMode.JOIN);
		detachedCriteria.createAlias("spubDtlsInts", "spubDtls", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("spubDtls.normalDoseFrequencyInts", "ndf", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("spubDtlsInts.spubAlternateInts", "spubAlternateInts", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("spubDtlsInts.spubAlternateInts.normalDoseFreqAlternateInts", "andf", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.createAlias("spubDtls.suborderTaperStatInts", "taper", CriteriaSpecification.LEFT_JOIN);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return spubHdrsIntDAO.findByCriteria(detachedCriteria);

	}

	@Override
	public void updateSpubHdrInt(String sendFlagValue, String factCode) {
		StringBuilder updateStr = new StringBuilder();
		updateStr
				.append("update SpubHdrsInt e ")
				.append(" set ")
				.append(" e.sendFlag = :sendFlagValue, e.version = e.version + 1 ")
				.append(" where ")
				.append(" e.referredTo = :factCode ");
		Session session = spubHdrsIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(updateStr.toString());

		query.setParameter("sendFlagValue", sendFlagValue);
		query.setParameter("factCode", factCode);
		query.executeUpdate();
		session.close();
	}

	@Override
	public boolean isNotExisted(String spubNo, String fromPtjCode, String fromFactCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("spubNo", spubNo));
		detachedCriteria.add(Restrictions.eq("ptjCode", fromPtjCode));
		detachedCriteria.add(Restrictions.eq("facCode", fromFactCode));
		List spubHdrInts =  spubHdrsIntDAO.findByCriteria(detachedCriteria);
		return spubHdrInts.isEmpty();
	}
	
	@Override
	public boolean isRegistered(String spubNo, String fromPtjCode, String fromFactCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("spubNo", spubNo));
		detachedCriteria.add(Restrictions.eq("ptjCode", fromPtjCode));
		detachedCriteria.add(Restrictions.eq("facCode", fromFactCode));
		detachedCriteria.add(Restrictions.eq("spubRegistered", RefCodeConstant.SPUB_REGISTERED_REGISTERED));
		List spubHdrInts =  spubHdrsIntDAO.findByCriteria(detachedCriteria);
		return spubHdrInts.isEmpty();
	}
	
	public SpubHdrsInt getSpubBySpubNo(String spubNo){
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubHdrsInt.class);
		detachedCriteria.add(Restrictions.eq("spubNo", spubNo));
		
		return DataAccessUtils.uniqueResult(spubHdrsIntDAO.findByCriteria(detachedCriteria));
		
	}
}
