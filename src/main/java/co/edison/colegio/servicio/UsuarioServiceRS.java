package co.edison.colegio.servicio;

// @author eosorio
import co.edison.colegio.data.IUsuarioDao;
import co.edison.colegio.domain.Usuario;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/auth")
public class UsuarioServiceRS {

    @Inject
    private IUsuarioDao usuarioDao;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/signin")
    public Response registrarUsuario(Usuario usuario) {
        Usuario usuarioAuth = usuarioDao.encontrarUsuario(usuario);

        if (usuarioAuth != null) {
            System.out.println("usuarioAuth encontrado = " + usuarioAuth);

            if (usuarioAuth.getPassword().equals(usuario.getPassword())) {
                System.out.println("Password correcto");
                return Response.ok(usuarioAuth).build();

            } else {
                return Response.status(Status.BAD_REQUEST).entity("Contraseña invalida").build();
            }
        }
        return null;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/signup")
    public Response ingresarUsuario(Usuario usuario) {
        usuarioDao.registrarUsuario(usuario);
        System.out.println("Usuario registrado" + usuario);
        return Response.ok().build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response actualizarAlumno(@PathParam("id") int id, Usuario usuarioModificado) {
        Usuario usuario = usuarioDao.encontrarUsuario(usuarioModificado);
        System.out.println("Usuario encontrado" + usuario);
        System.out.println("Hola");

        usuarioModificado.setTipoDocumento(usuario.getTipoDocumento());
        usuarioModificado.setPassword(usuario.getPassword());

        if (usuario != null) {
            usuarioDao.modificarUsuario(usuarioModificado);
            System.out.println("Usuario Modificaso = " + usuarioModificado);
            return Response.ok().entity(usuarioModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }

    }

}
