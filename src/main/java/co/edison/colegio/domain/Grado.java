package co.edison.colegio.domain;

// @author eosorio
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByIdGrado", query = "SELECT g FROM Grado g WHERE g.idGrado = :idGrado"),
    @NamedQuery(name = "Grado.findByNombre", query = "SELECT g FROM Grado g WHERE g.nombre = :nombre")})
public class Grado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grado")
    private Integer idGrado;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String nombre;

//    @OneToMany(mappedBy = "idGradoA")
//    private List<Alumno> alumnoList;
    public Grado() {
    }

    public Grado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public Grado(Integer idGrado, String nombre) {
        this.idGrado = idGrado;
        this.nombre = nombre;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public List<Alumno> getAlumnoList() {
//        return alumnoList;
//    }
//
//    public void setAlumnoList(List<Alumno> alumnoList) {
//        this.alumnoList = alumnoList;
//    }
//    public List<Materia> getMateriaList() {
//        return materiaList;
//    }
//
//    public void setMateriaList(List<Materia> materiaList) {
//        this.materiaList = materiaList;
//    }
    @Override
    public String toString() {
        return "Grado{" + "idGrado=" + idGrado + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

}
