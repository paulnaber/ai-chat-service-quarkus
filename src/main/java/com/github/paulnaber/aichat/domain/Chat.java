package com.github.paulnaber.aichat.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "chats")
public class Chat extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public String id;

    @Column(name = "user_id")
    public String userId;

    // TODO add default value
    @Column(name = "title")
    public String title;

    // TODO add default value
    public String lastActiveDate;
}
