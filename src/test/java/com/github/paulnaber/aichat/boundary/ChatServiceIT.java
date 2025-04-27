package com.github.paulnaber.aichat.boundary;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.github.paulnaber.aichat.boundary.dto.ChatDto;
import com.github.paulnaber.aichat.boundary.dto.MessageDto;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ChatServiceIT {

    @Test
    void testCreateChatEndpoint() {

        // Create a new chat
        ChatDto createdChat = given().contentType("text/plain").body("Whats up?")
                .when().post("/v1/chats").then().statusCode(200).extract().as(ChatDto.class);

        assertNotNull(createdChat);
        assertNotNull(createdChat.getId());
        assertEquals(createdChat.getTitle(), "Whats up?");

        // Get all chats
        ChatDto[] allChats = given().when().get("/v1/chats")
                .then()
                .statusCode(200)
                .extract().as(ChatDto[].class);

        assertNotNull(allChats);
        assertEquals(allChats.length, 1);
        assertEquals(allChats[0].getTitle(), "Whats up?");

        MessageDto[] messages = given()
                .pathParam("chatId", createdChat.getId())
                .when()
                .get("/v1/chats/{chatId}/messages")
                .then()
                .statusCode(200)
                .extract()
                .as(MessageDto[].class);

        assertNotNull(messages);
        assertEquals(messages.length, 1);
        assertEquals(messages[0].getContent(), "Whats up?");

    }
}
