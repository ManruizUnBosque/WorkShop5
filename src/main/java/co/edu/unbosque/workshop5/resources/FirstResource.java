package co.edu.unbosque.workshop5.resources;

import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;
import co.edu.unbosque.workshop5.services.FirstService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/First")
public class FirstResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UsuarioPOJO official) {
        Optional<UsuarioPOJO> persistedOfficial = new FirstService().createOfficial(official);
        return persistedOfficial.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOfficial.get())
                        .build() :
                Response.serverError()
                        .entity("El usuario no pudo ser generado")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UsuarioPOJO official, @PathParam("username") String username) {
        Optional<UsuarioPOJO> updatedOfficial = new FirstService().updatefirst(official, username);
        return Response.ok().entity(updatedOfficial).build();
    }
}
