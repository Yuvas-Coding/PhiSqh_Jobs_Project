package my.com.cmg.iwp.backend.service.integration.tdm.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.tdm.SamplingDetailsInt;
import my.com.cmg.iwp.backend.model.integration.tdm.TdmOrderInt;
import my.com.cmg.iwp.backend.service.integration.tdm.TdmOrderIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class TdmOrderIntServiceImpl implements TdmOrderIntService {
	
	private BasisNextidDaoImpl<TdmOrderInt> tdmOrderIntDAO;
	private BasisNextidDaoImpl<SamplingDetailsInt> samplingDetailsIntDAO;

	@Override
	public void saveOrUpdate(TdmOrderInt tdmOrderInt) {
		tdmOrderIntDAO.saveOrUpdate(tdmOrderInt);
	}
	
	@Override
	public void save(TdmOrderInt tdmOrderInt) {
		tdmOrderIntDAO.save(tdmOrderInt);
	}

	@Override
	public TdmOrderInt findTDMOrderByID(long id) {
		return tdmOrderIntDAO.get(TdmOrderInt.class, id);
	}

	@Override
	public void saveOrUpdate(SamplingDetailsInt samplingDetailsInt) {
		samplingDetailsIntDAO.saveOrUpdate(samplingDetailsInt);
	}

	@Override
	public void save(SamplingDetailsInt samplingDetailsInt){
		samplingDetailsIntDAO.save(samplingDetailsInt);
	}
	@Override
	public SamplingDetailsInt findSamplingDetailByID(long id) {
		return samplingDetailsIntDAO.get(SamplingDetailsInt.class, id);
	}

	public BasisNextidDaoImpl<TdmOrderInt> getTdmOrderIntDAO() {
		return tdmOrderIntDAO;
	}

	public void setTdmOrderIntDAO(BasisNextidDaoImpl<TdmOrderInt> tdmOrderIntDAO) {
		this.tdmOrderIntDAO = tdmOrderIntDAO;
	}

	public BasisNextidDaoImpl<SamplingDetailsInt> getSamplingDetailsIntDAO() {
		return samplingDetailsIntDAO;
	}

	public void setSamplingDetailsIntDAO(
			BasisNextidDaoImpl<SamplingDetailsInt> samplingDetailsIntDAO) {
		this.samplingDetailsIntDAO = samplingDetailsIntDAO;
	}

	@Override
	public boolean isNotExisted(String tdmNo, String toPtjCode, String toFacilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TdmOrderInt.class);
		detachedCriteria.add(Restrictions.eq("tdmOrderNo", tdmNo));
		detachedCriteria.add(Restrictions.eq("toPtjCode", toPtjCode));
		detachedCriteria.add(Restrictions.eq("toFacilityCode", toFacilityCode));
		List<TdmOrderInt> tdmOrderInts =  tdmOrderIntDAO.findByCriteria(detachedCriteria);
		return tdmOrderInts.isEmpty();
	}
	
	@Override
	public List<TdmOrderInt> getTdmOrderInts(String status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TdmOrderInt.class);
		criteria.add(Restrictions.eq("sendFlag", status));
		criteria.setFetchMode("samplingDetailsInts", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return tdmOrderIntDAO.findByCriteria(criteria);
	}

	@Override
	public void updateTdmOrderInt(List<Long> seqnos, String sendFlag) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("update TdmOrderInt e set e.sendFlag = :sendFlag where e.tdmOrderIntSeqno in (:seqnos) ");
		Session session = tdmOrderIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(querySql.toString());
		query.setParameter("sendFlag", sendFlag);
		query.setParameterList("seqnos", seqnos);
		query.executeUpdate();
		session.close();
	}

	@Override
	public TdmOrderInt getTdmOrderIntByTdmNo(String tdmNo, String fromPtjCode, String fromFacilityCode){		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TdmOrderInt.class);
		detachedCriteria.add(Restrictions.eq("tdmOrderNo", tdmNo));
		detachedCriteria.add(Restrictions.eq("fromPtjCode", fromPtjCode));
		detachedCriteria.add(Restrictions.eq("fromFacilityCode", fromFacilityCode));
		
		detachedCriteria.setFetchMode("samplingDetailsInts", FetchMode.JOIN);
		List<TdmOrderInt> tdmOrderInts = tdmOrderIntDAO.findByCriteria(detachedCriteria);
		
		return tdmOrderInts != null && tdmOrderInts.size() > 0 ? tdmOrderInts.get(0) : null;
	}

}
