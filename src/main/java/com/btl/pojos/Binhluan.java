/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findById", query = "SELECT b FROM Binhluan b WHERE b.id = :id"),
    @NamedQuery(name = "Binhluan.findByNoidung", query = "SELECT b FROM Binhluan b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Binhluan.findByThoigian", query = "SELECT b FROM Binhluan b WHERE b.thoigian = :thoigian")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thoigian")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date thoigian;
    @JoinColumn(name = "idBaiviet", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Baiviet idBaiviet;
    @JoinColumn(name = "idUser", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User idUser;

    public Binhluan() {
    }

    public Binhluan(Integer id) {
        this.id = id;
    }

    public Binhluan(Integer id, String noidung, Date thoigian) {
        this.id = id;
        this.noidung = noidung;
        this.thoigian = thoigian;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public Baiviet getIdBaiviet() {
        return idBaiviet;
    }

    public void setIdBaiviet(Baiviet idBaiviet) {
        this.idBaiviet = idBaiviet;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Binhluan[ id=" + id + " ]";
    }
    
}
