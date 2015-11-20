/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrezz
 */
@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idCancion = :idCancion"),
    @NamedQuery(name = "Cancion.findByNombreCancion", query = "SELECT c FROM Cancion c WHERE c.nombreCancion = :nombreCancion"),
    @NamedQuery(name = "Cancion.findByGenero", query = "SELECT c FROM Cancion c WHERE c.genero = :genero"),
    @NamedQuery(name = "Cancion.findByDuracion", query = "SELECT c FROM Cancion c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "Cancion.findByPrecio", query = "SELECT c FROM Cancion c WHERE c.precio = :precio")})
public class Cancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cancion")
    private Integer idCancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_cancion")
    private String nombreCancion;
    @Size(max = 45)
    @Column(name = "genero")
    private String genero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duracion")
    private BigDecimal duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCancion")
    private Collection<Venta> ventaCollection;
    @JoinColumn(name = "id_album", referencedColumnName = "id_album")
    @ManyToOne(optional = false)
    private Album idAlbum;

    public Cancion() {
    }

    public Cancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Cancion(Integer idCancion, String nombreCancion, BigDecimal precio) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.precio = precio;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancion != null ? idCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idCancion  +" / " +nombreCancion ;
    }
    
}
