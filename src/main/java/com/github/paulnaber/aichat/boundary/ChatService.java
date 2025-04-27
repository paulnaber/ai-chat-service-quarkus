package com.github.paulnaber.aichat.boundary;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.paulnaber.aichat.boundary.dto.ChatDto;
import com.github.paulnaber.aichat.control.ChatController;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/chats")
@Tag(name = "Chats", description = "Endpoints for managing user chat sessions")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class ChatService {

    private final ChatController chatController;

    @Inject
    public ChatService(ChatController chatController) {
        this.chatController = chatController;
    }



    @GET
    @Path("")
    public List<ChatDto> getChats() {
        return this.chatController.getAllChats();
    };



    @POST
    @Path("")
    public ChatDto createChats(@RequestBody(name = "content", description = "New request message") String content) {
        return chatController.createChat(content);
    };
}
