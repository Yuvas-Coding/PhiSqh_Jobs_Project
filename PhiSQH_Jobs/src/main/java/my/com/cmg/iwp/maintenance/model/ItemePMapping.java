package my.com.cmg.iwp.maintenance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_item_ep_mapping", uniqueConstraints = @UniqueConstraint(columnNames = "map_seqno"))
public class ItemePMapping implements java.io.Serializable {

	private static final long serialVersionUID = 5451073573592681360L;
	private long mapSeqno = Long.MIN_VALUE;
	private String UNSPCCode;
	private Character activeFlag = 'A';
	private long createdBy = 0;
	private Date createdDate;
	private long updatedBy = 0;
	private Date updatedDate;
	private Item item;
	private AltUom alternateUOMSeqno;

	public ItemePMapping() {
	}

	public ItemePMapping(Item item, long mapSeqno,  AltUom alternateUOMSeqno, String UNSPCCode, long createdBy, Date createdDate, long updatedBy, Date updatedDate) {
		
		this.item = item;
		this.mapSeqno = mapSeqno;
		this.alternateUOMSeqno = alternateUOMSeqno;
		this.UNSPCCode = UNSPCCode;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public ItemePMapping(Item item, long mapSeqno,  AltUom alternateUOMSeqno, String UNSPCCode, Character activeFlag, long createdBy, Date createdDate, long updatedBy, Date updatedDate) {

		this.item = item;
		this.mapSeqno = mapSeqno;
		this.alternateUOMSeqno = alternateUOMSeqno;
		this.UNSPCCode = UNSPCCode;
		this.activeFlag = activeFlag;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "map_seqno", unique = true, nullable = false)
	@SequenceGenerator(name = "epMappingSEQ", sequenceName = "t_item_ep_mapping_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "epMappingSEQ")
	public long getMapSeqno() {
		return this.mapSeqno;
	}

	public void setMapSeqno(long mapSeqno) {
		this.mapSeqno = mapSeqno;
	}	

	@ManyToOne
	@JoinColumn(name = "alt_uom_seqno")
	public AltUom getAlternateUOMSeqno() {
		return this.alternateUOMSeqno;
	}

	public void setAlternateUOMSeqno(AltUom alternateUOMSeqno) {
		this.alternateUOMSeqno = alternateUOMSeqno;
	}

	@Column(name = "unspc_code")
	public String getUNSPCCode() {
		return this.UNSPCCode;
	}

	public void setUNSPCCode(String uNSPCCode) {
		UNSPCCode = uNSPCCode;
	}

	@Column(name = "active_flag")
	public Character getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(Character activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_SEQNO")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
