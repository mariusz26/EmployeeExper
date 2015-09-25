package com.mariusz.empexp.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@Table(name = "Zatrudnienie")

public class Zatrudnienie implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_zatrudnienie")
    private Short idZatrudnienie;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "umowa_od")
    @Temporal(TemporalType.DATE)
    private Date umowaOd;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "umowa_do")
    @Temporal(TemporalType.DATE)
    private Date umowaDo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pensja")
    private BigDecimal pensja;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "liczba_dni_dziennie")
    private short liczbaDniDziennie;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "wymiar")
    private BigDecimal wymiar;
    
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_typ_umowy")
    private TypUmowy idTypUmowy;
       
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_stanowisko")
    private StanowiskaPracy idStanowisko;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pracownik")
    private Pracownik idPracownik;

   

	public Zatrudnienie() {
    }

    public Zatrudnienie(Short idZatrudnienie) {
        this.idZatrudnienie = idZatrudnienie;
    }

    public Zatrudnienie(Short idZatrudnienie, Date umowaOd, Date umowaDo, BigDecimal pensja, short liczbaDniDziennie, BigDecimal wymiar) {
        this.idZatrudnienie = idZatrudnienie;
        this.umowaOd = umowaOd;
        this.umowaDo = umowaDo;
        this.pensja = pensja;
        this.liczbaDniDziennie = liczbaDniDziennie;
        this.wymiar = wymiar;
    }

	public Short getIdZatrudnienie() {
		return idZatrudnienie;
	}

	public void setIdZatrudnienie(Short idZatrudnienie) {
		this.idZatrudnienie = idZatrudnienie;
	}

	public Date getUmowaOd() {
		return umowaOd;
	}

	public void setUmowaOd(Date umowaOd) {
		this.umowaOd = umowaOd;
	}

	public Date getUmowaDo() {
		return umowaDo;
	}

	public void setUmowaDo(Date umowaDo) {
		this.umowaDo = umowaDo;
	}

	public BigDecimal getPensja() {
		return pensja;
	}

	public void setPensja(BigDecimal pensja) {
		this.pensja = pensja;
	}

	public short getLiczbaDniDziennie() {
		return liczbaDniDziennie;
	}

	public void setLiczbaDniDziennie(short liczbaDniDziennie) {
		this.liczbaDniDziennie = liczbaDniDziennie;
	}

	public BigDecimal getWymiar() {
		return wymiar;
	}

	public void setWymiar(BigDecimal wymiar) {
		this.wymiar = wymiar;
	}

	public TypUmowy getIdTypUmowy() {
		return idTypUmowy;
	}

	public void setIdTypUmowy(TypUmowy idTypUmowy) {
		this.idTypUmowy = idTypUmowy;
	}

	public StanowiskaPracy getIdStanowisko() {
		return idStanowisko;
	}

	public void setIdStanowisko(StanowiskaPracy idStanowisko) {
		this.idStanowisko = idStanowisko;
	}

	public Pracownik getIdPracownik() {
		return idPracownik;
	}

	public void setIdPracownik(Pracownik idPracownik) {
		this.idPracownik = idPracownik;
	}
    
    
	 @Override
		public boolean equals(final Object other) {
			if (!(other instanceof Zatrudnienie)) {
				return false;
			}
			Zatrudnienie castOther = (Zatrudnienie) other;
			return new EqualsBuilder().append(idZatrudnienie,
					castOther.idZatrudnienie).isEquals();
		}

		@Override
		public int hashCode() {
			return new HashCodeBuilder().append(idZatrudnienie).toHashCode();
		}

}

