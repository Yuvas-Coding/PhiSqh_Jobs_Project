package my.com.cmg.iwp.maintenance.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.PoDtl;
import my.com.cmg.iwp.maintenance.service.PoDtlService;
@Service
public class PoDtlServiceImpl implements PoDtlService{
	private BasisNextidDaoImpl<PoDtl> poDtlDAO;

	@Override
	public List<PoDtl> getAllItemByPoHdrSeqNo(Long example) {
		String query = "select all podtl "
				+ "from PoDtl podtl join fetch podtl.item as poItem "
				+ "join fetch podtl.poHdr as podtlHdr "
				 + "where podtlHdr.poHdrSeqno="
				+ example;
		return poDtlDAO.find(query);
	}
	
	
	public BasisNextidDaoImpl<PoDtl> getPoDtlDAO() {
		return poDtlDAO;
	}

	public void setPoDtlDAO(BasisNextidDaoImpl<PoDtl> poDtlDAO) {
		this.poDtlDAO = poDtlDAO;
	}
	
	
	
	
}
