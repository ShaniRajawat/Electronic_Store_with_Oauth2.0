package com.sr.electronic.store.Electronic_Store.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Electronic Store API",
                description = "This is Complete BackEnd With Oauth2.0",
                contact = @Contact(
                        name = "Shani Rajawat",
                        email = "rajawt.sunny512@gmail.com"
                ),
                license = @License(
                        name = "SrM"
                ),
                version = "v3"
        ),
        servers = {
                @Server(
                        description = "dev",
                        url = "http://localhost:9090"
                )
        },
        security = @SecurityRequirement(name = "Bearer")  // This associates the security scheme
)
@SecurityScheme(
        name = "Bearer",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "security desc"
)
public class SwaggerConfig {
    // Your configuration code
}