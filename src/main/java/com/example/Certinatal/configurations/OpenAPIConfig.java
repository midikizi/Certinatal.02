package com.example.Certinatal.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "API-CertiNatal",
            email = "email.com",
            url = "productManagement.com"
        ),
        description = "Notre API de gestion des naissances et certificats de naissance",
        title = "API-CertiNatal",
        version = "2.0"
    ),
    servers = @Server(
        description = "Server 1",
        url = "http://localhost:8080"
    )
)
public class OpenAPIConfig {

}
