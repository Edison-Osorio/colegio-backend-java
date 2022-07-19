package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Materia;
import java.util.List;

public interface IMateriaDao {

    public List<Materia> encontrarTodosMaterias();

    public Materia encontrarMateria(Materia materia);

    public void insetarMateria(Materia materia);

    public void actualizarMateria(Materia materia);

    public void eliminarMateria(Materia materia);
}
