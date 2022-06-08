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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chieko Topa
 */
@Entity
@Table(name = "pieces_jointe", catalog = "facsciencedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PiecesJointe.findAll", query = "SELECT p FROM PiecesJointe p")})
public class PiecesJointe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpieces_jointe")
    private Integer idpiecesJointe;
    @Lob
    @Column(name = "pieces_jointe")
    private byte[] piecesJointe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpiecesJointe", fetch = FetchType.EAGER)
    private Collection<Request> requestCollection;

    public PiecesJointe() {
    }

    public PiecesJointe(Integer idpiecesJointe) {
        this.idpiecesJointe = idpiecesJointe;
    }

    public Integer getIdpiecesJointe() {
        return idpiecesJointe;
    }

    public void setIdpiecesJointe(Integer idpiecesJointe) {
        this.idpiecesJointe = idpiecesJointe;
    }

    public byte[] getPiecesJointe() {
        return piecesJointe;
    }

    public void setPiecesJointe(byte[] piecesJointe) {
        this.piecesJointe = piecesJointe;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpiecesJointe != null ? idpiecesJointe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PiecesJointe)) {
            return false;
        }
        PiecesJointe other = (PiecesJointe) object;
        if ((this.idpiecesJointe == null && other.idpiecesJointe != null) || (this.idpiecesJointe != null && !this.idpiecesJointe.equals(other.idpiecesJointe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.request.model.PiecesJointe[ idpiecesJointe=" + idpiecesJointe + " ]";
    }
    
}
