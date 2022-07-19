package co.edison.colegio.data;

// @author eosorio
import co.edison.colegio.domain.Usuario;

public interface IUsuarioDao {

    public Usuario encontrarUsuario(Usuario usuario);

    public void registrarUsuario(Usuario usuario);

    public void modificarUsuario(Usuario usuario);

}
