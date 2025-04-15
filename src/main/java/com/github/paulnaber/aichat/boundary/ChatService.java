package com.github.paulnaber.aichat.boundary;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/chats")
@Tag(name = "Chats", description = "Endpoints for managing user chat sessions")
public interface ChatService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getChats();



    @POST
    @Produces(MediaType.TEXT_PLAIN)
    String createChats();
}
