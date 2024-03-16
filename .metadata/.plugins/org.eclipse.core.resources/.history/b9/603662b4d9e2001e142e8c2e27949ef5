/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.com.cmg.iwp.maintenance.model.report.stg;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "T_PO_SUMMARY_STG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPoSummaryStg.findAll", query = "SELECT t FROM TPoSummaryStg t"),
    @NamedQuery(name = "TPoSummaryStg.findByPoSummaryStgSeqno", query = "SELECT t FROM TPoSummaryStg t WHERE t.poSummaryStgSeqno = :poSummaryStgSeqno"),
    @NamedQuery(name = "TPoSummaryStg.findByPurchaseOrderNo", query = "SELECT t FROM TPoSummaryStg t WHERE t.purchaseOrderNo = :purchaseOrderNo"),
    @NamedQuery(name = "TPoSummaryStg.findByFacilityCode", query = "SELECT t FROM TPoSummaryStg t WHERE t.facilityCode = :facilityCode"),
    @NamedQuery(name = "TPoSummaryStg.findByFacilityName", query = "SELECT t FROM TPoSummaryStg t WHERE t.facilityName = :facilityName"),
    @NamedQuery(name = "TPoSummaryStg.findByPtjCode", query = "SELECT t FROM TPoSummaryStg t WHERE t.ptjCode = :ptjCode"),
    @NamedQuery(name = "TPoSummaryStg.findByPtjName", query = "SELECT t FROM TPoSummaryStg t WHERE t.ptjName = :ptjName"),
    @NamedQuery(name = "TPoSummaryStg.findByReqNo", query = "SELECT t FROM TPoSummaryStg t WHERE t.reqNo = :reqNo"),
    @NamedQuery(name = "TPoSummaryStg.findByEpoSendToEp", query = "SELECT t FROM TPoSummaryStg t WHERE t.epoSendToEp = :epoSendToEp"),
    @NamedQuery(name = "TPoSummaryStg.findByKodAkaunGl", query = "SELECT t FROM TPoSummaryStg t WHERE t.kodAkaunGl = :kodAkaunGl"),
    @NamedQuery(name = "TPoSummaryStg.findByEpContractNo", query = "SELECT t FROM TPoSummaryStg t WHERE t.epContractNo = :epContractNo"),
    @NamedQuery(name = "TPoSummaryStg.findByKodProjek", query = "SELECT t FROM TPoSummaryStg t WHERE t.kodProjek = :kodProjek"),
    @NamedQuery(name = "TPoSummaryStg.findByPoIndicator", query = "SELECT t FROM TPoSummaryStg t WHERE t.poIndicator = :poIndicator"),
    @NamedQuery(name = "TPoSummaryStg.findByKodProgram", query = "SELECT t FROM TPoSummaryStg t WHERE t.kodProgram = :kodProgram"),
    @NamedQuery(name = "TPoSummaryStg.findByLpoNo", query = "SELECT t FROM TPoSummaryStg t WHERE t.lpoNo = :lpoNo"),
    @NamedQuery(name = "TPoSummaryStg.findByLpoDate", query = "SELECT t FROM TPoSummaryStg t WHERE t.lpoDate = :lpoDate"),
    @NamedQuery(name = "TPoSummaryStg.findByLpoTransmittedDate", query = "SELECT t FROM TPoSummaryStg t WHERE t.lpoTransmittedDate = :lpoTransmittedDate"),
    @NamedQuery(name = "TPoSummaryStg.findByEpRejectRemarks", query = "SELECT t FROM TPoSummaryStg t WHERE t.epRejectRemarks = :epRejectRemarks"),
    @NamedQuery(name = "TPoSummaryStg.findByNepVoteCode", query = "SELECT t FROM TPoSummaryStg t WHERE t.nepVoteCode = :nepVoteCode"),
    @NamedQuery(name = "TPoSummaryStg.findByDelToCode", query = "SELECT t FROM TPoSummaryStg t WHERE t.delToCode = :delToCode"),
    @NamedQuery(name = "TPoSummaryStg.findByOrderedDate", query = "SELECT t FROM TPoSummaryStg t WHERE t.orderedDate = :orderedDate"),
    @NamedQuery(name = "TPoSummaryStg.findBySentToEpDate", query = "SELECT t FROM TPoSummaryStg t WHERE t.sentToEpDate = :sentToEpDate"),
    @NamedQuery(name = "TPoSummaryStg.findByUpdatedBy", query = "SELECT t FROM TPoSummaryStg t WHERE t.updatedBy = :updatedBy"),
    @NamedQuery(name = "TPoSummaryStg.findByUpdatedDate", query = "SELECT t FROM TPoSummaryStg t WHERE t.updatedDate = :updatedDate")})
