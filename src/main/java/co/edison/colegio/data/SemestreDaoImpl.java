package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Semestre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class SemestreDaoImpl implements ISemestreDao {

    @PersistenceContext(unitName = "ColegioPU")
    EntityManager em;

    @Override
    public List<Semestre> encontrarTodosSemestres() {
        return em.createNamedQuery("Semestre.findAll").getResultList();
    }

    @Override
    public Semestre encontrarSemestre(Semestre semestre) {
        return em.find(Semestre.class, semestre.getIdSemestre());
    }

    @Override
    public void insetarSemestre(Semestre semestre) {
        em.persist(semestre);
    }

    @Override
    public void actualizarSemestre(Semestre semestre) {
        em.merge(semestre);
    }

    @Override
    public void eliminarSemestre(Semestre semestre) {
        em.remove(em.merge(semestre));
    }

}
