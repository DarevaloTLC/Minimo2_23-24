package edu.upc.dsa.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.upc.dsa.FormResource;
import edu.upc.dsa.models.FormData;
import edu.upc.dsa.models.FormResponse;
import io.swagger.annotations.Api;

@Api(value = "/forms", description = "Endpoint to User Service")
@Path("/forms")
public class FormResourceImpl {
    @POST
    @Path("/submit-form")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitForm(FormData formData) {
        if (formData.getNombre() == null || formData.getEmail() == null || formData.getMensaje() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Por favor, complete todos los campos").build();
        }


        System.out.println("Nombre: " + formData.getNombre() + ", Email: " + formData.getEmail() + ", Mensaje: " + formData.getMensaje());

        return Response.status(200).entity(new FormResponse("Ok")).build();
    }


}
