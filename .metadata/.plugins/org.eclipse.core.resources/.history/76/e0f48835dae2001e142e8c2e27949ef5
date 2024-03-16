package my.com.cmg.iwp.backend.service.inventory.penalty.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.inventory.penalty.PenaltyItem;
import my.com.cmg.iwp.backend.service.inventory.penalty.PenaltyItemService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
@Service
public class PenaltyItemServiceImpl implements PenaltyItemService {

	private BasisNextidDaoImpl<PenaltyItem> penaltyItemDAO;
	
	@Override
	public void saveOrUpdate(PenaltyItem penaltyItem) {
		getPenaltyItemDAO().saveOrUpdate(penaltyItem);
	}

	@Override
	public void saveOrUpdateAll(List<PenaltyItem> penaltyItems) {
		getPenaltyItemDAO().saveOrUpdateAll(penaltyItems);
	}

	@Override
	public void delete(PenaltyItem penaltyItem) {
		getPenaltyItemDAO().delete(penaltyItem);
	}

	@Override
	public void deleteAll(List<PenaltyItem> penaltyItems) {
		getPenaltyItemDAO().deleteAll(penaltyItems);
	}

	@Override
	public List<PenaltyItem> findByExample(PenaltyItem penaltyItem) {
		return getPenaltyItemDAO().findByExample(penaltyItem);
	}

	public BasisNextidDaoImpl<PenaltyItem> getPenaltyItemDAO() {
		return penaltyItemDAO;
	}

	public void setPenaltyItemDAO(BasisNextidDaoImpl<PenaltyItem> penaltyItemDAO) {
		this.penaltyItemDAO = penaltyItemDAO;
	}}
