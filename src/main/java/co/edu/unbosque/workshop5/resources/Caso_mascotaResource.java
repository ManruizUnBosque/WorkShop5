package co.edu.unbosque.workshop5.resources;

import co.edu.unbosque.workshop5.resources.pojos.PetCasePOJO;
import co.edu.unbosque.workshop5.services.PetCaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/casomascotas")
public class Caso_mascotaResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetCasePOJO petCase) {
        Optional<PetCasePOJO> persistedPetCase = new PetCaseService().createPetCase(petCase);
        return persistedPetCase.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedPetCase.get())
                        .build() :
                Response.serverError()
                        .entity("Dueño no pudo ser generado")
                        .build();
    }

}
