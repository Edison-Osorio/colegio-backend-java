package co.edison.colegio.data;

// @author eosorio
import java.util.List;
import co.edison.colegio.domain.Semestre;

public interface ISemestreDao {

    public List<Semestre> encontrarTodosSemestres();

    public Semestre encontrarSemestre(Semestre semestre);

    public void insetarSemestre(Semestre semestre);

    public void actualizarSemestre(Semestre semestre);

    public void eliminarSemestre(Semestre semestre);
}
