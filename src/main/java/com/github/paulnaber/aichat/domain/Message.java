package com.github.paulnaber.aichat.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public String id;

    @Column(name = "user_id")
    public String userId;

    @Column(name = "content")
    public String content;

    // TODO add default value
    @Column(name = "sender_type")
    public String senderType;

    // TODO add default value
    @Column(name = "created_at")
    public String createdAt;

    // TODO add references(() => chats.id, { onDelete: 'cascade' })
    @Column(name = "chat_id")
    public String chatId;
}
