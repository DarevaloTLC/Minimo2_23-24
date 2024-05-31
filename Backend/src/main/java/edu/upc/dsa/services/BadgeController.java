package edu.upc.dsa.services;
import edu.upc.dsa.BadgeService;
import edu.upc.dsa.models.Badge;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Weapon;
import io.swagger.annotations.Api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Api(value = "/prueba", description = "Endpoint to User Service")
@Path("/prueba")
public class BadgeController {
    private BadgeService badgeService = new BadgeService();

    @GET
    @Path("/{userId}/badges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserBadges(@PathParam("userId") int userId) {
        List<Badge> badges = badgeService.getUserBadges(userId);
        if (badges.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            System.out.println("Badge User:" + userId);
            GenericEntity<List<Badge>> entity = new GenericEntity<List<Badge>>(badges) {};
            return Response.status(200).entity(entity).build();
        }
    }
}


