package my.com.cmg.iwp.backend.service.integration.indent.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.integration.indent.IndentDtlsInt;
import my.com.cmg.iwp.backend.model.integration.indent.IndentHdrsInt;
import my.com.cmg.iwp.backend.model.integration.indent.SpubPatientInfoInt;
import my.com.cmg.iwp.backend.service.integration.indent.IndentIntService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class IndentIntServiceImpl implements IndentIntService {

	private BasisNextidDaoImpl<IndentHdrsInt> indentHdrsIntDAO;
	private BasisNextidDaoImpl<IndentDtlsInt> indentDtlsIntDAO;
	private BasisNextidDaoImpl generalDAO;

	@Override
	public void saveOrUpdate(IndentHdrsInt indentHdrsInt) {
		this.indentHdrsIntDAO.save(indentHdrsInt);
	}

	@Override
	public void saveOrUpdate(IndentDtlsInt indentDtlsInt) {
		this.indentDtlsIntDAO.save(indentDtlsInt);
	}

	@Override
	public List<IndentHdrsInt> getAllSendIndent() {
		//		DetachedCriteria detachedCriteria = DetachedCriteria
		//				.forClass(IndentHdrsInt.class);
		//		detachedCriteria.add(Restrictions.eq("sendFlag",
		//				RefCodeConstant.BOOLEAN_YES));
		//		detachedCriteria.setFetchMode("indentDtlsInts", FetchMode.JOIN);
		//		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//		return indentHdrsIntDAO.findByCriteria(detachedCriteria);
		StringBuilder querySql = new StringBuilder();
		querySql.append("select distinct e from IndentHdrsInt e ")
		.append(" inner join fetch e.indentDtlsInts dtli ")
		//.append(" left join fetch dtli.spubPatientInfoInts info")
		.append(" where ")
		.append(" e.sendFlag = :sendFlag ");
		/*.append(" AND ")
		.append(" INDENT_STATUS = 'Open'")
		.append(" AND ")
		.append(" APPROVAL_STATUS = 'Appr'");*/
		Session session = this.indentHdrsIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(querySql.toString());
		query.setParameter("sendFlag", RefCodeConstant.BOOLEAN_YES);
		List<IndentHdrsInt> results = query.list();
		session.close();
		return results;
	}

	@Override
	public void updateIndentHdrsInt(String sendFlagValue, String ptjCode,
			String factCode) {

	}

	@Override
	public void updateSendFlag(String sendFlagValue, String ptjCode,
			String factCode) {
		StringBuilder updateStr = new StringBuilder();
		updateStr
		.append("update IndentHdrsInt e ")
		.append(" set ")
		.append(" e.sendFlag = :sendFlagValue")
		.append(" where ")
		.append(" e.toFacilityCode = :factCode and e.toPtjCode = :ptjCode ");
		Session session = this.indentHdrsIntDAO.getSessionFactory().openSession();
		org.hibernate.query.Query query = session.createQuery(updateStr.toString());

		query.setParameter("sendFlagValue", sendFlagValue);
		query.setParameter("factCode", factCode);
		query.setParameter("ptjCode", ptjCode);
		query.executeUpdate();
		session.close();

	}

	public BasisNextidDaoImpl<IndentHdrsInt> getIndentHdrsIntDAO() {
		return this.indentHdrsIntDAO;
	}

	public void setIndentHdrsIntDAO(
			BasisNextidDaoImpl<IndentHdrsInt> indentHdrsIntDAO) {
		this.indentHdrsIntDAO = indentHdrsIntDAO;
	}

	public BasisNextidDaoImpl<IndentDtlsInt> getIndentDtlsIntDAO() {
		return this.indentDtlsIntDAO;
	}

	public void setIndentDtlsIntDAO(
			BasisNextidDaoImpl<IndentDtlsInt> indentDtlsIntDAO) {
		this.indentDtlsIntDAO = indentDtlsIntDAO;
	}

	public BasisNextidDaoImpl getGeneralDAO() {
		return generalDAO;
	}

	public void setGeneralDAO(BasisNextidDaoImpl generalDAO) {
		this.generalDAO = generalDAO;
	}

	@Override
	public void saveOrUpdate(SpubPatientInfoInt spubPatientInfoInt) {
		System.out.println("Inside spub save");
		generalDAO.save(spubPatientInfoInt);	
	}
	
	@Override
	public List<SpubPatientInfoInt> getSpubPatientInfoByDtl(IndentDtlsInt indentDtlsInt) {
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SpubPatientInfoInt.class);
				detachedCriteria.add(Restrictions.eq("indentDtlsInt",indentDtlsInt));
				detachedCriteria.setResultTransformer(detachedCriteria.DISTINCT_ROOT_ENTITY);
				return generalDAO.findByCriteria(detachedCriteria);
	}
}
