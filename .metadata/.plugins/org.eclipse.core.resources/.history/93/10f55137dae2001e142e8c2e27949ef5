package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.LinkRpharmaScanHdrs;
import my.com.cmg.iwp.maintenance.service.LinkRpharmaScanHdrsService;
@Service
public class LinkRpharmaScanHdrsServiceImpl implements
		LinkRpharmaScanHdrsService {

	private BasisNextidDaoImpl<LinkRpharmaScanHdrs> linkRpharmaScanHdrsDAO;

	public BasisNextidDaoImpl<LinkRpharmaScanHdrs> getLinkRpharmaScanHdrsDAO() {
		return linkRpharmaScanHdrsDAO;
	}

	public void setLinkRpharmaScanHdrsDAO(
			BasisNextidDaoImpl<LinkRpharmaScanHdrs> linkRpharmaScanHdrsDAO) {
		this.linkRpharmaScanHdrsDAO = linkRpharmaScanHdrsDAO;
	}

	@Override
	public void delete(LinkRpharmaScanHdrs anLinkRpharmaScanHdrs) {
		// TODO Auto-generated method stub
		linkRpharmaScanHdrsDAO.delete(anLinkRpharmaScanHdrs);
	}

	@Override
	public LinkRpharmaScanHdrs getNewLinkRpharmaScanHdrs() {
		// TODO Auto-generated method stub
		return new LinkRpharmaScanHdrs();
	}

	@Override
	public void saveOrUpdate(LinkRpharmaScanHdrs anLinkRpharmaScanHdrs) {

		linkRpharmaScanHdrsDAO.saveOrUpdate(anLinkRpharmaScanHdrs);
	}

	@Override
	public List<LinkRpharmaScanHdrs> getAllLinkRpharmaScanHdrs() {
		// String qry =
		// "select distinct l.typeOfScan as typeOfScan from LinkRpharmaScan l order by l.typeOfScan";
		// return linkRpharmaScanHdrsDAO.loadAll(LinkRpharmaScanHdrs.class);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkRpharmaScanHdrs.class);
		detachedCriteria.addOrder(Order.desc("updatedDate"));
		return linkRpharmaScanHdrsDAO.findByCriteria(detachedCriteria);
		
	}

	@Override
	public List getLinkRpharmaScanHdrsByTypeOfScan(String typeOfScan) {
		String qry = "select distinct l.typeOfScan as typeOfScan from LinkRpharmaScan l where l.typeOfScan like \'%"
				+ typeOfScan + "%\'";
		return linkRpharmaScanHdrsDAO.find(qry);
	}

	public LinkRpharmaScanHdrs findbyTypeOfScan(String typeOfScan) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScanHdrs.class);
		detachedCriteria.add(Restrictions.sqlRestriction("UPPER(type_of_scan) = '" +  typeOfScan.toUpperCase() +"'"));
		List list = linkRpharmaScanHdrsDAO.findByCriteria(detachedCriteria);
		LinkRpharmaScanHdrs returnObject =  list.isEmpty() ? null : (LinkRpharmaScanHdrs)list.get(0);
		return returnObject;

	}
	
	public LinkRpharmaScanHdrs findTypeOfScanbySeqno (long seqno) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScanHdrs.class);
		detachedCriteria.add(Restrictions.sqlRestriction("link_hdrs_seqno = '" +  seqno +"'"));
		List list = linkRpharmaScanHdrsDAO.findByCriteria(detachedCriteria);
		LinkRpharmaScanHdrs returnObject =  list.isEmpty() ? null : (LinkRpharmaScanHdrs)list.get(0);
		return returnObject;
	}

	public List<LinkRpharmaScanHdrs> findAllByTypeOfScan(String typeOfScan) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScanHdrs.class);
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.ilike("typeOfScan", "%" + typeOfScan
				+ "%"));
		return linkRpharmaScanHdrsDAO.findByCriteria(detachedCriteria);

	}

	public List<LinkRpharmaScanHdrs> getAllActiveLinkRpharmaScanHdrs() {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScanHdrs.class);
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.eq("activeFlag", 'A'));
		return linkRpharmaScanHdrsDAO.findByCriteria(detachedCriteria);
	}

}
