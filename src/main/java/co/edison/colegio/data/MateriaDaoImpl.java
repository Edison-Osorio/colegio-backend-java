package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Materia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class MateriaDaoImpl implements IMateriaDao {

    @PersistenceContext(unitName = "ColegioPU")
    EntityManager em;

    @Override
    public List<Materia> encontrarTodosMaterias() {
        return em.createNamedQuery("Materia.findAll").getResultList();
    }

    @Override
    public Materia encontrarMateria(Materia materia) {
        return em.find(Materia.class, materia.getIdMateria());
    }

    @Override
    public void insetarMateria(Materia materia) {
        em.persist(materia);
    }

    @Override
    public void actualizarMateria(Materia materia) {
        em.merge(materia);
    }

    @Override
    public void eliminarMateria(Materia materia) {
        Materia materiaEliminar = encontrarMateria(materia);
        em.remove(materiaEliminar);

    }

}
