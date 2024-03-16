package my.com.cmg.iwp.maintenance.model.his;

import java.math.BigDecimal;

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
@Table(name = "T_EPO_DTL_STG")
public class EPODtlStg implements java.io.Serializable {
	
	@Id
	@SequenceGenerator(name="T_EPO_DTL_STG_SEQNO_GENERATOR", sequenceName="T_EPO_DTL_STG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_EPO_DTL_STG_SEQNO_GENERATOR")
	@Column(name = "EPO_DTL_SEQNO", nullable = false, precision = 22, scale = 0)
	private BigDecimal epoDtlSeqno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EPO_HDR_SEQNO", nullable = false)
	private EPOHdrStg epoHdrStg;

	@Column(name = "ITEM_CODE", length = 15)
	private String itemCode;

	@Column(name = "ORDERED_QTY", precision = 9, scale = 0)
	private Integer orderedQty;

	@Column(name = "HO_APRVED_QTY", precision = 9, scale = 0)
	private Integer hoAprvedQty;

	@Column(name = "EP_APRVED_QTY", precision = 9, scale = 0)
	private Integer epAprvedQty;

	@Column(name = "MAPPED_ITEM_CODE", length = 18)
	private String mappedItemCode;

	@Column(name = "MAPPED_ALT_UOM", length = 3)
	private String mappedAltUom;

	@Column(name = "MAPPED_GL_ACCOUNT", length = 8)
	private String mappedGlAccount;

	
	public BigDecimal getEpoDtlSeqno() {
		return epoDtlSeqno;
	}

	public void setEpoDtlSeqno(BigDecimal epoDtlSeqno) {
		this.epoDtlSeqno = epoDtlSeqno;
	}

	public EPOHdrStg getEpoHdrStg() {
		return epoHdrStg;
	}

	public void setEpoHdrStg(EPOHdrStg epoHdrStg) {
		this.epoHdrStg = epoHdrStg;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}

	public Integer getHoAprvedQty() {
		return hoAprvedQty;
	}

	public void setHoAprvedQty(Integer hoAprvedQty) {
		this.hoAprvedQty = hoAprvedQty;
	}

	public Integer getEpAprvedQty() {
		return epAprvedQty;
	}

	public void setEpAprvedQty(Integer epAprvedQty) {
		this.epAprvedQty = epAprvedQty;
	}

	public String getMappedItemCode() {
		return mappedItemCode;
	}

	public void setMappedItemCode(String mappedItemCode) {
		this.mappedItemCode = mappedItemCode;
	}

	public String getMappedAltUom() {
		return mappedAltUom;
	}

	public void setMappedAltUom(String mappedAltUom) {
		this.mappedAltUom = mappedAltUom;
	}

	public String getMappedGlAccount() {
		return mappedGlAccount;
	}

	public void setMappedGlAccount(String mappedGlAccount) {
		this.mappedGlAccount = mappedGlAccount;
	}
}
