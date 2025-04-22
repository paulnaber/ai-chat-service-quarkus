package com.github.paulnaber.aichat.boundary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private String id;
    private String title;
    private LocalDateTime lastActiveDate;
}