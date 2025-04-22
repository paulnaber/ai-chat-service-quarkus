package com.github.paulnaber.aichat.boundary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ChatServiceIT {

    @Test
    void testGetChatsEndpoint() {
        given()
                .when().get("/v1/chats")
                .then()
                .statusCode(200)
                .body(is("Hello World"));
    }
}
