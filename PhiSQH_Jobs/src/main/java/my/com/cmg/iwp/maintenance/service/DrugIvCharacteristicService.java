package my.com.cmg.iwp.maintenance.service;

import java.util.List;

import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugIvCharacteristic;

public interface DrugIvCharacteristicService {
	
	DrugIvCharacteristic getNewDrugIvCharacteristic();
	
	void delete(DrugIvCharacteristic anDrugIvCharacteristic);

	void saveOrUpdate(DrugIvCharacteristic anDrugIvCharacteristic);
	
	List<DrugIvCharacteristic> getAllDrugIvCharacteristics(Drug ivDrug);
	
	List<DrugIvCharacteristic> findByFluidSeqno(long fluidDrugSeqno);

	List<DrugIvCharacteristic> getAllDrugIvCharacteristics();
	
	List<DrugIvCharacteristic> findByDefaultDrugIvCharacteristic(Drug drug, boolean defaultDrug);

	DrugIvCharacteristic findByDrugAndIVDrug(Drug fluidDrug, Drug ivDrug);

	void deleteAll(List<DrugIvCharacteristic> listDrugIv);

}