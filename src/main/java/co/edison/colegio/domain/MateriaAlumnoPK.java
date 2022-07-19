
package co.edison.colegio.domain;

// @author eosorio

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class MateriaAlumnoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alumno_ma")
    private int idAlumnoMa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_semestre_ma")
    private int idSemestreMa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_materia_ma")
    private int idMateriaMa;

    public MateriaAlumnoPK() {
    }

    public MateriaAlumnoPK(int idAlumnoMa, int idSemestreMa, int idMateriaMa) {
        this.idAlumnoMa = idAlumnoMa;
        this.idSemestreMa = idSemestreMa;
        this.idMateriaMa = idMateriaMa;
    }

    public int getIdAlumnoMa() {
        return idAlumnoMa;
    }

    public void setIdAlumnoMa(int idAlumnoMa) {
        this.idAlumnoMa = idAlumnoMa;
    }

    public int getIdSemestreMa() {
        return idSemestreMa;
    }

    public void setIdSemestreMa(int idSemestreMa) {
        this.idSemestreMa = idSemestreMa;
    }

    public int getIdMateriaMa() {
        return idMateriaMa;
    }

    public void setIdMateriaMa(int idMateriaMa) {
        this.idMateriaMa = idMateriaMa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAlumnoMa;
        hash += (int) idSemestreMa;
        hash += (int) idMateriaMa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaAlumnoPK)) {
            return false;
        }
        MateriaAlumnoPK other = (MateriaAlumnoPK) object;
        if (this.idAlumnoMa != other.idAlumnoMa) {
            return false;
        }
        if (this.idSemestreMa != other.idSemestreMa) {
            return false;
        }
        if (this.idMateriaMa != other.idMateriaMa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edison.colegio.backend.java.MateriaAlumnoPK[ idAlumnoMa=" + idAlumnoMa + ", idSemestreMa=" + idSemestreMa + ", idMateriaMa=" + idMateriaMa + " ]";
    }

}
