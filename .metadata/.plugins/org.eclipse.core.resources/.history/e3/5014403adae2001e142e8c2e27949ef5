package my.com.cmg.iwp.maintenance.service;

import java.sql.SQLException;

import my.com.cmg.iwp.maintenance.model.NonDrug;

public interface NonDrugService {

	NonDrug getNewNonDrug();

	void delete(NonDrug anNonDrug);

	void saveOrUpdate(NonDrug anNonDrug);

	NonDrug findByNonDrugCode(String nonDrugCode);

	NonDrug findByNonDrugName(String nondrugName);

	NonDrug findByNonDrugSeqno(long nonDrugSeqno);

	NonDrug getNonDrug(long nonDrugSeqno);

	void refresh(NonDrug anNonDrug);

	Integer getNonDrugRunningNo(String nonDrugPrefix) throws SQLException;
}
