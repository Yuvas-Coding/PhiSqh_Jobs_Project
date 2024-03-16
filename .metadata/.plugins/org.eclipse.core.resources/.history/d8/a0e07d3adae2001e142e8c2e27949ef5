package my.com.cmg.iwp.maintenance.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.Item;
import my.com.cmg.iwp.maintenance.model.RPSetupBrands;
import my.com.cmg.iwp.maintenance.model.RPSetupSOP;
import my.com.cmg.iwp.maintenance.model.RPSetupStrip;
import my.com.cmg.iwp.maintenance.model.RpSource;
import my.com.cmg.iwp.maintenance.service.RpSourceService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class RpSourceServiceImpl implements RpSourceService {

	private BasisNextidDaoImpl<RpSource> rpSourceDAO;
	private BasisNextidDaoImpl<Drug> drugDAO;

	public void setRpSourceDAO(BasisNextidDaoImpl<RpSource> rpSourceDAO) {
		this.rpSourceDAO = rpSourceDAO;
	}

	public BasisNextidDaoImpl<RpSource> getRpSourceDAO() {
		return rpSourceDAO;
	}

	@Override
	public RpSource getNewRpSource() {
		RpSource rpSource = new RpSource();
		rpSource.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		return new RpSource();
	}

	@Override
	public List<RpSource> getSource() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(RpSource.class);
		detachedCriteria.setFetchMode("item", FetchMode.JOIN);
		return rpSourceDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public void delete(RpSource anRpSource) {

		rpSourceDAO.delete(anRpSource);

	}

	@Override
	public void saveOrUpdate(RpSource anRpSource) {
		rpSourceDAO.saveOrUpdate(anRpSource);

	}

	@Override
	public RpSource findByRpSourceSeqno(long seqNo) {

		DetachedCriteria criteria = DetachedCriteria.forClass(RpSource.class);
		criteria.add(Restrictions.eq("rpSourceSeqno", seqNo));
		return DataAccessUtils.uniqueResult(rpSourceDAO
				.findByCriteria(criteria));
	}

	@Override
	public List<Drug> getRFDrugList() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Drug.class);
		criteria.add(Restrictions.eq("drugType", "RF"));
		return drugDAO.findByCriteria(criteria);
	}

	public BasisNextidDaoImpl<Drug> getDrugDAO() {
		return drugDAO;
	}

	public void setDrugDAO(BasisNextidDaoImpl<Drug> drugDAO) {
		this.drugDAO = drugDAO;
	}

	@Override
	public boolean checkitemPresence(Item item) {
		boolean duplicateitem=false; 
		DetachedCriteria criteria = DetachedCriteria.forClass(RpSource.class);
		criteria.add(Restrictions.eq("item", item));
		List Rpsource=rpSourceDAO.findByCriteria(criteria);
		if(Rpsource.size()>0)
		{
			duplicateitem=true;
		}
		return duplicateitem;
	}

	@Override
	public RPSetupBrands getNewRPSetupBrands() {
		RPSetupBrands rpSetupBrands = new RPSetupBrands();
		rpSetupBrands.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		return rpSetupBrands;
	}

	@Override
	public boolean isNewRPSetupBrands(RPSetupBrands rpSetupBrands) {
		return rpSetupBrands.getRpSetupBrndSeqno() == Long.MIN_VALUE;
	}

	@Override
	public RPSetupStrip getNewRPSetupStrip(RPSetupBrands rpSetupBrands) {
		RPSetupStrip rpSetupStrip = new RPSetupStrip();
		rpSetupStrip.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		rpSetupStrip.setRpSetupBrands(rpSetupBrands);
		return rpSetupStrip;
	}

	@Override
	public boolean isNewRPSetupStrip(RPSetupStrip rpSetupStrip2) {
		return rpSetupStrip2.getRpSetupStripSeqno() == Long.MIN_VALUE;
	}

	@Override
	public RPSetupSOP getNewRPSetupSOP(RPSetupBrands rpSetupBrands) {
		RPSetupSOP rpSetupSOP = new RPSetupSOP();
		rpSetupSOP.setActiveFlag(RefCodeConstant.ACTIVE_FLAG_TRUE);
		int seqNo = getMaxRPSetupSOPSequenceNo(rpSetupBrands.getRpSetupBrndSeqno());
		if(seqNo > 0) seqNo = rpSetupBrands.getRpSetupSOPs().size();
		rpSetupSOP.setSequenceNumber(seqNo+1);
		return rpSetupSOP;
	}

	@Override
	public boolean isNewRPSetupSOP(RPSetupSOP rpSetupSOP) {
		return rpSetupSOP.getRpSetupSopSeqNo() == Long.MIN_VALUE;
	}
	
	@Override
	public Integer getMaxRPSetupSOPSequenceNo(Long rpSetUpBrandsSeqNo) {
		Session session = null;
		try {
			session = getRpSourceDAO().getSessionFactory().openSession();
			Query query = session.createSQLQuery("SELECT max(sequence_number) FROM t_rp_setup_sop WHERE rp_setup_brnd_seqno = "+rpSetUpBrandsSeqNo);
			List<Object> list = query.list();
			return (list != null && list.get(0) != null ? ((BigDecimal) list.get(0)).intValue() : 0);
		} finally {
			if(session != null) session.close();
		}
	}
	
	@Override
	public boolean isNewRpSource(RpSource anRpSource) {
		return anRpSource.getRpSourceSeqno() == Long.MIN_VALUE;
	}

	@Override
	public void inActiveRpSetUpBrands(RPSetupBrands rpSetupBrands) {
		rpSetupBrands.setUpdatedDate(new Date());
		rpSetupBrands.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
		for(RPSetupSOP rpSetupSOP : rpSetupBrands.getRpSetupSOPs()) {
			rpSetupSOP.setUpdatedDate(new Date());
			rpSetupSOP.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
		}
		for(RPSetupStrip rpSetupStrip : rpSetupBrands.getRpSetupStrips()) {
			rpSetupStrip.setUpdatedDate(new Date());
			rpSetupStrip.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
		}
	}

	@Override
	public void inActiveRpSetupStrip(RPSetupStrip rpSetupStrip) {
		rpSetupStrip.setUpdatedDate(new Date());
		rpSetupStrip.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
	}

	@Override
	public void inActiveRpSetupSOP(RPSetupSOP rpSetupSOP) {
		rpSetupSOP.setUpdatedDate(new Date());
		rpSetupSOP.setActiveFlag(RefCodeConstant.STATUS_VALUE_INACTIVE.charAt(0));
	}
}
