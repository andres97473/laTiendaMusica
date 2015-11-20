/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrezz
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByIdAlbum", query = "SELECT a FROM Album a WHERE a.idAlbum = :idAlbum"),
    @NamedQuery(name = "Album.findByNombreAlbum", query = "SELECT a FROM Album a WHERE a.nombreAlbum = :nombreAlbum"),
    @NamedQuery(name = "Album.findByFechaLanzamiento", query = "SELECT a FROM Album a WHERE a.fechaLanzamiento = :fechaLanzamiento")})
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_album")
    private Integer idAlbum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_album")
    private String nombreAlbum;
    @Column(name = "fecha_lanzamiento")
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;
    @JoinColumn(name = "id_banda", referencedColumnName = "id_banda")
    @ManyToOne(optional = false)
    private Banda idBanda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlbum")
    private Collection<Cancion> cancionCollection;

    public Album() {
    }

    public Album(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Album(Integer idAlbum, String nombreAlbum) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Banda getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Banda idBanda) {
        this.idBanda = idBanda;
    }

    @XmlTransient
    public Collection<Cancion> getCancionCollection() {
        return cancionCollection;
    }

    public void setCancionCollection(Collection<Cancion> cancionCollection) {
        this.cancionCollection = cancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbum != null ? idAlbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idAlbum == null && other.idAlbum != null) || (this.idAlbum != null && !this.idAlbum.equals(other.idAlbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idAlbum  + " / " + nombreAlbum ;
    }
    
}
