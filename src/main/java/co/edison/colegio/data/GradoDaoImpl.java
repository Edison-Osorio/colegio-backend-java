package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Grado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GradoDaoImpl implements IGradoDao {

    @PersistenceContext(unitName = "ColegioPU")
    EntityManager em;

    @Override
    public List<Grado> encontrarTodosGrados() {
        return em.createNamedQuery("Grado.findAll").getResultList();
    }

    @Override
    public Grado encontrarGrado(Grado grado) {
        return em.find(Grado.class, grado.getIdGrado());
    }

    @Override
    public void insetarGrado(Grado grado) {
        em.persist(grado);
        em.flush();
    }

    @Override
    public void actualizarGrado(Grado grado) {
        em.merge(grado);
    }

    @Override
    public void eliminarGrado(Grado grado) {
        em.remove(em.merge(grado));
    }

}
