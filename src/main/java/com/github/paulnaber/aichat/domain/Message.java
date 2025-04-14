package com.github.paulnaber.aichat.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Message extends PanacheEntity {
    public String field;
}
