package my.com.cmg.iwp.maintenance.service.impl;

import javax.management.Query;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.HqConfig;
import my.com.cmg.iwp.maintenance.service.HQConfigService;
@Service
public class HQConfigServiceImpl implements HQConfigService {
	private BasisNextidDaoImpl<HqConfig> hqConfigDAO;

	public BasisNextidDaoImpl<HqConfig> getHqConfigDAO() {
		return hqConfigDAO;
	}

	public void setHqConfigDAO(BasisNextidDaoImpl<HqConfig> hqConfigDAO) {
		this.hqConfigDAO = hqConfigDAO;
	}

	@Override
	public HqConfig getHQConfig() {
		return getHqConfigDAO().find("from HqConfig").get(0);
	}

	@Override
	public void saveOrUpdate(HqConfig hqConfig) {
		hqConfigDAO.saveOrUpdate(hqConfig);
	}

	@Override
	public boolean isepNextGenActive() {

		String hql = "SELECT COUNT(*) FROM HqConfig WHERE isePNextGenActive='Y'";
		Query query = hqConfigDAO.getSessionFactory().getCurrentSession().createQuery(hql);
		Long isepNextGenActive = (Long) query.uniqueResult();
		return isepNextGenActive > 0;
	}
}
