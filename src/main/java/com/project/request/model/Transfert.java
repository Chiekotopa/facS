/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.request.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chieko Topa
 */
@Entity
@Table(name = "transfert", catalog = "facsciencedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfert.findAll", query = "SELECT t FROM Transfert t")})
public class Transfert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransfert")
    private Integer idtransfert;
    @Size(max = 45)
    @Column(name = "reponse")
    private String reponse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "service_recive")
    private String serviceRecive;
    @JoinColumn(name = "id_service_send", referencedColumnName = "idservice")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Services idServiceSend;
    @JoinColumn(name = "idrequest", referencedColumnName = "idrequest")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Request idrequest;

    public Transfert() {
    }

    public Transfert(Integer idtransfert) {
        this.idtransfert = idtransfert;
    }

    public Transfert(Integer idtransfert, String serviceRecive) {
        this.idtransfert = idtransfert;
        this.serviceRecive = serviceRecive;
    }

    public Integer getIdtransfert() {
        return idtransfert;
    }

    public void setIdtransfert(Integer idtransfert) {
        this.idtransfert = idtransfert;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getServiceRecive() {
        return serviceRecive;
    }

    public void setServiceRecive(String serviceRecive) {
        this.serviceRecive = serviceRecive;
    }

    public Services getIdServiceSend() {
        return idServiceSend;
    }

    public void setIdServiceSend(Services idServiceSend) {
        this.idServiceSend = idServiceSend;
    }

    public Request getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(Request idrequest) {
        this.idrequest = idrequest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransfert != null ? idtransfert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfert)) {
            return false;
        }
        Transfert other = (Transfert) object;
        if ((this.idtransfert == null && other.idtransfert != null) || (this.idtransfert != null && !this.idtransfert.equals(other.idtransfert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.request.model.Transfert[ idtransfert=" + idtransfert + " ]";
    }
    
}
