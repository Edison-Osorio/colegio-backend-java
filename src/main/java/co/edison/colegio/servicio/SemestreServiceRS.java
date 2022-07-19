package co.edison.colegio.servicio;

// @author eosorio
import co.edison.colegio.data.ISemestreDao;
import co.edison.colegio.domain.Semestre;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/semestres")
public class SemestreServiceRS {

    @Inject
    private ISemestreDao semestreDao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Semestre> listarSemestres() {
        List<Semestre> semestres = semestreDao.encontrarTodosSemestres();
        System.out.println("semestres encontrados  = " + semestres);
        return semestres;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Semestre encontrarSemestre(@PathParam("id") int id) {
        Semestre semestre = semestreDao.encontrarSemestre(new Semestre(id));
        System.out.println("semestre encontrado = " + semestre);
        return semestre;
    }

}
