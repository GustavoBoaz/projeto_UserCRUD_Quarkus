package org.dboaz.configurations;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "API with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Gustavo Boaz",
                        url = "https://github.com/GustavoBoaz",
                        email = "gustavo.boaz@hotmail.com"),
                license = @License(
                        name = "MIT",
                        url = "https://opensource.org/licenses/MIT"))
)
public class SwaggerConfiguration extends Application {
    
}
