package co.edu.unbosque.workshop5.resources;

import co.edu.unbosque.workshop5.resources.pojos.VisitPOJO;
import co.edu.unbosque.workshop5.services.VisitService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/visits")
public class VisitaResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VisitPOJO visit) {
        Optional<VisitPOJO> persitedVisit = new VisitService().createVisit(visit);
        return persitedVisit.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVisit.get())
                        .build() :
                Response.serverError()
                        .entity("Visitas no pudieron ser generado")
                        .build();
    }
}
