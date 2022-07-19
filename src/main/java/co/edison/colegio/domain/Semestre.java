package co.edison.colegio.domain;

// @author eosorio
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s"),
    @NamedQuery(name = "Semestre.findByIdSemestre", query = "SELECT s FROM Semestre s WHERE s.idSemestre = :idSemestre"),
    @NamedQuery(name = "Semestre.findByNombre", query = "SELECT s FROM Semestre s WHERE s.nombre = :nombre")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semestre")
    private Integer idSemestre;

    @NotEmpty
    @Size(max = 50)
    private String nombre;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "semestre")
//    private List<MateriaAlumno> materiaAlumnoList;
    public Semestre() {
    }

    public Semestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public List<MateriaAlumno> getMateriaAlumnoList() {
//        return materiaAlumnoList;
//    }
//
//    public void setMateriaAlumnoList(List<MateriaAlumno> materiaAlumnoList) {
//        this.materiaAlumnoList = materiaAlumnoList;
//    }
    @Override
    public String toString() {
        return "Semestre{" + "idSemestre=" + idSemestre + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSemestre != null ? idSemestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.idSemestre == null && other.idSemestre != null) || (this.idSemestre != null && !this.idSemestre.equals(other.idSemestre))) {
            return false;
        }
        return true;
    }

}
