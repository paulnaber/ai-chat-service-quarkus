package com.github.paulnaber.aichat.control;

import java.util.List;

import com.github.paulnaber.aichat.domain.Chat;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ChatRepository implements PanacheRepository<Chat> {

    @Transactional
    public Chat createChat(Chat c) {
        try {
            System.out.println("persisting chat" + c.getTitle() + c.getUserId() + c.getLastActiveDate());
            persist(c);
            return c;
        }
        catch (PersistenceException e) {
            // TODO implement logging and errorHandling
            System.out.println("failed to create chat, persistance error");
            return null;
        }

    }



    public List<Chat> getChats() {
        return this.listAll();
    }

}
