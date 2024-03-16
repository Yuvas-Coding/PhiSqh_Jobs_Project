package my.com.cmg.iwp.maintenance.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.NonDrug;
import my.com.cmg.iwp.maintenance.service.NonDrugService;
@Service
public class NonDrugServiceImpl implements NonDrugService {

	private BasisNextidDaoImpl<NonDrug> nonDrugDAO;

	public BasisNextidDaoImpl<NonDrug> getNonDrugDAO() {
		return nonDrugDAO;
	}

	public void setNonDrugDAO(BasisNextidDaoImpl<NonDrug> nonDrugDAO) {
		this.nonDrugDAO = nonDrugDAO;
	}

	@Override
	public NonDrug getNewNonDrug() {
		return new NonDrug();
	}

	@Override
	public void delete(NonDrug anNonDrug) {
		nonDrugDAO.delete(anNonDrug);
	}

	@Override
	public void saveOrUpdate(NonDrug anNonDrug) {
		nonDrugDAO.saveOrUpdate(anNonDrug);
	}

	@Override
	public NonDrug findByNonDrugCode(String nonDrugCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NonDrug.class);
		criteria.add(Restrictions.eq("nondrugCode", nonDrugCode));
		return DataAccessUtils.uniqueResult(nonDrugDAO.findByCriteria(criteria));
	}

	@Override
	public NonDrug findByNonDrugName(String nondrugName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NonDrug.class);
		criteria.add(Restrictions.eq("nondrugName", nondrugName));
		return DataAccessUtils.uniqueResult(nonDrugDAO.findByCriteria(criteria));
	}

	@Override
	public NonDrug findByNonDrugSeqno(long nonDrugSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NonDrug.class);
		criteria.add(Restrictions.eq("nondrugSeqno", nonDrugSeqno));
		return DataAccessUtils.uniqueResult(nonDrugDAO.findByCriteria(criteria));
	}

	@Override
	public void refresh(NonDrug anNonDrug) {
		nonDrugDAO.refresh(anNonDrug);
		nonDrugDAO.initialize(anNonDrug);
	}

	@Override
	public NonDrug getNonDrug(long nonDrugSeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(NonDrug.class);
		criteria.add(Restrictions.eq("nondrugSeqno", nonDrugSeqno));
		List<NonDrug> nondrugs = getNonDrugDAO().findByCriteria(criteria);
		return nondrugs.isEmpty() ? null : nondrugs.get(0);
	}

	@Override
	public Integer getNonDrugRunningNo(String nonDrugPrefix) throws SQLException {

//		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
//		Connection con = null;
//		con = DataSourceUtils.doGetConnection(ds);
		Session session = getNonDrugDAO().getSessionFactory().openSession();
		//String query = "select TO_NUMBER(max(substr(nondrug_code , length(nondrug_code)-3, length(nondrug_code))))+1 as max_number from t_non_drugs";
		StringBuffer query = new StringBuffer();
		query.append(" select case when max_number is null then 0 else max_number end as max_number from ( "
				+ " SELECT max(substr(nondrug_code , length(nondrug_code)-3, length(nondrug_code)))+1 as max_number ");
		query.append(" FROM T_NON_DRUGS");
		query.append(" WHERE TRIM(substr(nondrug_code , 1, length(nondrug_code)-4)) = '"+nonDrugPrefix+"')");
		System.err.println(query.toString());
		Query query1 = session.createSQLQuery(query.toString());
//		PreparedStatement ps = con.prepareStatement(query.toString());
//		ps.setString(1, nonDrugPrefix);
//		ResultSet rs = ps.executeQuery();
		Integer SeqNo = Integer.parseInt(query1.list().iterator().next().toString());
		/*Integer seq = null;

		while (rs.next()) {
			seq = rs.getInt("max_number");
		}
		con.close();*/
		session.close();
		return SeqNo;

	}
}
