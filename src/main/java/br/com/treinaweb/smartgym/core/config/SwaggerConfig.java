package br.com.treinaweb.smartgym.core.config;

import com.fasterxml.classmate.TypeResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.treinaweb.smartgym.api.v1.common.dtos.ErrorResponse;
import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    private static final String CONTACT_NAME = "Smart Gym";
    private static final String CONTACT_URL = "https://www.smartgym.com.br/contato";
    private static final String CONTACT_EMAIL = "contato@smartgym.com.br";
    private static final String API_TITLE = "API Back-end Smart Gym";
    private static final String API_DESCRIPTION = "API para gerenciamento de treinos dos alunos da Smart Gym";
    private static final String API_VERSION = "1.0.0";
    private static final String BASE_PACKAGE = "br.com.treinaweb.smartgym.api.v1";

    private final TypeResolver typeResolver;

    public static final String TAG_CLIENT = "Clients";
    public static final String TAG_INSTRUCTOR = "Instructors";
    public static final String TAG_EXERCISE = "Exercises";
    public static final String TAG_AUTH = "Auth";
    public static final String TAG_WORKOUTSHEET = "Workout Sheets";
    public static final String TAG_WORKOUT = "Workouts";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .additionalModels(typeResolver.resolve(ErrorResponse.class))
            .useDefaultResponseMessages(false)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .tags(
                new Tag(TAG_CLIENT, "Client Controller"),
                new Tag(TAG_INSTRUCTOR, "Instructor Controller"),
                new Tag(TAG_EXERCISE, "Exercise Controller"),
                new Tag(TAG_AUTH, "Auth Controller"),
                new Tag(TAG_WORKOUTSHEET, "WorkoutSheet Controller"),
                new Tag(TAG_WORKOUT, "Workout Controller")
            )
            .apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
            .title(API_TITLE)
            .description(API_DESCRIPTION)
            .version(API_VERSION)
            .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL))
            .build();
    }

}
