/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author andrezz
 */
@Entity
@Table(name = "banda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banda.findAll", query = "SELECT b FROM Banda b"),
    @NamedQuery(name = "Banda.findByIdBanda", query = "SELECT b FROM Banda b WHERE b.idBanda = :idBanda"),
    @NamedQuery(name = "Banda.findByNombreBanda", query = "SELECT b FROM Banda b WHERE b.nombreBanda = :nombreBanda"),
    @NamedQuery(name = "Banda.findByDescripcion", query = "SELECT b FROM Banda b WHERE b.descripcion = :descripcion")})
public class Banda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banda")
    private Integer idBanda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_banda")
    private String nombreBanda;
    @Size(max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBanda")
    private Collection<Album> albumCollection;

    public Banda() {
    }

    public Banda(Integer idBanda) {
        this.idBanda = idBanda;
    }

    public Banda(Integer idBanda, String nombreBanda) {
        this.idBanda = idBanda;
        this.nombreBanda = nombreBanda;
    }

    public Integer getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Integer idBanda) {
        this.idBanda = idBanda;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanda != null ? idBanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banda)) {
            return false;
        }
        Banda other = (Banda) object;
        if ((this.idBanda == null && other.idBanda != null) || (this.idBanda != null && !this.idBanda.equals(other.idBanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idBanda + " / " + nombreBanda;
    }
    
}
