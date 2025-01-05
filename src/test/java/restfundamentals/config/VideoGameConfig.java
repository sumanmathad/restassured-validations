package restfundamentals.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class VideoGameConfig {


    @BeforeAll
    public static void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://videogamedb.uk/")
                .setBasePath("api/v2/")
                .setContentType("application/json")
                .addHeader("Accept","application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }

}
