package co.edison.colegio.servicio;

// @author eosorio
import co.edison.colegio.data.IMateriaDao;
import co.edison.colegio.domain.Materia;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/materias")
public class MateriaServiceRS {

    @Inject
    private IMateriaDao materiaDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Materia> listarMaterias() {
        List<Materia> materias = materiaDao.encontrarTodosMaterias();
        System.out.println("materias encontradas = " + materias);
        return materias;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Materia encontrarMateria(@PathParam("id") int id) {
        Materia materia = materiaDao.encontrarMateria(new Materia(id));
        System.out.println("materia encontada = " + materia);
        return materia;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Materia insertarMateria(Materia materia) {
        materiaDao.insetarMateria(materia);
        System.out.println("materia agregada = " + materia);
        return materia;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response actualizarMateria(@PathParam("id") int id, Materia materiaModificada) {

        Materia materia = materiaDao.encontrarMateria(materiaModificada);

        if (materia != null) {
            materiaDao.actualizarMateria(materiaModificada);
            System.out.println("materia actualizada = " + materiaModificada);
            return Response.ok().entity(materiaModificada).build();

        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response eliminarMateria(@PathParam("id") Integer id) {
        System.out.println("Materia eliminda con el id: " + id);
        materiaDao.eliminarMateria(new Materia(id));
        return Response.ok().build();
    }
//
//    @DELETE
//    @Produces(value = MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public Response eliminarMateria(@PathParam("id") int id) {
//        materiaDao.eliminarMateria(new Materia(id));
//        System.out.println("Persona eliminada con el id = " + id);
//        return Response.ok().build();
//}

}
