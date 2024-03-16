package my.com.cmg.iwp.maintenance.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.DrugIvCharacteristic;
import my.com.cmg.iwp.maintenance.service.DrugIvCharacteristicService;
@Service
public class DrugIvCharacteristicServiceImpl implements
		DrugIvCharacteristicService {

	private BasisNextidDaoImpl<DrugIvCharacteristic> drugIvCharacteristicDAO;

	@Override
	public DrugIvCharacteristic getNewDrugIvCharacteristic() {
		DrugIvCharacteristic drugIvCharacteristic = new DrugIvCharacteristic();
		drugIvCharacteristic.setCreatedDate(new Date());
		return drugIvCharacteristic;
	}

	@Override
	public void delete(DrugIvCharacteristic anDrugIvCharacteristic) {
		drugIvCharacteristicDAO.delete(anDrugIvCharacteristic);

	}

	@Override
	public void saveOrUpdate(DrugIvCharacteristic anDrugIvCharacteristic) {
		drugIvCharacteristicDAO.saveOrUpdate(anDrugIvCharacteristic);

	}

	public void setDrugIvCharacteristicDAO(
			BasisNextidDaoImpl<DrugIvCharacteristic> drugIvCharacteristicDAO) {
		this.drugIvCharacteristicDAO = drugIvCharacteristicDAO;
	}

	public BasisNextidDaoImpl<DrugIvCharacteristic> getDrugIvCharacteristicDAO() {
		return drugIvCharacteristicDAO;
	}

	@Override
	public List<DrugIvCharacteristic> getAllDrugIvCharacteristics() {
		return drugIvCharacteristicDAO.loadAll(DrugIvCharacteristic.class);
	}

	@Override
	public List<DrugIvCharacteristic> findByDefaultDrugIvCharacteristic(
			Drug drug, boolean defaultDrug) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugIvCharacteristic.class);
		Criterion crit1 = Restrictions.eq("drugSeqno", drug.getDrugSeqno());
		Criterion crit2 = Restrictions.eq("defaultYn", defaultDrug);
		criteria.add(Restrictions.and(crit1, crit2));
		return drugIvCharacteristicDAO.findByCriteria(criteria);

	}

	@Override
	public List<DrugIvCharacteristic> getAllDrugIvCharacteristics(Drug ivDrug) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DrugIvCharacteristic.class);
		criteria.setFetchMode("ivDrug", FetchMode.JOIN);
		criteria.setFetchMode("fluidDrug", FetchMode.JOIN);
		criteria.add(Restrictions.eq("ivDrug", ivDrug));
		return drugIvCharacteristicDAO.findByCriteria(criteria);
	}

	@Override
	public List<DrugIvCharacteristic> findByFluidSeqno(long fluidDrugSeqno) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(DrugIvCharacteristic.class);
		criteria.add(Restrictions.eq("fluidDrugSeqno", fluidDrugSeqno));
		criteria.setFetchMode("ivDrug", FetchMode.JOIN);
		return drugIvCharacteristicDAO.findByCriteria(criteria);
	}

	@Override
	public DrugIvCharacteristic findByDrugAndIVDrug(Drug fluidDrug, Drug ivDrug) {
		if(ivDrug != null && fluidDrug != null && ivDrug.getDrugIvCharacteristic() != null && ivDrug.getDrugIvCharacteristic().size() > 0) {
			for(DrugIvCharacteristic drugIvCharacteristic : ivDrug.getDrugIvCharacteristic()) {
				if(drugIvCharacteristic.getFluidDrugSeqno() == fluidDrug.getDrugSeqno()) {
					return drugIvCharacteristic;
				}
			}
		}
		return null;
	}

	@Override
	public void deleteAll(List<DrugIvCharacteristic> listDrugIv) {

		drugIvCharacteristicDAO.deleteAll(listDrugIv);

	}

}