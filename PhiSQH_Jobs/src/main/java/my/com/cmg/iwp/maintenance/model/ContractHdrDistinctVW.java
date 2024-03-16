package my.com.cmg.iwp.maintenance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTRACT_HDRS_DISTINCT_VW")
public class ContractHdrDistinctVW implements Serializable {
	
	@Id
	@Column(name="CONTRACT_NO")
	private String contractNo;
	
	@Column(name="REVISED_NO")
	private String revisedNo;

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getRevisedNo() {
		return revisedNo;
	}

	public void setRevisedNo(String revisedNo) {
		this.revisedNo = revisedNo;
	}
}
