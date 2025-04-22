package com.github.paulnaber.aichat.control;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import com.github.paulnaber.aichat.boundary.dto.ChatDto;
import com.github.paulnaber.aichat.boundary.mapper.ChatMapper;
import com.github.paulnaber.aichat.domain.Chat;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ChatController {
    private final JsonWebToken   jwt;
    private final ChatMapper     chatMapper;
    private final ChatRepository chatRepository;

    @Inject
    public ChatController(final JsonWebToken jwt, final ChatMapper cMapper, final ChatRepository chatRepository) {
        this.jwt = jwt;
        this.chatMapper = cMapper;
        this.chatRepository = chatRepository;
    }



    public ChatDto createChat(String content) {
        System.out.println("create Chat: " + content);
        Chat c = createChatFromString(content);
        Chat persistedChat = this.chatRepository.createChat(c);
        return this.chatMapper.mapEntityToDto(persistedChat);
    }



    public List<ChatDto> getAllChats() {
        List<Chat> chats = this.chatRepository.getChats();
        return this.chatMapper.mapListEntityToDto(chats);
    }



    /**
     * create new Chat Entity from incoming content String
     * The first message will be the title of the chat.
     */
    private Chat createChatFromString(String content) {
        Chat c = new Chat();
        c.setLastActiveDate(LocalDateTime.now());
        c.setTitle(content);
        // c.setUserId(getUserEmail()); // TODO 
        c.setUserId("paul.naber@todo.de");
        return c;
    }



    private String getUserEmail() {
        return this.jwt.getClaim(Claims.email);
    }

}
