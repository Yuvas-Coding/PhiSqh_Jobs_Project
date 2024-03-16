package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugFrequency;
import my.com.cmg.iwp.maintenance.model.Frequency;
import my.com.cmg.iwp.maintenance.model.ResultObject;

public interface DrugFrequencyService {

	DrugFrequency getNewDrugFrequency();

	void delete(DrugFrequency anDrugFrequency);

	void saveOrUpdate(DrugFrequency anDrugFrequency);

	ResultObject getAllDrugFrequenciesLikeText(String text, int i, int pageSize);

	DrugFrequency findByDefaultDrugFreq(Drug drug, boolean defaultFrequencyYn);

	DrugFrequency findByDrugFreq(Drug drug, String freqDesc);

	List<DrugFrequency> getAllListValueByFreqCode(String freqCode);

	public void deleteAll(List<DrugFrequency> drugFrequencies);

	public List<DrugFrequency> findDrugFreqByDrug(Drug drug);

	public DrugFrequency findDrugFreqByFrequency(Drug drug, Frequency frequency);

	List<DrugFrequency> getDrugFrequencyByDrug(Drug drug);

	List<DrugFrequency> getDrugFrequencyByDrugCDR(Drug drug);

}
