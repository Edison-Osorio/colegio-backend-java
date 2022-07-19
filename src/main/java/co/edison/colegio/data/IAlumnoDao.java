package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Alumno;
import java.util.List;

public interface IAlumnoDao {

    public List<Alumno> encontrarTodosAlumnos();

    public Alumno encontrarAlumno(Alumno alumno);

    public void insetarAlumno(Alumno alumno);

    public void actualizarAlumno(Alumno alumno);

    public void eliminarAlumno(Alumno alumno);

}
