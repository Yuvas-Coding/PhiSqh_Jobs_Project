package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Faq;
import my.com.cmg.iwp.maintenance.service.FaqService;


@Service
public class FaqServiceImpl implements FaqService {
	
	private BasisNextidDaoImpl<Faq> faqDAO;

	public void setfaqDAO(BasisNextidDaoImpl<Faq> faqDAO) {
		this.faqDAO = faqDAO;
	}

	public BasisNextidDaoImpl<Faq> getRpSourceDAO() {
		return faqDAO;
	}

	@Override
	public Faq getNewFaq() {

		return new Faq();
	}

	@Override
	public List<Faq> getFaq() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Faq.class);
		return faqDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public void delete(Faq anFaq) {

		faqDAO.delete(anFaq);

	}

	@Override
	public void saveOrUpdate(Faq anFaq) {
		faqDAO.saveOrUpdate(anFaq);

	}

	@Override
	public Faq findByFaqSeqno(long seqNo) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Faq.class);
		criteria.add(Restrictions.eq("faqSeqno", seqNo));
		return DataAccessUtils.uniqueResult(faqDAO.findByCriteria(criteria));
	}

	@Override
	public boolean isFaqExists(long enquirySeqno) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Faq.class);
		criteria.add(Restrictions.eq("enquirySeqno", enquirySeqno));
		List<Faq> faqList = faqDAO.findByCriteria(criteria);
		if(null != faqList && faqList.size() > 0)
			return true;
		else
			return false;
	}

	/*@Override
	public ExternalFacility getFacilityNameforFacilityCode(String facilityCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExternalFacility.class);
		detachedCriteria.add(Restrictions.eq("facilityCode", facilityCode));
		return faqDAO.findByCriteria(detachedCriteria);
	}*/
	
	
}
