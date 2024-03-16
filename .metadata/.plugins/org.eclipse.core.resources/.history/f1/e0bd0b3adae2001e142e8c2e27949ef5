package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.sdr.SpecialDrugTreatment;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.SpecialDrugTreatmentService;
@Service
public class SpecialDrugTreatmentServiceImpl implements
		SpecialDrugTreatmentService {

	private BasisNextidDaoImpl<SpecialDrugTreatment> specialDrugTreatmentDAO;

	@Override
	public void saveOrUpdate(SpecialDrugTreatment specialDrugTreatment) {
		this.specialDrugTreatmentDAO.saveOrUpdate(specialDrugTreatment);
	}

	public BasisNextidDaoImpl<SpecialDrugTreatment> getSpecialDrugTreatmentDAO() {
		return specialDrugTreatmentDAO;
	}

	public void setSpecialDrugTreatmentDAO(
			BasisNextidDaoImpl<SpecialDrugTreatment> specialDrugTreatmentDAO) {
		this.specialDrugTreatmentDAO = specialDrugTreatmentDAO;
	}

}
