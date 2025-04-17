package com.github.paulnaber.aichat.boundary;

public class ChatServiceImpl implements ChatService {

    @Override
    public String getChats() {
        return "Hello from Quarkus REST GET";
    }



    @Override
    public String createChats() {
        return "Hello from Quarkus REST";
    }
}
