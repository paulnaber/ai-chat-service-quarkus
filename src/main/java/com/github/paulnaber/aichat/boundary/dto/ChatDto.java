package com.github.paulnaber.aichat.boundary.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private int           id;
    private String        title;
    private LocalDateTime lastActiveDate;
}