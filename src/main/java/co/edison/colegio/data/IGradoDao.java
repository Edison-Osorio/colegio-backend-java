package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Grado;
import java.util.List;

public interface IGradoDao {

    public List<Grado> encontrarTodosGrados();

    public Grado encontrarGrado(Grado grado);

    public void insetarGrado(Grado grado);

    public void actualizarGrado(Grado grado);

    public void eliminarGrado(Grado grado);
}
