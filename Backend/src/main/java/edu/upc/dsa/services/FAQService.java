package edu.upc.dsa.services;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import edu.upc.dsa.models.FAQ;
import edu.upc.dsa.FAQList;
import edu.upc.dsa.FAQListImpl;


@Api(value = "/FAQs", description = "Endpoint to FAQs Service")
@Path("/FAQs")
public class FAQService {
    private final FAQList fl;
    public FAQService() {this.fl = FAQListImpl.getInstance();}

    @GET
    @ApiOperation(value = "get all FAQs", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = FAQ.class, responseContainer = "List")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFAQs() {
        List<FAQ> faqs = fl.getFAQList();
        GenericEntity<List<FAQ>> entity = new GenericEntity<List<FAQ>>(faqs){};
        return Response.status(200).entity(entity).build();
    }

    @POST
    @ApiOperation(value = "create a new FAQ", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = FAQ.class)
    })
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFAQ(FAQ faq) {
        FAQ retfaq = this.fl.addFAQ(faq);
        return Response.status(201).entity(retfaq).build();
    }
    @POST
    @ApiOperation(value = "answer a FAQ", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = FAQ.class)
    })
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response answerFAQ(@PathParam("id") String id, String answer) {
        FAQ retfaq = this.fl.answerFAQ(id, answer);
        return Response.status(201).entity(retfaq).build();
    }
}
