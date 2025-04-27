package com.github.paulnaber.aichat.control;

import java.util.List;

import com.github.paulnaber.aichat.domain.Message;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MessageRepository implements PanacheRepository<Message> {

    @Transactional
    public Message createMessage(Message m) {
        try {
            System.out.println("persisting message" + m.getContent() + m.getUserId() + m.getCreatedAt());
            persist(m);
            return m;
        }
        catch (PersistenceException e) {
            // TODO implement logging and errorHandling
            System.out.println("failed to create message, persistance error");
            System.out.println(e);
            return null;
        }
    }



    public List<Message> getMessages(Long chatId) {
        return this.list("chatId", chatId);
    }
}
