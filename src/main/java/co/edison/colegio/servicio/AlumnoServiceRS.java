package co.edison.colegio.servicio;

// @author eosorio
import co.edison.colegio.data.IAlumnoDao;
import co.edison.colegio.domain.Alumno;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/alumnos")
public class AlumnoServiceRS {

    @Inject
    private IAlumnoDao alumnoDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = alumnoDao.encontrarTodosAlumnos();
        System.out.println("Alumnos encontrados = " + alumnos);
        return alumnos;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{idAlumno}")
    public Alumno encontrarAlumno(@PathParam("idAlumno") Integer idAlumno) {
        Alumno alumno = alumnoDao.encontrarAlumno(new Alumno(idAlumno));
        System.out.println("Alumno encontrado: " + alumno);
        return alumno;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response insertarAlumno(Alumno alumno) {
        alumnoDao.insetarAlumno(alumno);

        return Response.ok().build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response actualizarAlumno(@PathParam("id") int id, Alumno alumnoModificado) {
        Alumno alumno = alumnoDao.encontrarAlumno(alumnoModificado);

        if (alumno != null) {
            alumnoDao.actualizarAlumno(alumnoModificado);
            System.out.println("alumno modificado = " + alumnoModificado);
            return Response.ok().entity(alumnoModificado).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarAlumno(@PathParam("id") int id) {
        System.out.println("alumno eliminda con el id: " + id);
        alumnoDao.eliminarAlumno(new Alumno(id));
        return Response.ok().build();
    }

}
