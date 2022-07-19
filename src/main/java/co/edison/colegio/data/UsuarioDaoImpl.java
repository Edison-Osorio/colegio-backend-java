package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDaoImpl implements IUsuarioDao {

    @PersistenceContext(unitName = "ColegioPU")
    EntityManager em;

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

}
