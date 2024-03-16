package my.com.cmg.iwp.maintenance.service.impl;

import org.springframework.stereotype.Service;

import my.com.cmg.iwp.maintenance.dao.impl.BasisNextidDaoImpl;
import my.com.cmg.iwp.maintenance.model.ContractDtl;
import my.com.cmg.iwp.maintenance.service.ContractDtlService;


@Service
public class ContractDtlServiceImpl implements ContractDtlService {

	private BasisNextidDaoImpl<ContractDtl> ContractDtlDAO;

	public void setContractDtlDAO(BasisNextidDaoImpl<ContractDtl> contractDtlDAO) {
		ContractDtlDAO = contractDtlDAO;
	}

	public BasisNextidDaoImpl<ContractDtl> getContractDtlDAO() {
		return ContractDtlDAO;
	}

	@Override
	public void delete(ContractDtl anContractDtl) {
		ContractDtlDAO.delete(anContractDtl);
	}

	@Override
	public ContractDtl getNewContractDtl() {
		return new ContractDtl();
	}

	@Override
	public void saveOrUpdate(ContractDtl anContractDtl) {

		ContractDtlDAO.saveOrUpdate(anContractDtl);

	}

}
