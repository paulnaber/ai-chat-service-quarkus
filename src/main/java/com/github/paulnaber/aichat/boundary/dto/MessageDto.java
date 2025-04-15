package com.github.paulnaber.aichat.boundary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private int    id;
    private String content;
    private String senderType;
    private String createdAt;
    private int    chatId;
}
