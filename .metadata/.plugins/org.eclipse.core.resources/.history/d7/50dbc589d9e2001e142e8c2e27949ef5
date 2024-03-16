package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.MtacInfo;
import my.com.cmg.iwp.maintenance.service.MtacInfoService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class MtacInfoServiceImpl implements MtacInfoService {

	private BasisNextidDaoImpl<MtacInfo> mtacInfoDAO;

	public BasisNextidDaoImpl<MtacInfo> getMtacInfoDAO() {
		return mtacInfoDAO;
	}

	public void setMtacInfoDAO(BasisNextidDaoImpl<MtacInfo> mtacInfoDAO) {
		this.mtacInfoDAO = mtacInfoDAO;
	}
	
	@Override
	public MtacInfo getNewMtacInfo() {

		return new MtacInfo();
	}

	@Override
	public void delete(MtacInfo anMtacInfo) {

		mtacInfoDAO.delete(anMtacInfo);
	}

	@Override
	public void saveOrUpdate(MtacInfo anMtacInfo) {
		mtacInfoDAO.saveOrUpdate(anMtacInfo);
	}
	
	@Override
	public MtacInfo getMtacInfoByMtacCode(String mtacCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MtacInfo.class);
		if(StringUtils.isNotBlank(mtacCode)) {
			detachedCriteria.add(Restrictions.eq("mtacCode", mtacCode));
		}
		return DataAccessUtils.uniqueResult(mtacInfoDAO.findByCriteria(detachedCriteria));
	}
	
	@Override
	public List<MtacInfo> getAllMtacInfos() {
		return mtacInfoDAO.loadAll(MtacInfo.class);
	}

	@Override
	public List<MtacInfo> getActiveMtacInfos() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MtacInfo.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return mtacInfoDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public MtacInfo findByMtacInfoCode(String mtacCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MtacInfo.class);
		detachedCriteria.add(Restrictions.eq("mtacCode", mtacCode));
		return DataAccessUtils.uniqueResult(mtacInfoDAO.findByCriteria(detachedCriteria));
	}

}