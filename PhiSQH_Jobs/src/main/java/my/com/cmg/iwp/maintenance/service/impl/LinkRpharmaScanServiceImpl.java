package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Drug;
import my.com.cmg.iwp.maintenance.model.LinkRpharmaScan;
import my.com.cmg.iwp.maintenance.service.LinkRpharmaScanService;
@Service
public class LinkRpharmaScanServiceImpl implements LinkRpharmaScanService {

	private BasisNextidDaoImpl<LinkRpharmaScan> linkRpharmaScanDAO;

	public BasisNextidDaoImpl<LinkRpharmaScan> getLinkRpharmaScanDAO() {
		return linkRpharmaScanDAO;
	}

	public void setLinkRpharmaScanDAO(
			BasisNextidDaoImpl<LinkRpharmaScan> linkRpharmaScanDAO) {
		this.linkRpharmaScanDAO = linkRpharmaScanDAO;
	}

	@Override
	public void delete(LinkRpharmaScan anLinkRpharmaScan) {
		// TODO Auto-generated method stub
		linkRpharmaScanDAO.delete(anLinkRpharmaScan);
	}

	@Override
	public LinkRpharmaScan getNewLinkRpharmaScan() {
		// TODO Auto-generated method stub
		return new LinkRpharmaScan();
	}

	@Override
	public void saveOrUpdate(LinkRpharmaScan anLinkRpharmaScan) {

		linkRpharmaScanDAO.saveOrUpdate(anLinkRpharmaScan);
	}

	@Override
	public List getAllLinkRpharmaScanByQuery() {
		String qry = "select distinct l.typeOfScan as typeOfScan from LinkRpharmaScan l order by l.typeOfScan";
		return linkRpharmaScanDAO.find(qry);
	}

	@Override
	public List<LinkRpharmaScan> getAllLinkRpharmaScan() {

		return linkRpharmaScanDAO.loadAll(LinkRpharmaScan.class);
	}

	@Override
	public List getLinkRpharmaScanByTypeOfScan(String typeOfScan) {
		String qry = "select distinct l.typeOfScan as typeOfScan from LinkRpharmaScan l where l.typeOfScan like \'%"
				+ typeOfScan + "%\'";
		return linkRpharmaScanDAO.find(qry);
	}

	public LinkRpharmaScan findbyTypeOfScan(String typeOfScan) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScan.class);
		detachedCriteria.add(Restrictions.ilike("typeOfScan", "%" + typeOfScan
				+ "%"));
		return DataAccessUtils.uniqueResult(linkRpharmaScanDAO
				.findByCriteria(detachedCriteria));

	}

	public List<LinkRpharmaScan> findAllByTypeOfScan(String typeOfScan) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScan.class);
		detachedCriteria.setFetchMode("drug", FetchMode.JOIN);
		detachedCriteria.add(Restrictions.ilike("typeOfScan", "%" + typeOfScan
				+ "%"));
		return linkRpharmaScanDAO.findByCriteria(detachedCriteria);

	}

	public LinkRpharmaScan findbyTypeOfScanAndDrug(String typeOfScan, Drug drug) {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(LinkRpharmaScan.class);
		detachedCriteria.setFetchMode("linkRpharmaScanHdrs", FetchMode.JOIN);

		DetachedCriteria creteriaHdrs = detachedCriteria
				.createCriteria("linkRpharmaScanHdrs");
		creteriaHdrs.add(Restrictions.eq("typeOfScan", typeOfScan));

		detachedCriteria.add(Restrictions.eq("drug", drug));
		List<LinkRpharmaScan> scans = linkRpharmaScanDAO.findByCriteria(detachedCriteria);
		return scans != null && !scans.isEmpty() ? scans.get(0) : null;

	}

}
