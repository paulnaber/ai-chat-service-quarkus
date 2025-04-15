package com.github.paulnaber.aichat;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "AI Chat API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Paul Naber",
                        email = "paul.naber@inside-m2m.de")))
public class ApiApplication extends Application {
}
