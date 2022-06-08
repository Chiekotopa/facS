/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.request.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chieko Topa
 */
@Entity
@Table(name = "request", catalog = "facsciencedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequest")
    private Integer idrequest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ticket")
    private String ticket;
    @Size(max = 45)
    @Column(name = "statut")
    private String statut;
    @Size(max = 45)
    @Column(name = "reponse")
    private String reponse;
    @Size(max = 255)
    @Column(name = "objetrequest")
    private String objetrequest;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequest", fetch = FetchType.EAGER)
    private Collection<Notification> notificationCollection;
    @JoinColumn(name = "idpieces_jointe", referencedColumnName = "idpieces_jointe")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PiecesJointe idpiecesJointe;
    @JoinColumn(name = "idrequest_type", referencedColumnName = "idrequest_type")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RequestType idrequestType;
    @JoinColumn(name = "idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users idusers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequest", fetch = FetchType.EAGER)
    private Collection<Transfert> transfertCollection;

    public Request() {
    }

    public Request(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public Request(Integer idrequest, String ticket) {
        this.idrequest = idrequest;
        this.ticket = ticket;
    }

    public Integer getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getObjetrequest() {
        return objetrequest;
    }

    public void setObjetrequest(String objetrequest) {
        this.objetrequest = objetrequest;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    public PiecesJointe getIdpiecesJointe() {
        return idpiecesJointe;
    }

    public void setIdpiecesJointe(PiecesJointe idpiecesJointe) {
        this.idpiecesJointe = idpiecesJointe;
    }

    public RequestType getIdrequestType() {
        return idrequestType;
    }

    public void setIdrequestType(RequestType idrequestType) {
        this.idrequestType = idrequestType;
    }

    public Users getIdusers() {
        return idusers;
    }

    public void setIdusers(Users idusers) {
        this.idusers = idusers;
    }

    @XmlTransient
    public Collection<Transfert> getTransfertCollection() {
        return transfertCollection;
    }

    public void setTransfertCollection(Collection<Transfert> transfertCollection) {
        this.transfertCollection = transfertCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequest != null ? idrequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.idrequest == null && other.idrequest != null) || (this.idrequest != null && !this.idrequest.equals(other.idrequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.request.model.Request[ idrequest=" + idrequest + " ]";
    }
    
}
