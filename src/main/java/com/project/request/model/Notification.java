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
@Table(name = "notification", catalog = "facsciencedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnotification")
    private Integer idnotification;
    @Size(max = 45)
    @Column(name = "dateNotification")
    private String dateNotification;
    @Size(max = 45)
    @Column(name = "notification")
    private String notification;
    @JoinColumn(name = "etudiant_idEtudiant", referencedColumnName = "idEtudiant")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Etudiant etudiantidEtudiant;
    @JoinColumn(name = "idrequest", referencedColumnName = "idrequest")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Request idrequest;

    public Notification() {
    }

    public Notification(Integer idnotification) {
        this.idnotification = idnotification;
    }

    public Integer getIdnotification() {
        return idnotification;
    }

    public void setIdnotification(Integer idnotification) {
        this.idnotification = idnotification;
    }

    public String getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(String dateNotification) {
        this.dateNotification = dateNotification;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Etudiant getEtudiantidEtudiant() {
        return etudiantidEtudiant;
    }

    public void setEtudiantidEtudiant(Etudiant etudiantidEtudiant) {
        this.etudiantidEtudiant = etudiantidEtudiant;
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
        hash += (idnotification != null ? idnotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idnotification == null && other.idnotification != null) || (this.idnotification != null && !this.idnotification.equals(other.idnotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.request.model.Notification[ idnotification=" + idnotification + " ]";
    }
    
}
