package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Topic;
import my.com.cmg.iwp.maintenance.service.TopicService;
import my.com.cmg.iwp.webui.constant.RefCodeConstant;
@Service
public class TopicServiceImpl implements TopicService {

	private BasisNextidDaoImpl<Topic> topicDAO;

	public BasisNextidDaoImpl<Topic> getTopicDAO() {
		return topicDAO;
	}

	public void setTopicDAO(BasisNextidDaoImpl<Topic> topicDAO) {
		this.topicDAO = topicDAO;
	}
	
	@Override
	public Topic getNewTopic() {

		return new Topic();
	}

	@Override
	public void delete(Topic anTopic) {

		topicDAO.delete(anTopic);
	}

	@Override
	public void saveOrUpdate(Topic anTopic) {
		topicDAO.saveOrUpdate(anTopic);
	}
	
	
	@Override
	public List<Topic> getAllTopics() {
		return topicDAO.loadAll(Topic.class);
	}

	@Override
	public List<Topic> getActiveTopics() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Topic.class);
		detachedCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.add(Restrictions.eq("activeFlag", RefCodeConstant.ACTIVE_FLAG_TRUE));
		return topicDAO.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Topic> findByTopicCode(String topicCode) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Topic.class);
		detachedCriteria.add(Restrictions.eq("topicCode", topicCode));
		return topicDAO.findByCriteria(detachedCriteria);
	}

}