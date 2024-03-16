package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.OutsourceOrderInt;
import my.com.cmg.iwp.backend.model.integration.PatientAllergiesInt;
import my.com.cmg.iwp.backend.model.integration.PatientDiagnosisInt;
import my.com.cmg.iwp.backend.model.integration.PatientInt;
import my.com.cmg.iwp.backend.model.integration.rp.OrderRpInt;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.OutsourceOrderIntService;
@Service
public class OutsourceOrderIntServiceImpl implements OutsourceOrderIntService {

	private BasisNextidDaoImpl<OutsourceOrderInt> outsourceOrderIntDAO;
	private BasisNextidDaoImpl generalDAO;

	@Override
	public void saveOrUpdate(OutsourceOrderInt outsourceOrderInt) {

		this.outsourceOrderIntDAO.saveOrUpdate(outsourceOrderInt);
	}

	@Override
	public void save(OutsourceOrderInt outsourceOrderInt) {

		this.outsourceOrderIntDAO.save(outsourceOrderInt);
	}

	@Override
	public OutsourceOrderInt findByID(long id) {
		return this.outsourceOrderIntDAO.get(OutsourceOrderInt.class, id);
	}

	@Override
	public void save(PatientInt patientInt) {
		this.generalDAO.save(patientInt);
	}

	@Override
	public void save(OrderRpInt orderRpInt) {
		this.generalDAO.save(orderRpInt);
	}

	@Override
	public void save(PatientAllergiesInt patientAllergiesInt) {
		this.generalDAO.save(patientAllergiesInt);
	}

	@Override
	public void save(PatientDiagnosisInt patientDiagnosisInt) {
		this.generalDAO.save(patientDiagnosisInt);
	}

	@Override
	public List<OutsourceOrderInt> getOutsourceOrderInt(String orderType,
			String sendFlag) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("select distinct(e) from OutsourceOrderInt e ")
		.append(" left join fetch e.patientInt pt ")
		.append(" left join fetch e.orderRpInts orp ")
		.append(" left join fetch orp.dispenseRpBatchInts dispenseRpBatchInt ")
		.append(" left join fetch e.pnOrderRegimenInts ori")
		.append(" left join fetch ori.pnNutritionalAssmntInts nai")
		.append(" left join fetch ori.pnOrderTotalEnergyInts ptei")
		.append(" left join fetch e.patientAllergiesInts pai ")
		.append(" left join fetch e.patientDiagnosisInts pdi ")
		.append(" left join fetch e.currentstkHdrsInts chi ")
		.append(" left join fetch e.cdrDrugsInts cdrdi ")
		.append(" left join fetch cdrdi.cdrDrugsScheduleInts cdrdsi ")
		.append(" left join fetch cdrdi.cdrDispensingInts cdrdispi ")
		.append(" left join fetch chi.currentstkDtlsInts cdi ")
		.append(" left join fetch e.dispenseReasonsInts dri ")
		.append(" left join fetch e.pnPrepCalHeaderInts pchi ")
		.append(" left join fetch pchi.pnPrepCalInts pci ")
		.append(" where ")
		.append(" e.sendFlag = :sendFlag and e.preparationType = :preparationType ");
		Session session = this.generalDAO.getSessionFactory().openSession();
		Query query = session.createQuery(querySql.toString());
		query.setParameter("sendFlag", sendFlag);
		query.setParameter("preparationType", orderType);
		List<OutsourceOrderInt> results = query.list();
		session.close();
		return results;
	}

	@Override
	public void updateOutsourceOrderInt(List<Long> seqnos, String sendFlag) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("update OutsourceOrderInt e set e.sendFlag = :sendFlag where e.outsourceIntSeqno in (:seqnos) ");
		Session session = this.generalDAO.getSessionFactory().openSession();
		Query query = session.createQuery(querySql.toString());
		query.setParameter("sendFlag", sendFlag);
		query.setParameterList("seqnos", seqnos);
		query.executeUpdate();
		session.close();
	}

	public BasisNextidDaoImpl getGeneralDAO() {
		return this.generalDAO;
	}

	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
		this.generalDAO = generalDAO;
	}

	@Override
	public BasisNextidDaoImpl<OutsourceOrderInt> getOutsourceOrderIntDAO() {
		return this.outsourceOrderIntDAO;
	}

	public void setOutsourceOrderIntDAO(
			BasisNextidDaoImpl<OutsourceOrderInt> outsourceOrderIntDAO) {
		this.outsourceOrderIntDAO = outsourceOrderIntDAO;
	}
	
	@Override
	public boolean isExists(OutsourceOrderInt outsourceOrderInt) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(OutsourceOrderInt.class);
		criteria.add(Restrictions.eq("sourceOutsourceNo", outsourceOrderInt.getSourceOutsourceNo()));
		criteria.add(Restrictions.eq("referredFactFrom", outsourceOrderInt.getReferredFactFrom()));
		criteria.add(Restrictions.eq("referredFactTo", outsourceOrderInt.getReferredFactTo()));
		List<OutsourceOrderInt> lst = outsourceOrderIntDAO.findByCriteria(criteria);
		return lst.size() > 0 ? true : false;
	}
	
	@Override
	public OutsourceOrderInt findBySourceOutsourceNo(String sourceOutsourceNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(OutsourceOrderInt.class);
		detachedCriteria.add(Restrictions.eq("sourceOutsourceNo",sourceOutsourceNo));
		return DataAccessUtils.uniqueResult(this.outsourceOrderIntDAO.findByCriteria(detachedCriteria));
	}
}
