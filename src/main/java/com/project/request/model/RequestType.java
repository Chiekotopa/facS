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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chieko Topa
 */
@Entity
@Table(name = "request_type", catalog = "facsciencedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestType.findAll", query = "SELECT r FROM RequestType r")})
public class RequestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrequest_type")
    private Integer idrequestType;
    @Size(max = 45)
    @Column(name = "libele")
    private String libele;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrequestType", fetch = FetchType.EAGER)
    private Collection<Request> requestCollection;
    @JoinColumn(name = "idservice", referencedColumnName = "idservice")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Services idservice;

    public RequestType() {
    }

    public RequestType(Integer idrequestType) {
        this.idrequestType = idrequestType;
    }

    public Integer getIdrequestType() {
        return idrequestType;
    }

    public void setIdrequestType(Integer idrequestType) {
        this.idrequestType = idrequestType;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Services getIdservice() {
        return idservice;
    }

    public void setIdservice(Services idservice) {
        this.idservice = idservice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequestType != null ? idrequestType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestType)) {
            return false;
        }
        RequestType other = (RequestType) object;
        if ((this.idrequestType == null && other.idrequestType != null) || (this.idrequestType != null && !this.idrequestType.equals(other.idrequestType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.request.model.RequestType[ idrequestType=" + idrequestType + " ]";
    }
    
}
