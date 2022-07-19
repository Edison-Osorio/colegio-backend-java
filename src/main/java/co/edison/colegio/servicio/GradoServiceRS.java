package co.edison.colegio.servicio;

// @author eosorio
import co.edison.colegio.data.IGradoDao;
import co.edison.colegio.domain.Grado;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/grados")
public class GradoServiceRS {

    @Inject
    private IGradoDao gradoDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Grado> listarGrados() {
        List<Grado> grados = gradoDao.encontrarTodosGrados();
        System.out.println("Grados encontrados = " + grados);

        return grados;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Grado encontrarGrado(@PathParam("id") int id) {
        Grado grado = gradoDao.encontrarGrado(new Grado(id));
        System.out.println("grados encontrados  = " + grado);
        return grado;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Grado agregarGrado(Grado grado) {
        gradoDao.insetarGrado(grado);
        System.out.println("grado agregado = " + grado);
        return grado;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response actualizarGrado(Grado gradoModificado) {
        Grado grado = gradoDao.encontrarGrado(gradoModificado);
        if (grado != null) {
            gradoDao.actualizarGrado(gradoModificado);
            System.out.println("grado modificado= " + gradoModificado);
            return Response.ok().entity(gradoModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response eliminarGrado(Grado grado) {
        gradoDao.eliminarGrado(grado);
        System.out.println("grado  eliminado= " + grado);
        return Response.ok().build();
    }

}
