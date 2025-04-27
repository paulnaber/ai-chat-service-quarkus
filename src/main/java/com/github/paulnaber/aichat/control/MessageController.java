package com.github.paulnaber.aichat.control;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import com.github.paulnaber.aichat.boundary.dto.MessageDto;
import com.github.paulnaber.aichat.boundary.mapper.MessageMapper;
import com.github.paulnaber.aichat.domain.Message;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MessageController {
    private final JsonWebToken      jwt;
    private final MessageMapper     messageMapper;
    private final MessageRepository messageRepository;

    @Inject
    public MessageController(final JsonWebToken jwt, final MessageMapper mMapper, final MessageRepository mRepository) {
        this.jwt = jwt;
        this.messageMapper = mMapper;
        this.messageRepository = mRepository;
    }



    public MessageDto createMessage(String content, Long chatId) {
        System.out.println("create Message: " + content);
        Message m = createMessageFromString(content, chatId);
        Message persistedMessage = this.messageRepository.createMessage(m);
        return this.messageMapper.mapEntityToDto(persistedMessage);
    }



    public MessageDto[] getAllMessages(Long chatId) {
        List<Message> chats = this.messageRepository.getMessages(chatId);
        return this.messageMapper.mapListEntityToDto(chats).toArray(new MessageDto[0]);
    }



    /**
     * create new Message Entity from incoming content String
     */
    private Message createMessageFromString(String content, Long chatId) {
        Message m = new Message();
        m.setCreatedAt(LocalDateTime.now());
        m.setContent(content);
        m.setChatId(chatId);
        m.setSenderType("TODO");
        m.setUserId(getUserEmail());
        return m;
    }



    private String getUserEmail() {
        return this.jwt.getClaim(Claims.email);
    }

}
