package co.edu.unbosque.workshop5.resources;

import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;
import co.edu.unbosque.workshop5.services.DueñoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/dueños")
public class DueñoResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UsuarioPOJO owner) {
        Optional<UsuarioPOJO> persistedOwner = new DueñoService().createOwner(owner);
        return persistedOwner.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedOwner.get())
                        .build() :
                Response.serverError()
                        .entity("El dueño no pudo ser generado")
                        .build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UsuarioPOJO owner, @PathParam("username") String username) {
        Optional<UsuarioPOJO> updatedOwner = new DueñoService().updateOwner(owner, username);
        return Response.ok().entity(updatedOwner).build();
    }
}
