package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.sdr.SpecialDrugPatient;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.service.SpecialDrugPatientService;
@Service
public class SpecialDrugPatientServiceImpl implements SpecialDrugPatientService {

	private BasisNextidDaoImpl<SpecialDrugPatient> specialDrugPatientDAO;

	@Override
	public void saveOrUpdate(SpecialDrugPatient specialDrugPatient) {
		this.specialDrugPatientDAO.saveOrUpdate(specialDrugPatient);
	}

	public BasisNextidDaoImpl<SpecialDrugPatient> getSpecialDrugPatientDAO() {
		return specialDrugPatientDAO;
	}

	public void setSpecialDrugPatientDAO(
			BasisNextidDaoImpl<SpecialDrugPatient> specialDrugPatientDAO) {
		this.specialDrugPatientDAO = specialDrugPatientDAO;
	}

}
