package cl.dataservices.domainmongo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by cgonzalezr on 19-12-19.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String PACKAGE_CONTROLLER = "cl.dataservices.domainmongo.controller";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalResponseMessage(RequestMethod.POST, new ArrayList<>())
                .globalResponseMessage(RequestMethod.GET, new ArrayList<>())
                .globalResponseMessage(RequestMethod.DELETE, new ArrayList<>())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contacto = new Contact("RagnaxSistemas", "", "soporte@ragnaxsistemas.cl");
        return new ApiInfo("Microservices Rest domain-mongo", "MicroServicio que implementa " +
                "CRUD de MongoDB con spring boot",
                "1.0.0", "Ragnax Sistemas", contacto, "Apache",
                "http://www.ragnaxsistemas.cl.", new ArrayList<VendorExtension>());
    }


}