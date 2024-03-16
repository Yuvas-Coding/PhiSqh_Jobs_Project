package my.com.cmg.iwp.maintenance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_rp_setup_sop")
public class RPSetupSOP extends BaseEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="T_RP_SETUP_SOP_SEQNO_GENERATOR", sequenceName="t_rp_setup_sop_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_RP_SETUP_SOP_SEQNO_GENERATOR")
	@Column(name="RP_SETUP_SOP_SEQNO")
	private Long rpSetupSopSeqNo = Long.MIN_VALUE;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rp_setup_brnd_seqno")
	private RPSetupBrands rpSetupBrands;
	
	@Column(name = "sequence_number")
	private Integer sequenceNumber;

	@Column(name = "procedures")
	private String procedures;
	
	public Long getRpSetupSopSeqNo() { return rpSetupSopSeqNo; }
	public void setRpSetupSopSeqNo(Long rpSetupSopSeqNo) { this.rpSetupSopSeqNo = rpSetupSopSeqNo; }
	
	public RPSetupBrands getRpSetupBrands() { return rpSetupBrands; }
	public void setRpSetupBrands(RPSetupBrands rpSetupBrands) { this.rpSetupBrands = rpSetupBrands; }
	
	public Integer getSequenceNumber() { return sequenceNumber; }
	public void setSequenceNumber(Integer sequenceNumber) { this.sequenceNumber = sequenceNumber; }
	
	public String getProcedures() { return procedures; }
	public void setProcedures(String procedures) { this.procedures = procedures; }
}
