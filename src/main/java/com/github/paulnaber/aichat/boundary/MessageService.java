package com.github.paulnaber.aichat.boundary;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/chats")
@Tag(name = "Messages", description = "Endpoints for sending and retrieving messages within chats")
public interface MessageService {
    @GET
    @Path("{chatId}/messages")
    @Produces(MediaType.TEXT_PLAIN)
    String getMessages();



    @POST
    @Path("{chatId}/messages")
    @Produces(MediaType.TEXT_PLAIN)
    String createMessages();
}
