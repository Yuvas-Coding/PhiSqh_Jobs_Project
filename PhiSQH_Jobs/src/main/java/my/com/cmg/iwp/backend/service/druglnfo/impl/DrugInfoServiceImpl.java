package my.com.cmg.iwp.backend.service.druglnfo.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.backend.model.druglnfo.DiHdr;
import my.com.cmg.iwp.backend.model.druglnfo.EnquiryDetail;
import my.com.cmg.iwp.backend.service.drugInfo.DrugInfoService;
import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.webui.pharmacy.drugInformation.DrugInfoUtil;

@Service
public class DrugInfoServiceImpl implements DrugInfoService {

	private BasisNextidDaoImpl<DiHdr> diHdrDAO;
	private BasisNextidDaoImpl<EnquiryDetail> enquiryDetailDAO;

	@Override
	public DiHdr getNewDiHdr() {
		return new DiHdr();
	}

	@Override
	public List<DiHdr> findDihdr(String query) {
		return diHdrDAO.find(query);
	}

	@Override
	public List<DiHdr> getDihdr() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DiHdr.class);
		detachedCriteria.setFetchMode("enquiryDetail", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.ilike("enquiryStatus", DrugInfoUtil.ENQUIRY_STATUS_RESPONDED, MatchMode.EXACT));
		detachedCriteria.addOrder(Order.asc("enquiryDateTime"));
		return diHdrDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public DiHdr getDiHdr(long seqNo) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DiHdr.class);
		detachedCriteria.add(Restrictions.eq("enquirerSeqno", seqNo));
		return DataAccessUtils.uniqueResult(diHdrDAO.findByCriteria(detachedCriteria));
	}

	@Override
	public DiHdr findDiHdrByDeptSeqNo(long deptSeqno) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DiHdr.class);
		detachedCriteria.add(Restrictions.eq("enquiryFrom", deptSeqno));
		return DataAccessUtils.uniqueResult(diHdrDAO.findByCriteria(detachedCriteria));
	}

	@Override
	public void saveOrUpdate(EnquiryDetail enquiryDetail) {
		enquiryDetailDAO.saveOrUpdate(enquiryDetail);
	}

	@Override
	public void saveOrUpdate(DiHdr anDiHdr) {
		diHdrDAO.saveOrUpdate(anDiHdr);
	}

	@Override
	public DiHdr getDiHdrByReqNo(String diNo) {

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(DiHdr.class);
		detachedCriteria.add(Restrictions.eq("diNo", diNo));
		return DataAccessUtils.uniqueResult(diHdrDAO.findByCriteria(detachedCriteria));
	}

	public BasisNextidDaoImpl<DiHdr> getDiHdrDAO() {
		return diHdrDAO;
	}

	public void setDiHdrDAO(BasisNextidDaoImpl<DiHdr> diHdrDAO) {
		this.diHdrDAO = diHdrDAO;
	}

	public BasisNextidDaoImpl<EnquiryDetail> getEnquiryDetailDAO() {
		return enquiryDetailDAO;
	}

	public void setEnquiryDetailDAO(BasisNextidDaoImpl<EnquiryDetail> enquiryDetailDAO) {
		this.enquiryDetailDAO = enquiryDetailDAO;
	}

}
