/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.dipvvf.crick.vvfintranet.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Crick
 */
@Entity
@Table(catalog = "postgres", schema = "intranet")
@NamedQueries({
    @NamedQuery(name = "Ufficio.findAll", query = "SELECT u FROM Ufficio u ORDER BY u.ordine"),
    @NamedQuery(name = "Ufficio.findByCodice", query = "SELECT u FROM Ufficio u WHERE u.codice = :codice"),
    @NamedQuery(name = "Ufficio.findByNome", query = "SELECT u FROM Ufficio u WHERE u.nome = :nome"),
    @NamedQuery(name = "Ufficio.findByOrdine", query = "SELECT u FROM Ufficio u WHERE u.ordine = :ordine"),
    @NamedQuery(name = "Ufficio.findByVersion", query = "SELECT u FROM Ufficio u WHERE u.version = :version")})
@XmlRootElement
public class Ufficio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    private String codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    private String nome;
    @Basic(optional = false)
    @NotNull
    private int ordine;
    @Basic(optional = false)
    @NotNull
    private long version;

    public Ufficio() {
    }

    public Ufficio(String codice) {
        this.codice = codice;
    }

    public Ufficio(String codice, String nome, int ordine) {
        this.codice = codice;
        this.nome = nome;
        this.ordine = ordine;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdine() {
        return ordine;
    }

    public void setOrdine(int ordine) {
        this.ordine = ordine;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ufficio)) {
            return false;
        }
        Ufficio other = (Ufficio) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.dipvvf.crick.vvfintranet.model.Ufficio[ codice=" + codice + " ]";
    }
    
}
