package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class AlumnoDaoImpl implements IAlumnoDao {

    @PersistenceContext(unitName = "ColegioPU")
    EntityManager em;

    @Override
    public List<Alumno> encontrarTodosAlumnos() {
        return em.createNamedQuery("Alumno.findAll").getResultList();
    }

    @Override
    public Alumno encontrarAlumno(Alumno alumno) {
        return em.find(Alumno.class, alumno.getIdAlumno());
    }

    @Override
    public void insetarAlumno(Alumno alumno) {
        em.persist(alumno);
        em.flush();
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        em.merge(alumno);
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        Alumno alumnoEncontrado = encontrarAlumno(alumno);
        System.out.println("alumnoEncontrado econtrado = " + alumnoEncontrado);
        em.remove(alumnoEncontrado);
    }

}
