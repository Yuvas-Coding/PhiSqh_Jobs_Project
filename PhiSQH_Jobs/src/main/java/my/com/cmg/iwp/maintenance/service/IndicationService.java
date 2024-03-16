package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.DrugIndication;
import my.com.cmg.iwp.maintenance.model.Indication;

public interface IndicationService {

	Indication getNewIndication();

	void delete(Indication anIndication);

	void saveOrUpdate(Indication anIndication);

	Indication findByIndicationCode(String indicationCode);

	Indication findByIndicationSeqno(long seqNo);

	List<DrugIndication> getDrugIndications(Indication indication);
}
