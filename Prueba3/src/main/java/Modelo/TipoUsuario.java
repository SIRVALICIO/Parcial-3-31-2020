/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author VAL
 */
@Entity
public class TipoUsuario implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @Column(name="ID")
    private Integer id;
    
    @Basic(optional=false)
    @NotNull
    @Size(min=5,max=15)
    @Column(name="NOMBRE_TIPO")
    private String nombre_tipo;
    @OneToMany(cascade=CascadeType.ALL, mappedBy="tipo_usuario_id")
    private List<Usuario> tiposUSuarios; 

    public List<Usuario> getTiposUSuarios() {
        return tiposUSuarios;
    }

    public void setTiposUSuarios(List<Usuario> tiposUSuarios) {
        this.tiposUSuarios = tiposUSuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
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
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
