package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ContractHdr;
import my.com.cmg.iwp.maintenance.service.ContractHdrService;

@Service
public class ContractHdrServiceImpl implements ContractHdrService {

	private BasisNextidDaoImpl<ContractHdr> ContractHdrDAO;

	public BasisNextidDaoImpl<ContractHdr> getContractHdrDAO() {
		return this.ContractHdrDAO;
	}

	public void setContractHdrDAO(final BasisNextidDaoImpl<ContractHdr> contractHdrDAO) {
		this.ContractHdrDAO = contractHdrDAO;
	}

	@Override
	public void delete(final ContractHdr anContract) {
		this.ContractHdrDAO.delete(anContract);
	}

	@Override
	public ContractHdr getNewContractHdr() {
		return new ContractHdr();
	}

	@Override
	public void saveOrUpdate(final ContractHdr anContract) {
		this.ContractHdrDAO.saveOrUpdate(anContract);
	}
	
}
