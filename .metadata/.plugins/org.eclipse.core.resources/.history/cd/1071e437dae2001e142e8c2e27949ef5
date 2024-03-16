package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.CounsellingMaterial;
import my.com.cmg.iwp.maintenance.service.CounsellingMaterialService;

@Service
public class CounsellingMaterialServiceImpl implements CounsellingMaterialService {

	private BasisNextidDaoImpl<CounsellingMaterial> counsellingMaterialDAO;

	@Override
	public void saveOrUpdateCounsellingMaterial(CounsellingMaterial counsellingMaterial) {
		counsellingMaterialDAO.saveOrUpdate(counsellingMaterial);
	}

	public BasisNextidDaoImpl<CounsellingMaterial> getCounsellingMaterialDAO() {
		return counsellingMaterialDAO;
	}

	public void setCounsellingMaterialDAO(
			BasisNextidDaoImpl<CounsellingMaterial> counsellingMaterialDAO) {
		this.counsellingMaterialDAO = counsellingMaterialDAO;
	}

}
