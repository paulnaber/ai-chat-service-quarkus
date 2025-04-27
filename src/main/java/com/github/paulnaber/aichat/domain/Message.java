package com.github.paulnaber.aichat.domain;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
public class Message extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long          id;

    @Column(name = "user_id")
    public String        userId;

    @Column(name = "content")
    public String        content;

    // TODO add default value
    @Column(name = "sender_type")
    public String        senderType;

    // TODO add default value
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    // TODO add references(() => chats.id, { onDelete: 'cascade' })
    @Column(name = "chat_id")
    public Long          chatId;
}
