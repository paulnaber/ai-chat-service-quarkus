
package com.github.paulnaber.aichat.boundary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private String id;
    private String title;
    private String lastActiveDate;
}