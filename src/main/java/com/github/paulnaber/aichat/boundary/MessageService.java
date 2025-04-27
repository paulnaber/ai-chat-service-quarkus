package com.github.paulnaber.aichat.boundary;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.paulnaber.aichat.boundary.dto.MessageDto;
import com.github.paulnaber.aichat.control.MessageController;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/messages")
@Tag(name = "Messages", description = "Endpoints for sending and retrieving messages within chats")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class MessageService {

    private final MessageController messageController;

    @Inject
    public MessageService(MessageController mc) {
        this.messageController = mc;
    }



    @GET
    @Path("{chatId}/messages")
    public MessageDto[] getMessages(@PathParam("chatId") Long chatId) {
        return this.messageController.getAllMessages(chatId);
    }



    @POST
    @Path("{chatId}/messages")
    public MessageDto
            createMessage(@PathParam("chatId") Long chatId,
                    @RequestBody(name = "content", description = "Content of the message") String content) {
        return this.messageController.createMessage(content, chatId);
    }

}
