package my.com.cmg.iwp.maintenance.service;

import my.com.cmg.iwp.maintenance.model.ContractDtl;

public interface ContractDtlService {

	void delete(ContractDtl anContractDtl);

	ContractDtl getNewContractDtl();

	void saveOrUpdate(ContractDtl anContractDtl);

}