package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.Manufacturer;
import my.com.cmg.iwp.maintenance.service.ManufacturerService;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private BasisNextidDaoImpl<Manufacturer> manufacturerDAO;

	public BasisNextidDaoImpl<Manufacturer> getManufacturerDAO() {
		return manufacturerDAO;
	}

	public void setManufacturerDAO(
			BasisNextidDaoImpl<Manufacturer> manufacturerDAO) {
		this.manufacturerDAO = manufacturerDAO;
	}

	@Override
	public Manufacturer getNewManufacturer() {
		return new Manufacturer();
	}

	@Override
	public void saveOrUpdate(Manufacturer anManufacturer) {
		getManufacturerDAO().saveOrUpdate(anManufacturer);
	}

	@Override
	public void delete(Manufacturer anManufacturer) {
		getManufacturerDAO().delete(anManufacturer);
	}

	@Override
	public List<Manufacturer> getAllManufacturers() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Manufacturer.class);
		criteria.addOrder(Order.asc("manufacturerLongName"));

		return getManufacturerDAO().findByCriteria(criteria);
	}

	public Manufacturer findByManufacturerCode(String manufacturerCode) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Manufacturer.class);
		criteria.add(Restrictions.eq("manufacturerCode", manufacturerCode));
		return DataAccessUtils.uniqueResult(manufacturerDAO
				.findByCriteria(criteria));
	}

	@Override
	public String getManufacturerNo(Manufacturer anManufacturer) {

		String requestNo = "MFG";
		String temp = "";

		// get the last reqNo
		Session session = manufacturerDAO.getSessionFactory().openSession();
		List<Manufacturer> previousManufacturer = this
				.findLastManufacturer(anManufacturer);
		// int last = (String.valueOf(previousManufacturer.size())).length();
		int seq = previousManufacturer.size();

		// if (last < 7) {
		// if (previousManufacturer.size() == 0) {
		// for (int i = 0; i < 6; i++) {
		// temp += "0";
		// }
		// } else {
		// for (int i = 0; i < 7 - last; i++) {
		// temp += "0";
		// }
		// }
		// }

		seq++;
		requestNo += String.format("%07d", seq);
		System.out.println("Manufacturer Code (Generated): " + requestNo);
		session.close();

		return requestNo;
	}

	private List<Manufacturer> findLastManufacturer(Manufacturer anManufacturer) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Manufacturer.class);
		return getManufacturerDAO().findByCriteria(criteria);
	}

	@Override
	public Manufacturer findByManufacturerName(String manufacturerName) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Manufacturer.class).add(Restrictions.sqlRestriction("rownum =1"));
		criteria.add(Restrictions.eq("manufacturerShortname", manufacturerName).ignoreCase());
		return DataAccessUtils.uniqueResult(manufacturerDAO
				.findByCriteria(criteria));
	}

	@Override
	public Manufacturer getManufacturerBySeqNo(Long manuSeqno) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(Manufacturer.class);
		criteria.add(Restrictions.eq("manuSeqno", manuSeqno));
		return DataAccessUtils.uniqueResult(manufacturerDAO
				.findByCriteria(criteria));
	}

}
