
package co.edison.colegio.domain;

// @author eosorio

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "materia_alumno")
@NamedQueries({
    @NamedQuery(name = "MateriaAlumno.findAll", query = "SELECT m FROM MateriaAlumno m"),
    @NamedQuery(name = "MateriaAlumno.findByIdAlumnoMa", query = "SELECT m FROM MateriaAlumno m WHERE m.materiaAlumnoPK.idAlumnoMa = :idAlumnoMa"),
    @NamedQuery(name = "MateriaAlumno.findByIdSemestreMa", query = "SELECT m FROM MateriaAlumno m WHERE m.materiaAlumnoPK.idSemestreMa = :idSemestreMa"),
    @NamedQuery(name = "MateriaAlumno.findByIdMateriaMa", query = "SELECT m FROM MateriaAlumno m WHERE m.materiaAlumnoPK.idMateriaMa = :idMateriaMa")})
public class MateriaAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaAlumnoPK materiaAlumnoPK;
    @JoinColumn(name = "id_alumno_ma", referencedColumnName = "id_alumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "id_semestre_ma", referencedColumnName = "id_semestre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Semestre semestre;

    public MateriaAlumno() {
    }

    public MateriaAlumno(MateriaAlumnoPK materiaAlumnoPK) {
        this.materiaAlumnoPK = materiaAlumnoPK;
    }

    public MateriaAlumno(int idAlumnoMa, int idSemestreMa, int idMateriaMa) {
        this.materiaAlumnoPK = new MateriaAlumnoPK(idAlumnoMa, idSemestreMa, idMateriaMa);
    }

    public MateriaAlumnoPK getMateriaAlumnoPK() {
        return materiaAlumnoPK;
    }

    public void setMateriaAlumnoPK(MateriaAlumnoPK materiaAlumnoPK) {
        this.materiaAlumnoPK = materiaAlumnoPK;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaAlumnoPK != null ? materiaAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaAlumno)) {
            return false;
        }
        MateriaAlumno other = (MateriaAlumno) object;
        if ((this.materiaAlumnoPK == null && other.materiaAlumnoPK != null) || (this.materiaAlumnoPK != null && !this.materiaAlumnoPK.equals(other.materiaAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edison.colegio.backend.java.MateriaAlumno[ materiaAlumnoPK=" + materiaAlumnoPK + " ]";
    }

}
