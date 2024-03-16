package my.com.cmg.iwp.backend.model.sdr;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.com.cmg.iwp.maintenance.model.GetterBaseEntity;

@Entity
@Table(name = "t_spl_drug_approval")
public class SpecialDrugApproval extends GetterBaseEntity {

	private long splDrugApprovalSeqno = Long.MIN_VALUE;
	private Character splCategory;
	private Character splType;
	private BigDecimal splAmountLess;
	private String splCompareLess;
	private BigDecimal splAmountGreater;
	private String splCompareGreater;
	private String splApprover;
	private String splStatus;
	
	@Id
	@Column(name = "spl_drug_approval_seqno", unique = true, nullable = false, precision = 38, scale = 0)
	@SequenceGenerator(name = "splDrugApprovalSeqno", sequenceName = "t_spl_drug_approval_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "splDrugApprovalSeqno")
	public long getSplDrugApprovalSeqno() {
		return splDrugApprovalSeqno;
	}
	public void setSplDrugApprovalSeqno(long splDrugApprovalSeqno) {
		this.splDrugApprovalSeqno = splDrugApprovalSeqno;
	}
	
	@Column(name = "spl_category")
	public Character getSplCategory() {
		return splCategory;
	}
	public void setSplCategory(Character splCategory) {
		this.splCategory = splCategory;
	}
	
	@Column(name = "spl_type")
	public Character getSplType() {
		return splType;
	}
	public void setSplType(Character splType) {
		this.splType = splType;
	}
	
	@Column(name = "spl_amount_less")
	public BigDecimal getSplAmountLess() {
		return splAmountLess;
	}
	public void setSplAmountLess(BigDecimal splAmountLess) {
		this.splAmountLess = splAmountLess;
	}
	
	@Column(name = "spl_compare_less")
	public String getSplCompareLess() {
		return splCompareLess;
	}
	public void setSplCompareLess(String splCompareLess) {
		this.splCompareLess = splCompareLess;
	}
	
	@Column(name = "spl_amount_greater")
	public BigDecimal getSplAmountGreater() {
		return splAmountGreater;
	}
	public void setSplAmountGreater(BigDecimal splAmountGreater) {
		this.splAmountGreater = splAmountGreater;
	}
	
	@Column(name = "spl_compare_greater")
	public String getSplCompareGreater() {
		return splCompareGreater;
	}
	public void setSplCompareGreater(String splCompareGreater) {
		this.splCompareGreater = splCompareGreater;
	}
	@Column(name = "spl_approver")
	public String getSplApprover() {
		return splApprover;
	}
	public void setSplApprover(String splApprover) {
		this.splApprover = splApprover;
	}
	
	@Column(name = "spl_status")
	public String getSplStatus() {
		return splStatus;
	}
	public void setSplStatus(String splStatus) {
		this.splStatus = splStatus;
	}
}
