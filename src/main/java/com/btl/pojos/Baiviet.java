/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "baiviet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Baiviet.findAll", query = "SELECT b FROM Baiviet b"),
    @NamedQuery(name = "Baiviet.findById", query = "SELECT b FROM Baiviet b WHERE b.id = :id"),
    @NamedQuery(name = "Baiviet.findByNgaytao", query = "SELECT b FROM Baiviet b WHERE b.ngaytao = :ngaytao"),
    @NamedQuery(name = "Baiviet.findByNoidung", query = "SELECT b FROM Baiviet b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Baiviet.findByAnh", query = "SELECT b FROM Baiviet b WHERE b.anh = :anh")})
public class Baiviet implements Serializable {
    
    public static String AVAIL = "Chưa nhận";
    public static String UNAVAIL = "Đã nhận";

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tinhtrang")
    private String tinhtrang;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaytao")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date ngaytao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "noidung")
    private String noidung;
    @Size(max = 1000)
    @Column(name = "anh")
    private String anh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaiviet")
    private Set<Donhang> donhangSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBaiviet", fetch = FetchType.EAGER)
    private Set<Binhluan> binhluanSet;
    @JoinColumn(name = "idUser", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private User idUser;

    @Transient
    private MultipartFile file;
    public Baiviet() {
    }

    public Baiviet(Integer id) {
        this.id = id;
    }

    public Baiviet(Integer id, Date ngaytao, String noidung) {
        this.id = id;
        this.ngaytao = ngaytao;
        this.noidung = noidung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @XmlTransient
    public Set<Donhang> getDonhangSet() {
        return donhangSet;
    }

    public void setDonhangSet(Set<Donhang> donhangSet) {
        this.donhangSet = donhangSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
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
        if (!(object instanceof Baiviet)) {
            return false;
        }
        Baiviet other = (Baiviet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.btl.pojos.Baiviet[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    /**
     * @return the Available
     */
    public static String getAvailable() {
        return AVAIL;
    }

    /**
     * @param aAvailable the Available to set
     */
    public static void setAvailable(String aAvailable) {
        AVAIL = aAvailable;
    }

    /**
     * @return the unAvailable
     */
    public static String getUnAvailable() {
        return UNAVAIL;
    }

    /**
     * @param aUnAvailable the unAvailable to set
     */
    public static void setUnAvailable(String aUnAvailable) {
        UNAVAIL = aUnAvailable;
    }
    
}
