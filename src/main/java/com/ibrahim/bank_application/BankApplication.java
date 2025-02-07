package com.ibrahim.bank_application;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Bank App",
                description = "Backend Rest APIs for Bank App",
                version = "v1.0",
                contact = @Contact(
                        name = "Mohammed Ibrahim",
                        email = "ibmirnga234@gmail.com",
                        url = "https://github.com/IBmirnga/Banking-Application-.git"
                ),
                license = @License(
                        name = "The Bank App",
                        url = "https://github.com/IBmirnga/Banking-Application-.git"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "The Bank app Documentation",
                url = "https://github.com/IBmirnga/Banking-Application-.git"
        )
)
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
