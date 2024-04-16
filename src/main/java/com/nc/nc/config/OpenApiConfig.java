package com.nc.nc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
       info = @Info(
               contact = @Contact(
                       name="Naveen Chandra",
                       email = "nc.upadhyay20@gmail.com",
                       url = "http://localhost:8080/"
               ),
               title = "Swagger Api Documentation.",
               description = "This is the documentation of swagger api. it used for document. it is easy to use",
               version = "1.0"

       ),
        servers = {
               @Server(
                       url = "www.openapi.com"
                        ,description = "Prod env"
               ),
                @Server(
                url = "www.openapi.com"
                ,description = "dev env"
        )
        }
)

public class OpenApiConfig {
}