public class TPoSummaryStg implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PO_SUMMARY_STG_SEQNO", nullable = false, precision = 38, scale = 0)
    private BigDecimal poSummaryStgSeqno;
    @Column(name = "PURCHASE_ORDER_NO", length = 20)
    private String purchaseOrderNo;
    @Column(name = "FACILITY_CODE", length = 20)
    private String facilityCode;
    @Column(name = "FACILITY_NAME", length = 50)
    private String facilityName;
    @Column(name = "PTJ_CODE", length = 15)
    private String ptjCode;
    @Column(name = "PTJ_NAME", length = 100)
    private String ptjName;
    @Column(name = "REQ_NO", length = 20)
    private String reqNo;
    @Column(name = "EPO_SEND_TO_EP")
    private Character epoSendToEp;
    @Column(name = "KOD_AKAUN_GL", length = 8)
    private String kodAkaunGl;
    @Column(name = "EP_CONTRACT_NO", length = 17)
    private String epContractNo;
    @Column(name = "KOD_PROJEK", length = 16)
    private String kodProjek;
    @Column(name = "PO_INDICATOR")
    private Character poIndicator;
    @Column(name = "KOD_PROGRAM", length = 9)
    private String kodProgram;
    @Column(name = "LPO_NO", length = 22)
    private String lpoNo;
    @Column(name = "LPO_DATE")
    @Temporal(TemporalType.DATE)
    private Date lpoDate;
    @Column(name = "LPO_TRANSMITTED_DATE")
    @Temporal(TemporalType.DATE)
    private Date lpoTransmittedDate;
    @Column(name = "EP_REJECT_REMARKS", length = 100)
    private String epRejectRemarks;
    @Column(name = "NEP_VOTE_CODE", length = 5)
    private String nepVoteCode;
    @Column(name = "DEL_TO_CODE", length = 10)
    private String delToCode;
    @Column(name = "ORDERED_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderedDate;
    @Column(name = "SENT_TO_EP_DATE")
    @Temporal(TemporalType.DATE)
    private Date sentToEpDate;
    @Column(name = "UPDATED_BY")
    private BigInteger updatedBy;
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public TPoSummaryStg() {
    }

    public TPoSummaryStg(BigDecimal poSummaryStgSeqno) {
        this.poSummaryStgSeqno = poSummaryStgSeqno;
    }

    public BigDecimal getPoSummaryStgSeqno() {
        return poSummaryStgSeqno;
    }

    public void setPoSummaryStgSeqno(BigDecimal poSummaryStgSeqno) {
        this.poSummaryStgSeqno = poSummaryStgSeqno;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getPtjCode() {
        return ptjCode;
    }

    public void setPtjCode(String ptjCode) {
        this.ptjCode = ptjCode;
    }

    public String getPtjName() {
        return ptjName;
    }

    public void setPtjName(String ptjName) {
        this.ptjName = ptjName;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public Character getEpoSendToEp() {
        return epoSendToEp;
    }

    public void setEpoSendToEp(Character epoSendToEp) {
        this.epoSendToEp = epoSendToEp;
    }

    public String getKodAkaunGl() {
        return kodAkaunGl;
    }

    public void setKodAkaunGl(String kodAkaunGl) {
        this.kodAkaunGl = kodAkaunGl;
    }

    public String getEpContractNo() {
        return epContractNo;
    }

    public void setEpContractNo(String epContractNo) {
        this.epContractNo = epContractNo;
    }

    public String getKodProjek() {
        return kodProjek;
    }

    public void setKodProjek(String kodProjek) {
        this.kodProjek = kodProjek;
    }

    public Character getPoIndicator() {
        return poIndicator;
    }

    public void setPoIndicator(Character poIndicator) {
        this.poIndicator = poIndicator;
    }

    public String getKodProgram() {
        return kodProgram;
    }

    public void setKodProgram(String kodProgram) {
        this.kodProgram = kodProgram;
    }

    public String getLpoNo() {
        return lpoNo;
    }

    public void setLpoNo(String lpoNo) {
        this.lpoNo = lpoNo;
    }

    public Date getLpoDate() {
        return lpoDate;
    }

    public void setLpoDate(Date lpoDate) {
        this.lpoDate = lpoDate;
    }

    public Date getLpoTransmittedDate() {
        return lpoTransmittedDate;
    }

    public void setLpoTransmittedDate(Date lpoTransmittedDate) {
        this.lpoTransmittedDate = lpoTransmittedDate;
    }

    public String getEpRejectRemarks() {
        return epRejectRemarks;
    }

    public void setEpRejectRemarks(String epRejectRemarks) {
        this.epRejectRemarks = epRejectRemarks;
    }

    public String getNepVoteCode() {
        return nepVoteCode;
    }

    public void setNepVoteCode(String nepVoteCode) {
        this.nepVoteCode = nepVoteCode;
    }

    public String getDelToCode() {
        return delToCode;
    }

    public void setDelToCode(String delToCode) {
        this.delToCode = delToCode;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getSentToEpDate() {
        return sentToEpDate;
    }

    public void setSentToEpDate(Date sentToEpDate) {
        this.sentToEpDate = sentToEpDate;
    }

    public BigInteger getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(BigInteger updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poSummaryStgSeqno != null ? poSummaryStgSeqno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPoSummaryStg)) {
            return false;
        }
        TPoSummaryStg other = (TPoSummaryStg) object;
        if ((this.poSummaryStgSeqno == null && other.poSummaryStgSeqno != null) || (this.poSummaryStgSeqno != null && !this.poSummaryStgSeqno.equals(other.poSummaryStgSeqno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my.com.cmg.iwp.maintenance.model.report.stg.TPoSummaryStg[ poSummaryStgSeqno=" + poSummaryStgSeqno + " ]";
    }
    
}
