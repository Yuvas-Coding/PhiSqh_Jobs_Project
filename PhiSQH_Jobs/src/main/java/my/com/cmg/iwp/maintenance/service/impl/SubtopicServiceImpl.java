package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Subtopic;
import my.com.cmg.iwp.maintenance.model.Topic;
import my.com.cmg.iwp.maintenance.service.SubtopicService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class SubtopicServiceImpl implements SubtopicService {

	private BasisNextidDaoImpl<Subtopic> subtopicDAO;

	public BasisNextidDaoImpl<Subtopic> getSubtopicDAO() {
		return subtopicDAO;
	}

	public void setSubtopicDAO(BasisNextidDaoImpl<Subtopic> subtopicDAO) {
		this.subtopicDAO = subtopicDAO;
	}
	
	@Override
	public Subtopic getNewSubtopic() {

		return new Subtopic();
	}

	@Override
	public void delete(Subtopic anSubtopic) {

		subtopicDAO.delete(anSubtopic);
	}

	@Override
	public void saveOrUpdate(Subtopic anSubtopic) {
		subtopicDAO.saveOrUpdate(anSubtopic);
	}
	
	
	@Override
	public List<Subtopic> getAllSubtopics() {
		return subtopicDAO.loadAll(Subtopic.class);
	}

	@Override
	public List<Subtopic> getActiveSubtopics() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subtopic.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return subtopicDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public Subtopic findBySubtopicCode(String subtopicCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subtopic.class);
		detachedCriteria.add(Restrictions.eq("subtopicCode", subtopicCode));
		return subtopicDAO.findByCriteria(detachedCriteria).get(0);
	}

	@Override
	public Subtopic findBySubtopicCode(String subtopicCode, Topic topic) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Subtopic.class);
		Criterion criterion1 = Restrictions.eq("subtopicCode", subtopicCode);
		Criterion criterion2 = Restrictions.eq("topic", topic);
		criteria.add(Restrictions.and(criterion1, criterion2));
		return DataAccessUtils.uniqueResult(subtopicDAO.findByCriteria(criteria));
	}

}